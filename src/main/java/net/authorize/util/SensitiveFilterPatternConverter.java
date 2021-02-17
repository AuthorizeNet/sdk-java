package net.authorize.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SensitiveFilterLayout extends PatternLayout{
	
	private static final String SENSITIVE_CONFIG_FILE_NAME = "/AuthorizedNetSensitiveTagsConfig.json";

    private static Pattern[] cardPatterns;
	
	private static Pattern[] tagPatterns;
	private static String[] tagReplacements;
	private static Gson gson;
	
	public SensitiveFilterLayout() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(SensitiveDataConfigType.class, new SensitiveTagsDeserializer());
			gson = gsonBuilder.create();
				
			InputStream in = getClass().getResourceAsStream(SENSITIVE_CONFIG_FILE_NAME);
			Closeable closeableResource = in;
            if (null != in) {
                try {
					InputStreamReader inputStreamReader = new InputStreamReader(in);
					closeableResource = inputStreamReader;
					BufferedReader reader = new BufferedReader(inputStreamReader);
					closeableResource = reader;
					SensitiveDataConfigType configType = gson.fromJson(reader, SensitiveDataConfigType.class);
					cardPatterns = new Pattern[configType.sensitiveStringRegexes.length];

				  for(int i = 0; i < configType.sensitiveStringRegexes.length; i++) {  
						  cardPatterns[i] = Pattern.compile(configType.sensitiveStringRegexes[i]);
					  }
					  
					int noOfSensitiveTags = configType.sensitiveTags.length;
					tagPatterns	 = new Pattern[noOfSensitiveTags];
					tagReplacements = new String[noOfSensitiveTags];
						  
					 for(int j=0; j<noOfSensitiveTags; j++) {
						  String tagName	 = configType.sensitiveTags[j].tagName;
						  String pattern	 = configType.sensitiveTags[j].pattern;
						  String replacement = configType.sensitiveTags[j].replacement;
						  
						  if(pattern != null && !pattern.isEmpty())
							  tagPatterns[j] = Pattern.compile("<"+tagName+">"+pattern+"</"+tagName+">");
						  else
							  tagPatterns[j] = Pattern.compile("<"+tagName+">"+".+"+"</"+tagName+">");
						  tagReplacements[j] = "<"+tagName+">"+replacement+"</"+tagName+">";
					  }
				} finally {
					closeableResource.close();
				}
			} else {
				// no logging system configured, so System.err is the only option...
				System.err.println("Resource "+ SENSITIVE_CONFIG_FILE_NAME + " not found when configuring SensitiveFilterLayout");
			}
		}
		catch(Exception e){
            // no logging system configured, so System.err is the only option...
            System.err.println("Something went wrong configuring the SensitiveFilterLayout");
            e.printStackTrace(System.err);
		}		
	}

	@Override
	public String format(LoggingEvent event) {
		try {
			if(event.getMessage() instanceof String) {
				String message = event.getRenderedMessage();
				String maskXmlMessage = SensitiveFilterLayout.maskSensitiveXmlString(message);
				String maskCardNumber = SensitiveFilterLayout.maskCreditCards(maskXmlMessage);
				
				Throwable throwable = event.getThrowableInformation() != null ? event.getThrowableInformation().getThrowable() : null;
				LoggingEvent maskedEvent = new LoggingEvent(event.fqnOfCategoryClass, Logger.getLogger(event.getLoggerName()), event.timeStamp, event.getLevel(), maskCardNumber, throwable);			
				return super.format(maskedEvent);
			}		
		}
		catch(Exception e){
		}		
		return null;
	}

	public static String maskCreditCards(String str) {
	    for (int i = 0; i < cardPatterns.length; i++) {
	        str = cardPatterns[i].matcher(str).replaceAll("XXXX");
	    }
	    return str;
	}
	
	public static String maskSensitiveXmlString(String str) {
	    for (int i = 0; i < tagPatterns.length; i++) {
	        str = tagPatterns[i].matcher(str).replaceAll(tagReplacements[i]);
	    }
	    return str;
	}	
}

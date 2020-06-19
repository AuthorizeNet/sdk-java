package net.authorize.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.ConverterKeys;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Plugin(name = "SensitiveFilterPatternConverter", category = "Converter")
@ConverterKeys({"maskedMessage"})
public class SensitiveFilterPatternConverter extends LogEventPatternConverter{
	private static Pattern[] cardPatterns;
	
	private static Pattern[] tagPatterns;
	private static String[] tagReplacements;
	private static Gson gson;
	
	private SensitiveFilterPatternConverter(final String name, final String style) {
		super(name, style);
		initialize();
	}
	
	public static SensitiveFilterPatternConverter newInstance(final String[] options) {
		return new SensitiveFilterPatternConverter("maskedMessage", "maskedMessage");
	}

	@Override
	public void format(LogEvent event, StringBuilder toAppendTo) {
		try {
				String message = event.getMessage().getFormattedMessage();
				String maskXmlMessage = SensitiveFilterPatternConverter.maskSensitiveXmlString(message);
				String maskCardNumber = SensitiveFilterPatternConverter.maskCreditCards(maskXmlMessage);
				
				toAppendTo.append(maskCardNumber.trim());
		}
		catch(Exception e){
		}
	}

	public void initialize() {
		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(SensitiveDataConfigType.class, new SensitiveTagsDeserializer());
			gson = gsonBuilder.create();
				
			InputStream in = getClass().getResourceAsStream("/AuthorizedNetSensitiveTagsConfig.json"); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				SensitiveDataConfigType configType = gson.fromJson(reader, SensitiveDataConfigType.class);
				cardPatterns = new Pattern[configType.sensitiveStringRegexes.length];

			  for(int i = 0; i < configType.sensitiveStringRegexes.length; i++) {  
					  cardPatterns[i] = Pattern.compile(configType.sensitiveStringRegexes[i]);
				  }
				  
				int noOfSensitiveTags = configType.sensitiveTags.length;
				tagPatterns     = new Pattern[noOfSensitiveTags];
				tagReplacements = new String[noOfSensitiveTags];
					  
				 for(int j=0; j<noOfSensitiveTags; j++) {
					  String tagName     = configType.sensitiveTags[j].tagName;
					  String pattern     = configType.sensitiveTags[j].pattern;
					  String replacement = configType.sensitiveTags[j].replacement;
					  
					  if(pattern != null && !pattern.isEmpty())
						  tagPatterns[j] = Pattern.compile("<"+tagName+">"+pattern+"</"+tagName+">");
					  else
						  tagPatterns[j] = Pattern.compile("<"+tagName+">"+".+"+"</"+tagName+">");
					  tagReplacements[j] = "<"+tagName+">"+replacement+"</"+tagName+">";
				  }
				 if(reader!=null)
					 reader.close();
		}
		catch(Exception e){
		}
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

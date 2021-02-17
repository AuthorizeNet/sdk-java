package net.authorize.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SensitiveFilterLogWrapper implements Log {

    private static final String SENSITIVE_CONFIG_FILE_NAME = "/AuthorizedNetSensitiveTagsConfig.json";

    private static Pattern[] cardPatterns;

    private static Pattern[] tagPatterns;
    private static String[] tagReplacements;
    private static Gson gson;
    private Log delegate;

    public SensitiveFilterLogWrapper(Log delegate) {
        this.delegate = delegate;

        parseConfiguration(delegate);
    }

    private void parseConfiguration(Log delegate) {
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

                    for (int i = 0; i < configType.sensitiveStringRegexes.length; i++) {
                        cardPatterns[i] = Pattern.compile(configType.sensitiveStringRegexes[i]);
                    }

                    int noOfSensitiveTags = configType.sensitiveTags.length;
                    tagPatterns = new Pattern[noOfSensitiveTags];
                    tagReplacements = new String[noOfSensitiveTags];

                    for (int j = 0; j < noOfSensitiveTags; j++) {
                        String tagName = configType.sensitiveTags[j].tagName;
                        String pattern = configType.sensitiveTags[j].pattern;
                        String replacement = configType.sensitiveTags[j].replacement;

                        if (pattern != null && !pattern.isEmpty())
                            tagPatterns[j] = Pattern.compile("<" + tagName + ">" + pattern + "</" + tagName + ">");
                        else
                            tagPatterns[j] = Pattern.compile("<" + tagName + ">" + ".+" + "</" + tagName + ">");
                        tagReplacements[j] = "<" + tagName + ">" + replacement + "</" + tagName + ">";
                    }
                } finally {
                    closeableResource.close();
                }
            } else {
                delegate.error("Resource " + SENSITIVE_CONFIG_FILE_NAME + " not found when configuring SensitiveFilterLogWrapper");
            }
        } catch (Exception e) {
            delegate.error("Something went wrong configuring the SensitiveFilterLogWrapper", e);
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

    public String filterSensitiveInformation(Object messageObject) {
        if (null == messageObject) {
            return null;
        }

        String message = messageObject.toString();
        try {
            String messageWithMaskedXml = SensitiveFilterLogWrapper.maskSensitiveXmlString(message);
            String messageWithMaskedCardNumber = SensitiveFilterLogWrapper.maskCreditCards(messageWithMaskedXml);
            return messageWithMaskedCardNumber;
        } catch (Exception e) {
            return "Error masking message: " + e.getMessage();
        }
    }

    public void debug(Object arg0, Throwable arg1) {
        delegate.debug(filterSensitiveInformation(arg0), arg1);
    }

    public void debug(Object arg0) {
        delegate.debug(filterSensitiveInformation(arg0));
    }

    public void error(Object arg0, Throwable arg1) {
        delegate.error(filterSensitiveInformation(arg0), arg1);
    }

    public void error(Object arg0) {
        delegate.error(filterSensitiveInformation(arg0));
    }

    public void fatal(Object arg0, Throwable arg1) {
        delegate.fatal(filterSensitiveInformation(arg0), arg1);
    }

    public void fatal(Object arg0) {
        delegate.fatal(filterSensitiveInformation(arg0));
    }

    public void info(Object arg0, Throwable arg1) {
        delegate.info(filterSensitiveInformation(arg0), arg1);
    }

    public void info(Object arg0) {
        delegate.info(filterSensitiveInformation(arg0));
    }

    public boolean isDebugEnabled() {
        return delegate.isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return delegate.isErrorEnabled();
    }

    public boolean isFatalEnabled() {
        return delegate.isFatalEnabled();
    }

    public boolean isInfoEnabled() {
        return delegate.isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return delegate.isTraceEnabled();
    }

    public boolean isWarnEnabled() {
        return delegate.isWarnEnabled();
    }

    public void trace(Object arg0, Throwable arg1) {
        delegate.trace(filterSensitiveInformation(arg0), arg1);
    }

    public void trace(Object arg0) {
        delegate.trace(filterSensitiveInformation(arg0));
    }

    public void warn(Object arg0, Throwable arg1) {
        delegate.warn(filterSensitiveInformation(arg0), arg1);
    }

    public void warn(Object arg0) {
        delegate.warn(filterSensitiveInformation(arg0));
    }
}

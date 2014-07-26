package net.authorize.util;

import org.apache.commons.logging.Log;

public final class LogHelper {

	public static String LineSeparator = System.getProperty("line.separator");
	
	private LogHelper() {
	}

	public static void debug(Log logger, String format, Object... arguments) {
		String logMessage = getMessage(logger, format, arguments);
		if ( null != logMessage) { logger.debug(logMessage); }
	}

	public static void error(Log logger, String format, Object... arguments) {
		String logMessage = getMessage(logger, format, arguments);
		if ( null != logMessage) { logger.error(logMessage); }
	}
	
	public static void info(Log logger, String format, Object... arguments) {
		String logMessage = getMessage(logger, format, arguments);
		if ( null != logMessage) { logger.info(logMessage); }
	}

	public static void warn(Log logger, String format, Object... arguments) {
		String logMessage = getMessage(logger, format, arguments);
		if ( null != logMessage) { logger.warn(logMessage); }
	}

	private static String getMessage(Log logger, String format, Object... arguments) {
		String logMessage = null;
		
		if ( null != logger && null != format && 0 < format.trim().length()) {
			logMessage = String.format(format, arguments);
			//do encoding etc here or output neutralization as necessary 
		}
		return logMessage;
	}
}

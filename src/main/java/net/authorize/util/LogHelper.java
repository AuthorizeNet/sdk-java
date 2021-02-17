package net.authorize.util;

import org.apache.logging.log4j.Logger;

public final class LogHelper {

	public static String LineSeparator = System.getProperty("line.separator");
	
	private LogHelper() {
	}

	public static void debug(Logger logger, String format, Object... arguments) {
		String logMessage = getMessage(logger, format, arguments);
		if ( null != logMessage) { logger.debug(logMessage); }
	}

	public static void error(Logger logger, String format, Object... arguments) {
		String logMessage = getMessage(logger, format, arguments);
		if ( null != logMessage) { logger.error(logMessage); }
	}
	
	public static void info(Logger logger, String format, Object... arguments) {
		String logMessage = getMessage(logger, format, arguments);
		if ( null != logMessage) { logger.info(logMessage); }
	}

	public static void warn(Logger logger, String format, Object... arguments) {
		String logMessage = getMessage(logger, format, arguments);
		if ( null != logMessage) { logger.warn(logMessage); }
	}

	private static String getMessage(Logger logger, String format, Object... arguments) {
		String logMessage = null;
		
		if ( null != logger && null != format && 0 < format.trim().length()) {
			logMessage = String.format(format, arguments);
			//do encoding etc here or output neutralization as necessary 
		}
		return logMessage;
	}
}

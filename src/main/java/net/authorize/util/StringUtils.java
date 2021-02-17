package net.authorize.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringUtils {

	private static Logger logger = LogManager.getLogger(StringUtils.class);

	public static int parseInt(String intStringValue) {
		int amount = 0;
		
		if ( null != intStringValue && 0 < intStringValue.trim().length())
		try {
			amount = Integer.parseInt(intStringValue.trim());
		} catch (NumberFormatException nfe) {
			LogHelper.warn(logger, "Error parsing to int value: '%s'", intStringValue);
		}
		
		return amount;
	}
}

package net.authorize.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtils {

	private static Log logger = LogFactory.getLog(StringUtils.class);

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

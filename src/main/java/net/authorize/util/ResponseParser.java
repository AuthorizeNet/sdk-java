package net.authorize.util;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import net.authorize.ResponseField;
import net.authorize.aim.Transaction;

/**
 * Parses a response string from Authorize.net into a Map of values.
 * 
 * @deprecated since version 1.9.8
 * @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
 * @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API (package: net.authorize.api.*).
 * @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
 * @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/PaymentTransactions.
 * @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
 *
 */
@Deprecated
public class ResponseParser {

	/**
	 * Take a string and parses it into a Map keyed on ResponseFields.
	 *
	 * @param responseString
	 * @return dictionary of response values.
	 */
	public static Map<ResponseField, String> parseResponseString(String responseString) {
		return parseResponseString(responseString, Transaction.TRANSACTION_FIELD_DELIMITER);
	}

	/**
	 * Take a string and parses it into a Map keyed on ResponseFields.
	 *
	 * @param responseString
	 * @param delimiter
	 * @return dictionary of response values.
	 */
	public static Map<ResponseField, String> parseResponseString(String responseString, String delimiter) {

		Map<ResponseField, String> responseMap = new HashMap<ResponseField, String>();

		StringTokenizer st = new StringTokenizer(responseString, delimiter, true);

		int order = 0;
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			ResponseField responseField = ResponseField.get(++order);
			if(responseField != null) {
				if(delimiter.equals(token)) {
					responseMap.put(responseField, "");
				} else {
					responseMap.put(responseField, token.replaceAll(delimiter, ""));
					if (st.hasMoreTokens()) {
						st.nextToken(); // skip delimiter
					}
				}
			}
		}

		return responseMap;
	}

}

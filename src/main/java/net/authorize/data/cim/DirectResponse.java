package net.authorize.data.cim;

import java.util.Map;

import net.authorize.ResponseField;
import net.authorize.util.ResponseParser;

/**
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
public class DirectResponse {
	public static final String RESPONSE_DELIMITER = ",";
	private String directResponseString;
	private Map<ResponseField, String> directResponseMap;

	private DirectResponse(String directResponseString) {
		this.directResponseString = directResponseString;

		this.directResponseMap = ResponseParser.parseResponseString(
				directResponseString,RESPONSE_DELIMITER);
	}

	/**
	 * Create a validation direct response from a passed in string.
	 *
	 * @param directResponseString
	 *
	 * @return DirectResponse object
	 */
	public static DirectResponse createDirectResponse(
			String directResponseString) {
		return new DirectResponse(directResponseString);
	}

	/**
	 * @return the directResponseString
	 */
	public String getDirectResponseString() {
		return directResponseString;
	}
	/**
	 * @return the directResponseMap
	 */
	public Map<ResponseField, String> getDirectResponseMap() {
		return directResponseMap;
	}
}

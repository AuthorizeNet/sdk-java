package net.authorize.data.xml.reporting;

/**
 * Card code type.
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
public enum CardCodeResponseType {
	M("M", "Match"),
	N("N", "No Match"),
	P("P", "Not Processed"),
	S("S", "Should have been present"),
	U("U", "Issuer unable to process request");

	private final String value;
	private final String description;

	private CardCodeResponseType(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public static CardCodeResponseType findByValue(String value) {
		if(value != null) {
			for(CardCodeResponseType responseType : values()) {
				if(responseType.value.equals(value)) {
					return responseType;
				}
			}
		}

		return null;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}

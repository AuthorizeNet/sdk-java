package net.authorize.data.xml.reporting;

/**
 * Cardholder Authentication Verification type.
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
public enum CAVVResponseType {
	NOT_VALIDATED("", "CAVV	not validated"),
	CAVV_0("0", "CAVV not validated	because erroneous data was submitted"),
	CAVV_1("1", "CAVV failed validation"),
	CAVV_2("2", "CAVV passed validation"),
	CAVV_3("3", "CAVV validation could not be performed; issuer attempt incomplete"),
	CAVV_4("4", "CAVV validation could not be performed; issuer system error"),
	CAVV_5("5", "Reserved for future use"),
	CAVV_6("6", "Reserved for future use"),
	CAVV_7("7", "CAVV attempt - failed validation - issuer available (U.S.-issued card/non-U.S. acquirer)"),
	CAVV_8("8", "CAVV attempt - passed validation - issuer available (U.S.-issued card/non-U.S. acquirer)"),
	CAVV_9("9", "CAVV attempt - failed validation - issuer unavailable (U.S.-issued card/non-U.S. acquirer)"),
	CAVV_A("A", "CAVV attempt - passed validation - issuer unavailable (U.S.-issued card/non-U.S. acquirer)"),
	CAVV_B("B", "CAVV passed validation, information only, no liability	shift");

	private final String value;
	private final String description;

	private CAVVResponseType(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public static CAVVResponseType findByValue(String value) {
		if(value != null) {
			for(CAVVResponseType responseType : values()) {
				if(responseType.value.equals(value)) {
					return responseType;
				}
			}
		}

		return CAVVResponseType.NOT_VALIDATED;
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

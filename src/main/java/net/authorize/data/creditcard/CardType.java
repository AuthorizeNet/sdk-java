package net.authorize.data.creditcard;

import java.io.Serializable;

/**
 * Supported payment card types.
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
public enum CardType implements Serializable {
	VISA("Visa"),
	MASTER_CARD("MasterCard"),
	AMERICAN_EXPRESS("AmericanExpress"),
	DISCOVER("Discover"),
	DINERS_CLUB("DinersClub"),
	JCB("JCB"),
	ECHECK("eCheck"),	// added for the reporting API
	UNKNOWN("");

	private final String value;

	private CardType(String value) {
		this.value = value;
	}

	public static CardType findByValue(String value) {
		if(value != null) {
			for(CardType cardType : values()) {
				if(cardType.value.equals(value)) {
					return cardType;
				}
			}
		}

		return CardType.UNKNOWN;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}

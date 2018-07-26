package net.authorize;

/**
 * The credit card transaction types supported by the payment gateway.
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
public enum TransactionType {
	AUTH_CAPTURE("AUTH_CAPTURE", "profileTransAuthCapture"),
	AUTH_ONLY("AUTH_ONLY", "profileTransAuthOnly"),
	PRIOR_AUTH_CAPTURE("PRIOR_AUTH_CAPTURE", "profileTransPriorAuthCapture"),
	CAPTURE_ONLY("CAPTURE_ONLY", "profileTransCaptureOnly"),
	CREDIT("CREDIT", "profileTransRefund"),
	UNLINKED_CREDIT("CREDIT", "profileTransRefund"),
	VOID("VOID", "profileTransVoid");

	final private String value;
	final private String cimValue;

	private TransactionType(String value, String cimValue) {
		this.value = value;
		this.cimValue = cimValue;
	}

	/**
	 * Return the value needed for SIM/AIM integrations.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Return the value needed for CIM integrations.
	 *
	 * @return cim transaction type value.
	 */
	public String getCIMValue() {
		return cimValue;
	}

}

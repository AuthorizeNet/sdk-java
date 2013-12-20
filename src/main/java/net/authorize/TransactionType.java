package net.authorize;

/**
 * The credit card transaction types supported by the payment gateway.
 *
 */
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

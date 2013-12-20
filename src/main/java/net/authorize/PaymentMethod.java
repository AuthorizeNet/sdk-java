package net.authorize;

/**
 * The method of payment for the transaction.
 * CC (credit card) or ECHECK (electronic check).
 */
public enum PaymentMethod {
	CREDIT_CARD("CC"),
	E_CHECK("ECHECK"),
	UNKNOWN("UNKNOWN");

	private final String method;

	private PaymentMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}


}

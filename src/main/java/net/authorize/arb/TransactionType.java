package net.authorize.arb;

public enum TransactionType {

	CREATE_SUBSCRIPTION("ARBCreateSubscriptionRequest"),
	UPDATE_SUBSCRIPTION("ARBUpdateSubscriptionRequest"),
	CANCEL_SUBSCRIPTION("ARBCancelSubscriptionRequest"),
	GET_SUBSCRIPTION_STATUS("ARBGetSubscriptionStatusRequest");

	final private String value;

	private TransactionType(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}

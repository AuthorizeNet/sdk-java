package net.authorize;

/**
 * MarketType is used for Card Present transactions.
 */
public enum MarketType {
	RETAIL("2");

	final private String value;

	private MarketType(String value) {
		this.value = value;
	}

	/**
	 * Return the MarketType value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}

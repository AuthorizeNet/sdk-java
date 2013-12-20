package net.authorize;

/**
 * DeviceType is used for Card Present transactions.
 *
 */
public enum DeviceType {

	UNKNOWN("1"),
	UNATTENDED("2"),
	SELF_SERVICE_TERMINAL("3"),
	ELECTRONIC_CASH_REGISTER("4"),
	PERSONAL_COMPUTER_BASED_TERMINAL("5"),
	AIRPAY("6"),
	WIRELESS_POS("7"),
	WEBSITE("8"),
	DIAL_TERMINAL("9"),
	VIRTUAL_TERMINAL("10");

	final private String value;

	private DeviceType(String value) {
		this.value = value;
	}

	/**
	 * Return the DeviceType value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}


}

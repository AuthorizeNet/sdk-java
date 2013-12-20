package net.authorize.cim;

public enum ValidationModeType {
	NONE("none"),
	TEST_MODE("testMode"),
	LIVE_MODE("liveMode");

	final private String value;

	private ValidationModeType(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}

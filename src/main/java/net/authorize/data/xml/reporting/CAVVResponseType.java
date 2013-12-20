package net.authorize.data.xml.reporting;

/**
 * Cardholder Authentication Verification type.
 */
public enum CAVVResponseType {
	NOT_VALIDATED("", "CAVV	not validated"),
	CAVV_0("0", "CAVV not validated	because erroneous data was submitted"),
	CAVV_1("1", "CAVV failed validation"),
	CAVV_2("2", "CAVV passed validation"),
	CAVV_3("3", "CAVV validation could not be performed; issuer attempt incomplete"),
	CAVV_4("4", "CAVV validation could not be performed; issuer system error"),
	CAVV_5("5", "Reserved for future use"),
	CAVV_6("6", "Reserved for future use"),
	CAVV_7("7", "CAVV attempt Ñ failed validation Ñ issuer available (U.S.-issued card/non-U.S. acquirer)"),
	CAVV_8("8", "CAVV attempt Ñ passed validation Ñ issuer available (U.S.-issued card/non-U.S. acquirer)"),
	CAVV_9("9", "CAVV attempt Ñ failed validation Ñ issuer unavailable (U.S.-issued card/non-U.S. acquirer)"),
	CAVV_A("A", "CAVV attempt Ñ passed validation Ñ issuer unavailable (U.S.-issued card/non-U.S. acquirer)"),
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

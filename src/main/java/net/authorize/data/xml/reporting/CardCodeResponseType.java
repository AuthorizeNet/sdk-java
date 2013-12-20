package net.authorize.data.xml.reporting;

/**
 * Card code type.
 */
public enum CardCodeResponseType {
	M("M", "Match"),
	N("N", "No Match"),
	P("P", "Not Processed"),
	S("S", "Should have been present"),
	U("U", "Issuer unable to process request");

	private final String value;
	private final String description;

	private CardCodeResponseType(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public static CardCodeResponseType findByValue(String value) {
		if(value != null) {
			for(CardCodeResponseType responseType : values()) {
				if(responseType.value.equals(value)) {
					return responseType;
				}
			}
		}

		return null;
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

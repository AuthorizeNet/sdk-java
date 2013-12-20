package net.authorize.data.creditcard;

import java.io.Serializable;

/**
 * Address Verification Service (AVS) response codes.
 *
 */
public enum AVSCode implements Serializable {
	A("A", "Address (Street) matches, ZIP does not"),
	B("B", "Address information not provided for AVS check"),
	E("E", "AVS error"),
	G("G", "Non-U.S. Card Issuing Bank"),
	N("N", "No Match on Address (Street) or ZIP"),
	P("P", "AVS not applicable for this transaction"),
	R("R", "Retry - System unavailable or timed out"),
	S("S", "Service not supported by issuer"),
	U("U", "Address information is unavailable"),
	W("W", "Nine digit ZIP matches, Address (Street) does not"),
	X("X", "Address (Street) and nine digit ZIP match"),
	Y("Y", "Address (Street) and five digit ZIP match"),
	Z("Z", "Five digit ZIP matches, Address (Street) does not");

	private final String value;
  	private final String description;

	private AVSCode(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public static AVSCode findByValue(String value) {
		for(AVSCode avs : values()) {
			if(avs.value.equals(value)) {
				return avs;
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

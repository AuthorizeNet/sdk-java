package net.authorize.data.cim;

import java.util.Map;

import net.authorize.ResponseField;
import net.authorize.util.ResponseParser;

public class DirectResponse {
	public static final String RESPONSE_DELIMITER = ",";
	private String directResponseString;
	private Map<ResponseField, String> directResponseMap;

	private DirectResponse(String directResponseString) {
		this.directResponseString = directResponseString;

		this.directResponseMap = ResponseParser.parseResponseString(
				directResponseString,RESPONSE_DELIMITER);
	}

	/**
	 * Create a validation direct response from a passed in string.
	 *
	 * @param directResponseString
	 *
	 * @return DirectResponse object
	 */
	public static DirectResponse createDirectResponse(
			String directResponseString) {
		return new DirectResponse(directResponseString);
	}

	/**
	 * @return the directResponseString
	 */
	public String getDirectResponseString() {
		return directResponseString;
	}
	/**
	 * @return the directResponseMap
	 */
	public Map<ResponseField, String> getDirectResponseMap() {
		return directResponseMap;
	}
}

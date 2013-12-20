package net.authorize;

import net.authorize.util.StringUtils;

/**
 * Response code indicates the overall status of the transaction
 * with possible values of approved, declined, error, or held for review.
 *
 */
public enum ResponseCode {
	APPROVED(1, "This transaction has been approved."),
	DECLINED(2, "This transaction has been declined"),
	ERROR(3, "There has been an error processing this transaction."),
	REVIEW(4, "This transaction is being held for review."),
	UNKNOWN(0, "Unknown.");

	private final int code;
	private final String description;

	private ResponseCode(int code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * Lookup a ResponseCode by it's response code.
	 * @param code
	 *
	 * @return Returns a ResponseCode if a code match is found.
	 */
	public static ResponseCode findByResponseCode(int code) {
		for(ResponseCode responseCode : values()) {
			if(responseCode.code == code) {
				return responseCode;
			}
		}

		return ResponseCode.UNKNOWN;
	}

	/**
	 * Lookup a ResponseCode by it's response code.
	 * @param code
	 *
	 * @return Returns a ResponseCode if a code match is found.
	 */
	public static ResponseCode findByResponseCode(String code) {
		if(StringUtils.isNotEmpty(code)) {
			return findByResponseCode(Integer.parseInt(code));
		}

		return ResponseCode.UNKNOWN;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}

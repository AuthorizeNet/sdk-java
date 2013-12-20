package net.authorize;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final int MAX_AUTH_CODE_LENGTH = 6;
	public static final String VERSION = "3.1";
	public static String TRANSACTION_FIELD_DELIMITER = "|";
	public static String ENCAP_CHAR_DELIMITER = "";
	public static final String BRACKET_PIPE_DELIMITER = "<|>";
	public static final String TRUE = "TRUE";
	public static final String FALSE = "FALSE";
	public static final String ZERO_STRING = "0.00";
	public static final BigDecimal ZERO_AMOUNT = new BigDecimal(0.00);
	public static final String EMPTY_STRING = "";
	public static final int CURRENCY_DECIMAL_PLACES = 2;
	public static final int QUANTITY_DECIMAL_PLACES = 4;

	/**
	 * Convenience method for overriding the transaction field delimited.
	 *
	 * Character that will be used to separate fields in the transaction response.
	 * The system will use the character passed in this field or the value stored
	 * in the Merchant Interface if no value is passed.
	 *
	 * @param transactionFieldDelimiter
	 */
	public static void setTransactionFieldDelimiter(String transactionFieldDelimiter) {
		Transaction.TRANSACTION_FIELD_DELIMITER = transactionFieldDelimiter;
	}

	/**
	 * Convenience method for overriding the encap char delimiter.
	 *
	 * Character that will be used to encapsulate the fields in the transaction response.
	 * The system will use the character passed in this field or the value stored in
	 * the Merchant Interface if no value is passed.
	 */
	public static void setEncapCharDelimiter(String encapCharDelimiter) {
		Transaction.ENCAP_CHAR_DELIMITER = encapCharDelimiter;
	}

	public String toNVPString() { return ""; }

	public String toXMLString() { return ""; }
}

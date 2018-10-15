package net.authorize;

import java.io.Serializable;
import java.math.BigDecimal;

import net.authorize.util.XmlUtility;

import org.w3c.dom.Node;

/**
 * 
 * @deprecated since version 1.9.8
 * @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
 * @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API (package: net.authorize.api.*).
 * @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
 * @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/PaymentTransactions.
 * @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
 */
@Deprecated
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

	public String toNVPString() { return ""; }

	public String toXMLString() { return ""; }

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

	/**
	 * Try to encode string value as per proper xml requirements
	 * Will  default to original value (without encoding) if there are any exceptions
	 * @param document the document to create text node to
	 * @param value string value to encode
	 * @return Node with encoded text value appropriate for XML
	 */
	public static Node getEncodedString(net.authorize.util.BasicXmlDocument document, String value) {
		String encodedValue = XmlUtility.escapeStringForXml(value);
		Node node = document.getDocument().createTextNode(encodedValue);
		
		return node;
	}

	/**
	 * Try to decode string value from xml node as per proper xml requirements
	 * @param node which is a text element 
	 * @return decoded String value
	 */
	public static String getDecodedString(Node node) {
		String value = node.getTextContent();
		String decodedValue = XmlUtility.descapeStringForXml(value);
		
		return decodedValue;
	}
}

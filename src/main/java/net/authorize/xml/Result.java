package net.authorize.xml;

import java.util.ArrayList;

import net.authorize.arb.Transaction;
import net.authorize.util.BasicXmlDocument;

import org.w3c.dom.Element;

/**
 * Templated wrapper container for passing back the result from the request gateway.
 *
 */
public class Result<T> extends net.authorize.Result<T> {

	private static final long serialVersionUID = 1L;

	public static final String OK = "Ok";
	public static final String ERROR = "Error";

	protected String resultCode = null;
	protected ArrayList<Message> messages = new ArrayList<Message>();

	protected Result() { }

	@SuppressWarnings("unchecked")
	public static <T> Result<T> createResult(T object, BasicXmlDocument response) {
		Result<T> result = new Result<T>();

		if(object instanceof Transaction) {
			Transaction targetTransaction = Transaction.createTransaction((Transaction) object, response);
			result.importResponseMessages(targetTransaction);
			result.target = (T)targetTransaction;
		}

		return result;
	}

	/**
	 * Returns the result code.
	 *
	 * @return String containing the result code.
	 */
	public String getResultCode(){
		return resultCode;
	}

	/**
	 * @return the messages
	 */
	public ArrayList<Message> getMessages() {
		return messages;
	}

	/**
	 * Local wrapper for getting element text from a parent.
	 *
	 * @param parent_el
	 * @param element_name
	 * @return element text
	 */
	protected static String getElementText(Element parent_el, String element_name) {
		return BasicXmlDocument.getElementText(parent_el, element_name);
	}

	/**
	 * Import the response messages into the result.
	 *
	 * @param txn transaction containing the response messages.
	 */
	protected void importResponseMessages(Transaction txn) {};

	public void printMessages() { }

	/**
	 * Returns true if the response is Ok.
	 *
	 * @return boolean
	 */
	public boolean isOk() {
		return OK.equals(this.resultCode);
	}

	/**
	 * Returns true if the response is Error.
	 * @return boolean
	 */
	public boolean isError() {
		return ERROR.equals(this.resultCode);
	}

}

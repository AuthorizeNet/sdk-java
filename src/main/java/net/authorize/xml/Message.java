package net.authorize.xml;

/**
 * Contains information about the results of the request.
 */
public class Message{

	private String result_code;
	private String code;
	private String text;

	private Message() {

	}

	public static Message createMessage() {
		return new Message();
	}

	/**
	 * Message code (ie. I00001)
	 *
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Set the message code.
	 *
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Message result code.  Contains additional information about the results
	 * of the request.  An 'Ok' result code indicates that the request was
	 * processed and accepted without error.
	 *
	 * @return String
	 */
	public String getResultCode() {
		return result_code;
	}

	/**
	 * Set the result code.
	 *
	 * @param result_code
	 */
	public void setResultCode(String result_code) {
		this.result_code = result_code;
	}

	/**
	 * Text description of the status.
	 *
	 * @return String
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text description.
	 *
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

}

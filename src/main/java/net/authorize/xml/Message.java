package net.authorize.xml;

/**
 * Contains information about the results of the request.
 * 
 * @deprecated since version 1.9.8
 * @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
 * @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API.
 * @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
 * @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-php/tree/master/PaymentTransactions.
 * @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
 *
 */
@Deprecated
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

package net.authorize.aim.cardpresent;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import net.authorize.AuthNetField;
import net.authorize.ResponseCode;
import net.authorize.ResponseReasonCode;
import net.authorize.aim.Transaction;
import net.authorize.data.creditcard.AVSCode;
import net.authorize.data.creditcard.CardType;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.xml.reporting.CardCodeResponseType;
import net.authorize.util.BasicXmlDocument;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Templated wrapper container for passing back the result from the request gateway.
 *
 */
public class Result<T> extends net.authorize.Result<T> {

	private static final long serialVersionUID = 1L;

	protected ResponseCode responseCode = null;
	protected ArrayList<ResponseReasonCode> responseReasonCodes = new ArrayList<ResponseReasonCode>();

	private String authCode;
	private AVSCode avsResultCode;
	private CardCodeResponseType cardCodeResponse;
	private String transId;
	private String refTransId;
	private String transHash;
	private boolean testMode;
	private String userRef;
	protected BasicXmlDocument xmlResponseDocument;

	protected Result() { }

	@SuppressWarnings("unchecked")
	public static <T> Result<T> createResult(T object, BasicXmlDocument response) {
		Result<T> result = new Result<T>();

		if(object instanceof Transaction) {
			Transaction targetTransaction = Transaction.createTransaction((Transaction) object, response);

			result.importResponseCode(targetTransaction);
			result.importResponseReasonCodes(targetTransaction);
			result.importAuthCode(targetTransaction);
			result.importAVSResultCode(targetTransaction);
			result.importCardCode(targetTransaction);
			result.importTransID(targetTransaction);
			result.importRefTransID(targetTransaction);
			result.importTransHash(targetTransaction);
			result.importTestMode(targetTransaction);
			result.importUserRef(targetTransaction);

			// update target credit card information
			CreditCard creditCard = targetTransaction.getCreditCard();
			if(creditCard != null) {
				// masked credit card
				creditCard.setMaskedCreditCardNumber(result.getAccountNumber(targetTransaction));
				// credit card type
				creditCard.setCardType(
						CardType.findByValue(
								result.getAccountType(targetTransaction)));
				// AVS response
				creditCard.setAvsCode(result.avsResultCode);
				targetTransaction.setCreditCard(creditCard);
			}

			result.target = (T)targetTransaction;
		}

		return result;
	}

	/**
	 * @return the responseCode
	 */
	public ResponseCode getResponseCode() {
		return responseCode;
	}

	/**
	 * @return the responseReasonCodes
	 */
	public ArrayList<ResponseReasonCode> getResponseReasonCodes() {
		return responseReasonCodes;
	}

	/**
	 * @return the authCode
	 */
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * @return the avsResultCode
	 */
	public AVSCode getAvsResultCode() {
		return avsResultCode;
	}

	/**
	 * @return the cardCodeReponse
	 */
	public CardCodeResponseType getCardCodeResponse() {
		return cardCodeResponse;
	}

	/**
	 * @return the transId
	 */
	public String getTransId() {
		return transId;
	}

	/**
	 * @return the refTransId
	 */
	public String getRefTransId() {
		return refTransId;
	}

	/**
	 * @return the transHash
	 */
	public String getTransHash() {
		return transHash;
	}

	/**
	 * @return the testMode
	 */
	public boolean isTestMode() {
		return testMode;
	}

	/**
	 * @return the userRef
	 */
	public String getUserRef() {
		return userRef;
	}

	public boolean isApproved() {
		return ResponseCode.APPROVED.equals(this.responseCode);
	}

	public boolean isDeclined() {
		return ResponseCode.DECLINED.equals(this.responseCode);
	}

	public boolean isError() {
		return ResponseCode.ERROR.equals(this.responseCode);
	}

	private void importResponseCode(Transaction txn) {
		this.responseCode = ResponseCode.findByResponseCode(
				BasicXmlDocument.getElementText(
						txn.getCurrentResponse().getDocument().getDocumentElement(),
						AuthNetField.ELEMENT__RESPONSE_CODE.getFieldName()));
	}

	/**
	 * Import errors.
	 *
	 * @param txn Transaction
	 */
	private void importErrors(Transaction txn) {
		NodeList errors_list = txn.getCurrentResponse().getDocument().getElementsByTagName(AuthNetField.ELEMENT__ERROR.getFieldName());
		for(int i = 0; i < errors_list.getLength(); i++){
			Element error_el = (Element)errors_list.item(i);
			ResponseReasonCode responseReasonCode = ResponseReasonCode.findByReasonCode(
					BasicXmlDocument.getElementText(error_el,AuthNetField.ELEMENT__ERROR_CODE.getFieldName()));
			responseReasonCode.setReasonText(BasicXmlDocument.getElementText(error_el,AuthNetField.ELEMENT__ERROR_TEXT.getFieldName()));

			this.responseReasonCodes.add(responseReasonCode);
		}
	}

	/**
	 * Import messages.
	 *
	 * @param txn Transaction
	 */
	private void importMessages(Transaction txn) {
		NodeList message_list = txn.getCurrentResponse().getDocument().getElementsByTagName(AuthNetField.ELEMENT__MESSAGE.getFieldName());
		for(int i = 0; i < message_list.getLength(); i++){
			Element message_el = (Element)message_list.item(i);
			ResponseReasonCode responseReasonCode = ResponseReasonCode.findByReasonCode(
					BasicXmlDocument.getElementText(message_el,AuthNetField.ELEMENT__CODE.getFieldName()));
			responseReasonCode.setReasonText(BasicXmlDocument.getElementText(message_el,AuthNetField.ELEMENT__DESCRIPTION.getFieldName()));

			this.responseReasonCodes.add(responseReasonCode);
		}
	}

	/**
	 * Import the response messages into the result.
	 *
	 * @param txn Transaction
	 *
	 */
	private void importResponseReasonCodes(Transaction txn) {

		// approval
		// decline
		// error
		switch (this.responseCode) {
		case APPROVED:
			importMessages(txn);
			break;
		case DECLINED:
			importErrors(txn);
			break;
		case ERROR:
			importErrors(txn);
			break;
		default:
			break;
		}
	}

	/**
	 * Import the AuthCode.
	 *
	 * @param txn
	 */
	private void importAuthCode(Transaction txn) {
		this.authCode = BasicXmlDocument.getElementText(
				txn.getCurrentResponse().getDocumentElement(),
				AuthNetField.ELEMENT__AUTH_CODE.getFieldName());
	}

	/**
	 * Import the AVS result code.
	 *
	 * @param txn
	 */
	private void importAVSResultCode(Transaction txn) {
		this.avsResultCode = AVSCode.findByValue(BasicXmlDocument.getElementText(
				txn.getCurrentResponse().getDocumentElement(),
				AuthNetField.ELEMENT__AVS_RESULT_CODE.getFieldName()));
	}

	/**
	 * Import the card code result code.
	 *
	 * @param txn
	 */
	private void importCardCode(Transaction txn) {
		this.cardCodeResponse = CardCodeResponseType.findByValue(BasicXmlDocument.getElementText(
				txn.getCurrentResponse().getDocumentElement(),
				AuthNetField.ELEMENT__CVV_RESULT_CODE.getFieldName()));
	}

	/**
	 * Import the TransID.
	 *
	 * @param txn
	 */
	private void importTransID(Transaction txn) {
		this.transId = BasicXmlDocument.getElementText(
				txn.getCurrentResponse().getDocumentElement(),
				AuthNetField.ELEMENT__TRANS_ID.getFieldName());
	}

	/**
	 * Import the TransID.
	 *
	 * @param txn
	 */
	private void importRefTransID(Transaction txn) {
		this.refTransId = BasicXmlDocument.getElementText(
				txn.getCurrentResponse().getDocumentElement(),
				AuthNetField.ELEMENT__REF_TRANS_ID.getFieldName());
	}

	/**
	 * Import the TransHash.
	 *
	 * @param txn
	 */
	private void importTransHash(Transaction txn) {
		this.transHash = BasicXmlDocument.getElementText(
				txn.getCurrentResponse().getDocumentElement(),
				AuthNetField.ELEMENT__TRANS_HASH.getFieldName());
	}

	/**
	 * Import the TestMode.
	 *
	 * @param txn
	 */
	private void importTestMode(Transaction txn) {
		String _testMode = BasicXmlDocument.getElementText(
				txn.getCurrentResponse().getDocumentElement(),
				AuthNetField.ELEMENT__TEST_MODE.getFieldName());

		this.testMode = "1".equals(_testMode)?true:false;
	}


	/**
	 * Import the UserRef.
	 *
	 * @param txn
	 */
	private void importUserRef(Transaction txn) {
		this.userRef = BasicXmlDocument.getElementText(
				txn.getCurrentResponse().getDocumentElement(),
				AuthNetField.ELEMENT__USER_REF.getFieldName());
	}

	/**
	 * Get the (masked) AccountNumber.
	 *
	 * @param txn
	 */
	private String getAccountNumber(Transaction txn) {
		return BasicXmlDocument.getElementText(
				txn.getCurrentResponse().getDocumentElement(),
				AuthNetField.ELEMENT__ACCOUNT_NUMBER.getFieldName());
	}

	/**
	 * Get the (masked) AccountNumber.
	 *
	 * @param txn
	 */
	private String getAccountType(Transaction txn) {
		return BasicXmlDocument.getElementText(
				txn.getCurrentResponse().getDocumentElement(),
				AuthNetField.ELEMENT__ACCOUNT_TYPE.getFieldName());
	}

	/**
 	 * Return the response as a raw xml document.
 	 *
	 * @return the xmlResponseDocument
	 */
	public BasicXmlDocument getXmlResponseDocument() {
		return xmlResponseDocument;
	}

   /**
    * Verify that the relay response post is actually coming from
    * AuthorizeNet.
    *
    * @return boolean true if the txn came from Authorize.Net
    */
	public boolean isAuthorizeNet() {

	    String amount = ((Transaction)this.target).getRequestMap().get(AuthNetField.X_AMOUNT.getFieldName());
        String MD5Value = ((Transaction)this.target).getMD5Value();
        String apiLoginId = ((Transaction)this.target).getRequestMap().get(AuthNetField.X_LOGIN.getFieldName());
        String md5Check = null;

	    try {
		    MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
		    String s = MD5Value + apiLoginId + getTransId() + amount;
		    digest.update(s.getBytes());
		    md5Check = new BigInteger(1,digest.digest()).toString(16).toUpperCase();
		    while(md5Check.length() < 32) {
		    	md5Check = "0" + md5Check;
		    }
	    } catch (NoSuchAlgorithmException nsae) {
	    	//
	    }

	    return md5Check != null && md5Check.equalsIgnoreCase(getTransHash());
	}

}

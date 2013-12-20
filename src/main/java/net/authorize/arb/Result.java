package net.authorize.arb;

import net.authorize.AuthNetField;
import net.authorize.data.arb.SubscriptionStatusType;
import net.authorize.util.BasicXmlDocument;
import net.authorize.xml.Message;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Templated wrapper container for passing back the result from the request gateway.
 *
 */
public class Result<T> extends net.authorize.xml.Result<T> {

	private static final long serialVersionUID = 1L;

	protected SubscriptionStatusType subscriptionStatus = null;
	protected String resultSubscriptionId = null;

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
	 * Returns the result subscription id.
	 *
	 * @return String containing the subscription id.
	 */
	public String getResultSubscriptionId(){
		return resultSubscriptionId;
	}

	/**
	 * @return the status
	 */
	public SubscriptionStatusType getSubscriptionStatus() {
		return subscriptionStatus;
	}

	/**
	 * Import the response messages into the result.
	 */
	protected void importResponseMessages(Transaction txn){
		NodeList messages_list = txn.getCurrentResponse().getDocument().getElementsByTagName(AuthNetField.ELEMENT_MESSAGES.getFieldName());
		if(messages_list.getLength() == 0) {
			return;
		}

		Element messages_el =(Element)messages_list.item(0);

		resultCode = getElementText(messages_el,AuthNetField.ELEMENT_RESULT_CODE.getFieldName());
		resultSubscriptionId = getElementText(txn.getCurrentResponse().getDocumentElement(),AuthNetField.ELEMENT_SUBSCRIPTION_ID.getFieldName());

		if(TransactionType.GET_SUBSCRIPTION_STATUS.equals(txn.getTransactionType())) {
			String statusStr = getElementText(txn.getCurrentResponse().getDocumentElement(),AuthNetField.ELEMENT_SUBSCRIPTION_STATUS.getFieldName());
			// this has been added since the documentation appears to be out of sync with the implementation... just a safeguard
			if(statusStr == null) {
				statusStr =
					getElementText(txn.getCurrentResponse().getDocumentElement(),AuthNetField.ELEMENT_SUBSCRIPTION_STATUS.getFieldName().toLowerCase());
			}
			subscriptionStatus = SubscriptionStatusType.fromValue(statusStr);
		}

		NodeList message_list = messages_el.getElementsByTagName(AuthNetField.ELEMENT_MESSAGE.getFieldName());
		for(int i = 0; i < message_list.getLength(); i++){
			Element message_el = (Element)message_list.item(i);
			Message new_message = Message.createMessage();
			new_message.setCode(getElementText(message_el,AuthNetField.ELEMENT_CODE.getFieldName()));
			new_message.setText(getElementText(message_el,AuthNetField.ELEMENT_TEXT.getFieldName()));
			this.messages.add(new_message);
		}
	}

	public void printMessages() {
		System.out.println("Result Code: " + (resultCode != null ? resultCode : "No result code"));
		if(resultSubscriptionId != null){
			System.out.println("Result Subscription Id: " + resultSubscriptionId);
		}
		for(int i = 0; i < messages.size(); i++){
			Message message = (Message)messages.get(i);
			System.out.println(message.getCode() + " - " + message.getText());
		}
	}
}

package net.authorize.arb;

import java.math.BigDecimal;

import net.authorize.AuthNetField;
import net.authorize.Merchant;
import net.authorize.data.Order;
import net.authorize.data.arb.PaymentSchedule;
import net.authorize.data.arb.Subscription;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.xml.Address;
import net.authorize.data.xml.BankAccount;
import net.authorize.data.xml.Payment;
import net.authorize.util.BasicXmlDocument;

import org.w3c.dom.Element;

/**
 * Transaction object for ARB.
 *
 */
public class Transaction extends net.authorize.Transaction {

	private static final long serialVersionUID = 1L;
	public static String XML_NAMESPACE = "AnetApi/xml/v1/schema/AnetApiSchema.xsd";

	private Merchant merchant;
	private TransactionType transactionType;
	private BasicXmlDocument currentRequest = null;
	private BasicXmlDocument currentResponse = null;

	/**
	 * Private constructor.
	 *
	 * @param merchant
	 * @param transactionType
	 * @param subscription
	 */
	private Transaction(Merchant merchant, TransactionType transactionType,
			Subscription subscription) {

		this.merchant = merchant;
		this.transactionType = transactionType;

		switch (this.transactionType) {
		case CANCEL_SUBSCRIPTION :
			cancelSubscriptionRequest(subscription);
			break;
		case CREATE_SUBSCRIPTION :
			createSubscriptionRequest(subscription);
			break;
		case GET_SUBSCRIPTION_STATUS :
			getSubscriptionStatusRequest(subscription);
			break;
		case UPDATE_SUBSCRIPTION :
			updateSubscriptionRequest(subscription);
			break;
		default:
			break;
		}
	}

	/**
	 * Creates a transaction.
	 *
	 * @param merchant
	 * @param transactionType
	 * @param subscription
	 *
	 * @return Transaction
	 */
	public static Transaction createTransaction(Merchant merchant, TransactionType transactionType, Subscription subscription) {
		return new Transaction(merchant, transactionType, subscription);
	}

	/**
	 * Create a transaction from a response.
	 *
	 * @param transaction
	 * @param response
	 * @return a Transaction
	 */
	public static final Transaction createTransaction(Transaction transaction, BasicXmlDocument response) {

		transaction.currentResponse = response;

		return transaction;
	}

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * Returns the current request.
	 *
	 * @return BasicXmlDocument containing the request
	 */
	public BasicXmlDocument getCurrentRequest(){
		return currentRequest;

	}

	/**
	 * Returns the current response.
	 *
	 * @return BasicXmlDocument containing the response
	 */
	public BasicXmlDocument getCurrentResponse(){
		return currentResponse;
	}

	/**
	 * Add the subscription id to the request.
	 *
	 * @param document
	 * @param subscription
	 */
	private void addSubscriptionIdToRequest(BasicXmlDocument document, Subscription subscription){
		if(subscription.getSubscriptionId() != null) {
			Element subscr_id_el = document.createElement(AuthNetField.ELEMENT_SUBSCRIPTION_ID.getFieldName());
			subscr_id_el.appendChild(document.getDocument().createTextNode(subscription.getSubscriptionId()));
			document.getDocumentElement().appendChild(subscr_id_el);
		}
	}

	/**
	 * Add the refUId to the subscription request.
	 *
	 * @param document
	 * @param subscription
	 */
	private void addRefIdToRequst(BasicXmlDocument document, Subscription subscription) {
		if(subscription.getRefId() != null){
			Element ref_id_el = document.createElement(AuthNetField.ELEMENT_REFID.getFieldName());
			ref_id_el.appendChild(document.getDocument().createTextNode(subscription.getRefId()));
			document.getDocumentElement().appendChild(ref_id_el);
		}
	}

	/**
	 * Add subscription information to the subscription request.
	 *
	 * @param document
	 * @param subscription
	 */
	private void addSubscriptionToRequest(BasicXmlDocument document, Subscription subscription){

		addRefIdToRequst(document, subscription);
		addSubscriptionIdToRequest(document, subscription);

		Element subscr_el = document.createElement(AuthNetField.ELEMENT_SUBSCRIPTION.getFieldName());
		if(subscription.getName() != null){
			Element name_el = document.createElement(AuthNetField.ELEMENT_NAME.getFieldName());
			name_el.appendChild(document.getDocument().createTextNode(subscription.getName()));
			subscr_el.appendChild(name_el);
		}

		addPaymentScheduleToSubscription(document, subscription, subscr_el);
		if(!subscription.getAmount().equals(ZERO_AMOUNT) || !subscription.getTrialAmount().equals(ZERO_AMOUNT)) {
			Element amount_el = document.createElement(AuthNetField.ELEMENT_AMOUNT.getFieldName());
			amount_el.appendChild(document.getDocument().createTextNode(
					subscription.getAmount().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString()) );
			subscr_el.appendChild(amount_el);
			Element trial_el = document.createElement(AuthNetField.ELEMENT_TRIAL_AMOUNT.getFieldName());
			trial_el.appendChild(document.getDocument().createTextNode(
					subscription.getTrialAmount().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString()) );
			subscr_el.appendChild(trial_el);
		}

		addPaymentToSubscription(document, subscription, subscr_el);
		addBillingInfoToSubscription(document, subscription, subscr_el);
		document.getDocumentElement().appendChild(subscr_el);
	}

	/**
	 * Add billing information to the subscription request.
	 *
	 * @param document
	 * @param subscription
	 * @param subscr_el
	 */
	private void addBillingInfoToSubscription(BasicXmlDocument document, Subscription subscription, Element subscr_el){
		if(subscription.getCustomer() == null || subscription.getCustomer().getBillTo() == null) {
			return;
		}

		// order info
		Order order_info = subscription.getOrder();
		if(order_info != null) {
		  Element order_el = document.createElement(AuthNetField.ELEMENT_ORDER.getFieldName());

		  Element invoice_num_el = document.createElement(AuthNetField.ELEMENT_INVOICE_NUMBER.getFieldName());
		  invoice_num_el.appendChild(document.getDocument().createTextNode(order_info.getInvoiceNumber()));
		  order_el.appendChild(invoice_num_el);

		  Element description_el = document.createElement(AuthNetField.ELEMENT_DESCRIPTION.getFieldName());
		  description_el.appendChild(document.getDocument().createTextNode(order_info.getDescription()));
		  order_el.appendChild(description_el);

		  subscr_el.appendChild(order_el);
		}

		net.authorize.data.xml.Customer customer_info = subscription.getCustomer();
		if(customer_info != null) {
			  Element customer_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER.getFieldName());

			  Element id_el = document.createElement(AuthNetField.ELEMENT_ID.getFieldName());
			  id_el.appendChild(document.getDocument().createTextNode(customer_info.getId()));
			  customer_el.appendChild(id_el);

			  Element email_el = document.createElement(AuthNetField.ELEMENT_EMAIL.getFieldName());
			  email_el.appendChild(document.getDocument().createTextNode(customer_info.getEmail()));
			  customer_el.appendChild(email_el);

			  Element phone_el = document.createElement(AuthNetField.ELEMENT_PHONE_NUMBER.getFieldName());
			  phone_el.appendChild(document.getDocument().createTextNode(customer_info.getPhoneNumber()));
			  customer_el.appendChild(phone_el);

			  Element fax_el = document.createElement(AuthNetField.ELEMENT_FAX_NUMBER.getFieldName());
			  fax_el.appendChild(document.getDocument().createTextNode(customer_info.getFaxNumber()));
			  customer_el.appendChild(fax_el);

			  subscr_el.appendChild(customer_el);
		}

		// add billTo
		addAddressInfoSubscription(document, AuthNetField.ELEMENT_BILL_TO.getFieldName(),
				subscription.getCustomer().getBillTo(), subscr_el);
		// add shipTo
		addAddressInfoSubscription(document, AuthNetField.ELEMENT_SHIP_TO.getFieldName(),
				subscription.getCustomer().getShipTo(), subscr_el);
	}

	/**
	 * Add address info (shipTo / billTo).
	 *
	 * @param document
	 * @param elementName
	 * @param address
	 * @param subscr_el
	 */
	private void addAddressInfoSubscription(BasicXmlDocument document, String elementName,
			Address address, Element subscr_el) {

		if(address != null) {
			Element address_el = document.createElement(elementName);

			Element fname_el = document.createElement(AuthNetField.ELEMENT_FIRST_NAME.getFieldName());
			fname_el.appendChild(document.getDocument().createTextNode(address.getFirstName()));
			address_el.appendChild(fname_el);

			Element lname_el = document.createElement(AuthNetField.ELEMENT_LAST_NAME.getFieldName());
			lname_el.appendChild(document.getDocument().createTextNode(address.getLastName()));
			address_el.appendChild(lname_el);

			Element company_el = document.createElement(AuthNetField.ELEMENT_COMPANY.getFieldName());
			company_el.appendChild(document.getDocument().createTextNode(address.getCompany()));
			address_el.appendChild(company_el);

			Element address_line_el = document.createElement(AuthNetField.ELEMENT_ADDRESS.getFieldName());
			address_line_el.appendChild(document.getDocument().createTextNode(address.getAddress()));
			address_el.appendChild(address_line_el);

			Element city_el = document.createElement(AuthNetField.ELEMENT_CITY.getFieldName());
			city_el.appendChild(document.getDocument().createTextNode(address.getCity()));
			address_el.appendChild(city_el);

			Element state_el = document.createElement(AuthNetField.ELEMENT_STATE.getFieldName());
			state_el.appendChild(document.getDocument().createTextNode(address.getState()));
			address_el.appendChild(state_el);

			Element zip_el = document.createElement(AuthNetField.ELEMENT_ZIP.getFieldName());
			zip_el.appendChild(document.getDocument().createTextNode(address.getZipPostalCode()));
			address_el.appendChild(zip_el);

			Element country_el = document.createElement(AuthNetField.ELEMENT_COUNTRY.getFieldName());
			country_el.appendChild(document.getDocument().createTextNode(address.getCountry()));
			address_el.appendChild(country_el);

			subscr_el.appendChild(address_el);
		}
	}

	/**
	 * Add payment information to the subscription request.
	 *
	 * @param document
	 * @param subscription
	 * @param subscr_el
	 */
	private void addPaymentToSubscription(BasicXmlDocument document, Subscription subscription, Element subscr_el){
		Payment payment = subscription.getPayment();
		if(payment == null) return;

		Element payment_el = document.createElement(AuthNetField.ELEMENT_PAYMENT.getFieldName());
		CreditCard credit_card= payment.getCreditCard();
		BankAccount bank_account = payment.getBankAccount();

		if (credit_card != null){
			Element cc_el = document.createElement(AuthNetField.ELEMENT_CREDIT_CARD.getFieldName());

			Element cc_num_el = document.createElement(AuthNetField.ELEMENT_CREDIT_CARD_NUMBER.getFieldName());
			cc_num_el.appendChild(document.getDocument().createTextNode(credit_card.getCreditCardNumber()));
			cc_el.appendChild(cc_num_el);

			Element cc_exp_el = document.createElement(AuthNetField.ELEMENT_CREDIT_CARD_EXPIRY.getFieldName());
			cc_exp_el.appendChild(document.getDocument().createTextNode(net.authorize.util.DateUtil.getFormattedDate(credit_card.getExpirationDate(),
					CreditCard.ARB_EXPIRY_DATE_FORMAT)));
			cc_el.appendChild(cc_exp_el);

			payment_el.appendChild(cc_el);
		}
		else if (bank_account != null) {
			Element bankacct_el = document.createElement(AuthNetField.ELEMENT_BANK_ACCOUNT.getFieldName());

			if(bank_account.getBankAccountType() != null) {
				Element account_type_el = document.createElement(AuthNetField.ELEMENT_ACCOUNT_TYPE.getFieldName());
				account_type_el.appendChild(document.getDocument().createTextNode(bank_account.getBankAccountType().getValue().toLowerCase()));
				bankacct_el.appendChild(account_type_el);
			}

			Element routing_number_el = document.createElement(AuthNetField.ELEMENT_ROUTING_NUMBER.getFieldName());
			routing_number_el.appendChild(document.getDocument().createTextNode(bank_account.getRoutingNumber()));
			bankacct_el.appendChild(routing_number_el);

			Element acct_number_el = document.createElement(AuthNetField.ELEMENT_ACCOUNT_NUMBER.getFieldName());
			acct_number_el.appendChild(document.getDocument().createTextNode(bank_account.getBankAccountNumber()));
			bankacct_el.appendChild(acct_number_el);

			Element name_on_acct_el = document.createElement(AuthNetField.ELEMENT_NAME_ON_ACCOUNT.getFieldName());
			name_on_acct_el.appendChild(document.getDocument().createTextNode(bank_account.getBankAccountName()));
			bankacct_el.appendChild(name_on_acct_el);

			if(bank_account.getECheckType() != null) {
				Element echeck_type_el = document.createElement(AuthNetField.ELEMENT_ECHECK_TYPE.getFieldName());
				echeck_type_el.appendChild(document.getDocument().createTextNode(bank_account.getECheckType().getValue()));
				bankacct_el.appendChild(echeck_type_el);
			}

			Element bank_name_el = document.createElement(AuthNetField.ELEMENT_BANK_NAME.getFieldName());
			bank_name_el.appendChild(document.getDocument().createTextNode(bank_account.getBankName()));
			bankacct_el.appendChild(bank_name_el);

			payment_el.appendChild(bankacct_el);
		}

		subscr_el.appendChild(payment_el);
	}

	/**
	 * Add a payment schedule to the payment request.
	 *
	 * @param document
	 * @param subscription
	 * @param subscr_el
	 */
	private void addPaymentScheduleToSubscription(BasicXmlDocument document, Subscription subscription, Element subscr_el){
		PaymentSchedule schedule = subscription.getSchedule();
		if(schedule == null) return;

		Element payment_el = document.createElement(AuthNetField.ELEMENT_PAYMENT_SCHEDULE.getFieldName());

		// Add the interval
		//
		if(schedule.getIntervaLength() > 0){
			Element interval_el = document.createElement(AuthNetField.ELEMENT_INTERVAL.getFieldName());
			Element length_el = document.createElement(AuthNetField.ELEMENT_LENGTH.getFieldName());
			Element unit_el = document.createElement(AuthNetField.ELEMENT_UNIT.getFieldName());
			length_el.appendChild(document.getDocument().createTextNode(Integer.toString(schedule.getIntervaLength())));
			interval_el.appendChild(length_el);
			interval_el.appendChild(unit_el);
			unit_el.appendChild(document.getDocument().createTextNode(schedule.getSubscriptionUnit().value()));

			payment_el.appendChild(interval_el);
		}

		Element start_date_el = document.createElement(AuthNetField.ELEMENT_START_DATE.getFieldName());
		start_date_el.appendChild(document.getDocument().createTextNode(net.authorize.util.DateUtil.getFormattedDate(schedule.getStartDate(),
				PaymentSchedule.SCHEDULE_DATE_FORMAT)));
		payment_el.appendChild(start_date_el);

		Element total_el = document.createElement(AuthNetField.ELEMENT_TOTAL_OCCURRENCES.getFieldName());
		total_el.appendChild(document.getDocument().createTextNode(Integer.toString(schedule.getTotalOccurrences())));
		payment_el.appendChild(total_el);

		Element trial_el = document.createElement(AuthNetField.ELEMENT_TRIAL_OCCURRENCES.getFieldName());
		trial_el.appendChild(document.getDocument().createTextNode(Integer.toString(schedule.getTrialOccurrences())));
		payment_el.appendChild(trial_el);

		subscr_el.appendChild(payment_el);
	}

	/**
	 * Add authentication to the subscription request.
	 *
	 * @param document
	 */
	private void addAuthenticationToRequest(BasicXmlDocument document){
		Element auth_el = document.createElement(AuthNetField.ELEMENT_MERCHANT_AUTHENTICATION.getFieldName());
		Element name_el = document.createElement(AuthNetField.ELEMENT_NAME.getFieldName());
		name_el.appendChild(document.getDocument().createTextNode(merchant.getLogin()));
		Element trans_key = document.createElement(AuthNetField.ELEMENT_TRANSACTION_KEY.getFieldName());
		trans_key.appendChild(document.getDocument().createTextNode(merchant.getTransactionKey()));
		auth_el.appendChild(name_el);
		auth_el.appendChild(trans_key);
		document.getDocumentElement().appendChild(auth_el);
	}

	/**
	 * Create subscription request core.
	 *
	 * @param subscription
	 */
	private void createSubscriptionRequest(Subscription subscription){

		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.CREATE_SUBSCRIPTION.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthenticationToRequest(document);
		addSubscriptionToRequest(document,subscription);
		currentRequest = document;
	}

	/**
	 * Update subscription request core.
	 *
	 * @param subscription
	 */
	private void updateSubscriptionRequest(Subscription subscription){

		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.UPDATE_SUBSCRIPTION.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthenticationToRequest(document);
		addSubscriptionToRequest(document,subscription);
		currentRequest = document;
	}

	/**
	 * Cancel subscription request core.
	 *
	 * @param subscription
	 */
	private void cancelSubscriptionRequest(Subscription subscription){

		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.CANCEL_SUBSCRIPTION.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthenticationToRequest(document);
		addSubscriptionIdToRequest(document,subscription);
		currentRequest = document;
	}

	/**
	 * Get subscription request (query request) core.
	 *
	 * @param subscription
	 */
	private void getSubscriptionStatusRequest(Subscription subscription){

		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.GET_SUBSCRIPTION_STATUS.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthenticationToRequest(document);
		addSubscriptionIdToRequest(document,subscription);
		currentRequest = document;
	}

	/**
	 * Convert request to XML.
	 *
	 */
	public String toXMLString() {
		return currentRequest.dump();
	}

}

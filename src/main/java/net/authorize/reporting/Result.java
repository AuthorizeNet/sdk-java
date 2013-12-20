package net.authorize.reporting;

import java.util.ArrayList;

import net.authorize.AuthNetField;
import net.authorize.ResponseCode;
import net.authorize.ResponseReasonCode;
import net.authorize.data.Order;
import net.authorize.data.OrderItem;
import net.authorize.data.ShippingCharges;
import net.authorize.data.creditcard.AVSCode;
import net.authorize.data.creditcard.CardType;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.echeck.ECheckType;
import net.authorize.data.xml.Address;
import net.authorize.data.xml.BankAccount;
import net.authorize.data.xml.Customer;
import net.authorize.data.xml.CustomerType;
import net.authorize.data.xml.Payment;
import net.authorize.data.xml.reporting.BatchDetails;
import net.authorize.data.xml.reporting.BatchStatistics;
import net.authorize.data.xml.reporting.CAVVResponseType;
import net.authorize.data.xml.reporting.CardCodeResponseType;
import net.authorize.data.xml.reporting.FDSFilter;
import net.authorize.data.xml.reporting.FDSFilterActionType;
import net.authorize.data.xml.reporting.ReportingDetails;
import net.authorize.data.xml.reporting.ReportingTransactionType;
import net.authorize.data.xml.reporting.SettlementStateType;
import net.authorize.data.xml.reporting.TransactionDetails;
import net.authorize.data.xml.reporting.TransactionStatusType;
import net.authorize.util.BasicXmlDocument;
import net.authorize.xml.Message;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Reporting specific templated wrapper container for passing back the result from the request gateway.
 *
 */
public class Result<T> extends net.authorize.xml.Result<T> {

	private static final long serialVersionUID = 1L;

	protected String refId;
	protected ReportingDetails reportingDetails;

	@SuppressWarnings("unchecked")
	public static <T> Result<T> createResult(T object, BasicXmlDocument response) {
		Result<T> result = new Result<T>();

		if(object instanceof Transaction) {
			Transaction targetTransaction = Transaction.createTransaction((Transaction) object, response);
			result.importRefId(targetTransaction);
			result.importResponseMessages(targetTransaction);
			switch (targetTransaction.getTransactionType()) {
				case GET_SETTLED_BATCH_LIST :
					result.importBatchSettledInformation(targetTransaction);
					break;
				case GET_TRANSACTION_LIST :
					result.importTransactionList(targetTransaction);
					break;
				case GET_TRANSACTION_DETAILS :
					result.importTransactionDetails(targetTransaction);
					break;
				case GET_BATCH_STATISTICS :
					result.importBatchSettledInformation(targetTransaction);
					break;
				case GET_UNSETTLED_TRANSACTION_LIST :
					result.importTransactionList(targetTransaction);
					break;
				default:
					break;
			}
			result.target = (T)targetTransaction;
		}

		return result;
	}

	/**
	 * Import batch settled reporting information.
	 *
	 * @param txn Transaction object
	 */
	private void importBatchSettledInformation(Transaction txn) {
		this.reportingDetails = txn.getReportingDetails();
		NodeList batchlist_list = txn.getCurrentResponse().getDocument().getElementsByTagName(AuthNetField.ELEMENT_BATCH.getFieldName());

		if(batchlist_list.getLength() == 0) {
			return;
		} else {
			for(int i = 0; i < batchlist_list.getLength(); i++) {
				Element batch_el = (Element)batchlist_list.item(i);
				BatchDetails batchDetail = BatchDetails.createBatchDetail();
				batchDetail.setBatchId(getElementText(batch_el, AuthNetField.ELEMENT_BATCH_ID.getFieldName()));
				batchDetail.setSettlementTimeLocal(getElementText(batch_el, AuthNetField.ELEMENT_SETTLEMENT_TIME_LOCAL.getFieldName()));
				batchDetail.setSettlementTimeUTC(getElementText(batch_el, AuthNetField.ELEMENT_SETTLEMENT_TIME_UTC.getFieldName()));
				batchDetail.setSettlementState(SettlementStateType.fromValue(getElementText(batch_el, AuthNetField.ELEMENT_SETTLEMENT_STATE.getFieldName())));
				batchDetail.setPaymentMethod(getElementText(batch_el, AuthNetField.ELEMENT_PAYMENT_METHOD.getFieldName()));
				// include statistics
				NodeList statistics_list = batch_el.getElementsByTagName(AuthNetField.ELEMENT_STATISTIC.getFieldName());
				for(int j = 0; j < statistics_list.getLength(); j++) {
					BatchStatistics batchStats = BatchStatistics.createBatchStatistics();
					Element statistic_el = (Element)statistics_list.item(j);
					batchStats.setAccountType(
							CardType.findByValue(getElementText(statistic_el, AuthNetField.ELEMENT_ACCOUNT_TYPE.getFieldName())));
					batchStats.setChargeAmount(getElementText(statistic_el, AuthNetField.ELEMENT_CHARGE_AMOUNT.getFieldName()));
					batchStats.setChargeCount(getElementText(statistic_el, AuthNetField.ELEMENT_CHARGE_COUNT.getFieldName()));
					batchStats.setRefundAmount(getElementText(statistic_el, AuthNetField.ELEMENT_REFUND_AMOUNT.getFieldName()));
					batchStats.setRefundCount(getElementText(statistic_el, AuthNetField.ELEMENT_REFUND_COUNT.getFieldName()));
					batchStats.setVoidCount(getElementText(statistic_el, AuthNetField.ELEMENT_VOID_COUNT.getFieldName()));
					batchStats.setDeclineCount(getElementText(statistic_el, AuthNetField.ELEMENT_DECLINE_COUNT.getFieldName()));
					batchStats.setErrorCount(getElementText(statistic_el, AuthNetField.ELEMENT_ERROR_COUNT.getFieldName()));

					batchStats.setReturnedItemAmount(getElementText(statistic_el, AuthNetField.ELEMENT_RETURNED_ITEM_AMOUNT.getFieldName()));
					batchStats.setReturnedItemCount(getElementText(statistic_el, AuthNetField.ELEMENT_RETURNED_ITEM_COUNT.getFieldName()));

					batchStats.setChargebackAmount(getElementText(statistic_el, AuthNetField.ELEMENT_CHARGEBACK_AMOUNT.getFieldName()));
					batchStats.setChargebackCount(getElementText(statistic_el, AuthNetField.ELEMENT_CHARGEBACK_COUNT.getFieldName()));

					batchStats.setCorrectionNoticeCount(getElementText(statistic_el, AuthNetField.ELEMENT_CORRECTION_NOTICE_COUNT.getFieldName()));

					batchStats.setChargeChargebackAmount(getElementText(statistic_el, AuthNetField.ELEMENT_CHARGE_CHARGEBACK_AMOUNT.getFieldName()));
					batchStats.setChargeChargebackCount(getElementText(statistic_el, AuthNetField.ELEMENT_CHARGE_CHARGEBACK_COUNT.getFieldName()));

					batchStats.setRefundChargebackAmount(getElementText(statistic_el, AuthNetField.ELEMENT_REFUND_CHARGEBACK_AMOUNT.getFieldName()));
					batchStats.setRefundChargebackCount(getElementText(statistic_el, AuthNetField.ELEMENT_REFUND_CHARGEBACK_COUNT.getFieldName()));

					batchStats.setChargeReturnedItemsAmount(getElementText(statistic_el, AuthNetField.ELEMENT_CHARGE_RETURNED_ITEMS_AMOUNT.getFieldName()));
					batchStats.setChargeReturnedItemsCount(getElementText(statistic_el, AuthNetField.ELEMENT_CHARGE_RETURNED_ITEMS_COUNT.getFieldName()));

					batchStats.setRefundReturnedItemsAmount(getElementText(statistic_el, AuthNetField.ELEMENT_REFUND_RETURNED_ITEMS_AMOUNT.getFieldName()));
					batchStats.setRefundReturnedItemsCount(getElementText(statistic_el, AuthNetField.ELEMENT_REFUND_RETURNED_ITEMS_COUNT.getFieldName()));

					batchDetail.addBatchStatistics(batchStats);
				}
				this.reportingDetails.getBatchDetailsList().add(batchDetail);
			}
		}
	}

	/**
	 * Import reporting transaction information.
	 *
	 * @param txn
	 */
	private void importTransactionList(Transaction txn) {
		this.reportingDetails = txn.getReportingDetails();
		NodeList transactions_list = txn.getCurrentResponse().getDocument().getElementsByTagName(AuthNetField.ELEMENT_TRANSACTION.getFieldName());

		if(transactions_list.getLength() == 0) {
			return;
		} else {
			ArrayList<TransactionDetails> transactionDetailList = new ArrayList<TransactionDetails>();
			for(int i = 0; i < transactions_list.getLength(); i++) {
				Element transaction_el = (Element)transactions_list.item(i);
				TransactionDetails transactionDetails = TransactionDetails.createTransactionDetails();
				transactionDetails.setTransId(getElementText(transaction_el, AuthNetField.ELEMENT_TRANS_ID.getFieldName()));
				transactionDetails.setSubmitTimeLocal(getElementText(transaction_el, AuthNetField.ELEMENT_SUBMIT_TIME_LOCAL.getFieldName()));
				transactionDetails.setSubmitTimeUTC(getElementText(transaction_el, AuthNetField.ELEMENT_SUBMIT_TIME_UTC.getFieldName()));
				transactionDetails.setTransactionStatus(TransactionStatusType.fromValue(getElementText(transaction_el, AuthNetField.ELEMENT_TRANSACTION_STATUS.getFieldName())));
				transactionDetails.setInvoiceNumber(getElementText(transaction_el, AuthNetField.ELEMENT_INVOICE_NUMBER.getFieldName()));
				transactionDetails.setFirstName(getElementText(transaction_el, AuthNetField.ELEMENT_FIRST_NAME.getFieldName()));
				transactionDetails.setLastName(getElementText(transaction_el, AuthNetField.ELEMENT_LAST_NAME.getFieldName()));
				transactionDetails.setAccountType(CardType.findByValue(getElementText(transaction_el, AuthNetField.ELEMENT_ACCOUNT_TYPE.getFieldName())));
				transactionDetails.setAccountNumber(getElementText(transaction_el, AuthNetField.ELEMENT_ACCOUNT_NUMBER.getFieldName()));
				transactionDetails.setSettleAmount(getElementText(transaction_el, AuthNetField.ELEMENT_SETTLE_AMOUNT.getFieldName()));
				transactionDetailList.add(transactionDetails);
			}
			this.reportingDetails.setTransactionDetailList(transactionDetailList);
		}
	}

	/**
	 * Import reporting transaction details.
	 * @param txn
	 */
	private void importTransactionDetails(Transaction txn) {
		this.reportingDetails = txn.getReportingDetails();
		NodeList transactions_list = txn.getCurrentResponse().getDocument().getElementsByTagName(AuthNetField.ELEMENT_TRANSACTION.getFieldName());
		if(transactions_list.getLength() == 0) {
			return;
		}

		Element transaction_el =(Element)transactions_list.item(0);
		TransactionDetails transactionDetails = TransactionDetails.createTransactionDetails();
		transactionDetails.setTransId(getElementText(transaction_el, AuthNetField.ELEMENT_TRANS_ID.getFieldName()));
		transactionDetails.setRefTransId(getElementText(transaction_el, AuthNetField.ELEMENT_REF_TRANS_ID.getFieldName()));
		transactionDetails.setSplitTenderId(getElementText(transaction_el, AuthNetField.ELEMENT_SPLIT_TENDER_ID.getFieldName()));
		transactionDetails.setSubmitTimeLocal(getElementText(transaction_el, AuthNetField.ELEMENT_SUBMIT_TIME_LOCAL.getFieldName()));
		transactionDetails.setSubmitTimeUTC(getElementText(transaction_el, AuthNetField.ELEMENT_SUBMIT_TIME_UTC.getFieldName()));
		transactionDetails.setTransactionType(ReportingTransactionType.fromValue(getElementText(transaction_el, AuthNetField.ELEMENT_TRANSACTION_TYPE.getFieldName())));
		transactionDetails.setTransactionStatus(TransactionStatusType.fromValue(getElementText(transaction_el, AuthNetField.ELEMENT_TRANSACTION_STATUS.getFieldName())));
		transactionDetails.setResponseCode(ResponseCode.findByResponseCode(getElementText(transaction_el, AuthNetField.ELEMENT_RESPONSE_CODE.getFieldName())));

		// auth codes/responses
		ResponseReasonCode responseReasonCode = ResponseReasonCode.findByReasonCode(getElementText(transaction_el, AuthNetField.ELEMENT_RESPONSE_REASON_CODE.getFieldName()));
		responseReasonCode.setReasonText(getElementText(transaction_el, AuthNetField.ELEMENT_RESPONSE_REASON_DESCRIPTION.getFieldName()));
		transactionDetails.setResponseReasonCode(responseReasonCode);
		transactionDetails.setAuthCode(getElementText(transaction_el, AuthNetField.ELEMENT_AUTH_CODE.getFieldName()));
		transactionDetails.setAvsResponse(AVSCode.findByValue(getElementText(transaction_el, AuthNetField.ELEMENT__AVS_RESPONSE.getFieldName())));
		transactionDetails.setCardCodeResponse(CardCodeResponseType.findByValue(getElementText(transaction_el, AuthNetField.ELEMENT_CARD_CODE_RESPONSE.getFieldName())));
		transactionDetails.setCAVVResponse(CAVVResponseType.findByValue(getElementText(transaction_el, AuthNetField.ELEMENT__CAVV_RESPONSE.getFieldName())));
		transactionDetails.setFDSFilterAction(FDSFilterActionType.findByValue(getElementText(transaction_el, AuthNetField.ELEMENT__FDS_FILTER_ACTION.getFieldName())));

		//FDSFilters
		NodeList FDSFilters_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT__FDS_FILTER.getFieldName());
		for(int i = 0; i < FDSFilters_list.getLength(); i++){
			Element FDSFilter_el = (Element)FDSFilters_list.item(i);
			FDSFilter fdsFilter = FDSFilter.createFDSFilter();
			fdsFilter.setName(getElementText(FDSFilter_el,AuthNetField.ELEMENT_NAME.getFieldName()));
			fdsFilter.setAction(FDSFilterActionType.findByValue(getElementText(FDSFilter_el,AuthNetField.ELEMENT_ACTION.getFieldName())));
			transactionDetails.getFDSFilterList().add(fdsFilter);
		}

		// batch
		NodeList batch_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_BATCH.getFieldName());
		if(batch_list!=null && batch_list.getLength() == 1) {
			Element batch_el = (Element)batch_list.item(0);
			BatchDetails batchDetail = BatchDetails.createBatchDetail();
			batchDetail.setBatchId(getElementText(batch_el, AuthNetField.ELEMENT_BATCH_ID.getFieldName()));
			batchDetail.setSettlementTimeLocal(getElementText(batch_el, AuthNetField.ELEMENT_SETTLEMENT_TIME_LOCAL.getFieldName()));
			batchDetail.setSettlementTimeUTC(getElementText(batch_el, AuthNetField.ELEMENT_SETTLEMENT_TIME_UTC.getFieldName()));
			batchDetail.setSettlementState(SettlementStateType.fromValue(getElementText(batch_el, AuthNetField.ELEMENT_SETTLEMENT_STATE.getFieldName())));
			transactionDetails.setBatch(batchDetail);
		}

		// order
		Order order = Order.createOrder();
		NodeList order_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_ORDER.getFieldName());
		if(order_list != null && order_list.getLength() == 1) {
			Element order_el = (Element)order_list.item(0);
			order.setInvoiceNumber(getElementText(order_el, AuthNetField.ELEMENT_INVOICE_NUMBER.getFieldName()));
			transactionDetails.setInvoiceNumber(order.getInvoiceNumber());
			order.setDescription(getElementText(order_el, AuthNetField.ELEMENT_DESCRIPTION.getFieldName()));
			order.setPurchaseOrderNumber(getElementText(order_el, AuthNetField.ELEMENT_PURCHASE_ORDER_NUMBER.getFieldName()));
		}
		transactionDetails.setRequestedAmount(getElementText(transaction_el, AuthNetField.ELEMENT_REQUESTED_AMOUNT.getFieldName()));
		transactionDetails.setAuthAmount(getElementText(transaction_el, AuthNetField.ELEMENT_AUTH_AMOUNT.getFieldName()));
		order.setTotalAmount(transactionDetails.getAuthAmount());
		transactionDetails.setSettleAmount(getElementText(transaction_el, AuthNetField.ELEMENT_SETTLE_AMOUNT.getFieldName()));

		// tax, shipping, duty charges are rolled into AIM's ShippingCharges
		ShippingCharges shippingCharges = ShippingCharges.createShippingCharges();
		NodeList tax_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_TAX.getFieldName());
		if(tax_list != null && tax_list.getLength() == 1) {
			Element tax_el = (Element)tax_list.item(0);
			shippingCharges.setTaxAmount(getElementText(tax_el, AuthNetField.ELEMENT_AMOUNT.getFieldName()));
			shippingCharges.setTaxItemName(getElementText(tax_el, AuthNetField.ELEMENT_NAME.getFieldName()));
			shippingCharges.setTaxDescription(getElementText(tax_el, AuthNetField.ELEMENT_DESCRIPTION.getFieldName()));
		}
		NodeList shipping_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_SHIPPING.getFieldName());
		if(shipping_list != null && shipping_list.getLength() == 1) {
			Element shipping_el = (Element)shipping_list.item(0);
			shippingCharges.setFreightAmount(getElementText(shipping_el, AuthNetField.ELEMENT_AMOUNT.getFieldName()));
			shippingCharges.setFreightItemName(getElementText(shipping_el, AuthNetField.ELEMENT_NAME.getFieldName()));
			shippingCharges.setFreightDescription(getElementText(shipping_el, AuthNetField.ELEMENT_DESCRIPTION.getFieldName()));
		}
		NodeList duty_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_DUTY.getFieldName());
		if(duty_list != null && duty_list.getLength() == 1) {
			Element duty_el = (Element)duty_list.item(0);
			shippingCharges.setDutyAmount(getElementText(duty_el, AuthNetField.ELEMENT_AMOUNT.getFieldName()));
			shippingCharges.setDutyItemName(getElementText(duty_el, AuthNetField.ELEMENT_NAME.getFieldName()));
			shippingCharges.setDutyItemDescription(getElementText(duty_el, AuthNetField.ELEMENT_DESCRIPTION.getFieldName()));
		}
		order.setShippingCharges(shippingCharges);

		// lineitems
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		NodeList orderitem_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_LINE_ITEM.getFieldName());
		for(int i = 0; i < orderitem_list.getLength(); i++){
			Element orderitem_el = (Element)orderitem_list.item(i);
			OrderItem orderItem = OrderItem.createOrderItem();
			orderItem.setItemId(getElementText(orderitem_el, AuthNetField.ELEMENT_ITEM_ID.getFieldName()));
			orderItem.setItemName(getElementText(orderitem_el, AuthNetField.ELEMENT_NAME.getFieldName()));
			orderItem.setItemDescription(getElementText(orderitem_el, AuthNetField.ELEMENT_DESCRIPTION.getFieldName()));
			orderItem.setItemQuantity(getElementText(orderitem_el, AuthNetField.ELEMENT_QUANTITY.getFieldName()));
			orderItem.setItemPrice(getElementText(orderitem_el, AuthNetField.ELEMENT_UNIT_PRICE.getFieldName()));
			orderItem.setItemTaxable(getElementText(orderitem_el, AuthNetField.ELEMENT_TAXABLE.getFieldName()));
			orderItemList.add(orderItem);
		}
		order.setOrderItems(orderItemList);
		transactionDetails.setOrder(order);
		transactionDetails.setPrepaidBalanceRemaining(getElementText(transaction_el, AuthNetField.ELEMENT_PREPAID_BALANCE_REMAINING.getFieldName()));
		transactionDetails.setItemTaxExempt(getElementText(transaction_el, AuthNetField.ELEMENT_TAX_EXEMPT.getFieldName()));

		// payment
		NodeList payment_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_PAYMENT.getFieldName());
		Payment payment = null;
		if(payment_list != null && payment_list.getLength() == 1) {
			Element payment_el = (Element)payment_list.item(0);
			NodeList credit_card_list = payment_el.getElementsByTagName(AuthNetField.ELEMENT_CREDIT_CARD.getFieldName());
			if(credit_card_list != null && credit_card_list.getLength() == 1) {
				CreditCard creditCard = CreditCard.createCreditCard();
				Element credit_card_el = (Element)credit_card_list.item(0);
				creditCard.setMaskedCreditCardNumber(getElementText(credit_card_el, AuthNetField.ELEMENT_CARD_NUMBER.getFieldName()));
				creditCard.setExpirationDate(getElementText(credit_card_el, AuthNetField.ELEMENT_EXPIRATION_DATE.getFieldName()));
				creditCard.setCardType(CardType.findByValue(getElementText(credit_card_el, AuthNetField.ELEMENT_ACCOUNT_TYPE.getFieldName())));
				payment = Payment.createPayment(creditCard);
			}
			NodeList bank_account_list = payment_el.getElementsByTagName(AuthNetField.ELEMENT_BANK_ACCOUNT.getFieldName());
			if(bank_account_list != null && bank_account_list.getLength() == 1) {
				BankAccount bankAccount = BankAccount.createBankAccount();
				Element bank_account_el = (Element)bank_account_list.item(0);
				bankAccount.setRoutingNumber(getElementText(bank_account_el, AuthNetField.ELEMENT_ROUTING_NUMBER.getFieldName()));
				bankAccount.setBankAccountNumber(getElementText(bank_account_el, AuthNetField.ELEMENT_ACCOUNT_NUMBER.getFieldName()));
				bankAccount.setBankAccountName(getElementText(bank_account_el, AuthNetField.ELEMENT_NAME_ON_ACCOUNT.getFieldName()));
				bankAccount.setECheckType(ECheckType.findByValue(getElementText(bank_account_el, AuthNetField.ELEMENT_ECHECK_TYPE.getFieldName())));
				payment = Payment.createPayment(bankAccount);
			}
			transactionDetails.setPayment(payment);
		}

		// customer
		NodeList customer_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_CUSTOMER.getFieldName());
		Customer customer = null;
		if(customer_list != null && customer_list.getLength() == 1) {
			Element customer_el = (Element)customer_list.item(0);
			customer = Customer.createCustomer();
			customer.setCustomerType(CustomerType.findByName(getElementText(customer_el, AuthNetField.ELEMENT_TYPE.getFieldName())));
			customer.setId(getElementText(customer_el, AuthNetField.ELEMENT_ID.getFieldName()));
			customer.setEmail(getElementText(customer_el, AuthNetField.ELEMENT_EMAIL.getFieldName()));
			// bill to address
			Address billToAddress = null;
			NodeList bill_to_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_BILL_TO.getFieldName());
			if(bill_to_list != null && bill_to_list.getLength() == 1) {
				Element address_el = (Element)bill_to_list.item(0);
				billToAddress = Address.createAddress();
				billToAddress.setFirstName(getElementText(address_el, AuthNetField.ELEMENT_FIRST_NAME.getFieldName()));
				billToAddress.setLastName(getElementText(address_el, AuthNetField.ELEMENT_LAST_NAME.getFieldName()));
				billToAddress.setCompany(getElementText(address_el, AuthNetField.ELEMENT_COMPANY.getFieldName()));
				billToAddress.setAddress(getElementText(address_el, AuthNetField.ELEMENT_ADDRESS.getFieldName()));
				billToAddress.setCity(getElementText(address_el, AuthNetField.ELEMENT_CITY.getFieldName()));
				billToAddress.setState(getElementText(address_el, AuthNetField.ELEMENT_STATE.getFieldName()));
				billToAddress.setZipPostalCode(getElementText(address_el, AuthNetField.ELEMENT_ZIP.getFieldName()));
				billToAddress.setCountry(getElementText(address_el, AuthNetField.ELEMENT_COUNTRY.getFieldName()));
				billToAddress.setPhoneNumber(getElementText(address_el, AuthNetField.ELEMENT_PHONE_NUMBER.getFieldName()));
				billToAddress.setFaxNumber(getElementText(address_el, AuthNetField.ELEMENT_FAX_NUMBER.getFieldName()));
				customer.setBillTo(billToAddress);
			}
			// ship to address
			Address shipToAddress = null;
			NodeList ship_to_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_SHIP_TO.getFieldName());
			if(ship_to_list != null && ship_to_list.getLength() == 1) {
				Element address_el = (Element)ship_to_list.item(0);
				shipToAddress = Address.createAddress();
				shipToAddress.setFirstName(getElementText(address_el, AuthNetField.ELEMENT_FIRST_NAME.getFieldName()));
				shipToAddress.setLastName(getElementText(address_el, AuthNetField.ELEMENT_LAST_NAME.getFieldName()));
				shipToAddress.setCompany(getElementText(address_el, AuthNetField.ELEMENT_COMPANY.getFieldName()));
				shipToAddress.setAddress(getElementText(address_el, AuthNetField.ELEMENT_ADDRESS.getFieldName()));
				shipToAddress.setCity(getElementText(address_el, AuthNetField.ELEMENT_CITY.getFieldName()));
				shipToAddress.setState(getElementText(address_el, AuthNetField.ELEMENT_STATE.getFieldName()));
				shipToAddress.setZipPostalCode(getElementText(address_el, AuthNetField.ELEMENT_ZIP.getFieldName()));
				shipToAddress.setCountry(getElementText(address_el, AuthNetField.ELEMENT_COUNTRY.getFieldName()));
				customer.setShipTo(billToAddress);
			}
			transactionDetails.setCustomer(customer);
		}
		// recurringbilling
		transactionDetails.setRecurringBilling(getElementText(transaction_el, AuthNetField.ELEMENT_RECURRING_BILLING.getFieldName()));
		// customer ip
		transactionDetails.setCustomerIP(getElementText(transaction_el, AuthNetField.ELEMENT_CUSTOMER_IP.getFieldName()));
		this.getReportingDetails().getTransactionDetailList().add(transactionDetails);
	}

	/**
	 * Import the response messages into the result.
	 */
	private void importResponseMessages(Transaction txn){
		NodeList messages_list = txn.getCurrentResponse().getDocument().getElementsByTagName(AuthNetField.ELEMENT_MESSAGES.getFieldName());
		if(messages_list.getLength() == 0) {
			return;
		}

		Element messages_el =(Element)messages_list.item(0);

		resultCode = getElementText(messages_el,AuthNetField.ELEMENT_RESULT_CODE.getFieldName());

		NodeList message_list = messages_el.getElementsByTagName(AuthNetField.ELEMENT_MESSAGE.getFieldName());
		for(int i = 0; i < message_list.getLength(); i++){
			Element message_el = (Element)message_list.item(i);
			Message new_message = Message.createMessage();
			new_message.setCode(getElementText(message_el,AuthNetField.ELEMENT_CODE.getFieldName()));
			new_message.setText(getElementText(message_el,AuthNetField.ELEMENT_TEXT.getFieldName()));
			this.messages.add(new_message);
		}
	}

	/**
	 * Import the refId.
	 */
	private void importRefId(Transaction txn) {
		this.refId = getElementText(
				txn.getCurrentResponse().getDocument().getDocumentElement(), AuthNetField.ELEMENT_REFID.getFieldName());
	}

	/**
	 * @return the refId
	 */
	public String getRefId() {
		return refId;
	}

	/**
	 * @return the reportingDetails
	 */
	public ReportingDetails getReportingDetails() {
		return reportingDetails;
	}

	/**
	 * Print out messages for debugging.
	 *
	 */
	public void printMessages() {
		System.out.println("Result Code: " + (resultCode != null ? resultCode : "No result code"));
		for(int i = 0; i < messages.size(); i++){
			Message message = (Message)messages.get(i);
			System.out.println(message.getCode() + " - " + message.getText());
		}
	}
}

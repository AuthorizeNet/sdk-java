package net.authorize.aim;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import net.authorize.AuthNetField;
import net.authorize.Environment;
import net.authorize.Merchant;
import net.authorize.PaymentMethod;
import net.authorize.ResponseField;
import net.authorize.TransactionType;
import net.authorize.data.Customer;
import net.authorize.data.EmailReceipt;
import net.authorize.data.Order;
import net.authorize.data.OrderItem;
import net.authorize.data.ShippingAddress;
import net.authorize.data.ShippingCharges;
import net.authorize.data.creditcard.AVSCode;
import net.authorize.data.creditcard.CardType;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.echeck.ECheck;
import net.authorize.data.echeck.ECheckType;
import net.authorize.util.BasicXmlDocument;
import net.authorize.util.DeepCopy;
import net.authorize.util.HttpClient;
import net.authorize.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Container to hold all payment related information that gets passed back and
 * forth to the payment gateway.
 *
 */
public class Transaction extends net.authorize.Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Log logger = LogFactory.getLog(Transaction.class);

	protected Map<String, String> requestMap = Collections.synchronizedMap(new HashMap<String, String>());
	private Map<ResponseField, String> responseMap = Collections.synchronizedMap(new HashMap<ResponseField, String>());
	private BasicXmlDocument currentResponse = null;
	protected Map<String, String> merchantDefinedMap = Collections.synchronizedMap(new HashMap<String, String>());
	private CreditCard creditCard;
	private ECheck eCheck;
	private Customer customer;
	private EmailReceipt emailReceipt;
	private Order order;
	private ShippingAddress shippingAddress;
	private ShippingCharges shippingCharges;
	protected TransactionType transactionType;
	private boolean cardPresent = false;
	protected String MD5Value = null;

	/**
	 * Constructor for creation a transaction with typed objects.
	 *
	 * @param merchant
	 * @param transactionType
	 * @param amount
	 */
	protected Transaction(Merchant merchant,
			TransactionType transactionType, BigDecimal amount) {

		this.requestMap.put(AuthNetField.X_VERSION_FIELD.getFieldName(), Transaction.VERSION);
		this.requestMap.put(AuthNetField.X_DELIM_CHAR_FIELD.getFieldName(), Transaction.TRANSACTION_FIELD_DELIMITER);
		this.requestMap.put(AuthNetField.X_DELIM_DATA_FIELD.getFieldName(), TRUE);
		this.requestMap.put(AuthNetField.X_ENCAP_CHAR.getFieldName(), Transaction.ENCAP_CHAR_DELIMITER);

		// setup test mode
		if(Environment.PRODUCTION.equals(merchant.getEnvironment()) ||
			Environment.SANDBOX.equals(merchant.getEnvironment()) ) {
			this.requestMap.put(AuthNetField.X_TEST_REQUEST.getFieldName(),FALSE);
		}
		 // applies to SANDBOX_TEST & PRODUCTION_TEST
		else {
			this.requestMap.put(AuthNetField.X_TEST_REQUEST.getFieldName(),TRUE);
		}

		// setup the merchant
		if(merchant != null) {
			this.requestMap.put(AuthNetField.X_LOGIN.getFieldName(), merchant.getLogin());
			this.requestMap.put(AuthNetField.X_TRAN_KEY.getFieldName(), merchant.getTransactionKey());
			this.requestMap.put(AuthNetField.X_ALLOW_PARTIAL_AUTH.getFieldName(), merchant.isAllowPartialAuth()?TRUE:FALSE);

			// is this a card present transaction?
			if(merchant.getDeviceType() != null && merchant.getMarketType() != null) {
				this.cardPresent = true;
				this.MD5Value = merchant.getMD5Value();
				this.requestMap.put(AuthNetField.X_MARKET_TYPE.getFieldName(), merchant.getMarketType().getValue());
				this.requestMap.put(AuthNetField.X_DEVICE_TYPE.getFieldName(), merchant.getDeviceType().getValue());
				this.requestMap.put(AuthNetField.X_CPVERSION.getFieldName(), Merchant.CP_VERSION);
				// hard wire this to be 0 - XML, 1 - DELIMITED TEXT.  Note the default is 0
				this.requestMap.put(AuthNetField.X_RESPONSE_FORMAT.getFieldName(), "0");
				if(StringUtils.isNotEmpty(merchant.getUserRef()) ) {
					this.requestMap.put(AuthNetField.X_USER_REF.getFieldName(), merchant.getUserRef());
				}
			}
		}

		// default transaction type
		if(transactionType == null) {
			transactionType = TransactionType.AUTH_CAPTURE;
		}
		this.transactionType = transactionType;
		this.requestMap.put(AuthNetField.X_TYPE.getFieldName(), transactionType.getValue());

		this.requestMap.put(AuthNetField.X_AMOUNT.getFieldName(), amount != null?
				amount.setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString():
					ZERO_STRING);

		// SIM applications use relay response. Set this to false (default) if you are using AIM.
		this.requestMap.put(AuthNetField.X_RELAY_RESPONSE.getFieldName(), FALSE);

		// Indicates whether a delimited transaction response is required
		this.requestMap.put(AuthNetField.X_DELIM_DATA.getFieldName(), TRUE);

	}

	/**
	 * Create a transaction from a responseMap.
	 *
	 * @param transaction
	 * @param responseMap
	 * @return a Transaction
	 */
	public static final Transaction createTransaction(Transaction transaction, Map<ResponseField, String> responseMap) {
		Transaction _transaction = (Transaction)DeepCopy.copy(transaction);

		_transaction.responseMap = responseMap;

		// populate the authorization code
		if(responseMap.containsKey(ResponseField.AUTHORIZATION_CODE)) {
			_transaction.setAuthorizationCode((String)responseMap.get(ResponseField.AUTHORIZATION_CODE));
		}

		// transaction ID
		if(responseMap.containsKey(ResponseField.TRANSACTION_ID)) {
			_transaction.setTransactionId((String)responseMap.get(ResponseField.TRANSACTION_ID));
		}

		CreditCard creditCard = _transaction.getCreditCard();
		if(creditCard != null) {
			// masked credit card
			if(responseMap.containsKey(ResponseField.ACCOUNT_NUMBER)) {
				creditCard.setMaskedCreditCardNumber((String)responseMap.get(ResponseField.ACCOUNT_NUMBER));
			}
			// credit card type
			if(responseMap.containsKey(ResponseField.CARD_TYPE)) {
				creditCard.setCardType(CardType.findByValue((String)responseMap.get(ResponseField.CARD_TYPE)));
			}
			// AVS response
			if(responseMap.containsKey(ResponseField.AVS_CODE)) {
				creditCard.setAvsCode(AVSCode.findByValue((String)responseMap.get(ResponseField.AVS_CODE)));
			}

			_transaction.setCreditCard(creditCard);
		}

		ECheck eCheck = _transaction.getECheck();
		if(eCheck != null) {
		}

		return _transaction;
	}

	/**
	 * Create a transaction from a response XML doc.
	 *
	 * @param transaction
	 * @param response
	 * @return Transaction object
	 */
	public static final Transaction createTransaction(Transaction transaction, BasicXmlDocument response) {

		Transaction _transaction = (Transaction)DeepCopy.copy(transaction);

		_transaction.cardPresent = true;
		_transaction.currentResponse = response;

		return _transaction;
	}

	/**
	 * Create a Transaction for a merchant.
	 *
	 * @param merchant
	 * @param transactionType
	 * @param amount
	 */
	public static Transaction createTransaction(Merchant merchant,
			TransactionType transactionType, BigDecimal amount) {

		return new Transaction(merchant, transactionType, amount);
	}

	/**
	 * @return the transactionRequestHash
	 */
	public Map<String, String> getRequestMap() {
		return this.requestMap;
	}

	/**
	 * Return the payment gateway response data map.
	 *
	 * @return a map of response data
	 */
	public Map<ResponseField, String> getResponseMap() {
		return this.responseMap;
	}

	/**
	 * The payment gateway assigned transaction ID of an original transaction.
	 *
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId) {
		if( this.requestMap.get(AuthNetField.X_SPLIT_TENDER_ID.getFieldName()) == null ||
				this.requestMap.get(AuthNetField.X_SPLIT_TENDER_ID.getFieldName()).equals("")) {

			this.requestMap.put(AuthNetField.X_TRANS_ID.getFieldName(),
					transactionId != null?transactionId:EMPTY_STRING);
			this.requestMap.remove(AuthNetField.X_SPLIT_TENDER_ID.getFieldName());
		}
	}

	/**
	 * The payment gateway assigned slit tender ID of an original transaction.
	 *
	 * @param splitTenderId
	 */
	public void setSplitTenderId(String splitTenderId) {
		if( this.requestMap.get(AuthNetField.X_TRANS_ID.getFieldName()) == null ||
				this.requestMap.get(AuthNetField.X_TRANS_ID.getFieldName()).equals("")) {

			this.requestMap.put(AuthNetField.X_SPLIT_TENDER_ID.getFieldName(),
					splitTenderId != null?splitTenderId:EMPTY_STRING);
			this.requestMap.remove(AuthNetField.X_TRANS_ID.getFieldName());
		}
	}
	/**
	 * Return the payment gateway assigned transaction ID of the transaction.
	 *
	 * @return The transaction id.
	 */
	public String getTransactionId() {
		return this.requestMap.containsKey(AuthNetField.X_TRANS_ID.getFieldName())?
				this.requestMap.get(AuthNetField.X_TRANS_ID.getFieldName()):EMPTY_STRING;
	}


	/**
	 * Get the transaction type.
	 *
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * The authorization code of an original transaction not captured on the payment gateway.
	 *
	 * @param authCode
	 */
	public void setAuthorizationCode(String authCode) {
		this.requestMap.put(AuthNetField.X_AUTH_CODE.getFieldName(),
				authCode!=null?authCode:EMPTY_STRING);
	}

	/**
	 * Get the authorization code of the transaction.
	 *
	 * @return authorizationCode
	 */
	public String getAuthorizationCode() {
		return this.requestMap.containsKey(AuthNetField.X_AUTH_CODE.getFieldName())?
				this.requestMap.get(AuthNetField.X_AUTH_CODE.getFieldName()):EMPTY_STRING;
	}

	/**
	 * Set the CreditCard information for the transaction request.
	 *
	 * @param creditCard
	 */
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;

		if(creditCard != null) {
			this.requestMap.put(AuthNetField.X_METHOD.getFieldName(),
					PaymentMethod.CREDIT_CARD.getMethod());
			this.requestMap.put(AuthNetField.X_CARD_NUM.getFieldName(),
					creditCard.getCreditCardNumber()!=null?creditCard.getCreditCardNumber():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_EXP_DATE.getFieldName(),
					creditCard.getExpirationMonth()!=null&&creditCard.getExpirationYear()!=null?
							creditCard.getExpirationMonth()+creditCard.getExpirationYear():EMPTY_STRING);
			// card code
			if(creditCard.getCardCode() != null) {
				this.requestMap.put(AuthNetField.X_CARD_CODE.getFieldName(), creditCard.getCardCode());
			}
			// cardholder authentication
			if(creditCard.getCardholderAuthenticationIndicator() != null &&
					creditCard.getCardholderAuthenticationValue() != null &&
					(TransactionType.AUTH_ONLY.equals(this.transactionType) ||
					TransactionType.AUTH_CAPTURE.equals(this.transactionType)) ) {

				this.requestMap.put(AuthNetField.X_AUTHENTICATION_INDICATOR.getFieldName(),
						creditCard.getCardholderAuthenticationIndicator());
				this.requestMap.put(AuthNetField.X_CARDHOLDER_AUTHENTICATION_VALUE.getFieldName(),
						creditCard.getCardholderAuthenticationValue());
			}
			// card present transaction?
			if(StringUtils.isNotEmpty(creditCard.getTrack1()) ||
					StringUtils.isNotEmpty(creditCard.getTrack2())) {

				if(creditCard.getCardType() != null) {
					this.requestMap.put(AuthNetField.X_CARD_TYPE.getFieldName(),
							creditCard.getCardType().name().substring(0,0));
				}
				this.requestMap.put(AuthNetField.X_TRACK1.getFieldName(),
						StringUtils.isNotEmpty(creditCard.getTrack1())?creditCard.getTrack1():EMPTY_STRING);
				this.requestMap.put(AuthNetField.X_TRACK2.getFieldName(),
						StringUtils.isNotEmpty(creditCard.getTrack2())?creditCard.getTrack2():EMPTY_STRING);
			}
		}
	}

	/**
	 * Get the CreditCard associated with the transaction.
	 *
	 * @return credit card object
	 */
	public CreditCard getCreditCard() {
		return this.creditCard;
	}

	/**
	 * @param eCheck the eCheck to set
	 */
	public void setECheck(ECheck eCheck) {
		this.eCheck = eCheck;
		if(eCheck != null) {
			this.requestMap.put(AuthNetField.X_METHOD.getFieldName(), PaymentMethod.E_CHECK.getMethod());
			this.requestMap.put(AuthNetField.X_BANK_ABA_CODE.getFieldName(), eCheck.getRoutingNumber());
			this.requestMap.put(AuthNetField.X_BANK_ACCT_NUM.getFieldName(), eCheck.getBankAccountNumber());
			this.requestMap.put(AuthNetField.X_BANK_ACCT_TYPE.getFieldName(), eCheck.getBankAccountType().getValue());
			this.requestMap.put(AuthNetField.X_BANK_NAME.getFieldName(), eCheck.getBankName());
			this.requestMap.put(AuthNetField.X_BANK_ACCT_NAME.getFieldName(), eCheck.getBankAccountName());
			this.requestMap.put(AuthNetField.X_ECHECK_TYPE.getFieldName(), eCheck.getECheckType().getValue());
			if(ECheckType.ARC.equals(eCheck.getECheckType()) ||
					ECheckType.BOC.equals(eCheck.getECheckType()) ) {

				this.requestMap.put(AuthNetField.X_BANK_CHECK_NUMBER.getFieldName(),
						eCheck.getBankCheckNumber());

			}
		}
	}

	/**
	 * @return the eCheck
	 */
	public ECheck getECheck() {
		return eCheck;
	}

	/**
	 * Set the Customer information for the transaction request.
	 *
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;

		if(customer != null) {
			this.requestMap.put(AuthNetField.X_FIRST_NAME.getFieldName(), customer.getFirstName()!=null?customer.getFirstName():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_LAST_NAME.getFieldName(), customer.getLastName()!=null?customer.getLastName():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_COMPANY.getFieldName(), customer.getCompany()!=null?customer.getCompany():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_ADDRESS.getFieldName(), customer.getAddress()!=null?customer.getAddress():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_CITY.getFieldName(), customer.getCity()!=null?customer.getCity():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_STATE.getFieldName(), customer.getState()!=null?customer.getState():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_ZIP.getFieldName(), customer.getZipPostalCode()!=null?customer.getZipPostalCode():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_COUNTRY.getFieldName(), customer.getCountry()!=null?customer.getCountry():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_PHONE.getFieldName(), customer.getPhone()!=null?customer.getPhone():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_FAX.getFieldName(), customer.getFax()!=null?customer.getFax():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_EMAIL.getFieldName(), customer.getEmail()!=null?customer.getEmail():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_CUST_ID.getFieldName(), customer.getCustomerId()!=null?customer.getCustomerId():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_CUSTOMER_IP.getFieldName(), customer.getCustomerIP()!=null?customer.getCustomerIP():EMPTY_STRING);
		}
	}

	/**
	 * Get the Customer information associated with the transaction.
	 *
	 * @return The Customer
	 */
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Set the EmailReceipt information for the transaction request.
	 *
	 * @param emailReceipt
	 */
	public void setEmailReceipt(EmailReceipt emailReceipt) {
		this.emailReceipt = emailReceipt;

		if(emailReceipt != null) {
			this.requestMap.put(AuthNetField.X_EMAIL.getFieldName(), emailReceipt.getEmail()!=null?emailReceipt.getEmail():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_EMAIL_CUSTOMER.getFieldName(), emailReceipt.isEmailCustomer()?TRUE:FALSE);
			this.requestMap.put(AuthNetField.X_HEADER_EMAIL_RECEIPT.getFieldName(), emailReceipt.getHeaderEmailReceipt()!=null?emailReceipt.getHeaderEmailReceipt():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_FOOTER_EMAIL_RECEIPT.getFieldName(), emailReceipt.getFooterEmailReceipt()!=null?emailReceipt.getFooterEmailReceipt():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_MERCHANT_EMAIL.getFieldName(), emailReceipt.getMerchantEmail()!=null?emailReceipt.getMerchantEmail():EMPTY_STRING);
		}
	}

	/**
	 * Get the EmailReceipt associated with the transaction.
	 *
	 * @return The EmailReceipt.
	 */
	public EmailReceipt getEmailReceipt() {
		return this.emailReceipt;
	}

	/**
	 * Set the Order (and OrderItems) for the transaction request.
	 *
	 * @param order
	 */
	public void setOrder(Order order) {
		this.order = order;

		if(order != null) {
			this.requestMap.put(AuthNetField.X_INVOICE_NUM.getFieldName(), order.getInvoiceNumber()!=null?order.getInvoiceNumber():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_DESCRIPTION.getFieldName(), order.getDescription()!=null?order.getDescription():EMPTY_STRING);

			if(order.getOrderItems() != null) {
				StringBuilder orderItemBuffer = new StringBuilder();
				boolean firstOrderItem = true;
				for(OrderItem orderItem : order.getOrderItems()) {
					if(firstOrderItem) {
						firstOrderItem = false;
					} else {
						orderItemBuffer.append("&").append(AuthNetField.X_LINE_ITEM.getFieldName()).append("=");
					}
					try {
						orderItemBuffer.append(orderItem.getItemId()!=null?
								URLEncoder.encode(orderItem.getItemId(), HttpClient.ENCODING) :
									EMPTY_STRING).append(BRACKET_PIPE_DELIMITER);
						orderItemBuffer.append(orderItem.getItemName()!=null?
								URLEncoder.encode(orderItem.getItemName(), HttpClient.ENCODING):
								EMPTY_STRING).append(BRACKET_PIPE_DELIMITER);
						orderItemBuffer.append(orderItem.getItemDescription()!=null?
								URLEncoder.encode(orderItem.getItemDescription(), HttpClient.ENCODING):
									EMPTY_STRING).append(BRACKET_PIPE_DELIMITER);
						orderItemBuffer.append(orderItem.getItemQuantity()!=null?
								URLEncoder.encode(orderItem.getItemQuantity().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString(), HttpClient.ENCODING):
									ZERO_STRING).append(BRACKET_PIPE_DELIMITER);
						orderItemBuffer.append(orderItem.getItemPrice()!=null?
								URLEncoder.encode(orderItem.getItemPrice().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString(), HttpClient.ENCODING):
									ZERO_STRING).append(BRACKET_PIPE_DELIMITER);
						orderItemBuffer.append(orderItem.isItemTaxable()?TRUE:FALSE);
					} catch (UnsupportedEncodingException uee) {
						logger.warn("Failed encoding order items.", uee);
					}
				}
				this.requestMap.put(AuthNetField.X_LINE_ITEM.getFieldName(), orderItemBuffer.toString());
			}
			// set the shipping charges here.
			setShippingCharges(order.getShippingCharges());
		}
	}

	/**
	 * Get the Order associated with the transaction.
	 *
	 * @return The Order.
	 */
	public Order getOrder() {
		return this.order;
	}

	/**
	 * Set the ShippingAddress for the transaction request.
	 *
	 * @param shippingAddress
	 */
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;

		if(shippingAddress != null) {
			this.requestMap.put(AuthNetField.X_SHIP_TO_FIRST_NAME.getFieldName(),
					shippingAddress.getFirstName() != null?shippingAddress.getFirstName():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_SHIP_TO_LAST_NAME.getFieldName(),
					shippingAddress.getLastName() != null?shippingAddress.getLastName():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_SHIP_TO_COMPANY.getFieldName(),
					shippingAddress.getCompany() != null?shippingAddress.getCompany():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_SHIP_TO_ADDRESS.getFieldName(),
					shippingAddress.getAddress() != null?shippingAddress.getAddress():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_SHIP_TO_CITY.getFieldName(),
					shippingAddress.getCity() != null?shippingAddress.getCity():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_SHIP_TO_STATE.getFieldName(),
					shippingAddress.getState() != null?shippingAddress.getState():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_SHIP_TO_ZIP.getFieldName(),
					shippingAddress.getZipPostalCode() != null?shippingAddress.getZipPostalCode():EMPTY_STRING);
			this.requestMap.put(AuthNetField.X_SHIP_TO_COUNTRY.getFieldName(),
					shippingAddress.getCountry() != null?shippingAddress.getCountry():EMPTY_STRING);
		}
	}

	/**
	 * Get the ShippingAddress for the transaction request.
	 *
	 * @return The ShippingAddress
	 */
	public ShippingAddress getShippingAddress() {
		return this.shippingAddress;
	}

	/**
	 * Set the ShippingCharges for the transaction request.
	 *
	 * @param shippingCharges
	 */
	public void setShippingCharges(ShippingCharges shippingCharges) {
		this.shippingCharges = shippingCharges;

		if(shippingCharges != null) {
			try {
				// tax charges
				if(shippingCharges.getTaxAmount() != null &&
						!ZERO_AMOUNT.equals(shippingCharges.getTaxAmount())) {
					StringBuilder taxBuffer = new StringBuilder();
					taxBuffer.append(URLEncoder.encode(shippingCharges.getTaxItemName()!=null?
							shippingCharges.getTaxItemName():EMPTY_STRING, HttpClient.ENCODING)).append(BRACKET_PIPE_DELIMITER);
					taxBuffer.append(URLEncoder.encode(shippingCharges.getTaxDescription()!=null?
							shippingCharges.getTaxDescription():EMPTY_STRING, HttpClient.ENCODING)).append(BRACKET_PIPE_DELIMITER);
					taxBuffer.append(URLEncoder.encode(shippingCharges.getTaxAmount().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString(), HttpClient.ENCODING));

					this.requestMap.put(AuthNetField.X_TAX.getFieldName(),  taxBuffer.toString());
				}
				// freight charges
				if(shippingCharges.getFreightAmount() != null &&
						!ZERO_AMOUNT.equals(shippingCharges.getFreightAmount())) {
					StringBuilder freightBuffer = new StringBuilder();
					freightBuffer.append(URLEncoder.encode(shippingCharges.getFreightItemName()!=null?
							shippingCharges.getFreightItemName():EMPTY_STRING, HttpClient.ENCODING)).append(BRACKET_PIPE_DELIMITER);
					freightBuffer.append(URLEncoder.encode(shippingCharges.getFreightDescription()!=null?
							shippingCharges.getFreightDescription():EMPTY_STRING, HttpClient.ENCODING)).append(BRACKET_PIPE_DELIMITER);
					freightBuffer.append(URLEncoder.encode(shippingCharges.getFreightAmount().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString(), HttpClient.ENCODING));

					this.requestMap.put(AuthNetField.X_FREIGHT.getFieldName(), freightBuffer.toString());
				}
				// duty charges
				if(shippingCharges.getDutyAmount() != null &&
						!ZERO_AMOUNT.equals(shippingCharges.getDutyAmount())) {
					StringBuilder dutyBuffer = new StringBuilder();
					dutyBuffer.append(URLEncoder.encode(shippingCharges.getDutyItemName()!=null?
							shippingCharges.getDutyItemName():EMPTY_STRING, HttpClient.ENCODING));
					dutyBuffer.append(URLEncoder.encode(shippingCharges.getDutyItemDescription()!=null?
							shippingCharges.getDutyItemDescription():EMPTY_STRING, HttpClient.ENCODING));
					dutyBuffer.append(URLEncoder.encode(shippingCharges.getDutyAmount().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString(), HttpClient.ENCODING));

					this.requestMap.put(AuthNetField.X_DUTY.getFieldName(), dutyBuffer.toString());
				}
			} catch (UnsupportedEncodingException uee) {
				logger.warn("Failed encoding shipping charges.", uee);
			}

			this.requestMap.put(AuthNetField.X_TAX_EXEMPT.getFieldName(), shippingCharges.isTaxExempt()?TRUE:FALSE);
			this.requestMap.put(AuthNetField.X_PO_NUM.getFieldName(),
					shippingCharges.getPurchaseOrderNumber()!=null?shippingCharges.getPurchaseOrderNumber():EMPTY_STRING);
		}

	}

	/**
	 * Get the ShippingCharges associated with the transaction.
	 *
	 * @return The ShippingCharges
	 */
	public ShippingCharges getShippingCharges() {
		return this.shippingCharges;
	}

	/**
	 * The window of time after the submission of a transaction that a duplicate transaction can not be submitted.
	 *
	 * @param seconds
	 */
	public void setDuplicateWindow(int seconds) {
		this.requestMap.put(AuthNetField.X_DUPLICATE_WINDOW.getFieldName(), Integer.toString(seconds));
	}

	/**
	 * Set the currency code for Card Present transactions.
	 *
	 * @param currencyCode
	 */
	public void setCurrencyCode(String currencyCode) {
		this.requestMap.put(AuthNetField.X_CURRENCY_CODE.getFieldName(), currencyCode);
	}

	/**
	 * Get the currency code for Card Present transactions.
	 *
	 * @return the currencyCode used in the transaction.
	 */
	public String getCurrencyCode() {
		return this.requestMap.get(AuthNetField.X_CURRENCY_CODE.getFieldName());
	}

	/**
	 * Indicating marker used by merchant account providers to identify transactions which originate from merchant
	 * hosted recurring billing applications. This value is not affiliated with Automated Recurring Billing.
	 *
	 * @param recurringBillingStatus
	 */
	public void setRecurringBilling(boolean recurringBillingStatus) {
		this.requestMap.put(AuthNetField.X_RECURRING_BILLING.getFieldName(), recurringBillingStatus?TRUE:FALSE);
	}

	/**
	 * Set a merchant defined field.
	 *
	 * @param field
	 * @param value
	 */
	public void setMerchantDefinedField(String field, String value) {
		if(this.requestMap.get(field) == null) {
			this.merchantDefinedMap.put(field, value);
		}
	}

	/**
	 * Get a merchant defined field.
	 *
	 * @param field
	 *
	 * @return Return the value found in the merchant defined hash by a field.
	 */
	public String getMerchantDefinedField(String field) {
		return this.merchantDefinedMap.get(field);
	}

	/**
	 * Get the merchant defined data map.
	 *
	 * @return a map of merchant defined data
	 */
	public Map<String, String> getMerchantDefinedMap() {
		return this.merchantDefinedMap;
	}

	/**
	 * Returns the payment gateway response data for a specific ResponseField.
	 *
	 * @param responseField
	 *
	 * @return the value found in the map identified by the response field
	 */
	public String getResponseField(ResponseField responseField) {
		return this.responseMap.get(responseField);
	}

	/**
	 * Prepare the name/value pair mapping based on the Map(s) provided.
	 *
	 * @return String
	 */
	public String toNVPString() {
		StringBuilder nvpBuffer = new StringBuilder();

		// loop on the request mappings
		LinkedList<Map<String,String>> requestMappings = new LinkedList<Map<String, String>>();
		requestMappings.add(requestMap);
		requestMappings.add(merchantDefinedMap);

		for(Map<String, String> requestMapping : requestMappings) {
			Set<String> keys = requestMapping.keySet();
			for(String key : keys) {
				try {
					String value = requestMapping.get(key).toString();
					key = URLEncoder.encode(key, HttpClient.ENCODING);
					if( !AuthNetField.X_LINE_ITEM.getFieldName().equals(key) &&
						 !AuthNetField.X_TAX.getFieldName().equals(key) &&
						 !AuthNetField.X_FREIGHT.getFieldName().equals(key) &&
						 !AuthNetField.X_DUTY.getFieldName().equals(key) ) {
						value = URLEncoder.encode(value, HttpClient.ENCODING);
					}
					nvpBuffer.append(key).append("=").append(value).append("&");
				} catch (Exception e) {
					logger.warn("NVP encoding failed: " + e.getMessage());
				}
			}
		}
		nvpBuffer.deleteCharAt(nvpBuffer.length()-1);

		return nvpBuffer.toString();
	}

	/**
	 * Return true if the transaction is a Card Present type transaction.
	 *
	 * @return the cardPresent
	 */
	public boolean isCardPresent() {
		return cardPresent;
	}

	/**
	 * Return a response XML doc if the transaction was a Card Present transaction.
	 * @return the responseXml
	 */
	public BasicXmlDocument getCurrentResponse() {
		return currentResponse;
	}

	/**
	 * @return the mD5Value
	 */
	public String getMD5Value() {
		return MD5Value;
	}


}

package net.authorize.data.xml.reporting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import net.authorize.ResponseCode;
import net.authorize.ResponseReasonCode;
import net.authorize.aim.Transaction;
import net.authorize.data.Order;
import net.authorize.data.creditcard.AVSCode;
import net.authorize.data.creditcard.CardType;
import net.authorize.data.xml.Customer;
import net.authorize.data.xml.Payment;
import net.authorize.util.StringUtils;

/**
 * Reporting transaction details.
 */
public class TransactionDetails {

	private String transId;
	private String refTransId;
	private String splitTenderId;
	private Date submitTimeUTC;
	private Date submitTimeLocal;
	private ReportingTransactionType transactionType;
	private TransactionStatusType transactionStatus;
	private ResponseCode responseCode;
	private ResponseReasonCode responseReasonCode;
	private String authCode;
	private AVSCode avsResponse;
	private CardCodeResponseType cardCodeResponse;
	private CAVVResponseType CAVVResponse;
	private FDSFilterActionType FDSFilterAction;
	private ArrayList<FDSFilter> FDSFilterList = new ArrayList<FDSFilter>();
	private BatchDetails batch;
	private Order order;
	// reporting
	private BigDecimal prepaidBalanceRemaining = null;
	private boolean itemTaxExempt;

	private BigDecimal requestedAmount;
	private BigDecimal authAmount;
	private BigDecimal settleAmount;
	private Payment payment;
	private Customer customer;
	private boolean recurringBilling;
	private String customerIP;

	private String invoiceNumber;
	private String firstName;
	private String lastName;
	private CardType accountType;
	private String accountNumber;

	private boolean fullTransactionDetails = false;

	private TransactionDetails() { }

	public static TransactionDetails createTransactionDetails() {
		return new TransactionDetails();
	}

	/**
	 * @return the transId
	 */
	public String getTransId() {
		return transId;
	}

	/**
	 * @param transId
	 *            the transId to set
	 */
	public void setTransId(String transId) {
		this.transId = transId;
	}

	/**
	 * @return the submitTimeUTC
	 */
	public Date getSubmitTimeUTC() {
		return submitTimeUTC;
	}

	/**
	 * @param submitTimeUTC
	 *            the submitTimeUTC to set
	 */
	public void setSubmitTimeUTC(Date submitTimeUTC) {
		this.submitTimeUTC = submitTimeUTC;
	}

	/**
	 * @param submitTimeUTC
	 *            the submitTimeUTC to set
	 */
	public void setSubmitTimeUTC(String submitTimeUTC) {
		if (StringUtils.isNotEmpty(submitTimeUTC)) {
			this.submitTimeUTC = net.authorize.util.DateUtil
					.getDateFromFormattedDate(submitTimeUTC,
							fullTransactionDetails?ReportingDetails.DATE_FORMAT_FULL:ReportingDetails.DATE_FORMAT);
		}
	}

	/**
	 * @return the submitTimeLocal
	 */
	public Date getSubmitTimeLocal() {
		return submitTimeLocal;
	}

	/**
	 * @param submitTimeLocal
	 *            the submitTimeLocal to set
	 */
	public void setSubmitTimeLocal(Date submitTimeLocal) {
		this.submitTimeLocal = submitTimeLocal;
	}

	/**
	 * @param submitTimeLocal
	 *            the submitTimeLocal to set
	 */
	public void setSubmitTimeLocal(String submitTimeLocal) {
		if (StringUtils.isNotEmpty(submitTimeLocal)) {
			this.submitTimeLocal = net.authorize.util.DateUtil
					.getDateFromFormattedDate(submitTimeLocal,
							fullTransactionDetails?ReportingDetails.DATE_FORMAT_FULL:ReportingDetails.DATE_FORMAT);
		}
	}

	/**
	 * @return the transactionStatus
	 */
	public TransactionStatusType getTransactionStatus() {
		return transactionStatus;
	}

	/**
	 * @param transactionStatus
	 *            the transactionStatus to set
	 */
	public void setTransactionStatus(TransactionStatusType transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * @param transactionStatus
	 *            the transactionStatus to set
	 */
	public void setTransactionStatus(String transactionStatus) {
		if (StringUtils.isNotEmpty(transactionStatus)) {
			this.transactionStatus = TransactionStatusType
					.fromValue(transactionStatus);
		}
	}

	/**
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * @param invoiceNumber
	 *            the invoiceNumber to set
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the accountType
	 */
	public CardType getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType
	 *            the accountType to set
	 */
	public void setAccountType(CardType accountType) {
		this.accountType = accountType;
	}

	/**
	 * @param accountType
	 *            the accountType to set
	 */
	public void setAccountType(String accountType) {
		if (StringUtils.isNotEmpty(accountType)) {
			this.accountType = CardType.findByValue(accountType);
		}
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the fullTransactionDetails
	 */
	public boolean isFullTransactionDetails() {
		return fullTransactionDetails;
	}

	/**
	 * @param fullTransactionDetails the fullTransactionDetails to set
	 */
	public void setFullTransactionDetails(boolean fullTransactionDetails) {
		this.fullTransactionDetails = fullTransactionDetails;
	}

	/**
	 * @return the refTransId
	 */
	public String getRefTransId() {
		return refTransId;
	}

	/**
	 * @param refTransId the refTransId to set
	 */
	public void setRefTransId(String refTransId) {
		this.refTransId = refTransId;
	}

	/**
	 * @return the splitTenderId
	 */
	public String getSplitTenderId() {
		return splitTenderId;
	}

	/**
	 * @param splitTenderId the splitTenderId to set
	 */
	public void setSplitTenderId(String splitTenderId) {
		this.splitTenderId = splitTenderId;
	}

	/**
	 * @return the transactionType
	 */
	public ReportingTransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(ReportingTransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the responseCode
	 */
	public ResponseCode getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseReasonCode
	 */
	public ResponseReasonCode getResponseReasonCode() {
		return responseReasonCode;
	}

	/**
	 * @param responseReasonCode the responseReasonCode to set
	 */
	public void setResponseReasonCode(ResponseReasonCode responseReasonCode) {
		this.responseReasonCode = responseReasonCode;
	}

	/**
	 * @return the authCode
	 */
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * @param authCode the authCode to set
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	/**
	 * @return the avsResponse
	 */
	public AVSCode getAvsResponse() {
		return avsResponse;
	}

	/**
	 * @param avsResponse the avsResponse to set
	 */
	public void setAvsResponse(AVSCode avsResponse) {
		this.avsResponse = avsResponse;
	}

	/**
	 * @return the cardCodeResponse
	 */
	public CardCodeResponseType getCardCodeResponse() {
		return cardCodeResponse;
	}

	/**
	 * @param cardCodeResponse the cardCodeResponse to set
	 */
	public void setCardCodeResponse(CardCodeResponseType cardCodeResponse) {
		this.cardCodeResponse = cardCodeResponse;
	}

	/**
	 * @return the cAVVResponse
	 */
	public CAVVResponseType getCAVVResponse() {
		return CAVVResponse;
	}

	/**
	 * @param cAVVResponse the cAVVResponse to set
	 */
	public void setCAVVResponse(CAVVResponseType cAVVResponse) {
		CAVVResponse = cAVVResponse;
	}

	/**
	 * @return the fDSFilterAction
	 */
	public FDSFilterActionType getFDSFilterAction() {
		return FDSFilterAction;
	}

	/**
	 * @param fDSFilterAction the fDSFilterAction to set
	 */
	public void setFDSFilterAction(FDSFilterActionType fDSFilterAction) {
		FDSFilterAction = fDSFilterAction;
	}

	/**
	 * @return the fDSFilterList
	 */
	public ArrayList<FDSFilter> getFDSFilterList() {
		return FDSFilterList;
	}

	/**
	 * @param fDSFilterList the fDSFilterList to set
	 */
	public void setFDSFilterList(ArrayList<FDSFilter> fDSFilterList) {
		FDSFilterList = fDSFilterList;
	}

	/**
	 * @return the batch
	 */
	public BatchDetails getBatch() {
		return batch;
	}

	/**
	 * @param batch the batch to set
	 */
	public void setBatch(BatchDetails batch) {
		this.batch = batch;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the requestedAmount
	 */
	public BigDecimal getRequestedAmount() {
		return requestedAmount;
	}

	/**
	 * @param requestedAmount the requestedAmount to set
	 */
	public void setRequestedAmount(BigDecimal requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	/**
	 * @param requestedAmount the requestedAmount to set
	 */
	public void setRequestedAmount(String requestedAmount) {
		if(StringUtils.isNotEmpty(requestedAmount)) {
			this.requestedAmount = new BigDecimal(requestedAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the authAmount
	 */
	public BigDecimal getAuthAmount() {
		return authAmount;
	}

	/**
	 * @param authAmount the authAmount to set
	 */
	public void setAuthAmount(BigDecimal authAmount) {
		this.authAmount = authAmount;
	}

	/**
	 * @param authAmount the authAmount to set
	 */
	public void setAuthAmount(String authAmount) {
		if(StringUtils.isNotEmpty(authAmount)) {
			this.authAmount = new BigDecimal(authAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the settleAmount
	 */
	public BigDecimal getSettleAmount() {
		return settleAmount;
	}

	/**
	 * @param settleAmount the settleAmount to set
	 */
	public void setSettleAmount(BigDecimal settleAmount) {
		this.settleAmount = settleAmount;
	}

	/**
	 * @param settleAmount the settleAmount to set
	 */
	public void setSettleAmount(String settleAmount) {
		if(StringUtils.isNotEmpty(settleAmount)) {
			this.settleAmount = new BigDecimal(settleAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the recurringBilling
	 */
	public boolean isRecurringBilling() {
		return recurringBilling;
	}

	/**
	 * @param recurringBilling the recurringBilling to set
	 */
	public void setRecurringBilling(boolean recurringBilling) {
		this.recurringBilling = recurringBilling;
	}

	/**
	 * @param recurringBilling the recurringBilling to set
	 */
	public void setRecurringBilling(String recurringBilling) {
		if(StringUtils.isNotEmpty(recurringBilling)) {
			this.recurringBilling = Boolean.valueOf(recurringBilling);
		}
	}

	/**
	 * @return the customerIP
	 */
	public String getCustomerIP() {
		return customerIP;
	}

	/**
	 * @param customerIP the customerIP to set
	 */
	public void setCustomerIP(String customerIP) {
		this.customerIP = customerIP;
	}

	/**
	 * @return the prepaidBalanceRemaining
	 */
	public BigDecimal getPrepaidBalanceRemaining() {
		return prepaidBalanceRemaining;
	}

	/**
	 * @param prepaidBalanceRemaining the prepaidBalanceRemaining to set
	 */
	public void setPrepaidBalanceRemaining(BigDecimal prepaidBalanceRemaining) {
		this.prepaidBalanceRemaining = prepaidBalanceRemaining;
	}

	/**
	 * @param prepaidBalanceRemaining the prepaidBalanceRemaining to set
	 */
	public void setPrepaidBalanceRemaining(String prepaidBalanceRemaining) {
		if(StringUtils.isNotEmpty(prepaidBalanceRemaining)) {
			this.prepaidBalanceRemaining = new BigDecimal(prepaidBalanceRemaining).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the itemTaxExempt
	 */
	public boolean isItemTaxExempt() {
		return itemTaxExempt;
	}

	/**
	 * @param itemTaxExempt the itemTaxExempt to set
	 */
	public void setItemTaxExempt(boolean itemTaxExempt) {
		this.itemTaxExempt = itemTaxExempt;
	}

	/**
	 * @param itemTaxExempt the itemTaxExempt to set
	 */
	public void setItemTaxExempt(String itemTaxExempt) {
		if(StringUtils.isNotEmpty(itemTaxExempt)) {
			this.itemTaxExempt = Boolean.valueOf(itemTaxExempt);
		}
	}

}

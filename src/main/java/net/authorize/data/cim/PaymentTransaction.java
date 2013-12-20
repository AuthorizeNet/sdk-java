package net.authorize.data.cim;

import net.authorize.TransactionType;
import net.authorize.cim.SplitTenderStatus;
import net.authorize.data.Order;

public class PaymentTransaction {

	private TransactionType transactionType;
	private Order order;
	private String cardCode;
	private boolean recurringBilling = false;
	private String customerPaymentProfileId;
	private String customerShippingAddressId;
	private String splitTenderId;
	private SplitTenderStatus splitTenderStatus = null;
	private String approvalCode;
	private String transactionId;
	private String creditCardNumberMasked;
	private String bankRoutingNumberMasked;
	private String bankAccountNumberMasked;

	private PaymentTransaction() {}

	public static PaymentTransaction createPaymentTransaction() {
		return new PaymentTransaction();
	}

	/**
	 * Get the payment transaction type.
	 *
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * Set the payment transaction type.
	 *
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
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
	 * @return the cardCode
	 */
	public String getCardCode() {
		return cardCode;
	}

	/**
	 * @param cardCode the cardCode to set
	 */
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
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
	 * @return the customerPaymentProfileId
	 */
	public String getCustomerPaymentProfileId() {
		return customerPaymentProfileId;
	}

	/**
	 * @param customerPaymentProfileId the customerPaymentProfileId to set
	 */
	public void setCustomerPaymentProfileId(String customerPaymentProfileId) {
		this.customerPaymentProfileId = customerPaymentProfileId;
	}

	/**
	 * @return the customerShippingAddressId
	 */
	public String getCustomerShippingAddressId() {
		return customerShippingAddressId;
	}

	/**
	 * @param customerShippingAddressId the customerShippingAddressId to set
	 */
	public void setCustomerShippingAddressId(String customerShippingAddressId) {
		this.customerShippingAddressId = customerShippingAddressId;
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
	 * @return the approvalCode
	 */
	public String getApprovalCode() {
		return approvalCode;
	}

	/**
	 * @param approvalCode the approvalCode to set
	 */
	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the creditCardNumberMasked
	 */
	public String getCreditCardNumberMasked() {
		return creditCardNumberMasked;
	}

	/**
	 * @param creditCardNumberMasked the creditCardNumberMasked to set
	 */
	public void setCreditCardNumberMasked(String creditCardNumberMasked) {
		this.creditCardNumberMasked = creditCardNumberMasked;
	}

	/**
	 * @return the bankRoutingNumberMasked
	 */
	public String getBankRoutingNumberMasked() {
		return bankRoutingNumberMasked;
	}

	/**
	 * @param bankRoutingNumberMasked the bankRoutingNumberMasked to set
	 */
	public void setBankRoutingNumberMasked(String bankRoutingNumberMasked) {
		this.bankRoutingNumberMasked = bankRoutingNumberMasked;
	}

	/**
	 * @return the bankAccountNumberMasked
	 */
	public String getBankAccountNumberMasked() {
		return bankAccountNumberMasked;
	}

	/**
	 * @param bankAccountNumberMasked the bankAccountNumberMasked to set
	 */
	public void setBankAccountNumberMasked(String bankAccountNumberMasked) {
		this.bankAccountNumberMasked = bankAccountNumberMasked;
	}

	/**
	 * @return the splitTenderStatus
	 */
	public SplitTenderStatus getSplitTenderStatus() {
		return splitTenderStatus;
	}

	/**
	 * @param splitTenderStatus the splitTenderStatus to set
	 */
	public void setSplitTenderStatus(SplitTenderStatus splitTenderStatus) {
		this.splitTenderStatus = splitTenderStatus;
	}



}
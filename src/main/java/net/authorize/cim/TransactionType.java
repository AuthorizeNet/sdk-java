package net.authorize.cim;

/**
 *	Enumeration of CIM transaction types that are supported by Authorize.Net
 */
public enum TransactionType {

	CREATE_CUSTOMER_PROFILE("createCustomerProfileRequest"),
	CREATE_CUSTOMER_PAYMENT_PROFILE("createCustomerPaymentProfileRequest"),
	CREATE_CUSTOMER_SHIPPING_ADDRESS("createCustomerShippingAddressRequest"),
	CREATE_CUSTOMER_PROFILE_TRANSACTION("createCustomerProfileTransactionRequest"),
	DELETE_CUSTOMER_PROFILE("deleteCustomerProfileRequest"),
	DELETE_CUSTOMER_PAYMENT_PROFILE("deleteCustomerPaymentProfileRequest"),
	DELETE_CUSTOMER_SHIPPING_ADDRESS("deleteCustomerShippingAddressRequest"),
	GET_CUSTOMER_PROFILE_IDS("getCustomerProfileIdsRequest"),
	GET_CUSTOMER_PROFILE("getCustomerProfileRequest"),
	GET_CUSTOMER_PAYMENT_PROFILE("getCustomerPaymentProfileRequest"),
	GET_CUSTOMER_SHIPPING_ADDRESS("getCustomerShippingAddressRequest"),
	UPDATE_CUSTOMER_PROFILE("updateCustomerProfileRequest"),
	UPDATE_CUSTOMER_PAYMENT_PROFILE("updateCustomerPaymentProfileRequest"),
	UPDATE_CUSTOMER_SHIPPING_ADDRESS("updateCustomerShippingAddressRequest"),
	UPDATE_SPLIT_TENDER_GROUP("updateSplitTenderGroupRequest"),
	VALIDATE_CUSTOMER_PAYMENT_PROFILE("validateCustomerPaymentProfileRequest");

	final private String value;

	private TransactionType(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}

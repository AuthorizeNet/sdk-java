package net.authorize.cim;

/**
 *	Enumeration of CIM transaction types that are supported by Authorize.Net
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
	GET_HOSTED_PROFILE_PAGE("getHostedProfilePageRequest"),
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

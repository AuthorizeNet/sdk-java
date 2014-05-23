
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApiMethodName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ApiMethodName">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="ARBCreateSubscription"/>
 *     &lt;enumeration value="ARBUpdateSubscription"/>
 *     &lt;enumeration value="ARBCancelSubscription"/>
 *     &lt;enumeration value="IsAlive"/>
 *     &lt;enumeration value="AuthenticateTest"/>
 *     &lt;enumeration value="CreateCustomerProfile"/>
 *     &lt;enumeration value="CreateCustomerPaymentProfile"/>
 *     &lt;enumeration value="CreateCustomerShippingAddress"/>
 *     &lt;enumeration value="GetCustomerProfile"/>
 *     &lt;enumeration value="GetCustomerPaymentProfile"/>
 *     &lt;enumeration value="GetCustomerShippingAddress"/>
 *     &lt;enumeration value="UpdateCustomerProfile"/>
 *     &lt;enumeration value="UpdateCustomerPaymentProfile"/>
 *     &lt;enumeration value="UpdateCustomerShippingAddress"/>
 *     &lt;enumeration value="DeleteCustomerProfile"/>
 *     &lt;enumeration value="DeleteCustomerPaymentProfile"/>
 *     &lt;enumeration value="DeleteCustomerShippingAddress"/>
 *     &lt;enumeration value="CreateCustomerProfileTransaction"/>
 *     &lt;enumeration value="ValidateCustomerPaymentProfile"/>
 *     &lt;enumeration value="GetResellerServices"/>
 *     &lt;enumeration value="GetResellerProcessors"/>
 *     &lt;enumeration value="GetServiceBuyRatePrograms"/>
 *     &lt;enumeration value="GetResellerAcquirers"/>
 *     &lt;enumeration value="ResellerCreateMerchant"/>
 *     &lt;enumeration value="GetCustomerProfileIds"/>
 *     &lt;enumeration value="UpdateSplitTenderGroup"/>
 *     &lt;enumeration value="ARBGetSubscriptionStatus"/>
 *     &lt;enumeration value="GetTransactionDetails"/>
 *     &lt;enumeration value="GetSettledBatchList"/>
 *     &lt;enumeration value="GetTransactionList"/>
 *     &lt;enumeration value="GetSettledBatchDetails"/>
 *     &lt;enumeration value="GetSplitTenderGroup"/>
 *     &lt;enumeration value="CreateTransaction"/>
 *     &lt;enumeration value="GetHostedProfilePage"/>
 *     &lt;enumeration value="GetUnsettledTransactionList"/>
 *     &lt;enumeration value="GetBatchStatistics"/>
 *     &lt;enumeration value="MobileDeviceLogin"/>
 *     &lt;enumeration value="Logout"/>
 *     &lt;enumeration value="MobileDeviceRegistration"/>
 *     &lt;enumeration value="SendCustomerTransactionReceipt"/>
 *     &lt;enumeration value="GetMerchantActivationLink"/>
 *     &lt;enumeration value="GetMerchantActivationHostedSurvey"/>
 *     &lt;enumeration value="GetMerchantActivationStatus"/>
 *     &lt;enumeration value="ResellerActivateMerchant"/>
 *     &lt;enumeration value="UpdateMerchantConfiguration"/>
 *     &lt;enumeration value="ARBGetSubscriptionReport"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ApiMethodName")
@XmlEnum
public enum ApiMethodName {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("ARBCreateSubscription")
    ARB_CREATE_SUBSCRIPTION("ARBCreateSubscription"),
    @XmlEnumValue("ARBUpdateSubscription")
    ARB_UPDATE_SUBSCRIPTION("ARBUpdateSubscription"),
    @XmlEnumValue("ARBCancelSubscription")
    ARB_CANCEL_SUBSCRIPTION("ARBCancelSubscription"),
    @XmlEnumValue("IsAlive")
    IS_ALIVE("IsAlive"),
    @XmlEnumValue("AuthenticateTest")
    AUTHENTICATE_TEST("AuthenticateTest"),
    @XmlEnumValue("CreateCustomerProfile")
    CREATE_CUSTOMER_PROFILE("CreateCustomerProfile"),
    @XmlEnumValue("CreateCustomerPaymentProfile")
    CREATE_CUSTOMER_PAYMENT_PROFILE("CreateCustomerPaymentProfile"),
    @XmlEnumValue("CreateCustomerShippingAddress")
    CREATE_CUSTOMER_SHIPPING_ADDRESS("CreateCustomerShippingAddress"),
    @XmlEnumValue("GetCustomerProfile")
    GET_CUSTOMER_PROFILE("GetCustomerProfile"),
    @XmlEnumValue("GetCustomerPaymentProfile")
    GET_CUSTOMER_PAYMENT_PROFILE("GetCustomerPaymentProfile"),
    @XmlEnumValue("GetCustomerShippingAddress")
    GET_CUSTOMER_SHIPPING_ADDRESS("GetCustomerShippingAddress"),
    @XmlEnumValue("UpdateCustomerProfile")
    UPDATE_CUSTOMER_PROFILE("UpdateCustomerProfile"),
    @XmlEnumValue("UpdateCustomerPaymentProfile")
    UPDATE_CUSTOMER_PAYMENT_PROFILE("UpdateCustomerPaymentProfile"),
    @XmlEnumValue("UpdateCustomerShippingAddress")
    UPDATE_CUSTOMER_SHIPPING_ADDRESS("UpdateCustomerShippingAddress"),
    @XmlEnumValue("DeleteCustomerProfile")
    DELETE_CUSTOMER_PROFILE("DeleteCustomerProfile"),
    @XmlEnumValue("DeleteCustomerPaymentProfile")
    DELETE_CUSTOMER_PAYMENT_PROFILE("DeleteCustomerPaymentProfile"),
    @XmlEnumValue("DeleteCustomerShippingAddress")
    DELETE_CUSTOMER_SHIPPING_ADDRESS("DeleteCustomerShippingAddress"),
    @XmlEnumValue("CreateCustomerProfileTransaction")
    CREATE_CUSTOMER_PROFILE_TRANSACTION("CreateCustomerProfileTransaction"),
    @XmlEnumValue("ValidateCustomerPaymentProfile")
    VALIDATE_CUSTOMER_PAYMENT_PROFILE("ValidateCustomerPaymentProfile"),
    @XmlEnumValue("GetResellerServices")
    GET_RESELLER_SERVICES("GetResellerServices"),
    @XmlEnumValue("GetResellerProcessors")
    GET_RESELLER_PROCESSORS("GetResellerProcessors"),
    @XmlEnumValue("GetServiceBuyRatePrograms")
    GET_SERVICE_BUY_RATE_PROGRAMS("GetServiceBuyRatePrograms"),
    @XmlEnumValue("GetResellerAcquirers")
    GET_RESELLER_ACQUIRERS("GetResellerAcquirers"),
    @XmlEnumValue("ResellerCreateMerchant")
    RESELLER_CREATE_MERCHANT("ResellerCreateMerchant"),
    @XmlEnumValue("GetCustomerProfileIds")
    GET_CUSTOMER_PROFILE_IDS("GetCustomerProfileIds"),
    @XmlEnumValue("UpdateSplitTenderGroup")
    UPDATE_SPLIT_TENDER_GROUP("UpdateSplitTenderGroup"),
    @XmlEnumValue("ARBGetSubscriptionStatus")
    ARB_GET_SUBSCRIPTION_STATUS("ARBGetSubscriptionStatus"),
    @XmlEnumValue("GetTransactionDetails")
    GET_TRANSACTION_DETAILS("GetTransactionDetails"),
    @XmlEnumValue("GetSettledBatchList")
    GET_SETTLED_BATCH_LIST("GetSettledBatchList"),
    @XmlEnumValue("GetTransactionList")
    GET_TRANSACTION_LIST("GetTransactionList"),
    @XmlEnumValue("GetSettledBatchDetails")
    GET_SETTLED_BATCH_DETAILS("GetSettledBatchDetails"),
    @XmlEnumValue("GetSplitTenderGroup")
    GET_SPLIT_TENDER_GROUP("GetSplitTenderGroup"),
    @XmlEnumValue("CreateTransaction")
    CREATE_TRANSACTION("CreateTransaction"),
    @XmlEnumValue("GetHostedProfilePage")
    GET_HOSTED_PROFILE_PAGE("GetHostedProfilePage"),
    @XmlEnumValue("GetUnsettledTransactionList")
    GET_UNSETTLED_TRANSACTION_LIST("GetUnsettledTransactionList"),
    @XmlEnumValue("GetBatchStatistics")
    GET_BATCH_STATISTICS("GetBatchStatistics"),
    @XmlEnumValue("MobileDeviceLogin")
    MOBILE_DEVICE_LOGIN("MobileDeviceLogin"),
    @XmlEnumValue("Logout")
    LOGOUT("Logout"),
    @XmlEnumValue("MobileDeviceRegistration")
    MOBILE_DEVICE_REGISTRATION("MobileDeviceRegistration"),
    @XmlEnumValue("SendCustomerTransactionReceipt")
    SEND_CUSTOMER_TRANSACTION_RECEIPT("SendCustomerTransactionReceipt"),
    @XmlEnumValue("GetMerchantActivationLink")
    GET_MERCHANT_ACTIVATION_LINK("GetMerchantActivationLink"),
    @XmlEnumValue("GetMerchantActivationHostedSurvey")
    GET_MERCHANT_ACTIVATION_HOSTED_SURVEY("GetMerchantActivationHostedSurvey"),
    @XmlEnumValue("GetMerchantActivationStatus")
    GET_MERCHANT_ACTIVATION_STATUS("GetMerchantActivationStatus"),
    @XmlEnumValue("ResellerActivateMerchant")
    RESELLER_ACTIVATE_MERCHANT("ResellerActivateMerchant"),
    @XmlEnumValue("UpdateMerchantConfiguration")
    UPDATE_MERCHANT_CONFIGURATION("UpdateMerchantConfiguration"),
    @XmlEnumValue("ARBGetSubscriptionReport")
    ARB_GET_SUBSCRIPTION_REPORT("ARBGetSubscriptionReport");
    private final String value;

    ApiMethodName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ApiMethodName fromValue(String v) {
        for (ApiMethodName c: ApiMethodName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

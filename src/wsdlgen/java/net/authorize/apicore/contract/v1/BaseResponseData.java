
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseResponseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Successful" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Messages" type="{http://api.authorize.net/ANetApiWS/}ArrayOfMessagesWS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResponseData", propOrder = {
    "successful",
    "messages"
})
@XmlSeeAlso({
    IsValidMerchantConfigGroupResponseData.class,
    UpdateCustomerShippingAddressResponseData.class,
    SearchCustomerProfilesResponseData.class,
    GetUnsettledTransListResponseData.class,
    ValidatePaymentProfileResponseData.class,
    GetTransactionDetailsResponseData.class,
    GetSettledBatchListResponseData.class,
    GetCustomerShippingAddressResponseData.class,
    GetMerchantConfigResponseData.class,
    ARBGetSubscriptionStatusResponseData.class,
    GetBatchStatisticsResponseData.class,
    SendCustomerEmailReceiptResponse.class,
    ARBUpdateSubscriptionResponseData.class,
    CustomerShippingAddressResponseData.class,
    IsValidMerchantConfigFieldResponseData.class,
    DecryptFOPResponseData.class,
    CustomerPaymentProfileResponseData.class,
    ARBCreateSubscriptionResponseData.class,
    ARBCancelSubscriptionResponseData.class,
    ARBGetSubscriptionReportResponseData.class,
    GetCustomerProfileResponseData.class,
    DeleteCustomerPaymentProfileResponseData.class,
    GetTransListResponseData.class,
    DeleteCustomerProfileResponseData.class,
    GetMerchantInfoResponseData.class,
    SearchCustomerProfilesAdvancedResponseData.class,
    GetCustomerPaymentProfileResponseData.class,
    GetMerchantActivationStatusResponseData.class,
    CustomerProfileResponseData.class,
    UpdateSplitTenderGroupResponseData.class,
    GetCustomerProfileIdsResponseData.class,
    UpdateCustomerProfileResponseData.class,
    GetCustomerProfileTransactionHistoryResponseData.class,
    CreateProfileTransactionResponseData.class,
    AuthenticateUserResponseData.class,
    UpdateCustomerPaymentProfileResponseData.class,
    SetMerchantConfigResponseData.class,
    DeleteCustomerShippingAddressResponseData.class
})
public class BaseResponseData {

    @XmlElement(name = "Successful")
    protected boolean successful;
    @XmlElement(name = "Messages")
    protected ArrayOfMessagesWS messages;

    /**
     * Gets the value of the successful property.
     * 
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * Sets the value of the successful property.
     * 
     */
    public void setSuccessful(boolean value) {
        this.successful = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMessagesWS }
     *     
     */
    public ArrayOfMessagesWS getMessages() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMessagesWS }
     *     
     */
    public void setMessages(ArrayOfMessagesWS value) {
        this.messages = value;
    }

}

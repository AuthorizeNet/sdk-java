
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseRequestData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ApiIntegration" type="{http://api.authorize.net/ANetApiWS/}ApiIntegration" minOccurs="0"/>
 *         &lt;element name="ApiVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuditUserID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FrontendServerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRequestData", propOrder = {
    "apiIntegration",
    "apiVersion",
    "clientIP",
    "customerIP",
    "auditUserID",
    "frontendServerName"
})
@XmlSeeAlso({
    ARBGetSubscriptionStatusRequestData.class,
    ValidatePaymentProfileRequestData.class,
    IsValidMerchantConfigGroupRequestData.class,
    GetCustomerProfileTransactionHistoryRequestData.class,
    ARBCreateSubscriptionRequestData.class,
    UpdateCustomerShippingAddressRequestData.class,
    GetTransListRequestData.class,
    CustomerPaymentProfileRequestData.class,
    GetCustomerShippingAddressRequestData.class,
    DeleteCustomerPaymentProfileRequestData.class,
    CustomerShippingAddressRequestData.class,
    UpdateCustomerProfileRequestData.class,
    ARBUpdateSubscriptionRequestData.class,
    ARBCancelSubscriptionRequestData.class,
    SearchCustomerProfilesRequestData.class,
    SetMerchantConfigRequestData.class,
    GetMerchantActivationStatusRequestData.class,
    IsValidMerchantConfigFieldRequestData.class,
    SearchCustomerProfilesAdvancedRequestData.class,
    GetUnsettledTransListRequestData.class,
    GetMerchantConfigRequestData.class,
    GetCustomerPaymentProfileRequestData.class,
    CustomerProfileRequestData.class,
    GetMerchantInfoRequestData.class,
    GetTransactionDetailsRequestData.class,
    GetCustomerProfileIdsRequestData.class,
    GetSettledBatchListRequestData.class,
    EncryptedFOPRequestData.class,
    SendCustomerEmailReceiptRequest.class,
    DeleteCustomerProfileRequestData.class,
    GetBatchStatisticsRequestData.class,
    DeleteCustomerShippingAddressRequestData.class,
    UpdateSplitTenderGroupRequestData.class,
    CreateProfileTransactionRequestData.class,
    ARBGetSubscriptionReportRequestData.class,
    AuthenticateUserRequestData.class,
    GetCustomerProfileRequestData.class,
    UpdateCustomerPaymentProfileRequestData.class,
    ApiMethodUsageRequestData.class
})
public class BaseRequestData {

    @XmlElement(name = "ApiIntegration")
    @XmlSchemaType(name = "string")
    protected ApiIntegration apiIntegration;
    @XmlElement(name = "ApiVersion")
    protected String apiVersion;
    @XmlElement(name = "ClientIP")
    protected String clientIP;
    @XmlElement(name = "CustomerIP")
    protected String customerIP;
    @XmlElement(name = "AuditUserID")
    protected long auditUserID;
    @XmlElement(name = "FrontendServerName")
    protected String frontendServerName;

    /**
     * Gets the value of the apiIntegration property.
     * 
     * @return
     *     possible object is
     *     {@link ApiIntegration }
     *     
     */
    public ApiIntegration getApiIntegration() {
        return apiIntegration;
    }

    /**
     * Sets the value of the apiIntegration property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiIntegration }
     *     
     */
    public void setApiIntegration(ApiIntegration value) {
        this.apiIntegration = value;
    }

    /**
     * Gets the value of the apiVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * Sets the value of the apiVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiVersion(String value) {
        this.apiVersion = value;
    }

    /**
     * Gets the value of the clientIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientIP() {
        return clientIP;
    }

    /**
     * Sets the value of the clientIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientIP(String value) {
        this.clientIP = value;
    }

    /**
     * Gets the value of the customerIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerIP() {
        return customerIP;
    }

    /**
     * Sets the value of the customerIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerIP(String value) {
        this.customerIP = value;
    }

    /**
     * Gets the value of the auditUserID property.
     * 
     */
    public long getAuditUserID() {
        return auditUserID;
    }

    /**
     * Sets the value of the auditUserID property.
     * 
     */
    public void setAuditUserID(long value) {
        this.auditUserID = value;
    }

    /**
     * Gets the value of the frontendServerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrontendServerName() {
        return frontendServerName;
    }

    /**
     * Sets the value of the frontendServerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrontendServerName(String value) {
        this.frontendServerName = value;
    }

}

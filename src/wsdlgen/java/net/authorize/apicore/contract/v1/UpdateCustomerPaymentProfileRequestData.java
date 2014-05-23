
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateCustomerPaymentProfileRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateCustomerPaymentProfileRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProfileID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PaymentProfileID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PaymentProfile" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerPaymentProfileType" minOccurs="0"/>
 *         &lt;element name="validationMode" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}validationModeEnum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateCustomerPaymentProfileRequestData", propOrder = {
    "merchantID",
    "profileID",
    "paymentProfileID",
    "paymentProfile",
    "validationMode"
})
public class UpdateCustomerPaymentProfileRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "ProfileID")
    protected int profileID;
    @XmlElement(name = "PaymentProfileID")
    protected int paymentProfileID;
    @XmlElement(name = "PaymentProfile")
    protected CustomerPaymentProfileType paymentProfile;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ValidationModeEnum validationMode;

    /**
     * Gets the value of the merchantID property.
     * 
     */
    public int getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     */
    public void setMerchantID(int value) {
        this.merchantID = value;
    }

    /**
     * Gets the value of the profileID property.
     * 
     */
    public int getProfileID() {
        return profileID;
    }

    /**
     * Sets the value of the profileID property.
     * 
     */
    public void setProfileID(int value) {
        this.profileID = value;
    }

    /**
     * Gets the value of the paymentProfileID property.
     * 
     */
    public int getPaymentProfileID() {
        return paymentProfileID;
    }

    /**
     * Sets the value of the paymentProfileID property.
     * 
     */
    public void setPaymentProfileID(int value) {
        this.paymentProfileID = value;
    }

    /**
     * Gets the value of the paymentProfile property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerPaymentProfileType }
     *     
     */
    public CustomerPaymentProfileType getPaymentProfile() {
        return paymentProfile;
    }

    /**
     * Sets the value of the paymentProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerPaymentProfileType }
     *     
     */
    public void setPaymentProfile(CustomerPaymentProfileType value) {
        this.paymentProfile = value;
    }

    /**
     * Gets the value of the validationMode property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationModeEnum }
     *     
     */
    public ValidationModeEnum getValidationMode() {
        return validationMode;
    }

    /**
     * Sets the value of the validationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationModeEnum }
     *     
     */
    public void setValidationMode(ValidationModeEnum value) {
        this.validationMode = value;
    }

}

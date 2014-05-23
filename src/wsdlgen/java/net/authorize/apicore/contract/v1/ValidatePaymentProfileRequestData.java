
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidatePaymentProfileRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidatePaymentProfileRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProfileID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentProfileID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValidationMode" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}validationModeEnum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidatePaymentProfileRequestData", propOrder = {
    "merchantID",
    "profileID",
    "paymentProfileID",
    "addressID",
    "cardCode",
    "validationMode"
})
public class ValidatePaymentProfileRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "ProfileID")
    protected String profileID;
    @XmlElement(name = "PaymentProfileID")
    protected String paymentProfileID;
    @XmlElement(name = "AddressID")
    protected String addressID;
    @XmlElement(name = "CardCode")
    protected String cardCode;
    @XmlElement(name = "ValidationMode", required = true)
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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfileID() {
        return profileID;
    }

    /**
     * Sets the value of the profileID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfileID(String value) {
        this.profileID = value;
    }

    /**
     * Gets the value of the paymentProfileID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentProfileID() {
        return paymentProfileID;
    }

    /**
     * Sets the value of the paymentProfileID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentProfileID(String value) {
        this.paymentProfileID = value;
    }

    /**
     * Gets the value of the addressID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressID() {
        return addressID;
    }

    /**
     * Sets the value of the addressID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressID(String value) {
        this.addressID = value;
    }

    /**
     * Gets the value of the cardCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardCode() {
        return cardCode;
    }

    /**
     * Sets the value of the cardCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardCode(String value) {
        this.cardCode = value;
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

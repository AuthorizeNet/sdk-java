
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerProfileRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerProfileRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Profile" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerProfileType" minOccurs="0"/>
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
@XmlType(name = "CustomerProfileRequestData", propOrder = {
    "merchantID",
    "profile",
    "validationMode"
})
public class CustomerProfileRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "Profile")
    protected CustomerProfileType profile;
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
     * Gets the value of the profile property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerProfileType }
     *     
     */
    public CustomerProfileType getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerProfileType }
     *     
     */
    public void setProfile(CustomerProfileType value) {
        this.profile = value;
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

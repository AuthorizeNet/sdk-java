
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerProfileResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerProfileResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="ProfileID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentProfileIDList" type="{http://api.authorize.net/ANetApiWS/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="ShippingAddressIDList" type="{http://api.authorize.net/ANetApiWS/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="ValidationDirectResponseList" type="{http://api.authorize.net/ANetApiWS/}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerProfileResponseData", propOrder = {
    "profileID",
    "paymentProfileIDList",
    "shippingAddressIDList",
    "validationDirectResponseList"
})
public class CustomerProfileResponseData
    extends BaseResponseData
{

    @XmlElement(name = "ProfileID")
    protected String profileID;
    @XmlElement(name = "PaymentProfileIDList")
    protected ArrayOfString paymentProfileIDList;
    @XmlElement(name = "ShippingAddressIDList")
    protected ArrayOfString shippingAddressIDList;
    @XmlElement(name = "ValidationDirectResponseList")
    protected ArrayOfString validationDirectResponseList;

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
     * Gets the value of the paymentProfileIDList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getPaymentProfileIDList() {
        return paymentProfileIDList;
    }

    /**
     * Sets the value of the paymentProfileIDList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setPaymentProfileIDList(ArrayOfString value) {
        this.paymentProfileIDList = value;
    }

    /**
     * Gets the value of the shippingAddressIDList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getShippingAddressIDList() {
        return shippingAddressIDList;
    }

    /**
     * Sets the value of the shippingAddressIDList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setShippingAddressIDList(ArrayOfString value) {
        this.shippingAddressIDList = value;
    }

    /**
     * Gets the value of the validationDirectResponseList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getValidationDirectResponseList() {
        return validationDirectResponseList;
    }

    /**
     * Sets the value of the validationDirectResponseList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setValidationDirectResponseList(ArrayOfString value) {
        this.validationDirectResponseList = value;
    }

}

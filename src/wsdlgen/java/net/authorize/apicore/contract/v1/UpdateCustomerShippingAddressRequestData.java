
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateCustomerShippingAddressRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateCustomerShippingAddressRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProfileID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AddressID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Address" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerAddressType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateCustomerShippingAddressRequestData", propOrder = {
    "merchantID",
    "profileID",
    "addressID",
    "address"
})
public class UpdateCustomerShippingAddressRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "ProfileID")
    protected int profileID;
    @XmlElement(name = "AddressID")
    protected int addressID;
    @XmlElement(name = "Address")
    protected CustomerAddressType address;

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
     * Gets the value of the addressID property.
     * 
     */
    public int getAddressID() {
        return addressID;
    }

    /**
     * Sets the value of the addressID property.
     * 
     */
    public void setAddressID(int value) {
        this.addressID = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAddressType }
     *     
     */
    public CustomerAddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAddressType }
     *     
     */
    public void setAddress(CustomerAddressType value) {
        this.address = value;
    }

}

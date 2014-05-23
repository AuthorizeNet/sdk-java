
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCustomerShippingAddressResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCustomerShippingAddressResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerAddressExType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCustomerShippingAddressResponseData", propOrder = {
    "address"
})
public class GetCustomerShippingAddressResponseData
    extends BaseResponseData
{

    @XmlElement(name = "Address")
    protected CustomerAddressExType address;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAddressExType }
     *     
     */
    public CustomerAddressExType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAddressExType }
     *     
     */
    public void setAddress(CustomerAddressExType value) {
        this.address = value;
    }

}

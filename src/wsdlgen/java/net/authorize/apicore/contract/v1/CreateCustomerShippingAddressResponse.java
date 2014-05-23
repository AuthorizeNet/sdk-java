
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreateCustomerShippingAddressResult" type="{http://api.authorize.net/ANetApiWS/}CustomerShippingAddressResponseData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "createCustomerShippingAddressResult"
})
@XmlRootElement(name = "CreateCustomerShippingAddressResponse")
public class CreateCustomerShippingAddressResponse {

    @XmlElement(name = "CreateCustomerShippingAddressResult")
    protected CustomerShippingAddressResponseData createCustomerShippingAddressResult;

    /**
     * Gets the value of the createCustomerShippingAddressResult property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerShippingAddressResponseData }
     *     
     */
    public CustomerShippingAddressResponseData getCreateCustomerShippingAddressResult() {
        return createCustomerShippingAddressResult;
    }

    /**
     * Sets the value of the createCustomerShippingAddressResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerShippingAddressResponseData }
     *     
     */
    public void setCreateCustomerShippingAddressResult(CustomerShippingAddressResponseData value) {
        this.createCustomerShippingAddressResult = value;
    }

}

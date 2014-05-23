
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
 *         &lt;element name="UpdateCustomerShippingAddressResult" type="{http://api.authorize.net/ANetApiWS/}UpdateCustomerShippingAddressResponseData" minOccurs="0"/>
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
    "updateCustomerShippingAddressResult"
})
@XmlRootElement(name = "UpdateCustomerShippingAddressResponse")
public class UpdateCustomerShippingAddressResponse {

    @XmlElement(name = "UpdateCustomerShippingAddressResult")
    protected UpdateCustomerShippingAddressResponseData updateCustomerShippingAddressResult;

    /**
     * Gets the value of the updateCustomerShippingAddressResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateCustomerShippingAddressResponseData }
     *     
     */
    public UpdateCustomerShippingAddressResponseData getUpdateCustomerShippingAddressResult() {
        return updateCustomerShippingAddressResult;
    }

    /**
     * Sets the value of the updateCustomerShippingAddressResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateCustomerShippingAddressResponseData }
     *     
     */
    public void setUpdateCustomerShippingAddressResult(UpdateCustomerShippingAddressResponseData value) {
        this.updateCustomerShippingAddressResult = value;
    }

}

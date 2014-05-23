
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
 *         &lt;element name="GetCustomerShippingAddressResult" type="{http://api.authorize.net/ANetApiWS/}GetCustomerShippingAddressResponseData" minOccurs="0"/>
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
    "getCustomerShippingAddressResult"
})
@XmlRootElement(name = "GetCustomerShippingAddressResponse")
public class GetCustomerShippingAddressResponse {

    @XmlElement(name = "GetCustomerShippingAddressResult")
    protected GetCustomerShippingAddressResponseData getCustomerShippingAddressResult;

    /**
     * Gets the value of the getCustomerShippingAddressResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerShippingAddressResponseData }
     *     
     */
    public GetCustomerShippingAddressResponseData getGetCustomerShippingAddressResult() {
        return getCustomerShippingAddressResult;
    }

    /**
     * Sets the value of the getCustomerShippingAddressResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerShippingAddressResponseData }
     *     
     */
    public void setGetCustomerShippingAddressResult(GetCustomerShippingAddressResponseData value) {
        this.getCustomerShippingAddressResult = value;
    }

}

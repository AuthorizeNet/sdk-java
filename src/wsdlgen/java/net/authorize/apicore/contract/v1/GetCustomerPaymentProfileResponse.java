
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
 *         &lt;element name="GetCustomerPaymentProfileResult" type="{http://api.authorize.net/ANetApiWS/}GetCustomerPaymentProfileResponseData" minOccurs="0"/>
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
    "getCustomerPaymentProfileResult"
})
@XmlRootElement(name = "GetCustomerPaymentProfileResponse")
public class GetCustomerPaymentProfileResponse {

    @XmlElement(name = "GetCustomerPaymentProfileResult")
    protected GetCustomerPaymentProfileResponseData getCustomerPaymentProfileResult;

    /**
     * Gets the value of the getCustomerPaymentProfileResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerPaymentProfileResponseData }
     *     
     */
    public GetCustomerPaymentProfileResponseData getGetCustomerPaymentProfileResult() {
        return getCustomerPaymentProfileResult;
    }

    /**
     * Sets the value of the getCustomerPaymentProfileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerPaymentProfileResponseData }
     *     
     */
    public void setGetCustomerPaymentProfileResult(GetCustomerPaymentProfileResponseData value) {
        this.getCustomerPaymentProfileResult = value;
    }

}

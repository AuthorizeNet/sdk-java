
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
 *         &lt;element name="UpdateCustomerPaymentProfileResult" type="{http://api.authorize.net/ANetApiWS/}UpdateCustomerPaymentProfileResponseData" minOccurs="0"/>
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
    "updateCustomerPaymentProfileResult"
})
@XmlRootElement(name = "UpdateCustomerPaymentProfileResponse")
public class UpdateCustomerPaymentProfileResponse {

    @XmlElement(name = "UpdateCustomerPaymentProfileResult")
    protected UpdateCustomerPaymentProfileResponseData updateCustomerPaymentProfileResult;

    /**
     * Gets the value of the updateCustomerPaymentProfileResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateCustomerPaymentProfileResponseData }
     *     
     */
    public UpdateCustomerPaymentProfileResponseData getUpdateCustomerPaymentProfileResult() {
        return updateCustomerPaymentProfileResult;
    }

    /**
     * Sets the value of the updateCustomerPaymentProfileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateCustomerPaymentProfileResponseData }
     *     
     */
    public void setUpdateCustomerPaymentProfileResult(UpdateCustomerPaymentProfileResponseData value) {
        this.updateCustomerPaymentProfileResult = value;
    }

}

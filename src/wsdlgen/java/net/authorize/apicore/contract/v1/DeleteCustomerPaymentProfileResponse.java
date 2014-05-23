
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
 *         &lt;element name="DeleteCustomerPaymentProfileResult" type="{http://api.authorize.net/ANetApiWS/}DeleteCustomerPaymentProfileResponseData" minOccurs="0"/>
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
    "deleteCustomerPaymentProfileResult"
})
@XmlRootElement(name = "DeleteCustomerPaymentProfileResponse")
public class DeleteCustomerPaymentProfileResponse {

    @XmlElement(name = "DeleteCustomerPaymentProfileResult")
    protected DeleteCustomerPaymentProfileResponseData deleteCustomerPaymentProfileResult;

    /**
     * Gets the value of the deleteCustomerPaymentProfileResult property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteCustomerPaymentProfileResponseData }
     *     
     */
    public DeleteCustomerPaymentProfileResponseData getDeleteCustomerPaymentProfileResult() {
        return deleteCustomerPaymentProfileResult;
    }

    /**
     * Sets the value of the deleteCustomerPaymentProfileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteCustomerPaymentProfileResponseData }
     *     
     */
    public void setDeleteCustomerPaymentProfileResult(DeleteCustomerPaymentProfileResponseData value) {
        this.deleteCustomerPaymentProfileResult = value;
    }

}

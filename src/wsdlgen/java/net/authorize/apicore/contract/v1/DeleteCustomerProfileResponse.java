
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
 *         &lt;element name="DeleteCustomerProfileResult" type="{http://api.authorize.net/ANetApiWS/}DeleteCustomerProfileResponseData" minOccurs="0"/>
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
    "deleteCustomerProfileResult"
})
@XmlRootElement(name = "DeleteCustomerProfileResponse")
public class DeleteCustomerProfileResponse {

    @XmlElement(name = "DeleteCustomerProfileResult")
    protected DeleteCustomerProfileResponseData deleteCustomerProfileResult;

    /**
     * Gets the value of the deleteCustomerProfileResult property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteCustomerProfileResponseData }
     *     
     */
    public DeleteCustomerProfileResponseData getDeleteCustomerProfileResult() {
        return deleteCustomerProfileResult;
    }

    /**
     * Sets the value of the deleteCustomerProfileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteCustomerProfileResponseData }
     *     
     */
    public void setDeleteCustomerProfileResult(DeleteCustomerProfileResponseData value) {
        this.deleteCustomerProfileResult = value;
    }

}

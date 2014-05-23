
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
 *         &lt;element name="ValidatePaymentProfileResult" type="{http://api.authorize.net/ANetApiWS/}ValidatePaymentProfileResponseData" minOccurs="0"/>
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
    "validatePaymentProfileResult"
})
@XmlRootElement(name = "ValidatePaymentProfileResponse")
public class ValidatePaymentProfileResponse {

    @XmlElement(name = "ValidatePaymentProfileResult")
    protected ValidatePaymentProfileResponseData validatePaymentProfileResult;

    /**
     * Gets the value of the validatePaymentProfileResult property.
     * 
     * @return
     *     possible object is
     *     {@link ValidatePaymentProfileResponseData }
     *     
     */
    public ValidatePaymentProfileResponseData getValidatePaymentProfileResult() {
        return validatePaymentProfileResult;
    }

    /**
     * Sets the value of the validatePaymentProfileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidatePaymentProfileResponseData }
     *     
     */
    public void setValidatePaymentProfileResult(ValidatePaymentProfileResponseData value) {
        this.validatePaymentProfileResult = value;
    }

}

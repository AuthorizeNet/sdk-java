
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
 *         &lt;element name="GetMerchantActivationStatusResult" type="{http://api.authorize.net/ANetApiWS/}GetMerchantActivationStatusResponseData" minOccurs="0"/>
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
    "getMerchantActivationStatusResult"
})
@XmlRootElement(name = "GetMerchantActivationStatusResponse")
public class GetMerchantActivationStatusResponse {

    @XmlElement(name = "GetMerchantActivationStatusResult")
    protected GetMerchantActivationStatusResponseData getMerchantActivationStatusResult;

    /**
     * Gets the value of the getMerchantActivationStatusResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetMerchantActivationStatusResponseData }
     *     
     */
    public GetMerchantActivationStatusResponseData getGetMerchantActivationStatusResult() {
        return getMerchantActivationStatusResult;
    }

    /**
     * Sets the value of the getMerchantActivationStatusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMerchantActivationStatusResponseData }
     *     
     */
    public void setGetMerchantActivationStatusResult(GetMerchantActivationStatusResponseData value) {
        this.getMerchantActivationStatusResult = value;
    }

}

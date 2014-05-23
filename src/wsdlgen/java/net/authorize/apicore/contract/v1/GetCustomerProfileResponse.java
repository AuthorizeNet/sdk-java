
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
 *         &lt;element name="GetCustomerProfileResult" type="{http://api.authorize.net/ANetApiWS/}GetCustomerProfileResponseData" minOccurs="0"/>
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
    "getCustomerProfileResult"
})
@XmlRootElement(name = "GetCustomerProfileResponse")
public class GetCustomerProfileResponse {

    @XmlElement(name = "GetCustomerProfileResult")
    protected GetCustomerProfileResponseData getCustomerProfileResult;

    /**
     * Gets the value of the getCustomerProfileResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerProfileResponseData }
     *     
     */
    public GetCustomerProfileResponseData getGetCustomerProfileResult() {
        return getCustomerProfileResult;
    }

    /**
     * Sets the value of the getCustomerProfileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerProfileResponseData }
     *     
     */
    public void setGetCustomerProfileResult(GetCustomerProfileResponseData value) {
        this.getCustomerProfileResult = value;
    }

}

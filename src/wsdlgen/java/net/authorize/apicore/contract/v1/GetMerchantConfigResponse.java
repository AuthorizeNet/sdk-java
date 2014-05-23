
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
 *         &lt;element name="GetMerchantConfigResult" type="{http://api.authorize.net/ANetApiWS/}GetMerchantConfigResponseData" minOccurs="0"/>
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
    "getMerchantConfigResult"
})
@XmlRootElement(name = "GetMerchantConfigResponse")
public class GetMerchantConfigResponse {

    @XmlElement(name = "GetMerchantConfigResult")
    protected GetMerchantConfigResponseData getMerchantConfigResult;

    /**
     * Gets the value of the getMerchantConfigResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetMerchantConfigResponseData }
     *     
     */
    public GetMerchantConfigResponseData getGetMerchantConfigResult() {
        return getMerchantConfigResult;
    }

    /**
     * Sets the value of the getMerchantConfigResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMerchantConfigResponseData }
     *     
     */
    public void setGetMerchantConfigResult(GetMerchantConfigResponseData value) {
        this.getMerchantConfigResult = value;
    }

}

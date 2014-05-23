
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
 *         &lt;element name="GetMerchantInfoResult" type="{http://api.authorize.net/ANetApiWS/}GetMerchantInfoResponseData" minOccurs="0"/>
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
    "getMerchantInfoResult"
})
@XmlRootElement(name = "GetMerchantInfoResponse")
public class GetMerchantInfoResponse {

    @XmlElement(name = "GetMerchantInfoResult")
    protected GetMerchantInfoResponseData getMerchantInfoResult;

    /**
     * Gets the value of the getMerchantInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetMerchantInfoResponseData }
     *     
     */
    public GetMerchantInfoResponseData getGetMerchantInfoResult() {
        return getMerchantInfoResult;
    }

    /**
     * Sets the value of the getMerchantInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMerchantInfoResponseData }
     *     
     */
    public void setGetMerchantInfoResult(GetMerchantInfoResponseData value) {
        this.getMerchantInfoResult = value;
    }

}

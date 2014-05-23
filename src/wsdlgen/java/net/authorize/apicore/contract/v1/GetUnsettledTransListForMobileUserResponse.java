
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
 *         &lt;element name="GetUnsettledTransListForMobileUserResult" type="{http://api.authorize.net/ANetApiWS/}GetUnsettledTransListResponseData" minOccurs="0"/>
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
    "getUnsettledTransListForMobileUserResult"
})
@XmlRootElement(name = "GetUnsettledTransListForMobileUserResponse")
public class GetUnsettledTransListForMobileUserResponse {

    @XmlElement(name = "GetUnsettledTransListForMobileUserResult")
    protected GetUnsettledTransListResponseData getUnsettledTransListForMobileUserResult;

    /**
     * Gets the value of the getUnsettledTransListForMobileUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetUnsettledTransListResponseData }
     *     
     */
    public GetUnsettledTransListResponseData getGetUnsettledTransListForMobileUserResult() {
        return getUnsettledTransListForMobileUserResult;
    }

    /**
     * Sets the value of the getUnsettledTransListForMobileUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUnsettledTransListResponseData }
     *     
     */
    public void setGetUnsettledTransListForMobileUserResult(GetUnsettledTransListResponseData value) {
        this.getUnsettledTransListForMobileUserResult = value;
    }

}


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
 *         &lt;element name="GetTransListForMobileUserResult" type="{http://api.authorize.net/ANetApiWS/}GetTransListResponseData" minOccurs="0"/>
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
    "getTransListForMobileUserResult"
})
@XmlRootElement(name = "GetTransListForMobileUserResponse")
public class GetTransListForMobileUserResponse {

    @XmlElement(name = "GetTransListForMobileUserResult")
    protected GetTransListResponseData getTransListForMobileUserResult;

    /**
     * Gets the value of the getTransListForMobileUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetTransListResponseData }
     *     
     */
    public GetTransListResponseData getGetTransListForMobileUserResult() {
        return getTransListForMobileUserResult;
    }

    /**
     * Sets the value of the getTransListForMobileUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTransListResponseData }
     *     
     */
    public void setGetTransListForMobileUserResult(GetTransListResponseData value) {
        this.getTransListForMobileUserResult = value;
    }

}

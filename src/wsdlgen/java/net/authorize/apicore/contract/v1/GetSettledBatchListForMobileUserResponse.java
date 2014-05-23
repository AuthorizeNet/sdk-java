
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
 *         &lt;element name="GetSettledBatchListForMobileUserResult" type="{http://api.authorize.net/ANetApiWS/}GetSettledBatchListResponseData" minOccurs="0"/>
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
    "getSettledBatchListForMobileUserResult"
})
@XmlRootElement(name = "GetSettledBatchListForMobileUserResponse")
public class GetSettledBatchListForMobileUserResponse {

    @XmlElement(name = "GetSettledBatchListForMobileUserResult")
    protected GetSettledBatchListResponseData getSettledBatchListForMobileUserResult;

    /**
     * Gets the value of the getSettledBatchListForMobileUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetSettledBatchListResponseData }
     *     
     */
    public GetSettledBatchListResponseData getGetSettledBatchListForMobileUserResult() {
        return getSettledBatchListForMobileUserResult;
    }

    /**
     * Sets the value of the getSettledBatchListForMobileUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSettledBatchListResponseData }
     *     
     */
    public void setGetSettledBatchListForMobileUserResult(GetSettledBatchListResponseData value) {
        this.getSettledBatchListForMobileUserResult = value;
    }

}

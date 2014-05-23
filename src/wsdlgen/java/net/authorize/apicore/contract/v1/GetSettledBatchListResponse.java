
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
 *         &lt;element name="GetSettledBatchListResult" type="{http://api.authorize.net/ANetApiWS/}GetSettledBatchListResponseData" minOccurs="0"/>
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
    "getSettledBatchListResult"
})
@XmlRootElement(name = "GetSettledBatchListResponse")
public class GetSettledBatchListResponse {

    @XmlElement(name = "GetSettledBatchListResult")
    protected GetSettledBatchListResponseData getSettledBatchListResult;

    /**
     * Gets the value of the getSettledBatchListResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetSettledBatchListResponseData }
     *     
     */
    public GetSettledBatchListResponseData getGetSettledBatchListResult() {
        return getSettledBatchListResult;
    }

    /**
     * Sets the value of the getSettledBatchListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSettledBatchListResponseData }
     *     
     */
    public void setGetSettledBatchListResult(GetSettledBatchListResponseData value) {
        this.getSettledBatchListResult = value;
    }

}

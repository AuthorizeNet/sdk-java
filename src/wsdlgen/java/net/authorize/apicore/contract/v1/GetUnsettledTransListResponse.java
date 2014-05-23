
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
 *         &lt;element name="GetUnsettledTransListResult" type="{http://api.authorize.net/ANetApiWS/}GetUnsettledTransListResponseData" minOccurs="0"/>
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
    "getUnsettledTransListResult"
})
@XmlRootElement(name = "GetUnsettledTransListResponse")
public class GetUnsettledTransListResponse {

    @XmlElement(name = "GetUnsettledTransListResult")
    protected GetUnsettledTransListResponseData getUnsettledTransListResult;

    /**
     * Gets the value of the getUnsettledTransListResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetUnsettledTransListResponseData }
     *     
     */
    public GetUnsettledTransListResponseData getGetUnsettledTransListResult() {
        return getUnsettledTransListResult;
    }

    /**
     * Sets the value of the getUnsettledTransListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUnsettledTransListResponseData }
     *     
     */
    public void setGetUnsettledTransListResult(GetUnsettledTransListResponseData value) {
        this.getUnsettledTransListResult = value;
    }

}

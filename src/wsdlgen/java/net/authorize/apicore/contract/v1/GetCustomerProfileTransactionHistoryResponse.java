
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
 *         &lt;element name="GetCustomerProfileTransactionHistoryResult" type="{http://api.authorize.net/ANetApiWS/}GetCustomerProfileTransactionHistoryResponseData" minOccurs="0"/>
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
    "getCustomerProfileTransactionHistoryResult"
})
@XmlRootElement(name = "GetCustomerProfileTransactionHistoryResponse")
public class GetCustomerProfileTransactionHistoryResponse {

    @XmlElement(name = "GetCustomerProfileTransactionHistoryResult")
    protected GetCustomerProfileTransactionHistoryResponseData getCustomerProfileTransactionHistoryResult;

    /**
     * Gets the value of the getCustomerProfileTransactionHistoryResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerProfileTransactionHistoryResponseData }
     *     
     */
    public GetCustomerProfileTransactionHistoryResponseData getGetCustomerProfileTransactionHistoryResult() {
        return getCustomerProfileTransactionHistoryResult;
    }

    /**
     * Sets the value of the getCustomerProfileTransactionHistoryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerProfileTransactionHistoryResponseData }
     *     
     */
    public void setGetCustomerProfileTransactionHistoryResult(GetCustomerProfileTransactionHistoryResponseData value) {
        this.getCustomerProfileTransactionHistoryResult = value;
    }

}

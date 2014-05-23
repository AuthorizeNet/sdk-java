
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
 *         &lt;element name="IsValidMerchantConfigGroupResult" type="{http://api.authorize.net/ANetApiWS/}IsValidMerchantConfigGroupResponseData" minOccurs="0"/>
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
    "isValidMerchantConfigGroupResult"
})
@XmlRootElement(name = "IsValidMerchantConfigGroupResponse")
public class IsValidMerchantConfigGroupResponse {

    @XmlElement(name = "IsValidMerchantConfigGroupResult")
    protected IsValidMerchantConfigGroupResponseData isValidMerchantConfigGroupResult;

    /**
     * Gets the value of the isValidMerchantConfigGroupResult property.
     * 
     * @return
     *     possible object is
     *     {@link IsValidMerchantConfigGroupResponseData }
     *     
     */
    public IsValidMerchantConfigGroupResponseData getIsValidMerchantConfigGroupResult() {
        return isValidMerchantConfigGroupResult;
    }

    /**
     * Sets the value of the isValidMerchantConfigGroupResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsValidMerchantConfigGroupResponseData }
     *     
     */
    public void setIsValidMerchantConfigGroupResult(IsValidMerchantConfigGroupResponseData value) {
        this.isValidMerchantConfigGroupResult = value;
    }

}

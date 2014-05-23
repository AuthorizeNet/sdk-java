
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
 *         &lt;element name="IsValidMerchantConfigFieldResult" type="{http://api.authorize.net/ANetApiWS/}IsValidMerchantConfigFieldResponseData" minOccurs="0"/>
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
    "isValidMerchantConfigFieldResult"
})
@XmlRootElement(name = "IsValidMerchantConfigFieldResponse")
public class IsValidMerchantConfigFieldResponse {

    @XmlElement(name = "IsValidMerchantConfigFieldResult")
    protected IsValidMerchantConfigFieldResponseData isValidMerchantConfigFieldResult;

    /**
     * Gets the value of the isValidMerchantConfigFieldResult property.
     * 
     * @return
     *     possible object is
     *     {@link IsValidMerchantConfigFieldResponseData }
     *     
     */
    public IsValidMerchantConfigFieldResponseData getIsValidMerchantConfigFieldResult() {
        return isValidMerchantConfigFieldResult;
    }

    /**
     * Sets the value of the isValidMerchantConfigFieldResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsValidMerchantConfigFieldResponseData }
     *     
     */
    public void setIsValidMerchantConfigFieldResult(IsValidMerchantConfigFieldResponseData value) {
        this.isValidMerchantConfigFieldResult = value;
    }

}

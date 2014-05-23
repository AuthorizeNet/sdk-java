
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
 *         &lt;element name="GetMerchantIPCommerceResult" type="{http://api.authorize.net/ANetApiWS/}MerchantIPCommerce" minOccurs="0"/>
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
    "getMerchantIPCommerceResult"
})
@XmlRootElement(name = "GetMerchantIPCommerceResponse")
public class GetMerchantIPCommerceResponse {

    @XmlElement(name = "GetMerchantIPCommerceResult")
    protected MerchantIPCommerce getMerchantIPCommerceResult;

    /**
     * Gets the value of the getMerchantIPCommerceResult property.
     * 
     * @return
     *     possible object is
     *     {@link MerchantIPCommerce }
     *     
     */
    public MerchantIPCommerce getGetMerchantIPCommerceResult() {
        return getMerchantIPCommerceResult;
    }

    /**
     * Sets the value of the getMerchantIPCommerceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerchantIPCommerce }
     *     
     */
    public void setGetMerchantIPCommerceResult(MerchantIPCommerce value) {
        this.getMerchantIPCommerceResult = value;
    }

}

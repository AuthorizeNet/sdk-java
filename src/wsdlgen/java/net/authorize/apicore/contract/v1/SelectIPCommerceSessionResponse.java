
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
 *         &lt;element name="SelectIPCommerceSessionResult" type="{http://api.authorize.net/ANetApiWS/}MerchantIPCommerceSession" minOccurs="0"/>
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
    "selectIPCommerceSessionResult"
})
@XmlRootElement(name = "SelectIPCommerceSessionResponse")
public class SelectIPCommerceSessionResponse {

    @XmlElement(name = "SelectIPCommerceSessionResult")
    protected MerchantIPCommerceSession selectIPCommerceSessionResult;

    /**
     * Gets the value of the selectIPCommerceSessionResult property.
     * 
     * @return
     *     possible object is
     *     {@link MerchantIPCommerceSession }
     *     
     */
    public MerchantIPCommerceSession getSelectIPCommerceSessionResult() {
        return selectIPCommerceSessionResult;
    }

    /**
     * Sets the value of the selectIPCommerceSessionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerchantIPCommerceSession }
     *     
     */
    public void setSelectIPCommerceSessionResult(MerchantIPCommerceSession value) {
        this.selectIPCommerceSessionResult = value;
    }

}

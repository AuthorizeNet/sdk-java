
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
 *         &lt;element name="SetMerchantConfigResult" type="{http://api.authorize.net/ANetApiWS/}SetMerchantConfigResponseData" minOccurs="0"/>
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
    "setMerchantConfigResult"
})
@XmlRootElement(name = "SetMerchantConfigResponse")
public class SetMerchantConfigResponse {

    @XmlElement(name = "SetMerchantConfigResult")
    protected SetMerchantConfigResponseData setMerchantConfigResult;

    /**
     * Gets the value of the setMerchantConfigResult property.
     * 
     * @return
     *     possible object is
     *     {@link SetMerchantConfigResponseData }
     *     
     */
    public SetMerchantConfigResponseData getSetMerchantConfigResult() {
        return setMerchantConfigResult;
    }

    /**
     * Sets the value of the setMerchantConfigResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SetMerchantConfigResponseData }
     *     
     */
    public void setSetMerchantConfigResult(SetMerchantConfigResponseData value) {
        this.setMerchantConfigResult = value;
    }

}

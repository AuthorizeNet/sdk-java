
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
 *         &lt;element name="ARBCancelSubscriptionResult" type="{http://api.authorize.net/ANetApiWS/}ARBCancelSubscriptionResponseData" minOccurs="0"/>
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
    "arbCancelSubscriptionResult"
})
@XmlRootElement(name = "ARBCancelSubscriptionResponse")
public class ARBCancelSubscriptionResponse {

    @XmlElement(name = "ARBCancelSubscriptionResult")
    protected ARBCancelSubscriptionResponseData arbCancelSubscriptionResult;

    /**
     * Gets the value of the arbCancelSubscriptionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ARBCancelSubscriptionResponseData }
     *     
     */
    public ARBCancelSubscriptionResponseData getARBCancelSubscriptionResult() {
        return arbCancelSubscriptionResult;
    }

    /**
     * Sets the value of the arbCancelSubscriptionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ARBCancelSubscriptionResponseData }
     *     
     */
    public void setARBCancelSubscriptionResult(ARBCancelSubscriptionResponseData value) {
        this.arbCancelSubscriptionResult = value;
    }

}

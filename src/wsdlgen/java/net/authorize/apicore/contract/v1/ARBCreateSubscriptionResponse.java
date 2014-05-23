
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
 *         &lt;element name="ARBCreateSubscriptionResult" type="{http://api.authorize.net/ANetApiWS/}ARBCreateSubscriptionResponseData" minOccurs="0"/>
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
    "arbCreateSubscriptionResult"
})
@XmlRootElement(name = "ARBCreateSubscriptionResponse")
public class ARBCreateSubscriptionResponse {

    @XmlElement(name = "ARBCreateSubscriptionResult")
    protected ARBCreateSubscriptionResponseData arbCreateSubscriptionResult;

    /**
     * Gets the value of the arbCreateSubscriptionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ARBCreateSubscriptionResponseData }
     *     
     */
    public ARBCreateSubscriptionResponseData getARBCreateSubscriptionResult() {
        return arbCreateSubscriptionResult;
    }

    /**
     * Sets the value of the arbCreateSubscriptionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ARBCreateSubscriptionResponseData }
     *     
     */
    public void setARBCreateSubscriptionResult(ARBCreateSubscriptionResponseData value) {
        this.arbCreateSubscriptionResult = value;
    }

}


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ARBUpdateSubscriptionRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ARBUpdateSubscriptionRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="SubscriptionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Subscr" type="{http://www.infospace.com/anet/Subscription.xsd}Subscription" minOccurs="0"/>
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ValMode" type="{http://api.authorize.net/ANetApiWS/}ARBSubscriptionValidationMode"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ARBUpdateSubscriptionRequestData", propOrder = {
    "subscriptionId",
    "subscr",
    "userID",
    "valMode"
})
public class ARBUpdateSubscriptionRequestData
    extends BaseRequestData
{

    @XmlElement(name = "SubscriptionId")
    protected int subscriptionId;
    @XmlElement(name = "Subscr")
    protected Subscription subscr;
    @XmlElement(name = "UserID")
    protected long userID;
    @XmlElement(name = "ValMode", required = true)
    @XmlSchemaType(name = "string")
    protected ARBSubscriptionValidationMode valMode;

    /**
     * Gets the value of the subscriptionId property.
     * 
     */
    public int getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the value of the subscriptionId property.
     * 
     */
    public void setSubscriptionId(int value) {
        this.subscriptionId = value;
    }

    /**
     * Gets the value of the subscr property.
     * 
     * @return
     *     possible object is
     *     {@link Subscription }
     *     
     */
    public Subscription getSubscr() {
        return subscr;
    }

    /**
     * Sets the value of the subscr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subscription }
     *     
     */
    public void setSubscr(Subscription value) {
        this.subscr = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     */
    public long getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     */
    public void setUserID(long value) {
        this.userID = value;
    }

    /**
     * Gets the value of the valMode property.
     * 
     * @return
     *     possible object is
     *     {@link ARBSubscriptionValidationMode }
     *     
     */
    public ARBSubscriptionValidationMode getValMode() {
        return valMode;
    }

    /**
     * Sets the value of the valMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ARBSubscriptionValidationMode }
     *     
     */
    public void setValMode(ARBSubscriptionValidationMode value) {
        this.valMode = value;
    }

}

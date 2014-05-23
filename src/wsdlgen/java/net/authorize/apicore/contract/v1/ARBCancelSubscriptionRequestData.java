
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ARBCancelSubscriptionRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ARBCancelSubscriptionRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="SubscriptionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ARBCancelSubscriptionRequestData", propOrder = {
    "subscriptionId",
    "userID",
    "merchantID"
})
public class ARBCancelSubscriptionRequestData
    extends BaseRequestData
{

    @XmlElement(name = "SubscriptionId")
    protected int subscriptionId;
    @XmlElement(name = "UserID")
    protected long userID;
    @XmlElement(name = "MerchantID")
    protected long merchantID;

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
     * Gets the value of the merchantID property.
     * 
     */
    public long getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     */
    public void setMerchantID(long value) {
        this.merchantID = value;
    }

}

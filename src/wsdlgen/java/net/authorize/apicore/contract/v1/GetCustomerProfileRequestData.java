
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCustomerProfileRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCustomerProfileRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProfileID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UnmaskedExpDate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="BaseProfileOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCustomerProfileRequestData", propOrder = {
    "merchantID",
    "profileID",
    "unmaskedExpDate",
    "baseProfileOnly"
})
public class GetCustomerProfileRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "ProfileID")
    protected int profileID;
    @XmlElement(name = "UnmaskedExpDate")
    protected boolean unmaskedExpDate;
    @XmlElement(name = "BaseProfileOnly")
    protected boolean baseProfileOnly;

    /**
     * Gets the value of the merchantID property.
     * 
     */
    public int getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     */
    public void setMerchantID(int value) {
        this.merchantID = value;
    }

    /**
     * Gets the value of the profileID property.
     * 
     */
    public int getProfileID() {
        return profileID;
    }

    /**
     * Sets the value of the profileID property.
     * 
     */
    public void setProfileID(int value) {
        this.profileID = value;
    }

    /**
     * Gets the value of the unmaskedExpDate property.
     * 
     */
    public boolean isUnmaskedExpDate() {
        return unmaskedExpDate;
    }

    /**
     * Sets the value of the unmaskedExpDate property.
     * 
     */
    public void setUnmaskedExpDate(boolean value) {
        this.unmaskedExpDate = value;
    }

    /**
     * Gets the value of the baseProfileOnly property.
     * 
     */
    public boolean isBaseProfileOnly() {
        return baseProfileOnly;
    }

    /**
     * Sets the value of the baseProfileOnly property.
     * 
     */
    public void setBaseProfileOnly(boolean value) {
        this.baseProfileOnly = value;
    }

}


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
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AnetUserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SessionToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sGUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "merchantID",
    "anetUserID",
    "sVersion",
    "sessionToken",
    "sguid"
})
@XmlRootElement(name = "InsertIPCommerceSession")
public class InsertIPCommerceSession {

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "AnetUserID")
    protected int anetUserID;
    protected String sVersion;
    @XmlElement(name = "SessionToken")
    protected String sessionToken;
    @XmlElement(name = "sGUID")
    protected String sguid;

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
     * Gets the value of the anetUserID property.
     * 
     */
    public int getAnetUserID() {
        return anetUserID;
    }

    /**
     * Sets the value of the anetUserID property.
     * 
     */
    public void setAnetUserID(int value) {
        this.anetUserID = value;
    }

    /**
     * Gets the value of the sVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSVersion() {
        return sVersion;
    }

    /**
     * Sets the value of the sVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSVersion(String value) {
        this.sVersion = value;
    }

    /**
     * Gets the value of the sessionToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionToken() {
        return sessionToken;
    }

    /**
     * Sets the value of the sessionToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionToken(String value) {
        this.sessionToken = value;
    }

    /**
     * Gets the value of the sguid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGUID() {
        return sguid;
    }

    /**
     * Sets the value of the sguid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGUID(String value) {
        this.sguid = value;
    }

}

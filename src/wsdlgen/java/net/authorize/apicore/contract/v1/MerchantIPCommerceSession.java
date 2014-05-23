
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MerchantIPCommerceSession complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantIPCommerceSession">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AnetUserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="HashVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ModuleSignOnUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecurityHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MerchantIPCommerceSession", propOrder = {
    "merchantID",
    "anetUserID",
    "hashVersion",
    "moduleSignOnUrl",
    "securityHash"
})
public class MerchantIPCommerceSession {

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "AnetUserID")
    protected int anetUserID;
    @XmlElement(name = "HashVersion")
    protected String hashVersion;
    @XmlElement(name = "ModuleSignOnUrl")
    protected String moduleSignOnUrl;
    @XmlElement(name = "SecurityHash")
    protected String securityHash;

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
     * Gets the value of the hashVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHashVersion() {
        return hashVersion;
    }

    /**
     * Sets the value of the hashVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHashVersion(String value) {
        this.hashVersion = value;
    }

    /**
     * Gets the value of the moduleSignOnUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleSignOnUrl() {
        return moduleSignOnUrl;
    }

    /**
     * Sets the value of the moduleSignOnUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleSignOnUrl(String value) {
        this.moduleSignOnUrl = value;
    }

    /**
     * Gets the value of the securityHash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityHash() {
        return securityHash;
    }

    /**
     * Sets the value of the securityHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityHash(String value) {
        this.securityHash = value;
    }

}

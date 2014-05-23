
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
 *         &lt;element name="AuditUserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CutOffTimeInMinutes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IPAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "auditUserID",
    "cutOffTimeInMinutes",
    "ipAddress"
})
@XmlRootElement(name = "UpdateMerchantBatchCutOffTime")
public class UpdateMerchantBatchCutOffTime {

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "AuditUserID")
    protected int auditUserID;
    @XmlElement(name = "CutOffTimeInMinutes")
    protected int cutOffTimeInMinutes;
    @XmlElement(name = "IPAddress")
    protected String ipAddress;

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
     * Gets the value of the auditUserID property.
     * 
     */
    public int getAuditUserID() {
        return auditUserID;
    }

    /**
     * Sets the value of the auditUserID property.
     * 
     */
    public void setAuditUserID(int value) {
        this.auditUserID = value;
    }

    /**
     * Gets the value of the cutOffTimeInMinutes property.
     * 
     */
    public int getCutOffTimeInMinutes() {
        return cutOffTimeInMinutes;
    }

    /**
     * Sets the value of the cutOffTimeInMinutes property.
     * 
     */
    public void setCutOffTimeInMinutes(int value) {
        this.cutOffTimeInMinutes = value;
    }

    /**
     * Gets the value of the ipAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPAddress() {
        return ipAddress;
    }

    /**
     * Sets the value of the ipAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPAddress(String value) {
        this.ipAddress = value;
    }

}

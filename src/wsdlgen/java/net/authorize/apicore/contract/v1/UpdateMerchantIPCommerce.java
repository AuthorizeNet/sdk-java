
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="LastUpdatedAuditUserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StartSyncDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "lastUpdatedAuditUserID",
    "startSyncDate",
    "active",
    "ipAddress"
})
@XmlRootElement(name = "UpdateMerchantIPCommerce")
public class UpdateMerchantIPCommerce {

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "LastUpdatedAuditUserID")
    protected int lastUpdatedAuditUserID;
    @XmlElement(name = "StartSyncDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startSyncDate;
    @XmlElement(name = "Active")
    protected boolean active;
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
     * Gets the value of the lastUpdatedAuditUserID property.
     * 
     */
    public int getLastUpdatedAuditUserID() {
        return lastUpdatedAuditUserID;
    }

    /**
     * Sets the value of the lastUpdatedAuditUserID property.
     * 
     */
    public void setLastUpdatedAuditUserID(int value) {
        this.lastUpdatedAuditUserID = value;
    }

    /**
     * Gets the value of the startSyncDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartSyncDate() {
        return startSyncDate;
    }

    /**
     * Sets the value of the startSyncDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartSyncDate(XMLGregorianCalendar value) {
        this.startSyncDate = value;
    }

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
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

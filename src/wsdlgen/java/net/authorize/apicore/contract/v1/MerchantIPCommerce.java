
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MerchantIPCommerce complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantIPCommerce">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MerchantProfileID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LastUpdatedAuditUserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SyncStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceStatusID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Validated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LastValidationCheck" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MerchantIPCommerce", propOrder = {
    "merchantID",
    "merchantProfileID",
    "dateCreated",
    "lastUpdated",
    "lastUpdatedAuditUserID",
    "syncStartDate",
    "active",
    "email",
    "serviceStatusID",
    "validated",
    "lastValidationCheck"
})
public class MerchantIPCommerce {

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "MerchantProfileID")
    protected String merchantProfileID;
    @XmlElement(name = "DateCreated", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreated;
    @XmlElement(name = "LastUpdated", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdated;
    @XmlElement(name = "LastUpdatedAuditUserID")
    protected int lastUpdatedAuditUserID;
    @XmlElement(name = "SyncStartDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar syncStartDate;
    @XmlElement(name = "Active")
    protected boolean active;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "ServiceStatusID")
    protected int serviceStatusID;
    @XmlElement(name = "Validated")
    protected boolean validated;
    @XmlElement(name = "LastValidationCheck", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastValidationCheck;

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
     * Gets the value of the merchantProfileID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantProfileID() {
        return merchantProfileID;
    }

    /**
     * Sets the value of the merchantProfileID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantProfileID(String value) {
        this.merchantProfileID = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreated(XMLGregorianCalendar value) {
        this.dateCreated = value;
    }

    /**
     * Gets the value of the lastUpdated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the value of the lastUpdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdated(XMLGregorianCalendar value) {
        this.lastUpdated = value;
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
     * Gets the value of the syncStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSyncStartDate() {
        return syncStartDate;
    }

    /**
     * Sets the value of the syncStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSyncStartDate(XMLGregorianCalendar value) {
        this.syncStartDate = value;
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
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the serviceStatusID property.
     * 
     */
    public int getServiceStatusID() {
        return serviceStatusID;
    }

    /**
     * Sets the value of the serviceStatusID property.
     * 
     */
    public void setServiceStatusID(int value) {
        this.serviceStatusID = value;
    }

    /**
     * Gets the value of the validated property.
     * 
     */
    public boolean isValidated() {
        return validated;
    }

    /**
     * Sets the value of the validated property.
     * 
     */
    public void setValidated(boolean value) {
        this.validated = value;
    }

    /**
     * Gets the value of the lastValidationCheck property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastValidationCheck() {
        return lastValidationCheck;
    }

    /**
     * Sets the value of the lastValidationCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastValidationCheck(XMLGregorianCalendar value) {
        this.lastValidationCheck = value;
    }

}


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchCustomerProfilesOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchCustomerProfilesOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RowLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RowOffset" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MerchantCustomerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProfileId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SortMethod" type="{http://api.authorize.net/ANetApiWS/}SearchCustomerProfilesSortMethod"/>
 *         &lt;element name="SortDescending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchCustomerProfilesOptions", propOrder = {
    "rowLimit",
    "rowOffset",
    "merchantCustomerId",
    "profileId",
    "description",
    "email",
    "sortMethod",
    "sortDescending"
})
public class SearchCustomerProfilesOptions {

    @XmlElement(name = "RowLimit")
    protected int rowLimit;
    @XmlElement(name = "RowOffset")
    protected int rowOffset;
    @XmlElement(name = "MerchantCustomerId")
    protected String merchantCustomerId;
    @XmlElement(name = "ProfileId")
    protected int profileId;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "SortMethod", required = true)
    @XmlSchemaType(name = "string")
    protected SearchCustomerProfilesSortMethod sortMethod;
    @XmlElement(name = "SortDescending")
    protected boolean sortDescending;

    /**
     * Gets the value of the rowLimit property.
     * 
     */
    public int getRowLimit() {
        return rowLimit;
    }

    /**
     * Sets the value of the rowLimit property.
     * 
     */
    public void setRowLimit(int value) {
        this.rowLimit = value;
    }

    /**
     * Gets the value of the rowOffset property.
     * 
     */
    public int getRowOffset() {
        return rowOffset;
    }

    /**
     * Sets the value of the rowOffset property.
     * 
     */
    public void setRowOffset(int value) {
        this.rowOffset = value;
    }

    /**
     * Gets the value of the merchantCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantCustomerId() {
        return merchantCustomerId;
    }

    /**
     * Sets the value of the merchantCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantCustomerId(String value) {
        this.merchantCustomerId = value;
    }

    /**
     * Gets the value of the profileId property.
     * 
     */
    public int getProfileId() {
        return profileId;
    }

    /**
     * Sets the value of the profileId property.
     * 
     */
    public void setProfileId(int value) {
        this.profileId = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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
     * Gets the value of the sortMethod property.
     * 
     * @return
     *     possible object is
     *     {@link SearchCustomerProfilesSortMethod }
     *     
     */
    public SearchCustomerProfilesSortMethod getSortMethod() {
        return sortMethod;
    }

    /**
     * Sets the value of the sortMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCustomerProfilesSortMethod }
     *     
     */
    public void setSortMethod(SearchCustomerProfilesSortMethod value) {
        this.sortMethod = value;
    }

    /**
     * Gets the value of the sortDescending property.
     * 
     */
    public boolean isSortDescending() {
        return sortDescending;
    }

    /**
     * Sets the value of the sortDescending property.
     * 
     */
    public void setSortDescending(boolean value) {
        this.sortDescending = value;
    }

}

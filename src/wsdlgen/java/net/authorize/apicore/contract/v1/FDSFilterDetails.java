
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FDSFilterDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FDSFilterDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FilterConfigID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FilterActionID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FilterID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FilterTypeID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FilterNameSpecific" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FilterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FDSFilterDetails", propOrder = {
    "filterConfigID",
    "filterActionID",
    "filterID",
    "filterTypeID",
    "filterNameSpecific",
    "filterName"
})
public class FDSFilterDetails {

    @XmlElement(name = "FilterConfigID")
    protected int filterConfigID;
    @XmlElement(name = "FilterActionID")
    protected int filterActionID;
    @XmlElement(name = "FilterID")
    protected int filterID;
    @XmlElement(name = "FilterTypeID")
    protected int filterTypeID;
    @XmlElement(name = "FilterNameSpecific")
    protected String filterNameSpecific;
    @XmlElement(name = "FilterName")
    protected String filterName;

    /**
     * Gets the value of the filterConfigID property.
     * 
     */
    public int getFilterConfigID() {
        return filterConfigID;
    }

    /**
     * Sets the value of the filterConfigID property.
     * 
     */
    public void setFilterConfigID(int value) {
        this.filterConfigID = value;
    }

    /**
     * Gets the value of the filterActionID property.
     * 
     */
    public int getFilterActionID() {
        return filterActionID;
    }

    /**
     * Sets the value of the filterActionID property.
     * 
     */
    public void setFilterActionID(int value) {
        this.filterActionID = value;
    }

    /**
     * Gets the value of the filterID property.
     * 
     */
    public int getFilterID() {
        return filterID;
    }

    /**
     * Sets the value of the filterID property.
     * 
     */
    public void setFilterID(int value) {
        this.filterID = value;
    }

    /**
     * Gets the value of the filterTypeID property.
     * 
     */
    public int getFilterTypeID() {
        return filterTypeID;
    }

    /**
     * Sets the value of the filterTypeID property.
     * 
     */
    public void setFilterTypeID(int value) {
        this.filterTypeID = value;
    }

    /**
     * Gets the value of the filterNameSpecific property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterNameSpecific() {
        return filterNameSpecific;
    }

    /**
     * Sets the value of the filterNameSpecific property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterNameSpecific(String value) {
        this.filterNameSpecific = value;
    }

    /**
     * Gets the value of the filterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterName() {
        return filterName;
    }

    /**
     * Sets the value of the filterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterName(String value) {
        this.filterName = value;
    }

}

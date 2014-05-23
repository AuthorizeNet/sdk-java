
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeZoneData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeZoneData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TimeZoneInfoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OlsonTimeZoneId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StandardTimeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DayLightSavingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StdAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DstAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UseDST" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="BaseUtcOffset" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DstDeltaInMins" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DstStartMth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DstStartWkOfMth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DstStartDayOfWk" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DstStartTimeInMins" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DstEndMth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DstEndWkOfMth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DstEndDayOfWk" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DstEndTimeInMins" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsDst" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeZoneData", propOrder = {
    "id",
    "timeZoneInfoId",
    "olsonTimeZoneId",
    "standardTimeName",
    "dayLightSavingName",
    "displayName",
    "stdAbbreviation",
    "dstAbbreviation",
    "useDST",
    "baseUtcOffset",
    "dstDeltaInMins",
    "dstStartMth",
    "dstStartWkOfMth",
    "dstStartDayOfWk",
    "dstStartTimeInMins",
    "dstEndMth",
    "dstEndWkOfMth",
    "dstEndDayOfWk",
    "dstEndTimeInMins",
    "isDst"
})
public class TimeZoneData {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "TimeZoneInfoId")
    protected String timeZoneInfoId;
    @XmlElement(name = "OlsonTimeZoneId")
    protected String olsonTimeZoneId;
    @XmlElement(name = "StandardTimeName")
    protected String standardTimeName;
    @XmlElement(name = "DayLightSavingName")
    protected String dayLightSavingName;
    @XmlElement(name = "DisplayName")
    protected String displayName;
    @XmlElement(name = "StdAbbreviation")
    protected String stdAbbreviation;
    @XmlElement(name = "DstAbbreviation")
    protected String dstAbbreviation;
    @XmlElement(name = "UseDST")
    protected boolean useDST;
    @XmlElement(name = "BaseUtcOffset")
    protected int baseUtcOffset;
    @XmlElement(name = "DstDeltaInMins")
    protected int dstDeltaInMins;
    @XmlElement(name = "DstStartMth")
    protected int dstStartMth;
    @XmlElement(name = "DstStartWkOfMth")
    protected int dstStartWkOfMth;
    @XmlElement(name = "DstStartDayOfWk")
    protected int dstStartDayOfWk;
    @XmlElement(name = "DstStartTimeInMins")
    protected int dstStartTimeInMins;
    @XmlElement(name = "DstEndMth")
    protected int dstEndMth;
    @XmlElement(name = "DstEndWkOfMth")
    protected int dstEndWkOfMth;
    @XmlElement(name = "DstEndDayOfWk")
    protected int dstEndDayOfWk;
    @XmlElement(name = "DstEndTimeInMins")
    protected int dstEndTimeInMins;
    @XmlElement(name = "IsDst")
    protected boolean isDst;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setID(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the timeZoneInfoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZoneInfoId() {
        return timeZoneInfoId;
    }

    /**
     * Sets the value of the timeZoneInfoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZoneInfoId(String value) {
        this.timeZoneInfoId = value;
    }

    /**
     * Gets the value of the olsonTimeZoneId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOlsonTimeZoneId() {
        return olsonTimeZoneId;
    }

    /**
     * Sets the value of the olsonTimeZoneId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOlsonTimeZoneId(String value) {
        this.olsonTimeZoneId = value;
    }

    /**
     * Gets the value of the standardTimeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandardTimeName() {
        return standardTimeName;
    }

    /**
     * Sets the value of the standardTimeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandardTimeName(String value) {
        this.standardTimeName = value;
    }

    /**
     * Gets the value of the dayLightSavingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayLightSavingName() {
        return dayLightSavingName;
    }

    /**
     * Sets the value of the dayLightSavingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayLightSavingName(String value) {
        this.dayLightSavingName = value;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Gets the value of the stdAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStdAbbreviation() {
        return stdAbbreviation;
    }

    /**
     * Sets the value of the stdAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStdAbbreviation(String value) {
        this.stdAbbreviation = value;
    }

    /**
     * Gets the value of the dstAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDstAbbreviation() {
        return dstAbbreviation;
    }

    /**
     * Sets the value of the dstAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDstAbbreviation(String value) {
        this.dstAbbreviation = value;
    }

    /**
     * Gets the value of the useDST property.
     * 
     */
    public boolean isUseDST() {
        return useDST;
    }

    /**
     * Sets the value of the useDST property.
     * 
     */
    public void setUseDST(boolean value) {
        this.useDST = value;
    }

    /**
     * Gets the value of the baseUtcOffset property.
     * 
     */
    public int getBaseUtcOffset() {
        return baseUtcOffset;
    }

    /**
     * Sets the value of the baseUtcOffset property.
     * 
     */
    public void setBaseUtcOffset(int value) {
        this.baseUtcOffset = value;
    }

    /**
     * Gets the value of the dstDeltaInMins property.
     * 
     */
    public int getDstDeltaInMins() {
        return dstDeltaInMins;
    }

    /**
     * Sets the value of the dstDeltaInMins property.
     * 
     */
    public void setDstDeltaInMins(int value) {
        this.dstDeltaInMins = value;
    }

    /**
     * Gets the value of the dstStartMth property.
     * 
     */
    public int getDstStartMth() {
        return dstStartMth;
    }

    /**
     * Sets the value of the dstStartMth property.
     * 
     */
    public void setDstStartMth(int value) {
        this.dstStartMth = value;
    }

    /**
     * Gets the value of the dstStartWkOfMth property.
     * 
     */
    public int getDstStartWkOfMth() {
        return dstStartWkOfMth;
    }

    /**
     * Sets the value of the dstStartWkOfMth property.
     * 
     */
    public void setDstStartWkOfMth(int value) {
        this.dstStartWkOfMth = value;
    }

    /**
     * Gets the value of the dstStartDayOfWk property.
     * 
     */
    public int getDstStartDayOfWk() {
        return dstStartDayOfWk;
    }

    /**
     * Sets the value of the dstStartDayOfWk property.
     * 
     */
    public void setDstStartDayOfWk(int value) {
        this.dstStartDayOfWk = value;
    }

    /**
     * Gets the value of the dstStartTimeInMins property.
     * 
     */
    public int getDstStartTimeInMins() {
        return dstStartTimeInMins;
    }

    /**
     * Sets the value of the dstStartTimeInMins property.
     * 
     */
    public void setDstStartTimeInMins(int value) {
        this.dstStartTimeInMins = value;
    }

    /**
     * Gets the value of the dstEndMth property.
     * 
     */
    public int getDstEndMth() {
        return dstEndMth;
    }

    /**
     * Sets the value of the dstEndMth property.
     * 
     */
    public void setDstEndMth(int value) {
        this.dstEndMth = value;
    }

    /**
     * Gets the value of the dstEndWkOfMth property.
     * 
     */
    public int getDstEndWkOfMth() {
        return dstEndWkOfMth;
    }

    /**
     * Sets the value of the dstEndWkOfMth property.
     * 
     */
    public void setDstEndWkOfMth(int value) {
        this.dstEndWkOfMth = value;
    }

    /**
     * Gets the value of the dstEndDayOfWk property.
     * 
     */
    public int getDstEndDayOfWk() {
        return dstEndDayOfWk;
    }

    /**
     * Sets the value of the dstEndDayOfWk property.
     * 
     */
    public void setDstEndDayOfWk(int value) {
        this.dstEndDayOfWk = value;
    }

    /**
     * Gets the value of the dstEndTimeInMins property.
     * 
     */
    public int getDstEndTimeInMins() {
        return dstEndTimeInMins;
    }

    /**
     * Sets the value of the dstEndTimeInMins property.
     * 
     */
    public void setDstEndTimeInMins(int value) {
        this.dstEndTimeInMins = value;
    }

    /**
     * Gets the value of the isDst property.
     * 
     */
    public boolean isIsDst() {
        return isDst;
    }

    /**
     * Sets the value of the isDst property.
     * 
     */
    public void setIsDst(boolean value) {
        this.isDst = value;
    }

}

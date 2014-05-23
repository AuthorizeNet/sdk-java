
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Recurrence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Recurrence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Interval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="NumRecurrence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NumRecurred" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NextRunDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LastRunDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ARBStatusID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Recurrence", namespace = "http://www.infospace.com/anet/Subscription.xsd", propOrder = {
    "unit",
    "interval",
    "startDate",
    "endDate",
    "numRecurrence",
    "numRecurred",
    "nextRunDate",
    "lastRunDate",
    "arbStatusID"
})
public class Recurrence {

    @XmlElement(name = "Unit")
    protected String unit;
    @XmlElement(name = "Interval")
    protected int interval;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "NumRecurrence")
    protected int numRecurrence;
    @XmlElement(name = "NumRecurred")
    protected int numRecurred;
    @XmlElement(name = "NextRunDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextRunDate;
    @XmlElement(name = "LastRunDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastRunDate;
    @XmlElement(name = "ARBStatusID")
    protected int arbStatusID;

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Gets the value of the interval property.
     * 
     */
    public int getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     */
    public void setInterval(int value) {
        this.interval = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the numRecurrence property.
     * 
     */
    public int getNumRecurrence() {
        return numRecurrence;
    }

    /**
     * Sets the value of the numRecurrence property.
     * 
     */
    public void setNumRecurrence(int value) {
        this.numRecurrence = value;
    }

    /**
     * Gets the value of the numRecurred property.
     * 
     */
    public int getNumRecurred() {
        return numRecurred;
    }

    /**
     * Sets the value of the numRecurred property.
     * 
     */
    public void setNumRecurred(int value) {
        this.numRecurred = value;
    }

    /**
     * Gets the value of the nextRunDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextRunDate() {
        return nextRunDate;
    }

    /**
     * Sets the value of the nextRunDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextRunDate(XMLGregorianCalendar value) {
        this.nextRunDate = value;
    }

    /**
     * Gets the value of the lastRunDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastRunDate() {
        return lastRunDate;
    }

    /**
     * Sets the value of the lastRunDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastRunDate(XMLGregorianCalendar value) {
        this.lastRunDate = value;
    }

    /**
     * Gets the value of the arbStatusID property.
     * 
     */
    public int getARBStatusID() {
        return arbStatusID;
    }

    /**
     * Sets the value of the arbStatusID property.
     * 
     */
    public void setARBStatusID(int value) {
        this.arbStatusID = value;
    }

}

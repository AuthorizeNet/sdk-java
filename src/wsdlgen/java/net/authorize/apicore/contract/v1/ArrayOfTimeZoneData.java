
package net.authorize.apicore.contract.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTimeZoneData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTimeZoneData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TimeZoneData" type="{http://api.authorize.net/ANetApiWS/}TimeZoneData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTimeZoneData", propOrder = {
    "timeZoneData"
})
public class ArrayOfTimeZoneData {

    @XmlElement(name = "TimeZoneData", nillable = true)
    protected List<TimeZoneData> timeZoneData;

    /**
     * Gets the value of the timeZoneData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeZoneData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeZoneData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimeZoneData }
     * 
     * 
     */
    public List<TimeZoneData> getTimeZoneData() {
        if (timeZoneData == null) {
            timeZoneData = new ArrayList<TimeZoneData>();
        }
        return this.timeZoneData;
    }

}

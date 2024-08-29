//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.08.29 at 03:15:31 AM IST 
//


package net.authorize.api.contract.v1;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFDSFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFDSFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FDSFilter" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}FDSFilterType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFDSFilter", propOrder = {
    "fdsFilter"
})
public class ArrayOfFDSFilter {

    @XmlElement(name = "FDSFilter")
    protected List<FDSFilterType> fdsFilter;

    /**
     * Gets the value of the fdsFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fdsFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFDSFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FDSFilterType }
     * 
     * 
     */
    public List<FDSFilterType> getFDSFilter() {
        if (fdsFilter == null) {
            fdsFilter = new ArrayList<FDSFilterType>();
        }
        return this.fdsFilter;
    }

}

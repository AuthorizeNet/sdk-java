
package net.authorize.apicore.contract.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFDSFilterDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFDSFilterDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FDSFilterDetails" type="{http://api.authorize.net/ANetApiWS/}FDSFilterDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFDSFilterDetails", propOrder = {
    "fdsFilterDetails"
})
public class ArrayOfFDSFilterDetails {

    @XmlElement(name = "FDSFilterDetails", nillable = true)
    protected List<FDSFilterDetails> fdsFilterDetails;

    /**
     * Gets the value of the fdsFilterDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fdsFilterDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFDSFilterDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FDSFilterDetails }
     * 
     * 
     */
    public List<FDSFilterDetails> getFDSFilterDetails() {
        if (fdsFilterDetails == null) {
            fdsFilterDetails = new ArrayList<FDSFilterDetails>();
        }
        return this.fdsFilterDetails;
    }

}

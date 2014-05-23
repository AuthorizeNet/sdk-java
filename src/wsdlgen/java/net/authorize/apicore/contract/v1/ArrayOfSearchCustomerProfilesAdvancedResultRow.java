
package net.authorize.apicore.contract.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSearchCustomerProfilesAdvancedResultRow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSearchCustomerProfilesAdvancedResultRow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchCustomerProfilesAdvancedResultRow" type="{http://api.authorize.net/ANetApiWS/}SearchCustomerProfilesAdvancedResultRow" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSearchCustomerProfilesAdvancedResultRow", propOrder = {
    "searchCustomerProfilesAdvancedResultRow"
})
public class ArrayOfSearchCustomerProfilesAdvancedResultRow {

    @XmlElement(name = "SearchCustomerProfilesAdvancedResultRow", nillable = true)
    protected List<SearchCustomerProfilesAdvancedResultRow> searchCustomerProfilesAdvancedResultRow;

    /**
     * Gets the value of the searchCustomerProfilesAdvancedResultRow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchCustomerProfilesAdvancedResultRow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchCustomerProfilesAdvancedResultRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchCustomerProfilesAdvancedResultRow }
     * 
     * 
     */
    public List<SearchCustomerProfilesAdvancedResultRow> getSearchCustomerProfilesAdvancedResultRow() {
        if (searchCustomerProfilesAdvancedResultRow == null) {
            searchCustomerProfilesAdvancedResultRow = new ArrayList<SearchCustomerProfilesAdvancedResultRow>();
        }
        return this.searchCustomerProfilesAdvancedResultRow;
    }

}

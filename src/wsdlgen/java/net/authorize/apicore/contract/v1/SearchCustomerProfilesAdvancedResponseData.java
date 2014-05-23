
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchCustomerProfilesAdvancedResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchCustomerProfilesAdvancedResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="TotalRows" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Rows" type="{http://api.authorize.net/ANetApiWS/}ArrayOfSearchCustomerProfilesAdvancedResultRow" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchCustomerProfilesAdvancedResponseData", propOrder = {
    "totalRows",
    "rows"
})
public class SearchCustomerProfilesAdvancedResponseData
    extends BaseResponseData
{

    @XmlElement(name = "TotalRows")
    protected int totalRows;
    @XmlElement(name = "Rows")
    protected ArrayOfSearchCustomerProfilesAdvancedResultRow rows;

    /**
     * Gets the value of the totalRows property.
     * 
     */
    public int getTotalRows() {
        return totalRows;
    }

    /**
     * Sets the value of the totalRows property.
     * 
     */
    public void setTotalRows(int value) {
        this.totalRows = value;
    }

    /**
     * Gets the value of the rows property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSearchCustomerProfilesAdvancedResultRow }
     *     
     */
    public ArrayOfSearchCustomerProfilesAdvancedResultRow getRows() {
        return rows;
    }

    /**
     * Sets the value of the rows property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSearchCustomerProfilesAdvancedResultRow }
     *     
     */
    public void setRows(ArrayOfSearchCustomerProfilesAdvancedResultRow value) {
        this.rows = value;
    }

}

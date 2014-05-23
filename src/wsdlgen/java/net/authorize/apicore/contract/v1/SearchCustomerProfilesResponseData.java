
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchCustomerProfilesResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchCustomerProfilesResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="TotalRows" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProfileSummaries" type="{http://api.authorize.net/ANetApiWS/}ArrayOfCustomerProfileSummaryType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchCustomerProfilesResponseData", propOrder = {
    "totalRows",
    "profileSummaries"
})
public class SearchCustomerProfilesResponseData
    extends BaseResponseData
{

    @XmlElement(name = "TotalRows")
    protected int totalRows;
    @XmlElement(name = "ProfileSummaries")
    protected ArrayOfCustomerProfileSummaryType profileSummaries;

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
     * Gets the value of the profileSummaries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCustomerProfileSummaryType }
     *     
     */
    public ArrayOfCustomerProfileSummaryType getProfileSummaries() {
        return profileSummaries;
    }

    /**
     * Sets the value of the profileSummaries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCustomerProfileSummaryType }
     *     
     */
    public void setProfileSummaries(ArrayOfCustomerProfileSummaryType value) {
        this.profileSummaries = value;
    }

}

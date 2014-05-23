
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCustomerProfileTransactionHistoryResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCustomerProfileTransactionHistoryResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="TotalRows" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProfileTransactionSummaries" type="{http://api.authorize.net/ANetApiWS/}ArrayOfProfileTransactionSummary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCustomerProfileTransactionHistoryResponseData", propOrder = {
    "totalRows",
    "profileTransactionSummaries"
})
public class GetCustomerProfileTransactionHistoryResponseData
    extends BaseResponseData
{

    @XmlElement(name = "TotalRows")
    protected int totalRows;
    @XmlElement(name = "ProfileTransactionSummaries")
    protected ArrayOfProfileTransactionSummary profileTransactionSummaries;

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
     * Gets the value of the profileTransactionSummaries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProfileTransactionSummary }
     *     
     */
    public ArrayOfProfileTransactionSummary getProfileTransactionSummaries() {
        return profileTransactionSummaries;
    }

    /**
     * Sets the value of the profileTransactionSummaries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProfileTransactionSummary }
     *     
     */
    public void setProfileTransactionSummaries(ArrayOfProfileTransactionSummary value) {
        this.profileTransactionSummaries = value;
    }

}

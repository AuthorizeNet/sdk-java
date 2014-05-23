
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchCustomerProfilesAdvancedResult" type="{http://api.authorize.net/ANetApiWS/}SearchCustomerProfilesAdvancedResponseData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "searchCustomerProfilesAdvancedResult"
})
@XmlRootElement(name = "SearchCustomerProfilesAdvancedResponse")
public class SearchCustomerProfilesAdvancedResponse {

    @XmlElement(name = "SearchCustomerProfilesAdvancedResult")
    protected SearchCustomerProfilesAdvancedResponseData searchCustomerProfilesAdvancedResult;

    /**
     * Gets the value of the searchCustomerProfilesAdvancedResult property.
     * 
     * @return
     *     possible object is
     *     {@link SearchCustomerProfilesAdvancedResponseData }
     *     
     */
    public SearchCustomerProfilesAdvancedResponseData getSearchCustomerProfilesAdvancedResult() {
        return searchCustomerProfilesAdvancedResult;
    }

    /**
     * Sets the value of the searchCustomerProfilesAdvancedResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCustomerProfilesAdvancedResponseData }
     *     
     */
    public void setSearchCustomerProfilesAdvancedResult(SearchCustomerProfilesAdvancedResponseData value) {
        this.searchCustomerProfilesAdvancedResult = value;
    }

}

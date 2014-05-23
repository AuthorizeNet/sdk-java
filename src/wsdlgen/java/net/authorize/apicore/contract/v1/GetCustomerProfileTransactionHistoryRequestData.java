
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCustomerProfileTransactionHistoryRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCustomerProfileTransactionHistoryRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Options" type="{http://api.authorize.net/ANetApiWS/}SearchProfileTransactionsOptions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCustomerProfileTransactionHistoryRequestData", propOrder = {
    "merchantID",
    "options"
})
public class GetCustomerProfileTransactionHistoryRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "Options")
    protected SearchProfileTransactionsOptions options;

    /**
     * Gets the value of the merchantID property.
     * 
     */
    public int getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     */
    public void setMerchantID(int value) {
        this.merchantID = value;
    }

    /**
     * Gets the value of the options property.
     * 
     * @return
     *     possible object is
     *     {@link SearchProfileTransactionsOptions }
     *     
     */
    public SearchProfileTransactionsOptions getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchProfileTransactionsOptions }
     *     
     */
    public void setOptions(SearchProfileTransactionsOptions value) {
        this.options = value;
    }

}

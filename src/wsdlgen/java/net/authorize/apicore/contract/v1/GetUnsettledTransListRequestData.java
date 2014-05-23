
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetUnsettledTransListRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetUnsettledTransListRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AnetUserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PageNumberBeingRetrieved" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NumItemsInResultSet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUnsettledTransListRequestData", propOrder = {
    "merchantID",
    "anetUserID",
    "pageNumberBeingRetrieved",
    "numItemsInResultSet"
})
public class GetUnsettledTransListRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "AnetUserID")
    protected int anetUserID;
    @XmlElement(name = "PageNumberBeingRetrieved")
    protected int pageNumberBeingRetrieved;
    @XmlElement(name = "NumItemsInResultSet")
    protected int numItemsInResultSet;

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
     * Gets the value of the anetUserID property.
     * 
     */
    public int getAnetUserID() {
        return anetUserID;
    }

    /**
     * Sets the value of the anetUserID property.
     * 
     */
    public void setAnetUserID(int value) {
        this.anetUserID = value;
    }

    /**
     * Gets the value of the pageNumberBeingRetrieved property.
     * 
     */
    public int getPageNumberBeingRetrieved() {
        return pageNumberBeingRetrieved;
    }

    /**
     * Sets the value of the pageNumberBeingRetrieved property.
     * 
     */
    public void setPageNumberBeingRetrieved(int value) {
        this.pageNumberBeingRetrieved = value;
    }

    /**
     * Gets the value of the numItemsInResultSet property.
     * 
     */
    public int getNumItemsInResultSet() {
        return numItemsInResultSet;
    }

    /**
     * Sets the value of the numItemsInResultSet property.
     * 
     */
    public void setNumItemsInResultSet(int value) {
        this.numItemsInResultSet = value;
    }

}

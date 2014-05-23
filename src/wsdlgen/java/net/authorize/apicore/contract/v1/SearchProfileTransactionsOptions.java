
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchProfileTransactionsOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchProfileTransactionsOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RowLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProfileID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PaymentProfileID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ShippingAddressID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchProfileTransactionsOptions", propOrder = {
    "rowLimit",
    "profileID",
    "paymentProfileID",
    "shippingAddressID"
})
public class SearchProfileTransactionsOptions {

    @XmlElement(name = "RowLimit")
    protected int rowLimit;
    @XmlElement(name = "ProfileID")
    protected long profileID;
    @XmlElement(name = "PaymentProfileID")
    protected long paymentProfileID;
    @XmlElement(name = "ShippingAddressID")
    protected long shippingAddressID;

    /**
     * Gets the value of the rowLimit property.
     * 
     */
    public int getRowLimit() {
        return rowLimit;
    }

    /**
     * Sets the value of the rowLimit property.
     * 
     */
    public void setRowLimit(int value) {
        this.rowLimit = value;
    }

    /**
     * Gets the value of the profileID property.
     * 
     */
    public long getProfileID() {
        return profileID;
    }

    /**
     * Sets the value of the profileID property.
     * 
     */
    public void setProfileID(long value) {
        this.profileID = value;
    }

    /**
     * Gets the value of the paymentProfileID property.
     * 
     */
    public long getPaymentProfileID() {
        return paymentProfileID;
    }

    /**
     * Sets the value of the paymentProfileID property.
     * 
     */
    public void setPaymentProfileID(long value) {
        this.paymentProfileID = value;
    }

    /**
     * Gets the value of the shippingAddressID property.
     * 
     */
    public long getShippingAddressID() {
        return shippingAddressID;
    }

    /**
     * Sets the value of the shippingAddressID property.
     * 
     */
    public void setShippingAddressID(long value) {
        this.shippingAddressID = value;
    }

}

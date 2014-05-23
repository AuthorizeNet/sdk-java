
package net.authorize.apicore.contract.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Invoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CurrencyID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TrialOrderInfo" type="{http://www.infospace.com/anet/Subscription.xsd}TrialInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderInfo", namespace = "http://www.infospace.com/anet/Subscription.xsd", propOrder = {
    "description",
    "invoice",
    "amount",
    "currencyID",
    "trialOrderInfo"
})
public class OrderInfo {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Invoice")
    protected String invoice;
    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "CurrencyID")
    protected int currencyID;
    @XmlElement(name = "TrialOrderInfo")
    protected TrialInfo trialOrderInfo;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the invoice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoice() {
        return invoice;
    }

    /**
     * Sets the value of the invoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoice(String value) {
        this.invoice = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the currencyID property.
     * 
     */
    public int getCurrencyID() {
        return currencyID;
    }

    /**
     * Sets the value of the currencyID property.
     * 
     */
    public void setCurrencyID(int value) {
        this.currencyID = value;
    }

    /**
     * Gets the value of the trialOrderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TrialInfo }
     *     
     */
    public TrialInfo getTrialOrderInfo() {
        return trialOrderInfo;
    }

    /**
     * Sets the value of the trialOrderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrialInfo }
     *     
     */
    public void setTrialOrderInfo(TrialInfo value) {
        this.trialOrderInfo = value;
    }

}

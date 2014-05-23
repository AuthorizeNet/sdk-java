
package net.authorize.apicore.contract.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TransListInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransListInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="submitTimeUTC" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="submitTimeLocal" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="transactionStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="invoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardType" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="settleAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="subscription" type="{http://api.authorize.net/ANetApiWS/}SubscriptionPaymentInfo" minOccurs="0"/>
 *         &lt;element name="marketType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobileDeviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hasReturnedItems" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="hasReturnedItemsSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransListInfo", propOrder = {
    "transId",
    "submitTimeUTC",
    "submitTimeLocal",
    "transactionStatus",
    "invoiceNumber",
    "firstName",
    "lastName",
    "cardType",
    "accountNumber",
    "settleAmount",
    "subscription",
    "marketType",
    "product",
    "mobileDeviceId",
    "hasReturnedItems",
    "hasReturnedItemsSpecified"
})
public class TransListInfo {

    protected String transId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submitTimeUTC;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submitTimeLocal;
    protected int transactionStatus;
    protected String invoiceNumber;
    protected String firstName;
    protected String lastName;
    @XmlSchemaType(name = "unsignedShort")
    protected int cardType;
    protected String accountNumber;
    @XmlElement(required = true)
    protected BigDecimal settleAmount;
    protected SubscriptionPaymentInfo subscription;
    protected String marketType;
    protected String product;
    protected String mobileDeviceId;
    protected Boolean hasReturnedItems;
    protected boolean hasReturnedItemsSpecified;

    /**
     * Gets the value of the transId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransId() {
        return transId;
    }

    /**
     * Sets the value of the transId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransId(String value) {
        this.transId = value;
    }

    /**
     * Gets the value of the submitTimeUTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmitTimeUTC() {
        return submitTimeUTC;
    }

    /**
     * Sets the value of the submitTimeUTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmitTimeUTC(XMLGregorianCalendar value) {
        this.submitTimeUTC = value;
    }

    /**
     * Gets the value of the submitTimeLocal property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmitTimeLocal() {
        return submitTimeLocal;
    }

    /**
     * Sets the value of the submitTimeLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmitTimeLocal(XMLGregorianCalendar value) {
        this.submitTimeLocal = value;
    }

    /**
     * Gets the value of the transactionStatus property.
     * 
     */
    public int getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     */
    public void setTransactionStatus(int value) {
        this.transactionStatus = value;
    }

    /**
     * Gets the value of the invoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the value of the invoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the cardType property.
     * 
     */
    public int getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     */
    public void setCardType(int value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the settleAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    /**
     * Sets the value of the settleAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSettleAmount(BigDecimal value) {
        this.settleAmount = value;
    }

    /**
     * Gets the value of the subscription property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionPaymentInfo }
     *     
     */
    public SubscriptionPaymentInfo getSubscription() {
        return subscription;
    }

    /**
     * Sets the value of the subscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionPaymentInfo }
     *     
     */
    public void setSubscription(SubscriptionPaymentInfo value) {
        this.subscription = value;
    }

    /**
     * Gets the value of the marketType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketType() {
        return marketType;
    }

    /**
     * Sets the value of the marketType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketType(String value) {
        this.marketType = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

    /**
     * Gets the value of the mobileDeviceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileDeviceId() {
        return mobileDeviceId;
    }

    /**
     * Sets the value of the mobileDeviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileDeviceId(String value) {
        this.mobileDeviceId = value;
    }

    /**
     * Gets the value of the hasReturnedItems property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasReturnedItems() {
        return hasReturnedItems;
    }

    /**
     * Sets the value of the hasReturnedItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasReturnedItems(Boolean value) {
        this.hasReturnedItems = value;
    }

    /**
     * Gets the value of the hasReturnedItemsSpecified property.
     * 
     */
    public boolean isHasReturnedItemsSpecified() {
        return hasReturnedItemsSpecified;
    }

    /**
     * Sets the value of the hasReturnedItemsSpecified property.
     * 
     */
    public void setHasReturnedItemsSpecified(boolean value) {
        this.hasReturnedItemsSpecified = value;
    }

}

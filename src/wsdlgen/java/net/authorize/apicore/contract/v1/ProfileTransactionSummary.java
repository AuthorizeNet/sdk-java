
package net.authorize.apicore.contract.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ProfileTransactionSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileTransactionSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProfileID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PaymentProfileID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ShippingAddressID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TransID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseToCustomer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ActionCode" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="Type" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="SettlementState" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BatchID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TranStatusID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TranStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubmitTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="BillToFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillToLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentMethodType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PaymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Invoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CurrencyID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SettledTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SettleBusinessDay" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Method" type="{http://microsoft.com/wsdl/types/}char"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileTransactionSummary", propOrder = {
    "merchantID",
    "profileID",
    "paymentProfileID",
    "shippingAddressID",
    "transID",
    "responseToCustomer",
    "actionCode",
    "type",
    "settlementState",
    "batchID",
    "tranStatusID",
    "tranStatusDescription",
    "submitTimeStamp",
    "billToFirstName",
    "billToLastName",
    "paymentMethodType",
    "paymentMethod",
    "invoice",
    "amount",
    "currencyID",
    "settledTimeStamp",
    "settleBusinessDay",
    "method"
})
public class ProfileTransactionSummary {

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "ProfileID")
    protected long profileID;
    @XmlElement(name = "PaymentProfileID")
    protected long paymentProfileID;
    @XmlElement(name = "ShippingAddressID")
    protected long shippingAddressID;
    @XmlElement(name = "TransID")
    protected String transID;
    @XmlElement(name = "ResponseToCustomer")
    protected int responseToCustomer;
    @XmlElement(name = "ActionCode")
    @XmlSchemaType(name = "unsignedShort")
    protected int actionCode;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "unsignedShort")
    protected int type;
    @XmlElement(name = "SettlementState")
    protected int settlementState;
    @XmlElement(name = "BatchID")
    protected int batchID;
    @XmlElement(name = "TranStatusID")
    protected int tranStatusID;
    @XmlElement(name = "TranStatusDescription")
    protected String tranStatusDescription;
    @XmlElement(name = "SubmitTimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submitTimeStamp;
    @XmlElement(name = "BillToFirstName")
    protected String billToFirstName;
    @XmlElement(name = "BillToLastName")
    protected String billToLastName;
    @XmlElement(name = "PaymentMethodType")
    protected int paymentMethodType;
    @XmlElement(name = "PaymentMethod")
    protected String paymentMethod;
    @XmlElement(name = "Invoice")
    protected String invoice;
    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "CurrencyID")
    protected int currencyID;
    @XmlElement(name = "SettledTimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar settledTimeStamp;
    @XmlElement(name = "SettleBusinessDay", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar settleBusinessDay;
    @XmlElement(name = "Method")
    @XmlSchemaType(name = "unsignedShort")
    protected int method;

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

    /**
     * Gets the value of the transID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransID() {
        return transID;
    }

    /**
     * Sets the value of the transID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransID(String value) {
        this.transID = value;
    }

    /**
     * Gets the value of the responseToCustomer property.
     * 
     */
    public int getResponseToCustomer() {
        return responseToCustomer;
    }

    /**
     * Sets the value of the responseToCustomer property.
     * 
     */
    public void setResponseToCustomer(int value) {
        this.responseToCustomer = value;
    }

    /**
     * Gets the value of the actionCode property.
     * 
     */
    public int getActionCode() {
        return actionCode;
    }

    /**
     * Sets the value of the actionCode property.
     * 
     */
    public void setActionCode(int value) {
        this.actionCode = value;
    }

    /**
     * Gets the value of the type property.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

    /**
     * Gets the value of the settlementState property.
     * 
     */
    public int getSettlementState() {
        return settlementState;
    }

    /**
     * Sets the value of the settlementState property.
     * 
     */
    public void setSettlementState(int value) {
        this.settlementState = value;
    }

    /**
     * Gets the value of the batchID property.
     * 
     */
    public int getBatchID() {
        return batchID;
    }

    /**
     * Sets the value of the batchID property.
     * 
     */
    public void setBatchID(int value) {
        this.batchID = value;
    }

    /**
     * Gets the value of the tranStatusID property.
     * 
     */
    public int getTranStatusID() {
        return tranStatusID;
    }

    /**
     * Sets the value of the tranStatusID property.
     * 
     */
    public void setTranStatusID(int value) {
        this.tranStatusID = value;
    }

    /**
     * Gets the value of the tranStatusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranStatusDescription() {
        return tranStatusDescription;
    }

    /**
     * Sets the value of the tranStatusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranStatusDescription(String value) {
        this.tranStatusDescription = value;
    }

    /**
     * Gets the value of the submitTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmitTimeStamp() {
        return submitTimeStamp;
    }

    /**
     * Sets the value of the submitTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmitTimeStamp(XMLGregorianCalendar value) {
        this.submitTimeStamp = value;
    }

    /**
     * Gets the value of the billToFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillToFirstName() {
        return billToFirstName;
    }

    /**
     * Sets the value of the billToFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillToFirstName(String value) {
        this.billToFirstName = value;
    }

    /**
     * Gets the value of the billToLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillToLastName() {
        return billToLastName;
    }

    /**
     * Sets the value of the billToLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillToLastName(String value) {
        this.billToLastName = value;
    }

    /**
     * Gets the value of the paymentMethodType property.
     * 
     */
    public int getPaymentMethodType() {
        return paymentMethodType;
    }

    /**
     * Sets the value of the paymentMethodType property.
     * 
     */
    public void setPaymentMethodType(int value) {
        this.paymentMethodType = value;
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethod(String value) {
        this.paymentMethod = value;
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
     * Gets the value of the settledTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSettledTimeStamp() {
        return settledTimeStamp;
    }

    /**
     * Sets the value of the settledTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSettledTimeStamp(XMLGregorianCalendar value) {
        this.settledTimeStamp = value;
    }

    /**
     * Gets the value of the settleBusinessDay property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSettleBusinessDay() {
        return settleBusinessDay;
    }

    /**
     * Sets the value of the settleBusinessDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSettleBusinessDay(XMLGregorianCalendar value) {
        this.settleBusinessDay = value;
    }

    /**
     * Gets the value of the method property.
     * 
     */
    public int getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     */
    public void setMethod(int value) {
        this.method = value;
    }

}

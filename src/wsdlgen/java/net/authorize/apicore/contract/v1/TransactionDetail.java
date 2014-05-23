
package net.authorize.apicore.contract.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TransactionDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatchID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DriversLicenseNumMasked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DriversLicenseState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DriversLicenseDOBMasked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillToAddress" type="{http://api.authorize.net/ANetApiWS/}TransactionAddress" minOccurs="0"/>
 *         &lt;element name="ShipToAddress" type="{http://api.authorize.net/ANetApiWS/}TransactionAddress" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerOranizationTypeChar" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="CustomerTaxIDMasked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardNumberMasked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpDateMasked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankRoutingNumberMasked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccountNumberMasked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameOnBankAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ECheckTypeID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ECheckTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Invoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Desription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="FreightAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DutyAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TaxExempt" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PurchaseOrderNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AVSResponse" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="CardCodeResponse" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="ResponseToCustomer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TransID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalTransID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionType" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="RecurringBilling" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Method" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="MarketType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="AuthCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettleAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SettleCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettledTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SettleBusinessDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchSettlementState" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AuthTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SubmitTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PartialReversalStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TranStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EfalconFraudScore" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ArbIteration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ArbNumRecurrence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ArbNumRecurred" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ArbSubscriptionID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ArbSubscriptionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CAVVResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FdsFilterActionID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FdsFilterList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FdsFilters" type="{http://api.authorize.net/ANetApiWS/}ArrayOfFDSFilterDetails" minOccurs="0"/>
 *         &lt;element name="DccStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CanIssueCredit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LineItems" type="{http://api.authorize.net/ANetApiWS/}ArrayOfLineItem" minOccurs="0"/>
 *         &lt;element name="PaymentMethodLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentMethodFeatureSetID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ResponseMajorCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ResponseCustomerMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionCode" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="SourceIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SplitTenderID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="VaultTransactionCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PrepaidRemainingBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="isPrepaidCard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PrepaidRequestedAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MobileDeviceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReturnedItemInfos" type="{http://api.authorize.net/ANetApiWS/}ArrayOfReturnedItemInfo" minOccurs="0"/>
 *         &lt;element name="Solution" type="{http://api.authorize.net/ANetApiWS/}SolutionInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionDetail", propOrder = {
    "batchID",
    "driversLicenseNumMasked",
    "driversLicenseState",
    "driversLicenseDOBMasked",
    "billToAddress",
    "shipToAddress",
    "email",
    "phone",
    "fax",
    "custID",
    "customerIP",
    "customerOranizationTypeChar",
    "customerTaxIDMasked",
    "cardNumberMasked",
    "expDateMasked",
    "bankRoutingNumberMasked",
    "bankAccountNumberMasked",
    "bankAccountType",
    "nameOnBankAccount",
    "eCheckTypeID",
    "eCheckTypeCode",
    "invoice",
    "desription",
    "taxAmount",
    "freightAmount",
    "dutyAmount",
    "taxExempt",
    "purchaseOrderNum",
    "avsResponse",
    "cardCodeResponse",
    "responseToCustomer",
    "transID",
    "authCode",
    "originalTransID",
    "amount",
    "currencyCode",
    "transactionType",
    "recurringBilling",
    "method",
    "marketType",
    "product",
    "authAmount",
    "authCurrencyCode",
    "settleAmount",
    "settleCurrencyCode",
    "settledTimeStamp",
    "settleBusinessDay",
    "batchSettlementState",
    "authTimeStamp",
    "submitTimeStamp",
    "partialReversalStatus",
    "tranStatus",
    "efalconFraudScore",
    "merchantID",
    "arbIteration",
    "arbNumRecurrence",
    "arbNumRecurred",
    "arbSubscriptionID",
    "arbSubscriptionName",
    "cavvResponse",
    "fdsFilterActionID",
    "fdsFilterList",
    "fdsFilters",
    "dccStatus",
    "canIssueCredit",
    "lineItems",
    "paymentMethodLabel",
    "paymentMethodFeatureSetID",
    "responseMajorCode",
    "responseCustomerMessage",
    "responseDescription",
    "actionCode",
    "sourceIP",
    "splitTenderID",
    "vaultTransactionCount",
    "prepaidRemainingBalance",
    "isPrepaidCard",
    "prepaidRequestedAmount",
    "mobileDeviceID",
    "returnedItemInfos",
    "solution"
})
public class TransactionDetail {

    @XmlElement(name = "BatchID")
    protected int batchID;
    @XmlElement(name = "DriversLicenseNumMasked")
    protected String driversLicenseNumMasked;
    @XmlElement(name = "DriversLicenseState")
    protected String driversLicenseState;
    @XmlElement(name = "DriversLicenseDOBMasked")
    protected String driversLicenseDOBMasked;
    @XmlElement(name = "BillToAddress")
    protected TransactionAddress billToAddress;
    @XmlElement(name = "ShipToAddress")
    protected TransactionAddress shipToAddress;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Phone")
    protected String phone;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "CustID")
    protected String custID;
    @XmlElement(name = "CustomerIP")
    protected String customerIP;
    @XmlElement(name = "CustomerOranizationTypeChar")
    @XmlSchemaType(name = "unsignedShort")
    protected int customerOranizationTypeChar;
    @XmlElement(name = "CustomerTaxIDMasked")
    protected String customerTaxIDMasked;
    @XmlElement(name = "CardNumberMasked")
    protected String cardNumberMasked;
    @XmlElement(name = "ExpDateMasked")
    protected String expDateMasked;
    @XmlElement(name = "BankRoutingNumberMasked")
    protected String bankRoutingNumberMasked;
    @XmlElement(name = "BankAccountNumberMasked")
    protected String bankAccountNumberMasked;
    @XmlElement(name = "BankAccountType")
    protected String bankAccountType;
    @XmlElement(name = "NameOnBankAccount")
    protected String nameOnBankAccount;
    @XmlElement(name = "ECheckTypeID")
    protected int eCheckTypeID;
    @XmlElement(name = "ECheckTypeCode")
    protected String eCheckTypeCode;
    @XmlElement(name = "Invoice")
    protected String invoice;
    @XmlElement(name = "Desription")
    protected String desription;
    @XmlElement(name = "TaxAmount", required = true)
    protected BigDecimal taxAmount;
    @XmlElement(name = "FreightAmount", required = true)
    protected BigDecimal freightAmount;
    @XmlElement(name = "DutyAmount", required = true)
    protected BigDecimal dutyAmount;
    @XmlElement(name = "TaxExempt")
    protected Boolean taxExempt;
    @XmlElement(name = "PurchaseOrderNum")
    protected String purchaseOrderNum;
    @XmlElement(name = "AVSResponse")
    @XmlSchemaType(name = "unsignedShort")
    protected int avsResponse;
    @XmlElement(name = "CardCodeResponse")
    @XmlSchemaType(name = "unsignedShort")
    protected int cardCodeResponse;
    @XmlElement(name = "ResponseToCustomer")
    protected int responseToCustomer;
    @XmlElement(name = "TransID")
    protected String transID;
    @XmlElement(name = "AuthCode")
    protected String authCode;
    @XmlElement(name = "OriginalTransID")
    protected String originalTransID;
    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "CurrencyCode")
    protected String currencyCode;
    @XmlElement(name = "TransactionType")
    @XmlSchemaType(name = "unsignedShort")
    protected int transactionType;
    @XmlElement(name = "RecurringBilling")
    protected Boolean recurringBilling;
    @XmlElement(name = "Method")
    @XmlSchemaType(name = "unsignedShort")
    protected int method;
    @XmlElement(name = "MarketType")
    protected String marketType;
    @XmlElement(name = "Product")
    protected String product;
    @XmlElement(name = "AuthAmount", required = true)
    protected BigDecimal authAmount;
    @XmlElement(name = "AuthCurrencyCode")
    protected String authCurrencyCode;
    @XmlElement(name = "SettleAmount", required = true)
    protected BigDecimal settleAmount;
    @XmlElement(name = "SettleCurrencyCode")
    protected String settleCurrencyCode;
    @XmlElement(name = "SettledTimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar settledTimeStamp;
    @XmlElement(name = "SettleBusinessDay")
    protected String settleBusinessDay;
    @XmlElement(name = "BatchSettlementState")
    protected int batchSettlementState;
    @XmlElement(name = "AuthTimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar authTimeStamp;
    @XmlElement(name = "SubmitTimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submitTimeStamp;
    @XmlElement(name = "PartialReversalStatus")
    protected int partialReversalStatus;
    @XmlElement(name = "TranStatus")
    protected int tranStatus;
    @XmlElement(name = "EfalconFraudScore")
    protected int efalconFraudScore;
    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "ArbIteration")
    protected int arbIteration;
    @XmlElement(name = "ArbNumRecurrence")
    protected int arbNumRecurrence;
    @XmlElement(name = "ArbNumRecurred")
    protected int arbNumRecurred;
    @XmlElement(name = "ArbSubscriptionID")
    protected int arbSubscriptionID;
    @XmlElement(name = "ArbSubscriptionName")
    protected String arbSubscriptionName;
    @XmlElement(name = "CAVVResponse")
    protected String cavvResponse;
    @XmlElement(name = "FdsFilterActionID")
    protected int fdsFilterActionID;
    @XmlElement(name = "FdsFilterList")
    protected String fdsFilterList;
    @XmlElement(name = "FdsFilters")
    protected ArrayOfFDSFilterDetails fdsFilters;
    @XmlElement(name = "DccStatus")
    protected int dccStatus;
    @XmlElement(name = "CanIssueCredit")
    protected int canIssueCredit;
    @XmlElement(name = "LineItems")
    protected ArrayOfLineItem lineItems;
    @XmlElement(name = "PaymentMethodLabel")
    protected String paymentMethodLabel;
    @XmlElement(name = "PaymentMethodFeatureSetID")
    protected int paymentMethodFeatureSetID;
    @XmlElement(name = "ResponseMajorCode")
    protected int responseMajorCode;
    @XmlElement(name = "ResponseCustomerMessage")
    protected String responseCustomerMessage;
    @XmlElement(name = "ResponseDescription")
    protected String responseDescription;
    @XmlElement(name = "ActionCode")
    @XmlSchemaType(name = "unsignedShort")
    protected int actionCode;
    @XmlElement(name = "SourceIP")
    protected String sourceIP;
    @XmlElement(name = "SplitTenderID")
    protected int splitTenderID;
    @XmlElement(name = "VaultTransactionCount")
    protected int vaultTransactionCount;
    @XmlElement(name = "PrepaidRemainingBalance", required = true)
    protected BigDecimal prepaidRemainingBalance;
    protected boolean isPrepaidCard;
    @XmlElement(name = "PrepaidRequestedAmount", required = true)
    protected BigDecimal prepaidRequestedAmount;
    @XmlElement(name = "MobileDeviceID")
    protected String mobileDeviceID;
    @XmlElement(name = "ReturnedItemInfos")
    protected ArrayOfReturnedItemInfo returnedItemInfos;
    @XmlElement(name = "Solution")
    protected SolutionInfo solution;

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
     * Gets the value of the driversLicenseNumMasked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriversLicenseNumMasked() {
        return driversLicenseNumMasked;
    }

    /**
     * Sets the value of the driversLicenseNumMasked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriversLicenseNumMasked(String value) {
        this.driversLicenseNumMasked = value;
    }

    /**
     * Gets the value of the driversLicenseState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriversLicenseState() {
        return driversLicenseState;
    }

    /**
     * Sets the value of the driversLicenseState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriversLicenseState(String value) {
        this.driversLicenseState = value;
    }

    /**
     * Gets the value of the driversLicenseDOBMasked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriversLicenseDOBMasked() {
        return driversLicenseDOBMasked;
    }

    /**
     * Sets the value of the driversLicenseDOBMasked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriversLicenseDOBMasked(String value) {
        this.driversLicenseDOBMasked = value;
    }

    /**
     * Gets the value of the billToAddress property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionAddress }
     *     
     */
    public TransactionAddress getBillToAddress() {
        return billToAddress;
    }

    /**
     * Sets the value of the billToAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionAddress }
     *     
     */
    public void setBillToAddress(TransactionAddress value) {
        this.billToAddress = value;
    }

    /**
     * Gets the value of the shipToAddress property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionAddress }
     *     
     */
    public TransactionAddress getShipToAddress() {
        return shipToAddress;
    }

    /**
     * Sets the value of the shipToAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionAddress }
     *     
     */
    public void setShipToAddress(TransactionAddress value) {
        this.shipToAddress = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the custID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustID() {
        return custID;
    }

    /**
     * Sets the value of the custID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustID(String value) {
        this.custID = value;
    }

    /**
     * Gets the value of the customerIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerIP() {
        return customerIP;
    }

    /**
     * Sets the value of the customerIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerIP(String value) {
        this.customerIP = value;
    }

    /**
     * Gets the value of the customerOranizationTypeChar property.
     * 
     */
    public int getCustomerOranizationTypeChar() {
        return customerOranizationTypeChar;
    }

    /**
     * Sets the value of the customerOranizationTypeChar property.
     * 
     */
    public void setCustomerOranizationTypeChar(int value) {
        this.customerOranizationTypeChar = value;
    }

    /**
     * Gets the value of the customerTaxIDMasked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerTaxIDMasked() {
        return customerTaxIDMasked;
    }

    /**
     * Sets the value of the customerTaxIDMasked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerTaxIDMasked(String value) {
        this.customerTaxIDMasked = value;
    }

    /**
     * Gets the value of the cardNumberMasked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumberMasked() {
        return cardNumberMasked;
    }

    /**
     * Sets the value of the cardNumberMasked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumberMasked(String value) {
        this.cardNumberMasked = value;
    }

    /**
     * Gets the value of the expDateMasked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpDateMasked() {
        return expDateMasked;
    }

    /**
     * Sets the value of the expDateMasked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpDateMasked(String value) {
        this.expDateMasked = value;
    }

    /**
     * Gets the value of the bankRoutingNumberMasked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankRoutingNumberMasked() {
        return bankRoutingNumberMasked;
    }

    /**
     * Sets the value of the bankRoutingNumberMasked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankRoutingNumberMasked(String value) {
        this.bankRoutingNumberMasked = value;
    }

    /**
     * Gets the value of the bankAccountNumberMasked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountNumberMasked() {
        return bankAccountNumberMasked;
    }

    /**
     * Sets the value of the bankAccountNumberMasked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountNumberMasked(String value) {
        this.bankAccountNumberMasked = value;
    }

    /**
     * Gets the value of the bankAccountType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountType() {
        return bankAccountType;
    }

    /**
     * Sets the value of the bankAccountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountType(String value) {
        this.bankAccountType = value;
    }

    /**
     * Gets the value of the nameOnBankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOnBankAccount() {
        return nameOnBankAccount;
    }

    /**
     * Sets the value of the nameOnBankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOnBankAccount(String value) {
        this.nameOnBankAccount = value;
    }

    /**
     * Gets the value of the eCheckTypeID property.
     * 
     */
    public int getECheckTypeID() {
        return eCheckTypeID;
    }

    /**
     * Sets the value of the eCheckTypeID property.
     * 
     */
    public void setECheckTypeID(int value) {
        this.eCheckTypeID = value;
    }

    /**
     * Gets the value of the eCheckTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECheckTypeCode() {
        return eCheckTypeCode;
    }

    /**
     * Sets the value of the eCheckTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECheckTypeCode(String value) {
        this.eCheckTypeCode = value;
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
     * Gets the value of the desription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesription() {
        return desription;
    }

    /**
     * Sets the value of the desription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesription(String value) {
        this.desription = value;
    }

    /**
     * Gets the value of the taxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    /**
     * Sets the value of the taxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxAmount(BigDecimal value) {
        this.taxAmount = value;
    }

    /**
     * Gets the value of the freightAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    /**
     * Sets the value of the freightAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFreightAmount(BigDecimal value) {
        this.freightAmount = value;
    }

    /**
     * Gets the value of the dutyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDutyAmount() {
        return dutyAmount;
    }

    /**
     * Sets the value of the dutyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDutyAmount(BigDecimal value) {
        this.dutyAmount = value;
    }

    /**
     * Gets the value of the taxExempt property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTaxExempt() {
        return taxExempt;
    }

    /**
     * Sets the value of the taxExempt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTaxExempt(Boolean value) {
        this.taxExempt = value;
    }

    /**
     * Gets the value of the purchaseOrderNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseOrderNum() {
        return purchaseOrderNum;
    }

    /**
     * Sets the value of the purchaseOrderNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseOrderNum(String value) {
        this.purchaseOrderNum = value;
    }

    /**
     * Gets the value of the avsResponse property.
     * 
     */
    public int getAVSResponse() {
        return avsResponse;
    }

    /**
     * Sets the value of the avsResponse property.
     * 
     */
    public void setAVSResponse(int value) {
        this.avsResponse = value;
    }

    /**
     * Gets the value of the cardCodeResponse property.
     * 
     */
    public int getCardCodeResponse() {
        return cardCodeResponse;
    }

    /**
     * Sets the value of the cardCodeResponse property.
     * 
     */
    public void setCardCodeResponse(int value) {
        this.cardCodeResponse = value;
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
     * Gets the value of the authCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * Sets the value of the authCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthCode(String value) {
        this.authCode = value;
    }

    /**
     * Gets the value of the originalTransID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalTransID() {
        return originalTransID;
    }

    /**
     * Sets the value of the originalTransID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalTransID(String value) {
        this.originalTransID = value;
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
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     */
    public int getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     */
    public void setTransactionType(int value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the recurringBilling property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecurringBilling() {
        return recurringBilling;
    }

    /**
     * Sets the value of the recurringBilling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecurringBilling(Boolean value) {
        this.recurringBilling = value;
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
     * Gets the value of the authAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAuthAmount() {
        return authAmount;
    }

    /**
     * Sets the value of the authAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAuthAmount(BigDecimal value) {
        this.authAmount = value;
    }

    /**
     * Gets the value of the authCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthCurrencyCode() {
        return authCurrencyCode;
    }

    /**
     * Sets the value of the authCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthCurrencyCode(String value) {
        this.authCurrencyCode = value;
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
     * Gets the value of the settleCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettleCurrencyCode() {
        return settleCurrencyCode;
    }

    /**
     * Sets the value of the settleCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettleCurrencyCode(String value) {
        this.settleCurrencyCode = value;
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
     *     {@link String }
     *     
     */
    public String getSettleBusinessDay() {
        return settleBusinessDay;
    }

    /**
     * Sets the value of the settleBusinessDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettleBusinessDay(String value) {
        this.settleBusinessDay = value;
    }

    /**
     * Gets the value of the batchSettlementState property.
     * 
     */
    public int getBatchSettlementState() {
        return batchSettlementState;
    }

    /**
     * Sets the value of the batchSettlementState property.
     * 
     */
    public void setBatchSettlementState(int value) {
        this.batchSettlementState = value;
    }

    /**
     * Gets the value of the authTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAuthTimeStamp() {
        return authTimeStamp;
    }

    /**
     * Sets the value of the authTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuthTimeStamp(XMLGregorianCalendar value) {
        this.authTimeStamp = value;
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
     * Gets the value of the partialReversalStatus property.
     * 
     */
    public int getPartialReversalStatus() {
        return partialReversalStatus;
    }

    /**
     * Sets the value of the partialReversalStatus property.
     * 
     */
    public void setPartialReversalStatus(int value) {
        this.partialReversalStatus = value;
    }

    /**
     * Gets the value of the tranStatus property.
     * 
     */
    public int getTranStatus() {
        return tranStatus;
    }

    /**
     * Sets the value of the tranStatus property.
     * 
     */
    public void setTranStatus(int value) {
        this.tranStatus = value;
    }

    /**
     * Gets the value of the efalconFraudScore property.
     * 
     */
    public int getEfalconFraudScore() {
        return efalconFraudScore;
    }

    /**
     * Sets the value of the efalconFraudScore property.
     * 
     */
    public void setEfalconFraudScore(int value) {
        this.efalconFraudScore = value;
    }

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
     * Gets the value of the arbIteration property.
     * 
     */
    public int getArbIteration() {
        return arbIteration;
    }

    /**
     * Sets the value of the arbIteration property.
     * 
     */
    public void setArbIteration(int value) {
        this.arbIteration = value;
    }

    /**
     * Gets the value of the arbNumRecurrence property.
     * 
     */
    public int getArbNumRecurrence() {
        return arbNumRecurrence;
    }

    /**
     * Sets the value of the arbNumRecurrence property.
     * 
     */
    public void setArbNumRecurrence(int value) {
        this.arbNumRecurrence = value;
    }

    /**
     * Gets the value of the arbNumRecurred property.
     * 
     */
    public int getArbNumRecurred() {
        return arbNumRecurred;
    }

    /**
     * Sets the value of the arbNumRecurred property.
     * 
     */
    public void setArbNumRecurred(int value) {
        this.arbNumRecurred = value;
    }

    /**
     * Gets the value of the arbSubscriptionID property.
     * 
     */
    public int getArbSubscriptionID() {
        return arbSubscriptionID;
    }

    /**
     * Sets the value of the arbSubscriptionID property.
     * 
     */
    public void setArbSubscriptionID(int value) {
        this.arbSubscriptionID = value;
    }

    /**
     * Gets the value of the arbSubscriptionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArbSubscriptionName() {
        return arbSubscriptionName;
    }

    /**
     * Sets the value of the arbSubscriptionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArbSubscriptionName(String value) {
        this.arbSubscriptionName = value;
    }

    /**
     * Gets the value of the cavvResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAVVResponse() {
        return cavvResponse;
    }

    /**
     * Sets the value of the cavvResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAVVResponse(String value) {
        this.cavvResponse = value;
    }

    /**
     * Gets the value of the fdsFilterActionID property.
     * 
     */
    public int getFdsFilterActionID() {
        return fdsFilterActionID;
    }

    /**
     * Sets the value of the fdsFilterActionID property.
     * 
     */
    public void setFdsFilterActionID(int value) {
        this.fdsFilterActionID = value;
    }

    /**
     * Gets the value of the fdsFilterList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFdsFilterList() {
        return fdsFilterList;
    }

    /**
     * Sets the value of the fdsFilterList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFdsFilterList(String value) {
        this.fdsFilterList = value;
    }

    /**
     * Gets the value of the fdsFilters property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFDSFilterDetails }
     *     
     */
    public ArrayOfFDSFilterDetails getFdsFilters() {
        return fdsFilters;
    }

    /**
     * Sets the value of the fdsFilters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFDSFilterDetails }
     *     
     */
    public void setFdsFilters(ArrayOfFDSFilterDetails value) {
        this.fdsFilters = value;
    }

    /**
     * Gets the value of the dccStatus property.
     * 
     */
    public int getDccStatus() {
        return dccStatus;
    }

    /**
     * Sets the value of the dccStatus property.
     * 
     */
    public void setDccStatus(int value) {
        this.dccStatus = value;
    }

    /**
     * Gets the value of the canIssueCredit property.
     * 
     */
    public int getCanIssueCredit() {
        return canIssueCredit;
    }

    /**
     * Sets the value of the canIssueCredit property.
     * 
     */
    public void setCanIssueCredit(int value) {
        this.canIssueCredit = value;
    }

    /**
     * Gets the value of the lineItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLineItem }
     *     
     */
    public ArrayOfLineItem getLineItems() {
        return lineItems;
    }

    /**
     * Sets the value of the lineItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLineItem }
     *     
     */
    public void setLineItems(ArrayOfLineItem value) {
        this.lineItems = value;
    }

    /**
     * Gets the value of the paymentMethodLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethodLabel() {
        return paymentMethodLabel;
    }

    /**
     * Sets the value of the paymentMethodLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethodLabel(String value) {
        this.paymentMethodLabel = value;
    }

    /**
     * Gets the value of the paymentMethodFeatureSetID property.
     * 
     */
    public int getPaymentMethodFeatureSetID() {
        return paymentMethodFeatureSetID;
    }

    /**
     * Sets the value of the paymentMethodFeatureSetID property.
     * 
     */
    public void setPaymentMethodFeatureSetID(int value) {
        this.paymentMethodFeatureSetID = value;
    }

    /**
     * Gets the value of the responseMajorCode property.
     * 
     */
    public int getResponseMajorCode() {
        return responseMajorCode;
    }

    /**
     * Sets the value of the responseMajorCode property.
     * 
     */
    public void setResponseMajorCode(int value) {
        this.responseMajorCode = value;
    }

    /**
     * Gets the value of the responseCustomerMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCustomerMessage() {
        return responseCustomerMessage;
    }

    /**
     * Sets the value of the responseCustomerMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCustomerMessage(String value) {
        this.responseCustomerMessage = value;
    }

    /**
     * Gets the value of the responseDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseDescription() {
        return responseDescription;
    }

    /**
     * Sets the value of the responseDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseDescription(String value) {
        this.responseDescription = value;
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
     * Gets the value of the sourceIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceIP() {
        return sourceIP;
    }

    /**
     * Sets the value of the sourceIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceIP(String value) {
        this.sourceIP = value;
    }

    /**
     * Gets the value of the splitTenderID property.
     * 
     */
    public int getSplitTenderID() {
        return splitTenderID;
    }

    /**
     * Sets the value of the splitTenderID property.
     * 
     */
    public void setSplitTenderID(int value) {
        this.splitTenderID = value;
    }

    /**
     * Gets the value of the vaultTransactionCount property.
     * 
     */
    public int getVaultTransactionCount() {
        return vaultTransactionCount;
    }

    /**
     * Sets the value of the vaultTransactionCount property.
     * 
     */
    public void setVaultTransactionCount(int value) {
        this.vaultTransactionCount = value;
    }

    /**
     * Gets the value of the prepaidRemainingBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrepaidRemainingBalance() {
        return prepaidRemainingBalance;
    }

    /**
     * Sets the value of the prepaidRemainingBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrepaidRemainingBalance(BigDecimal value) {
        this.prepaidRemainingBalance = value;
    }

    /**
     * Gets the value of the isPrepaidCard property.
     * 
     */
    public boolean isIsPrepaidCard() {
        return isPrepaidCard;
    }

    /**
     * Sets the value of the isPrepaidCard property.
     * 
     */
    public void setIsPrepaidCard(boolean value) {
        this.isPrepaidCard = value;
    }

    /**
     * Gets the value of the prepaidRequestedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrepaidRequestedAmount() {
        return prepaidRequestedAmount;
    }

    /**
     * Sets the value of the prepaidRequestedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrepaidRequestedAmount(BigDecimal value) {
        this.prepaidRequestedAmount = value;
    }

    /**
     * Gets the value of the mobileDeviceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileDeviceID() {
        return mobileDeviceID;
    }

    /**
     * Sets the value of the mobileDeviceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileDeviceID(String value) {
        this.mobileDeviceID = value;
    }

    /**
     * Gets the value of the returnedItemInfos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfReturnedItemInfo }
     *     
     */
    public ArrayOfReturnedItemInfo getReturnedItemInfos() {
        return returnedItemInfos;
    }

    /**
     * Sets the value of the returnedItemInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfReturnedItemInfo }
     *     
     */
    public void setReturnedItemInfos(ArrayOfReturnedItemInfo value) {
        this.returnedItemInfos = value;
    }

    /**
     * Gets the value of the solution property.
     * 
     * @return
     *     possible object is
     *     {@link SolutionInfo }
     *     
     */
    public SolutionInfo getSolution() {
        return solution;
    }

    /**
     * Sets the value of the solution property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolutionInfo }
     *     
     */
    public void setSolution(SolutionInfo value) {
        this.solution = value;
    }

}

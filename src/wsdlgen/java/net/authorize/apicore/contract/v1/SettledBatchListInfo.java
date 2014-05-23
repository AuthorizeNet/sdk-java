
package net.authorize.apicore.contract.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SettledBatchListInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SettledBatchListInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatchID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SettledTimeStampUTC" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SettledTimeStampLocal" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SettlementState" type="{http://api.authorize.net/ANetApiWS/}SettlementState"/>
 *         &lt;element name="paymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrencyID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardType" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="DCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DeclineCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ErrorCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ChargeChargeBackAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ChargeChargeBackCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RefundChargeBackAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RefundChargeBackCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ChargeReturnedItemsAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ChargeReturnedItemsCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RefundReturnedItemsAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RefundReturnedItemsCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ReturnedItemAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ReturnedItemCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ChargebackAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ChargebackCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CorrectionNoticeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MarketType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettledBatchListInfo", propOrder = {
    "batchID",
    "settledTimeStampUTC",
    "settledTimeStampLocal",
    "settlementState",
    "paymentMethod",
    "currencyID",
    "currencyCode",
    "cardType",
    "dCount",
    "dAmount",
    "cCount",
    "cAmount",
    "vCount",
    "declineCount",
    "errorCount",
    "chargeChargeBackAmount",
    "chargeChargeBackCount",
    "refundChargeBackAmount",
    "refundChargeBackCount",
    "chargeReturnedItemsAmount",
    "chargeReturnedItemsCount",
    "refundReturnedItemsAmount",
    "refundReturnedItemsCount",
    "returnedItemAmount",
    "returnedItemCount",
    "chargebackAmount",
    "chargebackCount",
    "correctionNoticeCount",
    "marketType",
    "product"
})
public class SettledBatchListInfo {

    @XmlElement(name = "BatchID")
    protected String batchID;
    @XmlElement(name = "SettledTimeStampUTC", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar settledTimeStampUTC;
    @XmlElement(name = "SettledTimeStampLocal", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar settledTimeStampLocal;
    @XmlElement(name = "SettlementState", required = true)
    @XmlSchemaType(name = "string")
    protected SettlementState settlementState;
    protected String paymentMethod;
    @XmlElement(name = "CurrencyID")
    protected int currencyID;
    @XmlElement(name = "CurrencyCode")
    protected String currencyCode;
    @XmlElement(name = "CardType")
    @XmlSchemaType(name = "unsignedShort")
    protected int cardType;
    @XmlElement(name = "DCount")
    protected int dCount;
    @XmlElement(name = "DAmount", required = true)
    protected BigDecimal dAmount;
    @XmlElement(name = "CCount")
    protected int cCount;
    @XmlElement(name = "CAmount", required = true)
    protected BigDecimal cAmount;
    @XmlElement(name = "VCount")
    protected int vCount;
    @XmlElement(name = "DeclineCount")
    protected int declineCount;
    @XmlElement(name = "ErrorCount")
    protected int errorCount;
    @XmlElement(name = "ChargeChargeBackAmount", required = true)
    protected BigDecimal chargeChargeBackAmount;
    @XmlElement(name = "ChargeChargeBackCount")
    protected int chargeChargeBackCount;
    @XmlElement(name = "RefundChargeBackAmount", required = true)
    protected BigDecimal refundChargeBackAmount;
    @XmlElement(name = "RefundChargeBackCount")
    protected int refundChargeBackCount;
    @XmlElement(name = "ChargeReturnedItemsAmount", required = true)
    protected BigDecimal chargeReturnedItemsAmount;
    @XmlElement(name = "ChargeReturnedItemsCount")
    protected int chargeReturnedItemsCount;
    @XmlElement(name = "RefundReturnedItemsAmount", required = true)
    protected BigDecimal refundReturnedItemsAmount;
    @XmlElement(name = "RefundReturnedItemsCount")
    protected int refundReturnedItemsCount;
    @XmlElement(name = "ReturnedItemAmount", required = true)
    protected BigDecimal returnedItemAmount;
    @XmlElement(name = "ReturnedItemCount")
    protected int returnedItemCount;
    @XmlElement(name = "ChargebackAmount", required = true)
    protected BigDecimal chargebackAmount;
    @XmlElement(name = "ChargebackCount")
    protected int chargebackCount;
    @XmlElement(name = "CorrectionNoticeCount")
    protected int correctionNoticeCount;
    @XmlElement(name = "MarketType")
    protected String marketType;
    @XmlElement(name = "Product")
    protected String product;

    /**
     * Gets the value of the batchID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchID() {
        return batchID;
    }

    /**
     * Sets the value of the batchID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchID(String value) {
        this.batchID = value;
    }

    /**
     * Gets the value of the settledTimeStampUTC property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSettledTimeStampUTC() {
        return settledTimeStampUTC;
    }

    /**
     * Sets the value of the settledTimeStampUTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSettledTimeStampUTC(XMLGregorianCalendar value) {
        this.settledTimeStampUTC = value;
    }

    /**
     * Gets the value of the settledTimeStampLocal property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSettledTimeStampLocal() {
        return settledTimeStampLocal;
    }

    /**
     * Sets the value of the settledTimeStampLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSettledTimeStampLocal(XMLGregorianCalendar value) {
        this.settledTimeStampLocal = value;
    }

    /**
     * Gets the value of the settlementState property.
     * 
     * @return
     *     possible object is
     *     {@link SettlementState }
     *     
     */
    public SettlementState getSettlementState() {
        return settlementState;
    }

    /**
     * Sets the value of the settlementState property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementState }
     *     
     */
    public void setSettlementState(SettlementState value) {
        this.settlementState = value;
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
     * Gets the value of the dCount property.
     * 
     */
    public int getDCount() {
        return dCount;
    }

    /**
     * Sets the value of the dCount property.
     * 
     */
    public void setDCount(int value) {
        this.dCount = value;
    }

    /**
     * Gets the value of the dAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDAmount() {
        return dAmount;
    }

    /**
     * Sets the value of the dAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDAmount(BigDecimal value) {
        this.dAmount = value;
    }

    /**
     * Gets the value of the cCount property.
     * 
     */
    public int getCCount() {
        return cCount;
    }

    /**
     * Sets the value of the cCount property.
     * 
     */
    public void setCCount(int value) {
        this.cCount = value;
    }

    /**
     * Gets the value of the cAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCAmount() {
        return cAmount;
    }

    /**
     * Sets the value of the cAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCAmount(BigDecimal value) {
        this.cAmount = value;
    }

    /**
     * Gets the value of the vCount property.
     * 
     */
    public int getVCount() {
        return vCount;
    }

    /**
     * Sets the value of the vCount property.
     * 
     */
    public void setVCount(int value) {
        this.vCount = value;
    }

    /**
     * Gets the value of the declineCount property.
     * 
     */
    public int getDeclineCount() {
        return declineCount;
    }

    /**
     * Sets the value of the declineCount property.
     * 
     */
    public void setDeclineCount(int value) {
        this.declineCount = value;
    }

    /**
     * Gets the value of the errorCount property.
     * 
     */
    public int getErrorCount() {
        return errorCount;
    }

    /**
     * Sets the value of the errorCount property.
     * 
     */
    public void setErrorCount(int value) {
        this.errorCount = value;
    }

    /**
     * Gets the value of the chargeChargeBackAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChargeChargeBackAmount() {
        return chargeChargeBackAmount;
    }

    /**
     * Sets the value of the chargeChargeBackAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChargeChargeBackAmount(BigDecimal value) {
        this.chargeChargeBackAmount = value;
    }

    /**
     * Gets the value of the chargeChargeBackCount property.
     * 
     */
    public int getChargeChargeBackCount() {
        return chargeChargeBackCount;
    }

    /**
     * Sets the value of the chargeChargeBackCount property.
     * 
     */
    public void setChargeChargeBackCount(int value) {
        this.chargeChargeBackCount = value;
    }

    /**
     * Gets the value of the refundChargeBackAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRefundChargeBackAmount() {
        return refundChargeBackAmount;
    }

    /**
     * Sets the value of the refundChargeBackAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRefundChargeBackAmount(BigDecimal value) {
        this.refundChargeBackAmount = value;
    }

    /**
     * Gets the value of the refundChargeBackCount property.
     * 
     */
    public int getRefundChargeBackCount() {
        return refundChargeBackCount;
    }

    /**
     * Sets the value of the refundChargeBackCount property.
     * 
     */
    public void setRefundChargeBackCount(int value) {
        this.refundChargeBackCount = value;
    }

    /**
     * Gets the value of the chargeReturnedItemsAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChargeReturnedItemsAmount() {
        return chargeReturnedItemsAmount;
    }

    /**
     * Sets the value of the chargeReturnedItemsAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChargeReturnedItemsAmount(BigDecimal value) {
        this.chargeReturnedItemsAmount = value;
    }

    /**
     * Gets the value of the chargeReturnedItemsCount property.
     * 
     */
    public int getChargeReturnedItemsCount() {
        return chargeReturnedItemsCount;
    }

    /**
     * Sets the value of the chargeReturnedItemsCount property.
     * 
     */
    public void setChargeReturnedItemsCount(int value) {
        this.chargeReturnedItemsCount = value;
    }

    /**
     * Gets the value of the refundReturnedItemsAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRefundReturnedItemsAmount() {
        return refundReturnedItemsAmount;
    }

    /**
     * Sets the value of the refundReturnedItemsAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRefundReturnedItemsAmount(BigDecimal value) {
        this.refundReturnedItemsAmount = value;
    }

    /**
     * Gets the value of the refundReturnedItemsCount property.
     * 
     */
    public int getRefundReturnedItemsCount() {
        return refundReturnedItemsCount;
    }

    /**
     * Sets the value of the refundReturnedItemsCount property.
     * 
     */
    public void setRefundReturnedItemsCount(int value) {
        this.refundReturnedItemsCount = value;
    }

    /**
     * Gets the value of the returnedItemAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getReturnedItemAmount() {
        return returnedItemAmount;
    }

    /**
     * Sets the value of the returnedItemAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setReturnedItemAmount(BigDecimal value) {
        this.returnedItemAmount = value;
    }

    /**
     * Gets the value of the returnedItemCount property.
     * 
     */
    public int getReturnedItemCount() {
        return returnedItemCount;
    }

    /**
     * Sets the value of the returnedItemCount property.
     * 
     */
    public void setReturnedItemCount(int value) {
        this.returnedItemCount = value;
    }

    /**
     * Gets the value of the chargebackAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChargebackAmount() {
        return chargebackAmount;
    }

    /**
     * Sets the value of the chargebackAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChargebackAmount(BigDecimal value) {
        this.chargebackAmount = value;
    }

    /**
     * Gets the value of the chargebackCount property.
     * 
     */
    public int getChargebackCount() {
        return chargebackCount;
    }

    /**
     * Sets the value of the chargebackCount property.
     * 
     */
    public void setChargebackCount(int value) {
        this.chargebackCount = value;
    }

    /**
     * Gets the value of the correctionNoticeCount property.
     * 
     */
    public int getCorrectionNoticeCount() {
        return correctionNoticeCount;
    }

    /**
     * Sets the value of the correctionNoticeCount property.
     * 
     */
    public void setCorrectionNoticeCount(int value) {
        this.correctionNoticeCount = value;
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

}

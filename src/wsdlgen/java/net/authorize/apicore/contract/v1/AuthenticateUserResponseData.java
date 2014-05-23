
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthenticateUserResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthenticateUserResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="UserLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AccountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TestMode" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SessionToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MobilePermissions" type="{http://api.authorize.net/ANetApiWS/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="MerchantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiptReplyTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiptReplyTo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HeaderHTMLReceipt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FooterHTMLReceipt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TimeZoneInfoID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GMTOffsetInMins" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StdAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DstAbbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MarketTypeID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ApiKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthenticateUserResponseData", propOrder = {
    "userLogin",
    "userId",
    "accountId",
    "active",
    "testMode",
    "sessionToken",
    "mobilePermissions",
    "merchantName",
    "merchantAddress",
    "merchantCity",
    "merchantState",
    "merchantZip",
    "merchantPhone",
    "receiptReplyTo",
    "receiptReplyTo2",
    "headerHTMLReceipt",
    "footerHTMLReceipt",
    "timeZoneInfoID",
    "gmtOffsetInMins",
    "stdAbbreviation",
    "dstAbbreviation",
    "marketTypeID",
    "apiKey"
})
public class AuthenticateUserResponseData
    extends BaseResponseData
{

    @XmlElement(name = "UserLogin")
    protected String userLogin;
    @XmlElement(name = "UserId")
    protected long userId;
    @XmlElement(name = "AccountId")
    protected long accountId;
    @XmlElement(name = "Active")
    protected Boolean active;
    @XmlElement(name = "TestMode")
    protected Boolean testMode;
    @XmlElement(name = "SessionToken")
    protected String sessionToken;
    @XmlElement(name = "MobilePermissions")
    protected ArrayOfString mobilePermissions;
    @XmlElement(name = "MerchantName")
    protected String merchantName;
    @XmlElement(name = "MerchantAddress")
    protected String merchantAddress;
    @XmlElement(name = "MerchantCity")
    protected String merchantCity;
    @XmlElement(name = "MerchantState")
    protected String merchantState;
    @XmlElement(name = "MerchantZip")
    protected String merchantZip;
    @XmlElement(name = "MerchantPhone")
    protected String merchantPhone;
    @XmlElement(name = "ReceiptReplyTo")
    protected String receiptReplyTo;
    @XmlElement(name = "ReceiptReplyTo2")
    protected String receiptReplyTo2;
    @XmlElement(name = "HeaderHTMLReceipt")
    protected String headerHTMLReceipt;
    @XmlElement(name = "FooterHTMLReceipt")
    protected String footerHTMLReceipt;
    @XmlElement(name = "TimeZoneInfoID")
    protected String timeZoneInfoID;
    @XmlElement(name = "GMTOffsetInMins")
    protected int gmtOffsetInMins;
    @XmlElement(name = "StdAbbreviation")
    protected String stdAbbreviation;
    @XmlElement(name = "DstAbbreviation")
    protected String dstAbbreviation;
    @XmlElement(name = "MarketTypeID")
    protected int marketTypeID;
    @XmlElement(name = "ApiKey")
    protected String apiKey;

    /**
     * Gets the value of the userLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * Sets the value of the userLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLogin(String value) {
        this.userLogin = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the testMode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTestMode() {
        return testMode;
    }

    /**
     * Sets the value of the testMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTestMode(Boolean value) {
        this.testMode = value;
    }

    /**
     * Gets the value of the sessionToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionToken() {
        return sessionToken;
    }

    /**
     * Sets the value of the sessionToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionToken(String value) {
        this.sessionToken = value;
    }

    /**
     * Gets the value of the mobilePermissions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getMobilePermissions() {
        return mobilePermissions;
    }

    /**
     * Sets the value of the mobilePermissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setMobilePermissions(ArrayOfString value) {
        this.mobilePermissions = value;
    }

    /**
     * Gets the value of the merchantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * Sets the value of the merchantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantName(String value) {
        this.merchantName = value;
    }

    /**
     * Gets the value of the merchantAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantAddress() {
        return merchantAddress;
    }

    /**
     * Sets the value of the merchantAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantAddress(String value) {
        this.merchantAddress = value;
    }

    /**
     * Gets the value of the merchantCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantCity() {
        return merchantCity;
    }

    /**
     * Sets the value of the merchantCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantCity(String value) {
        this.merchantCity = value;
    }

    /**
     * Gets the value of the merchantState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantState() {
        return merchantState;
    }

    /**
     * Sets the value of the merchantState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantState(String value) {
        this.merchantState = value;
    }

    /**
     * Gets the value of the merchantZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantZip() {
        return merchantZip;
    }

    /**
     * Sets the value of the merchantZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantZip(String value) {
        this.merchantZip = value;
    }

    /**
     * Gets the value of the merchantPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantPhone() {
        return merchantPhone;
    }

    /**
     * Sets the value of the merchantPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantPhone(String value) {
        this.merchantPhone = value;
    }

    /**
     * Gets the value of the receiptReplyTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptReplyTo() {
        return receiptReplyTo;
    }

    /**
     * Sets the value of the receiptReplyTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptReplyTo(String value) {
        this.receiptReplyTo = value;
    }

    /**
     * Gets the value of the receiptReplyTo2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptReplyTo2() {
        return receiptReplyTo2;
    }

    /**
     * Sets the value of the receiptReplyTo2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptReplyTo2(String value) {
        this.receiptReplyTo2 = value;
    }

    /**
     * Gets the value of the headerHTMLReceipt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeaderHTMLReceipt() {
        return headerHTMLReceipt;
    }

    /**
     * Sets the value of the headerHTMLReceipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeaderHTMLReceipt(String value) {
        this.headerHTMLReceipt = value;
    }

    /**
     * Gets the value of the footerHTMLReceipt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFooterHTMLReceipt() {
        return footerHTMLReceipt;
    }

    /**
     * Sets the value of the footerHTMLReceipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFooterHTMLReceipt(String value) {
        this.footerHTMLReceipt = value;
    }

    /**
     * Gets the value of the timeZoneInfoID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZoneInfoID() {
        return timeZoneInfoID;
    }

    /**
     * Sets the value of the timeZoneInfoID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZoneInfoID(String value) {
        this.timeZoneInfoID = value;
    }

    /**
     * Gets the value of the gmtOffsetInMins property.
     * 
     */
    public int getGMTOffsetInMins() {
        return gmtOffsetInMins;
    }

    /**
     * Sets the value of the gmtOffsetInMins property.
     * 
     */
    public void setGMTOffsetInMins(int value) {
        this.gmtOffsetInMins = value;
    }

    /**
     * Gets the value of the stdAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStdAbbreviation() {
        return stdAbbreviation;
    }

    /**
     * Sets the value of the stdAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStdAbbreviation(String value) {
        this.stdAbbreviation = value;
    }

    /**
     * Gets the value of the dstAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDstAbbreviation() {
        return dstAbbreviation;
    }

    /**
     * Sets the value of the dstAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDstAbbreviation(String value) {
        this.dstAbbreviation = value;
    }

    /**
     * Gets the value of the marketTypeID property.
     * 
     */
    public int getMarketTypeID() {
        return marketTypeID;
    }

    /**
     * Sets the value of the marketTypeID property.
     * 
     */
    public void setMarketTypeID(int value) {
        this.marketTypeID = value;
    }

    /**
     * Gets the value of the apiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the value of the apiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiKey(String value) {
        this.apiKey = value;
    }

}

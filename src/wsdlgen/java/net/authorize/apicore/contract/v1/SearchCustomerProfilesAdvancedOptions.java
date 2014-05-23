
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SearchCustomerProfilesAdvancedOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchCustomerProfilesAdvancedOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RowLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RowOffset" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CustomerProfileID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MerchantCustomerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IncludePaymentProfiles" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IncludeShippingAddresses" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentProfileID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CustomerType" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerTypeEnum" minOccurs="0"/>
 *         &lt;element name="CardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardExpirationDate" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/>
 *         &lt;element name="BankAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankRoutingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameOnAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccountType" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}bankAccountTypeEnum" minOccurs="0"/>
 *         &lt;element name="BankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShippingAddressID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SortMethod" type="{http://api.authorize.net/ANetApiWS/}SearchCustomerProfilesAdvancedSortMethod"/>
 *         &lt;element name="SortDescending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchCustomerProfilesAdvancedOptions", propOrder = {
    "rowLimit",
    "rowOffset",
    "customerProfileID",
    "merchantCustomerID",
    "email",
    "description",
    "includePaymentProfiles",
    "includeShippingAddresses",
    "company",
    "firstName",
    "lastName",
    "address",
    "city",
    "stateProv",
    "zip",
    "country",
    "phone",
    "fax",
    "paymentProfileID",
    "customerType",
    "cardNumber",
    "cardExpirationDate",
    "bankAccountNumber",
    "bankRoutingNumber",
    "nameOnAccount",
    "bankAccountType",
    "bankName",
    "shippingAddressID",
    "sortMethod",
    "sortDescending"
})
public class SearchCustomerProfilesAdvancedOptions {

    @XmlElement(name = "RowLimit")
    protected int rowLimit;
    @XmlElement(name = "RowOffset")
    protected int rowOffset;
    @XmlElement(name = "CustomerProfileID")
    protected long customerProfileID;
    @XmlElement(name = "MerchantCustomerID")
    protected String merchantCustomerID;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "IncludePaymentProfiles")
    protected boolean includePaymentProfiles;
    @XmlElement(name = "IncludeShippingAddresses")
    protected boolean includeShippingAddresses;
    @XmlElement(name = "Company")
    protected String company;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "StateProv")
    protected String stateProv;
    @XmlElement(name = "Zip")
    protected String zip;
    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "Phone")
    protected String phone;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "PaymentProfileID")
    protected long paymentProfileID;
    @XmlElement(name = "CustomerType")
    @XmlSchemaType(name = "string")
    protected CustomerTypeEnum customerType;
    @XmlElement(name = "CardNumber")
    protected String cardNumber;
    @XmlElement(name = "CardExpirationDate")
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar cardExpirationDate;
    @XmlElement(name = "BankAccountNumber")
    protected String bankAccountNumber;
    @XmlElement(name = "BankRoutingNumber")
    protected String bankRoutingNumber;
    @XmlElement(name = "NameOnAccount")
    protected String nameOnAccount;
    @XmlElement(name = "BankAccountType")
    @XmlSchemaType(name = "string")
    protected BankAccountTypeEnum bankAccountType;
    @XmlElement(name = "BankName")
    protected String bankName;
    @XmlElement(name = "ShippingAddressID")
    protected long shippingAddressID;
    @XmlElement(name = "SortMethod", required = true)
    @XmlSchemaType(name = "string")
    protected SearchCustomerProfilesAdvancedSortMethod sortMethod;
    @XmlElement(name = "SortDescending")
    protected boolean sortDescending;

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
     * Gets the value of the rowOffset property.
     * 
     */
    public int getRowOffset() {
        return rowOffset;
    }

    /**
     * Sets the value of the rowOffset property.
     * 
     */
    public void setRowOffset(int value) {
        this.rowOffset = value;
    }

    /**
     * Gets the value of the customerProfileID property.
     * 
     */
    public long getCustomerProfileID() {
        return customerProfileID;
    }

    /**
     * Sets the value of the customerProfileID property.
     * 
     */
    public void setCustomerProfileID(long value) {
        this.customerProfileID = value;
    }

    /**
     * Gets the value of the merchantCustomerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantCustomerID() {
        return merchantCustomerID;
    }

    /**
     * Sets the value of the merchantCustomerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantCustomerID(String value) {
        this.merchantCustomerID = value;
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
     * Gets the value of the includePaymentProfiles property.
     * 
     */
    public boolean isIncludePaymentProfiles() {
        return includePaymentProfiles;
    }

    /**
     * Sets the value of the includePaymentProfiles property.
     * 
     */
    public void setIncludePaymentProfiles(boolean value) {
        this.includePaymentProfiles = value;
    }

    /**
     * Gets the value of the includeShippingAddresses property.
     * 
     */
    public boolean isIncludeShippingAddresses() {
        return includeShippingAddresses;
    }

    /**
     * Sets the value of the includeShippingAddresses property.
     * 
     */
    public void setIncludeShippingAddresses(boolean value) {
        this.includeShippingAddresses = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
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
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the stateProv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateProv() {
        return stateProv;
    }

    /**
     * Sets the value of the stateProv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateProv(String value) {
        this.stateProv = value;
    }

    /**
     * Gets the value of the zip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZip(String value) {
        this.zip = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
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
     * Gets the value of the customerType property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerTypeEnum }
     *     
     */
    public CustomerTypeEnum getCustomerType() {
        return customerType;
    }

    /**
     * Sets the value of the customerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerTypeEnum }
     *     
     */
    public void setCustomerType(CustomerTypeEnum value) {
        this.customerType = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the cardExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCardExpirationDate() {
        return cardExpirationDate;
    }

    /**
     * Sets the value of the cardExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCardExpirationDate(XMLGregorianCalendar value) {
        this.cardExpirationDate = value;
    }

    /**
     * Gets the value of the bankAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * Sets the value of the bankAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountNumber(String value) {
        this.bankAccountNumber = value;
    }

    /**
     * Gets the value of the bankRoutingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankRoutingNumber() {
        return bankRoutingNumber;
    }

    /**
     * Sets the value of the bankRoutingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankRoutingNumber(String value) {
        this.bankRoutingNumber = value;
    }

    /**
     * Gets the value of the nameOnAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOnAccount() {
        return nameOnAccount;
    }

    /**
     * Sets the value of the nameOnAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOnAccount(String value) {
        this.nameOnAccount = value;
    }

    /**
     * Gets the value of the bankAccountType property.
     * 
     * @return
     *     possible object is
     *     {@link BankAccountTypeEnum }
     *     
     */
    public BankAccountTypeEnum getBankAccountType() {
        return bankAccountType;
    }

    /**
     * Sets the value of the bankAccountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccountTypeEnum }
     *     
     */
    public void setBankAccountType(BankAccountTypeEnum value) {
        this.bankAccountType = value;
    }

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
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
     * Gets the value of the sortMethod property.
     * 
     * @return
     *     possible object is
     *     {@link SearchCustomerProfilesAdvancedSortMethod }
     *     
     */
    public SearchCustomerProfilesAdvancedSortMethod getSortMethod() {
        return sortMethod;
    }

    /**
     * Sets the value of the sortMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCustomerProfilesAdvancedSortMethod }
     *     
     */
    public void setSortMethod(SearchCustomerProfilesAdvancedSortMethod value) {
        this.sortMethod = value;
    }

    /**
     * Gets the value of the sortDescending property.
     * 
     */
    public boolean isSortDescending() {
        return sortDescending;
    }

    /**
     * Sets the value of the sortDescending property.
     * 
     */
    public void setSortDescending(boolean value) {
        this.sortDescending = value;
    }

}

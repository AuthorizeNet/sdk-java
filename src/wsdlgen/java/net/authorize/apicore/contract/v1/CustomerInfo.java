
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Payment" type="{http://www.infospace.com/anet/Subscription.xsd}PaymentInfo" minOccurs="0"/>
 *         &lt;element name="ShipToAddress" type="{http://www.infospace.com/anet/Subscription.xsd}Address" minOccurs="0"/>
 *         &lt;element name="BillingInfo" type="{http://www.infospace.com/anet/Subscription.xsd}BillingInfo" minOccurs="0"/>
 *         &lt;element name="DriversLicense" type="{http://www.infospace.com/anet/Subscription.xsd}DriversLicenseInfo" minOccurs="0"/>
 *         &lt;element name="CustomerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerTaxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerInfo", namespace = "http://www.infospace.com/anet/Subscription.xsd", propOrder = {
    "customerType",
    "payment",
    "shipToAddress",
    "billingInfo",
    "driversLicense",
    "customerID",
    "customerTaxID"
})
public class CustomerInfo {

    @XmlElement(name = "CustomerType")
    protected String customerType;
    @XmlElement(name = "Payment")
    protected PaymentInfo payment;
    @XmlElement(name = "ShipToAddress")
    protected Address shipToAddress;
    @XmlElement(name = "BillingInfo")
    protected BillingInfo billingInfo;
    @XmlElement(name = "DriversLicense")
    protected DriversLicenseInfo driversLicense;
    @XmlElement(name = "CustomerID")
    protected String customerID;
    @XmlElement(name = "CustomerTaxID")
    protected String customerTaxID;

    /**
     * Gets the value of the customerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * Sets the value of the customerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerType(String value) {
        this.customerType = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInfo }
     *     
     */
    public PaymentInfo getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInfo }
     *     
     */
    public void setPayment(PaymentInfo value) {
        this.payment = value;
    }

    /**
     * Gets the value of the shipToAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getShipToAddress() {
        return shipToAddress;
    }

    /**
     * Sets the value of the shipToAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setShipToAddress(Address value) {
        this.shipToAddress = value;
    }

    /**
     * Gets the value of the billingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BillingInfo }
     *     
     */
    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    /**
     * Sets the value of the billingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingInfo }
     *     
     */
    public void setBillingInfo(BillingInfo value) {
        this.billingInfo = value;
    }

    /**
     * Gets the value of the driversLicense property.
     * 
     * @return
     *     possible object is
     *     {@link DriversLicenseInfo }
     *     
     */
    public DriversLicenseInfo getDriversLicense() {
        return driversLicense;
    }

    /**
     * Sets the value of the driversLicense property.
     * 
     * @param value
     *     allowed object is
     *     {@link DriversLicenseInfo }
     *     
     */
    public void setDriversLicense(DriversLicenseInfo value) {
        this.driversLicense = value;
    }

    /**
     * Gets the value of the customerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Sets the value of the customerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerID(String value) {
        this.customerID = value;
    }

    /**
     * Gets the value of the customerTaxID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerTaxID() {
        return customerTaxID;
    }

    /**
     * Sets the value of the customerTaxID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerTaxID(String value) {
        this.customerTaxID = value;
    }

}

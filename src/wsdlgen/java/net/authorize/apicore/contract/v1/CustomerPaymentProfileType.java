
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerPaymentProfileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerPaymentProfileType">
 *   &lt;complexContent>
 *     &lt;extension base="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerPaymentProfileBaseType">
 *       &lt;sequence>
 *         &lt;element name="payment" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}paymentType" minOccurs="0"/>
 *         &lt;element name="driversLicense" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}driversLicenseType" minOccurs="0"/>
 *         &lt;element name="taxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerPaymentProfileType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "payment",
    "driversLicense",
    "taxId"
})
@XmlSeeAlso({
    CustomerPaymentProfileExType.class
})
public class CustomerPaymentProfileType
    extends CustomerPaymentProfileBaseType
{

    protected PaymentType payment;
    protected DriversLicenseType driversLicense;
    protected String taxId;

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentType }
     *     
     */
    public PaymentType getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType }
     *     
     */
    public void setPayment(PaymentType value) {
        this.payment = value;
    }

    /**
     * Gets the value of the driversLicense property.
     * 
     * @return
     *     possible object is
     *     {@link DriversLicenseType }
     *     
     */
    public DriversLicenseType getDriversLicense() {
        return driversLicense;
    }

    /**
     * Sets the value of the driversLicense property.
     * 
     * @param value
     *     allowed object is
     *     {@link DriversLicenseType }
     *     
     */
    public void setDriversLicense(DriversLicenseType value) {
        this.driversLicense = value;
    }

    /**
     * Gets the value of the taxId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * Sets the value of the taxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxId(String value) {
        this.taxId = value;
    }

}

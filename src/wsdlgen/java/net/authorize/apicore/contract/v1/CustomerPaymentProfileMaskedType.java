
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerPaymentProfileMaskedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerPaymentProfileMaskedType">
 *   &lt;complexContent>
 *     &lt;extension base="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerPaymentProfileBaseType">
 *       &lt;sequence>
 *         &lt;element name="customerPaymentProfileId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payment" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}paymentMaskedType" minOccurs="0"/>
 *         &lt;element name="driversLicense" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}driversLicenseMaskedType" minOccurs="0"/>
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
@XmlType(name = "customerPaymentProfileMaskedType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "customerPaymentProfileId",
    "payment",
    "driversLicense",
    "taxId"
})
public class CustomerPaymentProfileMaskedType
    extends CustomerPaymentProfileBaseType
{

    protected String customerPaymentProfileId;
    protected PaymentMaskedType payment;
    protected DriversLicenseMaskedType driversLicense;
    protected String taxId;

    /**
     * Gets the value of the customerPaymentProfileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerPaymentProfileId() {
        return customerPaymentProfileId;
    }

    /**
     * Sets the value of the customerPaymentProfileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerPaymentProfileId(String value) {
        this.customerPaymentProfileId = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMaskedType }
     *     
     */
    public PaymentMaskedType getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMaskedType }
     *     
     */
    public void setPayment(PaymentMaskedType value) {
        this.payment = value;
    }

    /**
     * Gets the value of the driversLicense property.
     * 
     * @return
     *     possible object is
     *     {@link DriversLicenseMaskedType }
     *     
     */
    public DriversLicenseMaskedType getDriversLicense() {
        return driversLicense;
    }

    /**
     * Sets the value of the driversLicense property.
     * 
     * @param value
     *     allowed object is
     *     {@link DriversLicenseMaskedType }
     *     
     */
    public void setDriversLicense(DriversLicenseMaskedType value) {
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

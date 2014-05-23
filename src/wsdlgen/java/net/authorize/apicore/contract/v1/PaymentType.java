
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paymentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="creditCard" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}creditCardType" minOccurs="0"/>
 *           &lt;element name="payPal" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}payPalType" minOccurs="0"/>
 *           &lt;element name="encryptedTrackData" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}encryptedTrackDataType" minOccurs="0"/>
 *           &lt;element name="bankAccount" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}bankAccountType" minOccurs="0"/>
 *           &lt;element name="trackData" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}creditCardTrackType" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paymentType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "creditCard",
    "payPal",
    "encryptedTrackData",
    "bankAccount",
    "trackData"
})
public class PaymentType {

    protected CreditCardType creditCard;
    protected PayPalType payPal;
    protected EncryptedTrackDataType encryptedTrackData;
    protected BankAccountType bankAccount;
    protected CreditCardTrackType trackData;

    /**
     * Gets the value of the creditCard property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardType }
     *     
     */
    public CreditCardType getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the value of the creditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardType }
     *     
     */
    public void setCreditCard(CreditCardType value) {
        this.creditCard = value;
    }

    /**
     * Gets the value of the payPal property.
     * 
     * @return
     *     possible object is
     *     {@link PayPalType }
     *     
     */
    public PayPalType getPayPal() {
        return payPal;
    }

    /**
     * Sets the value of the payPal property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayPalType }
     *     
     */
    public void setPayPal(PayPalType value) {
        this.payPal = value;
    }

    /**
     * Gets the value of the encryptedTrackData property.
     * 
     * @return
     *     possible object is
     *     {@link EncryptedTrackDataType }
     *     
     */
    public EncryptedTrackDataType getEncryptedTrackData() {
        return encryptedTrackData;
    }

    /**
     * Sets the value of the encryptedTrackData property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncryptedTrackDataType }
     *     
     */
    public void setEncryptedTrackData(EncryptedTrackDataType value) {
        this.encryptedTrackData = value;
    }

    /**
     * Gets the value of the bankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link BankAccountType }
     *     
     */
    public BankAccountType getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the value of the bankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccountType }
     *     
     */
    public void setBankAccount(BankAccountType value) {
        this.bankAccount = value;
    }

    /**
     * Gets the value of the trackData property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardTrackType }
     *     
     */
    public CreditCardTrackType getTrackData() {
        return trackData;
    }

    /**
     * Sets the value of the trackData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardTrackType }
     *     
     */
    public void setTrackData(CreditCardTrackType value) {
        this.trackData = value;
    }

}

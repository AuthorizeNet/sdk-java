//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.22 at 06:00:08 PM IST 
//


package net.authorize.api.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for auDeleteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="auDeleteType">
 *   &lt;complexContent>
 *     &lt;extension base="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}auDetailsType">
 *       &lt;sequence>
 *         &lt;element name="creditCard" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}creditCardMaskedType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "auDeleteType", propOrder = {
    "creditCard"
})
public class AuDeleteType
    extends AuDetailsType
{

    @XmlElement(required = true)
    protected CreditCardMaskedType creditCard;

    /**
     * Gets the value of the creditCard property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardMaskedType }
     *     
     */
    public CreditCardMaskedType getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the value of the creditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardMaskedType }
     *     
     */
    public void setCreditCard(CreditCardMaskedType value) {
        this.creditCard = value;
    }

}

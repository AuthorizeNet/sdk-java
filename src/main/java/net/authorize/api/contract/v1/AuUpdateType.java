//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.27 at 04:18:12 PM GMT+05:30 
//


package net.authorize.api.contract.v1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for auUpdateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="auUpdateType">
 *   &lt;complexContent>
 *     &lt;extension base="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}auDetailsType">
 *       &lt;sequence>
 *         &lt;element name="newCreditCard" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}creditCardMaskedType"/>
 *         &lt;element name="oldCreditCard" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}creditCardMaskedType"/>
 *         &lt;element name="subscriptionIdList" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}SubscriptionIdList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "auUpdateType", propOrder = {
    "newCreditCard",
    "oldCreditCard",
    "subscriptionIdList"
})
public class AuUpdateType
    extends AuDetailsType
{

    @XmlElement(required = true)
    protected CreditCardMaskedType newCreditCard;
    @XmlElement(required = true)
    protected CreditCardMaskedType oldCreditCard;
    
   	/*---Added for GetAccountUpdaterJobDetails---*/
    @XmlElement(required = true)
    protected SubscriptionIdList subscriptionIdList;
    
    public SubscriptionIdList getSubscriptionIdList() {
		return subscriptionIdList;
	}
	public void setSubscriptionIdList(SubscriptionIdList value) {
		this.subscriptionIdList = value;
	}
   /*---End---*/

	/**
     * Gets the value of the newCreditCard property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardMaskedType }
     *     
     */
    public CreditCardMaskedType getNewCreditCard() {
        return newCreditCard;
    }
	/**
     * Sets the value of the newCreditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardMaskedType }
     *     
     */
    public void setNewCreditCard(CreditCardMaskedType value) {
        this.newCreditCard = value;
    }

    /**
     * Gets the value of the oldCreditCard property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardMaskedType }
     *     
     */
    public CreditCardMaskedType getOldCreditCard() {
        return oldCreditCard;
    }

    /**
     * Sets the value of the oldCreditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardMaskedType }
     *     
     */
    public void setOldCreditCard(CreditCardMaskedType value) {
        this.oldCreditCard = value;
    }

}

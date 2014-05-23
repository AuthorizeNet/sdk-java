
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CreditCard" type="{http://www.infospace.com/anet/Subscription.xsd}CCInfo" minOccurs="0"/>
 *         &lt;element name="eCheck" type="{http://www.infospace.com/anet/Subscription.xsd}BankAccount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInfo", namespace = "http://www.infospace.com/anet/Subscription.xsd", propOrder = {
    "type",
    "creditCard",
    "eCheck"
})
public class PaymentInfo {

    protected int type;
    @XmlElement(name = "CreditCard")
    protected CCInfo creditCard;
    protected BankAccount eCheck;

    /**
     * Gets the value of the type property.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

    /**
     * Gets the value of the creditCard property.
     * 
     * @return
     *     possible object is
     *     {@link CCInfo }
     *     
     */
    public CCInfo getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the value of the creditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link CCInfo }
     *     
     */
    public void setCreditCard(CCInfo value) {
        this.creditCard = value;
    }

    /**
     * Gets the value of the eCheck property.
     * 
     * @return
     *     possible object is
     *     {@link BankAccount }
     *     
     */
    public BankAccount getECheck() {
        return eCheck;
    }

    /**
     * Sets the value of the eCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccount }
     *     
     */
    public void setECheck(BankAccount value) {
        this.eCheck = value;
    }

}

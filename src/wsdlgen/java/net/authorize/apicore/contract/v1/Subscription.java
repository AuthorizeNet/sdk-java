
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Subscription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Subscription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Hash" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="Article" type="{http://www.infospace.com/anet/Subscription.xsd}ARBArticle" minOccurs="0"/>
 *         &lt;element name="OrderInfo" type="{http://www.infospace.com/anet/Subscription.xsd}OrderInfo" minOccurs="0"/>
 *         &lt;element name="Recurrence" type="{http://www.infospace.com/anet/Subscription.xsd}Recurrence" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subscription", namespace = "http://www.infospace.com/anet/Subscription.xsd", propOrder = {
    "id",
    "hash",
    "article",
    "orderInfo",
    "recurrence"
})
public class Subscription {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "Hash")
    protected byte[] hash;
    @XmlElement(name = "Article")
    protected ARBArticle article;
    @XmlElement(name = "OrderInfo")
    protected OrderInfo orderInfo;
    @XmlElement(name = "Recurrence")
    protected Recurrence recurrence;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setID(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the hash property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getHash() {
        return hash;
    }

    /**
     * Sets the value of the hash property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setHash(byte[] value) {
        this.hash = value;
    }

    /**
     * Gets the value of the article property.
     * 
     * @return
     *     possible object is
     *     {@link ARBArticle }
     *     
     */
    public ARBArticle getArticle() {
        return article;
    }

    /**
     * Sets the value of the article property.
     * 
     * @param value
     *     allowed object is
     *     {@link ARBArticle }
     *     
     */
    public void setArticle(ARBArticle value) {
        this.article = value;
    }

    /**
     * Gets the value of the orderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link OrderInfo }
     *     
     */
    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    /**
     * Sets the value of the orderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderInfo }
     *     
     */
    public void setOrderInfo(OrderInfo value) {
        this.orderInfo = value;
    }

    /**
     * Gets the value of the recurrence property.
     * 
     * @return
     *     possible object is
     *     {@link Recurrence }
     *     
     */
    public Recurrence getRecurrence() {
        return recurrence;
    }

    /**
     * Sets the value of the recurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Recurrence }
     *     
     */
    public void setRecurrence(Recurrence value) {
        this.recurrence = value;
    }

}

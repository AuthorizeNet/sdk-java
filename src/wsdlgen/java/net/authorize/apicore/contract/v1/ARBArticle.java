
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ARBArticle complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ARBArticle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ARBArticleID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ARBArticleFromTransID" type="{http://www.infospace.com/anet/Subscription.xsd}TransId" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CustomerInfo" type="{http://www.infospace.com/anet/Subscription.xsd}CustomerInfo" minOccurs="0"/>
 *         &lt;element name="CreateTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ARBArticle", namespace = "http://www.infospace.com/anet/Subscription.xsd", propOrder = {
    "arbArticleID",
    "arbArticleFromTransID",
    "name",
    "merchantID",
    "customerInfo",
    "createTimeStamp"
})
public class ARBArticle {

    @XmlElement(name = "ARBArticleID")
    protected int arbArticleID;
    @XmlElement(name = "ARBArticleFromTransID")
    protected TransId arbArticleFromTransID;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "CustomerInfo")
    protected CustomerInfo customerInfo;
    @XmlElement(name = "CreateTimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTimeStamp;

    /**
     * Gets the value of the arbArticleID property.
     * 
     */
    public int getARBArticleID() {
        return arbArticleID;
    }

    /**
     * Sets the value of the arbArticleID property.
     * 
     */
    public void setARBArticleID(int value) {
        this.arbArticleID = value;
    }

    /**
     * Gets the value of the arbArticleFromTransID property.
     * 
     * @return
     *     possible object is
     *     {@link TransId }
     *     
     */
    public TransId getARBArticleFromTransID() {
        return arbArticleFromTransID;
    }

    /**
     * Sets the value of the arbArticleFromTransID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransId }
     *     
     */
    public void setARBArticleFromTransID(TransId value) {
        this.arbArticleFromTransID = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the merchantID property.
     * 
     */
    public int getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     */
    public void setMerchantID(int value) {
        this.merchantID = value;
    }

    /**
     * Gets the value of the customerInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerInfo }
     *     
     */
    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    /**
     * Sets the value of the customerInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerInfo }
     *     
     */
    public void setCustomerInfo(CustomerInfo value) {
        this.customerInfo = value;
    }

    /**
     * Gets the value of the createTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTimeStamp() {
        return createTimeStamp;
    }

    /**
     * Sets the value of the createTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTimeStamp(XMLGregorianCalendar value) {
        this.createTimeStamp = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.26 at 11:27:57 AM PDT 
//


package net.authorize.api.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for impersonationAuthenticationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="impersonationAuthenticationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="partnerLoginId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="25"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="partnerTransactionKey">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impersonationAuthenticationType", propOrder = {
    "partnerLoginId",
    "partnerTransactionKey"
})
public class ImpersonationAuthenticationType {

    @XmlElement(required = true)
    protected String partnerLoginId;
    @XmlElement(required = true)
    protected String partnerTransactionKey;

    /**
     * Gets the value of the partnerLoginId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerLoginId() {
        return partnerLoginId;
    }

    /**
     * Sets the value of the partnerLoginId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerLoginId(String value) {
        this.partnerLoginId = value;
    }

    /**
     * Gets the value of the partnerTransactionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerTransactionKey() {
        return partnerTransactionKey;
    }

    /**
     * Sets the value of the partnerTransactionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerTransactionKey(String value) {
        this.partnerTransactionKey = value;
    }

}


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for payPalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payPalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="successUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cancelUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paypalLc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paypalHdrImg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paypalPayflowcolor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payPalType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "successUrl",
    "cancelUrl",
    "paypalLc",
    "paypalHdrImg",
    "paypalPayflowcolor",
    "payerID"
})
public class PayPalType {

    protected String successUrl;
    protected String cancelUrl;
    protected String paypalLc;
    protected String paypalHdrImg;
    protected String paypalPayflowcolor;
    protected String payerID;

    /**
     * Gets the value of the successUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuccessUrl() {
        return successUrl;
    }

    /**
     * Sets the value of the successUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuccessUrl(String value) {
        this.successUrl = value;
    }

    /**
     * Gets the value of the cancelUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelUrl() {
        return cancelUrl;
    }

    /**
     * Sets the value of the cancelUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelUrl(String value) {
        this.cancelUrl = value;
    }

    /**
     * Gets the value of the paypalLc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaypalLc() {
        return paypalLc;
    }

    /**
     * Sets the value of the paypalLc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaypalLc(String value) {
        this.paypalLc = value;
    }

    /**
     * Gets the value of the paypalHdrImg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaypalHdrImg() {
        return paypalHdrImg;
    }

    /**
     * Sets the value of the paypalHdrImg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaypalHdrImg(String value) {
        this.paypalHdrImg = value;
    }

    /**
     * Gets the value of the paypalPayflowcolor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaypalPayflowcolor() {
        return paypalPayflowcolor;
    }

    /**
     * Sets the value of the paypalPayflowcolor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaypalPayflowcolor(String value) {
        this.paypalPayflowcolor = value;
    }

    /**
     * Gets the value of the payerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayerID() {
        return payerID;
    }

    /**
     * Sets the value of the payerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayerID(String value) {
        this.payerID = value;
    }

}

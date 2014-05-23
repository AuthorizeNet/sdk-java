
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateCustomerPaymentProfileResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateCustomerPaymentProfileResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="PaymentProfileID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValidationDirectResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ResponseToCustomer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateCustomerPaymentProfileResponseData", propOrder = {
    "paymentProfileID",
    "validationDirectResponse",
    "transID",
    "responseCode",
    "responseToCustomer"
})
public class UpdateCustomerPaymentProfileResponseData
    extends BaseResponseData
{

    @XmlElement(name = "PaymentProfileID")
    protected String paymentProfileID;
    @XmlElement(name = "ValidationDirectResponse")
    protected String validationDirectResponse;
    @XmlElement(name = "TransID")
    protected String transID;
    @XmlElement(name = "ResponseCode")
    protected int responseCode;
    @XmlElement(name = "ResponseToCustomer")
    protected int responseToCustomer;

    /**
     * Gets the value of the paymentProfileID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentProfileID() {
        return paymentProfileID;
    }

    /**
     * Sets the value of the paymentProfileID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentProfileID(String value) {
        this.paymentProfileID = value;
    }

    /**
     * Gets the value of the validationDirectResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationDirectResponse() {
        return validationDirectResponse;
    }

    /**
     * Sets the value of the validationDirectResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationDirectResponse(String value) {
        this.validationDirectResponse = value;
    }

    /**
     * Gets the value of the transID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransID() {
        return transID;
    }

    /**
     * Sets the value of the transID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransID(String value) {
        this.transID = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     */
    public void setResponseCode(int value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the responseToCustomer property.
     * 
     */
    public int getResponseToCustomer() {
        return responseToCustomer;
    }

    /**
     * Sets the value of the responseToCustomer property.
     * 
     */
    public void setResponseToCustomer(int value) {
        this.responseToCustomer = value;
    }

}

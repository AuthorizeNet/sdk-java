
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateProfileTransactionResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateProfileTransactionResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="DirectResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "CreateProfileTransactionResponseData", propOrder = {
    "directResponse",
    "transID",
    "responseCode",
    "responseToCustomer"
})
public class CreateProfileTransactionResponseData
    extends BaseResponseData
{

    @XmlElement(name = "DirectResponse")
    protected String directResponse;
    @XmlElement(name = "TransID")
    protected String transID;
    @XmlElement(name = "ResponseCode")
    protected int responseCode;
    @XmlElement(name = "ResponseToCustomer")
    protected int responseToCustomer;

    /**
     * Gets the value of the directResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectResponse() {
        return directResponse;
    }

    /**
     * Sets the value of the directResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectResponse(String value) {
        this.directResponse = value;
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


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendCustomerEmailReceiptRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendCustomerEmailReceiptRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailSettings" type="{http://api.authorize.net/ANetApiWS/}ArrayOfSettingType" minOccurs="0"/>
 *         &lt;element name="emailVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendCustomerEmailReceiptRequest", propOrder = {
    "userId",
    "transId",
    "customerEmail",
    "emailSettings",
    "emailVersion"
})
public class SendCustomerEmailReceiptRequest
    extends BaseRequestData
{

    protected int userId;
    protected String transId;
    protected String customerEmail;
    protected ArrayOfSettingType emailSettings;
    protected String emailVersion;

    /**
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Gets the value of the transId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransId() {
        return transId;
    }

    /**
     * Sets the value of the transId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransId(String value) {
        this.transId = value;
    }

    /**
     * Gets the value of the customerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets the value of the customerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerEmail(String value) {
        this.customerEmail = value;
    }

    /**
     * Gets the value of the emailSettings property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSettingType }
     *     
     */
    public ArrayOfSettingType getEmailSettings() {
        return emailSettings;
    }

    /**
     * Sets the value of the emailSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSettingType }
     *     
     */
    public void setEmailSettings(ArrayOfSettingType value) {
        this.emailSettings = value;
    }

    /**
     * Gets the value of the emailVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailVersion() {
        return emailVersion;
    }

    /**
     * Sets the value of the emailVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailVersion(String value) {
        this.emailVersion = value;
    }

}

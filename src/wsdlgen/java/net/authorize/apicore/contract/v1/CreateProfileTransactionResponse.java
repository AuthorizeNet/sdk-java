
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreateProfileTransactionResult" type="{http://api.authorize.net/ANetApiWS/}CreateProfileTransactionResponseData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "createProfileTransactionResult"
})
@XmlRootElement(name = "CreateProfileTransactionResponse")
public class CreateProfileTransactionResponse {

    @XmlElement(name = "CreateProfileTransactionResult")
    protected CreateProfileTransactionResponseData createProfileTransactionResult;

    /**
     * Gets the value of the createProfileTransactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link CreateProfileTransactionResponseData }
     *     
     */
    public CreateProfileTransactionResponseData getCreateProfileTransactionResult() {
        return createProfileTransactionResult;
    }

    /**
     * Sets the value of the createProfileTransactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateProfileTransactionResponseData }
     *     
     */
    public void setCreateProfileTransactionResult(CreateProfileTransactionResponseData value) {
        this.createProfileTransactionResult = value;
    }

}

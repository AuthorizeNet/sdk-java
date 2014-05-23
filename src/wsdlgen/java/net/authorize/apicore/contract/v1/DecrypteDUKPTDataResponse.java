
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
 *         &lt;element name="DecrypteDUKPTDataResult" type="{http://api.authorize.net/ANetApiWS/}DecryptFOPResponseData" minOccurs="0"/>
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
    "decrypteDUKPTDataResult"
})
@XmlRootElement(name = "DecrypteDUKPTDataResponse")
public class DecrypteDUKPTDataResponse {

    @XmlElement(name = "DecrypteDUKPTDataResult")
    protected DecryptFOPResponseData decrypteDUKPTDataResult;

    /**
     * Gets the value of the decrypteDUKPTDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link DecryptFOPResponseData }
     *     
     */
    public DecryptFOPResponseData getDecrypteDUKPTDataResult() {
        return decrypteDUKPTDataResult;
    }

    /**
     * Sets the value of the decrypteDUKPTDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecryptFOPResponseData }
     *     
     */
    public void setDecrypteDUKPTDataResult(DecryptFOPResponseData value) {
        this.decrypteDUKPTDataResult = value;
    }

}

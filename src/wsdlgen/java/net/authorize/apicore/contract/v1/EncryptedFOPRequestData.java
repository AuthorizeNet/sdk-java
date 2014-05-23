
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EncryptedFOPRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EncryptedFOPRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MetaData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EncryptedData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Algo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Encode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Mode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EncryptedFOPRequestData", propOrder = {
    "metaData",
    "encryptedData",
    "algo",
    "encode",
    "mode"
})
public class EncryptedFOPRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MetaData")
    protected String metaData;
    @XmlElement(name = "EncryptedData")
    protected String encryptedData;
    @XmlElement(name = "Algo")
    protected String algo;
    @XmlElement(name = "Encode")
    protected String encode;
    @XmlElement(name = "Mode")
    protected String mode;

    /**
     * Gets the value of the metaData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetaData() {
        return metaData;
    }

    /**
     * Sets the value of the metaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetaData(String value) {
        this.metaData = value;
    }

    /**
     * Gets the value of the encryptedData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncryptedData() {
        return encryptedData;
    }

    /**
     * Sets the value of the encryptedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncryptedData(String value) {
        this.encryptedData = value;
    }

    /**
     * Gets the value of the algo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgo() {
        return algo;
    }

    /**
     * Sets the value of the algo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgo(String value) {
        this.algo = value;
    }

    /**
     * Gets the value of the encode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncode() {
        return encode;
    }

    /**
     * Sets the value of the encode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncode(String value) {
        this.encode = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMode(String value) {
        this.mode = value;
    }

}

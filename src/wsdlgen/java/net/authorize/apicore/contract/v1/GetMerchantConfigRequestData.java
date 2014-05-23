
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMerchantConfigRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMerchantConfigRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ConfigFieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConfigGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMerchantConfigRequestData", propOrder = {
    "merchantID",
    "configFieldName",
    "configGroupName"
})
public class GetMerchantConfigRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "ConfigFieldName")
    protected String configFieldName;
    @XmlElement(name = "ConfigGroupName")
    protected String configGroupName;

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
     * Gets the value of the configFieldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigFieldName() {
        return configFieldName;
    }

    /**
     * Sets the value of the configFieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigFieldName(String value) {
        this.configFieldName = value;
    }

    /**
     * Gets the value of the configGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigGroupName() {
        return configGroupName;
    }

    /**
     * Sets the value of the configGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigGroupName(String value) {
        this.configGroupName = value;
    }

}

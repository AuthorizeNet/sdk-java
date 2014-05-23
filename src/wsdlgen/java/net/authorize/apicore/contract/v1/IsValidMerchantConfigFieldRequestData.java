
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IsValidMerchantConfigFieldRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IsValidMerchantConfigFieldRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="ConfigFieldNameEnum" type="{http://api.authorize.net/ANetApiWS/}MerchantConfigField"/>
 *         &lt;element name="ConfigFieldNameStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IsValidMerchantConfigFieldRequestData", propOrder = {
    "configFieldNameEnum",
    "configFieldNameStr"
})
public class IsValidMerchantConfigFieldRequestData
    extends BaseRequestData
{

    @XmlElement(name = "ConfigFieldNameEnum", required = true)
    @XmlSchemaType(name = "string")
    protected MerchantConfigField configFieldNameEnum;
    @XmlElement(name = "ConfigFieldNameStr")
    protected String configFieldNameStr;

    /**
     * Gets the value of the configFieldNameEnum property.
     * 
     * @return
     *     possible object is
     *     {@link MerchantConfigField }
     *     
     */
    public MerchantConfigField getConfigFieldNameEnum() {
        return configFieldNameEnum;
    }

    /**
     * Sets the value of the configFieldNameEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerchantConfigField }
     *     
     */
    public void setConfigFieldNameEnum(MerchantConfigField value) {
        this.configFieldNameEnum = value;
    }

    /**
     * Gets the value of the configFieldNameStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigFieldNameStr() {
        return configFieldNameStr;
    }

    /**
     * Sets the value of the configFieldNameStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigFieldNameStr(String value) {
        this.configFieldNameStr = value;
    }

}


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IsValidMerchantConfigGroupRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IsValidMerchantConfigGroupRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="ConfigGroupNameEnum" type="{http://api.authorize.net/ANetApiWS/}MerchantConfigGroup"/>
 *         &lt;element name="ConfigGroupNameStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IsValidMerchantConfigGroupRequestData", propOrder = {
    "configGroupNameEnum",
    "configGroupNameStr"
})
public class IsValidMerchantConfigGroupRequestData
    extends BaseRequestData
{

    @XmlElement(name = "ConfigGroupNameEnum", required = true)
    @XmlSchemaType(name = "string")
    protected MerchantConfigGroup configGroupNameEnum;
    @XmlElement(name = "ConfigGroupNameStr")
    protected String configGroupNameStr;

    /**
     * Gets the value of the configGroupNameEnum property.
     * 
     * @return
     *     possible object is
     *     {@link MerchantConfigGroup }
     *     
     */
    public MerchantConfigGroup getConfigGroupNameEnum() {
        return configGroupNameEnum;
    }

    /**
     * Sets the value of the configGroupNameEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerchantConfigGroup }
     *     
     */
    public void setConfigGroupNameEnum(MerchantConfigGroup value) {
        this.configGroupNameEnum = value;
    }

    /**
     * Gets the value of the configGroupNameStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigGroupNameStr() {
        return configGroupNameStr;
    }

    /**
     * Sets the value of the configGroupNameStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigGroupNameStr(String value) {
        this.configGroupNameStr = value;
    }

}

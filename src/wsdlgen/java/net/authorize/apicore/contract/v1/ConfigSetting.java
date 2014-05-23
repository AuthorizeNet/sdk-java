
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigSetting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigSetting">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConfigFieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConfigValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigSetting", propOrder = {
    "configFieldName",
    "configValue"
})
public class ConfigSetting {

    @XmlElement(name = "ConfigFieldName")
    protected String configFieldName;
    @XmlElement(name = "ConfigValue")
    protected String configValue;

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
     * Gets the value of the configValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * Sets the value of the configValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigValue(String value) {
        this.configValue = value;
    }

}

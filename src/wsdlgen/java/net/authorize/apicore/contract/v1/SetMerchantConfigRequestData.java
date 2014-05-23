
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SetMerchantConfigRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetMerchantConfigRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ConfigSettings" type="{http://api.authorize.net/ANetApiWS/}ArrayOfConfigSetting" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetMerchantConfigRequestData", propOrder = {
    "merchantID",
    "configSettings"
})
public class SetMerchantConfigRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "ConfigSettings")
    protected ArrayOfConfigSetting configSettings;

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
     * Gets the value of the configSettings property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfConfigSetting }
     *     
     */
    public ArrayOfConfigSetting getConfigSettings() {
        return configSettings;
    }

    /**
     * Sets the value of the configSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfConfigSetting }
     *     
     */
    public void setConfigSettings(ArrayOfConfigSetting value) {
        this.configSettings = value;
    }

}

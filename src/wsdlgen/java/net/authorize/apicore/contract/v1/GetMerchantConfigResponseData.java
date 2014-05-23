
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMerchantConfigResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMerchantConfigResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
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
@XmlType(name = "GetMerchantConfigResponseData", propOrder = {
    "configSettings"
})
public class GetMerchantConfigResponseData
    extends BaseResponseData
{

    @XmlElement(name = "ConfigSettings")
    protected ArrayOfConfigSetting configSettings;

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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.22 at 06:00:08 PM IST 
//


package net.authorize.api.contract.v1;

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
 *     &lt;extension base="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}ANetApiRequest">
 *       &lt;sequence>
 *         &lt;element name="mobileDevice" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}mobileDeviceType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mobileDevice"
})
@XmlRootElement(name = "mobileDeviceRegistrationRequest")
public class MobileDeviceRegistrationRequest
    extends ANetApiRequest
{

    @XmlElement(required = true)
    protected MobileDeviceType mobileDevice;

    /**
     * Gets the value of the mobileDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MobileDeviceType }
     *     
     */
    public MobileDeviceType getMobileDevice() {
        return mobileDevice;
    }

    /**
     * Sets the value of the mobileDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MobileDeviceType }
     *     
     */
    public void setMobileDevice(MobileDeviceType value) {
        this.mobileDevice = value;
    }

}

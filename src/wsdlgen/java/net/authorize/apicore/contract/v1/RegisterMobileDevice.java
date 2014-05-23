
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="AnetUserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MerchantId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MobileDeviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeviceDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DevicePhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DevicePlatform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeviceActivation" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}deviceActivationEnum"/>
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
    "anetUserId",
    "merchantId",
    "mobileDeviceId",
    "deviceDescription",
    "devicePhoneNumber",
    "devicePlatform",
    "deviceActivation"
})
@XmlRootElement(name = "RegisterMobileDevice")
public class RegisterMobileDevice {

    @XmlElement(name = "AnetUserId")
    protected int anetUserId;
    @XmlElement(name = "MerchantId")
    protected int merchantId;
    @XmlElement(name = "MobileDeviceId")
    protected String mobileDeviceId;
    @XmlElement(name = "DeviceDescription")
    protected String deviceDescription;
    @XmlElement(name = "DevicePhoneNumber")
    protected String devicePhoneNumber;
    @XmlElement(name = "DevicePlatform")
    protected String devicePlatform;
    @XmlElement(name = "DeviceActivation", required = true, nillable = true)
    @XmlSchemaType(name = "string")
    protected DeviceActivationEnum deviceActivation;

    /**
     * Gets the value of the anetUserId property.
     * 
     */
    public int getAnetUserId() {
        return anetUserId;
    }

    /**
     * Sets the value of the anetUserId property.
     * 
     */
    public void setAnetUserId(int value) {
        this.anetUserId = value;
    }

    /**
     * Gets the value of the merchantId property.
     * 
     */
    public int getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the value of the merchantId property.
     * 
     */
    public void setMerchantId(int value) {
        this.merchantId = value;
    }

    /**
     * Gets the value of the mobileDeviceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileDeviceId() {
        return mobileDeviceId;
    }

    /**
     * Sets the value of the mobileDeviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileDeviceId(String value) {
        this.mobileDeviceId = value;
    }

    /**
     * Gets the value of the deviceDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceDescription() {
        return deviceDescription;
    }

    /**
     * Sets the value of the deviceDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceDescription(String value) {
        this.deviceDescription = value;
    }

    /**
     * Gets the value of the devicePhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevicePhoneNumber() {
        return devicePhoneNumber;
    }

    /**
     * Sets the value of the devicePhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevicePhoneNumber(String value) {
        this.devicePhoneNumber = value;
    }

    /**
     * Gets the value of the devicePlatform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevicePlatform() {
        return devicePlatform;
    }

    /**
     * Sets the value of the devicePlatform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevicePlatform(String value) {
        this.devicePlatform = value;
    }

    /**
     * Gets the value of the deviceActivation property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceActivationEnum }
     *     
     */
    public DeviceActivationEnum getDeviceActivation() {
        return deviceActivation;
    }

    /**
     * Sets the value of the deviceActivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceActivationEnum }
     *     
     */
    public void setDeviceActivation(DeviceActivationEnum value) {
        this.deviceActivation = value;
    }

}

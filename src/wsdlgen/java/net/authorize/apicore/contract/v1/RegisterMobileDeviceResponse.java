
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
 *         &lt;element name="RegisterMobileDeviceResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "registerMobileDeviceResult"
})
@XmlRootElement(name = "RegisterMobileDeviceResponse")
public class RegisterMobileDeviceResponse {

    @XmlElement(name = "RegisterMobileDeviceResult")
    protected int registerMobileDeviceResult;

    /**
     * Gets the value of the registerMobileDeviceResult property.
     * 
     */
    public int getRegisterMobileDeviceResult() {
        return registerMobileDeviceResult;
    }

    /**
     * Sets the value of the registerMobileDeviceResult property.
     * 
     */
    public void setRegisterMobileDeviceResult(int value) {
        this.registerMobileDeviceResult = value;
    }

}


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCustomerProfileResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCustomerProfileResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="Profile" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerProfileMaskedType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCustomerProfileResponseData", propOrder = {
    "profile"
})
public class GetCustomerProfileResponseData
    extends BaseResponseData
{

    @XmlElement(name = "Profile")
    protected CustomerProfileMaskedType profile;

    /**
     * Gets the value of the profile property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerProfileMaskedType }
     *     
     */
    public CustomerProfileMaskedType getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerProfileMaskedType }
     *     
     */
    public void setProfile(CustomerProfileMaskedType value) {
        this.profile = value;
    }

}

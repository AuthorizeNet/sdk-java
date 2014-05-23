
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCustomerPaymentProfileResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCustomerPaymentProfileResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="PaymentProfile" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerPaymentProfileMaskedType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCustomerPaymentProfileResponseData", propOrder = {
    "paymentProfile"
})
public class GetCustomerPaymentProfileResponseData
    extends BaseResponseData
{

    @XmlElement(name = "PaymentProfile")
    protected CustomerPaymentProfileMaskedType paymentProfile;

    /**
     * Gets the value of the paymentProfile property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerPaymentProfileMaskedType }
     *     
     */
    public CustomerPaymentProfileMaskedType getPaymentProfile() {
        return paymentProfile;
    }

    /**
     * Sets the value of the paymentProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerPaymentProfileMaskedType }
     *     
     */
    public void setPaymentProfile(CustomerPaymentProfileMaskedType value) {
        this.paymentProfile = value;
    }

}

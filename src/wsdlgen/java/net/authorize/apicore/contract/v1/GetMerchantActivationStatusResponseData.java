
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMerchantActivationStatusResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMerchantActivationStatusResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="merchantActivationStatus" type="{http://api.authorize.net/ANetApiWS/}ArrayOfMerchantActivationStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMerchantActivationStatusResponseData", propOrder = {
    "merchantActivationStatus"
})
public class GetMerchantActivationStatusResponseData
    extends BaseResponseData
{

    protected ArrayOfMerchantActivationStatus merchantActivationStatus;

    /**
     * Gets the value of the merchantActivationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMerchantActivationStatus }
     *     
     */
    public ArrayOfMerchantActivationStatus getMerchantActivationStatus() {
        return merchantActivationStatus;
    }

    /**
     * Sets the value of the merchantActivationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMerchantActivationStatus }
     *     
     */
    public void setMerchantActivationStatus(ArrayOfMerchantActivationStatus value) {
        this.merchantActivationStatus = value;
    }

}

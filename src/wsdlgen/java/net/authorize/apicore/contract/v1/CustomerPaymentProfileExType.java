
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerPaymentProfileExType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerPaymentProfileExType">
 *   &lt;complexContent>
 *     &lt;extension base="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerPaymentProfileType">
 *       &lt;sequence>
 *         &lt;element name="customerPaymentProfileId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerPaymentProfileExType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "customerPaymentProfileId"
})
public class CustomerPaymentProfileExType
    extends CustomerPaymentProfileType
{

    protected String customerPaymentProfileId;

    /**
     * Gets the value of the customerPaymentProfileId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerPaymentProfileId() {
        return customerPaymentProfileId;
    }

    /**
     * Sets the value of the customerPaymentProfileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerPaymentProfileId(String value) {
        this.customerPaymentProfileId = value;
    }

}

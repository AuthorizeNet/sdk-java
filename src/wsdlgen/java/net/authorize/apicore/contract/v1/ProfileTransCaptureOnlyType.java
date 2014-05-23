
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for profileTransCaptureOnlyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="profileTransCaptureOnlyType">
 *   &lt;complexContent>
 *     &lt;extension base="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}profileTransOrderType">
 *       &lt;sequence>
 *         &lt;element name="approvalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "profileTransCaptureOnlyType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "approvalCode"
})
public class ProfileTransCaptureOnlyType
    extends ProfileTransOrderType
{

    protected String approvalCode;

    /**
     * Gets the value of the approvalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovalCode() {
        return approvalCode;
    }

    /**
     * Sets the value of the approvalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovalCode(String value) {
        this.approvalCode = value;
    }

}

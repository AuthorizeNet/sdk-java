
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
 *         &lt;element name="UpdateMerchantIPCommerceResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "updateMerchantIPCommerceResult"
})
@XmlRootElement(name = "UpdateMerchantIPCommerceResponse")
public class UpdateMerchantIPCommerceResponse {

    @XmlElement(name = "UpdateMerchantIPCommerceResult")
    protected boolean updateMerchantIPCommerceResult;

    /**
     * Gets the value of the updateMerchantIPCommerceResult property.
     * 
     */
    public boolean isUpdateMerchantIPCommerceResult() {
        return updateMerchantIPCommerceResult;
    }

    /**
     * Sets the value of the updateMerchantIPCommerceResult property.
     * 
     */
    public void setUpdateMerchantIPCommerceResult(boolean value) {
        this.updateMerchantIPCommerceResult = value;
    }

}

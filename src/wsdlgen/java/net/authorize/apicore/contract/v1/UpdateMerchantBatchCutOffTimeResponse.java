
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
 *         &lt;element name="UpdateMerchantBatchCutOffTimeResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "updateMerchantBatchCutOffTimeResult"
})
@XmlRootElement(name = "UpdateMerchantBatchCutOffTimeResponse")
public class UpdateMerchantBatchCutOffTimeResponse {

    @XmlElement(name = "UpdateMerchantBatchCutOffTimeResult")
    protected boolean updateMerchantBatchCutOffTimeResult;

    /**
     * Gets the value of the updateMerchantBatchCutOffTimeResult property.
     * 
     */
    public boolean isUpdateMerchantBatchCutOffTimeResult() {
        return updateMerchantBatchCutOffTimeResult;
    }

    /**
     * Sets the value of the updateMerchantBatchCutOffTimeResult property.
     * 
     */
    public void setUpdateMerchantBatchCutOffTimeResult(boolean value) {
        this.updateMerchantBatchCutOffTimeResult = value;
    }

}

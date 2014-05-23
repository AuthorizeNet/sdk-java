
package net.authorize.apicore.contract.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMerchantActivationStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMerchantActivationStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantActivationStatus" type="{http://api.authorize.net/ANetApiWS/}MerchantActivationStatus" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMerchantActivationStatus", propOrder = {
    "merchantActivationStatus"
})
public class ArrayOfMerchantActivationStatus {

    @XmlElement(name = "MerchantActivationStatus", nillable = true)
    protected List<MerchantActivationStatus> merchantActivationStatus;

    /**
     * Gets the value of the merchantActivationStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the merchantActivationStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMerchantActivationStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MerchantActivationStatus }
     * 
     * 
     */
    public List<MerchantActivationStatus> getMerchantActivationStatus() {
        if (merchantActivationStatus == null) {
            merchantActivationStatus = new ArrayList<MerchantActivationStatus>();
        }
        return this.merchantActivationStatus;
    }

}

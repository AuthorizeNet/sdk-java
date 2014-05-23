
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
 *         &lt;element name="MerchantId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AnetUserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "merchantId",
    "anetUserID"
})
@XmlRootElement(name = "GetQuickBooksUrl")
public class GetQuickBooksUrl {

    @XmlElement(name = "MerchantId")
    protected int merchantId;
    @XmlElement(name = "AnetUserID")
    protected int anetUserID;

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
     * Gets the value of the anetUserID property.
     * 
     */
    public int getAnetUserID() {
        return anetUserID;
    }

    /**
     * Sets the value of the anetUserID property.
     * 
     */
    public void setAnetUserID(int value) {
        this.anetUserID = value;
    }

}

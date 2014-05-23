
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMerchantInfoRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMerchantInfoRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ServiceIDList" type="{http://api.authorize.net/ANetApiWS/}ArrayOfInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMerchantInfoRequestData", propOrder = {
    "merchantID",
    "serviceIDList"
})
public class GetMerchantInfoRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected long merchantID;
    @XmlElement(name = "ServiceIDList")
    protected ArrayOfInt serviceIDList;

    /**
     * Gets the value of the merchantID property.
     * 
     */
    public long getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     */
    public void setMerchantID(long value) {
        this.merchantID = value;
    }

    /**
     * Gets the value of the serviceIDList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getServiceIDList() {
        return serviceIDList;
    }

    /**
     * Sets the value of the serviceIDList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setServiceIDList(ArrayOfInt value) {
        this.serviceIDList = value;
    }

}

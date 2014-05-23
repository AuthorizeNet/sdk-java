
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetUnsettledTransListResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetUnsettledTransListResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="TransListWithPagingInfo" type="{http://api.authorize.net/ANetApiWS/}TransListWithPagingInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUnsettledTransListResponseData", propOrder = {
    "transListWithPagingInfo"
})
public class GetUnsettledTransListResponseData
    extends BaseResponseData
{

    @XmlElement(name = "TransListWithPagingInfo")
    protected TransListWithPagingInfo transListWithPagingInfo;

    /**
     * Gets the value of the transListWithPagingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TransListWithPagingInfo }
     *     
     */
    public TransListWithPagingInfo getTransListWithPagingInfo() {
        return transListWithPagingInfo;
    }

    /**
     * Sets the value of the transListWithPagingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransListWithPagingInfo }
     *     
     */
    public void setTransListWithPagingInfo(TransListWithPagingInfo value) {
        this.transListWithPagingInfo = value;
    }

}

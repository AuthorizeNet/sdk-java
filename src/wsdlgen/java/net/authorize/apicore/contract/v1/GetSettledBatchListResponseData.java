
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetSettledBatchListResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetSettledBatchListResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="BatchInfo" type="{http://api.authorize.net/ANetApiWS/}ArrayOfSettledBatchListInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSettledBatchListResponseData", propOrder = {
    "batchInfo"
})
public class GetSettledBatchListResponseData
    extends BaseResponseData
{

    @XmlElement(name = "BatchInfo")
    protected ArrayOfSettledBatchListInfo batchInfo;

    /**
     * Gets the value of the batchInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSettledBatchListInfo }
     *     
     */
    public ArrayOfSettledBatchListInfo getBatchInfo() {
        return batchInfo;
    }

    /**
     * Sets the value of the batchInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSettledBatchListInfo }
     *     
     */
    public void setBatchInfo(ArrayOfSettledBatchListInfo value) {
        this.batchInfo = value;
    }

}

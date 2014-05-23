
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateSplitTenderGroupRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateSplitTenderGroupRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SplitTenderID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SplitTenderStatus" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}splitTenderStatusEnum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateSplitTenderGroupRequestData", propOrder = {
    "merchantID",
    "splitTenderID",
    "splitTenderStatus"
})
public class UpdateSplitTenderGroupRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "SplitTenderID")
    protected long splitTenderID;
    @XmlElement(name = "SplitTenderStatus", required = true)
    @XmlSchemaType(name = "string")
    protected SplitTenderStatusEnum splitTenderStatus;

    /**
     * Gets the value of the merchantID property.
     * 
     */
    public int getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     */
    public void setMerchantID(int value) {
        this.merchantID = value;
    }

    /**
     * Gets the value of the splitTenderID property.
     * 
     */
    public long getSplitTenderID() {
        return splitTenderID;
    }

    /**
     * Sets the value of the splitTenderID property.
     * 
     */
    public void setSplitTenderID(long value) {
        this.splitTenderID = value;
    }

    /**
     * Gets the value of the splitTenderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SplitTenderStatusEnum }
     *     
     */
    public SplitTenderStatusEnum getSplitTenderStatus() {
        return splitTenderStatus;
    }

    /**
     * Sets the value of the splitTenderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SplitTenderStatusEnum }
     *     
     */
    public void setSplitTenderStatus(SplitTenderStatusEnum value) {
        this.splitTenderStatus = value;
    }

}

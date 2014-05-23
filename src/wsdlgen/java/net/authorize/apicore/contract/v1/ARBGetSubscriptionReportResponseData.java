
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ARBGetSubscriptionReportResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ARBGetSubscriptionReportResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="TotalNumInResultSet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SubscriptionInfoList" type="{http://api.authorize.net/ANetApiWS/}ArrayOfSubscriptionInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ARBGetSubscriptionReportResponseData", propOrder = {
    "totalNumInResultSet",
    "subscriptionInfoList"
})
public class ARBGetSubscriptionReportResponseData
    extends BaseResponseData
{

    @XmlElement(name = "TotalNumInResultSet")
    protected int totalNumInResultSet;
    @XmlElement(name = "SubscriptionInfoList")
    protected ArrayOfSubscriptionInfo subscriptionInfoList;

    /**
     * Gets the value of the totalNumInResultSet property.
     * 
     */
    public int getTotalNumInResultSet() {
        return totalNumInResultSet;
    }

    /**
     * Sets the value of the totalNumInResultSet property.
     * 
     */
    public void setTotalNumInResultSet(int value) {
        this.totalNumInResultSet = value;
    }

    /**
     * Gets the value of the subscriptionInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSubscriptionInfo }
     *     
     */
    public ArrayOfSubscriptionInfo getSubscriptionInfoList() {
        return subscriptionInfoList;
    }

    /**
     * Sets the value of the subscriptionInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSubscriptionInfo }
     *     
     */
    public void setSubscriptionInfoList(ArrayOfSubscriptionInfo value) {
        this.subscriptionInfoList = value;
    }

}

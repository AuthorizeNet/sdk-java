
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
 *         &lt;element name="ARBGetSubscriptionReportResult" type="{http://api.authorize.net/ANetApiWS/}ARBGetSubscriptionReportResponseData" minOccurs="0"/>
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
    "arbGetSubscriptionReportResult"
})
@XmlRootElement(name = "ARBGetSubscriptionReportResponse")
public class ARBGetSubscriptionReportResponse {

    @XmlElement(name = "ARBGetSubscriptionReportResult")
    protected ARBGetSubscriptionReportResponseData arbGetSubscriptionReportResult;

    /**
     * Gets the value of the arbGetSubscriptionReportResult property.
     * 
     * @return
     *     possible object is
     *     {@link ARBGetSubscriptionReportResponseData }
     *     
     */
    public ARBGetSubscriptionReportResponseData getARBGetSubscriptionReportResult() {
        return arbGetSubscriptionReportResult;
    }

    /**
     * Sets the value of the arbGetSubscriptionReportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ARBGetSubscriptionReportResponseData }
     *     
     */
    public void setARBGetSubscriptionReportResult(ARBGetSubscriptionReportResponseData value) {
        this.arbGetSubscriptionReportResult = value;
    }

}

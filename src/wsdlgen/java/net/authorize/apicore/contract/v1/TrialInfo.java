
package net.authorize.apicore.contract.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrialInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrialInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TrialPeriodAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="NumTrialRecurrence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrialInfo", namespace = "http://www.infospace.com/anet/Subscription.xsd", propOrder = {
    "trialPeriodAmount",
    "numTrialRecurrence"
})
public class TrialInfo {

    @XmlElement(name = "TrialPeriodAmount", required = true)
    protected BigDecimal trialPeriodAmount;
    @XmlElement(name = "NumTrialRecurrence")
    protected int numTrialRecurrence;

    /**
     * Gets the value of the trialPeriodAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrialPeriodAmount() {
        return trialPeriodAmount;
    }

    /**
     * Sets the value of the trialPeriodAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrialPeriodAmount(BigDecimal value) {
        this.trialPeriodAmount = value;
    }

    /**
     * Gets the value of the numTrialRecurrence property.
     * 
     */
    public int getNumTrialRecurrence() {
        return numTrialRecurrence;
    }

    /**
     * Sets the value of the numTrialRecurrence property.
     * 
     */
    public void setNumTrialRecurrence(int value) {
        this.numTrialRecurrence = value;
    }

}

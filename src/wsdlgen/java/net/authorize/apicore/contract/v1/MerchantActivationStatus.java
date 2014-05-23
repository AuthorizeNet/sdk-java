
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MerchantActivationStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantActivationStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StepComplete" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StepOptional" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="StepStatusVisible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MerchantActivationStatus", propOrder = {
    "stepName",
    "stepComplete",
    "stepOptional",
    "stepStatusVisible"
})
public class MerchantActivationStatus {

    @XmlElement(name = "StepName")
    protected String stepName;
    @XmlElement(name = "StepComplete")
    protected int stepComplete;
    @XmlElement(name = "StepOptional")
    protected boolean stepOptional;
    @XmlElement(name = "StepStatusVisible")
    protected boolean stepStatusVisible;

    /**
     * Gets the value of the stepName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStepName() {
        return stepName;
    }

    /**
     * Sets the value of the stepName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStepName(String value) {
        this.stepName = value;
    }

    /**
     * Gets the value of the stepComplete property.
     * 
     */
    public int getStepComplete() {
        return stepComplete;
    }

    /**
     * Sets the value of the stepComplete property.
     * 
     */
    public void setStepComplete(int value) {
        this.stepComplete = value;
    }

    /**
     * Gets the value of the stepOptional property.
     * 
     */
    public boolean isStepOptional() {
        return stepOptional;
    }

    /**
     * Sets the value of the stepOptional property.
     * 
     */
    public void setStepOptional(boolean value) {
        this.stepOptional = value;
    }

    /**
     * Gets the value of the stepStatusVisible property.
     * 
     */
    public boolean isStepStatusVisible() {
        return stepStatusVisible;
    }

    /**
     * Sets the value of the stepStatusVisible property.
     * 
     */
    public void setStepStatusVisible(boolean value) {
        this.stepStatusVisible = value;
    }

}

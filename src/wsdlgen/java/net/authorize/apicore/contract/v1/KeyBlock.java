
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KeyBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeyBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Value" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}KeyValue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyBlock", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "value"
})
public class KeyBlock {

    @XmlElement(name = "Value")
    protected KeyValue value;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link KeyValue }
     *     
     */
    public KeyValue getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyValue }
     *     
     */
    public void setValue(KeyValue value) {
        this.value = value;
    }

}

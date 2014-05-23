
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for creditCardTrackType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="creditCardTrackType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="track2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *           &lt;element name="track1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditCardTrackType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "track2",
    "track1"
})
public class CreditCardTrackType {

    protected String track2;
    protected String track1;

    /**
     * Gets the value of the track2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrack2() {
        return track2;
    }

    /**
     * Sets the value of the track2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrack2(String value) {
        this.track2 = value;
    }

    /**
     * Gets the value of the track1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrack1() {
        return track1;
    }

    /**
     * Sets the value of the track1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrack1(String value) {
        this.track1 = value;
    }

}

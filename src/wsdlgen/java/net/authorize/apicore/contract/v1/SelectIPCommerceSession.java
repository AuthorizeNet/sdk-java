
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
 *         &lt;element name="sGUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sguid"
})
@XmlRootElement(name = "SelectIPCommerceSession")
public class SelectIPCommerceSession {

    @XmlElement(name = "sGUID")
    protected String sguid;

    /**
     * Gets the value of the sguid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGUID() {
        return sguid;
    }

    /**
     * Sets the value of the sguid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGUID(String value) {
        this.sguid = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.11 at 11:22:30 PM IST 
//


package net.authorize.api.contract.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBatchDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBatchDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="batch" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}batchDetailsType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBatchDetailsType", propOrder = {
    "batch"
})
public class ArrayOfBatchDetailsType {

    protected List<BatchDetailsType> batch;

    /**
     * Gets the value of the batch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the batch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BatchDetailsType }
     * 
     * 
     */
    public List<BatchDetailsType> getBatch() {
        if (batch == null) {
            batch = new ArrayList<BatchDetailsType>();
        }
        return this.batch;
    }

}

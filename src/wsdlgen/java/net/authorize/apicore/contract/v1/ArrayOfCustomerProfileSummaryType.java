
package net.authorize.apicore.contract.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCustomerProfileSummaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCustomerProfileSummaryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerProfileSummaryType" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}customerProfileSummaryType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCustomerProfileSummaryType", propOrder = {
    "customerProfileSummaryType"
})
public class ArrayOfCustomerProfileSummaryType {

    @XmlElement(nillable = true)
    protected List<CustomerProfileSummaryType> customerProfileSummaryType;

    /**
     * Gets the value of the customerProfileSummaryType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerProfileSummaryType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerProfileSummaryType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerProfileSummaryType }
     * 
     * 
     */
    public List<CustomerProfileSummaryType> getCustomerProfileSummaryType() {
        if (customerProfileSummaryType == null) {
            customerProfileSummaryType = new ArrayList<CustomerProfileSummaryType>();
        }
        return this.customerProfileSummaryType;
    }

}


package net.authorize.apicore.contract.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfReturnedItemInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfReturnedItemInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReturnedItemInfo" type="{http://api.authorize.net/ANetApiWS/}ReturnedItemInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfReturnedItemInfo", propOrder = {
    "returnedItemInfo"
})
public class ArrayOfReturnedItemInfo {

    @XmlElement(name = "ReturnedItemInfo", nillable = true)
    protected List<ReturnedItemInfo> returnedItemInfo;

    /**
     * Gets the value of the returnedItemInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the returnedItemInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturnedItemInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReturnedItemInfo }
     * 
     * 
     */
    public List<ReturnedItemInfo> getReturnedItemInfo() {
        if (returnedItemInfo == null) {
            returnedItemInfo = new ArrayList<ReturnedItemInfo>();
        }
        return this.returnedItemInfo;
    }

}

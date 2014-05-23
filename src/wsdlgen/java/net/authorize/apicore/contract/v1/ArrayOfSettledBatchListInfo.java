
package net.authorize.apicore.contract.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSettledBatchListInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSettledBatchListInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SettledBatchListInfo" type="{http://api.authorize.net/ANetApiWS/}SettledBatchListInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSettledBatchListInfo", propOrder = {
    "settledBatchListInfo"
})
public class ArrayOfSettledBatchListInfo {

    @XmlElement(name = "SettledBatchListInfo", nillable = true)
    protected List<SettledBatchListInfo> settledBatchListInfo;

    /**
     * Gets the value of the settledBatchListInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the settledBatchListInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSettledBatchListInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SettledBatchListInfo }
     * 
     * 
     */
    public List<SettledBatchListInfo> getSettledBatchListInfo() {
        if (settledBatchListInfo == null) {
            settledBatchListInfo = new ArrayList<SettledBatchListInfo>();
        }
        return this.settledBatchListInfo;
    }

}

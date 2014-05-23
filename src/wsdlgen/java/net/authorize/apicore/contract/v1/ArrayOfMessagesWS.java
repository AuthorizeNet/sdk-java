
package net.authorize.apicore.contract.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMessagesWS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMessagesWS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessagesWS" type="{http://api.authorize.net/ANetApiWS/}MessagesWS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMessagesWS", propOrder = {
    "messagesWS"
})
public class ArrayOfMessagesWS {

    @XmlElement(name = "MessagesWS", nillable = true)
    protected List<MessagesWS> messagesWS;

    /**
     * Gets the value of the messagesWS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messagesWS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessagesWS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessagesWS }
     * 
     * 
     */
    public List<MessagesWS> getMessagesWS() {
        if (messagesWS == null) {
            messagesWS = new ArrayList<MessagesWS>();
        }
        return this.messagesWS;
    }

}

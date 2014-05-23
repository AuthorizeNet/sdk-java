
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetTransListResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetTransListResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="Transactions" type="{http://api.authorize.net/ANetApiWS/}ArrayOfTransListInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTransListResponseData", propOrder = {
    "transactions"
})
public class GetTransListResponseData
    extends BaseResponseData
{

    @XmlElement(name = "Transactions")
    protected ArrayOfTransListInfo transactions;

    /**
     * Gets the value of the transactions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransListInfo }
     *     
     */
    public ArrayOfTransListInfo getTransactions() {
        return transactions;
    }

    /**
     * Sets the value of the transactions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransListInfo }
     *     
     */
    public void setTransactions(ArrayOfTransListInfo value) {
        this.transactions = value;
    }

}


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransListWithPagingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransListWithPagingInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allTransactionsReturned" type="{http://api.authorize.net/ANetApiWS/}ArrayOfTransListInfo" minOccurs="0"/>
 *         &lt;element name="totalNumberOfTransactionInDB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageNumberBeingRetrieved" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numItemsInResultSet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransListWithPagingInfo", propOrder = {
    "allTransactionsReturned",
    "totalNumberOfTransactionInDB",
    "pageNumberBeingRetrieved",
    "numItemsInResultSet"
})
public class TransListWithPagingInfo {

    protected ArrayOfTransListInfo allTransactionsReturned;
    protected int totalNumberOfTransactionInDB;
    protected int pageNumberBeingRetrieved;
    protected int numItemsInResultSet;

    /**
     * Gets the value of the allTransactionsReturned property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransListInfo }
     *     
     */
    public ArrayOfTransListInfo getAllTransactionsReturned() {
        return allTransactionsReturned;
    }

    /**
     * Sets the value of the allTransactionsReturned property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransListInfo }
     *     
     */
    public void setAllTransactionsReturned(ArrayOfTransListInfo value) {
        this.allTransactionsReturned = value;
    }

    /**
     * Gets the value of the totalNumberOfTransactionInDB property.
     * 
     */
    public int getTotalNumberOfTransactionInDB() {
        return totalNumberOfTransactionInDB;
    }

    /**
     * Sets the value of the totalNumberOfTransactionInDB property.
     * 
     */
    public void setTotalNumberOfTransactionInDB(int value) {
        this.totalNumberOfTransactionInDB = value;
    }

    /**
     * Gets the value of the pageNumberBeingRetrieved property.
     * 
     */
    public int getPageNumberBeingRetrieved() {
        return pageNumberBeingRetrieved;
    }

    /**
     * Sets the value of the pageNumberBeingRetrieved property.
     * 
     */
    public void setPageNumberBeingRetrieved(int value) {
        this.pageNumberBeingRetrieved = value;
    }

    /**
     * Gets the value of the numItemsInResultSet property.
     * 
     */
    public int getNumItemsInResultSet() {
        return numItemsInResultSet;
    }

    /**
     * Sets the value of the numItemsInResultSet property.
     * 
     */
    public void setNumItemsInResultSet(int value) {
        this.numItemsInResultSet = value;
    }

}

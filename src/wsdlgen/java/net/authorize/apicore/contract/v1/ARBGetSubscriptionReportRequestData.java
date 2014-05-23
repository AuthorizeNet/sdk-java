
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ARBGetSubscriptionReportRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ARBGetSubscriptionReportRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MerchantId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ExpDateHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartReportDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EndReportDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SearchType" type="{http://api.authorize.net/ANetApiWS/}ARBSubscriptionReportSearchTypeEnum"/>
 *         &lt;element name="OrderBy" type="{http://api.authorize.net/ANetApiWS/}ARBSubscriptionReportOrderFieldEnum"/>
 *         &lt;element name="OrderDescending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PageNumberBeingRetrieved" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NumItemsInResultSet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ARBGetSubscriptionReportRequestData", propOrder = {
    "userId",
    "merchantId",
    "expDateHash",
    "startReportDate",
    "endReportDate",
    "searchType",
    "orderBy",
    "orderDescending",
    "pageNumberBeingRetrieved",
    "numItemsInResultSet"
})
public class ARBGetSubscriptionReportRequestData
    extends BaseRequestData
{

    @XmlElement(name = "UserId")
    protected long userId;
    @XmlElement(name = "MerchantId")
    protected int merchantId;
    @XmlElement(name = "ExpDateHash")
    protected String expDateHash;
    @XmlElement(name = "StartReportDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startReportDate;
    @XmlElement(name = "EndReportDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endReportDate;
    @XmlElement(name = "SearchType", required = true)
    @XmlSchemaType(name = "string")
    protected ARBSubscriptionReportSearchTypeEnum searchType;
    @XmlElement(name = "OrderBy", required = true)
    @XmlSchemaType(name = "string")
    protected ARBSubscriptionReportOrderFieldEnum orderBy;
    @XmlElement(name = "OrderDescending")
    protected boolean orderDescending;
    @XmlElement(name = "PageNumberBeingRetrieved")
    protected int pageNumberBeingRetrieved;
    @XmlElement(name = "NumItemsInResultSet")
    protected int numItemsInResultSet;

    /**
     * Gets the value of the userId property.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the merchantId property.
     * 
     */
    public int getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the value of the merchantId property.
     * 
     */
    public void setMerchantId(int value) {
        this.merchantId = value;
    }

    /**
     * Gets the value of the expDateHash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpDateHash() {
        return expDateHash;
    }

    /**
     * Sets the value of the expDateHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpDateHash(String value) {
        this.expDateHash = value;
    }

    /**
     * Gets the value of the startReportDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartReportDate() {
        return startReportDate;
    }

    /**
     * Sets the value of the startReportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartReportDate(XMLGregorianCalendar value) {
        this.startReportDate = value;
    }

    /**
     * Gets the value of the endReportDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndReportDate() {
        return endReportDate;
    }

    /**
     * Sets the value of the endReportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndReportDate(XMLGregorianCalendar value) {
        this.endReportDate = value;
    }

    /**
     * Gets the value of the searchType property.
     * 
     * @return
     *     possible object is
     *     {@link ARBSubscriptionReportSearchTypeEnum }
     *     
     */
    public ARBSubscriptionReportSearchTypeEnum getSearchType() {
        return searchType;
    }

    /**
     * Sets the value of the searchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ARBSubscriptionReportSearchTypeEnum }
     *     
     */
    public void setSearchType(ARBSubscriptionReportSearchTypeEnum value) {
        this.searchType = value;
    }

    /**
     * Gets the value of the orderBy property.
     * 
     * @return
     *     possible object is
     *     {@link ARBSubscriptionReportOrderFieldEnum }
     *     
     */
    public ARBSubscriptionReportOrderFieldEnum getOrderBy() {
        return orderBy;
    }

    /**
     * Sets the value of the orderBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ARBSubscriptionReportOrderFieldEnum }
     *     
     */
    public void setOrderBy(ARBSubscriptionReportOrderFieldEnum value) {
        this.orderBy = value;
    }

    /**
     * Gets the value of the orderDescending property.
     * 
     */
    public boolean isOrderDescending() {
        return orderDescending;
    }

    /**
     * Sets the value of the orderDescending property.
     * 
     */
    public void setOrderDescending(boolean value) {
        this.orderDescending = value;
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


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateProfileTransactionRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateProfileTransactionRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Transaction" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}profileTransactionType" minOccurs="0"/>
 *         &lt;element name="ExtraOptions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateProfileTransactionRequestData", propOrder = {
    "merchantID",
    "transaction",
    "extraOptions"
})
public class CreateProfileTransactionRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MerchantID")
    protected int merchantID;
    @XmlElement(name = "Transaction")
    protected ProfileTransactionType transaction;
    @XmlElement(name = "ExtraOptions")
    protected String extraOptions;

    /**
     * Gets the value of the merchantID property.
     * 
     */
    public int getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     */
    public void setMerchantID(int value) {
        this.merchantID = value;
    }

    /**
     * Gets the value of the transaction property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileTransactionType }
     *     
     */
    public ProfileTransactionType getTransaction() {
        return transaction;
    }

    /**
     * Sets the value of the transaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileTransactionType }
     *     
     */
    public void setTransaction(ProfileTransactionType value) {
        this.transaction = value;
    }

    /**
     * Gets the value of the extraOptions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtraOptions() {
        return extraOptions;
    }

    /**
     * Sets the value of the extraOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtraOptions(String value) {
        this.extraOptions = value;
    }

}

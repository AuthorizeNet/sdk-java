
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bankAccountMaskedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bankAccountMaskedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountType" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}bankAccountTypeEnum" minOccurs="0"/>
 *         &lt;element name="routingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameOnAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="echeckType" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}echeckTypeEnum" minOccurs="0"/>
 *         &lt;element name="bankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bankAccountMaskedType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd", propOrder = {
    "accountType",
    "routingNumber",
    "accountNumber",
    "nameOnAccount",
    "echeckType",
    "bankName"
})
public class BankAccountMaskedType {

    @XmlSchemaType(name = "string")
    protected BankAccountTypeEnum accountType;
    protected String routingNumber;
    protected String accountNumber;
    protected String nameOnAccount;
    @XmlSchemaType(name = "string")
    protected EcheckTypeEnum echeckType;
    protected String bankName;

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link BankAccountTypeEnum }
     *     
     */
    public BankAccountTypeEnum getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccountTypeEnum }
     *     
     */
    public void setAccountType(BankAccountTypeEnum value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the routingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoutingNumber() {
        return routingNumber;
    }

    /**
     * Sets the value of the routingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoutingNumber(String value) {
        this.routingNumber = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the nameOnAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOnAccount() {
        return nameOnAccount;
    }

    /**
     * Sets the value of the nameOnAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOnAccount(String value) {
        this.nameOnAccount = value;
    }

    /**
     * Gets the value of the echeckType property.
     * 
     * @return
     *     possible object is
     *     {@link EcheckTypeEnum }
     *     
     */
    public EcheckTypeEnum getEcheckType() {
        return echeckType;
    }

    /**
     * Sets the value of the echeckType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EcheckTypeEnum }
     *     
     */
    public void setEcheckType(EcheckTypeEnum value) {
        this.echeckType = value;
    }

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

}

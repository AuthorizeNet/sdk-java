
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApiMethodUsageRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApiMethodUsageRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="MethodName" type="{http://api.authorize.net/ANetApiWS/}ApiMethodName"/>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AnetAccountTypeID" type="{http://microsoft.com/wsdl/types/}char"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApiMethodUsageRequestData", propOrder = {
    "methodName",
    "accountID",
    "anetAccountTypeID"
})
public class ApiMethodUsageRequestData
    extends BaseRequestData
{

    @XmlElement(name = "MethodName", required = true)
    @XmlSchemaType(name = "string")
    protected ApiMethodName methodName;
    @XmlElement(name = "AccountID")
    protected long accountID;
    @XmlElement(name = "AnetAccountTypeID")
    @XmlSchemaType(name = "unsignedShort")
    protected int anetAccountTypeID;

    /**
     * Gets the value of the methodName property.
     * 
     * @return
     *     possible object is
     *     {@link ApiMethodName }
     *     
     */
    public ApiMethodName getMethodName() {
        return methodName;
    }

    /**
     * Sets the value of the methodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiMethodName }
     *     
     */
    public void setMethodName(ApiMethodName value) {
        this.methodName = value;
    }

    /**
     * Gets the value of the accountID property.
     * 
     */
    public long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     */
    public void setAccountID(long value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the anetAccountTypeID property.
     * 
     */
    public int getAnetAccountTypeID() {
        return anetAccountTypeID;
    }

    /**
     * Sets the value of the anetAccountTypeID property.
     * 
     */
    public void setAnetAccountTypeID(int value) {
        this.anetAccountTypeID = value;
    }

}


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthenticateUserRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthenticateUserRequestData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseRequestData">
 *       &lt;sequence>
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApiAuthType" type="{http://api.authorize.net/ANetApiWS/}ApiAuthenticationType"/>
 *         &lt;element name="ApiKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SessionToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MobileDeviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnetAccountType" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="MethodName" type="{http://api.authorize.net/ANetApiWS/}ApiMethodName" minOccurs="0"/>
 *         &lt;element name="ImpersonationPartnerLoginId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ImpersonationPartnerApiKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthenticateUserRequestData", propOrder = {
    "userName",
    "apiAuthType",
    "apiKey",
    "password",
    "sessionToken",
    "mobileDeviceId",
    "anetAccountType",
    "methodName",
    "impersonationPartnerLoginId",
    "impersonationPartnerApiKey"
})
public class AuthenticateUserRequestData
    extends BaseRequestData
{

    @XmlElement(name = "UserName")
    protected String userName;
    @XmlElement(name = "ApiAuthType", required = true)
    @XmlSchemaType(name = "string")
    protected ApiAuthenticationType apiAuthType;
    @XmlElement(name = "ApiKey")
    protected String apiKey;
    @XmlElement(name = "Password")
    protected String password;
    @XmlElement(name = "SessionToken")
    protected String sessionToken;
    @XmlElement(name = "MobileDeviceId")
    protected String mobileDeviceId;
    @XmlElement(name = "AnetAccountType")
    @XmlSchemaType(name = "unsignedShort")
    protected int anetAccountType;
    @XmlElement(name = "MethodName")
    @XmlSchemaType(name = "string")
    protected ApiMethodName methodName;
    @XmlElement(name = "ImpersonationPartnerLoginId")
    protected String impersonationPartnerLoginId;
    @XmlElement(name = "ImpersonationPartnerApiKey")
    protected String impersonationPartnerApiKey;

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the apiAuthType property.
     * 
     * @return
     *     possible object is
     *     {@link ApiAuthenticationType }
     *     
     */
    public ApiAuthenticationType getApiAuthType() {
        return apiAuthType;
    }

    /**
     * Sets the value of the apiAuthType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiAuthenticationType }
     *     
     */
    public void setApiAuthType(ApiAuthenticationType value) {
        this.apiAuthType = value;
    }

    /**
     * Gets the value of the apiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the value of the apiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiKey(String value) {
        this.apiKey = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the sessionToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionToken() {
        return sessionToken;
    }

    /**
     * Sets the value of the sessionToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionToken(String value) {
        this.sessionToken = value;
    }

    /**
     * Gets the value of the mobileDeviceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileDeviceId() {
        return mobileDeviceId;
    }

    /**
     * Sets the value of the mobileDeviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileDeviceId(String value) {
        this.mobileDeviceId = value;
    }

    /**
     * Gets the value of the anetAccountType property.
     * 
     */
    public int getAnetAccountType() {
        return anetAccountType;
    }

    /**
     * Sets the value of the anetAccountType property.
     * 
     */
    public void setAnetAccountType(int value) {
        this.anetAccountType = value;
    }

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
     * Gets the value of the impersonationPartnerLoginId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpersonationPartnerLoginId() {
        return impersonationPartnerLoginId;
    }

    /**
     * Sets the value of the impersonationPartnerLoginId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpersonationPartnerLoginId(String value) {
        this.impersonationPartnerLoginId = value;
    }

    /**
     * Gets the value of the impersonationPartnerApiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpersonationPartnerApiKey() {
        return impersonationPartnerApiKey;
    }

    /**
     * Sets the value of the impersonationPartnerApiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpersonationPartnerApiKey(String value) {
        this.impersonationPartnerApiKey = value;
    }

}

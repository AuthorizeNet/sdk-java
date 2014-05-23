
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApiAuthenticationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ApiAuthenticationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="TransKey"/>
 *     &lt;enumeration value="Password"/>
 *     &lt;enumeration value="SessionToken"/>
 *     &lt;enumeration value="Impersonation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ApiAuthenticationType")
@XmlEnum
public enum ApiAuthenticationType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("TransKey")
    TRANS_KEY("TransKey"),
    @XmlEnumValue("Password")
    PASSWORD("Password"),
    @XmlEnumValue("SessionToken")
    SESSION_TOKEN("SessionToken"),
    @XmlEnumValue("Impersonation")
    IMPERSONATION("Impersonation");
    private final String value;

    ApiAuthenticationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ApiAuthenticationType fromValue(String v) {
        for (ApiAuthenticationType c: ApiAuthenticationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

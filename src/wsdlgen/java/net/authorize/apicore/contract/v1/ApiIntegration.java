
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApiIntegration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ApiIntegration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Xml"/>
 *     &lt;enumeration value="Soap"/>
 *     &lt;enumeration value="Mint"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="HostedPage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ApiIntegration")
@XmlEnum
public enum ApiIntegration {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Xml")
    XML("Xml"),
    @XmlEnumValue("Soap")
    SOAP("Soap"),
    @XmlEnumValue("Mint")
    MINT("Mint"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("HostedPage")
    HOSTED_PAGE("HostedPage");
    private final String value;

    ApiIntegration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ApiIntegration fromValue(String v) {
        for (ApiIntegration c: ApiIntegration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

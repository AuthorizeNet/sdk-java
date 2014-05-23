
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ARBSubscriptionStatusEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ARBSubscriptionStatusEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="active"/>
 *     &lt;enumeration value="expired"/>
 *     &lt;enumeration value="suspended"/>
 *     &lt;enumeration value="canceled"/>
 *     &lt;enumeration value="terminated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ARBSubscriptionStatusEnum", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd")
@XmlEnum
public enum ARBSubscriptionStatusEnum {

    @XmlEnumValue("active")
    ACTIVE("active"),
    @XmlEnumValue("expired")
    EXPIRED("expired"),
    @XmlEnumValue("suspended")
    SUSPENDED("suspended"),
    @XmlEnumValue("canceled")
    CANCELED("canceled"),
    @XmlEnumValue("terminated")
    TERMINATED("terminated");
    private final String value;

    ARBSubscriptionStatusEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ARBSubscriptionStatusEnum fromValue(String v) {
        for (ARBSubscriptionStatusEnum c: ARBSubscriptionStatusEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

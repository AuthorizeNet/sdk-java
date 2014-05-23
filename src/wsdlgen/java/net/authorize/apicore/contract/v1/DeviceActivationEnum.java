
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deviceActivationEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="deviceActivationEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Activate"/>
 *     &lt;enumeration value="Disable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "deviceActivationEnum", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd")
@XmlEnum
public enum DeviceActivationEnum {

    @XmlEnumValue("Activate")
    ACTIVATE("Activate"),
    @XmlEnumValue("Disable")
    DISABLE("Disable");
    private final String value;

    DeviceActivationEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeviceActivationEnum fromValue(String v) {
        for (DeviceActivationEnum c: DeviceActivationEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validationModeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="validationModeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="testMode"/>
 *     &lt;enumeration value="liveMode"/>
 *     &lt;enumeration value="oldLiveMode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "validationModeEnum", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd")
@XmlEnum
public enum ValidationModeEnum {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("testMode")
    TEST_MODE("testMode"),
    @XmlEnumValue("liveMode")
    LIVE_MODE("liveMode"),
    @XmlEnumValue("oldLiveMode")
    OLD_LIVE_MODE("oldLiveMode");
    private final String value;

    ValidationModeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidationModeEnum fromValue(String v) {
        for (ValidationModeEnum c: ValidationModeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

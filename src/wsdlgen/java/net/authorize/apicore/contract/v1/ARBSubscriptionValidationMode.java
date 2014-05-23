
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ARBSubscriptionValidationMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ARBSubscriptionValidationMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Local"/>
 *     &lt;enumeration value="TestModeTransaction"/>
 *     &lt;enumeration value="LiveModeTransaction"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ARBSubscriptionValidationMode")
@XmlEnum
public enum ARBSubscriptionValidationMode {

    @XmlEnumValue("Local")
    LOCAL("Local"),
    @XmlEnumValue("TestModeTransaction")
    TEST_MODE_TRANSACTION("TestModeTransaction"),
    @XmlEnumValue("LiveModeTransaction")
    LIVE_MODE_TRANSACTION("LiveModeTransaction");
    private final String value;

    ARBSubscriptionValidationMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ARBSubscriptionValidationMode fromValue(String v) {
        for (ARBSubscriptionValidationMode c: ARBSubscriptionValidationMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

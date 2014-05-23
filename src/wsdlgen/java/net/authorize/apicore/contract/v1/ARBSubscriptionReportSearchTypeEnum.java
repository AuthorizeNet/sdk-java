
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ARBSubscriptionReportSearchTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ARBSubscriptionReportSearchTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AboutExpire"/>
 *     &lt;enumeration value="ActiveCard"/>
 *     &lt;enumeration value="WillExpire"/>
 *     &lt;enumeration value="Inactive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ARBSubscriptionReportSearchTypeEnum")
@XmlEnum
public enum ARBSubscriptionReportSearchTypeEnum {

    @XmlEnumValue("AboutExpire")
    ABOUT_EXPIRE("AboutExpire"),
    @XmlEnumValue("ActiveCard")
    ACTIVE_CARD("ActiveCard"),
    @XmlEnumValue("WillExpire")
    WILL_EXPIRE("WillExpire"),
    @XmlEnumValue("Inactive")
    INACTIVE("Inactive");
    private final String value;

    ARBSubscriptionReportSearchTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ARBSubscriptionReportSearchTypeEnum fromValue(String v) {
        for (ARBSubscriptionReportSearchTypeEnum c: ARBSubscriptionReportSearchTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

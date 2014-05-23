
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for splitTenderStatusEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="splitTenderStatusEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="completed"/>
 *     &lt;enumeration value="held"/>
 *     &lt;enumeration value="voided"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "splitTenderStatusEnum", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd")
@XmlEnum
public enum SplitTenderStatusEnum {

    @XmlEnumValue("completed")
    COMPLETED("completed"),
    @XmlEnumValue("held")
    HELD("held"),
    @XmlEnumValue("voided")
    VOIDED("voided");
    private final String value;

    SplitTenderStatusEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SplitTenderStatusEnum fromValue(String v) {
        for (SplitTenderStatusEnum c: SplitTenderStatusEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

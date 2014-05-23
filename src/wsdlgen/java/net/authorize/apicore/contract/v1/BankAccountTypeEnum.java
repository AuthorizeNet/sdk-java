
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bankAccountTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="bankAccountTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="checking"/>
 *     &lt;enumeration value="savings"/>
 *     &lt;enumeration value="businessChecking"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "bankAccountTypeEnum", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd")
@XmlEnum
public enum BankAccountTypeEnum {

    @XmlEnumValue("checking")
    CHECKING("checking"),
    @XmlEnumValue("savings")
    SAVINGS("savings"),
    @XmlEnumValue("businessChecking")
    BUSINESS_CHECKING("businessChecking");
    private final String value;

    BankAccountTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BankAccountTypeEnum fromValue(String v) {
        for (BankAccountTypeEnum c: BankAccountTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

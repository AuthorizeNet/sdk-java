
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MerchantConfigGroup.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MerchantConfigGroup">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="PaymentFormFontsColors"/>
 *     &lt;enumeration value="TransactAll"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MerchantConfigGroup")
@XmlEnum
public enum MerchantConfigGroup {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("PaymentFormFontsColors")
    PAYMENT_FORM_FONTS_COLORS("PaymentFormFontsColors"),
    @XmlEnumValue("TransactAll")
    TRANSACT_ALL("TransactAll");
    private final String value;

    MerchantConfigGroup(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MerchantConfigGroup fromValue(String v) {
        for (MerchantConfigGroup c: MerchantConfigGroup.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchCustomerProfilesSortMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchCustomerProfilesSortMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CustomerProfileId"/>
 *     &lt;enumeration value="MerchantCustomerId"/>
 *     &lt;enumeration value="Email"/>
 *     &lt;enumeration value="Description"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchCustomerProfilesSortMethod")
@XmlEnum
public enum SearchCustomerProfilesSortMethod {

    @XmlEnumValue("CustomerProfileId")
    CUSTOMER_PROFILE_ID("CustomerProfileId"),
    @XmlEnumValue("MerchantCustomerId")
    MERCHANT_CUSTOMER_ID("MerchantCustomerId"),
    @XmlEnumValue("Email")
    EMAIL("Email"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description");
    private final String value;

    SearchCustomerProfilesSortMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchCustomerProfilesSortMethod fromValue(String v) {
        for (SearchCustomerProfilesSortMethod c: SearchCustomerProfilesSortMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchCustomerProfilesAdvancedSortMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchCustomerProfilesAdvancedSortMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CustomerProfileID"/>
 *     &lt;enumeration value="MerchantCustomerID"/>
 *     &lt;enumeration value="Description"/>
 *     &lt;enumeration value="Email"/>
 *     &lt;enumeration value="SubProfileType"/>
 *     &lt;enumeration value="SubProfileID"/>
 *     &lt;enumeration value="Company"/>
 *     &lt;enumeration value="FirstName"/>
 *     &lt;enumeration value="LastName"/>
 *     &lt;enumeration value="Address"/>
 *     &lt;enumeration value="City"/>
 *     &lt;enumeration value="StateProv"/>
 *     &lt;enumeration value="Zip"/>
 *     &lt;enumeration value="Country"/>
 *     &lt;enumeration value="Phone"/>
 *     &lt;enumeration value="Fax"/>
 *     &lt;enumeration value="CustomerOrganizationType"/>
 *     &lt;enumeration value="CardNumberMasked"/>
 *     &lt;enumeration value="CardExpirationDateMasked"/>
 *     &lt;enumeration value="BankAccountNumberMasked"/>
 *     &lt;enumeration value="BankRoutingNumberMasked"/>
 *     &lt;enumeration value="NameOnAccount"/>
 *     &lt;enumeration value="BankAccountType"/>
 *     &lt;enumeration value="BankName"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchCustomerProfilesAdvancedSortMethod")
@XmlEnum
public enum SearchCustomerProfilesAdvancedSortMethod {

    @XmlEnumValue("CustomerProfileID")
    CUSTOMER_PROFILE_ID("CustomerProfileID"),
    @XmlEnumValue("MerchantCustomerID")
    MERCHANT_CUSTOMER_ID("MerchantCustomerID"),
    @XmlEnumValue("Description")
    DESCRIPTION("Description"),
    @XmlEnumValue("Email")
    EMAIL("Email"),
    @XmlEnumValue("SubProfileType")
    SUB_PROFILE_TYPE("SubProfileType"),
    @XmlEnumValue("SubProfileID")
    SUB_PROFILE_ID("SubProfileID"),
    @XmlEnumValue("Company")
    COMPANY("Company"),
    @XmlEnumValue("FirstName")
    FIRST_NAME("FirstName"),
    @XmlEnumValue("LastName")
    LAST_NAME("LastName"),
    @XmlEnumValue("Address")
    ADDRESS("Address"),
    @XmlEnumValue("City")
    CITY("City"),
    @XmlEnumValue("StateProv")
    STATE_PROV("StateProv"),
    @XmlEnumValue("Zip")
    ZIP("Zip"),
    @XmlEnumValue("Country")
    COUNTRY("Country"),
    @XmlEnumValue("Phone")
    PHONE("Phone"),
    @XmlEnumValue("Fax")
    FAX("Fax"),
    @XmlEnumValue("CustomerOrganizationType")
    CUSTOMER_ORGANIZATION_TYPE("CustomerOrganizationType"),
    @XmlEnumValue("CardNumberMasked")
    CARD_NUMBER_MASKED("CardNumberMasked"),
    @XmlEnumValue("CardExpirationDateMasked")
    CARD_EXPIRATION_DATE_MASKED("CardExpirationDateMasked"),
    @XmlEnumValue("BankAccountNumberMasked")
    BANK_ACCOUNT_NUMBER_MASKED("BankAccountNumberMasked"),
    @XmlEnumValue("BankRoutingNumberMasked")
    BANK_ROUTING_NUMBER_MASKED("BankRoutingNumberMasked"),
    @XmlEnumValue("NameOnAccount")
    NAME_ON_ACCOUNT("NameOnAccount"),
    @XmlEnumValue("BankAccountType")
    BANK_ACCOUNT_TYPE("BankAccountType"),
    @XmlEnumValue("BankName")
    BANK_NAME("BankName");
    private final String value;

    SearchCustomerProfilesAdvancedSortMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchCustomerProfilesAdvancedSortMethod fromValue(String v) {
        for (SearchCustomerProfilesAdvancedSortMethod c: SearchCustomerProfilesAdvancedSortMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

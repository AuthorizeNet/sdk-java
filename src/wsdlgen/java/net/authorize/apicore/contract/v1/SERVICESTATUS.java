
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SERVICESTATUS.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SERVICESTATUS">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Disabled"/>
 *     &lt;enumeration value="Enabled"/>
 *     &lt;enumeration value="EnabledWithMerchantProvisioning"/>
 *     &lt;enumeration value="EnabledWithResellerProvisioningOnly"/>
 *     &lt;enumeration value="EnabledWithResellerProvisioningAndBillMerchant"/>
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="NotApproved"/>
 *     &lt;enumeration value="Declined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SERVICESTATUS")
@XmlEnum
public enum SERVICESTATUS {

    @XmlEnumValue("Disabled")
    DISABLED("Disabled"),
    @XmlEnumValue("Enabled")
    ENABLED("Enabled"),
    @XmlEnumValue("EnabledWithMerchantProvisioning")
    ENABLED_WITH_MERCHANT_PROVISIONING("EnabledWithMerchantProvisioning"),
    @XmlEnumValue("EnabledWithResellerProvisioningOnly")
    ENABLED_WITH_RESELLER_PROVISIONING_ONLY("EnabledWithResellerProvisioningOnly"),
    @XmlEnumValue("EnabledWithResellerProvisioningAndBillMerchant")
    ENABLED_WITH_RESELLER_PROVISIONING_AND_BILL_MERCHANT("EnabledWithResellerProvisioningAndBillMerchant"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("NotApproved")
    NOT_APPROVED("NotApproved"),
    @XmlEnumValue("Declined")
    DECLINED("Declined");
    private final String value;

    SERVICESTATUS(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SERVICESTATUS fromValue(String v) {
        for (SERVICESTATUS c: SERVICESTATUS.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

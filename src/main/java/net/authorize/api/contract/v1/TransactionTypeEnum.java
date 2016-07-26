//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.03 at 05:32:06 PM IST 
//


package net.authorize.api.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transactionTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="transactionTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="authOnlyTransaction"/>
 *     &lt;enumeration value="authCaptureTransaction"/>
 *     &lt;enumeration value="captureOnlyTransaction"/>
 *     &lt;enumeration value="refundTransaction"/>
 *     &lt;enumeration value="priorAuthCaptureTransaction"/>
 *     &lt;enumeration value="voidTransaction"/>
 *     &lt;enumeration value="getDetailsTransaction"/>
 *     &lt;enumeration value="authOnlyContinueTransaction"/>
 *     &lt;enumeration value="authCaptureContinueTransaction"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "transactionTypeEnum")
@XmlEnum
public enum TransactionTypeEnum {

    @XmlEnumValue("authOnlyTransaction")
    AUTH_ONLY_TRANSACTION("authOnlyTransaction"),
    @XmlEnumValue("authCaptureTransaction")
    AUTH_CAPTURE_TRANSACTION("authCaptureTransaction"),
    @XmlEnumValue("captureOnlyTransaction")
    CAPTURE_ONLY_TRANSACTION("captureOnlyTransaction"),
    @XmlEnumValue("refundTransaction")
    REFUND_TRANSACTION("refundTransaction"),
    @XmlEnumValue("priorAuthCaptureTransaction")
    PRIOR_AUTH_CAPTURE_TRANSACTION("priorAuthCaptureTransaction"),
    @XmlEnumValue("voidTransaction")
    VOID_TRANSACTION("voidTransaction"),
    @XmlEnumValue("getDetailsTransaction")
    GET_DETAILS_TRANSACTION("getDetailsTransaction"),
    @XmlEnumValue("authOnlyContinueTransaction")
    AUTH_ONLY_CONTINUE_TRANSACTION("authOnlyContinueTransaction"),
    @XmlEnumValue("authCaptureContinueTransaction")
    AUTH_CAPTURE_CONTINUE_TRANSACTION("authCaptureContinueTransaction");
    private final String value;

    TransactionTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionTypeEnum fromValue(String v) {
        for (TransactionTypeEnum c: TransactionTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

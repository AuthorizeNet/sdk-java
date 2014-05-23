
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OperationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DECRYPT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OperationType", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd")
@XmlEnum
public enum OperationType {

    DECRYPT;

    public String value() {
        return name();
    }

    public static OperationType fromValue(String v) {
        return valueOf(v);
    }

}

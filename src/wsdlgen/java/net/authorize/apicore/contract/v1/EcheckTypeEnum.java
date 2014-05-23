
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for echeckTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="echeckTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PPD"/>
 *     &lt;enumeration value="WEB"/>
 *     &lt;enumeration value="CCD"/>
 *     &lt;enumeration value="TEL"/>
 *     &lt;enumeration value="ARC"/>
 *     &lt;enumeration value="BOC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "echeckTypeEnum", namespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd")
@XmlEnum
public enum EcheckTypeEnum {

    PPD,
    WEB,
    CCD,
    TEL,
    ARC,
    BOC;

    public String value() {
        return name();
    }

    public static EcheckTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.11 at 11:22:30 PM IST 
//


package net.authorize.api.contract.v1;

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
@XmlType(name = "echeckTypeEnum")
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

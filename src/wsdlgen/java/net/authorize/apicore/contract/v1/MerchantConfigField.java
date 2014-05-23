
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MerchantConfigField.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MerchantConfigField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="AllowPartialAuth"/>
 *     &lt;enumeration value="EnablePartialAuthHold"/>
 *     &lt;enumeration value="PayFormCSSBody"/>
 *     &lt;enumeration value="PayFormColorText"/>
 *     &lt;enumeration value="PayFormColorLink"/>
 *     &lt;enumeration value="PayFormColorBackground"/>
 *     &lt;enumeration value="PayFormFontFamily"/>
 *     &lt;enumeration value="PayFormFontSize"/>
 *     &lt;enumeration value="PayFormHeading1ColorText"/>
 *     &lt;enumeration value="PayFormHeading1ColorBackground"/>
 *     &lt;enumeration value="PayFormHeading1FontFamily"/>
 *     &lt;enumeration value="PayFormHeading1FontSize"/>
 *     &lt;enumeration value="PayFormHeading1FontBold"/>
 *     &lt;enumeration value="PayFormHeading1FontItalic"/>
 *     &lt;enumeration value="PayFormHeading2ColorText"/>
 *     &lt;enumeration value="PayFormHeading2ColorBackground"/>
 *     &lt;enumeration value="PayFormHeading2FontFamily"/>
 *     &lt;enumeration value="PayFormHeading2FontSize"/>
 *     &lt;enumeration value="PayFormHeading2FontBold"/>
 *     &lt;enumeration value="PayFormHeading2FontItalic"/>
 *     &lt;enumeration value="PayFormMask"/>
 *     &lt;enumeration value="PayFormHtmlHeader1"/>
 *     &lt;enumeration value="PayFormHtmlFooter1"/>
 *     &lt;enumeration value="PayFormReceiptHtmlHeader1"/>
 *     &lt;enumeration value="PayFormReceiptHtmlFooter1"/>
 *     &lt;enumeration value="PayFormHtmlHeader2"/>
 *     &lt;enumeration value="PayFormHtmlFooter2"/>
 *     &lt;enumeration value="PayFormReceiptHtmlHeader2"/>
 *     &lt;enumeration value="PayFormReceiptHtmlFooter2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MerchantConfigField")
@XmlEnum
public enum MerchantConfigField {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("AllowPartialAuth")
    ALLOW_PARTIAL_AUTH("AllowPartialAuth"),
    @XmlEnumValue("EnablePartialAuthHold")
    ENABLE_PARTIAL_AUTH_HOLD("EnablePartialAuthHold"),
    @XmlEnumValue("PayFormCSSBody")
    PAY_FORM_CSS_BODY("PayFormCSSBody"),
    @XmlEnumValue("PayFormColorText")
    PAY_FORM_COLOR_TEXT("PayFormColorText"),
    @XmlEnumValue("PayFormColorLink")
    PAY_FORM_COLOR_LINK("PayFormColorLink"),
    @XmlEnumValue("PayFormColorBackground")
    PAY_FORM_COLOR_BACKGROUND("PayFormColorBackground"),
    @XmlEnumValue("PayFormFontFamily")
    PAY_FORM_FONT_FAMILY("PayFormFontFamily"),
    @XmlEnumValue("PayFormFontSize")
    PAY_FORM_FONT_SIZE("PayFormFontSize"),
    @XmlEnumValue("PayFormHeading1ColorText")
    PAY_FORM_HEADING_1_COLOR_TEXT("PayFormHeading1ColorText"),
    @XmlEnumValue("PayFormHeading1ColorBackground")
    PAY_FORM_HEADING_1_COLOR_BACKGROUND("PayFormHeading1ColorBackground"),
    @XmlEnumValue("PayFormHeading1FontFamily")
    PAY_FORM_HEADING_1_FONT_FAMILY("PayFormHeading1FontFamily"),
    @XmlEnumValue("PayFormHeading1FontSize")
    PAY_FORM_HEADING_1_FONT_SIZE("PayFormHeading1FontSize"),
    @XmlEnumValue("PayFormHeading1FontBold")
    PAY_FORM_HEADING_1_FONT_BOLD("PayFormHeading1FontBold"),
    @XmlEnumValue("PayFormHeading1FontItalic")
    PAY_FORM_HEADING_1_FONT_ITALIC("PayFormHeading1FontItalic"),
    @XmlEnumValue("PayFormHeading2ColorText")
    PAY_FORM_HEADING_2_COLOR_TEXT("PayFormHeading2ColorText"),
    @XmlEnumValue("PayFormHeading2ColorBackground")
    PAY_FORM_HEADING_2_COLOR_BACKGROUND("PayFormHeading2ColorBackground"),
    @XmlEnumValue("PayFormHeading2FontFamily")
    PAY_FORM_HEADING_2_FONT_FAMILY("PayFormHeading2FontFamily"),
    @XmlEnumValue("PayFormHeading2FontSize")
    PAY_FORM_HEADING_2_FONT_SIZE("PayFormHeading2FontSize"),
    @XmlEnumValue("PayFormHeading2FontBold")
    PAY_FORM_HEADING_2_FONT_BOLD("PayFormHeading2FontBold"),
    @XmlEnumValue("PayFormHeading2FontItalic")
    PAY_FORM_HEADING_2_FONT_ITALIC("PayFormHeading2FontItalic"),
    @XmlEnumValue("PayFormMask")
    PAY_FORM_MASK("PayFormMask"),
    @XmlEnumValue("PayFormHtmlHeader1")
    PAY_FORM_HTML_HEADER_1("PayFormHtmlHeader1"),
    @XmlEnumValue("PayFormHtmlFooter1")
    PAY_FORM_HTML_FOOTER_1("PayFormHtmlFooter1"),
    @XmlEnumValue("PayFormReceiptHtmlHeader1")
    PAY_FORM_RECEIPT_HTML_HEADER_1("PayFormReceiptHtmlHeader1"),
    @XmlEnumValue("PayFormReceiptHtmlFooter1")
    PAY_FORM_RECEIPT_HTML_FOOTER_1("PayFormReceiptHtmlFooter1"),
    @XmlEnumValue("PayFormHtmlHeader2")
    PAY_FORM_HTML_HEADER_2("PayFormHtmlHeader2"),
    @XmlEnumValue("PayFormHtmlFooter2")
    PAY_FORM_HTML_FOOTER_2("PayFormHtmlFooter2"),
    @XmlEnumValue("PayFormReceiptHtmlHeader2")
    PAY_FORM_RECEIPT_HTML_HEADER_2("PayFormReceiptHtmlHeader2"),
    @XmlEnumValue("PayFormReceiptHtmlFooter2")
    PAY_FORM_RECEIPT_HTML_FOOTER_2("PayFormReceiptHtmlFooter2");
    private final String value;

    MerchantConfigField(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MerchantConfigField fromValue(String v) {
        for (MerchantConfigField c: MerchantConfigField.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

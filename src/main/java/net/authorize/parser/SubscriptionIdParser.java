package net.authorize.parser;

import net.authorize.AuthNetField;
import net.authorize.util.BasicXmlDocument;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SubscriptionIdParser {
    private SubscriptionIdParser(){}

    public static String parse(Element transaction_el) {
        NodeList subscription_list = transaction_el.getElementsByTagName(AuthNetField.ELEMENT_SUBSCRIPTION.getFieldName());

        if (subscription_list != null && subscription_list.getLength() > 0) {
            Element subscription_el = (Element) subscription_list.item(0);
            return BasicXmlDocument.getElementText(subscription_el, AuthNetField.ELEMENT_ID.getFieldName());
        }

        return null;
    }

}

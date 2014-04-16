package net.authorize.parser;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SubscriptionIdParserTest {
    private DocumentBuilder document;

    @Before
    public void setUp() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        document = factory.newDocumentBuilder();
    }

    @Test
    public void parse_invalid_no_subscription() throws Exception {
        Document subscription = createSubscription("<na></na>");
        assertNull(SubscriptionIdParser.parse(subscription.getDocumentElement()));
    }

    @Test
    public void parse_invalid_no_subscription_id() throws Exception {
        Document subscription = createSubscription("<thing><subscription></subscription></thing>");
        assertNull(SubscriptionIdParser.parse(subscription.getDocumentElement()));
    }

    @Test
    public void parse_valid() throws Exception {
        String subscriptionId = "12351141";
        String xml = String.format("<thing><subscription><id>%s</id></subscription></thing>", subscriptionId);
        Document subscription = createSubscription(xml);
        assertEquals(subscriptionId, SubscriptionIdParser.parse(subscription.getDocumentElement()));
    }

    private Document createSubscription(String xml) throws Exception {
        return document.parse(new ByteArrayInputStream(xml.getBytes()));
    }

}

package net.authorize.util;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.MessagesType;
import net.authorize.api.contract.v1.ErrorResponse;

import org.junit.Assert;
import org.junit.Test;

public class XmlUtilityTest {
	@Test
	public void testXmlUtility() throws Exception {
		Random rand = new Random();

		MyTest myt = new MyTest();
		myt.setName("Test For X & with ampersand");
		System.out.println(myt);
		String xml = XmlUtility.getXml(myt);
		Assert.assertNotNull(xml);
		System.out.println(xml);
		MyTest xmlMyt = XmlUtility.create(xml, MyTest.class);
		Assert.assertNotNull(xmlMyt);
		System.out.println(xmlMyt);

		System.out.println(XmlUtility.getRootElementXml(myt));
		System.out.println(XmlUtility.getRootElementXml(xml));
	}

	@Test
	public void testStringXmlUtility() {
		final String base = "Bad string with & last character as period.";
		String xmlBase = XmlUtility.escapeStringForXml(base);
		Assert.assertNotNull(xmlBase);
		Assert.assertNotSame(base, xmlBase);
		Assert.assertFalse(base.equals(xmlBase));

		String decoded = XmlUtility.descapeStringForXml(xmlBase);
		Assert.assertNotNull(decoded);
		Assert.assertNotSame(xmlBase, decoded);
		Assert.assertFalse(xmlBase.equals(decoded));
		Assert.assertEquals(base, decoded);
		Assert.assertTrue(base.equals(decoded));
	}

	@Test
	public void testStringXmlUtilityNegative() {
		testStringXmlUtilityNegative(null, true);
		testStringXmlUtilityNegative("", false);
		testStringXmlUtilityNegative(" ", false);
	}

	@Test
	public void testErrorResponse() {
		final String xmlFromApiCall = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ErrorResponse xmlns=\"AnetApi/xml/v1/schema/AnetApiSchema.xsd\"><messages><resultCode>Error</resultCode><message><code>E00003</code><text>The element 'ARBGetSubscriptionReportRequest' in namespace 'AnetApi/xml/v1/schema/AnetApiSchema.xsd' has invalid child element 'OrderDescending' in namespace 'AnetApi/xml/v1/schema/AnetApiSchema.xsd'. List of possible elements expected: 'ExpDateHash, StartReportDate' in namespace 'AnetApi/xml/v1/schema/AnetApiSchema.xsd'.</text></message></messages></ErrorResponse>";

		MessagesType.Message message = new MessagesType.Message();
		message.setCode("E00003");
		message.setText(
				"The element 'ARBGetSubscriptionReportRequest' in namespace 'AnetApi/xml/v1/schema/AnetApiSchema.xsd' has invalid child element 'OrderDescending' in namespace 'AnetApi/xml/v1/schema/AnetApiSchema.xsd'. List of possible elements expected: 'ExpDateHash, StartReportDate' in namespace 'AnetApi/xml/v1/schema/AnetApiSchema.xsd'.");
		MessagesType messagesType = new MessagesType();
		messagesType.setResultCode(MessageTypeEnum.ERROR);
		List<MessagesType.Message> messages = messagesType.getMessage();
		messages.add(message);

		ErrorResponse testResponse = new ErrorResponse();
		testResponse.setMessages(messagesType);

		try {
			String xmlFromTestResponse = XmlUtility.getXml(testResponse);
			Assert.assertNotNull(xmlFromTestResponse);
			ErrorResponse responseFromTestXmlResponse = XmlUtility.create(xmlFromTestResponse, ErrorResponse.class);
			Assert.assertNotNull(responseFromTestXmlResponse);

			ErrorResponse responseFromApiCallXml = XmlUtility.create(xmlFromApiCall, ErrorResponse.class);
			Assert.assertNotNull(responseFromApiCallXml);

			String xmlFromResponseOfApiCallXml = XmlUtility.getXml(responseFromApiCallXml);
			Assert.assertNotNull(xmlFromResponseOfApiCallXml);

			// clean up spaces and line breaks for comparison
			Assert.assertEquals(xmlFromApiCall.replaceAll("[ ]", ""),
					xmlFromResponseOfApiCallXml.replaceAll("[" + System.getProperty("line.separator") + " ]", ""));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	private void testStringXmlUtilityNegative(String someValue, boolean nullCheck) {
		String xmlBase = XmlUtility.escapeStringForXml(someValue);
		String decoded = XmlUtility.descapeStringForXml(someValue);
		if (nullCheck) {
			Assert.assertNull(xmlBase);
			Assert.assertNull(decoded);
		} else {
			Assert.assertNotNull(xmlBase);
			Assert.assertNotNull(decoded);
			Assert.assertEquals(someValue, xmlBase);
			Assert.assertEquals(someValue, decoded);
		}
	}
}

@XmlRootElement
class MyTest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyTest:");
		builder.append(" Name: ").append(this.name);

		return builder.toString();
	}
}

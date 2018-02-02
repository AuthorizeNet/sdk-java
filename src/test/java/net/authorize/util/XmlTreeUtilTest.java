package net.authorize.util;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;

public class XmlTreeUtilTest {

	@Test
	public void testEscape() {
		BasicXmlDocument doc = new BasicXmlDocument();
		doc.parseString("<test/>");

		Element el = doc.createElement("child");
		el.setAttribute("attr", "can't \" quote in here");
		el.appendChild(doc.getDocument().createTextNode("this & that"));
		doc.getDocumentElement().appendChild(el);
		
		XmlTreeUtil util = new XmlTreeUtil();
		String xml = util.printTree(doc.document);
		
		Assert.assertTrue(doc.parseString(xml));
	}
}

package net.authorize.util;

import java.io.Serializable;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

import net.authorize.data.reporting.Subscription;

import org.junit.Assert;
import org.junit.Test;

public class XmlUtilityTest {
	@Test
	public void testXmlUtility() throws Exception
	{
		Random rand = new Random();
		
		Subscription subscription = Subscription.createSubscription(rand.nextInt(100), rand.nextInt(1000));
		MyTest myt = new MyTest();
		myt.setName( "Test For X & with ampersand");
		myt.setSubs(subscription);
		System.out.println(myt);
		String xml = XmlUtility.getXml(myt);
		Assert.assertNotNull( xml);
		System.out.println(xml);
		MyTest xmlMyt = XmlUtility.create(xml, MyTest.class);
		Assert.assertNotNull( xmlMyt);
		System.out.println(xmlMyt);
		
		System.out.println( XmlUtility.getRootElementXml(myt));
		System.out.println( XmlUtility.getRootElementXml(xml));		
	}
	
	@Test
	public void testStringXmlUtility() {
		final String base = "Bad string with & last character as period.";
		String xmlBase = XmlUtility.escapeStringForXml( base);
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
		testStringXmlUtilityNegative( null, true);
		testStringXmlUtilityNegative( "", false);
		testStringXmlUtilityNegative( " ", false);
	}

	private void testStringXmlUtilityNegative(String someValue, boolean nullCheck) {
		String xmlBase = XmlUtility.escapeStringForXml( someValue);
		String decoded = XmlUtility.descapeStringForXml(someValue);
		if ( nullCheck) {
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
	private Subscription subs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Subscription getSubs() {
		return subs;
	}
	public void setSubs(Subscription subs) {
		this.subs = subs;
	}
	
	public String toString() {
		 StringBuilder builder = new StringBuilder();
		 builder.append("MyTest:");
		 builder.append(" Name: ").append(this.name);
		 builder.append(", ").append(this.subs);
		 
	     return builder.toString();
    }	
}

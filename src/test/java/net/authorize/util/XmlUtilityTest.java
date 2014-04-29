package net.authorize.util;

import java.io.Serializable;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

import org.junit.Assert;
import org.junit.Test;

import net.authorize.data.reporting.Subscription;

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

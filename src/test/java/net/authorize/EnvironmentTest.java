package net.authorize;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class EnvironmentTest extends UnitTestData {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void createCustomEnvironment() {
		Environment environment = Environment.createEnvironment(
				"http://localhost:8080", "http://localhost:8081");

		Assert.assertEquals("http://localhost:8080", environment.getBaseUrl());
		Assert.assertEquals("http://localhost:8081", environment.getXmlBaseUrl());
		Assert.assertEquals(Environment.CUSTOM.name(), environment.name());
	}

	@Test
	public void testInternetConnectionViaProxy() {
		boolean internetAccessible = UnitTestData.isInternetAccessible();
		if ( !internetAccessible) {
			System.out.println("Make sure to set the following properties in the environment or via properties file.");
			
			for (String property : UnitTestData.getPropertiesList()) {
				if ( !property.toLowerCase().contains("password")) {
					System.out.printf("Property '%s'%s", property, net.authorize.util.LogHelper.LineSeparator);
				}
			}
		}
		Assert.assertTrue("Internet is not accessible.", internetAccessible);
	}
}

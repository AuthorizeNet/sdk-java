package net.authorize;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class EnvironmentTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void createCustomEnvironment() {
		Environment environment = Environment.createEnvironment("http://localhost:8080","http://localhost:8081");

		Assert.assertEquals("http://localhost:8080", environment.getBaseUrl());
		Assert.assertEquals("http://localhost:8081", environment.getXmlBaseUrl());
		Assert.assertEquals(Environment.CUSTOM.name(), environment.name());
	}

}

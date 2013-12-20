package net.authorize.data;


import junit.framework.Assert;
import net.authorize.UnitTestData;
import net.authorize.data.ShippingAddress;

import org.junit.Before;
import org.junit.Test;

public class ShippingAddressTest extends UnitTestData {

	private ShippingAddress shippingAddress;

	@Before
	public void setUp() throws Exception {
		this.shippingAddress = ShippingAddress.createShippingAddress();
	}

	@Test
	public void createShippingAddress() {
		Assert.assertNotNull(this.shippingAddress);
	}

	@Test
	public void validateShippingAddressFields() {
		this.shippingAddress.setAddress(address);
		this.shippingAddress.setCity(city);
		this.shippingAddress.setCompany(company);
		this.shippingAddress.setCountry(country);
		this.shippingAddress.setFirstName(firstName);
		this.shippingAddress.setLastName(lastName);
		this.shippingAddress.setState(state);
		this.shippingAddress.setZipPostalCode(zipPostalCode);

		Assert.assertEquals(address, this.shippingAddress.getAddress());
		Assert.assertEquals(city, this.shippingAddress.getCity());
		Assert.assertEquals(company, this.shippingAddress.getCompany());
		Assert.assertEquals(country, this.shippingAddress.getCountry());
		Assert.assertEquals(firstName, this.shippingAddress.getFirstName());
		Assert.assertEquals(lastName, this.shippingAddress.getLastName());
		Assert.assertEquals(state, this.shippingAddress.getState());
		Assert.assertEquals(zipPostalCode, this.shippingAddress.getZipPostalCode());
	}

}

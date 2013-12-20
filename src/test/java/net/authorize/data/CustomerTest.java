package net.authorize.data;

import junit.framework.Assert;
import net.authorize.UnitTestData;
import net.authorize.data.Customer;

import org.junit.Before;
import org.junit.Test;


public class CustomerTest extends UnitTestData {

	private Customer customer;

	@Before
	public void setUp() {
		this.customer = Customer.createCustomer();
	}

	@Test
	public void createCustomer() {
		Assert.assertNotNull(customer);
	}

	public void checkCustomerFields() {

		customer = Customer.createCustomer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setZipPostalCode(zipPostalCode);
		customer.setCompany(company);
		customer.setCountry(country);
		customer.setCustomerId(customerId);
		customer.setCustomerIP(customerIP);
		customer.setEmail(email);
		customer.setFax(fax);
		customer.setPhone(phone);

		Assert.assertEquals(firstName, customer.getFirstName());
		Assert.assertEquals(lastName, customer.getLastName());
		Assert.assertEquals(address, customer.getAddress());
		Assert.assertEquals(city, customer.getCity());
		Assert.assertEquals(state, customer.getState());
		Assert.assertEquals(zipPostalCode, customer.getZipPostalCode());
		Assert.assertEquals(company, customer.getCompany());
		Assert.assertEquals(country, customer.getCountry());
		Assert.assertEquals(customerId, customer.getCustomerId());
		Assert.assertEquals(customerIP, customer.getCustomerIP());
		Assert.assertEquals(email, customer.getEmail());
		Assert.assertEquals(fax, customer.getFax());
		Assert.assertEquals(phone, customer.getPhone());
	}
}

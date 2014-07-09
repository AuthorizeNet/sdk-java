package net.authorize.apicore.controller.test;

import junit.framework.Assert;
import net.authorize.apicore.contract.v1.CreateCustomerShippingAddressRequest;
import net.authorize.apicore.contract.v1.CreateCustomerShippingAddressResponse;
import net.authorize.apicore.contract.v1.CustomerAddressType;
import net.authorize.apicore.contract.v1.DeleteCustomerShippingAddressRequest;
import net.authorize.apicore.contract.v1.DeleteCustomerShippingAddressResponse;
import net.authorize.apicore.contract.v1.MerchantAuthenticationType;
import net.authorize.apicore.controller.CreateCustomerShippingAddressController;
import net.authorize.apicore.controller.DeleteCustomerShippingAddressController;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerShippingAddressTest extends ApiCoreTestBase {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApiCoreTestBase.setUpBeforeClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ApiCoreTestBase.tearDownAfterClass();
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testProcessCreateAndDeleteCustomerShippingAddressRequest() {
		//create a new customer profile
		String customerProfileId = CustomerProfileTest.createCustomerProfile(cnpMerchantAuthenticationType, customerPaymentProfileOne, customerProfileType, refId);
		
		//create a new customer shipping address
		String customerShippingAddressId = createCustomerShippingAddress(cnpMerchantAuthenticationType, customerAddressOne, customerProfileId, refId);
		Assert.assertNotNull(customerShippingAddressId);
		
		//delete the customer profile created earlier
		deleteCustomerShippingAddress(cnpMerchantAuthenticationType, customerProfileId, customerShippingAddressId, refId);

		//delete the customer shipping address created earlier
		CustomerProfileTest.deleteCustomerProfile(cnpMerchantAuthenticationType, customerProfileId, refId);
	}

	static String createCustomerShippingAddress(MerchantAuthenticationType merchantAuthenticationType, CustomerAddressType customerAddressType, String customerProfileId, String referenceId) {
		CreateCustomerShippingAddressRequest createRequest = new CreateCustomerShippingAddressRequest();
		createRequest.setMerchantAuthentication( merchantAuthenticationType);
		createRequest.setRefId(referenceId);
		createRequest.setCustomerProfileId(customerProfileId);
		createRequest.setAddress( customerAddressType);
		
		CreateCustomerShippingAddressResponse createResponse = executeTestRequestWithSuccess(createRequest, CreateCustomerShippingAddressController.class, environment);
		String CustomerShippingAddressId = createResponse.getCustomerAddressId();
		
		return CustomerShippingAddressId;
	}

	static void deleteCustomerShippingAddress(MerchantAuthenticationType merchantAuthenticationType, String customerProfileId, String customerShippingAddressId, String referenceId) {
		DeleteCustomerShippingAddressRequest deleteRequest = new DeleteCustomerShippingAddressRequest();
		deleteRequest.setMerchantAuthentication(merchantAuthenticationType);
		deleteRequest.setRefId(referenceId);
		deleteRequest.setCustomerAddressId( customerShippingAddressId);
		deleteRequest.setCustomerProfileId(customerProfileId);
		
		DeleteCustomerShippingAddressResponse deleteResponse = executeTestRequestWithSuccess(deleteRequest, DeleteCustomerShippingAddressController.class, environment);
		Assert.assertNotNull(deleteResponse);
	}
}

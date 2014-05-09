package net.authorize.apicore.helper.test;

import java.util.List;

import junit.framework.Assert;
import net.authorize.apicore.contract.v1.CreateCustomerProfileRequest;
import net.authorize.apicore.contract.v1.CreateCustomerProfileResponse;
import net.authorize.apicore.contract.v1.CustomerPaymentProfileType;
import net.authorize.apicore.contract.v1.DeleteCustomerProfileRequest;
import net.authorize.apicore.contract.v1.DeleteCustomerProfileResponse;
import net.authorize.apicore.contract.v1.MessageTypeEnum;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.helper.CreateCustomerProfile;
import net.authorize.apicore.helper.DeleteCustomerProfile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerProfileTest extends ApiCoreTestBase {
	
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
	public void testProcessCreateAndDeleteCustomerProfileRequest() {
		
		//create a new customer profile
		CreateCustomerProfileRequest createRequest = new CreateCustomerProfileRequest();
		createRequest.setMerchantAuthentication(merchantAuthenticationType);
		createRequest.setProfile(customerProfileType);
		createRequest.setRefId(refId);
		createRequest.setValidationMode(ValidationModeEnum.TEST_MODE);
		List<CustomerPaymentProfileType> paymentProfiles = createRequest.getProfile().getPaymentProfiles();
		paymentProfiles.add( customerPaymentProfileOne);
		
		CreateCustomerProfile createProfile = new CreateCustomerProfile(createRequest);
		CreateCustomerProfileResponse createResponse = createProfile.executeWithApiResponse(environment);
		logger.info(String.format("Create ResultCode: %s", createProfile.getResultCode()));
		logger.info(String.format("Create Results:    %s", createProfile.getResults()));

		Assert.assertEquals( MessageTypeEnum.OK, createProfile.getResultCode());
		Assert.assertNull(createProfile.getErrorResponse());
		Assert.assertNotNull(createResponse);
		Assert.assertNotNull(createResponse.getCustomerProfileId());
		
		//delete the customer profile create earlier
		DeleteCustomerProfileRequest deleteRequest = new DeleteCustomerProfileRequest();
		deleteRequest.setMerchantAuthentication(merchantAuthenticationType);
		deleteRequest.setRefId(refId);
		deleteRequest.setCustomerProfileId( createResponse.getCustomerProfileId());
		
		DeleteCustomerProfile deleteProfile = new DeleteCustomerProfile(deleteRequest);
		deleteProfile.execute(environment);  
		DeleteCustomerProfileResponse deleteResponse = deleteProfile.getApiResponse();
		logger.info(String.format("Delete ResultCode: %s", deleteProfile.getResultCode()));
		logger.info(String.format("Delete Results:    %s", deleteProfile.getResults()));
		
		Assert.assertEquals( MessageTypeEnum.OK, deleteProfile.getResultCode());
		Assert.assertNull(deleteProfile.getErrorResponse());
		Assert.assertNotNull(deleteResponse);
	}
}

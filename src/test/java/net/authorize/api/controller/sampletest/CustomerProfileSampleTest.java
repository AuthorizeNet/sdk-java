package net.authorize.api.controller.sampletest;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import net.authorize.api.contract.v1.CreateCustomerPaymentProfileRequest;
import net.authorize.api.contract.v1.CreateCustomerPaymentProfileResponse;
import net.authorize.api.contract.v1.CreateCustomerProfileRequest;
import net.authorize.api.contract.v1.CreateCustomerProfileResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.CustomerPaymentProfileListItemType;
import net.authorize.api.contract.v1.CustomerPaymentProfileSearchTypeEnum;
import net.authorize.api.contract.v1.CustomerPaymentProfileType;
import net.authorize.api.contract.v1.CustomerProfileType;
import net.authorize.api.contract.v1.CustomerTypeEnum;
import net.authorize.api.contract.v1.DeleteCustomerProfileRequest;
import net.authorize.api.contract.v1.DeleteCustomerProfileResponse;
import net.authorize.api.contract.v1.GetCustomerPaymentProfileListRequest;
import net.authorize.api.contract.v1.GetCustomerPaymentProfileListResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.CreateCustomerPaymentProfileController;
import net.authorize.api.controller.CreateCustomerProfileController;
import net.authorize.api.controller.DeleteCustomerProfileController;
import net.authorize.api.controller.GetCustomerPaymentProfileListController;
import net.authorize.api.controller.base.ApiOperationBase;
import net.authorize.api.controller.test.ApiCoreTestBase;
import net.authorize.util.LogHelper;

public class CustomerProfileSampleTest  extends ApiCoreTestBase {

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
	public void getCustomerPaymentProfileListSample()
	{
		//Common code to set for all requests
		ApiOperationBase.setEnvironment(environment);
		ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);

		CreateCustomerProfileResponse createdCustomerProfile = createCustomerProfile();

		try {
			GetCustomerPaymentProfileListRequest request = new GetCustomerPaymentProfileListRequest();
			request.setRefId(refId);
			request.setSearchType(CustomerPaymentProfileSearchTypeEnum.CARDS_EXPIRING_IN_MONTH);
			request.setMonth("2040-12");

			int retryCount = 3;
			boolean found = false;
			do {
				// Pause for about 15 seconds, so that the created subscription
				// will be in the next service call.
				try {
					Thread.sleep(15000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				GetCustomerPaymentProfileListController customerPaymentProfileController = new GetCustomerPaymentProfileListController(request);
				customerPaymentProfileController.execute();
				GetCustomerPaymentProfileListResponse response = customerPaymentProfileController.getApiResponse();

				Assert.assertNotNull(response);
				Assert.assertEquals(MessageTypeEnum.OK, response.getMessages().getResultCode());

				List<CustomerPaymentProfileListItemType> paymentProfiles = response.getPaymentProfiles().getPaymentProfile();

				Assert.assertTrue( 0 < response.getTotalNumInResultSet());
				Assert.assertNotNull(paymentProfiles);
				LogHelper.info( logger, "Customer Payment Profile List Count: %d", response.getTotalNumInResultSet());	

				for( CustomerPaymentProfileListItemType customerPaymentProfile : paymentProfiles) {
					String customerPaymentProfileId = Integer.toString(customerPaymentProfile.getCustomerProfileId());
					LogHelper.info( logger, "Customer Profile Id: %s", customerPaymentProfileId);
					if (customerPaymentProfileId.equals(createdCustomerProfile.getCustomerProfileId())) { found = true;}
				}
			} while (!found && --retryCount > 0);

			Assert.assertTrue("The customer payment profile " + createdCustomerProfile.getCustomerProfileId()
			+ " not found in the list.", found);
		} finally {
			// delete
			DeleteCustomerProfileRequest deleteCustomerProfileRequest = new DeleteCustomerProfileRequest();
			deleteCustomerProfileRequest.setRefId(refId);
			deleteCustomerProfileRequest.setCustomerProfileId(createdCustomerProfile.getCustomerProfileId());

			DeleteCustomerProfileController deleteCustomerProfileController = new DeleteCustomerProfileController(deleteCustomerProfileRequest);
			deleteCustomerProfileController.execute();
			DeleteCustomerProfileResponse deleteCustomerProfileResponse = deleteCustomerProfileController.getApiResponse();

			Assert.assertNotNull(deleteCustomerProfileResponse);
			Assert.assertEquals(MessageTypeEnum.OK, deleteCustomerProfileResponse.getMessages().getResultCode());
			logger.info(String.format("Customer Profile Deleted %s",
					createdCustomerProfile.getCustomerProfileId()));
		}
	}
	
	private CreateCustomerProfileResponse createCustomerProfile()
	{
		//Common code to set for all requests
		ApiOperationBase.setEnvironment(environment);
		ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);
		
		CreateCustomerProfileRequest request = new CreateCustomerProfileRequest();
		request.setRefId(refId);
		
		CreditCardType creditCard = new CreditCardType();
		creditCard.setCardNumber("4111111111111111");
		creditCard.setExpirationDate("2040-12");
		
		PaymentType payment = new PaymentType();
		payment.setCreditCard(creditCard);
		
		CustomerPaymentProfileType customerPaymentProfile = new CustomerPaymentProfileType();
		customerPaymentProfile.setCustomerType(CustomerTypeEnum.INDIVIDUAL);
		customerPaymentProfile.setPayment(payment);
		
		CustomerProfileType customerProfile = new CustomerProfileType() ;
		customerProfile.setMerchantCustomerId(getRandomString("Cust"));
		customerProfile.setDescription(getRandomString("CustDescription"));
		customerProfile.setEmail(counterStr+".customerProfileTest@test.anet.net");
		
		customerProfile.getPaymentProfiles().add(customerPaymentProfile);
		request.setProfile(customerProfile);
		request.setValidationMode(ValidationModeEnum.TEST_MODE);
		
		CreateCustomerProfileController createProfileController = new CreateCustomerProfileController(request);
		createProfileController.execute();
		CreateCustomerProfileResponse response = createProfileController.getApiResponse();
		
		Assert.assertNotNull(response);
		Assert.assertEquals(MessageTypeEnum.OK, response.getMessages().getResultCode());
		Assert.assertFalse(response.getCustomerProfileId().isEmpty());		
		
		return response;
	}
}

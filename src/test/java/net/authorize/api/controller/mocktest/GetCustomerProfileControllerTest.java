package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CustomerProfileMaskedType;
import net.authorize.api.contract.v1.GetCustomerProfileRequest;
import net.authorize.api.contract.v1.GetCustomerProfileResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetCustomerProfileControllerTest extends ApiCoreTestBase {
	
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
	public void mockGetCustomerProfileControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<GetCustomerProfileRequest, GetCustomerProfileResponse> mockController = getMockController();
		
		final GetCustomerProfileRequest mockRequest = factory.createGetCustomerProfileRequest();
		mockRequest.setRefId(refId);
		
		CustomerProfileMaskedType customerProfile = factory.createCustomerProfileMaskedType();
		customerProfile.setCustomerProfileId(counterStr);

		final GetCustomerProfileResponse   mockResponse = factory.createGetCustomerProfileResponse();
		mockResponse.setProfile(customerProfile);;//( paymentProfile);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		GetCustomerProfileResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getProfile());
		Assert.assertNotNull(controllerResponse.getProfile().getCustomerProfileId());
		logger.info(String.format("GetCustomerProfile: Details:%s", controllerResponse.getProfile().getCustomerProfileId()));
	}
}

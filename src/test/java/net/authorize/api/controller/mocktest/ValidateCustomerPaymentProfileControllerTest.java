package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.ValidateCustomerPaymentProfileRequest;
import net.authorize.api.contract.v1.ValidateCustomerPaymentProfileResponse;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidateCustomerPaymentProfileControllerTest extends ApiCoreTestBase {
	
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
	public void mockValidateCustomerPaymentProfileControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<ValidateCustomerPaymentProfileRequest, ValidateCustomerPaymentProfileResponse> mockController = getMockController();
		
		final ValidateCustomerPaymentProfileRequest mockRequest = factory.createValidateCustomerPaymentProfileRequest();
		mockRequest.setRefId(refId);
		
		final ValidateCustomerPaymentProfileResponse   mockResponse = factory.createValidateCustomerPaymentProfileResponse();
		mockResponse.setDirectResponse(counterStr);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		ValidateCustomerPaymentProfileResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getDirectResponse());
		logger.info(String.format("ValidateCustomerPaymentProfile: Details:%s", controllerResponse.getDirectResponse()));
	}
}

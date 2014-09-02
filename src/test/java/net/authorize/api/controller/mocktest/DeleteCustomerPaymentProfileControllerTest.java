package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.DeleteCustomerPaymentProfileRequest;
import net.authorize.api.contract.v1.DeleteCustomerPaymentProfileResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeleteCustomerPaymentProfileControllerTest extends ApiCoreTestBase {
	
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
	public void mockDeleteCustomerPaymentProfileControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<DeleteCustomerPaymentProfileRequest, DeleteCustomerPaymentProfileResponse> mockController = getMockController();
		
		final DeleteCustomerPaymentProfileRequest mockRequest = factory.createDeleteCustomerPaymentProfileRequest();
		mockRequest.setRefId(refId);
		
		final DeleteCustomerPaymentProfileResponse   mockResponse = factory.createDeleteCustomerPaymentProfileResponse();

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		DeleteCustomerPaymentProfileResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		logger.info(String.format("DeleteCustomerPaymentProfile: %s", controllerResponse));
	}
}

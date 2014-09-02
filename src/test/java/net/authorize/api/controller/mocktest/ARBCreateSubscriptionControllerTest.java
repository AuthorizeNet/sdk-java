package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ARBCreateSubscriptionRequest;
import net.authorize.api.contract.v1.ARBCreateSubscriptionResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ARBCreateSubscriptionControllerTest extends ApiCoreTestBase {
	
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
	public void mockARBCreateSubscriptionControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<ARBCreateSubscriptionRequest, ARBCreateSubscriptionResponse> mockController = getMockController();
		
		final ARBCreateSubscriptionRequest mockRequest = factory.createARBCreateSubscriptionRequest();
		mockRequest.setRefId(refId);
		
		final ARBCreateSubscriptionResponse   mockResponse = factory.createARBCreateSubscriptionResponse();
		mockResponse.setSubscriptionId(counterStr);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		ARBCreateSubscriptionResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getSubscriptionId());
		logger.info(String.format("ARBCreateSubscription: Id:%s", controllerResponse.getSubscriptionId()));
	}
}

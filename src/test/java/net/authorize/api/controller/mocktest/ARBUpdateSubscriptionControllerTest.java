package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ARBUpdateSubscriptionRequest;
import net.authorize.api.contract.v1.ARBUpdateSubscriptionResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ARBUpdateSubscriptionControllerTest extends ApiCoreTestBase {
	
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
	public void mockARBUpdateSubscriptionControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<ARBUpdateSubscriptionRequest, ARBUpdateSubscriptionResponse> mockController = getMockController();
		
		final ARBUpdateSubscriptionRequest mockRequest = factory.createARBUpdateSubscriptionRequest();
		mockRequest.setRefId(refId);
		
		final ARBUpdateSubscriptionResponse   mockResponse = factory.createARBUpdateSubscriptionResponse();

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		ARBUpdateSubscriptionResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		logger.info(String.format("ARBUpdateSubscription: %s", controllerResponse));
	}
}

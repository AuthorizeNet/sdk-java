package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ARBGetSubscriptionStatusRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionStatusResponse;
import net.authorize.api.contract.v1.ARBSubscriptionStatusEnum;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ARBGetSubscriptionStatusControllerTest extends ApiCoreTestBase {
	
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
	public void mockARBGetSubscriptionStatusControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<ARBGetSubscriptionStatusRequest, ARBGetSubscriptionStatusResponse> mockController = getMockController();
		
		final ARBGetSubscriptionStatusRequest mockRequest = factory.createARBGetSubscriptionStatusRequest();
		mockRequest.setRefId(refId);
		
		final ARBGetSubscriptionStatusResponse   mockResponse = factory.createARBGetSubscriptionStatusResponse();
		mockResponse.setStatus( ARBSubscriptionStatusEnum.ACTIVE);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		ARBGetSubscriptionStatusResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getStatus());
		logger.info(String.format("ARBGetSubscriptionStatus: Status:%s", controllerResponse.getStatus()));
	}
}

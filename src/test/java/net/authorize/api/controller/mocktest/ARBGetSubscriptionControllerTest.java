package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ARBGetSubscriptionRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionResponse;
import net.authorize.api.contract.v1.ARBSubscriptionMaskedType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

public class ARBGetSubscriptionControllerTest extends ApiCoreTestBase {
	
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
	public void mockARBGetSubscriptionControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<ARBGetSubscriptionRequest, ARBGetSubscriptionResponse> mockController = getMockController();
		
		final ARBGetSubscriptionRequest mockRequest = factory.createARBGetSubscriptionRequest();
		mockRequest.setRefId(refId);
		
		final ARBGetSubscriptionResponse   mockResponse = factory.createARBGetSubscriptionResponse();
		
		ARBSubscriptionMaskedType subscription = factory.createARBSubscriptionMaskedType();
		subscription.setName("testsubscription");
		mockResponse.setSubscription(subscription);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		ARBGetSubscriptionResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getSubscription());
		Assert.assertNotNull(controllerResponse.getSubscription().getName());
		logger.info(String.format("ARBGetSubscription: Name:%s", controllerResponse.getSubscription().getName()));
	}
}

package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.DecryptPaymentDataRequest;
import net.authorize.api.contract.v1.DecryptPaymentDataResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DecryptPaymentDataControllerTest extends ApiCoreTestBase {
	
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
	public void mockDecryptPaymentDataControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<DecryptPaymentDataRequest, DecryptPaymentDataResponse> mockController = getMockController();
		
		final DecryptPaymentDataRequest mockRequest = factory.createDecryptPaymentDataRequest();
		mockRequest.setRefId(refId);
		
		final DecryptPaymentDataResponse   mockResponse = factory.createDecryptPaymentDataResponse();

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		DecryptPaymentDataResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertEquals(MessageTypeEnum.OK, mockController.getResultCode());
		Assert.assertEquals(refId, controllerResponse.getRefId());
	}
}

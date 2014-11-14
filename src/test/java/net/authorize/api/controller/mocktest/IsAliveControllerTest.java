package net.authorize.api.controller.mocktest;

import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IsAliveControllerTest extends ApiCoreTestBase {
	
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
	public void mockIsAliveControllerTest()
	{
		//NO is AliveRequest...
		/*
		//define all mocked objects as final
		final IApiOperation<IsAliveRequest, IsAliveResponse> mockController = getMockController();
		
		final IsAliveRequest mockRequest = factory.createIsAliveRequest();
		mockRequest.setRefId(refId);
		
		final IsAliveResponse   mockResponse = factory.createIsAliveResponse();

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		IsAliveResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getYYY());
		logger.info(String.format("IsAlive: Details:%s", controllerResponse.getYYY()));
		*/
	}
}

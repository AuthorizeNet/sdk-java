package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ArrayOfNumericString;
import net.authorize.api.contract.v1.GetCustomerProfileIdsRequest;
import net.authorize.api.contract.v1.GetCustomerProfileIdsResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetCustomerProfileIdsControllerTest extends ApiCoreTestBase {
	
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
	public void mockGetCustomerProfileIdsControllerTest()
	{
		ArrayOfNumericString arrayOfIds = factory.createArrayOfNumericString();
		List<String> numericStrings = arrayOfIds.getNumericString();
		numericStrings.add(counterStr);
		
		//define all mocked objects as final
		final IApiOperation<GetCustomerProfileIdsRequest, GetCustomerProfileIdsResponse> mockController = getMockController();
		
		final GetCustomerProfileIdsRequest mockRequest = factory.createGetCustomerProfileIdsRequest();
		mockRequest.setRefId(refId);
		
		final GetCustomerProfileIdsResponse   mockResponse = factory.createGetCustomerProfileIdsResponse();
		mockResponse.setIds( arrayOfIds);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		GetCustomerProfileIdsResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getIds());
		Assert.assertNotNull(controllerResponse.getIds().getNumericString());
		logger.info(String.format("GetCustomerProfileIds: Details:%s", controllerResponse.getIds().getNumericString()));
	}
}

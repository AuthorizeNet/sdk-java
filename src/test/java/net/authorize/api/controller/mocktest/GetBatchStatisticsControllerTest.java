package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.BatchDetailsType;
import net.authorize.api.contract.v1.GetBatchStatisticsRequest;
import net.authorize.api.contract.v1.GetBatchStatisticsResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetBatchStatisticsControllerTest extends ApiCoreTestBase {
	
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
	public void mockGetBatchStatisticsControllerTest()
	{
		BatchDetailsType batchDetails = factory.createBatchDetailsType();
		batchDetails.setBatchId(counterStr);
		
		//define all mocked objects as final
		final IApiOperation<GetBatchStatisticsRequest, GetBatchStatisticsResponse> mockController = getMockController();
		
		final GetBatchStatisticsRequest mockRequest = factory.createGetBatchStatisticsRequest();
		mockRequest.setRefId(refId);
		
		final GetBatchStatisticsResponse   mockResponse = factory.createGetBatchStatisticsResponse();
		mockResponse.setBatch(batchDetails);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		GetBatchStatisticsResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getBatch());
		Assert.assertNotNull(controllerResponse.getBatch().getBatchId());
		logger.info(String.format("GetBatchStatistics: Details:%s", controllerResponse.getBatch().getBatchId()));
	}
}

package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ArrayOfBatchDetailsType;
import net.authorize.api.contract.v1.BatchDetailsType;
import net.authorize.api.contract.v1.GetSettledBatchListRequest;
import net.authorize.api.contract.v1.GetSettledBatchListResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetSettledBatchListControllerTest extends ApiCoreTestBase {
	
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
	public void mockGetSettledBatchListControllerTest()
	{
		BatchDetailsType aBatch = factory.createBatchDetailsType();
		aBatch.setBatchId(counterStr);
		ArrayOfBatchDetailsType batchDetails = factory.createArrayOfBatchDetailsType();
		List<BatchDetailsType> batchList = batchDetails.getBatch();
		batchList.add(aBatch);		

		//define all mocked objects as final
		final IApiOperation<GetSettledBatchListRequest, GetSettledBatchListResponse> mockController = getMockController();
		
		final GetSettledBatchListRequest mockRequest = factory.createGetSettledBatchListRequest();
		mockRequest.setRefId(refId);
		
		final GetSettledBatchListResponse   mockResponse = factory.createGetSettledBatchListResponse();
		mockResponse.setBatchList(batchDetails);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		GetSettledBatchListResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getBatchList());
		Assert.assertNotNull(controllerResponse.getBatchList().getBatch());
		Assert.assertNotNull(controllerResponse.getBatchList().getBatch());
		logger.info(String.format("GetSettledBatchList: Details:%s", controllerResponse.getBatchList().getBatch()));
	}
}

package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.GetTransactionDetailsRequest;
import net.authorize.api.contract.v1.GetTransactionDetailsResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.TransactionDetailsType;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetTransactionDetailsControllerTest extends ApiCoreTestBase {
	
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
	public void mockGetTransactionDetailsControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<GetTransactionDetailsRequest, GetTransactionDetailsResponse> mockController = getMockController();
		
		final GetTransactionDetailsRequest mockRequest = factory.createGetTransactionDetailsRequest();
		mockRequest.setRefId(refId);
		
		TransactionDetailsType transactionDetail = factory.createTransactionDetailsType();
		transactionDetail.setTransId(counterStr);
		
		final GetTransactionDetailsResponse   mockResponse = factory.createGetTransactionDetailsResponse();
		mockResponse.setTransaction(transactionDetail);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		GetTransactionDetailsResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getTransaction());
		Assert.assertNotNull(controllerResponse.getTransaction().getTransId());
		logger.info(String.format("GetTransactionDetails: Details:%s", controllerResponse.getTransaction().getTransId()));
	}
}

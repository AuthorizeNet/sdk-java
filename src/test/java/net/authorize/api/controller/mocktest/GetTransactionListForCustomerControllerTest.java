package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ArrayOfTransactionSummaryType;
import net.authorize.api.contract.v1.GetTransactionListForCustomerRequest;
import net.authorize.api.contract.v1.GetTransactionListResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.TransactionSummaryType;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetTransactionListForCustomerControllerTest extends ApiCoreTestBase {
	
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
	public void mockGetTransactionListForCustomerControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<GetTransactionListForCustomerRequest, GetTransactionListResponse> mockController = getMockController();
		
		final GetTransactionListForCustomerRequest mockRequest = factory.createGetTransactionListForCustomerRequest();
		mockRequest.setRefId(refId);
		
		TransactionSummaryType transactionSummary = factory.createTransactionSummaryType();
		transactionSummary.setTransId(counterStr);
		ArrayOfTransactionSummaryType transactionsArray = factory.createArrayOfTransactionSummaryType();
		List<TransactionSummaryType> transactionsList = transactionsArray.getTransaction();
		transactionsList.add(transactionSummary);
		
		final GetTransactionListResponse   mockResponse = factory.createGetTransactionListResponse();
		mockResponse.setTransactions(transactionsArray);
		
		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		GetTransactionListResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getTransactions());
		Assert.assertNotNull(controllerResponse.getTransactions().getTransaction());
		logger.info(String.format("GetTransactionListForCustomer: Details:%s", controllerResponse.getTransactions().getTransaction()));
	}
}

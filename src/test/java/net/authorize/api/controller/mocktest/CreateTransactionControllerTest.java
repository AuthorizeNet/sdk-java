package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateTransactionControllerTest extends ApiCoreTestBase {
	
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
	public void mockCreateTransactionControllerTest()
	{
		TransactionResponse trxResponse = factory.createTransactionResponse();
		trxResponse.setTransId(counterStr);
		
		//define all mocked objects as final
		final IApiOperation<CreateTransactionRequest, CreateTransactionResponse> mockController = getMockController();
		
		final CreateTransactionRequest mockRequest = factory.createCreateTransactionRequest();
		mockRequest.setRefId(refId);
		
		final CreateTransactionResponse   mockResponse = factory.createCreateTransactionResponse();
		mockResponse.setTransactionResponse(trxResponse);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		CreateTransactionResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getTransactionResponse());
		Assert.assertNotNull(controllerResponse.getTransactionResponse().getTransId());
		logger.info(String.format("CreateTransaction: Details:%s", controllerResponse.getTransactionResponse().getTransId()));
	}
}

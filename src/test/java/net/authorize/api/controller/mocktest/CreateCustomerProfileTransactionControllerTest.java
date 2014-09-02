package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateCustomerProfileTransactionRequest;
import net.authorize.api.contract.v1.CreateCustomerProfileTransactionResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateCustomerProfileTransactionControllerTest extends ApiCoreTestBase {
	
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
	public void mockCreateCustomerProfileTransactionControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<CreateCustomerProfileTransactionRequest, CreateCustomerProfileTransactionResponse> mockController = getMockController();
		
		final CreateCustomerProfileTransactionRequest mockRequest = factory.createCreateCustomerProfileTransactionRequest();
		mockRequest.setRefId(refId);
		
		TransactionResponse transactionResponse = factory.createTransactionResponse();
		transactionResponse.setTransId(counterStr);
		final CreateCustomerProfileTransactionResponse   mockResponse = factory.createCreateCustomerProfileTransactionResponse();
		mockResponse.setTransactionResponse(transactionResponse);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		CreateCustomerProfileTransactionResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getTransactionResponse());
		Assert.assertNotNull(controllerResponse.getTransactionResponse().getTransId());
		logger.info(String.format("CreateCustomerProfileTransaction: TransId:%s", controllerResponse.getTransactionResponse().getTransId()));
	}
}

package net.authorize.api.controller.mocktest;

import net.authorize.api.controller.test.ApiCoreTestBase;

/*
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
*/
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TransactionControllerTest extends ApiCoreTestBase {
	
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
	public void mockTransactionControllerTest()
	{
		//NOT NEEDED as this is contained in createTransaction
		/*
		//define all mocked objects as final
		final IApiOperation<TransactionRequestType, TransactionResponse> mockController = getMockController();
		
		final TransactionRequestType mockRequest = factory.createTransactionRequestType();
		//mockRequest.setRefId(refId);
		
		final TransactionResponse   mockResponse = factory.createTransactionResponse();

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		TransactionResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getTransId());
		logger.info(String.format("Transaction: Details:%s", controllerResponse.getTransId()));
		*/
	}
}

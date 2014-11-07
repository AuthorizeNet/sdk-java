package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateCustomerProfileFromTransactionRequest;
import net.authorize.api.contract.v1.CreateCustomerProfileResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateProfileFromTransactionConrollerTest extends ApiCoreTestBase {
	
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
	public void mockCreateProfileFromTransactionConrollerTest()
	{
		//define all mocked objects as final
		final IApiOperation<CreateCustomerProfileFromTransactionRequest, CreateCustomerProfileResponse> mockController = 
				getMockController();
		
		final CreateCustomerProfileFromTransactionRequest mockRequest = 
				factory.createCreateCustomerProfileFromTransactionRequest();
		mockRequest.setRefId(refId);
		
		
		final CreateCustomerProfileResponse  mockResponse = factory.createCreateCustomerProfileResponse();
        mockResponse.setCustomerProfileId("123");
        
		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		mockController.execute();
		CreateCustomerProfileResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertEquals(mockResponse.getCustomerProfileId(),controllerResponse.getCustomerProfileId());
		logger.info(String.format("CreateProfileFromTransactionConroller: Details:%s", controllerResponse.getCustomerProfileId()));
	}
}

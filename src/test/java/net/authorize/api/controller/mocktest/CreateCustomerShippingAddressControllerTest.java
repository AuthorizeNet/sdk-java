package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateCustomerShippingAddressRequest;
import net.authorize.api.contract.v1.CreateCustomerShippingAddressResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateCustomerShippingAddressControllerTest extends ApiCoreTestBase {
	
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
	public void mockCreateCustomerShippingAddressControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<CreateCustomerShippingAddressRequest, CreateCustomerShippingAddressResponse> mockController = getMockController();
		
		final CreateCustomerShippingAddressRequest mockRequest = factory.createCreateCustomerShippingAddressRequest();
		mockRequest.setRefId(refId);
		
		final CreateCustomerShippingAddressResponse   mockResponse = factory.createCreateCustomerShippingAddressResponse();
		mockResponse.setCustomerAddressId(counterStr);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		CreateCustomerShippingAddressResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getCustomerAddressId());
		logger.info(String.format("CreateCustomerShippingAddress: AddressId:%s", controllerResponse.getCustomerAddressId()));
	}
}

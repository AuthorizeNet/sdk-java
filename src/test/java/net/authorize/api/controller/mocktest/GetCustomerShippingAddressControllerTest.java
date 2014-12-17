package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CustomerAddressExType;
import net.authorize.api.contract.v1.GetCustomerShippingAddressRequest;
import net.authorize.api.contract.v1.GetCustomerShippingAddressResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetCustomerShippingAddressControllerTest extends ApiCoreTestBase {
	
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
	public void mockGetCustomerShippingAddressControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<GetCustomerShippingAddressRequest, GetCustomerShippingAddressResponse> mockController = getMockController();
		
		final GetCustomerShippingAddressRequest mockRequest = factory.createGetCustomerShippingAddressRequest();
		mockRequest.setRefId(refId);
		
		CustomerAddressExType address = factory.createCustomerAddressExType();
		address.setCity(counterStr);
		
		final GetCustomerShippingAddressResponse   mockResponse = factory.createGetCustomerShippingAddressResponse();
		mockResponse.setAddress(address);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		GetCustomerShippingAddressResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getAddress());
	
		logger.info(String.format("GetCustomerShippingAddress: Details:%s", controllerResponse.getAddress().getCity()));
	}
}

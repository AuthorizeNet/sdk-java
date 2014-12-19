package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.MobileDeviceLoginRequest;
import net.authorize.api.contract.v1.MobileDeviceLoginResponse;
import net.authorize.api.contract.v1.TransRetailInfoType;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MobileDeviceLoginControllerTest extends ApiCoreTestBase {
	
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
	public void mockMobileDeviceLoginControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<MobileDeviceLoginRequest, MobileDeviceLoginResponse> mockController = getMockController();
		
		final MobileDeviceLoginRequest mockRequest = factory.createMobileDeviceLoginRequest();
		mockRequest.setRefId(refId);
		
		TransRetailInfoType transRetail = factory.createTransRetailInfoType();
		transRetail.setDeviceType(counterStr);
		
		final MobileDeviceLoginResponse   mockResponse = factory.createMobileDeviceLoginResponse();
		mockResponse.setMerchantAccount(transRetail);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		MobileDeviceLoginResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getMerchantAccount());
		Assert.assertNotNull(controllerResponse.getMerchantAccount().getDeviceType());
		logger.info(String.format("MobileDeviceLogin: Details:%s", controllerResponse.getMerchantAccount().getDeviceType()));
	}
}

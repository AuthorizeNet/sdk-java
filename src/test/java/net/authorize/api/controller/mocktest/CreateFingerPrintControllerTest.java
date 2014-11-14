package net.authorize.api.controller.mocktest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateFingerPrintRequest;
import net.authorize.api.contract.v1.CreateFingerPrintResponse;
import net.authorize.api.contract.v1.FingerPrintSupportInformationType;
import net.authorize.api.contract.v1.FingerPrintType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateFingerPrintControllerTest extends ApiCoreTestBase {
	
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
	public void mockCreateFingerPrintControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<CreateFingerPrintRequest, CreateFingerPrintResponse> mockController = getMockController();
		
		FingerPrintSupportInformationType supportInformationType = factory.createFingerPrintSupportInformationType();
		supportInformationType.setAmount(new BigDecimal(counter));
		supportInformationType.setCurrencyCode("USD");
		supportInformationType.setSequence("1");
		supportInformationType.setTimestamp("12:00:00");
		
		final CreateFingerPrintRequest mockRequest = factory.createCreateFingerPrintRequest();
		mockRequest.setRefId(refId);
		mockRequest.setSupportInformation(supportInformationType);
		
		FingerPrintType fingerPrintType = factory.createFingerPrintType();
		fingerPrintType.setSequence(supportInformationType.getSequence());
		fingerPrintType.setTimestamp(supportInformationType.getTimestamp());
		
		final CreateFingerPrintResponse   mockResponse = factory.createCreateFingerPrintResponse();
		mockResponse.setFingerPrint(fingerPrintType);
		mockResponse.setSupportInformation(supportInformationType);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		CreateFingerPrintResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getFingerPrint());
		logger.info(String.format("CreateFingerPrint: FingerPrint:%s", controllerResponse.getFingerPrint()));
	}
}

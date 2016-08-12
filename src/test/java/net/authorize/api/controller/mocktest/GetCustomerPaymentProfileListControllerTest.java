package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ArrayOfCustomerPaymentProfileListItemType;
import net.authorize.api.contract.v1.CustomerPaymentProfileListItemType;
import net.authorize.api.contract.v1.CustomerPaymentProfileOrderFieldEnum;
import net.authorize.api.contract.v1.CustomerPaymentProfileSearchTypeEnum;
import net.authorize.api.contract.v1.CustomerPaymentProfileSorting;
import net.authorize.api.contract.v1.GetCustomerPaymentProfileListRequest;
import net.authorize.api.contract.v1.GetCustomerPaymentProfileListResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.Paging;
import net.authorize.api.contract.v1.SubscriptionDetail;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

public class GetCustomerPaymentProfileListControllerTest extends ApiCoreTestBase {
	
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
	public void mockGetCustomerPaymentProfileListControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<GetCustomerPaymentProfileListRequest, GetCustomerPaymentProfileListResponse> mockController = getMockController();
		
		final GetCustomerPaymentProfileListRequest mockRequest = factory.createGetCustomerPaymentProfileListRequest();
		mockRequest.setRefId(refId);
		mockRequest.setSearchType(CustomerPaymentProfileSearchTypeEnum.CARDS_EXPIRING_IN_MONTH);
		
		Paging paging = new Paging();
		paging.setLimit(100);
		paging.setOffset(1);
		
		CustomerPaymentProfileSorting sorting = factory.createCustomerPaymentProfileSorting();
		sorting.setOrderBy(CustomerPaymentProfileOrderFieldEnum.ID);
		sorting.setOrderDescending(false);
		
		mockRequest.setPaging(paging);
		mockRequest.setSorting(sorting);
		
		final GetCustomerPaymentProfileListResponse   mockResponse = factory.createGetCustomerPaymentProfileListResponse();
		
		ArrayOfCustomerPaymentProfileListItemType profileListArray = factory.createArrayOfCustomerPaymentProfileListItemType();

		List<CustomerPaymentProfileListItemType> profileDetails = profileListArray.getPaymentProfile();
		profileDetails.add(new CustomerPaymentProfileListItemType());
		mockResponse.setPaymentProfiles(profileListArray);
		mockResponse.setTotalNumInResultSet(profileDetails.size());
		
		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		GetCustomerPaymentProfileListResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getPaymentProfiles());
		logger.info(String.format("GetCustomerPaymentProfileList: Count:%d, Details:%s", controllerResponse.getTotalNumInResultSet(), controllerResponse.getPaymentProfiles()));
	}
}

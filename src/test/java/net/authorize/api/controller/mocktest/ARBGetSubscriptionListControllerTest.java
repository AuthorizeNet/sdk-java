package net.authorize.api.controller.mocktest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ARBGetSubscriptionListOrderFieldEnum;
import net.authorize.api.contract.v1.ARBGetSubscriptionListRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionListResponse;
import net.authorize.api.contract.v1.ARBGetSubscriptionListSearchTypeEnum;
import net.authorize.api.contract.v1.ARBGetSubscriptionListSorting;
import net.authorize.api.contract.v1.ArrayOfSubscription;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.Paging;
import net.authorize.api.contract.v1.SubscriptionDetail;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ARBGetSubscriptionListControllerTest extends ApiCoreTestBase {
	
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
	public void mockARBGetSubscriptionListControllerTest()
	{
		//define all mocked objects as final
		final IApiOperation<ARBGetSubscriptionListRequest, ARBGetSubscriptionListResponse> mockController = getMockController();
		
		final ARBGetSubscriptionListRequest mockRequest = factory.createARBGetSubscriptionListRequest();
		mockRequest.setRefId(refId);
		mockRequest.setSearchType(ARBGetSubscriptionListSearchTypeEnum.SUBSCRIPTION_ACTIVE);
		Paging paging = new Paging();
		paging.setLimit(100);
		paging.setOffset(1);
		ARBGetSubscriptionListSorting sorting = factory.createARBGetSubscriptionListSorting();
		sorting.setOrderBy(ARBGetSubscriptionListOrderFieldEnum.ID);
		sorting.setOrderDescending(false);
		mockRequest.setPaging(paging);
		mockRequest.setSorting(sorting);
		
		final ARBGetSubscriptionListResponse   mockResponse = factory.createARBGetSubscriptionListResponse();
		ArrayOfSubscription subscriptionArray = factory.createArrayOfSubscription();
		List<SubscriptionDetail> subscriptionDetail = subscriptionArray.getSubscriptionDetail();
		subscriptionDetail.add(new SubscriptionDetail());
		mockResponse.setSubscriptionDetails(subscriptionArray );
		mockResponse.setTotalNumInResultSet(subscriptionDetail.size());

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		ARBGetSubscriptionListResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getSubscriptionDetails());
		logger.info(String.format("ARBGetSubscriptionList: Count:%d, Details:%s", controllerResponse.getTotalNumInResultSet(), controllerResponse.getSubscriptionDetails()));
	}
}

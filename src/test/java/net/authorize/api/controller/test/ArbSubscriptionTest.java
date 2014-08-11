package net.authorize.api.controller.test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ARBCancelSubscriptionRequest;
import net.authorize.api.contract.v1.ARBCancelSubscriptionResponse;
import net.authorize.api.contract.v1.ARBCreateSubscriptionRequest;
import net.authorize.api.contract.v1.ARBCreateSubscriptionResponse;
import net.authorize.api.contract.v1.ARBGetSubscriptionListOrderFieldEnum;
import net.authorize.api.contract.v1.ARBGetSubscriptionListRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionListResponse;
import net.authorize.api.contract.v1.ARBGetSubscriptionListSearchTypeEnum;
import net.authorize.api.contract.v1.ARBGetSubscriptionListSorting;
import net.authorize.api.contract.v1.ARBGetSubscriptionStatusRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionStatusResponse;
import net.authorize.api.contract.v1.ARBSubscriptionStatusEnum;
import net.authorize.api.contract.v1.ARBUpdateSubscriptionRequest;
import net.authorize.api.contract.v1.ARBUpdateSubscriptionResponse;
import net.authorize.api.contract.v1.ArrayOfSubscription;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.Paging;
import net.authorize.api.contract.v1.SubscriptionDetail;
import net.authorize.api.controller.ARBCancelSubscriptionController;
import net.authorize.api.controller.ARBCreateSubscriptionController;
import net.authorize.api.controller.ARBGetSubscriptionListController;
import net.authorize.api.controller.ARBGetSubscriptionStatusController;
import net.authorize.api.controller.base.ApiOperationBase;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.util.LogHelper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArbSubscriptionTest extends ApiCoreTestBase {
	
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
	public void testGetSubscriptionList() throws DatatypeConfigurationException {

		//String subscriptionId = "42";

		String subscriptionId = createSubscription(cnpMerchantAuthenticationType);
		ARBSubscriptionStatusEnum newStatus = getSubscription(cnpMerchantAuthenticationType, subscriptionId);
		Assert.assertEquals(ARBSubscriptionStatusEnum.ACTIVE, newStatus);

		LogHelper.info(logger, "Getting Subscription List for SubscriptionId: %s", subscriptionId);

		ARBGetSubscriptionListRequest listRequest = setupSubscriptionListRequest(cnpMerchantAuthenticationType);
		ARBGetSubscriptionListResponse listResponse = executeTestRequestWithSuccess(listRequest, ARBGetSubscriptionListController.class, environment);

		LogHelper.info( logger, "Subscription Count: %d", listResponse.getTotalNumInResultSet());		
		Assert.assertTrue( 0 < listResponse.getTotalNumInResultSet());
		ArrayOfSubscription subscriptionsArray = listResponse.getSubscriptionDetails();
		Assert.assertNotNull( subscriptionsArray);

		boolean found = false;
		int subsId = Integer.parseInt(subscriptionId);
		
		for( SubscriptionDetail aSubscription : subscriptionsArray.getSubscriptionDetail()) {
			Assert.assertTrue( 0 < aSubscription.getId());
			LogHelper.info( logger, "Subscription Id: %s, Status:%s, PaymentMethod: %s, Amount: %s, Account:%s", 
					aSubscription.getId(), aSubscription.getStatus(), aSubscription.getPaymentMethod(), aSubscription.getAmount(), aSubscription.getAccountNumber());
			if ( subsId == aSubscription.getId()) { found = true;}
		}

		cancelSubscription(cnpMerchantAuthenticationType, subscriptionId);
		Assert.assertTrue(found);
		//validate the status of subscription to make sure it is in-activated
		ARBSubscriptionStatusEnum cancelStatus = getSubscription(cnpMerchantAuthenticationType, subscriptionId);
		Assert.assertEquals(ARBSubscriptionStatusEnum.CANCELED, cancelStatus);
	}


	@Test
	public void testSubscription() throws Exception {
		//cache the result
		String subscriptionId = createSubscription(cnpMerchantAuthenticationType);
		getSubscription(cnpMerchantAuthenticationType, subscriptionId);
		cancelSubscription(cnpMerchantAuthenticationType, subscriptionId);
	}

	private ARBGetSubscriptionListRequest setupSubscriptionListRequest(MerchantAuthenticationType merchantAuthentication) {
		
		ARBGetSubscriptionListSorting sorting = new ARBGetSubscriptionListSorting();
		sorting.setOrderDescending(true);
		sorting.setOrderBy(ARBGetSubscriptionListOrderFieldEnum.CREATE_TIME_STAMP_UTC);
		Paging paging = new Paging();
		paging.setLimit(100);
		paging.setOffset(1);
		
		ARBGetSubscriptionListRequest listRequest = new ARBGetSubscriptionListRequest();
		listRequest.setMerchantAuthentication(merchantAuthentication);
		listRequest.setRefId(refId);
		
		listRequest.setSearchType(ARBGetSubscriptionListSearchTypeEnum.SUBSCRIPTION_ACTIVE);
		
		listRequest.setSorting(sorting);
		listRequest.setPaging(paging);
		
		return listRequest;
	}

	private void cancelSubscription(MerchantAuthenticationType merchantAuthentication, String subscriptionId) {
		//cancel the subscription
		ARBCancelSubscriptionRequest cancelRequest = new ARBCancelSubscriptionRequest();
		cancelRequest.setMerchantAuthentication(merchantAuthentication);
		cancelRequest.setRefId(refId);
		cancelRequest.setSubscriptionId(subscriptionId);
		ARBCancelSubscriptionResponse cancelResponse = executeTestRequestWithSuccess(cancelRequest, ARBCancelSubscriptionController.class, environment);
		Assert.assertNotNull(cancelResponse.getMessages());
		logger.info(String.format("Subscription Cancelled %s", subscriptionId));
	}

	private ARBSubscriptionStatusEnum getSubscription(MerchantAuthenticationType merchantAuthentication, String subscriptionId) {
		//get a subscription
		ARBGetSubscriptionStatusRequest getRequest = new ARBGetSubscriptionStatusRequest();
		getRequest.setMerchantAuthentication(merchantAuthentication);
		getRequest.setRefId(refId);
		getRequest.setSubscriptionId(subscriptionId);
		ARBGetSubscriptionStatusResponse getResponse = executeTestRequestWithSuccess(getRequest, ARBGetSubscriptionStatusController.class, environment);
		Assert.assertNotNull(getResponse.getStatus());
		logger.info(String.format("Subscription Status: %s", getResponse.getStatus()));
		return getResponse.getStatus();
	}

	private String createSubscription( MerchantAuthenticationType merchantAuthentication) {
		//create a new subscription
		ARBCreateSubscriptionRequest createRequest = new ARBCreateSubscriptionRequest();
		createRequest.setMerchantAuthentication(merchantAuthentication);
		createRequest.setRefId(refId);
		createRequest.setSubscription(arbSubscriptionOne);
		ARBCreateSubscriptionResponse createResponse = executeTestRequestWithSuccess(createRequest, ARBCreateSubscriptionController.class, environment);
		Assert.assertNotNull(createResponse.getSubscriptionId());
		logger.info(String.format("Created Subscription: %s", createResponse.getSubscriptionId()));

		return createResponse.getSubscriptionId();
	}
	
	@Test
	public void sampleGetSubscriptionList() throws DatatypeConfigurationException {

		//Common code to set for all requests
		ApiOperationBase.setEnvironment(environment);
		ApiOperationBase.setMerchantAuthentication(cnpMerchantAuthenticationType);
		
		//create
		ARBCreateSubscriptionRequest createRequest = new ARBCreateSubscriptionRequest();
		createRequest.setRefId(refId);
		createRequest.setSubscription(arbSubscriptionOne);
		ARBCreateSubscriptionController createController = new ARBCreateSubscriptionController(createRequest);		
		//separate execute and getResponse calls
		createController.execute();
		ARBCreateSubscriptionResponse createResponse = createController.getApiResponse();
		
		Assert.assertNotNull(createResponse.getSubscriptionId());
		logger.info(String.format("Created Subscription: %s", createResponse.getSubscriptionId()));
		String subscriptionId = createResponse.getSubscriptionId();

		//get
		ARBGetSubscriptionStatusRequest getRequest = new ARBGetSubscriptionStatusRequest();
		getRequest.setRefId(refId);
		getRequest.setSubscriptionId(subscriptionId);
		ARBGetSubscriptionStatusController statusController = new ARBGetSubscriptionStatusController(getRequest);		
		//execute and getResponse calls together
		ARBGetSubscriptionStatusResponse getResponse = statusController.executeWithApiResponse();
		Assert.assertNotNull(getResponse.getStatus());
		logger.info(String.format("Subscription Status: %s", getResponse.getStatus()));
		ARBSubscriptionStatusEnum newStatus = getResponse.getStatus();
		Assert.assertEquals(ARBSubscriptionStatusEnum.ACTIVE, newStatus);
		LogHelper.info(logger, "Getting Subscription List for SubscriptionId: %s", subscriptionId);

		//get list
		ARBGetSubscriptionListSorting sorting = new ARBGetSubscriptionListSorting();
		sorting.setOrderDescending(true);
		sorting.setOrderBy(ARBGetSubscriptionListOrderFieldEnum.CREATE_TIME_STAMP_UTC);
		Paging paging = new Paging();
		paging.setLimit(100);
		paging.setOffset(1);
		ARBGetSubscriptionListRequest listRequest = new ARBGetSubscriptionListRequest();
		listRequest.setRefId(refId);
		listRequest.setSearchType(ARBGetSubscriptionListSearchTypeEnum.SUBSCRIPTION_ACTIVE);
		listRequest.setSorting(sorting);
		listRequest.setPaging(paging);
		ARBGetSubscriptionListController listController = new ARBGetSubscriptionListController(listRequest);
		ARBGetSubscriptionListResponse listResponse = listController.executeWithApiResponse();
		LogHelper.info( logger, "Subscription Count: %d", listResponse.getTotalNumInResultSet());		
		Assert.assertTrue( 0 < listResponse.getTotalNumInResultSet());

		//cancel
		ARBCancelSubscriptionRequest cancelRequest = new ARBCancelSubscriptionRequest();
		cancelRequest.setMerchantAuthentication(cnpMerchantAuthenticationType);
		cancelRequest.setRefId(refId);
		cancelRequest.setSubscriptionId(subscriptionId);
		//explicitly setting up the merchant id and environment 
		ARBCancelSubscriptionResponse cancelResponse = executeTestRequestWithSuccess(cancelRequest, ARBCancelSubscriptionController.class, environment);
		Assert.assertNotNull(cancelResponse.getMessages());
		logger.info(String.format("Subscription Cancelled %s", subscriptionId));

		//validation of list
		ArrayOfSubscription subscriptionsArray = listResponse.getSubscriptionDetails();
		Assert.assertNotNull( subscriptionsArray);
		boolean found = false;
		int subsId = Integer.parseInt(subscriptionId);
		for( SubscriptionDetail aSubscription : subscriptionsArray.getSubscriptionDetail()) {
			Assert.assertTrue( 0 < aSubscription.getId());
			LogHelper.info( logger, "Subscription Id: %s, Status:%s, PaymentMethod: %s, Amount: %s, Account:%s", 
					aSubscription.getId(), aSubscription.getStatus(), aSubscription.getPaymentMethod(), aSubscription.getAmount(), aSubscription.getAccountNumber());
			if ( subsId == aSubscription.getId()) { found = true;}
		}
		Assert.assertTrue(found);
	}
	
	@Test
	public void mockARBCreateSubscriptionTest()
	{
		//define all mocked objects as final
		final IApiOperation<ARBCreateSubscriptionRequest, ARBCreateSubscriptionResponse> mockController = getMockController();
		
		final ARBCreateSubscriptionRequest mockRequest = factory.createARBCreateSubscriptionRequest();
		mockRequest.setRefId(refId);
		mockRequest.setSubscription(arbSubscriptionOne);
		
		final ARBCreateSubscriptionResponse   mockResponse = factory.createARBCreateSubscriptionResponse();
		mockResponse.setSubscriptionId( "1234");

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		ARBCreateSubscriptionResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getSubscriptionId());
		logger.info(String.format("Created Subscription: %s", controllerResponse.getSubscriptionId()));
	}
	
	@Test
	public void mockARBCancelSubscriptionTest()
	{
		//define all mocked objects as final
		final IApiOperation<ARBCancelSubscriptionRequest, ARBCancelSubscriptionResponse> mockController = getMockController();
		
		final ARBCancelSubscriptionRequest mockRequest = factory.createARBCancelSubscriptionRequest();
		mockRequest.setRefId(refId);
		mockRequest.setSubscriptionId( "1234");
		
		final ARBCancelSubscriptionResponse   mockResponse = factory.createARBCancelSubscriptionResponse();

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		ARBCancelSubscriptionResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
	}
	
	@Test
	public void mockARBUpdateSubscriptionTest()
	{
		//define all mocked objects as final
		final IApiOperation<ARBUpdateSubscriptionRequest, ARBUpdateSubscriptionResponse> mockController = getMockController();
		
		final ARBUpdateSubscriptionRequest mockRequest = factory.createARBUpdateSubscriptionRequest();
		mockRequest.setRefId(refId);
		mockRequest.setSubscription(arbSubscriptionOne);
		mockRequest.setSubscriptionId( "1234");
		
		final ARBUpdateSubscriptionResponse   mockResponse = factory.createARBUpdateSubscriptionResponse();

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		ARBUpdateSubscriptionResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
	}
	
	@Test
	public void mockARBGetSubscriptionStatusTest()
	{
		//define all mocked objects as final
		final IApiOperation<ARBGetSubscriptionStatusRequest, ARBGetSubscriptionStatusResponse> mockController = getMockController();
		
		final ARBGetSubscriptionStatusRequest mockRequest = factory.createARBGetSubscriptionStatusRequest();
		mockRequest.setRefId(refId);
		mockRequest.setSubscriptionId( "1234");
		
		final ARBGetSubscriptionStatusResponse   mockResponse = factory.createARBGetSubscriptionStatusResponse();
		mockResponse.setStatus(  ARBSubscriptionStatusEnum.ACTIVE);

		final ANetApiResponse errorResponse = factory.createANetApiResponse();
		final List<String> results = new ArrayList<String>();
		final MessageTypeEnum messageTypeOk = MessageTypeEnum.OK;
		
		setMockControllerExpectations(mockController, mockRequest, mockResponse, errorResponse, results, messageTypeOk);
		//setMockControllerExpectations(mockController, mockResponse, null, null, null);
		mockController.execute();
		ARBGetSubscriptionStatusResponse controllerResponse = mockController.getApiResponse();
		
		Assert.assertNotNull(controllerResponse);
		Assert.assertNotNull(controllerResponse.getStatus());
		logger.info(String.format("ARBGetSubscriptionStatus: %s", controllerResponse.getStatus()));
	}

	@Test
	public void mockARBGetSubscriptionListTest()
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

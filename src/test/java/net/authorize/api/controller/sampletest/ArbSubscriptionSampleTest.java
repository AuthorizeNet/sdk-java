package net.authorize.api.controller.sampletest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import net.authorize.api.contract.v1.ARBCancelSubscriptionRequest;
import net.authorize.api.contract.v1.ARBCancelSubscriptionResponse;
import net.authorize.api.contract.v1.ARBCreateSubscriptionRequest;
import net.authorize.api.contract.v1.ARBCreateSubscriptionResponse;
import net.authorize.api.contract.v1.ARBGetSubscriptionListOrderFieldEnum;
import net.authorize.api.contract.v1.ARBGetSubscriptionListRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionListResponse;
import net.authorize.api.contract.v1.ARBGetSubscriptionListSearchTypeEnum;
import net.authorize.api.contract.v1.ARBGetSubscriptionListSorting;
import net.authorize.api.contract.v1.ARBGetSubscriptionRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionResponse;
import net.authorize.api.contract.v1.ARBGetSubscriptionStatusRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionStatusResponse;
import net.authorize.api.contract.v1.ARBSubscriptionMaskedType;
import net.authorize.api.contract.v1.ARBSubscriptionStatusEnum;
import net.authorize.api.contract.v1.ArrayOfSubscription;
import net.authorize.api.contract.v1.Paging;
import net.authorize.api.contract.v1.SubscriptionDetail;
import net.authorize.api.controller.ARBCancelSubscriptionController;
import net.authorize.api.controller.ARBCreateSubscriptionController;
import net.authorize.api.controller.ARBGetSubscriptionController;
import net.authorize.api.controller.ARBGetSubscriptionListController;
import net.authorize.api.controller.ARBGetSubscriptionStatusController;
import net.authorize.api.controller.base.ApiOperationBase;
import net.authorize.api.controller.test.ApiCoreTestBase;
import net.authorize.util.LogHelper;

public class ArbSubscriptionSampleTest extends ApiCoreTestBase {
	
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
	public void ARBGetSubscriptionSample() {

		//Common code to set for all requests
		ApiOperationBase.setEnvironment(environment);
		ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);
		
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

		try {
			//getsubscription
			LogHelper.info(logger, "Getting Subscription Information for SubscriptionId: %s", subscriptionId);
			
			ARBGetSubscriptionRequest getSubscriptionRequest = new ARBGetSubscriptionRequest();
			getSubscriptionRequest.setRefId(refId);
			getSubscriptionRequest.setSubscriptionId(subscriptionId);
			
			ARBGetSubscriptionController subscriptionController = new ARBGetSubscriptionController(getSubscriptionRequest);		
			//execute and getResponse calls together
			ARBGetSubscriptionResponse getSubscriptionResponse = subscriptionController.executeWithApiResponse();
			Assert.assertNotNull(getSubscriptionResponse.getSubscription());
			
			ARBSubscriptionMaskedType subscriptionInfo = getSubscriptionResponse.getSubscription();
			
			logger.info(String.format("Subscription Name: %s", subscriptionInfo.getName()));
			Assert.assertEquals(arbSubscriptionOne.getName(), subscriptionInfo.getName());
		} finally {
			// cancel
			ARBCancelSubscriptionRequest cancelRequest = new ARBCancelSubscriptionRequest();
			cancelRequest.setMerchantAuthentication(merchantAuthenticationType);
			cancelRequest.setRefId(refId);
			cancelRequest.setSubscriptionId(subscriptionId);
			// explicitly setting up the merchant id and environment
			ARBCancelSubscriptionResponse cancelResponse = executeTestRequestWithSuccess(
					cancelRequest, ARBCancelSubscriptionController.class,
					environment);
			Assert.assertNotNull(cancelResponse.getMessages());
			logger.info(String.format("Subscription Cancelled %s",
					subscriptionId));
		}
	}

	@Test
	public void subscriptionSamples() {

		//Common code to set for all requests
		ApiOperationBase.setEnvironment(environment);
		ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);
		
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

		try {
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
		
			int retryCount = 3;
			boolean found = false;
			do {
				// Pause for about 15 seconds, so that the created subscription
				// will be in the next service call.
				try {
					Thread.sleep(15000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ARBGetSubscriptionListController listController = new ARBGetSubscriptionListController(listRequest);
				ARBGetSubscriptionListResponse listResponse = listController.executeWithApiResponse();
				LogHelper.info( logger, "Subscription Count: %d", listResponse.getTotalNumInResultSet());		
				Assert.assertTrue( 0 < listResponse.getTotalNumInResultSet());

				//validation of list
				ArrayOfSubscription subscriptionsArray = listResponse.getSubscriptionDetails();
				Assert.assertNotNull( subscriptionsArray);

				int subsId = Integer.parseInt(subscriptionId);
				for( SubscriptionDetail aSubscription : subscriptionsArray.getSubscriptionDetail()) {
					Assert.assertTrue( 0 < aSubscription.getId());
					LogHelper.info( logger, "Subscription Id: %s, Status:%s, PaymentMethod: %s, Amount: %s, Account:%s", 
					aSubscription.getId(), aSubscription.getStatus(), aSubscription.getPaymentMethod(), aSubscription.getAmount(), aSubscription.getAccountNumber());
					if ( subsId == aSubscription.getId()) { found = true;}
				}
			} while (!found && --retryCount > 0);
			
			Assert.assertTrue("Retried " + retryCount
					+ " times, the subscription " + subscriptionId
					+ " not found in the subscription list.", found);
		} finally {
			// cancel
			ARBCancelSubscriptionRequest cancelRequest = new ARBCancelSubscriptionRequest();
			cancelRequest.setMerchantAuthentication(merchantAuthenticationType);
			cancelRequest.setRefId(refId);
			cancelRequest.setSubscriptionId(subscriptionId);
			// explicitly setting up the merchant id and environment
			ARBCancelSubscriptionResponse cancelResponse = executeTestRequestWithSuccess(
					cancelRequest, ARBCancelSubscriptionController.class,
					environment);
			Assert.assertNotNull(cancelResponse.getMessages());
			logger.info(String.format("Subscription Cancelled %s",
					subscriptionId));
		}
	}
}

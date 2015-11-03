package net.authorize.api.controller.test;

import javax.xml.datatype.DatatypeConfigurationException;

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
import net.authorize.api.contract.v1.ARBGetSubscriptionStatusRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionStatusResponse;
import net.authorize.api.contract.v1.ARBSubscriptionStatusEnum;
import net.authorize.api.contract.v1.ArrayOfSubscription;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.Paging;
import net.authorize.api.contract.v1.SubscriptionDetail;
import net.authorize.api.controller.ARBCancelSubscriptionController;
import net.authorize.api.controller.ARBCreateSubscriptionController;
import net.authorize.api.controller.ARBGetSubscriptionListController;
import net.authorize.api.controller.ARBGetSubscriptionStatusController;
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
		String subscriptionId = createSubscription(merchantAuthenticationType);
		try {
			ARBSubscriptionStatusEnum newStatus = getSubscription(merchantAuthenticationType, subscriptionId);
			Assert.assertEquals(ARBSubscriptionStatusEnum.ACTIVE, newStatus);

			LogHelper.info(logger, "Getting Subscription List for SubscriptionId: %s", subscriptionId);

			boolean found = false;
			int retryCount = 3;
			do {
				// Pause for about 15 seconds, so that the created subscription
				// will be in the next service call.
				try {
					Thread.sleep(15000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ARBGetSubscriptionListRequest listRequest = setupSubscriptionListRequest(merchantAuthenticationType);
				ARBGetSubscriptionListResponse listResponse = executeTestRequestWithSuccess(listRequest, ARBGetSubscriptionListController.class, environment);

				LogHelper.info( logger, "Subscription Count: %d", listResponse.getTotalNumInResultSet());		
				Assert.assertTrue( 0 < listResponse.getTotalNumInResultSet());
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
			cancelSubscription(merchantAuthenticationType, subscriptionId);
			//validate the status of subscription to make sure it is in-activated
			ARBSubscriptionStatusEnum cancelStatus = getSubscription(merchantAuthenticationType, subscriptionId);
			Assert.assertEquals(ARBSubscriptionStatusEnum.CANCELED, cancelStatus);
		}
	}

	@Test
	public void testSubscription() throws Exception {
		//cache the result
		String subscriptionId = createSubscription(merchantAuthenticationType);
		getSubscription(merchantAuthenticationType, subscriptionId);
		cancelSubscription(merchantAuthenticationType, subscriptionId);
		
	}
	
	
	/**
	 * @Zalak
	 * Repro and fix test for issue - ARBSubscriptionList SearchType of "cardExpiringThisMonth" doesn't work
	 */
	@Test
	public void ShouldReturnSubsciptionsWhenPagingNotPassedTest()
	{
		ARBGetSubscriptionListRequest getSubscriptionListRequest = new ARBGetSubscriptionListRequest();
		getSubscriptionListRequest.setSearchType(ARBGetSubscriptionListSearchTypeEnum.CARD_EXPIRING_THIS_MONTH);
		getSubscriptionListRequest.setMerchantAuthentication(merchantAuthenticationType);
		ARBGetSubscriptionListController nullController = new ARBGetSubscriptionListController(getSubscriptionListRequest);
		Assert.assertNotNull(nullController);
		ARBGetSubscriptionListResponse response = executeTestRequestWithSuccess(getSubscriptionListRequest, ARBGetSubscriptionListController.class, environment);
		Assert.assertNotNull(response);
		
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
	
	
}

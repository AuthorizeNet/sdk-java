package net.authorize.apicore.helper.test;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;

import junit.framework.Assert;
import net.authorize.Environment;
import net.authorize.apicore.contract.v1.ANetApiRequest;
import net.authorize.apicore.contract.v1.ANetApiResponse;
import net.authorize.apicore.contract.v1.ARBCancelSubscriptionRequest;
import net.authorize.apicore.contract.v1.ARBCancelSubscriptionResponse;
import net.authorize.apicore.contract.v1.ARBCreateSubscriptionRequest;
import net.authorize.apicore.contract.v1.ARBCreateSubscriptionResponse;
import net.authorize.apicore.contract.v1.ARBGetSubscriptionReportRequest;
import net.authorize.apicore.contract.v1.ARBGetSubscriptionReportResponse;
import net.authorize.apicore.contract.v1.ARBGetSubscriptionStatusRequest;
import net.authorize.apicore.contract.v1.ARBGetSubscriptionStatusResponse;
import net.authorize.apicore.contract.v1.ARBSubscriptionReportOrderFieldEnum;
import net.authorize.apicore.contract.v1.ARBSubscriptionReportSearchTypeEnum;
import net.authorize.apicore.contract.v1.ArrayOfSubscriptionInfo;
import net.authorize.apicore.contract.v1.MerchantAuthenticationType;
import net.authorize.apicore.contract.v1.MessageTypeEnum;
import net.authorize.apicore.contract.v1.SubscriptionInfo;
import net.authorize.apicore.controller.ARBCancelSubscriptionController;
import net.authorize.apicore.controller.ARBCreateSubscriptionController;
import net.authorize.apicore.controller.ARBGetSubscriptionReportController;
import net.authorize.apicore.controller.ARBGetSubscriptionStatusController;
import net.authorize.apicore.controller.base.ApiOperationBase;
import net.authorize.util.LogHelper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArbSubscription extends ApiCoreTestBase {
	
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
	public void testGetSubscriptionReport() throws DatatypeConfigurationException {

		String subscriptionId = createSubscription(cnpMerchantAuthenticationType);
		getSubscription(cnpMerchantAuthenticationType, subscriptionId);
		
		LogHelper.info(logger, "Getting Subscription report for SubscriptionId: %s", subscriptionId);

		//TODO figure out how to get merchant Id dynamically
		final int merchantId = 41235;
		final long userId = 10;
		
		ARBGetSubscriptionReportRequest reportRequest = setupSubscriptionReportRequest(cnpMerchantAuthenticationType, userId, merchantId);
		ARBGetSubscriptionReportResponse reportResponse = executeTestRequestWithSuccess(reportRequest, ARBGetSubscriptionReportController.class, environment);

		LogHelper.info( logger, "Subscription Count: %d", reportResponse.getTotalNumInResultSet());		
		Assert.assertTrue( 0 < reportResponse.getTotalNumInResultSet());
		ArrayOfSubscriptionInfo subscriptionInfoArray = reportResponse.getSubscriptionInfoList();
		Assert.assertNotNull( subscriptionInfoArray);

		boolean found = false;
		int subsId = Integer.parseInt(subscriptionId);
		
		for( SubscriptionInfo si : subscriptionInfoArray.getSubscriptionInfo()) {
			Assert.assertTrue( 0 < si.getId());
			LogHelper.info( logger, "SubscriptionIds: %s", si.getId());
			if ( subsId == si.getId()) { found = true;}
		}
		cancelSubscription(cnpMerchantAuthenticationType, subscriptionId);
		Assert.assertTrue(found);
		//can validate the status of subscription to make sure it is in-activated 
	}


	@Test
	public void testSubscription() throws Exception {
		//cache the result
		String subscriptionId = createSubscription(cnpMerchantAuthenticationType);
		getSubscription(cnpMerchantAuthenticationType, subscriptionId);
		cancelSubscription(cnpMerchantAuthenticationType, subscriptionId);
	}

	private ARBGetSubscriptionReportRequest setupSubscriptionReportRequest(MerchantAuthenticationType merchantAuthentication, long userId, int merchantId) {
		ARBGetSubscriptionReportRequest reportRequest = new ARBGetSubscriptionReportRequest();
		reportRequest.setMerchantAuthentication(merchantAuthentication);
		reportRequest.setRefId(refId);
		reportRequest.setUserId(userId);
		reportRequest.setMerchantId(merchantId);
		reportRequest.setExpDateHash(null);
		
		reportRequest.setStartReportDate(datatypeFactory.newXMLGregorianCalendar(new GregorianCalendar(2010, 01, 01)));
		reportRequest.setEndReportDate(datatypeFactory.newXMLGregorianCalendar(new GregorianCalendar()));
		reportRequest.setSearchType(ARBSubscriptionReportSearchTypeEnum.ACTIVE_CARD);
		reportRequest.setOrderBy(ARBSubscriptionReportOrderFieldEnum.CREATE_TIME);
		reportRequest.setOrderDescending(false);
		reportRequest.setPageNumberBeingRetrieved(1);
		reportRequest.setNumItemsInResultSet(100);
		return reportRequest;
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

	private void getSubscription(MerchantAuthenticationType merchantAuthentication, String subscriptionId) {
		//get a subscription
		ARBGetSubscriptionStatusRequest getRequest = new ARBGetSubscriptionStatusRequest();
		getRequest.setMerchantAuthentication(merchantAuthentication);
		getRequest.setRefId(refId);
		getRequest.setSubscriptionId(subscriptionId);
		ARBGetSubscriptionStatusResponse getResponse = executeTestRequestWithSuccess(getRequest, ARBGetSubscriptionStatusController.class, environment);
		Assert.assertNotNull(getResponse.getStatus());
		logger.info(String.format("Subscription Status: %s", getResponse.getStatus()));
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

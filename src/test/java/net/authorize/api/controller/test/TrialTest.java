package net.authorize.api.controller.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import net.authorize.api.contract.v1.GetTransactionDetailsRequest;
import net.authorize.api.contract.v1.GetTransactionDetailsResponse;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.TransactionDetailsType;
import net.authorize.api.controller.GetTransactionDetailsController;


public class TrialTest extends ApiCoreTestBase {
	
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

public void quicktrialtest() {
	String transactionId = "2236685252";
	TransactionDetailsType transactionDetailsType = getTransactionResponseCode(merchantAuthenticationType, transactionId);	
	
}




private TransactionDetailsType getTransactionResponseCode(MerchantAuthenticationType merchantAuthentication, String transId) {
	//get a subscription
	GetTransactionDetailsRequest getRequest = new GetTransactionDetailsRequest();
	getRequest.setMerchantAuthentication(merchantAuthentication);
	getRequest.setTransId(transId);
	GetTransactionDetailsResponse getResponse = executeTestRequestWithSuccess(getRequest, GetTransactionDetailsController.class, environment);
	Assert.assertNotNull(getResponse.getTransaction());
	logger.info(String.format("Response Code: %s", getResponse.getTransaction().getResponseCode()));
	return getResponse.getTransaction();
}
}

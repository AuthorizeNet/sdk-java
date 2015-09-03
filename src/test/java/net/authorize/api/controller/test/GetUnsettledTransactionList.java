package net.authorize.api.controller.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import junit.framework.Assert;

import net.authorize.api.contract.v1.ArrayOfBatchDetailsType;
import net.authorize.api.contract.v1.ArrayOfTransactionSummaryType;
import net.authorize.api.contract.v1.GetUnsettledTransactionListRequest;
import net.authorize.api.contract.v1.GetUnsettledTransactionListResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.MessagesType;
import net.authorize.api.controller.GetSettledBatchListController;
import net.authorize.api.controller.GetUnsettledTransactionListController;

public class GetUnsettledTransactionList extends ApiCoreTestBase{
	
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
	/*To run this test successfully you should have a valid transaction id 
	 */
	
	
	public void UnSettledTransactionList()
	{  
		MessageTypeEnum messagetypeenum = getUnSettledTransactionList();		
		Assert.assertEquals(MessageTypeEnum.OK,messagetypeenum);
	}
	
	private MessageTypeEnum getUnSettledTransactionList() {
		GetUnsettledTransactionListRequest getRequest = new GetUnsettledTransactionListRequest();
		getRequest.setMerchantAuthentication(merchantAuthenticationType);
		GetUnsettledTransactionListResponse getResponse = executeTestRequestWithSuccess(getRequest, GetUnsettledTransactionListController.class, environment);
		return getResponse.getMessages().getResultCode();
	}
}

package net.authorize.api.controller.test;
/*@author krgupta
 * 
 */
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
	public void UnSettledTransactionList()
	{  
		GetUnsettledTransactionListRequest getRequest = new GetUnsettledTransactionListRequest();
		getRequest.setMerchantAuthentication(merchantAuthenticationType);
		GetUnsettledTransactionListResponse getResponse = executeTestRequestWithSuccess(getRequest, GetUnsettledTransactionListController.class, environment);
		MessageTypeEnum messagetypeenum = getResponse.getMessages().getResultCode();		
		
		Assert.assertEquals("Check the credentials", MessageTypeEnum.OK,messagetypeenum);
	}
}

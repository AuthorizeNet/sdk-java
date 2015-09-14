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
import net.authorize.api.contract.v1.ArrayOfTransactionSummaryType;
import net.authorize.api.contract.v1.GetTransactionListRequest;
import net.authorize.api.contract.v1.GetTransactionListResponse;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.TransactionDetailsType;
import net.authorize.api.controller.GetTransactionListController;

public class GetTransactionList extends ApiCoreTestBase {
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
	public void TransactionList()
	{
		//update accordingly
		String batchId = "4594221";
 
		MessageTypeEnum messagetypeenum = transactionlist(merchantAuthenticationType, batchId);
		Assert.assertEquals(MessageTypeEnum.OK,messagetypeenum);
	}	
	
	private MessageTypeEnum transactionlist(MerchantAuthenticationType merchantAuthentication, String batchId) {
		//get a Transaction
		GetTransactionListRequest getRequest = new GetTransactionListRequest();
		getRequest.setMerchantAuthentication(merchantAuthenticationType);
		getRequest.setBatchId(batchId);
		GetTransactionListResponse getResponse = executeTestRequestWithSuccess(getRequest, GetTransactionListController.class, environment);
		Assert.assertNotNull(getResponse.getTransactions());
		return getResponse.getMessages().getResultCode();
	}	
}

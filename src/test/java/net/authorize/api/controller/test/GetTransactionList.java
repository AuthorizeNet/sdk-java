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
	
	//@Test
	/*To run this test successfully you should have a batchId 
	 */
	public void TransactionList()
	{
		String batchId = null ; //"4594221"; // Update to valid batchId
		Assert.assertNotNull("batchId is null. Enter a valid batchId", batchId);

		GetTransactionListRequest getRequest = new GetTransactionListRequest();
		getRequest.setMerchantAuthentication(merchantAuthenticationType);
		getRequest.setBatchId(batchId);
		GetTransactionListResponse getResponse = executeTestRequestWithSuccess(getRequest, GetTransactionListController.class, environment);
		MessageTypeEnum messagetypeenum = getResponse.getMessages().getResultCode();
		
		Assert.assertEquals("Check the credentials", MessageTypeEnum.OK,messagetypeenum);
	}	
}

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
import net.authorize.api.contract.v1.GetSettledBatchListRequest;
import net.authorize.api.contract.v1.GetSettledBatchListResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.GetSettledBatchListController;


public class GetSettledBatchList extends ApiCoreTestBase{	
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
	public void SettledBatchList()
	{  
		GetSettledBatchListRequest getRequest = new GetSettledBatchListRequest();
		getRequest.setMerchantAuthentication(merchantAuthenticationType);
		GetSettledBatchListResponse getResponse = executeTestRequestWithSuccess(getRequest, GetSettledBatchListController.class, environment);
		MessageTypeEnum messagetypeenum = getResponse.getMessages().getResultCode();	
		
		Assert.assertEquals("Check the credentials ", MessageTypeEnum.OK,messagetypeenum);
	}
}

package net.authorize.api.controller.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import junit.framework.Assert;
import net.authorize.api.contract.v1.ArrayOfBatchDetailsType;
import net.authorize.api.contract.v1.GetBatchStatisticsRequest;
import net.authorize.api.contract.v1.GetBatchStatisticsResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.controller.GetBatchStatisticsController;

public class GetBatchStatistics extends ApiCoreTestBase{
	
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
	public void getbatchstatistics()
	{  
		MessageTypeEnum messagetypeenum = getBatchStatistics();
		Assert.assertEquals(MessageTypeEnum.OK,messagetypeenum);
	}
	
	private MessageTypeEnum getBatchStatistics() {

		GetBatchStatisticsRequest getRequest = new GetBatchStatisticsRequest();
		getRequest.setMerchantAuthentication(merchantAuthenticationType);
		String batchId = "12345";
		getRequest.setBatchId(batchId);
		GetBatchStatisticsResponse getResponse = executeTestRequestWithSuccess(getRequest, GetBatchStatisticsController.class, environment);
		return getResponse.getMessages().getResultCode();
	}

}

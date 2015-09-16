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
	
	//@Test
	/*To run this test successfully you should have a valid batchId 
	 */
	public void getbatchstatistics()
	{  
		String batchId = null ; //"12345"; // Update to valid batchId
		Assert.assertNotNull("batchId is null. Enter a valid batchId", batchId);

		GetBatchStatisticsRequest getRequest = new GetBatchStatisticsRequest();
		getRequest.setMerchantAuthentication(merchantAuthenticationType);
		getRequest.setBatchId(batchId);
		GetBatchStatisticsResponse getResponse = executeTestRequestWithSuccess(getRequest, GetBatchStatisticsController.class, environment);
		MessageTypeEnum messagetypeenum = getResponse.getMessages().getResultCode();
		
		Assert.assertEquals("Check the credentials ", MessageTypeEnum.OK,messagetypeenum);
	}
}

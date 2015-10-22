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
import net.authorize.api.contract.v1.GetTransactionDetailsRequest;
import net.authorize.api.contract.v1.GetTransactionDetailsResponse;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.TransactionDetailsType;
import net.authorize.api.controller.GetTransactionDetailsController;

 /* test for issue #48 reported on github
*/
public class GetTransactionDetails extends ApiCoreTestBase {
	
	
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
	/*To run this test successfully you should have a valid transaction id 
	 */
	public void TransactionDetails()
	{
		String transId = null ; //"2236685252"; // Update to valid transId
		Assert.assertNotNull("transId is null. Enter a valid transId", transId);

		GetTransactionDetailsRequest getRequest = new GetTransactionDetailsRequest();
		getRequest.setMerchantAuthentication(merchantAuthenticationType);
		getRequest.setTransId(transId);
		GetTransactionDetailsResponse getResponse = executeTestRequestWithSuccess(getRequest, GetTransactionDetailsController.class, environment);
		MessageTypeEnum messagetypeenum = getResponse.getMessages().getResultCode();		
		
		Assert.assertEquals("Check the credentials", MessageTypeEnum.OK,messagetypeenum);
	}
}

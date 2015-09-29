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
import net.authorize.api.contract.v1.TransactionDetailsType;
import net.authorize.api.controller.GetTransactionDetailsController;

 /* test for issue #48 reported on github
*/
public class TransactionDetailsTest extends ApiCoreTestBase {
	
	
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
	public void TransactionDetails()
	{
		//update accordingly
		String transId = "2236685252";

		//transaction key and name  
		TransactionDetailsType transactionDetailsType = getTransactionDetails(merchantAuthenticationType, transId);
		
		//get transId in transactionDetailsType
		Assert.assertNotNull(transactionDetailsType);
		
		//get Authorized amount,CustomerIP,TransId, CardCodeResponse in transactionDetailsType
		Assert.assertNotNull(transactionDetailsType.getAuthAmount());
		Assert.assertNotNull(transactionDetailsType.getCustomerIP());
		Assert.assertEquals(transId, transactionDetailsType.getTransId());
		Assert.assertNotNull(transactionDetailsType.getCardCodeResponse());		
	}
	
	private TransactionDetailsType getTransactionDetails(MerchantAuthenticationType merchantAuthentication, String transId) {
		//get a Transaction
		GetTransactionDetailsRequest getRequest = new GetTransactionDetailsRequest();
		getRequest.setMerchantAuthentication(merchantAuthentication);
		getRequest.setTransId(transId);
		GetTransactionDetailsResponse getResponse = executeTestRequestWithSuccess(getRequest, GetTransactionDetailsController.class, environment);
		Assert.assertNotNull(getResponse.getTransaction());
		logger.info(String.format("AuthAmount: '%s', SettleAmount: '%s'", getResponse.getTransaction().getAuthAmount(), getResponse.getTransaction().getSettleAmount()));
		return getResponse.getTransaction();
	}	
}

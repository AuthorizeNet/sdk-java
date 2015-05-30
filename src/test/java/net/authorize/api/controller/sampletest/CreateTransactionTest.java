package net.authorize.api.controller.sampletest;

import java.math.BigDecimal;

import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.DecryptPaymentDataRequest;
import net.authorize.api.contract.v1.DecryptPaymentDataResponse;
import net.authorize.api.contract.v1.EncryptedTrackDataType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.OpaqueDataType;
import net.authorize.api.contract.v1.PayPalType;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.DecryptPaymentDataController;
import net.authorize.api.controller.base.ApiOperationBase;
import net.authorize.api.controller.test.ApiCoreTestBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CreateTransactionTest extends ApiCoreTestBase {

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
	public void createTransactionWithCreditCard()
	{
		CreditCardType creditCard = new CreditCardType();
		creditCard.setCardNumber("4111111111111111");
		creditCard.setExpirationDate("0616");
		
		PaymentType paymentType = new PaymentType();
		paymentType.setCreditCard(creditCard);
		
		CreateTransactionResponse response = createAndValidate("authOnlyTransaction",paymentType, merchantAuthenticationType);
		
		Assert.assertNotNull(response);
		Assert.assertEquals(MessageTypeEnum.OK, response.getMessages().getResultCode());
		Assert.assertFalse(response.getTransactionResponse().getTransId().isEmpty());
	}
	
	@Test
	public void decryptVisaCheckOutPaymentData()
	{
		// Switch to use the ApplePay apiLoginIdKey and transactionKey
		final String apiLoginIdKey = merchantAuthenticationType.getName();
		final String transactionKey = merchantAuthenticationType.getTransactionKey();

		merchantAuthenticationType.setName(apiLoginIdKeyApplePay);
		merchantAuthenticationType.setTransactionKey(transactionKeyApplePay);

		try {
			OpaqueDataType opaqueData = new OpaqueDataType();
			opaqueData.setDataDescriptor("COMMON.VCO.ONLINE.PAYMENT");
			opaqueData.setDataValue("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");
			opaqueData.setDataKey("KCSJeIab7wwH7mFcPM/YL+V9xBCDe4CmSjJ0MPHEodpWz4rmz78U8bR4Qqs1ipLBqH9mrfvLF4pytIcLOjKUtXvAII/xCze84INFMdtsVBgtEp5bZ4leehRQhNM+3/NH");
		
			DecryptPaymentDataRequest decryptPaymentDataRequest = new DecryptPaymentDataRequest();
			decryptPaymentDataRequest.setOpaqueData(opaqueData);
			decryptPaymentDataRequest.setCallId("1238408836021304101");
			
			//Common code to set for all requests
			ApiOperationBase.setEnvironment(environment);
			ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);

			DecryptPaymentDataController controller = new DecryptPaymentDataController(decryptPaymentDataRequest);
			controller.execute();
		
			DecryptPaymentDataResponse response = controller.getApiResponse();
		
			Assert.assertNotNull(response);
			Assert.assertEquals(MessageTypeEnum.OK, response.getMessages().getResultCode());
			Assert.assertEquals("Successful.", response.getMessages().getMessage().get(0).getText());
		}
		finally {
			merchantAuthenticationType.setName(apiLoginIdKey);
			merchantAuthenticationType.setTransactionKey(transactionKey);
		}
	}
	
	@Test
	@Ignore("The values of the callId, encKey and encPaymentData are one-time use values. Goto the http://brianmc.github.io/checkout.html to generate new values.")
	public void createTransactionWithVisaCheckOut()
	{
		final String encKey = "fQcg05s41WCEvHHkRIq7RfIxfmn/ZfcaXQdsFv8s+JpQvKeqBY42RqX3TdJ6nn0ATb63UAzj86PO/DNmp7lXS49MmGL44xFZatsYzWF8/aAN2ZrF9zr2Zu/03OOQOyHu";
		final String encPaymentData = "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";
		final String callId = "4371966085883192101";
		
		// Switch to use the ApplePay apiLoginIdKey and transactionKey
		final String apiLoginIdKey = merchantAuthenticationType.getName();
		final String transactionKey = merchantAuthenticationType.getTransactionKey();

		merchantAuthenticationType.setName(apiLoginIdKeyApplePay);
		merchantAuthenticationType.setTransactionKey(transactionKeyApplePay);

		try {
			OpaqueDataType opaqueData = new OpaqueDataType();
			opaqueData.setDataDescriptor("COMMON.VCO.ONLINE.PAYMENT");
			opaqueData.setDataKey(encKey);
			opaqueData.setDataValue(encPaymentData);

			PaymentType paymentType = new PaymentType();
			paymentType.setOpaqueData(opaqueData);
		
			CreateTransactionResponse response = createAndValidate("authCaptureTransaction", paymentType, merchantAuthenticationType, callId);
		
			Assert.assertNotNull(response);
			Assert.assertEquals(MessageTypeEnum.OK, response.getMessages().getResultCode());
			Assert.assertEquals("Successful.", response.getMessages().getMessage().get(0).getText());
			Assert.assertEquals("1", response.getTransactionResponse().getMessages().getMessage().get(0).getCode());
		}
		finally {
			merchantAuthenticationType.setName(apiLoginIdKey);
			merchantAuthenticationType.setTransactionKey(transactionKey);
		}
	}

	@Test
	public void createTransactionWithApplePay()
	{
		// Switch to use the ApplePay apiLoginIdKey and transactionKey
		final String apiLoginIdKey = merchantAuthenticationType.getName();
		final String transactionKey = merchantAuthenticationType.getTransactionKey();

		merchantAuthenticationType.setName(apiLoginIdKeyApplePay);
		merchantAuthenticationType.setTransactionKey(transactionKeyApplePay);

		try {
			OpaqueDataType opaqueData = new OpaqueDataType();
			opaqueData.setDataDescriptor("COMMON.APPLE.INAPP.PAYMENT");
			opaqueData.setDataValue("eyJkYXRhIjoiQkRQTldTdE1tR2V3UVVXR2c0bzdFXC9qKzFjcTFUNzhxeVU4NGI2N2l0amNZSTh3UFlBT2hzaGpoWlBycWRVcjRYd1BNYmo0emNHTWR5KysxSDJWa1BPWStCT01GMjV1YjE5Y1g0bkN2a1hVVU9UakRsbEIxVGdTcjhKSFp4Z3A5ckNnc1NVZ2JCZ0tmNjBYS3V0WGY2YWpcL284WkliS25yS1E4U2gwb3VMQUtsb1VNbit2UHU0K0E3V0tycXJhdXo5SnZPUXA2dmhJcStIS2pVY1VOQ0lUUHlGaG1PRXRxK0grdzB2UmExQ0U2V2hGQk5uQ0hxenpXS2NrQlwvMG5xTFpSVFliRjBwK3Z5QmlWYVdIZWdoRVJmSHhSdGJ6cGVjelJQUHVGc2ZwSFZzNDhvUExDXC9rXC8xTU5kNDdrelwvcEhEY1JcL0R5NmFVTStsTmZvaWx5XC9RSk4rdFMzbTBIZk90SVNBUHFPbVhlbXZyNnhKQ2pDWmxDdXcwQzltWHpcL29iSHBvZnVJRVM4cjljcUdHc1VBUERwdzdnNjQybTRQendLRitIQnVZVW5lV0RCTlNEMnU2amJBRzMiLCJ2ZXJzaW9uIjoiRUNfdjEiLCJoZWFkZXIiOnsiYXBwbGljYXRpb25EYXRhIjoiOTRlZTA1OTMzNWU1ODdlNTAxY2M0YmY5MDYxM2UwODE0ZjAwYTdiMDhiYzdjNjQ4ZmQ4NjVhMmFmNmEyMmNjMiIsInRyYW5zYWN0aW9uSWQiOiJjMWNhZjVhZTcyZjAwMzlhODJiYWQ5MmI4MjgzNjM3MzRmODViZjJmOWNhZGYxOTNkMWJhZDlkZGNiNjBhNzk1IiwiZXBoZW1lcmFsUHVibGljS2V5IjoiTUlJQlN6Q0NBUU1HQnlxR1NNNDlBZ0V3Z2ZjQ0FRRXdMQVlIS29aSXpqMEJBUUloQVBcL1wvXC9cLzhBQUFBQkFBQUFBQUFBQUFBQUFBQUFcL1wvXC9cL1wvXC9cL1wvXC9cL1wvXC9cL1wvXC9cL01Gc0VJUFwvXC9cL1wvOEFBQUFCQUFBQUFBQUFBQUFBQUFBQVwvXC9cL1wvXC9cL1wvXC9cL1wvXC9cL1wvXC9cLzhCQ0JheGpYWXFqcVQ1N1BydlZWMm1JYThaUjBHc014VHNQWTd6ancrSjlKZ1N3TVZBTVNkTmdpRzV3U1RhbVo0NFJPZEpyZUJuMzZRQkVFRWF4ZlI4dUVzUWtmNHZPYmxZNlJBOG5jRGZZRXQ2ek9nOUtFNVJkaVl3cFpQNDBMaVwvaHBcL200N242MHA4RDU0V0s4NHpWMnN4WHM3THRrQm9ONzlSOVFJaEFQXC9cL1wvXC84QUFBQUFcL1wvXC9cL1wvXC9cL1wvXC9cLys4NXZxdHB4ZWVoUE81eXNMOFl5VlJBZ0VCQTBJQUJHbStnc2wwUFpGVFwva0RkVVNreHd5Zm84SnB3VFFRekJtOWxKSm5tVGw0REdVdkFENEdzZUdqXC9wc2hCWjBLM1RldXFEdFwvdERMYkUrOFwvbTB5Q21veHc9IiwicHVibGljS2V5SGFzaCI6IlwvYmI5Q05DMzZ1QmhlSEZQYm1vaEI3T28xT3NYMkora0pxdjQ4ek9WVmlRPSJ9LCJzaWduYXR1cmUiOiJNSUlEUWdZSktvWklodmNOQVFjQ29JSURNekNDQXk4Q0FRRXhDekFKQmdVckRnTUNHZ1VBTUFzR0NTcUdTSWIzRFFFSEFhQ0NBaXN3Z2dJbk1JSUJsS0FEQWdFQ0FoQmNsK1BmMytVNHBrMTNuVkQ5bndRUU1Ba0dCU3NPQXdJZEJRQXdKekVsTUNNR0ExVUVBeDRjQUdNQWFBQnRBR0VBYVFCQUFIWUFhUUJ6QUdFQUxnQmpBRzhBYlRBZUZ3MHhOREF4TURFd05qQXdNREJhRncweU5EQXhNREV3TmpBd01EQmFNQ2N4SlRBakJnTlZCQU1lSEFCakFHZ0FiUUJoQUdrQVFBQjJBR2tBY3dCaEFDNEFZd0J2QUcwd2daOHdEUVlKS29aSWh2Y05BUUVCQlFBRGdZMEFNSUdKQW9HQkFOQzgra2d0Z212V0YxT3pqZ0ROcmpURUJSdW9cLzVNS3ZsTTE0NnBBZjdHeDQxYmxFOXc0ZklYSkFEN0ZmTzdRS2pJWFlOdDM5ckx5eTd4RHdiXC81SWtaTTYwVFoyaUkxcGo1NVVjOGZkNGZ6T3BrM2Z0WmFRR1hOTFlwdEcxZDlWN0lTODJPdXA5TU1vMUJQVnJYVFBITmNzTTk5RVBVblBxZGJlR2M4N20wckFnTUJBQUdqWERCYU1GZ0dBMVVkQVFSUk1FK0FFSFpXUHJXdEpkN1laNDMxaENnN1lGU2hLVEFuTVNVd0l3WURWUVFESGh3QVl3Qm9BRzBBWVFCcEFFQUFkZ0JwQUhNQVlRQXVBR01BYndCdGdoQmNsK1BmMytVNHBrMTNuVkQ5bndRUU1Ba0dCU3NPQXdJZEJRQURnWUVBYlVLWUNrdUlLUzlRUTJtRmNNWVJFSW0ybCtYZzhcL0pYditHQlZRSmtPS29zY1k0aU5ERkFcL2JRbG9nZjlMTFU4NFRId05SbnN2VjNQcnY3UlRZODFncTBkdEM4elljQWFBa0NISUkzeXFNbko0QU91NkVPVzlrSmsyMzJnU0U3V2xDdEhiZkxTS2Z1U2dRWDhLWFFZdVpMazJScjYzTjhBcFhzWHdCTDNjSjB4Z2VBd2dkMENBUUV3T3pBbk1TVXdJd1lEVlFRREhod0FZd0JvQUcwQVlRQnBBRUFBZGdCcEFITUFZUUF1QUdNQWJ3QnRBaEJjbCtQZjMrVTRwazEzblZEOW53UVFNQWtHQlNzT0F3SWFCUUF3RFFZSktvWklodmNOQVFFQkJRQUVnWUJhSzNFbE9zdGJIOFdvb3NlREFCZitKZ1wvMTI5SmNJYXdtN2M2VnhuN1phc05iQXEzdEF0OFB0eSt1UUNnc3NYcVprTEE3a3oyR3pNb2xOdHY5d1ltdTlVandhcjFQSFlTK0JcL29Hbm96NTkxd2phZ1hXUnowbk1vNXkzTzFLelgwZDhDUkhBVmE4OFNyVjFhNUpJaVJldjNvU3RJcXd2NXh1WmxkYWc2VHI4dz09In0=");
		
			PaymentType paymentType = new PaymentType();
			paymentType.setOpaqueData(opaqueData);
		
			CreateTransactionResponse response = createAndValidate("authCaptureTransaction", paymentType, merchantAuthenticationType);
		
			Assert.assertNotNull(response);
			Assert.assertEquals("1", response.getTransactionResponse().getMessages().getMessage().get(0).getCode());
		}
		finally {
			merchantAuthenticationType.setName(apiLoginIdKey);
			merchantAuthenticationType.setTransactionKey(transactionKey);
		}
	}
	
	@Test
	public void createTransactionWithPayPal()
	{
		/*
		 * Please enable the PayPal feature of your ANet account.
		 */	    
		PayPalType payPalData = new PayPalType();
		payPalData.setPaypalLc("IT");
		payPalData.setPaypalPayflowcolor("FFFF00");
		payPalData.setSuccessUrl("https://success.anet.net");
		payPalData.setCancelUrl("https://cancel.anet.net");
		
		PaymentType paymentType = new PaymentType();
		paymentType.setPayPal(payPalData);
		
		CreateTransactionResponse response = createAndValidate("authOnlyTransaction", paymentType, merchantAuthenticationType);
		Assert.assertNotNull(response);
		Assert.assertFalse(response.getTransactionResponse().getTransId().isEmpty());
		Assert.assertFalse(response.getTransactionResponse().getTransHash().isEmpty());
		Assert.assertNotNull(response.getTransactionResponse().getSecureAcceptance());
		Assert.assertFalse(response.getTransactionResponse().getSecureAcceptance().getSecureAcceptanceUrl().isEmpty());
	}
	
	private CreateTransactionResponse createAndValidate(String transactionType, PaymentType paymentType, MerchantAuthenticationType merchantAuthenticationType)
	{
		return createAndValidate(transactionType, paymentType, merchantAuthenticationType, null); 
	}
	
	private CreateTransactionResponse createAndValidate(String transactionType, PaymentType paymentType, MerchantAuthenticationType merchantAuthenticationType, String callId)
	{
		//Common code to set for all requests
		ApiOperationBase.setEnvironment(environment);
		ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);
				
		TransactionRequestType requestInternal = new TransactionRequestType();
		requestInternal.setTransactionType(transactionType);
		requestInternal.setPayment(paymentType);
		requestInternal.setAmount(new BigDecimal(System.currentTimeMillis() % 100));
		if (callId != null)
			requestInternal.setCallId(callId);
		
		CreateTransactionRequest request = new CreateTransactionRequest();
		request.setTransactionRequest(requestInternal);
				
		CreateTransactionController controller = new CreateTransactionController(request);
		controller.execute();
				
		return controller.getApiResponse();
	}
}

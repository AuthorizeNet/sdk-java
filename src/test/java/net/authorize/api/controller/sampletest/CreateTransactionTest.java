package net.authorize.api.controller.sampletest;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.authorize.api.contract.v1.CreateCustomerProfileFromTransactionRequest;
import net.authorize.api.contract.v1.CreateCustomerProfileResponse;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.CustomerDataType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.MessagesType;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.controller.CreateCustomerProfileFromTransactionConroller;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;
import net.authorize.api.controller.test.ApiCoreTestBase;
import net.authorize.data.Customer;

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
	public void createTransactionSample()
	{
		//Common code to set for all requests
		ApiOperationBase.setEnvironment(environment);
		ApiOperationBase.setMerchantAuthentication(cnpMerchantAuthenticationType);
		
		CreditCardType creditCard = new CreditCardType();
		creditCard.setCardNumber("4111111111111111");
		creditCard.setExpirationDate("0616");
		
		PaymentType paymentType = new PaymentType();
		paymentType.setCreditCard(creditCard);
		
		TransactionRequestType requestInternal = new TransactionRequestType();
		requestInternal.setTransactionType("authOnlyTransaction");
		requestInternal.setPayment(paymentType);
		requestInternal.setAmount(new BigDecimal(System.currentTimeMillis() % 100));
		
		CreateTransactionRequest request = new CreateTransactionRequest();
		request.setTransactionRequest(requestInternal);
		
		CreateTransactionController controller = new CreateTransactionController(request);
		controller.execute();
		
		CreateTransactionResponse response = controller.getApiResponse();
		
		Assert.assertNotNull(response);
		Assert.assertEquals(MessageTypeEnum.OK, response.getMessages().getResultCode());
		Assert.assertFalse(response.getTransactionResponse().getTransId().isEmpty());
	}
}

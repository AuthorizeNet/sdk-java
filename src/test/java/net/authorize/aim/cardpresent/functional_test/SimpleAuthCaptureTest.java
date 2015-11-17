package net.authorize.aim.cardpresent.functional_test;

import junit.framework.Assert;
import net.authorize.DeviceType;
import net.authorize.Environment;
import net.authorize.MarketType;
import net.authorize.Merchant;
import net.authorize.ResponseCode;
import net.authorize.ResponseReasonCode;
import net.authorize.TransactionType;
import net.authorize.UnitTestData;
import net.authorize.aim.Transaction;
import net.authorize.aim.cardpresent.PrepaidCard;
import net.authorize.aim.cardpresent.Result;
import net.authorize.data.Customer;
import net.authorize.data.Order;
import net.authorize.data.creditcard.CardType;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.reporting.Solution;

import org.junit.Before;
import org.junit.Test;

public class SimpleAuthCaptureTest extends UnitTestData {

	private static String transactionId;
	private static String authCode;

	private Customer customer;
	private Order order;
	private CreditCard creditCard = CreditCard.createCreditCard();
        private Solution solution;

	@Before
	public void setUp() {
		// create customer
		customer = Customer.createCustomer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setZipPostalCode(zipPostalCode);

		// create order
		order = Order.createOrder();
		order.setDescription(orderDescription);
		order.setInvoiceNumber(invoiceNumber);

		// create credit card
		creditCard = CreditCard.createCreditCard();
		creditCard.setCardType(CardType.VISA);
                creditCard.setTrack1("%B4111111111111111^CARDUSER/JOHN^1803101000000000020000831000000?");
                creditCard.setTrack2(";4111111111111111=1803101000020000831?");

                merchant = Merchant.createMerchant(Environment.SANDBOX, apiLoginID, transactionKey);
                merchant.setDeviceType(DeviceType.VIRTUAL_TERMINAL);
                merchant.setMarketType(MarketType.RETAIL);
                merchant.setMD5Value(merchantMD5Key);
                
                // create solution
                solution = Solution.createSolution();
                solution.setId("AAA100302");
	}

	@Test
	public void testCreditCardAuthCapture() {

		// create transaction
		Transaction authCaptureTransaction = merchant.createAIMTransaction(
				TransactionType.AUTH_CAPTURE, totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setCreditCard(creditCard);

		authCaptureTransaction.setMerchantDefinedField("super", "duper");
                authCaptureTransaction.setSolutionField(solution);

        Result<Transaction> result = (Result<Transaction>) merchant.postTransaction(authCaptureTransaction);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isApproved());
		Assert.assertTrue(result.isAuthorizeNet());
		Assert.assertEquals(ResponseCode.APPROVED, result.getResponseCode());
		Assert.assertEquals("This transaction has been approved.", result.getResponseCode().getDescription());
		Assert.assertEquals(1, result.getResponseReasonCodes().size());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1, result.getResponseReasonCodes().get(0));
		Assert.assertEquals("This transaction has been approved.", result.getResponseReasonCodes().get(0).getReasonText());
		Assert.assertNotSame("000000", result.getAuthCode());
		Assert.assertNotSame("0", result.getTransId());
		//Assert.assertTrue(result.isTestMode());
		Assert.assertTrue(result.getTarget().getCreditCard().getCreditCardNumber().startsWith("XXXX"));
		Assert.assertEquals(CardType.VISA, result.getTarget().getCreditCard().getCardType());

		//validate prepaid card, if present
		//AssertPrepaidCard( result.getPrepaidCard());
		//Assert.assertNotNull( result.getSplitTenderId());
	}

	// auth
	@Test
	public void testAuthOnly() {

		// create transaction
		Transaction authCaptureTransaction = merchant.createAIMTransaction(
				TransactionType.AUTH_ONLY, totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setCreditCard(creditCard);
		authCaptureTransaction.setMerchantDefinedField(mdfKey, mdfValue);
                authCaptureTransaction.setSolutionField(solution);

		Result<Transaction> result = (Result<Transaction>)merchant
				.postTransaction(authCaptureTransaction);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isApproved());
		Assert.assertEquals(ResponseCode.APPROVED, result.getResponseCode());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1, result.getResponseReasonCodes().get(0));
		Assert.assertNotNull(result.getAuthCode());
		Assert.assertNotNull(result.getTransId());

		SimpleAuthCaptureTest.transactionId = result.getTransId();
		SimpleAuthCaptureTest.authCode = result.getAuthCode();
	}

	// capture
	@Test
	public void testCaptureOnly() {
		// create transaction
		Transaction captureTransaction = merchant.createAIMTransaction(
				TransactionType.CAPTURE_ONLY, totalAmount);
		captureTransaction.setCustomer(customer);
		captureTransaction.setOrder(order);
		captureTransaction.setCreditCard(creditCard);
		captureTransaction.setTransactionId(transactionId);
		captureTransaction.setAuthorizationCode(authCode);
                captureTransaction.setSolutionField(solution);

		Result<Transaction> result = (Result<Transaction>)merchant
				.postTransaction(captureTransaction);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isApproved());
		Assert.assertEquals(ResponseCode.APPROVED, result.getResponseCode());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1, result.getResponseReasonCodes().get(0));
		Assert.assertNotNull(result.getAuthCode());
		Assert.assertNotNull(result.getTransId());

		SimpleAuthCaptureTest.transactionId = result.getTransId();
	}

	public static void AssertPrepaidCard( PrepaidCard prepaidCard)
	{
		Assert.assertNotNull(prepaidCard);
		Assert.assertTrue( 0 < prepaidCard.getRequestedAmount());
		Assert.assertTrue( 0 < prepaidCard.getApprovedAmount());
		Assert.assertTrue( 0 < prepaidCard.getBalanceAmountOnCard());
	}
}

package net.authorize.aim.functional_test;

import junit.framework.Assert;
import net.authorize.ResponseCode;
import net.authorize.ResponseReasonCode;
import net.authorize.TransactionType;
import net.authorize.UnitTestData;
import net.authorize.aim.Result;
import net.authorize.aim.Transaction;
import net.authorize.data.Customer;
import net.authorize.data.Order;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.echeck.ECheck;
// ADDED
    import net.authorize.data.reporting.Solution;

import org.junit.Before;
import org.junit.Test;

public class SimpleAuthCaptureTest extends UnitTestData {

	private Customer customer;
	private Order order;
        // ADDED
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
                
                // create solution
                solution = Solution.createSolution();
                solution.setId("AAA100302");
                solution.setName("Test Solution #1");
	}

	@Test
	public void testCreditCardAuthCapture() {

		// create credit card
		CreditCard creditCard = CreditCard.createCreditCard();
		creditCard.setCreditCardNumber(creditCardNumber);
		creditCard.setExpirationMonth(creditCardExpMonth);
		creditCard.setExpirationYear(creditCardExpYear);

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
		Assert.assertEquals(ResponseCode.APPROVED, result.getResponseCode());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1, result
				.getReasonResponseCode());
		Assert.assertNotNull(result.getTarget().getAuthorizationCode());
		Assert.assertNotNull(result.getTarget().getTransactionId());
		Assert.assertNotNull(result.getTarget().getCreditCard().getAvsCode());                
	}

	@Test
	public void testECheckAuthCapture() {

		// create echeck data
		ECheck eCheck = ECheck.createECheck();
		eCheck.setBankAccountName(bankAccountName);
		eCheck.setBankAccountNumber(bankAccountNumber);
		eCheck.setBankAccountType(bankAccountType);
		eCheck.setBankCheckNumber(bankCheckNumber);
		eCheck.setBankName(bankName);
		eCheck.setECheckType(eCheckType);
		eCheck.setRoutingNumber(routingNumber);

		// create transaction
		Transaction authCaptureTransaction = merchant.createAIMTransaction(
				TransactionType.AUTH_CAPTURE, totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setECheck(eCheck);
                authCaptureTransaction.setSolutionField(solution);

		Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(authCaptureTransaction);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isApproved());
		Assert.assertEquals(ResponseCode.APPROVED, result.getResponseCode());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1, result
				.getReasonResponseCode());
		Assert.assertNotNull(result.getTarget().getAuthorizationCode());
		Assert.assertNotNull(result.getTarget().getTransactionId());

	}
}

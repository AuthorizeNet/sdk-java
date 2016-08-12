package net.authorize.aim.functional_test;

import java.math.BigDecimal;

import junit.framework.Assert;
import net.authorize.ResponseCode;
import net.authorize.ResponseField;
import net.authorize.ResponseReasonCode;
import net.authorize.TransactionType;
import net.authorize.UnitTestData;
import net.authorize.aim.Result;
import net.authorize.aim.Transaction;
import net.authorize.data.Customer;
import net.authorize.data.EmailReceipt;
import net.authorize.data.Order;
import net.authorize.data.OrderItem;
import net.authorize.data.ShippingAddress;
import net.authorize.data.ShippingCharges;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.reporting.Solution;

import org.junit.Before;
import org.junit.Test;

public class MultiOrderAuth_Capture_Void_CreditTest extends UnitTestData {

	private static String authCode;
	private static String transactionId;

	private Customer customer;
	private CreditCard creditCard;
	private Order order;
	private OrderItem orderItem;
	private ShippingAddress shippingAddress;
	private ShippingCharges shippingCharges;
	private EmailReceipt emailReceipt;
	private static String splitTenderId = null;
        private Solution solution;

	@Before
	public void setUp() throws Exception {
		// create customer
		customer = Customer.createCustomer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setZipPostalCode(zipPostalCode);
		customer.setCompany(company);
		customer.setCountry(country);
		customer.setCustomerId(customerId);
		customer.setCustomerIP(customerIP);
		customer.setEmail(email);
		customer.setFax(fax);
		customer.setPhone(phone);

		// create credit card
		creditCard = CreditCard.createCreditCard();
		creditCard.setCreditCardNumber(creditCardNumber);
		creditCard.setExpirationMonth(creditCardExpMonth);
		creditCard.setExpirationYear(creditCardExpYear);

		// create order
		order = Order.createOrder();
		order.setDescription(orderDescription);
		order.setInvoiceNumber(invoiceNumber);

		// create order item
		orderItem = OrderItem.createOrderItem();
		orderItem.setItemDescription(itemDescription);
		orderItem.setItemId(itemId);
		orderItem.setItemName(itemName);
		orderItem.setItemPrice(itemPrice);
		orderItem.setItemQuantity(itemQuantity);
		orderItem.setItemTaxable(true);
		order.addOrderItem(orderItem);

		orderItem = OrderItem.createOrderItem();
		orderItem.setItemDescription(itemDescription2);
		orderItem.setItemId(itemId2);
		orderItem.setItemName(itemName2);
		orderItem.setItemPrice(itemPrice2);
		orderItem.setItemQuantity(itemQuantity2);
		orderItem.setItemTaxable(false);
		order.addOrderItem(orderItem);

		/*
		 *  add a bunch of line items (notice that we're trying to add 29 more
		 *  which is over the limit of 30.  addOrderItem knows the max length
		 *  and will only allow 30 in
		 */
		for(int i = 0; i <= 29; i++) {
			order.addOrderItem(orderItem);
		}

		// shipping address
		shippingAddress = ShippingAddress.createShippingAddress();
		shippingAddress.setAddress(address);
		shippingAddress.setCity(city);
		shippingAddress.setCompany(company);
		shippingAddress.setCountry(country);
		shippingAddress.setFirstName(firstName);
		shippingAddress.setLastName(lastName);
		shippingAddress.setState(state);
		shippingAddress.setZipPostalCode(zipPostalCode);

		// shipping charges
		shippingCharges = ShippingCharges.createShippingCharges();
		shippingCharges.setDutyAmount(dutyAmount);
		shippingCharges.setDutyItemDescription(dutyItemDescription);
		shippingCharges.setDutyItemName(dutyItemName);
		shippingCharges.setFreightAmount(freightAmount);
		shippingCharges.setFreightDescription(freightDescription);
		shippingCharges.setFreightItemName(freightItemName);
		shippingCharges.setPurchaseOrderNumber(purchaseOrderNumber);
		shippingCharges.setTaxAmount(taxAmount);
		shippingCharges.setTaxDescription(taxDescription);
		shippingCharges.setTaxExempt(taxExempt);
		shippingCharges.setTaxItemName(taxItemName);

		// email receipt
		emailReceipt = EmailReceipt.createEmailReceipt();
		emailReceipt.setEmail(email);
		emailReceipt.setEmailCustomer(true);
		emailReceipt.setFooterEmailReceipt(footerEmailReceipt);
		emailReceipt.setHeaderEmailReceipt(headerEmailReceipt);
		emailReceipt.setMerchantEmail(merchantEmail);
                
                // create solution
                solution = Solution.createSolution();
                solution.setId("AAA100302");
	}

	/**
	 * This is used in CIM to get access to an AIM created splitTenderId.
	 *
	 * @return String containing the splitTenderId
	 */
	public String createSplitTenderAuthCapture() {

		try {
			this.setUp();
			this.testCreateSplitTenderAuthCapture();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return MultiOrderAuth_Capture_Void_CreditTest.splitTenderId;
	}

	// auth - split tender auth
	@Test
	public void testCreateSplitTenderAuthCapture() {

		merchant.setAllowPartialAuth(true);
		// create transaction
		Transaction authCaptureTransaction = merchant.createAIMTransaction(TransactionType.AUTH_ONLY, totalAmount);
		creditCard.setCreditCardNumber("4222222222222");
		customer.setZipPostalCode(magicSplitTenderZipCode);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setCreditCard(creditCard);
		authCaptureTransaction.setShippingAddress(shippingAddress);
		authCaptureTransaction.setShippingCharges(shippingCharges);
		authCaptureTransaction.setEmailReceipt(emailReceipt);
		authCaptureTransaction.setMerchantDefinedField(mdfKey, mdfValue);
                authCaptureTransaction.setSolutionField(solution);

		Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(authCaptureTransaction);

		MultiOrderAuth_Capture_Void_CreditTest.splitTenderId = result.getTarget().getResponseField(ResponseField.SPLIT_TENDER_ID);
		Assert.assertNotNull(splitTenderId);
		Assert.assertTrue(result.isReview());

		authCaptureTransaction = merchant.createAIMTransaction(
				TransactionType.AUTH_ONLY, totalAmount.subtract(
						new BigDecimal(result.getTarget().getResponseMap().get(ResponseField.AMOUNT))));
		authCaptureTransaction.setSplitTenderId(splitTenderId);
		creditCard.setCreditCardNumber("4222222222222");
		customer.setZipPostalCode(zipPostalCode);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setCreditCard(creditCard);
		authCaptureTransaction.setShippingAddress(shippingAddress);
		authCaptureTransaction.setShippingCharges(shippingCharges);
		authCaptureTransaction.setEmailReceipt(emailReceipt);
		authCaptureTransaction.setMerchantDefinedField(mdfKey, mdfValue);
                authCaptureTransaction.setSolutionField(solution);

		result = (Result<Transaction>)merchant.postTransaction(authCaptureTransaction);
		Assert.assertTrue(result.isApproved());
	}

	// auth
	@Test
	public void testAuthOnly() {

		getAuthCode();
	}

	/**
	 * 
	 */
	private void getAuthCode() {
		// create transaction
		Transaction authCaptureTransaction = merchant.createAIMTransaction(TransactionType.AUTH_ONLY, totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setCreditCard(creditCard);
		authCaptureTransaction.setShippingAddress(shippingAddress);
		authCaptureTransaction.setShippingCharges(shippingCharges);
		authCaptureTransaction.setEmailReceipt(emailReceipt);
		authCaptureTransaction.setMerchantDefinedField(mdfKey, mdfValue);
                authCaptureTransaction.setSolutionField(solution);

		Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(authCaptureTransaction);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isApproved());
		Assert.assertEquals(ResponseCode.APPROVED, result.getResponseCode());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1, result.getReasonResponseCode());
		Assert.assertNotNull(result.getTarget().getAuthorizationCode());
		Assert.assertNotNull(result.getTarget().getTransactionId());
		Assert.assertNotNull(result.getTarget().getCreditCard().getAvsCode());

		MultiOrderAuth_Capture_Void_CreditTest.authCode = result.getTarget().getAuthorizationCode();
	}

	// capture
	@Test
	public void testCaptureOnly() {
		
		getCapture();
	}

	/**
	 * 
	 */
	private void getCapture() {
		if ( null == MultiOrderAuth_Capture_Void_CreditTest.authCode) { getAuthCode(); }
		Assert.assertNotNull("Dependent on AuthCode from test 'testAuthOnly', which is null", MultiOrderAuth_Capture_Void_CreditTest.authCode);
		
		// create transaction
		Transaction captureTransaction = merchant.createAIMTransaction(
				TransactionType.CAPTURE_ONLY, totalAmount);
		captureTransaction.setCustomer(customer);
		captureTransaction.setOrder(order);
		captureTransaction.setCreditCard(creditCard);
		captureTransaction.setShippingAddress(shippingAddress);
		captureTransaction.setShippingCharges(shippingCharges);
		captureTransaction.setEmailReceipt(emailReceipt);
		captureTransaction.setAuthorizationCode(MultiOrderAuth_Capture_Void_CreditTest.authCode);
		captureTransaction.setMerchantDefinedField(mdfKey, mdfValue);
                captureTransaction.setSolutionField(solution);

		Result<Transaction> result = (Result<Transaction>)merchant
				.postTransaction(captureTransaction);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isApproved());
		Assert.assertEquals(ResponseCode.APPROVED, result.getResponseCode());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1, result
				.getReasonResponseCode());
		Assert.assertNotNull(result.getTarget().getAuthorizationCode());
		Assert.assertNotNull(result.getTarget().getTransactionId());
		Assert.assertNotNull(result.getTarget().getCreditCard().getAvsCode());

		MultiOrderAuth_Capture_Void_CreditTest.transactionId = result.getTarget().getTransactionId();
	}

	// void
	@Test
	public void testVoid() {
		
		if ( null == MultiOrderAuth_Capture_Void_CreditTest.transactionId) { getCapture(); }
		Assert.assertNotNull( "Dependent on transactionId from test 'testCaptureOnly' which is null", MultiOrderAuth_Capture_Void_CreditTest.transactionId);
		
		// create transaction
		Transaction voidTransaction = merchant.createAIMTransaction(
				TransactionType.VOID, totalAmount);
		voidTransaction.setCustomer(customer);
		voidTransaction.setOrder(order);
		voidTransaction.setCreditCard(creditCard);
		voidTransaction.setShippingAddress(shippingAddress);
		voidTransaction.setShippingCharges(shippingCharges);
		voidTransaction.setEmailReceipt(emailReceipt);
		voidTransaction.setTransactionId(MultiOrderAuth_Capture_Void_CreditTest.transactionId);
                voidTransaction.setSolutionField(solution);

		Result<Transaction> result = (Result<Transaction>)merchant
				.postTransaction(voidTransaction);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isApproved());
		Assert.assertEquals(ResponseCode.APPROVED, result.getResponseCode());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1, result
				.getReasonResponseCode());
		Assert.assertNotNull(result.getTarget().getAuthorizationCode());
		Assert.assertNotNull(result.getTarget().getTransactionId());
		Assert.assertNotNull(result.getTarget().getCreditCard().getAvsCode());
	}

	/*
	 * credit
	 *
	 * NOTE: this will fail intentionally since the transaction has not been
	 * posted.
	 */
	@Test
	public void testCredit() {

		if ( null == MultiOrderAuth_Capture_Void_CreditTest.transactionId) { getCapture(); }
		Assert.assertNotNull( "Dependent on transactionId from test 'testCaptureOnly' which is null", MultiOrderAuth_Capture_Void_CreditTest.transactionId);

		// create transaction
		Transaction creditTransaction = merchant.createAIMTransaction(
				TransactionType.CREDIT, totalAmount);
		creditTransaction.setCustomer(customer);
		creditTransaction.setOrder(order);
		creditTransaction.setCreditCard(creditCard);
		creditTransaction.setShippingAddress(shippingAddress);
		creditTransaction.setShippingCharges(shippingCharges);
		creditTransaction.setEmailReceipt(emailReceipt);
		creditTransaction.setTransactionId(MultiOrderAuth_Capture_Void_CreditTest.transactionId);
                creditTransaction.setSolutionField(solution);

		Result<Transaction> result = (Result<Transaction>)merchant
				.postTransaction(creditTransaction);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isError());
		Assert.assertEquals(ResponseCode.ERROR, result.getResponseCode());
		Assert.assertEquals(ResponseReasonCode.RRC_3_54, result
				.getReasonResponseCode());
		Assert.assertEquals("", result.getTarget().getAuthorizationCode());
		Assert.assertEquals("0", result.getTarget().getTransactionId());
		Assert.assertNotNull(result.getTarget().getCreditCard().getAvsCode());
	}

	/*
	 * unlinked_credit
	 *
	 * NOTE: this will fail intentionally since the transaction has not been
	 * posted and isn't supported w/out an ECC application.
	 *
	 */
	@Test
	public void testUnlinkedCredit() {

		// create transaction
		Transaction creditTransaction = merchant.createAIMTransaction(
				TransactionType.UNLINKED_CREDIT, new BigDecimal(10.00));
		creditTransaction.setCreditCard(creditCard);
                creditTransaction.setSolutionField(solution);

		Result<Transaction> result = (Result<Transaction>)merchant
				.postTransaction(creditTransaction);

		Assert.assertNotNull(result);
		if(result.isError()) {
			Assert.assertTrue(result.isError());
			Assert.assertEquals(ResponseCode.ERROR, result.getResponseCode());
		} else if(result.isApproved()) {
			Assert.assertTrue(result.isApproved());
			Assert.assertEquals(ResponseCode.APPROVED, result.getResponseCode());
		}
	}

}

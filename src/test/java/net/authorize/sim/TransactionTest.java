package net.authorize.sim;


import java.util.LinkedHashMap;

import junit.framework.Assert;
import net.authorize.TransactionType;
import net.authorize.UnitTestData;
import net.authorize.data.Customer;
import net.authorize.data.Order;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.sim.button.TextButton;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest extends UnitTestData {

	private Customer customer;
	private Order order;

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
	}

	@Test
	public void createFormWithNoPaymentRequest() {

		// create credit card
		CreditCard creditCard = CreditCard.createCreditCard();
		creditCard.setCreditCardNumber(creditCardNumber);
		creditCard.setExpirationMonth(creditCardExpMonth);
		creditCard.setExpirationYear(creditCardExpYear);

		// create transaction
		Transaction authCaptureTransaction = merchant.createSIMTransaction(
				TransactionType.AUTH_CAPTURE, 1,totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setCreditCard(creditCard);

		String form = authCaptureTransaction.createForm(null, null, TextButton.createButton("submit_button", "Submit"));

		Assert.assertNotNull(form);
		Assert.assertTrue(form.indexOf("FORM") > 0);
		Assert.assertTrue(form.indexOf("INPUT") > 0);
	}

	@Test
	public void createFormWithNoPaymentRequestAndNonHiddenFields() {


		// create credit card
		CreditCard creditCard = CreditCard.createCreditCard();

		// create transaction
		Transaction authCaptureTransaction = merchant.createSIMTransaction(
				TransactionType.AUTH_CAPTURE, 1, totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setCreditCard(creditCard);

		authCaptureTransaction.addFormInput("x_card_num", null);
		authCaptureTransaction.addFormInput("x_exp_date", null);
		authCaptureTransaction.addFormInput("x_zip", null);

		String form = authCaptureTransaction.createForm(null, null, TextButton.createButton("submit_button", "Submit"));

		Assert.assertNotNull(form);
		Assert.assertTrue(form.indexOf("FORM") > 0);
		Assert.assertTrue(form.indexOf("INPUT") > 0);
		Assert.assertTrue(!form.contains("x_card_num"));
		Assert.assertTrue(!form.contains("x_exp_date"));
		Assert.assertTrue(!form.contains("x_zip"));
	}

	@Test
	public void createFormWithPaymentRequest() {

		// create transaction
		Transaction authCaptureTransaction = merchant.createSIMTransaction(
				TransactionType.AUTH_CAPTURE, 1, totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setShowPaymentForm(true);
		authCaptureTransaction.addFieldToRename("x_cust_id", "VIP Customer Id");
		authCaptureTransaction.addFieldToRename("x_last_name", "Sur Name");

		String form = authCaptureTransaction.createForm(null, null, TextButton.createButton("submit_button", "Submit"));

		Assert.assertNotNull(form);
		Assert.assertTrue(form.indexOf("FORM") > 0);
		Assert.assertTrue(form.indexOf("INPUT") > 0);
	}

	@Test
	public void createFormWithCustomFormInputs() {
		// create transaction
		Transaction authCaptureTransaction = merchant.createSIMTransaction(
				TransactionType.AUTH_CAPTURE, 1, totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);

		LinkedHashMap<String,String> input_options = new LinkedHashMap<String, String>();
		input_options.put("type", "text");
		authCaptureTransaction.addFormInput("x_card_num", "<INPUT type=text name=x_card_num></INPUT>");
		authCaptureTransaction.addFormInput("x_exp_date", "<INPUT type=text name=x_exp_date></INPUT>");
		authCaptureTransaction.addFormInput("x_zip", "<INPUT type=text name=x_zip></INPUT>");

		String form = authCaptureTransaction.createForm(null, null, TextButton.createButton("submit_button", "Submit"));

		Assert.assertNotNull(form);
		Assert.assertTrue(form.indexOf("FORM") > 0);
		Assert.assertTrue(form.indexOf("INPUT") > 0);
		Assert.assertTrue(form.indexOf("x_card_num") > 0);
		Assert.assertTrue(form.indexOf("x_exp_date") > 0);
		Assert.assertTrue(form.indexOf("x_zip") > 0);

	}
}

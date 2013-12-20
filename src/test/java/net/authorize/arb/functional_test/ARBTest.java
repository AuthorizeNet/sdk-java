package net.authorize.arb.functional_test;


import java.math.BigDecimal;

import net.authorize.Transaction;
import net.authorize.UnitTestData;
import net.authorize.arb.TransactionType;
import net.authorize.data.Order;
import net.authorize.data.arb.PaymentSchedule;
import net.authorize.data.arb.Subscription;
import net.authorize.data.arb.SubscriptionStatusType;
import net.authorize.data.arb.SubscriptionUnitType;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.echeck.BankAccountType;
import net.authorize.data.echeck.ECheckType;
import net.authorize.data.xml.Address;
import net.authorize.data.xml.BankAccount;
import net.authorize.data.xml.Customer;
import net.authorize.data.xml.Payment;
import net.authorize.arb.Result;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ARBTest extends UnitTestData {

	private static String subscriptionId = null;

	PaymentSchedule new_schedule;
	CreditCard credit_card;
	BankAccount bank_account;
	Subscription subscription;
	Address billing_info;
	Address shipping_info;
	Customer customer;
	Order order;

	@Before
	public void setUp() throws Exception {
		// Create a payment schedule
		//
		new_schedule = PaymentSchedule.createPaymentSchedule();
		new_schedule.setIntervalLength(1);
		new_schedule.setSubscriptionUnit(SubscriptionUnitType.MONTHS);
		new_schedule.setStartDate("2019-01-01");
		new_schedule.setTotalOccurrences(7);
		new_schedule.setTrialOccurrences(0);

		// Create a new credit card
		//
		credit_card = CreditCard.createCreditCard();
		credit_card.setCreditCardNumber(creditCardNumber);
		credit_card.setExpirationDate("2029-07");

		// Create a bank account
		bank_account = BankAccount.createBankAccount();
		bank_account.setBankAccountName(bankAccountName);
		bank_account.setBankAccountNumber(bankAccountNumber);
		bank_account.setBankAccountType(BankAccountType.CHECKING);
		bank_account.setBankName(bankName);
		bank_account.setRoutingNumber(routingNumber);
		bank_account.setECheckType(ECheckType.WEB);

		// Create a billing info
		//
		billing_info = (Address) Address.createAddress();
		billing_info.setFirstName(firstName + System.currentTimeMillis());
		billing_info.setLastName(lastName);

		// Create a shipping info
		//
		shipping_info = (Address) Address.createAddress();
		shipping_info.setFirstName(firstName + System.currentTimeMillis());
		shipping_info.setLastName(lastName);
		shipping_info.setCompany(company);
		shipping_info.setAddress(address);
		shipping_info.setCity(city);
		shipping_info.setState(state);
		shipping_info.setZipPostalCode(zipPostalCode);
		shipping_info.setPhoneNumber(phone);
		shipping_info.setFaxNumber(fax);

		// Create a customer and specify billing info
		//
		customer = Customer.createCustomer();
		customer.setBillTo(billing_info);
		customer.setShipTo(shipping_info);
		customer.setEmail(email);
		customer.setPhoneNumber(phone);

		// Create a subscription and specify payment, schedule and customer
		//
		subscription = Subscription.createSubscription();
		subscription.setPayment(Payment.createPayment(credit_card));
		subscription.setSchedule(new_schedule);
		subscription.setCustomer(customer);
	    subscription.setAmount(new BigDecimal(6.00));
		subscription.setTrialAmount(Transaction.ZERO_AMOUNT);
		subscription.setRefId("REF:" + System.currentTimeMillis());

		// Give this subscription a name
		//
		subscription.setName("Demo Subscription " + System.currentTimeMillis());

		order = Order.createOrder();
		order.setDescription(orderDescription);
		order.setInvoiceNumber(Long.toString(System.currentTimeMillis()));

		subscription.setOrder(order);
	}

	@Test
	public void testCreateSubscriptionCreditCard() {

		// Create a new subscription request from the subscription object
		// Returns XML document. Also holds internal pointer as current_request.
		//
		net.authorize.arb.Transaction transaction =
		  merchant.createARBTransaction(TransactionType.CREATE_SUBSCRIPTION,
					subscription);
		net.authorize.arb.Result<Transaction> result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getResultSubscriptionId());

		subscriptionId = result.getResultSubscriptionId();
	}

	@Test
	public void testUpdateSubscription() {
		credit_card.setCreditCardNumber(creditCardNumber);
		credit_card.setExpirationDate("2029-08");

		subscription = Subscription.createSubscription();
		subscription.setPayment(Payment.createPayment(credit_card));
		subscription.setSubscriptionId(subscriptionId);

		net.authorize.arb.Transaction transaction =
			  merchant.createARBTransaction(TransactionType.UPDATE_SUBSCRIPTION,
						subscription);
		Result<Transaction> result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
	}

	@Test
	public void testGetSubscription() {
		subscription = Subscription.createSubscription();
		subscription.setSubscriptionId(subscriptionId);

		net.authorize.arb.Transaction transaction =
			  merchant.createARBTransaction(TransactionType.GET_SUBSCRIPTION_STATUS,
						subscription);
		Result<Transaction> result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertEquals(SubscriptionStatusType.ACTIVE, result.getSubscriptionStatus());
	}

	@Test
	public void testCancelSubscription() {
		subscription = Subscription.createSubscription();
		subscription.setSubscriptionId(subscriptionId);

		net.authorize.arb.Transaction transaction =
			  merchant.createARBTransaction(TransactionType.CANCEL_SUBSCRIPTION,
						subscription);
		Result<Transaction> result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
	}

	@Test
	public void testGetSubscriptionII() {
		subscription = Subscription.createSubscription();
		subscription.setSubscriptionId(subscriptionId);

		net.authorize.arb.Transaction transaction =
			  merchant.createARBTransaction(TransactionType.GET_SUBSCRIPTION_STATUS,
						subscription);
		Result<Transaction> result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertEquals(SubscriptionStatusType.CANCELED, result.getSubscriptionStatus());
	}

	@Test
	public void testCreateSubscriptionBankAccount() {

		subscription.setPayment(Payment.createPayment(bank_account));
		// Create a new subscription request from the subscription object
		// Returns XML document. Also holds internal pointer as current_request.
		//
		net.authorize.arb.Transaction transaction =
		  merchant.createARBTransaction(TransactionType.CREATE_SUBSCRIPTION,
					subscription);
		Result<Transaction> result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getResultSubscriptionId());

		subscriptionId = result.getResultSubscriptionId();
	}



}

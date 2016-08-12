package net.authorize.arb.functional_test;

import java.math.BigDecimal;
import java.util.Random;
import net.authorize.Environment;
import net.authorize.Merchant;

import net.authorize.Transaction;
import net.authorize.UnitTestData;
import net.authorize.arb.Result;
import net.authorize.arb.TransactionType;
import net.authorize.data.arb.Profile;
import net.authorize.cim.ValidationModeType;
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
import net.authorize.data.xml.CustomerType;
import net.authorize.data.xml.Payment;
import net.authorize.util.XmlUtility;
import net.authorize.data.cim.CustomerProfile;
import net.authorize.data.cim.PaymentProfile;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ARBTest extends UnitTestData {

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
                credit_card.setCardCode("234");                

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
		billing_info = Address.createAddress();
		billing_info.setFirstName(firstName + System.currentTimeMillis());
		billing_info.setLastName(lastName);

		// Create a shipping info
		//
		shipping_info = Address.createAddress();
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
		createCreditCardSubscription();
	}

	@Test
	public void testUpdateSubscription() throws Exception {
		net.authorize.arb.Result<Transaction> result = createCreditCardSubscription();

		String xmlCc = XmlUtility.getXml(credit_card);
		CreditCard newCreditCard = XmlUtility.create(xmlCc,  CreditCard.class);
		newCreditCard.setCreditCardNumber(creditCardNumber);
		newCreditCard.setExpirationDate("2029-08");

		String testSubscriptionId = result.getResultSubscriptionId();
		String xmlSubs = XmlUtility.getXml(subscription);
		Subscription newSubscription = XmlUtility.create(xmlSubs,  Subscription.class);
		newSubscription.setPayment(Payment.createPayment(credit_card));
		newSubscription.setSubscriptionId(testSubscriptionId);

		net.authorize.arb.Transaction transaction = merchant.createARBTransaction(TransactionType.UPDATE_SUBSCRIPTION, newSubscription);
		result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);
		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
	}

	@Test
	public void testGetSubscription() {
		net.authorize.arb.Result<Transaction> result = createCreditCardSubscription();
		String testSubscriptionId = result.getResultSubscriptionId();

		Subscription newSubscription = Subscription.createSubscription();
		newSubscription.setSubscriptionId(testSubscriptionId);

		net.authorize.arb.Transaction transaction = merchant.createARBTransaction(TransactionType.GET_SUBSCRIPTION_STATUS, newSubscription);
		result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertEquals(SubscriptionStatusType.ACTIVE, result.getSubscriptionStatus());
	}

	@Test
	public void testCancelSubscription() {
		net.authorize.arb.Result<Transaction> result = createCreditCardSubscription();
		String testSubscriptionId = result.getResultSubscriptionId();

		Subscription newSubscription = Subscription.createSubscription();
		newSubscription.setSubscriptionId(testSubscriptionId);

		net.authorize.arb.Transaction transaction = merchant.createARBTransaction(TransactionType.CANCEL_SUBSCRIPTION, newSubscription);
		result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);
		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());

		transaction = merchant.createARBTransaction(TransactionType.GET_SUBSCRIPTION_STATUS, newSubscription);
		result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);
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
		net.authorize.arb.Transaction transaction = merchant.createARBTransaction(TransactionType.CREATE_SUBSCRIPTION, subscription);
		Result<Transaction> result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getResultSubscriptionId());
	}

	private net.authorize.arb.Result<Transaction> createCreditCardSubscription() {
		// Create a new subscription request from the subscription object
		//
		subscription.setPayment(Payment.createPayment(credit_card));
		net.authorize.arb.Transaction transaction = merchant.createARBTransaction(TransactionType.CREATE_SUBSCRIPTION, subscription);
		net.authorize.arb.Result<Transaction> result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);
		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getResultSubscriptionId());

		return result;
	}

	@Test
	public void createCimSubscription() throws InterruptedException {
		// Create a new subscription request from the subscription object
		//                
		net.authorize.cim.Transaction transactionCim = merchant.createCIMTransaction(net.authorize.cim.TransactionType.CREATE_CUSTOMER_PROFILE);
                
		transactionCim.setRefId("REF:" + System.currentTimeMillis());

		CustomerProfile customerProfile = CustomerProfile.createCustomerProfile();
		customerProfile.setMerchantCustomerId(Integer.toString(new Random().nextInt(10000)));
		transactionCim.setCustomerProfile(customerProfile);

		PaymentProfile paymentProfile = PaymentProfile.createPaymentProfile();
		paymentProfile.setBillTo(billing_info);
		paymentProfile.setCustomerType(CustomerType.INDIVIDUAL);
		paymentProfile.addPayment(Payment.createPayment(credit_card));
		transactionCim.addPaymentProfile(paymentProfile);
		transactionCim.setValidationMode(ValidationModeType.TEST_MODE);
		net.authorize.cim.Result<Transaction> resultCim = (net.authorize.cim.Result<Transaction>) merchant.postTransaction(transactionCim);
                Profile profile = Profile.createProfile();
		profile.setCustomerProfileId(resultCim.getCustomerProfileId());
		profile.setCustomerPaymentProfileId(resultCim.getCustomerPaymentProfileIdList().get(0));

		subscription.setProfile(profile);
		subscription.setPayment(null);
		subscription.setCustomer(null);
		Thread.sleep(30000); //wait for authorize to create CIM profile
		net.authorize.arb.Transaction transaction = merchant.createARBTransaction(TransactionType.CREATE_SUBSCRIPTION, subscription);
		net.authorize.arb.Result<Transaction> result = (net.authorize.arb.Result<Transaction>)merchant.postTransaction(transaction);
		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getResultSubscriptionId());
	}
}

package net.authorize.aim.cardpresent;

import junit.framework.Assert;
import net.authorize.ResponseCode;
import net.authorize.ResponseReasonCode;
import net.authorize.TransactionType;
import net.authorize.UnitTestData;
import net.authorize.aim.Transaction;
import net.authorize.data.Customer;
import net.authorize.data.Order;
import net.authorize.data.creditcard.AVSCode;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.xml.reporting.CardCodeResponseType;
import net.authorize.util.BasicXmlDocument;

import org.junit.Before;
import org.junit.Test;

public class CardPresentXMLTest extends UnitTestData {

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
	public void testApproval() {

		String xml = "<?xml version=\"1.0\" ?><response><ResponseCode>1</ResponseCode><Messages><Message><Code>1</Code><Description><![CDATA[This transaction has been approved.]]></Description></Message></Messages><AuthCode><![CDATA[ABCD]]></AuthCode><AVSResultCode>P</AVSResultCode><CVVResultCode>M</CVVResultCode><TransID>106707002</TransID><RefTransID>0</RefTransID><TransHash>BC46B890B5495B0FB419DE97CB5DAE9C</TransHash><TestMode>0</TestMode><UserRef>XXYYZZ</UserRef> <splitTenderId>12345</splitTenderId> <PrepaidCard> <RequestedAmount>456.78</RequestedAmount> <ApprovedAmount>123.45</ApprovedAmount> <BalanceOnCard>345.67</BalanceOnCard> </PrepaidCard> </response>";
		BasicXmlDocument xmlResponse = new BasicXmlDocument();
		xmlResponse.parseString(xml);

		CreditCard creditCard = CreditCard.createCreditCard();
		creditCard.setTrack1("%B1234123412341234^CARDUSER/JOHN^030510100000019301000000877000000?");
		creditCard.setTrack2(";1234123412341234=0305101193010877?");

		// create transaction
		Transaction authCaptureTransaction = merchant.createAIMTransaction(TransactionType.AUTH_CAPTURE, totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setCreditCard(creditCard);
		Assert.assertEquals("B1234123412341234^CARDUSER/JOHN^030510100000019301000000877000000", authCaptureTransaction.getCreditCard().getTrack1());
		Assert.assertEquals("1234123412341234=0305101193010877", authCaptureTransaction.getCreditCard().getTrack2());

		net.authorize.aim.cardpresent.Result<net.authorize.aim.Transaction> result =
			(net.authorize.aim.cardpresent.Result<net.authorize.aim.Transaction>) net.authorize.aim.cardpresent.Result.createResult(authCaptureTransaction, xmlResponse);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isApproved());
		Assert.assertEquals(ResponseCode.APPROVED, result.getResponseCode());
		Assert.assertEquals("This transaction has been approved.", result.getResponseCode().getDescription());
		Assert.assertEquals(1, result.getResponseReasonCodes().size());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1, result.getResponseReasonCodes().get(0));
		Assert.assertEquals("This transaction has been approved.", result.getResponseReasonCodes().get(0).getReasonText());
		Assert.assertEquals("ABCD", result.getAuthCode());
		Assert.assertEquals(AVSCode.P, result.getTarget().getCreditCard().getAvsCode());
		Assert.assertEquals(CardCodeResponseType.M, result.getCardCodeResponse());
		Assert.assertEquals("106707002", result.getTransId());
		Assert.assertEquals("0", result.getRefTransId());
		Assert.assertEquals("BC46B890B5495B0FB419DE97CB5DAE9C", result.getTransHash());
		Assert.assertFalse(result.isAuthorizeNet());
		Assert.assertFalse(result.isTestMode());
		Assert.assertEquals("XXYYZZ", result.getUserRef());
		
		Assert.assertNotNull( result.getSplitTenderId());
		Assert.assertEquals("12345",result.getSplitTenderId());
		
		net.authorize.aim.cardpresent.functional_test.SimpleAuthCaptureTest.AssertPrepaidCard( result.getPrepaidCard());
	}

	@Test
	public void testDecline() {

		String xml = "<?xml version=\"1.0\" ?> <response> <ResponseCode>2</ResponseCode> <Errors> <Error> <ErrorCode>2</ErrorCode> <ErrorText><![CDATA[This transaction has been declined.]]></ErrorText> </Error> </Errors> <AuthCode><![CDATA[]]></AuthCode> <AVSResultCode>P</AVSResultCode> <CVVResultCode></CVVResultCode> <TransID>106707003</TransID> <RefTransID>0</RefTransID> <TransHash>4852F60CD7D22CB31E98397E6F20673E</TransHash> <TestMode>0</TestMode> <UserRef></UserRef> </response>";
		BasicXmlDocument xmlResponse = new BasicXmlDocument();
		xmlResponse.parseString(xml);

		CreditCard creditCard = CreditCard.createCreditCard();
		creditCard.setTrack1("%B1234123412341234^CARDUSER/JOHN^030510100000019301000000877000000?");
		creditCard.setTrack2(";1234123412341234=0305101193010877?");

		// create transaction
		Transaction authCaptureTransaction = merchant.createAIMTransaction(
				TransactionType.AUTH_CAPTURE, totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setCreditCard(creditCard);

		net.authorize.aim.cardpresent.Result<net.authorize.aim.Transaction> result =
			(net.authorize.aim.cardpresent.Result<net.authorize.aim.Transaction>) net.authorize.aim.cardpresent.Result.createResult(authCaptureTransaction, xmlResponse);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isDeclined());
		Assert.assertEquals(ResponseCode.DECLINED, result.getResponseCode());
		Assert.assertEquals(1, result.getResponseReasonCodes().size());
		Assert.assertEquals(ResponseReasonCode.RRC_2_2, result.getResponseReasonCodes().get(0));
		Assert.assertEquals("This transaction has been declined.", result.getResponseReasonCodes().get(0).getReasonText());
		Assert.assertEquals("", result.getAuthCode());
		Assert.assertEquals(AVSCode.P, result.getTarget().getCreditCard().getAvsCode());
		Assert.assertEquals(null, result.getCardCodeResponse());
		Assert.assertEquals("106707003", result.getTransId());
		Assert.assertEquals("0", result.getRefTransId());
		Assert.assertEquals("4852F60CD7D22CB31E98397E6F20673E", result.getTransHash());
		Assert.assertFalse(result.isAuthorizeNet());
		Assert.assertFalse(result.isTestMode());
		Assert.assertEquals(null, result.getUserRef());
	}

	@Test
	public void testError() {

		String xml = "<?xml version=\"1.0\" ?> <response> <ResponseCode>3</ResponseCode> <Errors> <Error> <ErrorCode>33</ErrorCode> <ErrorText><![CDATA[Credit card number is required.]]></ErrorText> </Error> <Error> <ErrorCode>5</ErrorCode> <ErrorText><![CDATA[A valid amount is required.]]></ErrorText> </Error> </Errors> <AuthCode><![CDATA[]]></AuthCode> <AVSResultCode>P</AVSResultCode> <CVVResultCode></CVVResultCode> <TransID>0</TransID> <RefTransID>0</RefTransID> <TransHash>B663878ED0F52E88168B30DBACE92D47</TransHash> <TestMode>1</TestMode> <UserRef></UserRef> </response>";
		BasicXmlDocument xmlResponse = new BasicXmlDocument();
		xmlResponse.parseString(xml);

		CreditCard creditCard = CreditCard.createCreditCard();
		creditCard.setTrack1("%B1234123412341234^CARDUSER/JOHN^030510100000019301000000877000000?");
		creditCard.setTrack2(";1234123412341234=0305101193010877?");

		// create transaction
		Transaction authCaptureTransaction = merchant.createAIMTransaction(
				TransactionType.AUTH_CAPTURE, totalAmount);
		authCaptureTransaction.setCustomer(customer);
		authCaptureTransaction.setOrder(order);
		authCaptureTransaction.setCreditCard(creditCard);

		net.authorize.aim.cardpresent.Result<net.authorize.aim.Transaction> result =
			(net.authorize.aim.cardpresent.Result<net.authorize.aim.Transaction>) net.authorize.aim.cardpresent.Result.createResult(authCaptureTransaction, xmlResponse);

		Assert.assertNotNull(result);
		Assert.assertTrue(result.isError());
		Assert.assertEquals(ResponseCode.ERROR, result.getResponseCode());
		Assert.assertEquals(2, result.getResponseReasonCodes().size());
		Assert.assertEquals(ResponseReasonCode.RRC_3_33, result.getResponseReasonCodes().get(0));
		Assert.assertEquals("Credit card number is required.", result.getResponseReasonCodes().get(0).getReasonText());
		Assert.assertEquals(ResponseReasonCode.RRC_3_5, result.getResponseReasonCodes().get(1));
		Assert.assertEquals("A valid amount is required.", result.getResponseReasonCodes().get(1).getReasonText());
		Assert.assertEquals("", result.getAuthCode());
		Assert.assertEquals(AVSCode.P, result.getTarget().getCreditCard().getAvsCode());
		Assert.assertEquals(null, result.getCardCodeResponse());
		Assert.assertEquals("0", result.getTransId());
		Assert.assertEquals("0", result.getRefTransId());
		Assert.assertEquals("B663878ED0F52E88168B30DBACE92D47", result.getTransHash());
		Assert.assertFalse(result.isAuthorizeNet());
		Assert.assertTrue(result.isTestMode());
		Assert.assertEquals(null, result.getUserRef());
	}

}

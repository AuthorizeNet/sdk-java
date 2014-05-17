package net.authorize.reporting;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import net.authorize.ResponseCode;
import net.authorize.ResponseReasonCode;
import net.authorize.Transaction;
import net.authorize.UnitTestData;
import net.authorize.data.Order;
import net.authorize.data.OrderItem;
import net.authorize.data.ShippingCharges;
import net.authorize.data.creditcard.AVSCode;
import net.authorize.data.creditcard.CardType;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.echeck.ECheckType;
import net.authorize.data.reporting.ReturnedItem;
import net.authorize.data.reporting.Solution;
import net.authorize.data.reporting.Subscription;
import net.authorize.data.xml.Address;
import net.authorize.data.xml.BankAccount;
import net.authorize.data.xml.Customer;
import net.authorize.data.xml.CustomerType;
import net.authorize.data.xml.Payment;
import net.authorize.data.xml.reporting.BatchDetails;
import net.authorize.data.xml.reporting.BatchStatistics;
import net.authorize.data.xml.reporting.CAVVResponseType;
import net.authorize.data.xml.reporting.CardCodeResponseType;
import net.authorize.data.xml.reporting.FDSFilter;
import net.authorize.data.xml.reporting.FDSFilterActionType;
import net.authorize.data.xml.reporting.ReportingDetails;
import net.authorize.data.xml.reporting.ReportingTransactionType;
import net.authorize.data.xml.reporting.SettlementStateType;
import net.authorize.data.xml.reporting.TransactionDetails;
import net.authorize.data.xml.reporting.TransactionStatusType;
import net.authorize.util.BasicXmlDocument;
import net.authorize.util.DateUtil;
import net.authorize.util.XmlUtility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReportingTest extends UnitTestData {

	Random randomGenerator = null;
	
	@Before
	public void setup()
	{
		randomGenerator = new SecureRandom();
	}

	static final Date now = Calendar.getInstance().getTime();
	static final String dateUtcString = DateUtil.getFormattedDate(now, ReportingDetails.DATE_FORMAT);
	static Date dateLocal = null;

	static ArrayList<ReturnedItem> returnedItems = new ArrayList<ReturnedItem>();
	static ReturnedItem returnedItemOne = null;
	static ReturnedItem returnedItemTwo = null;
	static Solution solution = null;
	static Subscription subscriptionOne = null; 
	static Subscription subscriptionTwo = null;	
	
	static String subscriptionOneString = null;
	static String subscriptionTwoString = null;
	static String solutionString = null;
	static String returnedItemOneString = null;
	static String returnedItemTwoString = null;
	static String returnedItemsString = null;

	static String paymentMethodString = null;
	static String marketTypeString = null;
	static String productString = null;
	static String hasReturnedItemsString = null;

	static {
		Calendar currentCalender = Calendar.getInstance();
		currentCalender.add(Calendar.HOUR_OF_DAY, -3);
		dateLocal = currentCalender.getTime();

		subscriptionOne = Subscription.createSubscription( 10, 101);
		subscriptionTwo = Subscription.createSubscription( 20, 202);
		subscriptionOneString = XmlUtility.getRootElementXml( subscriptionOne);//" <subscription> <id>10</id> <payNum>101</payNum> </subscription> ";
		subscriptionTwoString = XmlUtility.getRootElementXml( subscriptionTwo);//" <subscription> <id>20</id> <payNum>202</payNum> </subscription> ";

		hasReturnedItemsString = String.format( "<%1$s> %2$b </%1$s>", "hasReturnedItems", true);

		solution = Solution.createSolution( "10", "SolutionName10");
		solutionString = XmlUtility.getRootElementXml( solution);

		returnedItemOne = ReturnedItem.createReturnedItem( "10", now, dateLocal, "RI:1", "ReturnedItem:10");
		returnedItemTwo = ReturnedItem.createReturnedItem( "20", now, dateLocal, "RI:2", "ReturnedItem:20");
		returnedItems.add(returnedItemOne);
		returnedItems.add(returnedItemTwo);
		returnedItemOneString = XmlUtility.getRootElementXml( returnedItemOne);
		returnedItemTwoString = XmlUtility.getRootElementXml( returnedItemTwo);
		returnedItemsString = String.format( "<returnedItems>%s%s</returnedItems>", returnedItemOneString, returnedItemTwoString);
		
		paymentMethodString = String.format( "<%1$s> x%1$sx </%1$s>", "paymentMethod");
		marketTypeString = String.format( "<%1$s> x%1$sx </%1$s>", "marketType");
		productString = String.format( "<%1$s> x%1$sx </%1$s>", "product");
	}
	
	@Test
	public void getSettledBatchListRequestMock() {

		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <getSettledBatchListResponse xmlns=\"AnetApi/xml/v1/schema/ AnetApiSchema.xsd\"> <messages> <resultCode>Ok</resultCode> <message> <code>I00001</code> <text>Successful.</text> </message> </messages> <batchList> <batch> <batchId>12345678</batchId> <settlementTimeUTC>2010-05-30T09:00:00</settlementTimeUTC> <settlementTimeLocal>2010-05-30T03:00:00</settlementTimeLocal> <settlementState>settledSuccessfully</settlementState> " + marketTypeString + productString + " <statistics> <statistic> <accountType>Visa</accountType> <!-- accountTypeEnum --> <chargeAmount>200.00</chargeAmount> <chargeCount>13</chargeCount> <refundAmount>10.00</refundAmount> <refundCount>1</refundCount> <voidCount>2</voidCount> <declineCount>4</declineCount> <errorCount>6</errorCount> <returnedItemAmount>0.00</returnedItemAmount> <returnedItemCount>0</returnedItemCount> <chargebackAmount>0.00</chargebackAmount> <chargebackCount>0</chargebackCount> <correctionNoticeCount>0</correctionNoticeCount> <chargeChargeBackAmount>0.00</chargeChargeBackAmount> <chargeChargeBackCount>0</chargeChargeBackCount> <refundChargeBackAmount>0.00</refundChargeBackAmount> <refundChargeBackCount>0</refundChargeBackCount> <chargeReturnedItemsAmount>0.00</chargeReturnedItemsAmount> <chargeReturnedItemsCount>0</chargeReturnedItemsCount> <refundReturnedItemsAmount>0.00</refundReturnedItemsAmount> <refundReturnedItemsCount>0</refundReturnedItemsCount> </statistic> <statistic> <accountType>MasterCard</accountType> <chargeAmount>200.00</chargeAmount> <chargeCount>13</chargeCount> <refundAmount>10.00</refundAmount> <refundCount>1</refundCount> <voidCount>2</voidCount> <declineCount>4</declineCount> <errorCount>6</errorCount> <chargebackAmount>0.00</chargebackAmount> <chargebackCount>0</chargebackCount> <correctionNoticeCount>0</correctionNoticeCount> <chargeChargeBackAmount>0.00</chargeChargeBackAmount> <chargeChargeBackCount>0</chargeChargeBackCount> <refundChargeBackAmount>0.00</refundChargeBackAmount> <refundChargeBackCount>0</refundChargeBackCount> </statistic> </statistics> </batch> <batch> <batchId>23456789</batchId> <settlementTimeUTC>2010-05-30T09:00:00</settlementTimeUTC> <settlementTimeLocal>2010-05-30T03:00:00</settlementTimeLocal> <settlementState>settledSuccessfully</settlementState> " + marketTypeString + productString + " <statistics> <statistic> <accountType>eCheck</accountType> <chargeAmount>200.00</chargeAmount> <chargeCount>13</chargeCount> <refundAmount>10.00</refundAmount> <refundCount>1</refundCount> <voidCount>2</voidCount> <declineCount>4</declineCount> <errorCount>6</errorCount> <returnedItemAmount>0.00</returnedItemAmount> <returnedItemCount>0</returnedItemCount> <correctionNoticeCount>0</correctionNoticeCount> <chargeReturnedItemsAmount>0.00</chargeReturnedItemsAmount> <chargeReturnedItemsCount>0</chargeReturnedItemsCount> <refundReturnedItemsAmount>0.00</refundReturnedItemsAmount> <refundReturnedItemsCount>0</refundReturnedItemsCount> </statistic> </statistics> </batch> </batchList> </getSettledBatchListResponse>";
		BasicXmlDocument xmlResponse = new BasicXmlDocument();
		xmlResponse.parseString(xml);

		//batch list request
		net.authorize.reporting.Transaction transaction =
		  merchant.createReportingTransaction(TransactionType.GET_SETTLED_BATCH_LIST);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		reportingDetails.setBatchIncludeStatistics(true);
		transaction.setReportingDetails(reportingDetails);

		net.authorize.reporting.Result<net.authorize.reporting.Transaction> result =
			(net.authorize.reporting.Result<net.authorize.reporting.Transaction>) net.authorize.reporting.Result.createResult(transaction, xmlResponse);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getReportingDetails().getBatchDetailsList());
		Assert.assertEquals(2, result.getReportingDetails().getBatchDetailsList().size());
		BatchDetails batchDetail = result.getReportingDetails().getBatchDetailsList().get(0);
		Assert.assertNotNull(batchDetail);
		Assert.assertEquals("12345678", batchDetail.getBatchId());
		Assert.assertEquals(SettlementStateType.SETTLED_SUCCESSFULLY, batchDetail.getSettlementState());
		Assert.assertEquals("Sun May 30 03:00:00 PDT 2010",batchDetail.getSettlementTimeLocal().toString());
		Assert.assertEquals("Sun May 30 09:00:00 PDT 2010",batchDetail.getSettlementTimeUTC().toString());
		Assert.assertEquals(null,batchDetail.getPaymentMethod());
		Assert.assertNotNull(batchDetail.getMarketType());
		Assert.assertNotNull(batchDetail.getProduct());
		
		Assert.assertEquals(2, batchDetail.getBatchStatisticsList().size());
		int num = 0;
		for(BatchStatistics batchStat :batchDetail.getBatchStatisticsList()) {
			num++;
			if(num == 1) {
				Assert.assertEquals(CardType.VISA,batchStat.getAccountType());
			} else if (num == 2) {
				Assert.assertEquals(CardType.MASTER_CARD, batchStat.getAccountType());
			}
			Assert.assertEquals(new BigDecimal(200.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getChargeAmount());
			Assert.assertEquals(13, batchStat.getChargeCount());
			Assert.assertEquals(new BigDecimal(10.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getRefundAmount());
			Assert.assertEquals(1, batchStat.getRefundCount());
			Assert.assertEquals(2, batchStat.getVoidCount());
			Assert.assertEquals(4, batchStat.getDeclineCount());
			Assert.assertEquals(6, batchStat.getErrorCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getReturnedItemAmount());
			Assert.assertEquals(0,batchStat.getReturnedItemCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getChargebackAmount());
			Assert.assertEquals(0,batchStat.getChargebackCount());
			Assert.assertEquals(0, batchStat.getCorrectionNoticeCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getChargeChargebackAmount());
			Assert.assertEquals(0,batchStat.getChargeChargebackCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getRefundChargebackAmount());
			Assert.assertEquals(0,batchStat.getRefundChargebackCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getChargeReturnedItemsAmount());
			Assert.assertEquals(0,batchStat.getChargeReturnedItemsCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getRefundReturnedItemsAmount());
			Assert.assertEquals(0, batchStat.getRefundReturnedItemsCount());
		}

		batchDetail = result.getReportingDetails().getBatchDetailsList().get(1);
		Assert.assertNotNull(batchDetail);
		Assert.assertEquals("23456789", batchDetail.getBatchId());
		Assert.assertEquals(SettlementStateType.SETTLED_SUCCESSFULLY, batchDetail.getSettlementState());
		Assert.assertEquals("Sun May 30 03:00:00 PDT 2010",batchDetail.getSettlementTimeLocal().toString());
		Assert.assertEquals("Sun May 30 09:00:00 PDT 2010",batchDetail.getSettlementTimeUTC().toString());
		Assert.assertNull(batchDetail.getPaymentMethod());
		Assert.assertNotNull(batchDetail.getMarketType());
		Assert.assertNotNull(batchDetail.getProduct());

		Assert.assertEquals(1, batchDetail.getBatchStatisticsList().size());
		BatchStatistics batchStat = batchDetail.getBatchStatisticsList().get(0);
		Assert.assertEquals(CardType.ECHECK, batchStat.getAccountType());
		Assert.assertEquals(new BigDecimal(200.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
				batchStat.getChargeAmount());
		Assert.assertEquals(13, batchStat.getChargeCount());
		Assert.assertEquals(new BigDecimal(10.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
				batchStat.getRefundAmount());
		Assert.assertEquals(1, batchStat.getRefundCount());
		Assert.assertEquals(2, batchStat.getVoidCount());
		Assert.assertEquals(4, batchStat.getDeclineCount());
		Assert.assertEquals(6, batchStat.getErrorCount());
		Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
				batchStat.getReturnedItemAmount());
		Assert.assertEquals(0,batchStat.getReturnedItemCount());
		Assert.assertEquals(0, batchStat.getCorrectionNoticeCount());
		Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
				batchStat.getChargeReturnedItemsAmount());
		Assert.assertEquals(0,batchStat.getChargeReturnedItemsCount());
		Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
				batchStat.getRefundReturnedItemsAmount());
		Assert.assertEquals(0, batchStat.getRefundReturnedItemsCount());
	}

	@Test
	public void getTransactionListRequestMock() {
		
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <getTransactionListResponse xmlns=\"AnetApi/xml/v1/schema/AnetApiSchema.xsd\"> <messages> <resultCode>Ok</resultCode> <message> <code>I00001</code> <text>Successful.</text> </message> </messages> <transactions> <transaction> <transId>12345</transId> <submitTimeUTC>2009-05-30T09:00:00</submitTimeUTC> <submitTimeLocal>2009-05-30T04:00:00</submitTimeLocal> <transactionStatus>settledSuccessfully</transactionStatus> <invoiceNumber>INV00001</invoiceNumber> <firstName>John</firstName> <lastName>Doe</lastName> <settleAmount>2.00</settleAmount> <accountType>Visa</accountType> <accountNumber>XXXX1111</accountNumber> " + subscriptionOneString + hasReturnedItemsString + " </transaction> <transaction> <transId>12345</transId> <submitTimeUTC>2009-05-30T09:00:00</submitTimeUTC> <submitTimeLocal>2009-05-30T04:00:00</submitTimeLocal> <transactionStatus>settledSuccessfully</transactionStatus> <invoiceNumber>INV00001</invoiceNumber> <firstName>John</firstName> <lastName>Doe</lastName> <settleAmount>2.00</settleAmount> <accountType>Visa</accountType> <accountNumber>XXXX1111</accountNumber> " + subscriptionTwoString + hasReturnedItemsString + " </transaction> </transactions> </getTransactionListResponse>";
		BasicXmlDocument xmlResponse = new BasicXmlDocument();
		xmlResponse.parseString(xml);

		net.authorize.reporting.Transaction transaction =
			  merchant.createReportingTransaction(TransactionType.GET_TRANSACTION_LIST);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		transaction.setReportingDetails(reportingDetails);

		net.authorize.reporting.Result<net.authorize.reporting.Transaction> result =
			(net.authorize.reporting.Result<net.authorize.reporting.Transaction>) net.authorize.reporting.Result.createResult(transaction, xmlResponse);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getReportingDetails().getTransactionDetailList());
		Assert.assertTrue(result.getReportingDetails().getTransactionDetailList().size() > 0);
		int count = 0;
		for(TransactionDetails transactionDetail : result.getReportingDetails().getTransactionDetailList()) {
			Assert.assertEquals("12345", transactionDetail.getTransId());
			Assert.assertEquals("Sat May 30 04:00:00 PDT 2009",transactionDetail.getSubmitTimeLocal().toString());
			Assert.assertEquals("Sat May 30 09:00:00 PDT 2009",transactionDetail.getSubmitTimeUTC().toString());
			Assert.assertEquals(TransactionStatusType.SETTLED_SUCCESSFULLY, transactionDetail.getTransactionStatus());
			Assert.assertEquals("INV00001", transactionDetail.getInvoiceNumber());
			Assert.assertEquals("John", transactionDetail.getFirstName());
			Assert.assertEquals("Doe", transactionDetail.getLastName());
			Assert.assertEquals("XXXX1111", transactionDetail.getAccountNumber());
			Assert.assertEquals(CardType.VISA, transactionDetail.getAccountType());
			Assert.assertEquals(new BigDecimal(2.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					transactionDetail.getSettleAmount());

			Assert.assertEquals(true, transactionDetail.isHasReturnedItems());
			AssertSubscription( ++count, transactionDetail);
			Assert.assertNull( transactionDetail.getSolution());
			Assert.assertNull( transactionDetail.getReturnedItems());
		}
	}

	@Test
	public void getTransactionDetailsRequestMock() {

		String xml = "<?xml version=\"1.0\"?> <getTransactionDetailsResponse xmlns:xsi=\"http://www.w3.org/2001/ XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"AnetApi/xml/v1/schema/AnetApiSchema.xsd\"> <messages> <resultCode>Ok</resultCode> <message> <code>I00001</code> <text>Successful.</text> </message> </messages> <transaction> <transId>12345</transId> <refTransId>12345</refTransId> <splitTenderId>12345</splitTenderId> <submitTimeUTC>2010-08-30T17:49:20.757Z</submitTimeUTC> <submitTimeLocal>2010-08-30T13:49:20.757</submitTimeLocal> <transactionType>authOnlyTransaction</transactionType> <transactionStatus>settledSuccessfully</transactionStatus> <responseCode>1</responseCode> <responseReasonCode>1</responseReasonCode> <responseReasonDescription>Approval</responseReasonDescription> <authCode>000000</authCode> <AVSResponse>X</AVSResponse> <cardCodeResponse>M</cardCodeResponse> <CAVVResponse>2</CAVVResponse> <FDSFilterAction>authAndHold</FDSFilterAction> <FDSFilters> <FDSFilter> <name>Hourly Velocity Filter</name> <action>authAndHold</action> </FDSFilter> <FDSFilter> <name>Amount Filter</name> <action>report</action> </FDSFilter> </FDSFilters> <batch> <batchId>12345</batchId> <settlementTimeUTC>2010-08-30T17:49:20.757Z</settlementTimeUTC> <settlementTimeLocal>2010-08-30T13:49:20.757</settlementTimeLocal> <settlementState>settledSuccessfully</settlementState>  </batch> <order> <invoiceNumber>INV00001</invoiceNumber> <description>some description</description> <purchaseOrderNumber>PO000001</purchaseOrderNumber> </order> <requestedAmount>5.00</requestedAmount> <authAmount>2.00</authAmount> <settleAmount>2.00</settleAmount> <tax> <amount>1.00</amount> <name>WA state sales tax</name> <description>Washington state sales tax</description> </tax> <shipping> <amount>2.00</amount> <name>ground based shipping</name> <description>Ground based 5 to 10 day shipping</description> </shipping> <duty> <amount>1.00</amount> </duty> <lineItems> <lineItem> <itemId>ITEM00001</itemId> <name>name of item sold</name> <description>Description of item sold</description> <quantity>1</quantity> <unitPrice>6.95</unitPrice> <taxable>true</taxable> </lineItem> <lineItem> <itemId>ITEM00001</itemId> <name>name of item sold</name> <description>Description of item sold</description> <quantity>1</quantity> <unitPrice>6.95</unitPrice> <taxable>true</taxable> </lineItem> </lineItems> <prepaidBalanceRemaining>30.00</prepaidBalanceRemaining> <taxExempt>false</taxExempt> <payment><bankAccount> <routingNumber>XXXX0000</routingNumber> <accountNumber>XXXX0000</accountNumber> <nameOnAccount>John Doe</nameOnAccount> <echeckType>WEB</echeckType> </bankAccount> </payment> <customer> <type>individual</type> <id>ABC00001</id> <email>mark@example.com</email> </customer> <billTo> <firstName>John</firstName> <lastName>Doe</lastName> <company/> <address>123 Main St.</address> <city>Bellevue</city> <state>WA</state> <zip>98004</zip> <country>USA</country> <phoneNumber>000-000-0000</phoneNumber> <faxNumber/> </billTo> <shipTo> <firstName>John</firstName> <lastName>Doe</lastName> <company/> <address>123 Main St.</address> <city>Bellevue</city> <state>WA</state> <zip>98004</zip> <country>USA</country> </shipTo> <recurringBilling>false</recurringBilling> <customerIP>0.0.0.0</customerIP> " + subscriptionOneString + returnedItemsString + solutionString + " </transaction> </getTransactionDetailsResponse>";
		BasicXmlDocument xmlResponse = new BasicXmlDocument();
		xmlResponse.parseString(xml);

		net.authorize.reporting.Transaction transaction = merchant
				.createReportingTransaction(TransactionType.GET_TRANSACTION_DETAILS);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		reportingDetails.setTransactionId("12345");
		transaction.setReportingDetails(reportingDetails);

		net.authorize.reporting.Result<net.authorize.reporting.Transaction> result =
			(net.authorize.reporting.Result<net.authorize.reporting.Transaction>) net.authorize.reporting.Result.createResult(transaction, xmlResponse);
		Assert.assertNotNull(result.getReportingDetails().getTransactionDetailList());
		Assert.assertTrue(result.getReportingDetails().getTransactionDetailList().size() == 1);
		TransactionDetails transactionDetail = result.getReportingDetails().getTransactionDetailList().get(0);
		Assert.assertEquals("12345",transactionDetail.getTransId());
		Assert.assertEquals("12345",transactionDetail.getRefTransId());
		Assert.assertEquals("12345",transactionDetail.getSplitTenderId());
		Assert.assertEquals("Mon Aug 30 17:49:20 PDT 2010",transactionDetail.getSubmitTimeUTC().toString());
		Assert.assertEquals("Mon Aug 30 13:49:20 PDT 2010",transactionDetail.getSubmitTimeLocal().toString());
		Assert.assertEquals(ReportingTransactionType.AUTH_ONLY,transactionDetail.getTransactionType());
		Assert.assertEquals(TransactionStatusType.SETTLED_SUCCESSFULLY,transactionDetail.getTransactionStatus());
		Assert.assertEquals(ResponseCode.APPROVED,transactionDetail.getResponseCode());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1,transactionDetail.getResponseReasonCode());
		Assert.assertEquals("Approval", transactionDetail.getResponseReasonCode().getReasonText());
		Assert.assertEquals("000000",transactionDetail.getAuthCode());
		Assert.assertEquals(AVSCode.X,transactionDetail.getAvsResponse());
		Assert.assertEquals(CardCodeResponseType.M,transactionDetail.getCardCodeResponse());
		Assert.assertEquals(CAVVResponseType.CAVV_2,transactionDetail.getCAVVResponse());
		Assert.assertEquals(FDSFilterActionType.AUTH_AND_HOLD,transactionDetail.getFDSFilterAction());
		Assert.assertEquals(2, transactionDetail.getFDSFilterList().size());
		// fds - 1
		FDSFilter fdsFilter = transactionDetail.getFDSFilterList().get(0);
		Assert.assertEquals("Hourly Velocity Filter", fdsFilter.getName());
		Assert.assertEquals(FDSFilterActionType.AUTH_AND_HOLD, fdsFilter.getAction());
		// fds - 2
		fdsFilter = transactionDetail.getFDSFilterList().get(1);
		Assert.assertEquals("Amount Filter", fdsFilter.getName());
		Assert.assertEquals(FDSFilterActionType.REPORT, fdsFilter.getAction());
		// batch
		BatchDetails batch = transactionDetail.getBatch();
		Assert.assertNotNull(batch);
		Assert.assertEquals("12345", batch.getBatchId());
		Assert.assertEquals("Mon Aug 30 17:49:20 PDT 2010", batch.getSettlementTimeUTC().toString());
		Assert.assertEquals("Mon Aug 30 13:49:20 PDT 2010", batch.getSettlementTimeLocal().toString());
		Assert.assertEquals(SettlementStateType.SETTLED_SUCCESSFULLY, batch.getSettlementState());
		Assert.assertEquals(null, batch.getPaymentMethod());
		Assert.assertNull(batch.getMarketType());
		Assert.assertNull(batch.getProduct());
		
		// order
		Order order = transactionDetail.getOrder();
		Assert.assertNotNull(order);
		Assert.assertEquals("INV00001", order.getInvoiceNumber());
		Assert.assertEquals("some description", order.getDescription());
		Assert.assertEquals("PO000001", order.getPurchaseOrderNumber());
		// requested amount
		Assert.assertEquals(new BigDecimal(5.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), transactionDetail.getRequestedAmount());
		// auth amount
		Assert.assertEquals(new BigDecimal(2.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), transactionDetail.getAuthAmount());
		// settle amount
		Assert.assertEquals(new BigDecimal(2.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), transactionDetail.getSettleAmount());
		ShippingCharges taxShipDutyCharges = order.getShippingCharges();
		Assert.assertNotNull(taxShipDutyCharges);
		// tax
		Assert.assertEquals(new BigDecimal(1.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), taxShipDutyCharges.getTaxAmount());
		Assert.assertEquals("WA state sales tax", taxShipDutyCharges.getTaxItemName());
		Assert.assertEquals("Washington state sales tax", taxShipDutyCharges.getTaxDescription());
		// ship
		Assert.assertEquals(new BigDecimal(2.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), taxShipDutyCharges.getFreightAmount());
		Assert.assertEquals("ground based shipping", taxShipDutyCharges.getFreightItemName());
		Assert.assertEquals("Ground based 5 to 10 day shipping", taxShipDutyCharges.getFreightDescription());
		// duty
		Assert.assertEquals(new BigDecimal(1.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), taxShipDutyCharges.getDutyAmount());
		Assert.assertNull(taxShipDutyCharges.getDutyItemName());
		Assert.assertNull(taxShipDutyCharges.getDutyItemDescription());
		// line items
		Assert.assertEquals(2, order.getOrderItems().size());
		for(OrderItem orderItem : order.getOrderItems()) {
			Assert.assertNotNull(orderItem);
			Assert.assertEquals("ITEM00001", orderItem.getItemId());
			Assert.assertEquals("name of item sold", orderItem.getItemName());
			Assert.assertEquals("Description of item sold", orderItem.getItemDescription());
			Assert.assertEquals(new BigDecimal(1).setScale(Transaction.QUANTITY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), orderItem.getItemQuantity());
			Assert.assertEquals(new BigDecimal(6.95).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), orderItem.getItemPrice());
			Assert.assertTrue(orderItem.isItemTaxable());
		}
		// prepaid balance
		Assert.assertEquals(new BigDecimal(30.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), transactionDetail.getPrepaidBalanceRemaining());
		Assert.assertFalse(transactionDetail.isItemTaxExempt());
		// payment
		Payment payment = transactionDetail.getPayment();
		Assert.assertNotNull(payment);
		BankAccount bankAccount = payment.getBankAccount();
		Assert.assertNotNull(bankAccount);
		Assert.assertEquals("XXXX0000", bankAccount.getRoutingNumber());
		Assert.assertEquals("XXXX0000", bankAccount.getBankAccountNumber());
		Assert.assertEquals("John Doe", bankAccount.getBankAccountName());
		Assert.assertEquals(ECheckType.WEB, bankAccount.getECheckType());
		// customer
		Customer customer = transactionDetail.getCustomer();
		Assert.assertNotNull(customer);
		Assert.assertEquals(CustomerType.INDIVIDUAL, customer.getCustomerType());
		Assert.assertEquals("ABC00001", customer.getId());
		Assert.assertEquals("mark@example.com", customer.getEmail());
		// billto
		Address billToAddress = customer.getBillTo();
		Assert.assertNotNull(billToAddress);
		Assert.assertEquals("John", billToAddress.getFirstName());
		Assert.assertEquals("Doe", billToAddress.getLastName());
		Assert.assertNull(billToAddress.getCompany());
		Assert.assertEquals("123 Main St.", billToAddress.getAddress());
		Assert.assertEquals("Bellevue", billToAddress.getCity());
		Assert.assertEquals("WA", billToAddress.getState());
		Assert.assertEquals("98004", billToAddress.getZipPostalCode());
		Assert.assertEquals("USA", billToAddress.getCountry());
		Assert.assertEquals("000-000-0000", billToAddress.getPhoneNumber());
		Assert.assertNull(billToAddress.getFaxNumber());
		// shipto
		Address shipToAddress = customer.getShipTo();
		Assert.assertNotNull(shipToAddress);
		Assert.assertEquals("John", shipToAddress.getFirstName());
		Assert.assertEquals("Doe", shipToAddress.getLastName());
		Assert.assertNull(shipToAddress.getCompany());
		Assert.assertEquals("123 Main St.", shipToAddress.getAddress());
		Assert.assertEquals("Bellevue", shipToAddress.getCity());
		Assert.assertEquals("WA", shipToAddress.getState());
		Assert.assertEquals("98004", shipToAddress.getZipPostalCode());
		Assert.assertEquals("USA", shipToAddress.getCountry());
		// recurring billing
		Assert.assertFalse(transactionDetail.isRecurringBilling());
		Assert.assertEquals("0.0.0.0", transactionDetail.getCustomerIP());
		
		//subscription
		int count = 0; 
		Assert.assertFalse(transactionDetail.isHasReturnedItems());
		AssertSubscription( ++count, transactionDetail);
		AssertSolution( transactionDetail);
		//TODO count check
		AssertReturnedItems( 1, transactionDetail);
	}

	@Test
	public void getBatchStatisticsRequestRequestMock() {

		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <getBatchStatisticsResponse xmlns:xsi=\"http://www.w3.org/2001/ XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"AnetApi/xml/v1/schema/AnetApiSchema.xsd\"> <messages> <resultCode>Ok</resultCode> <message> <code>I00001</code> <text>Successful.</text> </message> </messages> <batch> <batchId>24</batchId> <settlementTimeUTC>2011-01-13T20:58:33Z</settlementTimeUTC> <settlementTimeLocal>2011-01-13T12:58:33</settlementTimeLocal> <settlementState>settledSuccessfully</settlementState> <paymentMethod>creditCard</paymentMethod> " +  marketTypeString + productString + " <statistics> <statistic> <accountType>Visa</accountType> <chargeAmount>30.15</chargeAmount> <chargeCount>7</chargeCount> <refundAmount>0.00</refundAmount> <refundCount>1</refundCount> <voidCount>2</voidCount> <declineCount>4</declineCount> <errorCount>6</errorCount> </statistic> </statistics> </batch> </getBatchStatisticsResponse>";
		BasicXmlDocument xmlResponse = new BasicXmlDocument();
		xmlResponse.parseString(xml);

		//batch list request
		net.authorize.reporting.Transaction transaction =
		  merchant.createReportingTransaction(TransactionType.GET_BATCH_STATISTICS);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		reportingDetails.setBatchIncludeStatistics(true);
		reportingDetails.setBatchId("24");
		transaction.setReportingDetails(reportingDetails);

		net.authorize.reporting.Result<net.authorize.reporting.Transaction> result =
			(net.authorize.reporting.Result<net.authorize.reporting.Transaction>) net.authorize.reporting.Result.createResult(transaction, xmlResponse);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertEquals(1, result.getReportingDetails().getBatchDetailsList().size());
		Assert.assertEquals(1, result.getReportingDetails().getBatchDetailsList().get(0).getBatchStatisticsList().size());
		BatchDetails batchDetails = result.getReportingDetails().getBatchDetailsList().get(0);
		Assert.assertEquals("24", batchDetails.getBatchId());
		Assert.assertEquals("creditCard", batchDetails.getPaymentMethod());
		Assert.assertNotNull(batchDetails.getMarketType());
		Assert.assertNotNull(batchDetails.getProduct());
		Assert.assertEquals(SettlementStateType.SETTLED_SUCCESSFULLY, batchDetails.getSettlementState());
		Assert.assertEquals("Thu Jan 13 20:58:33 PST 2011", batchDetails.getSettlementTimeUTC().toString());
		Assert.assertEquals("Thu Jan 13 12:58:33 PST 2011", batchDetails.getSettlementTimeLocal().toString());
		Assert.assertNotNull(batchDetails.getMarketType());
		Assert.assertNotNull(batchDetails.getProduct());
		
		for(BatchStatistics batchStat :batchDetails.getBatchStatisticsList()) {
			Assert.assertEquals(CardType.VISA,batchStat.getAccountType());
			Assert.assertEquals(new BigDecimal(30.15).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getChargeAmount());
			Assert.assertEquals(7, batchStat.getChargeCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getRefundAmount());
			Assert.assertEquals(1, batchStat.getRefundCount());
			Assert.assertEquals(2, batchStat.getVoidCount());
			Assert.assertEquals(4, batchStat.getDeclineCount());
			Assert.assertEquals(6, batchStat.getErrorCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getReturnedItemAmount());
			Assert.assertEquals(0,batchStat.getReturnedItemCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getChargebackAmount());
			Assert.assertEquals(0,batchStat.getChargebackCount());
			Assert.assertEquals(0, batchStat.getCorrectionNoticeCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getChargeChargebackAmount());
			Assert.assertEquals(0,batchStat.getChargeChargebackCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getRefundChargebackAmount());
			Assert.assertEquals(0,batchStat.getRefundChargebackCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getChargeReturnedItemsAmount());
			Assert.assertEquals(0,batchStat.getChargeReturnedItemsCount());
			Assert.assertEquals(new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					batchStat.getRefundReturnedItemsAmount());
			Assert.assertEquals(0, batchStat.getRefundReturnedItemsCount());
		}
	}

	@Test
	public void getUnsettledTransactionListRequestMock() {

		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <getUnsettledTransactionListResponse xmlns=\"AnetApi/xml/v1/schema/AnetApiSchema.xsd\"> <messages> <resultCode>Ok</resultCode> <message> <code>I00001</code> <text>Successful.</text> </message> </messages> <transactions> <transaction> <transId>12345</transId> <submitTimeUTC>2009-05-30T09:00:00</submitTimeUTC> <submitTimeLocal>2009-05-30T04:00:00</submitTimeLocal> <transactionStatus>settledSuccessfully</transactionStatus> <invoiceNumber>INV00001</invoiceNumber> <firstName>John</firstName> <lastName>Doe</lastName> <settleAmount>2.00</settleAmount> <accountType>Visa</accountType> <accountNumber>XXXX1111</accountNumber> " + subscriptionOneString + hasReturnedItemsString + " </transaction> <transaction> <transId>12345</transId> <submitTimeUTC>2009-05-30T09:00:00</submitTimeUTC> <submitTimeLocal>2009-05-30T04:00:00</submitTimeLocal> <transactionStatus>settledSuccessfully</transactionStatus> <invoiceNumber>INV00001</invoiceNumber> <firstName>John</firstName> <lastName>Doe</lastName> <settleAmount>2.00</settleAmount> <accountType>Visa</accountType> <accountNumber>XXXX1111</accountNumber> " + subscriptionTwoString + hasReturnedItemsString + " </transaction> </transactions> </getUnsettledTransactionListResponse>";
		BasicXmlDocument xmlResponse = new BasicXmlDocument();
		xmlResponse.parseString(xml);

		net.authorize.reporting.Transaction transaction =
			  merchant.createReportingTransaction(TransactionType.GET_UNSETTLED_TRANSACTION_LIST);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		transaction.setReportingDetails(reportingDetails);

		net.authorize.reporting.Result<net.authorize.reporting.Transaction> result =
			(net.authorize.reporting.Result<net.authorize.reporting.Transaction>) net.authorize.reporting.Result.createResult(transaction, xmlResponse);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getReportingDetails().getTransactionDetailList());
		Assert.assertTrue(result.getReportingDetails().getTransactionDetailList().size() > 0);

		int count=0;
		for(TransactionDetails transactionDetail : result.getReportingDetails().getTransactionDetailList()) {
			Assert.assertEquals("12345", transactionDetail.getTransId());
			Assert.assertEquals("Sat May 30 04:00:00 PDT 2009",transactionDetail.getSubmitTimeLocal().toString());
			Assert.assertEquals("Sat May 30 09:00:00 PDT 2009",transactionDetail.getSubmitTimeUTC().toString());
			Assert.assertEquals(TransactionStatusType.SETTLED_SUCCESSFULLY, transactionDetail.getTransactionStatus());
			Assert.assertEquals("INV00001", transactionDetail.getInvoiceNumber());
			Assert.assertEquals("John", transactionDetail.getFirstName());
			Assert.assertEquals("Doe", transactionDetail.getLastName());
			Assert.assertEquals("XXXX1111", transactionDetail.getAccountNumber());
			Assert.assertEquals(CardType.VISA, transactionDetail.getAccountType());
			Assert.assertEquals(new BigDecimal(2.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP),
					transactionDetail.getSettleAmount());

			Assert.assertEquals(true, transactionDetail.isHasReturnedItems());
			Assert.assertNotNull( transactionDetail.getSubscription());
			AssertSubscription( ++count, transactionDetail);
			Assert.assertNull( transactionDetail.getSolution());
			Assert.assertNull( transactionDetail.getReturnedItems());
		}
	}
	
	
	@Test
	public void getTransactionDetailsRequestRefundMock() {
		String xml = "<?xml version=\"1.0\"?> <getTransactionDetailsResponse xmlns:xsi=\"http://www.w3.org/2001/ XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"AnetApi/xml/v1/schema/AnetApiSchema.xsd\"> <messages> <resultCode>Ok</resultCode> <message> <code>I00001</code> <text>Successful.</text> </message> </messages> <transaction> <transId>12345</transId> <refTransId>12345</refTransId> <splitTenderId>12345</splitTenderId> <submitTimeUTC>2010-08-30T17:49:20.757Z</submitTimeUTC> <submitTimeLocal>2010-08-30T13:49:20.757</submitTimeLocal> <transactionType>authOnlyTransaction</transactionType> <transactionStatus>settledSuccessfully</transactionStatus> <responseCode>1</responseCode> <responseReasonCode>1</responseReasonCode> <responseReasonDescription>Approval</responseReasonDescription> <authCode>000000</authCode> <AVSResponse>X</AVSResponse> <cardCodeResponse>M</cardCodeResponse> <CAVVResponse>2</CAVVResponse> <FDSFilterAction>authAndHold</FDSFilterAction> <FDSFilters> <FDSFilter> <name>Hourly Velocity Filter</name> <action>authAndHold</action> </FDSFilter> <FDSFilter> <name>Amount Filter</name> <action>report</action> </FDSFilter> </FDSFilters> <batch> <batchId>12345</batchId> <settlementTimeUTC>2010-08-30T17:49:20.757Z</settlementTimeUTC> <settlementTimeLocal>2010-08-30T13:49:20.757</settlementTimeLocal> <settlementState>settledSuccessfully</settlementState> </batch> <order> <invoiceNumber>INV00001</invoiceNumber> <description>some description</description> <purchaseOrderNumber>PO000001</purchaseOrderNumber> </order> <requestedAmount>5.00</requestedAmount> <authAmount>2.00</authAmount> <settleAmount>2.00</settleAmount> <tax> <amount>1.00</amount> <name>WA state sales tax</name> <description>Washington state sales tax</description> </tax> <shipping> <amount>2.00</amount> <name>ground based shipping</name> <description>Ground based 5 to 10 day shipping</description> </shipping> <duty> <amount>1.00</amount> </duty> <lineItems> <lineItem> <itemId>ITEM00001</itemId> <name>name of item sold</name> <description>Description of item sold</description> <quantity>1</quantity> <unitPrice>6.95</unitPrice> <taxable>true</taxable> </lineItem> <lineItem> <itemId>ITEM00001</itemId> <name>name of item sold</name> <description>Description of item sold</description> <quantity>1</quantity> <unitPrice>6.95</unitPrice> <taxable>true</taxable> </lineItem> </lineItems> <prepaidBalanceRemaining>30.00</prepaidBalanceRemaining> <taxExempt>false</taxExempt>  <payment>      <creditCard>        <cardNumber>XXXX1111</cardNumber>        <expirationDate>XXXX</expirationDate>        <cardType>Visa</cardType>      </creditCard>    </payment> <customer> <type>individual</type> <id>ABC00001</id> <email>mark@example.com</email> </customer> <billTo> <firstName>John</firstName> <lastName>Doe</lastName> <company/> <address>123 Main St.</address> <city>Bellevue</city> <state>WA</state> <zip>98004</zip> <country>USA</country> <phoneNumber>000-000-0000</phoneNumber> <faxNumber/> </billTo> <shipTo> <firstName>John</firstName> <lastName>Doe</lastName> <company/> <address>123 Main St.</address> <city>Bellevue</city> <state>WA</state> <zip>98004</zip> <country>USA</country> </shipTo> <recurringBilling>false</recurringBilling> <customerIP>0.0.0.0</customerIP> " + subscriptionOneString + solutionString + returnedItemsString + " </transaction> </getTransactionDetailsResponse>";

		BasicXmlDocument xmlResponse = new BasicXmlDocument();
		xmlResponse.parseString(xml);

		net.authorize.reporting.Transaction transaction = merchant
				.createReportingTransaction(TransactionType.GET_TRANSACTION_DETAILS);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		reportingDetails.setTransactionId("12345");
		transaction.setReportingDetails(reportingDetails);
	

		net.authorize.reporting.Result<net.authorize.reporting.Transaction> result =
			(net.authorize.reporting.Result<net.authorize.reporting.Transaction>) net.authorize.reporting.Result.createResult(transaction, xmlResponse);
		Assert.assertNotNull(result.getReportingDetails().getTransactionDetailList());
		Assert.assertTrue(result.getReportingDetails().getTransactionDetailList().size() == 1);
		TransactionDetails transactionDetail = result.getReportingDetails().getTransactionDetailList().get(0);
		Assert.assertEquals("12345",transactionDetail.getTransId());
		Assert.assertEquals("12345",transactionDetail.getRefTransId());
		Assert.assertEquals("12345",transactionDetail.getSplitTenderId());
		Assert.assertEquals("Mon Aug 30 17:49:20 PDT 2010",transactionDetail.getSubmitTimeUTC().toString());
		Assert.assertEquals("Mon Aug 30 13:49:20 PDT 2010",transactionDetail.getSubmitTimeLocal().toString());
		Assert.assertEquals(ReportingTransactionType.AUTH_ONLY,transactionDetail.getTransactionType());
		Assert.assertEquals(TransactionStatusType.SETTLED_SUCCESSFULLY,transactionDetail.getTransactionStatus());
		Assert.assertEquals(ResponseCode.APPROVED,transactionDetail.getResponseCode());
		Assert.assertEquals(ResponseReasonCode.RRC_1_1,transactionDetail.getResponseReasonCode());
		Assert.assertEquals("Approval", transactionDetail.getResponseReasonCode().getReasonText());
		Assert.assertEquals("000000",transactionDetail.getAuthCode());
		Assert.assertEquals(AVSCode.X,transactionDetail.getAvsResponse());
		Assert.assertEquals(CardCodeResponseType.M,transactionDetail.getCardCodeResponse());
		Assert.assertEquals(CAVVResponseType.CAVV_2,transactionDetail.getCAVVResponse());
		Assert.assertEquals(FDSFilterActionType.AUTH_AND_HOLD,transactionDetail.getFDSFilterAction());
		Assert.assertEquals(2, transactionDetail.getFDSFilterList().size());
		// fds - 1
		FDSFilter fdsFilter = transactionDetail.getFDSFilterList().get(0);
		Assert.assertEquals("Hourly Velocity Filter", fdsFilter.getName());
		Assert.assertEquals(FDSFilterActionType.AUTH_AND_HOLD, fdsFilter.getAction());
		// fds - 2
		fdsFilter = transactionDetail.getFDSFilterList().get(1);
		Assert.assertEquals("Amount Filter", fdsFilter.getName());
		Assert.assertEquals(FDSFilterActionType.REPORT, fdsFilter.getAction());
		// batch
		BatchDetails batch = transactionDetail.getBatch();
		Assert.assertNotNull(batch);
		Assert.assertEquals("12345", batch.getBatchId());
		Assert.assertEquals("Mon Aug 30 17:49:20 PDT 2010", batch.getSettlementTimeUTC().toString());
		Assert.assertEquals("Mon Aug 30 13:49:20 PDT 2010", batch.getSettlementTimeLocal().toString());
		Assert.assertEquals(SettlementStateType.SETTLED_SUCCESSFULLY, batch.getSettlementState());
		Assert.assertNull(batch.getPaymentMethod());
		Assert.assertNull(batch.getMarketType());
		Assert.assertNull(batch.getProduct());
		
		// order
		Order order = transactionDetail.getOrder();
		Assert.assertNotNull(order);
		Assert.assertEquals("INV00001", order.getInvoiceNumber());
		Assert.assertEquals("some description", order.getDescription());
		Assert.assertEquals("PO000001", order.getPurchaseOrderNumber());
		// requested amount
		Assert.assertEquals(new BigDecimal(5.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), transactionDetail.getRequestedAmount());
		// auth amount
		Assert.assertEquals(new BigDecimal(2.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), transactionDetail.getAuthAmount());
		// settle amount
		Assert.assertEquals(new BigDecimal(2.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), transactionDetail.getSettleAmount());
		ShippingCharges taxShipDutyCharges = order.getShippingCharges();
		Assert.assertNotNull(taxShipDutyCharges);
		// tax
		Assert.assertEquals(new BigDecimal(1.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), taxShipDutyCharges.getTaxAmount());
		Assert.assertEquals("WA state sales tax", taxShipDutyCharges.getTaxItemName());
		Assert.assertEquals("Washington state sales tax", taxShipDutyCharges.getTaxDescription());
		// ship
		Assert.assertEquals(new BigDecimal(2.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), taxShipDutyCharges.getFreightAmount());
		Assert.assertEquals("ground based shipping", taxShipDutyCharges.getFreightItemName());
		Assert.assertEquals("Ground based 5 to 10 day shipping", taxShipDutyCharges.getFreightDescription());
		// duty
		Assert.assertEquals(new BigDecimal(1.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), taxShipDutyCharges.getDutyAmount());
		Assert.assertNull(taxShipDutyCharges.getDutyItemName());
		Assert.assertNull(taxShipDutyCharges.getDutyItemDescription());
		// line items
		Assert.assertEquals(2, order.getOrderItems().size());
		for(OrderItem orderItem : order.getOrderItems()) {
			Assert.assertNotNull(orderItem);
			Assert.assertEquals("ITEM00001", orderItem.getItemId());
			Assert.assertEquals("name of item sold", orderItem.getItemName());
			Assert.assertEquals("Description of item sold", orderItem.getItemDescription());
			Assert.assertEquals(new BigDecimal(1).setScale(Transaction.QUANTITY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), orderItem.getItemQuantity());
			Assert.assertEquals(new BigDecimal(6.95).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), orderItem.getItemPrice());
			Assert.assertTrue(orderItem.isItemTaxable());
		}
		// prepaid balance
		Assert.assertEquals(new BigDecimal(30.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP), transactionDetail.getPrepaidBalanceRemaining());
		Assert.assertFalse(transactionDetail.isItemTaxExempt());
		// payment
		Payment payment = transactionDetail.getPayment();
		Assert.assertNotNull(payment);
		CreditCard creditCard = payment.getCreditCard();
		Assert.assertNotNull(creditCard);
		Assert.assertEquals(CardType.VISA.getValue(), creditCard.getCardType().getValue());
		// customer
		Customer customer = transactionDetail.getCustomer();
		Assert.assertNotNull(customer);
		Assert.assertEquals(CustomerType.INDIVIDUAL, customer.getCustomerType());
		Assert.assertEquals("ABC00001", customer.getId());
		Assert.assertEquals("mark@example.com", customer.getEmail());
		// billto
		Address billToAddress = customer.getBillTo();
		Assert.assertNotNull(billToAddress);
		Assert.assertEquals("John", billToAddress.getFirstName());
		Assert.assertEquals("Doe", billToAddress.getLastName());
		Assert.assertNull(billToAddress.getCompany());
		Assert.assertEquals("123 Main St.", billToAddress.getAddress());
		Assert.assertEquals("Bellevue", billToAddress.getCity());
		Assert.assertEquals("WA", billToAddress.getState());
		Assert.assertEquals("98004", billToAddress.getZipPostalCode());
		Assert.assertEquals("USA", billToAddress.getCountry());
		Assert.assertEquals("000-000-0000", billToAddress.getPhoneNumber());
		Assert.assertNull(billToAddress.getFaxNumber());
		// shipto
		Address shipToAddress = customer.getShipTo();
		Assert.assertNotNull(shipToAddress);
		Assert.assertEquals("John", shipToAddress.getFirstName());
		Assert.assertEquals("Doe", shipToAddress.getLastName());
		Assert.assertNull(shipToAddress.getCompany());
		Assert.assertEquals("123 Main St.", shipToAddress.getAddress());
		Assert.assertEquals("Bellevue", shipToAddress.getCity());
		Assert.assertEquals("WA", shipToAddress.getState());
		Assert.assertEquals("98004", shipToAddress.getZipPostalCode());
		Assert.assertEquals("USA", shipToAddress.getCountry());
		// recurring billing
		Assert.assertFalse(transactionDetail.isRecurringBilling());
		Assert.assertEquals("0.0.0.0", transactionDetail.getCustomerIP());

		//subscription
		int count=0;
		Assert.assertFalse(transactionDetail.isHasReturnedItems());
		AssertSubscription( ++count, transactionDetail);
		AssertSolution( transactionDetail);
		//TODO count check
		AssertReturnedItems( 1, transactionDetail);
	}


	//@Test
	public void issueReportedForSoapGetTransactionDetails()
	{
		String transId = "2212081781";
		net.authorize.reporting.Transaction transaction = merchant.createReportingTransaction(TransactionType.GET_TRANSACTION_DETAILS);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		reportingDetails.setTransactionId(transId);
		transaction.setReportingDetails(reportingDetails);

		net.authorize.reporting.Result<net.authorize.reporting.Transaction> result =
				(net.authorize.reporting.Result<net.authorize.reporting.Transaction>) merchant.postTransaction(transaction);
		
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getReportingDetails());
		Assert.assertNotNull(result.getReportingDetails().getTransactionDetailList());

		net.authorize.reporting.Transaction newTransaction = (net.authorize.reporting.Transaction) result.getTransaction();
		//Assert.assertNotNull(newTransaction);

		int size = result.getReportingDetails().getTransactionDetailList().size();
		/*
		Assert.assertEquals(1, size);
		TransactionDetails transactionDetail = result.getReportingDetails().getTransactionDetailList().get(0);
		Assert.assertEquals( transId,transactionDetail.getTransId());
		*/
	}
	
	@Test
	public void testXmlUtility() throws Exception
	{
		int subsId = randomGenerator.nextInt();
		int payNum = randomGenerator.nextInt();
		Subscription subscription = Subscription.createSubscription(subsId, payNum);
		System.out.println(subscription);
		String xml = XmlUtility.getXml(subscription);
		Assert.assertNotNull( xml);
		System.out.println(xml);
		Subscription xmlSubscription = XmlUtility.create(xml, Subscription.class);
		Assert.assertNotNull( xmlSubscription);
		System.out.println(xmlSubscription);
	}
	
	public static void AssertSubscription( int count, TransactionDetails transactionDetail)
	{
		Assert.assertNotNull(transactionDetail);
		Subscription subs = transactionDetail.getSubscription();
		Assert.assertNotNull(subs);
		if ( 0 == count)
		{
			Assert.assertTrue( 0 < subs.getId());
			Assert.assertTrue( 0 < subs.getPayNum());
		}
		else
		{
			Assert.assertEquals( count * 10, subs.getId());
			Assert.assertEquals( count * 101, subs.getPayNum());
		}
	}

	public static void AssertSolution( TransactionDetails transactionDetail)
	{
		Assert.assertNotNull(transactionDetail);
		Solution sol = transactionDetail.getSolution();
		Assert.assertNotNull(sol);
		Assert.assertNotNull( sol.getId());
		Assert.assertNotNull( sol.getName());
	}

	public static void AssertReturnedItems( int count, TransactionDetails transactionDetail)
	{
		Assert.assertNotNull(transactionDetail);
		ArrayList<ReturnedItem> returnedItems = transactionDetail.getReturnedItems();
		Assert.assertNotNull(returnedItems);
		Assert.assertEquals(count, returnedItems.size());

		for ( ReturnedItem returnedItem :  returnedItems)
		{
			Assert.assertNotNull(returnedItem.getId());
			Assert.assertNotNull(returnedItem.getDateUTC());
			Assert.assertNotNull(returnedItem.getDateLocal());
			Assert.assertNotNull(returnedItem.getCode());
			Assert.assertNotNull(returnedItem.getDescription());
		}
	}
}

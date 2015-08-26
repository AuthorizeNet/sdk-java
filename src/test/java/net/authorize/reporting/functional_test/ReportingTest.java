package net.authorize.reporting.functional_test;

import java.util.Calendar;
import java.util.List;
import net.authorize.Transaction;
import net.authorize.UnitTestData;
import net.authorize.data.reporting.Subscription;
import net.authorize.data.xml.reporting.BatchDetails;
import net.authorize.data.xml.reporting.BatchStatistics;
import net.authorize.data.xml.reporting.ReportingDetails;
import net.authorize.data.xml.reporting.TransactionDetails;
import net.authorize.data.xml.reporting.TransactionStatusType;
import net.authorize.reporting.Result;
import net.authorize.reporting.TransactionType;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class ReportingTest extends UnitTestData {

	@SuppressWarnings("unchecked")
	@Test
	public void getSettledBatchListRequestLive() {

		// batch list request
		List<BatchDetails> batchDetailsList = getSettledBatchDetailsList();

		Assert.assertNotNull(batchDetailsList);
		Assume.assumeTrue(batchDetailsList.size() > 0); /*- precondition */

		for(BatchDetails batchDetail : batchDetailsList) {
			Assert.assertNotNull(batchDetail.getBatchId());
			Assert.assertNotNull(batchDetail.getSettlementState());
			Assert.assertNotNull(batchDetail.getSettlementTimeLocal());
			Assert.assertNotNull(batchDetail.getSettlementTimeUTC());
			Assert.assertNotNull(batchDetail.getPaymentMethod());
			Assert.assertNotNull(batchDetail.getMarketType());
			Assert.assertNotNull(batchDetail.getProduct());
			
			for(BatchStatistics batchStat :batchDetail.getBatchStatisticsList()) {
				Assert.assertNotNull(batchStat.getAccountType());
				Assert.assertNotNull(batchStat.getChargeAmount());
				Assert.assertNotNull(batchStat.getChargebackAmount());
				Assert.assertNotNull(batchStat.getChargebackCount());
				Assert.assertNotNull(batchStat.getChargeChargebackAmount());
				Assert.assertNotNull(batchStat.getChargeChargebackCount());
				Assert.assertNotNull(batchStat.getChargeCount());
				Assert.assertNotNull(batchStat.getChargeReturnedItemsAmount());
				Assert.assertNotNull(batchStat.getChargeReturnedItemsCount());
				Assert.assertNotNull(batchStat.getCorrectionNoticeCount());
				Assert.assertNotNull(batchStat.getDeclineCount());
				Assert.assertNotNull(batchStat.getErrorCount());
				Assert.assertNotNull(batchStat.getRefundAmount());
				Assert.assertNotNull(batchStat.getRefundChargebackAmount());
				Assert.assertNotNull(batchStat.getRefundCount());
				Assert.assertNotNull(batchStat.getRefundReturnedItemsAmount());
				Assert.assertNotNull(batchStat.getRefundReturnedItemsCount());
				Assert.assertNotNull(batchStat.getReturnedItemAmount());
				Assert.assertNotNull(batchStat.getReturnedItemCount());
				Assert.assertNotNull(batchStat.getVoidCount());
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getSettledBatchListRequestWithTimeLive() {

		// batch list request
		net.authorize.reporting.Transaction transaction =
		  merchant.createReportingTransaction(TransactionType.GET_SETTLED_BATCH_LIST);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();

		Calendar firstSettlementCal = Calendar.getInstance();
		firstSettlementCal.add(Calendar.DAY_OF_YEAR, -30);
		reportingDetails.setBatchFirstSettlementDate(firstSettlementCal.getTime());
		
		Calendar lastSettlementCal = Calendar.getInstance();
		//lastSettlementCal.add(Calendar.DAY_OF_YEAR, +25);
		reportingDetails.setBatchLastSettlementDate(lastSettlementCal.getTime());

		reportingDetails.setBatchIncludeStatistics(true);
		transaction.setReportingDetails(reportingDetails);

		Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getReportingDetails().getBatchDetailsList());
		Assert.assertTrue(result.getReportingDetails().getBatchDetailsList().size() > 0);
		for(BatchDetails batchDetail : result.getReportingDetails().getBatchDetailsList()) {
			Assert.assertNotNull(batchDetail.getBatchId());
			Assert.assertNotNull(batchDetail.getSettlementState());
			Assert.assertNotNull(batchDetail.getSettlementTimeLocal());
			Assert.assertNotNull(batchDetail.getSettlementTimeUTC());
			Assert.assertNotNull(batchDetail.getPaymentMethod());
			Assert.assertNotNull(batchDetail.getMarketType());
			Assert.assertNotNull(batchDetail.getProduct());
			
			for(BatchStatistics batchStat :batchDetail.getBatchStatisticsList()) {
				Assert.assertNotNull(batchStat.getAccountType());
				Assert.assertNotNull(batchStat.getChargeAmount());
				Assert.assertNotNull(batchStat.getChargebackAmount());
				Assert.assertNotNull(batchStat.getChargebackCount());
				Assert.assertNotNull(batchStat.getChargeChargebackAmount());
				Assert.assertNotNull(batchStat.getChargeChargebackCount());
				Assert.assertNotNull(batchStat.getChargeCount());
				Assert.assertNotNull(batchStat.getChargeReturnedItemsAmount());
				Assert.assertNotNull(batchStat.getChargeReturnedItemsCount());
				Assert.assertNotNull(batchStat.getCorrectionNoticeCount());
				Assert.assertNotNull(batchStat.getDeclineCount());
				Assert.assertNotNull(batchStat.getErrorCount());
				Assert.assertNotNull(batchStat.getRefundAmount());
				Assert.assertNotNull(batchStat.getRefundChargebackAmount());
				Assert.assertNotNull(batchStat.getRefundCount());
				Assert.assertNotNull(batchStat.getRefundReturnedItemsAmount());
				Assert.assertNotNull(batchStat.getRefundReturnedItemsCount());
				Assert.assertNotNull(batchStat.getReturnedItemAmount());
				Assert.assertNotNull(batchStat.getReturnedItemCount());
				Assert.assertNotNull(batchStat.getVoidCount());
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getTransactionListRequestLive() {

		/*-
		 *  Precondition: there are settled batches in the AuthorizeNet service.
		 */

		// Find a batch id for an settled batch.
		List<BatchDetails> batchDetailsList = getSettledBatchDetailsList();

		Assert.assertNotNull(batchDetailsList);
		Assume.assumeTrue(batchDetailsList.size() > 0); /*- precondition */
		String batchId = batchDetailsList.get(0).getBatchId();

		// Get transactions for the given batch id.
		ReportingDetails reportingDetails = ReportingDetails
				.createReportingDetails();
		reportingDetails.setBatchId(batchId);

		net.authorize.reporting.Transaction transaction = merchant
				.createReportingTransaction(TransactionType.GET_TRANSACTION_LIST);
		transaction.setReportingDetails(reportingDetails);

		Result<Transaction> result = (Result<Transaction>) merchant
				.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());

		// Check the transactions.
		Assert.assertNotNull(result.getReportingDetails()
				.getTransactionDetailList());
		Assert.assertTrue(result.getReportingDetails()
				.getTransactionDetailList().size() > 0);

		for(TransactionDetails transactionDetail : result.getReportingDetails().getTransactionDetailList()) {
			Assert.assertNotNull(transactionDetail.getAccountNumber());
			Assert.assertNotNull(transactionDetail.getTransId());
			Assert.assertNotNull(transactionDetail.getAccountType());
			Assert.assertNotNull(transactionDetail.getSettleAmount());
			Assert.assertNotNull(transactionDetail.getSubmitTimeLocal());
			Assert.assertNotNull(transactionDetail.getSubmitTimeUTC());
			Assert.assertNotNull(transactionDetail.getTransactionStatus());

			Subscription subs = transactionDetail.getSubscription();
			if (subs != null) {
				Assert.assertTrue(0 < subs.getId());
				Assert.assertTrue(0 < subs.getPayNum());
			}
		}
	}

	@Test
	public void getUnsettledTransactionListRequest() {

		/*-
		 * Better that there are unsettled transactions in the AuthorizeNet
		 * service.
		 */
		List<TransactionDetails> transactionDetails = getUnsettledTransactionDetails();

		Assert.assertNotNull(transactionDetails);
		Assert.assertTrue(transactionDetails.size() >= 0); /*- 0 is valid; better not. */

		for(TransactionDetails transactionDetail : transactionDetails) {
			if (transactionDetail.getTransactionStatus() != TransactionStatusType.GENERAL_ERROR) {
				Assert.assertNotNull(transactionDetail.getAccountNumber());
				Assert.assertNotNull(transactionDetail.getTransId());
				Assert.assertNotNull(transactionDetail.getAccountType());
				Assert.assertNotNull(transactionDetail.getSettleAmount());
				Assert.assertNotNull(transactionDetail.getSubmitTimeLocal());
				Assert.assertNotNull(transactionDetail.getSubmitTimeUTC());
				Assert.assertNotNull(transactionDetail.getTransactionStatus());

				Subscription subs = transactionDetail.getSubscription();
				if (subs != null) {
					Assert.assertTrue(subs.getId() > 0);
					Assert.assertTrue(subs.getPayNum() > 0);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getTransactionDetailsRequestLive() {


		/*-
		 * Precondition: there are unsettled transactions in the AuthorizeNet
		 * service.
		 */

		// Find a transaction id for an unsettled transaction.
		List<TransactionDetails> transactionDetails = getUnsettledTransactionDetails();

		Assert.assertNotNull(transactionDetails);
		Assume.assumeTrue(transactionDetails.size() > 0); /*- precondition */
		String transId = transactionDetails.get(0).getTransId();

		// Get the transaction detail for the given transaction id.
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		reportingDetails.setTransactionId(transId);
	
		net.authorize.reporting.Transaction transaction = merchant.createReportingTransaction(TransactionType.GET_TRANSACTION_DETAILS);
		transaction.setReportingDetails(reportingDetails);

		Result<Transaction> result = (Result<Transaction>) merchant
				.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());

		// Check the transaction detail.
		Assert.assertNotNull(result.getReportingDetails()
				.getTransactionDetailList());
		Assert.assertTrue(result.getReportingDetails()
				.getTransactionDetailList().size() == 1);

		TransactionDetails transactionDetail = result.getReportingDetails()
				.getTransactionDetailList().get(0);

		Assert.assertNotNull(transactionDetail);
		Assert.assertNotNull(transactionDetail.getTransId());

		Subscription subs = transactionDetail.getSubscription();
		if (subs != null) {
			Assert.assertTrue(subs.getId() > 0);
			Assert.assertTrue(subs.getPayNum() > 0);
		}
	}

	private List<BatchDetails> getSettledBatchDetailsList() {

		ReportingDetails reportingDetails = ReportingDetails
				.createReportingDetails();
		reportingDetails.setBatchIncludeStatistics(true);

		net.authorize.reporting.Transaction transaction = merchant
				.createReportingTransaction(TransactionType.GET_SETTLED_BATCH_LIST);
		transaction.setReportingDetails(reportingDetails);

		@SuppressWarnings("unchecked")
		Result<Transaction> result = (Result<Transaction>) merchant
				.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());

		List<BatchDetails> batchDetailsList = result.getReportingDetails()
				.getBatchDetailsList();
		return batchDetailsList;
	}

	private List<TransactionDetails> getUnsettledTransactionDetails() {

		net.authorize.reporting.Transaction transaction = merchant
				.createReportingTransaction(TransactionType.GET_UNSETTLED_TRANSACTION_LIST);
		ReportingDetails reportingDetails = ReportingDetails
				.createReportingDetails();
		transaction.setReportingDetails(reportingDetails);

		@SuppressWarnings("unchecked")
		Result<Transaction> result = (Result<Transaction>) merchant
				.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());

		List<TransactionDetails> transactionDetails = result
				.getReportingDetails().getTransactionDetailList();
		return transactionDetails;
	}
	
	@Test
	public void Issue48repro()
	{ 
		 String errormessage = "The element 'getTransactionDetailsRequest' in namespace 'AnetApi/xml/v1/schema/AnetApiSchema.xsd' has incomplete content. List of possible elements expected: 'refId, transId' in namespace 'AnetApi/xml/v1/schema/AnetApiSchema.xsd'.";
		 net.authorize.reporting.Transaction transaction = merchant.createReportingTransaction(TransactionType.GET_TRANSACTION_DETAILS);
		 ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		
		 reportingDetails.setBatchIncludeStatistics(true);
		 transaction.setReportingDetails(reportingDetails);

	     Result<Transaction> result = (Result<Transaction>) merchant.postTransaction(transaction);
         System.out.println("Code : "+result.getMessages().get(0).getResultCode());
         System.out.println("Text : "+result.getMessages().get(0).getText());
      
         Assert.assertEquals(errormessage , result.getMessages().get(0).getText()); 
     for (BatchDetails batchDetail : result.getReportingDetails().getBatchDetailsList()) {
          System.out.println("---------------------");
          System.out.println("ID : "+ batchDetail.getBatchId() );
          System.out.println("Settlement State : "+ batchDetail.getSettlementState().value());
          System.out.println("local settlementTime: "+ batchDetail.getSettlementTimeLocal().toString());
      }
     reportingDetails.getTransactionDetailList();
	}	
	
	@Test
	public void Issue48solution()
	{ 
		//valid transaction id is required to run this test
		 String transId = "2239014404";
		 net.authorize.reporting.Transaction transaction = merchant.createReportingTransaction(TransactionType.GET_TRANSACTION_DETAILS);
		 ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		 reportingDetails.setTransactionId(transId);
		 
		 Assert.assertEquals(transId, reportingDetails.getTransactionId());
		 transaction.setReportingDetails(reportingDetails);
	     Result<Transaction> result = (Result<Transaction>) merchant.postTransaction(transaction);
	     Assert.assertEquals("Ok", result.getResultCode());
         reportingDetails.getTransactionDetailList();
	}
	
}

package net.authorize.reporting.functional_test;

import java.util.Calendar;

import net.authorize.Transaction;
import net.authorize.UnitTestData;
import net.authorize.data.reporting.Subscription;
import net.authorize.data.xml.reporting.BatchDetails;
import net.authorize.data.xml.reporting.BatchStatistics;
import net.authorize.data.xml.reporting.ReportingDetails;
import net.authorize.data.xml.reporting.TransactionDetails;
import net.authorize.reporting.Result;
import net.authorize.reporting.TransactionType;

import org.junit.Assert;
import org.junit.Test;

public class ReportingTest extends UnitTestData {

	protected static String reportingBatchId = "";
	protected static String reportingTransId = "";

	@SuppressWarnings("unchecked")
	@Test
	public void getSettledBatchListRequestLive() {

		// batch list request
		net.authorize.reporting.Transaction transaction =
		  merchant.createReportingTransaction(TransactionType.GET_SETTLED_BATCH_LIST);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
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
			reportingBatchId = batchDetail.getBatchId();
			Assert.assertNotNull(batchDetail.getSettlementState());
			Assert.assertNotNull(batchDetail.getSettlementTimeLocal());
			Assert.assertNotNull(batchDetail.getSettlementTimeUTC());
			Assert.assertNotNull(batchDetail.getPaymentMethod());
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
		firstSettlementCal.add(Calendar.DAY_OF_YEAR, -3);
		reportingDetails.setBatchFirstSettlementDate(firstSettlementCal.getTime());
		
		Calendar lastSettlementCal = Calendar.getInstance();
		lastSettlementCal.add(Calendar.DAY_OF_YEAR, +25);
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

		Assert.assertNotNull(reportingTransId);		
		// batch list request
		net.authorize.reporting.Transaction transaction =
		  merchant.createReportingTransaction(TransactionType.GET_TRANSACTION_LIST);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		reportingDetails.setBatchId(reportingBatchId);
		transaction.setReportingDetails(reportingDetails);

		Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getReportingDetails().getTransactionDetailList());
		Assert.assertTrue(result.getReportingDetails().getTransactionDetailList().size() > 0);
		for(TransactionDetails transactionDetail : result.getReportingDetails().getTransactionDetailList()) {
			Assert.assertNotNull(transactionDetail.getAccountNumber());
			Assert.assertNotNull(transactionDetail.getTransId());
			reportingTransId = transactionDetail.getTransId();
			Assert.assertNotNull(transactionDetail.getAccountType());
			Assert.assertNotNull(transactionDetail.getSettleAmount());
			Assert.assertNotNull(transactionDetail.getSubmitTimeLocal());
			Assert.assertNotNull(transactionDetail.getSubmitTimeUTC());
			Assert.assertNotNull(transactionDetail.getTransactionStatus());

			int count=0;
			net.authorize.reporting.ReportingTest.AssertSubscription( count, transactionDetail);
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getUnsettledTransactionListRequest() {

		//does not require any batch id, needs to have some transactions created
		//if(reportingBatchId != null) 
		{
			// batch list request
			net.authorize.reporting.Transaction transaction =
			  merchant.createReportingTransaction(TransactionType.GET_UNSETTLED_TRANSACTION_LIST);
			ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
			transaction.setReportingDetails(reportingDetails);

			Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(transaction);

			Assert.assertNotNull(result);
			result.printMessages();
			Assert.assertTrue(result.isOk());
			Assert.assertNotNull(result.getReportingDetails().getTransactionDetailList());
			Assert.assertTrue(result.getReportingDetails().getTransactionDetailList().size() >=0 );
			int count=0;
			for(TransactionDetails transactionDetail : result.getReportingDetails().getTransactionDetailList()) {
				Assert.assertNotNull(transactionDetail.getAccountNumber());
				Assert.assertNotNull(transactionDetail.getTransId());
				reportingTransId = transactionDetail.getTransId();
				Assert.assertNotNull(transactionDetail.getAccountType());
				Assert.assertNotNull(transactionDetail.getSettleAmount());
				Assert.assertNotNull(transactionDetail.getSubmitTimeLocal());
				Assert.assertNotNull(transactionDetail.getSubmitTimeUTC());
				Assert.assertNotNull(transactionDetail.getTransactionStatus());

				net.authorize.reporting.ReportingTest.AssertSubscription( count, transactionDetail);
			}
		}
		/*
		else 
		{
			Assert.assertTrue(true);
			System.out.println("getUnsettledTransactionListRequest did not have a reporting batch id to query");
		}
		*/
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getTransactionDetailsRequestLive() {

		Assert.assertNotNull(reportingTransId);		
		// batch list request
		net.authorize.reporting.Transaction transaction =
		  merchant.createReportingTransaction(TransactionType.GET_TRANSACTION_DETAILS);
		ReportingDetails reportingDetails = ReportingDetails.createReportingDetails();
		reportingDetails.setTransactionId(reportingTransId);		
		
		
		transaction.setReportingDetails(reportingDetails);

		Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(transaction);

		Assert.assertNotNull(result);
		result.printMessages();
		Assert.assertTrue(result.isOk());
		Assert.assertNotNull(result.getReportingDetails().getTransactionDetailList());
		Assert.assertTrue(result.getReportingDetails().getTransactionDetailList().size() > 0);
		int count=0;
		for(TransactionDetails transactionDetail : result.getReportingDetails().getTransactionDetailList()) {
			Assert.assertNotNull(transactionDetail.getTransId());

			net.authorize.reporting.ReportingTest.AssertSubscription( count, transactionDetail);
		}
	}
}

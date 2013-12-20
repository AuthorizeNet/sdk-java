package net.authorize.data.xml.reporting;

import java.util.ArrayList;
import java.util.Date;

/**
 * Reporting details.
 */
public class ReportingDetails {

    public static String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static String DATE_FORMAT_FULL = "yyyy-MM-dd'T'HH:mm:ss.SSS";

	private boolean batchIncludeStatistics = false;
	private Date batchFirstSettlementDate = null;
	private Date batchLastSettlementDate = null;
	private String batchId = null;
	private String transactionId = null;
	private ArrayList<BatchDetails> batchDetailsList = new ArrayList<BatchDetails>();
	private ArrayList<TransactionDetails> transactionDetailList = new ArrayList<TransactionDetails>();

	private ReportingDetails () { }

	public static ReportingDetails createReportingDetails() {
		return new ReportingDetails();
	}

	/**
	 * @return the batchIncludeStatistics
	 */
	public boolean isBatchIncludeStatistics() {
		return batchIncludeStatistics;
	}

	/**
	 * @param batchIncludeStatistics the batchIncludeStatistics to set
	 */
	public void setBatchIncludeStatistics(boolean batchIncludeStatistics) {
		this.batchIncludeStatistics = batchIncludeStatistics;
	}

	/**
	 * @return the batchFirstSettlementDate
	 */
	public Date getBatchFirstSettlementDate() {
		return batchFirstSettlementDate;
	}

	/**
	 * @param batchFirstSettlementDate the batchFirstSettlementDate to set
	 */
	public void setBatchFirstSettlementDate(Date batchFirstSettlementDate) {
		this.batchFirstSettlementDate = batchFirstSettlementDate;
	}

	/**
	 * @param batchFirstSettlementDate the batchFirstSettlementDate to set
	 */
	public void setBatchFirstSettlementDate(String batchFirstSettlementDate) {
		this.batchFirstSettlementDate = net.authorize.util.DateUtil.getDateFromFormattedDate(
				batchFirstSettlementDate, DATE_FORMAT);
	}

	/**
	 * @return the batchLastSettlementDate
	 */
	public Date getBatchLastSettlementDate() {
		return batchLastSettlementDate;
	}

	/**
	 * @param batchLastSettlementDate the batchLastSettlementDate to set
	 */
	public void setBatchLastSettlementDate(Date batchLastSettlementDate) {
		this.batchLastSettlementDate = batchLastSettlementDate;
	}

	/**
	 * @param batchLastSettlementDate the batchLastSettlementDate to set
	 */
	public void setBatchLastSettlementDate(String batchLastSettlementDate) {
		this.batchLastSettlementDate = net.authorize.util.DateUtil.getDateFromFormattedDate(
				batchLastSettlementDate, DATE_FORMAT);
	}

	/**
	 * @return the batchId
	 */
	public String getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the batchDetailList
	 */
	public ArrayList<BatchDetails> getBatchDetailsList() {
		return batchDetailsList;
	}

	/**
	 * @param batchDetailList the batchDetailList to set
	 */
	public void setBatchDetailsList(ArrayList<BatchDetails> batchDetailList) {
		this.batchDetailsList = batchDetailList;
	}

	/**
	 * @return the transactionDetailList
	 */
	public ArrayList<TransactionDetails> getTransactionDetailList() {
		return transactionDetailList;
	}

	/**
	 * @param transactionDetailList the transactionDetailList to set
	 */
	public void setTransactionDetailList(
			ArrayList<TransactionDetails> transactionDetailList) {
		this.transactionDetailList = transactionDetailList;
	}


}

package net.authorize.data.xml.reporting;

import java.util.ArrayList;
import java.util.Date;

import net.authorize.util.StringUtils;

/**
 * Batch related reporting information.
 *
 */
public class BatchDetails {

	private BatchDetails() { }
	private String batchId;
	private Date settlementTimeUTC;
	private Date settlementTimeLocal;
	private SettlementStateType settlementState;
	private String paymentMethod;
	private ArrayList<BatchStatistics> batchStatisticsList = new ArrayList<BatchStatistics>();

	public static BatchDetails createBatchDetail() {
		return new BatchDetails();
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
	 * @return the settlementTimeUTC
	 */
	public Date getSettlementTimeUTC() {
		return settlementTimeUTC;
	}

	/**
	 * @param settlementTimeUTC the settlementTimeUTC to set
	 */
	public void setSettlementTimeUTC(Date settlementTimeUTC) {
		this.settlementTimeUTC = settlementTimeUTC;
	}

	/**
	 * Set the settlement time UTC.
	 *
	 * @param settlementTimeUTC
	 */
	public void setSettlementTimeUTC(String settlementTimeUTC) {
		if(StringUtils.isNotEmpty(settlementTimeUTC)) {
			this.settlementTimeUTC = net.authorize.util.DateUtil.getDateFromFormattedDate(
					settlementTimeUTC, ReportingDetails.DATE_FORMAT);
		}
	}

	/**
	 * @return the settlementTimeLocal
	 */
	public Date getSettlementTimeLocal() {
		return settlementTimeLocal;
	}

	/**
	 * @param settlementTimeLocal the settlementTimeLocal to set
	 */
	public void setSettlementTimeLocal(Date settlementTimeLocal) {
		this.settlementTimeLocal = settlementTimeLocal;
	}

	/**
	 * @param settlementTimeLocal the settlementTimeLocal to set
	 */
	public void setSettlementTimeLocal(String settlementTimeLocal) {
		if(StringUtils.isNotEmpty(settlementTimeLocal)) {
			this.settlementTimeLocal = net.authorize.util.DateUtil.getDateFromFormattedDate(
					settlementTimeLocal, ReportingDetails.DATE_FORMAT);
		}
	}

	/**
	 * @return the settlementState
	 */
	public SettlementStateType getSettlementState() {
		return settlementState;
	}

	/**
	 * @param settlementState the settlementState to set
	 */
	public void setSettlementState(SettlementStateType settlementState) {
		this.settlementState = settlementState;
	}

	/**
	 * @return the batchStatisticsList
	 */
	public ArrayList<BatchStatistics> getBatchStatisticsList() {
		return batchStatisticsList;
	}

	/**
	 * Add batch statistics object to the existing list.
	 *
	 * @param batchStatistics
	 */
	public void addBatchStatistics(BatchStatistics batchStatistics) {
		if(this.batchStatisticsList == null) {
			this.batchStatisticsList = new ArrayList<BatchStatistics>();
		}

		this.batchStatisticsList.add(batchStatistics);
	}

	/**
	 * @param batchStatisticsList the batchStatisticsList to set
	 */
	public void setBatchStatisticsList(
			ArrayList<BatchStatistics> batchStatisticsList) {
		this.batchStatisticsList = batchStatisticsList;
	}

	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}

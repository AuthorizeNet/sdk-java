package net.authorize.data;

import java.io.Serializable;
import java.math.BigDecimal;

import net.authorize.aim.Transaction;
import net.authorize.util.StringUtils;

/**
 * Shipping charges (tax, freight/shipping, duty)
 *
 */
public class ShippingCharges implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final int MAX_PO_NUMBER_LENGTH = 25;

	private String taxItemName;
	private String taxDescription;
	private BigDecimal taxAmount = new BigDecimal(0.00);

	private String freightItemName;
	private String freightDescription;
	private BigDecimal freightAmount = new BigDecimal(0.00);

	private String dutyItemName;
	private String dutyItemDescription;
	private BigDecimal dutyAmount = new BigDecimal(0.00);

	private boolean taxExempt = false;
	private String purchaseOrderNumber;

	private ShippingCharges() { }

	public static ShippingCharges createShippingCharges() {
		return new ShippingCharges();
	}

	/**
	 * @return the taxItemName
	 */
	public String getTaxItemName() {
		return taxItemName;
	}

	/**
	 * @param taxItemName
	 *            the taxItemName to set
	 */
	public void setTaxItemName(String taxItemName) {
		this.taxItemName = taxItemName;
	}

	/**
	 * @return the taxDescription
	 */
	public String getTaxDescription() {
		return taxDescription;
	}

	/**
	 * @param taxDescription
	 *            the taxDescription to set
	 */
	public void setTaxDescription(String taxDescription) {
		this.taxDescription = taxDescription;
	}

	/**
	 * @return the taxAmount
	 */
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	/**
	 * @param taxAmount
	 *            the taxAmount to set
	 */
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	/**
	 * @param taxAmount
	 *            the taxAmount to set
	 */
	public void setTaxAmount(String taxAmount) {
		if(StringUtils.isNotEmpty(taxAmount)) {
			this.taxAmount = new BigDecimal(taxAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the freightItemName
	 */
	public String getFreightItemName() {
		return freightItemName;
	}

	/**
	 * @param freightItemName
	 *            the freightItemName to set
	 */
	public void setFreightItemName(String freightItemName) {
		this.freightItemName = freightItemName;
	}

	/**
	 * @return the freightDescription
	 */
	public String getFreightDescription() {
		return freightDescription;
	}

	/**
	 * @param freightDescription
	 *            the freightDescription to set
	 */
	public void setFreightDescription(String freightDescription) {
		this.freightDescription = freightDescription;
	}

	/**
	 * @return the freightAmount
	 */
	public BigDecimal getFreightAmount() {
		return freightAmount;
	}

	/**
	 * @param freightAmount
	 *            the freightAmount to set
	 */
	public void setFreightAmount(BigDecimal freightAmount) {
		this.freightAmount = freightAmount;
	}

	/**
	 * @param freightAmount
	 *            the freightAmount to set
	 */
	public void setFreightAmount(String freightAmount) {
		if(StringUtils.isNotEmpty(freightAmount)) {
			this.freightAmount = new BigDecimal(freightAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the dutyItemName
	 */
	public String getDutyItemName() {
		return dutyItemName;
	}

	/**
	 * @param dutyItemName
	 *            the dutyItemName to set
	 */
	public void setDutyItemName(String dutyItemName) {
		this.dutyItemName = dutyItemName;
	}

	/**
	 * @return the dutyItemDescription
	 */
	public String getDutyItemDescription() {
		return dutyItemDescription;
	}

	/**
	 * @param dutyItemDescription
	 *            the dutyItemDescription to set
	 */
	public void setDutyItemDescription(String dutyItemDescription) {
		this.dutyItemDescription = dutyItemDescription;
	}

	/**
	 * @return the dutyAmount
	 */
	public BigDecimal getDutyAmount() {
		return dutyAmount;
	}

	/**
	 * @param dutyAmount
	 *            the dutyAmount to set
	 */
	public void setDutyAmount(BigDecimal dutyAmount) {
		this.dutyAmount = dutyAmount;
	}

	/**
	 * @param dutyAmount
	 *            the dutyAmount to set
	 */
	public void setDutyAmount(String dutyAmount) {
		if(StringUtils.isNotEmpty(dutyAmount)) {
			this.dutyAmount = new BigDecimal(dutyAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the taxExempt
	 */
	public boolean isTaxExempt() {
		return taxExempt;
	}

	/**
	 * @param taxExempt
	 *            the taxExempt to set
	 */
	public void setTaxExempt(boolean taxExempt) {
		this.taxExempt = taxExempt;
	}

	/**
	 * @return the purchaseOrderNumber
	 */
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	/**
	 * @param purchaseOrderNumber
	 *            the purchaseOrderNumber to set
	 */
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

}

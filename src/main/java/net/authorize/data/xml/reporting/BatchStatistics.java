package net.authorize.data.xml.reporting;

import java.math.BigDecimal;

import net.authorize.aim.Transaction;
import net.authorize.data.creditcard.CardType;
import net.authorize.util.StringUtils;

/**
 * Batch statistical data.
 */
public class BatchStatistics {

	private CardType accountType;
	private BigDecimal chargeAmount;
	private long chargeCount = 0;
	private BigDecimal refundAmount;
	private long refundCount = 0;
	private long voidCount = 0;
	private long declineCount = 0;
	private long errorCount = 0;
	private BigDecimal returnedItemAmount;
	private long returnedItemCount = 0;
	private BigDecimal ChargebackAmount;
	private long ChargebackCount = 0;
	private long correctionNoticeCount = 0;
	private BigDecimal chargeChargebackAmount;
	private long chargeChargebackCount = 0;
	private BigDecimal refundChargebackAmount;
	private long refundChargebackCount = 0;
	private BigDecimal chargeReturnedItemsAmount;
	private long chargeReturnedItemsCount = 0;
	private BigDecimal refundReturnedItemsAmount;
	private long refundReturnedItemsCount = 0;

	private BatchStatistics() {
		chargeAmount = new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		chargeCount = 0;
		refundAmount = new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		refundCount = 0;
		voidCount = 0;
		declineCount = 0;
		errorCount = 0;
		returnedItemAmount = new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		returnedItemCount = 0;
		ChargebackAmount = new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		ChargebackCount = 0;
		correctionNoticeCount = 0;
		chargeChargebackAmount = new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		chargeChargebackCount = 0;
		refundChargebackAmount = new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		refundChargebackCount = 0;
		chargeReturnedItemsAmount = new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		chargeReturnedItemsCount = 0;
		refundReturnedItemsAmount = new BigDecimal(0.00).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		refundReturnedItemsCount = 0;
	}

	public static BatchStatistics createBatchStatistics() {
		return new BatchStatistics();
	}

	/**
	 * @return the accountType
	 */
	public CardType getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(CardType accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the chargeAmount
	 */
	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	/**
	 * @param chargeAmount the chargeAmount to set
	 */
	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	/**
	 * @param chargeAmount the chargeAmount to set
	 */
	public void setChargeAmount(String chargeAmount) {
		if(StringUtils.isNotEmpty(chargeAmount)) {
			this.chargeAmount = new BigDecimal(chargeAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the chargeCount
	 */
	public long getChargeCount() {
		return chargeCount;
	}

	/**
	 * @param chargeCount the chargeCount to set
	 */
	public void setChargeCount(long chargeCount) {
		this.chargeCount = chargeCount;
	}

	/**
	 * @param chargeCount the chargeCount to set
	 */
	public void setChargeCount(String chargeCount) {
		if(StringUtils.isNotEmpty(chargeCount)) {
			this.chargeCount = Long.parseLong(chargeCount);
		}
	}

	/**
	 * @return the refundAmount
	 */
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	/**
	 * @param refundAmount the refundAmount to set
	 */
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	/**
	 * @param refundAmount the refundAmount to set
	 */
	public void setRefundAmount(String refundAmount) {
		if(StringUtils.isNotEmpty(refundAmount)) {
			this.refundAmount = new BigDecimal(refundAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the refundCount
	 */
	public long getRefundCount() {
		return refundCount;
	}

	/**
	 * @param refundCount the refundCount to set
	 */
	public void setRefundCount(long refundCount) {
		this.refundCount = refundCount;
	}

	/**
	 * @param refundCount the refundCount to set
	 */
	public void setRefundCount(String refundCount) {
		if(StringUtils.isNotEmpty(refundCount)) {
			this.refundCount = Long.parseLong(refundCount);
		}
	}

	/**
	 * @return the voidCount
	 */
	public long getVoidCount() {
		return voidCount;
	}

	/**
	 * @param voidCount the voidCount to set
	 */
	public void setVoidCount(long voidCount) {
		this.voidCount = voidCount;
	}

	/**
	 * @param voidCount the voidCount to set
	 */
	public void setVoidCount(String voidCount) {
		if(StringUtils.isNotEmpty(voidCount)) {
			this.voidCount = Long.parseLong(voidCount);
		}
	}

	/**
	 * @return the declineCount
	 */
	public long getDeclineCount() {
		return declineCount;
	}

	/**
	 * @param declineCount the declineCount to set
	 */
	public void setDeclineCount(long declineCount) {
		this.declineCount = declineCount;
	}

	/**
	 * @param declineCount the declineCount to set
	 */
	public void setDeclineCount(String declineCount) {
		if(StringUtils.isNotEmpty(declineCount)) {
			this.declineCount = Long.parseLong(declineCount);
		}
	}

	/**
	 * @return the errorCount
	 */
	public long getErrorCount() {
		return errorCount;
	}

	/**
	 * @param errorCount the errorCount to set
	 */
	public void setErrorCount(long errorCount) {
		this.errorCount = errorCount;
	}

	/**
	 * @param errorCount the errorCount to set
	 */
	public void setErrorCount(String errorCount) {
		if(StringUtils.isNotEmpty(errorCount)) {
			this.errorCount = Long.parseLong(errorCount);
		}
	}

	/**
	 * @return the returnedItemAmount
	 */
	public BigDecimal getReturnedItemAmount() {
		return returnedItemAmount;
	}

	/**
	 * @param returnedItemAmount the returnedItemAmount to set
	 */
	public void setReturnedItemAmount(BigDecimal returnedItemAmount) {
		this.returnedItemAmount = returnedItemAmount;
	}

	/**
	 * @param returnedItemAmount the returnedItemAmount to set
	 */
	public void setReturnedItemAmount(String returnedItemAmount) {
		if(StringUtils.isNotEmpty(returnedItemAmount)) {
			this.returnedItemAmount = new BigDecimal(returnedItemAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the returnedItemCount
	 */
	public long getReturnedItemCount() {
		return returnedItemCount;
	}

	/**
	 * @param returnedItemCount the returnedItemCount to set
	 */
	public void setReturnedItemCount(long returnedItemCount) {
		this.returnedItemCount = returnedItemCount;
	}

	/**
	 * @param returnedItemCount the returnedItemCount to set
	 */
	public void setReturnedItemCount(String returnedItemCount) {
		if(StringUtils.isNotEmpty(returnedItemCount)) {
			this.returnedItemCount = Long.parseLong(returnedItemCount);
		}
	}

	/**
	 * @return the ChargebackAmount
	 */
	public BigDecimal getChargebackAmount() {
		return ChargebackAmount;
	}

	/**
	 * @param ChargebackAmount the ChargebackAmount to set
	 */
	public void setChargebackAmount(BigDecimal ChargebackAmount) {
		this.ChargebackAmount = ChargebackAmount;
	}

	/**
	 * @param ChargebackAmount the ChargebackAmount to set
	 */
	public void setChargebackAmount(String ChargebackAmount) {
		if(StringUtils.isNotEmpty(ChargebackAmount)) {
			this.ChargebackAmount = new BigDecimal(ChargebackAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the ChargebackCount
	 */
	public long getChargebackCount() {
		return ChargebackCount;
	}

	/**
	 * @param ChargebackCount the ChargebackCount to set
	 */
	public void setChargebackCount(long ChargebackCount) {
		this.ChargebackCount = ChargebackCount;
	}

	/**
	 * @param ChargebackCount the ChargebackCount to set
	 */
	public void setChargebackCount(String ChargebackCount) {
		if(StringUtils.isNotEmpty(ChargebackCount)) {
			this.ChargebackCount = Long.parseLong(ChargebackCount);
		}
	}

	/**
	 * @return the correctionNoticeCount
	 */
	public long getCorrectionNoticeCount() {
		return correctionNoticeCount;
	}

	/**
	 * @param correctionNoticeCount the correctionNoticeCount to set
	 */
	public void setCorrectionNoticeCount(long correctionNoticeCount) {
		this.correctionNoticeCount = correctionNoticeCount;
	}

	/**
	 * @param correctionNoticeCount the correctionNoticeCount to set
	 */
	public void setCorrectionNoticeCount(String correctionNoticeCount) {
		if(StringUtils.isNotEmpty(correctionNoticeCount)) {
			this.correctionNoticeCount = Long.parseLong(correctionNoticeCount);
		}
	}

	/**
	 * @return the chargeChargebackAmount
	 */
	public BigDecimal getChargeChargebackAmount() {
		return chargeChargebackAmount;
	}

	/**
	 * @param chargeChargebackAmount the chargeChargebackAmount to set
	 */
	public void setChargeChargebackAmount(BigDecimal chargeChargebackAmount) {
		this.chargeChargebackAmount = chargeChargebackAmount;
	}

	/**
	 * @param chargeChargebackAmount the chargeChargebackAmount to set
	 */
	public void setChargeChargebackAmount(String chargeChargebackAmount) {
		if(StringUtils.isNotEmpty(chargeChargebackAmount)) {
			this.chargeChargebackAmount = new BigDecimal(chargeChargebackAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the chargeChargebackCount
	 */
	public long getChargeChargebackCount() {
		return chargeChargebackCount;
	}

	/**
	 * @param chargeChargebackCount the chargeChargebackCount to set
	 */
	public void setChargeChargebackCount(long chargeChargebackCount) {
		this.chargeChargebackCount = chargeChargebackCount;
	}

	/**
	 * @param chargeChargebackCount the chargeChargebackCount to set
	 */
	public void setChargeChargebackCount(String chargeChargebackCount) {
		if(StringUtils.isNotEmpty(chargeChargebackCount)) {
			this.chargeChargebackCount = Long.parseLong(chargeChargebackCount);
		}
	}

	/**
	 * @return the refundChargebackAmount
	 */
	public BigDecimal getRefundChargebackAmount() {
		return refundChargebackAmount;
	}

	/**
	 * @param refundChargebackAmount the refundChargebackAmount to set
	 */
	public void setRefundChargebackAmount(BigDecimal refundChargebackAmount) {
		this.refundChargebackAmount = refundChargebackAmount;
	}

	/**
	 * @param refundChargebackAmount the refundChargebackAmount to set
	 */
	public void setRefundChargebackAmount(String refundChargebackAmount) {
		if(StringUtils.isNotEmpty(refundChargebackAmount)) {
			this.refundChargebackAmount = new BigDecimal(refundChargebackAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the refundChargebackCount
	 */
	public long getRefundChargebackCount() {
		return refundChargebackCount;
	}

	/**
	 * @param refundChargebackCount the refundChargebackCount to set
	 */
	public void setRefundChargebackCount(long refundChargebackCount) {
		this.refundChargebackCount = refundChargebackCount;
	}

	/**
	 * @param refundChargebackCount the refundChargebackCount to set
	 */
	public void setRefundChargebackCount(String refundChargebackCount) {
		if(StringUtils.isNotEmpty(refundChargebackCount)) {
			this.refundChargebackCount = Long.parseLong(refundChargebackCount);
		}
	}

	/**
	 * @return the chargeReturnedItemsAmount
	 */
	public BigDecimal getChargeReturnedItemsAmount() {
		return chargeReturnedItemsAmount;
	}

	/**
	 * @param chargeReturnedItemsAmount the chargeReturnedItemsAmount to set
	 */
	public void setChargeReturnedItemsAmount(BigDecimal chargeReturnedItemsAmount) {
		this.chargeReturnedItemsAmount = chargeReturnedItemsAmount;
	}

	/**
	 * @param chargeReturnedItemsAmount the chargeReturnedItemsAmount to set
	 */
	public void setChargeReturnedItemsAmount(String chargeReturnedItemsAmount) {
		if(StringUtils.isNotEmpty(chargeReturnedItemsAmount)) {
			this.chargeReturnedItemsAmount = new BigDecimal(chargeReturnedItemsAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the chargeReturnedItemsCount
	 */
	public long getChargeReturnedItemsCount() {
		return chargeReturnedItemsCount;
	}

	/**
	 * @param chargeReturnedItemsCount the chargeReturnedItemsCount to set
	 */
	public void setChargeReturnedItemsCount(long chargeReturnedItemsCount) {
		this.chargeReturnedItemsCount = chargeReturnedItemsCount;
	}

	/**
	 * @param chargeReturnedItemsCount the chargeReturnedItemsCount to set
	 */
	public void setChargeReturnedItemsCount(String chargeReturnedItemsCount) {
		if(StringUtils.isNotEmpty(chargeReturnedItemsCount)) {
			this.chargeReturnedItemsCount = Long.parseLong(chargeReturnedItemsCount);
		}
	}

	/**
	 * @return the refundReturnedItemsAmount
	 */
	public BigDecimal getRefundReturnedItemsAmount() {
		return refundReturnedItemsAmount;
	}

	/**
	 * @param refundReturnedItemsAmount the refundReturnedItemsAmount to set
	 */
	public void setRefundReturnedItemsAmount(BigDecimal refundReturnedItemsAmount) {
		this.refundReturnedItemsAmount = refundReturnedItemsAmount;
	}

	/**
	 * @param refundReturnedItemsAmount the refundReturnedItemsAmount to set
	 */
	public void setRefundReturnedItemsAmount(String refundReturnedItemsAmount) {
		if(StringUtils.isNotEmpty(refundReturnedItemsAmount)) {
			this.refundReturnedItemsAmount = new BigDecimal(refundReturnedItemsAmount).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the refundReturnedItemsCount
	 */
	public long getRefundReturnedItemsCount() {
		return refundReturnedItemsCount;
	}

	/**
	 * @param refundReturnedItemsCount the refundReturnedItemsCount to set
	 */
	public void setRefundReturnedItemsCount(long refundReturnedItemsCount) {
		this.refundReturnedItemsCount = refundReturnedItemsCount;
	}

	/**
	 * @param refundReturnedItemsCount the refundReturnedItemsCount to set
	 */
	public void setRefundReturnedItemsCount(String refundReturnedItemsCount) {
		if(StringUtils.isNotEmpty(refundReturnedItemsCount)) {
			this.chargeReturnedItemsCount = Long.parseLong(refundReturnedItemsCount);
		}
	}
}

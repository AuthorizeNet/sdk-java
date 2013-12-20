package net.authorize.data.xml.reporting;

/**
 * Transaction status enumeration.
 */
public enum TransactionStatusType {
	AUTHORIZED_PENDING_CAPTURE("authorizedPendingCapture"),
	CAPTURED_PENDING_SETTLEMENT("capturedPendingSettlement"),
	COMMUNICATION_ERROR("communicationError"),
	REFUND_SETTLED_SUCCESSFULLY("refundSettledSuccessfully"),
	REFUND_PENDING_SETTLEMENT("refundPendingSettlement"),
	APPROVED_REVIEW("approvedReview"),
	DECLINED("declined"),
	COULD_NOT_VOID("couldNotVoid"),
	EXPIRED("expired"),
	GENERAL_ERROR("generalError"),
	PENDING_FINAL_SETTLEMENT("pendingFinalSettlement"),
	PENDING_SETTLEMENT("pendingSettlement"),
	FAILED_REVIEW("failedReview"),
	SETTLED_SUCCESSFULLY("settledSuccessfully"),
	SETTLEMENT_ERROR("settlementError"),
	UNDER_REVIEW("underReview"),
	UPDATING_SETTLEMENT("updatingSettlement"),
	VOIDED("voided"),
	FDS_PENDING_REVIEW("FDSPendingReview"),
	FDS_AUTHORIZED_PENDING_REVIEW("FDSAuthorizedPendingReview"),
	RETURNED_ITEM("returnedItem"),
	CHARGEBACK("chargeback"),
	CHARGEBACK_REVERSAL("chargebackReversal"),
	AUTHORIZED_PENDING_RELEASE("authorizedPendingRelease");

    private final String value;

    private TransactionStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionStatusType fromValue(String v) {
        for (TransactionStatusType c: TransactionStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }

        return null;
    }

}

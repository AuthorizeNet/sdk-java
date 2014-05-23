
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SettlementState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SettlementState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Settle"/>
 *     &lt;enumeration value="SettledSuccessfully"/>
 *     &lt;enumeration value="SettledWithError"/>
 *     &lt;enumeration value="OutOfBalance"/>
 *     &lt;enumeration value="SettleCurrencyUnsupported"/>
 *     &lt;enumeration value="NoTransactionsInHostBatch"/>
 *     &lt;enumeration value="CardTypeNotSupported"/>
 *     &lt;enumeration value="MerchantNotSetupSettlement"/>
 *     &lt;enumeration value="DatabaseError"/>
 *     &lt;enumeration value="CommunicationError"/>
 *     &lt;enumeration value="BatchTransactionMismatch"/>
 *     &lt;enumeration value="ProcessorSettlementError"/>
 *     &lt;enumeration value="RequestCurrencyUnsupportedByMerchant"/>
 *     &lt;enumeration value="SettlerError"/>
 *     &lt;enumeration value="PendingSettlement"/>
 *     &lt;enumeration value="Updating"/>
 *     &lt;enumeration value="PendingFinalSettlement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SettlementState")
@XmlEnum
public enum SettlementState {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Settle")
    SETTLE("Settle"),
    @XmlEnumValue("SettledSuccessfully")
    SETTLED_SUCCESSFULLY("SettledSuccessfully"),
    @XmlEnumValue("SettledWithError")
    SETTLED_WITH_ERROR("SettledWithError"),
    @XmlEnumValue("OutOfBalance")
    OUT_OF_BALANCE("OutOfBalance"),
    @XmlEnumValue("SettleCurrencyUnsupported")
    SETTLE_CURRENCY_UNSUPPORTED("SettleCurrencyUnsupported"),
    @XmlEnumValue("NoTransactionsInHostBatch")
    NO_TRANSACTIONS_IN_HOST_BATCH("NoTransactionsInHostBatch"),
    @XmlEnumValue("CardTypeNotSupported")
    CARD_TYPE_NOT_SUPPORTED("CardTypeNotSupported"),
    @XmlEnumValue("MerchantNotSetupSettlement")
    MERCHANT_NOT_SETUP_SETTLEMENT("MerchantNotSetupSettlement"),
    @XmlEnumValue("DatabaseError")
    DATABASE_ERROR("DatabaseError"),
    @XmlEnumValue("CommunicationError")
    COMMUNICATION_ERROR("CommunicationError"),
    @XmlEnumValue("BatchTransactionMismatch")
    BATCH_TRANSACTION_MISMATCH("BatchTransactionMismatch"),
    @XmlEnumValue("ProcessorSettlementError")
    PROCESSOR_SETTLEMENT_ERROR("ProcessorSettlementError"),
    @XmlEnumValue("RequestCurrencyUnsupportedByMerchant")
    REQUEST_CURRENCY_UNSUPPORTED_BY_MERCHANT("RequestCurrencyUnsupportedByMerchant"),
    @XmlEnumValue("SettlerError")
    SETTLER_ERROR("SettlerError"),
    @XmlEnumValue("PendingSettlement")
    PENDING_SETTLEMENT("PendingSettlement"),
    @XmlEnumValue("Updating")
    UPDATING("Updating"),
    @XmlEnumValue("PendingFinalSettlement")
    PENDING_FINAL_SETTLEMENT("PendingFinalSettlement");
    private final String value;

    SettlementState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SettlementState fromValue(String v) {
        for (SettlementState c: SettlementState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

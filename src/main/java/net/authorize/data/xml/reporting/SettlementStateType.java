package net.authorize.data.xml.reporting;

/**
 * Settlement state enumeration.
 */
public enum SettlementStateType {
	SETTLED_SUCCESSFULLY("settledSuccessfully"),
	ERROR("settlementError"),
	PENDING_SETTLEMENT("pendingSettlement");

    private final String value;

    private SettlementStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SettlementStateType fromValue(String v) {
        for (SettlementStateType c: SettlementStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }

        return null;
    }

}

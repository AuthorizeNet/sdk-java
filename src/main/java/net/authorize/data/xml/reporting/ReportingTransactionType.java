package net.authorize.data.xml.reporting;

/**
 * ReportingTransactionType enumeration.
 */
public enum ReportingTransactionType {

	AUTH_CAPTURE("authCaptureTransaction"),
	AUTH_ONLY("authOnlyTransaction"),
	CAPTURE_ONLY("captureOnlyTransaction"),
	REFUND("refundTransaction");

    private final String value;

    private ReportingTransactionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReportingTransactionType fromValue(String v) {
        for (ReportingTransactionType c: ReportingTransactionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }

        return null;
    }

}


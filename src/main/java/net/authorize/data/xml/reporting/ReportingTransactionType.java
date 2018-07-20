package net.authorize.data.xml.reporting;

/**
 * ReportingTransactionType enumeration.
 * 
 * @deprecated since version 1.9.8
 * @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
 * @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API.
 * @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
 * @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-php/tree/master/PaymentTransactions.
 * @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
 *
 */
@Deprecated
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


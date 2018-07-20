package net.authorize.data.xml.reporting;

/**
 * Settlement state enumeration.
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

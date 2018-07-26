package net.authorize.data.xml.reporting;

/**
 * The action taken for a transaction that triggered one or more of the
 * Advanced Fraud Detection Suite filters.
 * 
 * @deprecated since version 1.9.8
 * @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
 * @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API (package: net.authorize.api.*).
 * @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
 * @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/PaymentTransactions.
 * @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
 *
 */
@Deprecated
public enum FDSFilterActionType {
	REJECT("reject"),
	DECLINE("decline"),
	HOLD("hold"),
	AUTH_AND_HOLD("authAndHold"),
	REPORT("report");

	private final String value;

	private FDSFilterActionType(String value) {
		this.value = value;
	}

	public static FDSFilterActionType findByValue(String value) {
		if(value != null) {
			for(FDSFilterActionType filterAction : values()) {
				if(filterAction.value.equals(value)) {
					return filterAction;
				}
			}
		}

		return null;
	}

}

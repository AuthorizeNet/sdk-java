package net.authorize.data.echeck;

import java.io.Serializable;

/**
 * eCheck.Net transaction types supported by the Authorize.Net Payment Gateway
 *
 * ARC - Accounts Receivable Conversion
 * BOC - Back Office Conversion
 * CCD - Cash Concentration or Disbursement
 * PPD - Prearranged Payment and Deposit Entry
 * TEL - Telephone-Initiated Entry
 * WEB - Internet-Initiated Entry
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
public enum ECheckType implements Serializable {
	ARC("ARC"),
	BOC("BOC"),
	CCD("CCD"),
	PPD("PPD"),
	TEL("TEL"),
	WEB("WEB"),
	UNKNOWN("UNKNOWN");

	private final String value;

	private ECheckType(String value) {
		this.value = value;
	}

	public static ECheckType findByValue(String value) {
		for(ECheckType echeckType : values()) {
			if(echeckType.value.equals(value)) {
				return echeckType;
			}
		}

		return ECheckType.UNKNOWN;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}

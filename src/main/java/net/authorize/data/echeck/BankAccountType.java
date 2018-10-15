package net.authorize.data.echeck;

import java.io.Serializable;

/**
 * Supported bank account types.
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
public enum BankAccountType implements Serializable {
	CHECKING("checking", "CHECKING"),
	BUSINESSCHECKING("businessChecking","BUSINESSCHECKING"),
	SAVINGS("savings","SAVINGS"),
	UNKNOWN("unknown","UNKNOWN");

	private final String value;
	private final String value2;

	private BankAccountType(String value, String value2) {
		this.value = value;
		this.value2 = value2;
	}

	public static BankAccountType findByValue(String value) {
		for(BankAccountType bankAccountType : values()) {
			if(bankAccountType.value.equals(value)|| 
					bankAccountType.value2.equals(value)) {
				return bankAccountType;
			}
		}

		return BankAccountType.UNKNOWN;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	


}

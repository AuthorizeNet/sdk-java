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
 */
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

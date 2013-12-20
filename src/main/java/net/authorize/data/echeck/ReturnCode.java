package net.authorize.data.echeck;


public enum ReturnCode {
	R01("R01", "Insufficient Funds (NSF)", "Insufficient Funds"),
	R02("R02", "Administrative Return", "Account Closed"),
	R03("R03", "Administrative Return", "No Account/Unable to Locate Account"),
	R04("R04", "Administrative Return", "Invalid Account Number"),
	R05("R05", "Administrative Return", "Unauthorized Debit to Consumer Account Using Corporate SEC Code"),
	R06("R06", "Administrative Return", "Returned per ODFI Request"),
	R07("R07", "Chargeback", "Authorization Revoked by Customer"),
	R08("R08", "Chargeback", "Payment Stopped by Customer"),
	R09("R09", "Insufficient Funds (NSF)", "Uncollected Funds"),
	R10("R10", "Chargeback", "Customer Advises Unauthorized"),
	R12("R12", "Administrative Return", "Branch Sold to Another DFI"),
	R13("R13", "Administrative Return", "RDFI Not Qualified to Participate"),
	R14("R14", "Administrative Return", "Representativ e Payee Deceased"),
	R15("R15", "Administrative Return", "Beneficiary or Account Holder Deceased"),
	R16("R16", "Administrative Return", "Account Frozen"),
	R17("R17", "Administrative Return", "RDFI Cannot Process"),
	R20("R20", "Administrative Return", "Non- Transaction Account"),
	R23("R23", "Administrative Return", "Credit Refused by Customer"),
	R24("R24", "Administrative Return", "Duplicate Entry"),
	R29("R29", "Chargeback", "Corporate Customer Advises Not Authorized"),
	R30("R30", "Administrative Return", "RDFI is Not an ACH Participant"),
	R31("R31", "Administrative Return", "Permissible Return"),
	R32("R32", "Administrative Return", "RDFI is not a Settlement RDFI"),
	R34("R34", "Administrative Return", "RDFI not Qualified to Participate"),
	R35("R35", "Administrative Return", "Return of Improper Debit Entry"),
	R36("R36", "Administrative Return", "Return of Improper Credit Entry");

	private final String code;
	private final String returnType;
	private final String shortTitle;

	private ReturnCode(String code, String returnType, String shortTitle) {
		this.code = code;
		this.returnType = returnType;
		this.shortTitle = shortTitle;
	}

	public static ReturnCode findByCode(String code) {
		for(ReturnCode returnCode : values()) {
			if(returnCode.code.equals(code)) {
				return returnCode;
			}
		}

		return null;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the returnType
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * @return the shortTitle
	 */
	public String getShortTitle() {
		return shortTitle;
	}


}

package net.authorize.data.echeck;


/**
 * ACH notice of change (NOC) codes that may be received from the customer's
 * bank in the event of a discrepancy in the bank information provided with the transaction.
 *
 */
public enum NOCCode {
	C01("C01", "Incorrect DFI account number", "The customer's bank account number is incorrect."),
	C02("C02", "Incorrect routing number", "The bank's ABA routing number is incorrect."),
	C03("C03", "Incorrect routing number and incorrect DFI account number", "The bank's ABA routing number is incorrect and as a result the bank account number structure is also incorrect."),
	C04("C04", "Incorrect individual name / receiving company name", "The individual or company name associated with the bank account is incorrect."),
	C05("C05", "Incorrect transaction code", "The transaction was submitted to a certain account type but includes a conflicting account type code (checking / savings)."),
	C06("C06", "Incorrect DFI account number and incorrect transaction code", "The customer's bank account number is incorrect and the transaction should be submitted to a different account type (checking / savings)."),
	C07("C07", "Incorrect routing number, incorrect DFI account number, and incorrect transaction code", "The bank's ABA routing number and the bank account number are incorrect; and the transaction was submitted to a certain account type but includes a conflicting account type code (checking / savings).");

	private final String code;
	private final String nocReason;
	private final String description;

	private NOCCode(String code, String nocReason, String description) {
		this.code = code;
		this.nocReason = nocReason;
		this.description = description;
	}

	public static NOCCode findByCode(String code) {
		for(NOCCode nocCode : values()) {
			if(nocCode.code.equals(code)) {
				return nocCode;
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
	 * @return the nocReason
	 */
	public String getNocReason() {
		return nocReason;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


}

package net.authorize;

/**
 *	Determines which environment to post transactions against.
 *  By placing the merchant's payment gateway account in Test Mode in the
 *  Merchant Interface. New payment gateway accounts are placed in Test Mode
 *  by default. For more information about Test Mode, see the Merchant
 *  Integration Guide at http://www.authorize.net/support/merchant/.
 *
 *  When processing test transactions in Test Mode, the payment gateway will
 *  return a transaction ID of "0." This means you cannot test follow-on
 *  transactions, for example, credits, voids, etc., while in Test Mode.
 *  To test follow-on transactions, you can either submit x_test_request=TRUE
 *  as indicated above, or process a test transaction with any valid credit card
 *  number in live mode, as explained below.
 *
 *  Note: Transactions posted against live merchant accounts using either of
 *  the above testing methods are not submitted to financial institutions for
 *  authorization and are not stored in the Merchant Interface.
 *
 *  If testing in the live environment is successful, you are ready to submit
 *  live transactions and verify that they are being submitted successfully.
 *  Either remove the x_test_request field from the transaction request string,
 *  or set it to "FALSE;" or, if you are using Test Mode, turn it off in the
 *  Merchant Interface. To receive a true response, you must submit a
 *  transaction using a real credit card number. You can use any valid credit
 *  card number to submit a test transaction. You can void successful
 *  transactions immediately to prevent live test transactions from being
 *  processed. This can be done quickly on the Unsettled Transactions page of
 *  the Merchant Interface. It is recommended that when testing using a live
 *  credit card, you use a nominal value, such as $0.01. That way, if you forget
 *  to void the transaction, the impact will be minimal. For VISA verification
 *  transactions, submit a $0.00 value instead, if the processor accepts it.
 */
public enum Environment {
	SANDBOX("https://test.authorize.net","https://apitest.authorize.net","https://test.authorize.net"),
	SANDBOX_TESTMODE("https://test.authorize.net","https://apitest.authorize.net","https://test.authorize.net"),
	PRODUCTION("https://secure.authorize.net","https://api.authorize.net","https://cardpresent.authorize.net"),
	PRODUCTION_TESTMODE("https://secure.authorize.net","https://api.authorize.net","https://cardpresent.authorize.net"),
	CUSTOM(null,null,null);

	private String baseUrl;
	private String xmlBaseUrl;
	private String cardPresentUrl;

	private Environment(String baseUrl, String xmlBaseUrl, String cardPresentUrl) {
		this.baseUrl = baseUrl;
		this.xmlBaseUrl = xmlBaseUrl;
		this.cardPresentUrl = cardPresentUrl;
	}

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * @return the xmlBaseUrl
	 */
	public String getXmlBaseUrl() {
		return xmlBaseUrl;
	}

	/**
	 * @return the cardPresentUrl
	 */
	public String getCardPresentUrl() {
		return cardPresentUrl;
	}

	/**
	 * If a custom environment needs to be supported, this convenience create
	 * method can be used to pass in a custom baseUrl.
	 *
	 * @param baseUrl
	 * @param xmlBaseUrl
	 * @return Environment object
	 */
	public static Environment createEnvironment(String baseUrl, String xmlBaseUrl) {
		Environment environment = Environment.CUSTOM;
		environment.baseUrl = baseUrl;
		environment.xmlBaseUrl = xmlBaseUrl;

		return environment;
	}

	/**
	 * If a custom environment needs to be supported, this convenience create
	 * method can be used to pass in a custom baseUrl.
	 *
	 * @param baseUrl
	 * @param xmlBaseUrl
	 * @param cardPresentUrl
	 *
	 * @return Environment object
	 */
	public static Environment createEnvironment(String baseUrl, String xmlBaseUrl, String cardPresentUrl) {
		Environment environment = Environment.CUSTOM;
		environment.baseUrl = baseUrl;
		environment.xmlBaseUrl = xmlBaseUrl;
		environment.cardPresentUrl = cardPresentUrl;

		return environment;
	}
}

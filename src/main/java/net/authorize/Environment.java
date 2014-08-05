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
	SANDBOX("https://sandbox.authorize.net","https://apitest.authorize.net","https://sandbox.authorize.net"),
	SANDBOX_TESTMODE("https://sandbox.authorize.net","https://apitest.authorize.net","https://sandbox.authorize.net"),
	PRODUCTION("https://secure.authorize.net","https://api.authorize.net","https://cardpresent.authorize.net"),
	PRODUCTION_TESTMODE("https://secure.authorize.net","https://api.authorize.net","https://cardpresent.authorize.net"),
	LOCAL_VM("http://WW725RAMITTAL1","http://WW725RAMITTAL1/xml/v1/request.api","http://WW725RAMITTAL1/xml/v1/request.api"),
	HOSTED_VM("http://WW758AKALGI02.qa.intra","http://WW758AKALGI02.qa.intra/xml/v1/request.api","http://WW758AKALGI02.qa.intra/xml/v1/request.api"),
	CUSTOM(null,null,null);
	//http://ww725ramittal1.qa.intra/xml/v1/request.api	

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
	
	/**
	 * Reads a integer value from property file and/or the environment
	 * Values in property file supersede the values set in environment
	 * @param propertyName name of the integer property to read
	 * @return int property value
	 */
	public static int getIntProperty( String propertyName) 
	{
		int value = 0;
		String stringValue = getProperty(propertyName);
		value = (net.authorize.util.StringUtils.parseInt(stringValue));
		
		return value;
	}

	/**
	 * Reads a boolean value from property file and/or the environment
	 * Values in property file supersede the values set in environment
	 * @param propertyName name of the boolean property to read
	 * @return boolean property value
	 */
	public static boolean getBooleanProperty( String propertyName) 
	{
		boolean value = false;
		String stringValue = getProperty(propertyName);
		if ( null != stringValue)
		{
			value = Boolean.parseBoolean(stringValue.trim()); 
		}
		
		return value;
	}

	/**
	 * Reads the value from property file and/or the environment
	 * Values in property file supersede the values set in environment
	 * @param propertyName name of the property to read
	 * @return String property value
	 */
	public static String getProperty(String propertyName) {
		String stringValue = null;
		
		String propValue = System.getProperty(propertyName);
		String envValue = System.getenv(propertyName);
		if ( null != propValue && propValue.trim().length() > 0 )
		{
			stringValue = propValue;
		}
		else if ( null != envValue && envValue.trim().length() > 0 )
		{
			stringValue = envValue;
		}
		return stringValue;
	}
}

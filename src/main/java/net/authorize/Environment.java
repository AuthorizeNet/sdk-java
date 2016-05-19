package net.authorize;

/*================================================================================
* 
* Determines the target environment to post transactions.
*
* SANDBOX should be used for testing. Transactions submitted to the sandbox 
* will not result in an actual card payment. Instead, the sandbox simulates 
* the response. Use the Testing Guide to generate specific gateway responses.
*
* PRODUCTION connects to the production gateway environment.
*
*===============================================================================*/
public enum Environment {
	SANDBOX("https://test.authorize.net","https://apitest.authorize.net","https://test.authorize.net"),
	PRODUCTION("https://secure2.authorize.net","https://api2.authorize.net","https://cardpresent.authorize.net"),
	LOCAL_VM(null,null,null),
	HOSTED_VM(null,null,null),
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

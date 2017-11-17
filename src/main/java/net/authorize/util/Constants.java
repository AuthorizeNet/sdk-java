package net.authorize.util;

public final class Constants {
	public static final String PROXY_PROTOCOL = "http";

	public static final String HTTPS_USE_PROXY = "https.proxyUse";
	public static final String HTTPS_PROXY_HOST = "https.proxyHost";
	public static final String HTTPS_PROXY_PORT = "https.proxyPort";

	public static final String HTTP_USE_PROXY = "http.proxyUse";
	public static final String HTTP_PROXY_HOST = "http.proxyHost";
	public static final String HTTP_PROXY_PORT = "http.proxyPort";
	
	public static final String ENV_API_LOGINID = "API_LOGIN_ID";
	public static final String ENV_TRANSACTION_KEY = "TRANSACTION_KEY";
	public static final String ENV_MD5_HASHKEY = "MD5_HASH_KEY";

	public static final String ENV_API_LOGINID_APPLEPAY = "API_LOGIN_ID_APPLEPAY";
	public static final String ENV_TRANSACTION_KEY_APPLEPAY = "TRANSACTION_KEY_APPLEPAY";
	public static final String ENV_MD5_HASHKEY_APPLEPAY = "MD5_HASH_KEY_APPLEPAY";

	public static final String PROP_API_LOGINID = "api.login.id";
	public static final String PROP_TRANSACTION_KEY = "transaction.key";
	public static final String PROP_MD5_HASHKEY = "md5.hash.key";	

	public static final String PROP_API_LOGINID_APPLEPAY = "api.login.id.applepay";
	public static final String PROP_TRANSACTION_KEY_APPLEPAY = "transaction.key.applepay";
	public static final String PROP_MD5_HASHKEY_APPLEPAY = "md5.hash.key.applepay";
	
	public static final String HTTP_CONNECTION_TIME_OUT = "http.ConnectionTimeout";
	public static final int HTTP_CONNECTION_TIME_OUT_DEFAULT_VALUE = 30000;
	
	public static final String HTTP_READ_TIME_OUT = "http.ReadTimeout";
	public static final int HTTP_READ_TIME_OUT_DEFAULT_VALUE = 30000;
	
	public static final String CLIENT_ID = "sdk-java-1.9.4";
}

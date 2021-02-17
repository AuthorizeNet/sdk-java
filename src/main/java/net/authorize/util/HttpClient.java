package net.authorize.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;

import net.authorize.Environment;

/**
 * Transportation object used to facilitate the communication with the
 * respective gateway.
 *
 */
public class HttpClient {
	private static Logger logger = LogManager.getLogger(HttpClient.class);

	public static final String ENCODING = "UTF-8";
	static boolean proxySet = false;

	static boolean UseProxy = Environment.getBooleanProperty(Constants.HTTPS_USE_PROXY);
	static String ProxyHost = Environment.getProperty(Constants.HTTPS_PROXY_HOST);
	static int ProxyPort = Environment.getIntProperty(Constants.HTTPS_PROXY_PORT);
	static String proxyUsername = Environment.getProperty(Constants.HTTPS_PROXY_USERNAME);
	static String proxyPassword = Environment.getProperty(Constants.HTTPS_PROXY_PASSWORD);

	static int httpConnectionTimeout = Environment.getIntProperty(Constants.HTTP_CONNECTION_TIME_OUT);
	static int httpReadTimeout = Environment.getIntProperty(Constants.HTTP_READ_TIME_OUT);

	static {
		LogHelper.info(logger, "Use Proxy: '%s'", UseProxy);

		httpConnectionTimeout = (httpConnectionTimeout == 0 ? Constants.HTTP_CONNECTION_TIME_OUT_DEFAULT_VALUE
				: httpConnectionTimeout);
		httpReadTimeout = (httpReadTimeout == 0 ? Constants.HTTP_READ_TIME_OUT_DEFAULT_VALUE : httpReadTimeout);
	}


	

	/**
	 * Converts a response inputstream into a string.
	 *
	 * @param is
	 * @return String
	 */
	@Deprecated
	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			LogHelper.warn(logger, "Exception reading data from Stream: '%s'", e.getMessage());
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					LogHelper.warn(logger, "Exception closing BufferedReader: '%s'", e.getMessage());
				}
			}

			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					LogHelper.warn(logger, "Exception closing InputStream: '%s'", e.getMessage());
				}
			}
		}
		return sb.toString();
	}

	
	/**
	 * @return returns an SSL context with TLSv1.2 protocol instance to be used in
	 *         the call
	 */
	private static SSLContext getSSLContext() {
		try {
			final SSLContext sc = SSLContext.getInstance("TLSv1.2");
			final TrustManagerFactory trustManagerFactory = TrustManagerFactory
					.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			trustManagerFactory.init((KeyStore) null);
			sc.init(null, trustManagerFactory.getTrustManagers(), new java.security.SecureRandom());
			return sc;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Returns a HTTPClient instance which enforce TLSv1.2 protocol for all the
	 * calls
	 * 
	 * @return CloseableHttpClient instance
	 * @throws Exception
	 */
	static CloseableHttpClient getHttpsClient() throws Exception {
		SSLContext sslcontext = getSSLContext();
		try {
			LayeredConnectionSocketFactory sslSocketFactory = new org.apache.http.conn.ssl.SSLConnectionSocketFactory(
					sslcontext, SSLConnectionSocketFactory.STRICT_HOSTNAME_VERIFIER);
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(httpConnectionTimeout).build();

			CloseableHttpClient httpClient;

			if (UseProxy && ProxyHost != null) {

				HttpClientBuilder hcBuilder;
				if (proxyUsername != null && proxyPassword != null) {
					LogHelper.info(logger, "Setting up proxy to URL with Authentication: '%s://%s@%s:%d'",
							Constants.PROXY_PROTOCOL, proxyUsername, ProxyHost, ProxyPort);
					CredentialsProvider credsProvider = new BasicCredentialsProvider();
					AuthScope proxyScope = new AuthScope(ProxyHost, ProxyPort);
					Credentials proxyCreds = new UsernamePasswordCredentials(proxyUsername, proxyPassword);
					credsProvider.setCredentials(proxyScope, proxyCreds);
					hcBuilder = HttpClients.custom().setSSLSocketFactory(sslSocketFactory)
							.setDefaultRequestConfig(requestConfig).setRedirectStrategy(new LaxRedirectStrategy())
							.setDefaultCredentialsProvider(credsProvider);
				} else {
					LogHelper.info(logger, "Setting up proxy to URL: '%s://%s:%d'", Constants.PROXY_PROTOCOL, ProxyHost,
							ProxyPort);
					hcBuilder = HttpClients.custom().setSSLSocketFactory(sslSocketFactory)
							.setDefaultRequestConfig(requestConfig).setRedirectStrategy(new LaxRedirectStrategy());
				}

				HttpHost httpProxy = new HttpHost(ProxyHost, ProxyPort, Constants.PROXY_PROTOCOL);
				hcBuilder.setProxy(httpProxy);

				httpClient = hcBuilder.build();

				proxySet = true;
			} else {
				LogHelper.warn(logger, "Defaulting to non-proxy environment");

				httpClient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory)
						.setDefaultRequestConfig(requestConfig).setRedirectStrategy(new LaxRedirectStrategy()).build();
			}

			return httpClient;
		} catch (Exception e) {
			return null;
		}
	}
}

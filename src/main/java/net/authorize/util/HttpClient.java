package net.authorize.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.authorize.Environment;
import net.authorize.ResponseField;
import net.authorize.Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

/**
 * Transportation object used to facilitate the communication with the respective gateway.
 *
 */
public class HttpClient {
	private static Log logger = LogFactory.getLog(HttpClient.class);
	
	public static final String ENCODING = "UTF-8";
	static boolean proxySet = false;

	static boolean UseProxy = Environment.getBooleanProperty(Constants.HTTPS_USE_PROXY);
	static String ProxyHost = Environment.getProperty(Constants.HTTPS_PROXY_HOST);
	static int ProxyPort = Environment.getIntProperty(Constants.HTTPS_PROXY_PORT);
	
	/**
	 * Creates the http post object for an environment and transaction container.
	 *
	 * @param env
	 * @param transaction
	 * @return HttpPost object
	 *
	 * @throws Exception
	 */
	private static HttpPost createHttpPost(Environment env, Transaction transaction) throws Exception {
		URI postUrl;
		HttpPost httpPost = null;

		if(transaction instanceof net.authorize.aim.Transaction ||
				transaction instanceof net.authorize.sim.Transaction) {

			if(transaction instanceof net.authorize.aim.Transaction &&
					((net.authorize.aim.Transaction)transaction).isCardPresent()) {

			  postUrl = new URI(env.getCardPresentUrl() + "/gateway/transact.dll");
			} else {
			  postUrl = new URI(env.getBaseUrl() + "/gateway/transact.dll");
			}

  		    httpPost = new HttpPost(postUrl);
		    httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
		    httpPost.setEntity(new StringEntity(transaction.toNVPString()));
		} else if (transaction instanceof net.authorize.arb.Transaction ||
			    transaction instanceof net.authorize.cim.Transaction ||
			    transaction instanceof net.authorize.reporting.Transaction) {

			  postUrl = new URI(env.getXmlBaseUrl() + "/xml/v1/request.api");
			  httpPost = new HttpPost(postUrl);
			  httpPost.setHeader("Content-Type", "text/xml; charset=utf-8");
			  httpPost.setEntity(new StringEntity(transaction.toXMLString()));
		}

		return httpPost;
	}

	/**
	 * Creates a response map for a given response string and transaction container.
	 *
	 * @param transaction
	 * @param responseString
	 * @return container map containing semi-processed data after request was posted
	 * @throws UnsupportedEncodingException
	 */
	private static Map<ResponseField, String> createResponseMap(Transaction transaction, String responseString)
		throws UnsupportedEncodingException {

		Map<ResponseField, String> responseMap = null;

		// aim/sim
		if(transaction instanceof net.authorize.aim.Transaction ||
				transaction instanceof net.authorize.sim.Transaction) {

			String decodedResponseData = URLDecoder.decode(responseString, HTTP.UTF_8);
			

			responseMap = ResponseParser.parseResponseString(decodedResponseData);
		}

		return responseMap;
	}

	/**
	 * Executes a Transaction against a given Environment.
	 *
	 * @param environment
	 * @param transaction
	 * @return container map containing semi-processed data after request was posted
	 */
	public static Map<ResponseField, String> execute(Environment environment, Transaction transaction) {
		Map<ResponseField, String> responseMap = new HashMap<ResponseField, String>();

		if(environment != null && transaction != null) {
			try {
				DefaultHttpClient httpClient = new DefaultHttpClient();

				setProxyIfRequested(httpClient);

				// create the HTTP POST object
				HttpPost httpPost = createHttpPost(environment, transaction);

				// execute the request
				HttpResponse httpResponse = httpClient.execute(httpPost);
				String rawResponseString;
				if(httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200) {
					HttpEntity entity = httpResponse.getEntity();

					// get the raw data being received
					InputStream instream = entity.getContent();
					rawResponseString = convertStreamToString(instream);
				}
				// handle HTTP errors
				else {
					StringBuilder responseBuilder = new StringBuilder();
					responseBuilder.append(3).append(net.authorize.aim.Transaction.TRANSACTION_FIELD_DELIMITER);
					responseBuilder.append(3).append(net.authorize.aim.Transaction.TRANSACTION_FIELD_DELIMITER);
					responseBuilder.append(22).append(net.authorize.aim.Transaction.TRANSACTION_FIELD_DELIMITER);
					responseBuilder.append(httpResponse != null ? httpResponse.getStatusLine().getReasonPhrase() : " ");
					rawResponseString = responseBuilder.toString();
				}

				httpClient.getConnectionManager().shutdown();

				String cleanResponseString = XmlUtility.descapeStringForXml(rawResponseString);
				
				responseMap = HttpClient.createResponseMap(transaction, cleanResponseString);
			} catch (Exception e) {
				logger.warn(String.format("Exception getting response: '%s': '%s'\n'%s'", e.getMessage(), e.getCause(), Arrays.toString(e.getStackTrace())));
			}
		}

		return responseMap;
	}

	/**
	 * Converts a response inputstream into a string.
	 *
	 * @param is
	 * @return String
	 */
	public static String convertStreamToString(InputStream is) {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();

	    String line;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append("\n");
	        }
	    } catch (IOException e) {
			logger.warn(String.format("Exception reading data from Stream: '%s'", e.getMessage()));
	    } finally {

	    	try {
	            is.close();
	        } catch (IOException e) {
				logger.warn(String.format("Exception closing InputStream: '%s'", e.getMessage()));
	        }
	    }
	    return sb.toString();
	}


	/**
	 * Executes a Transaction against a given Environment.
	 *
	 * @param environment
	 * @param transaction
	 * @return BasicXmlDocument containing semi-processed data after request was posted
	 */
	public static BasicXmlDocument executeXML(Environment environment, Transaction transaction) {
		BasicXmlDocument response = new BasicXmlDocument();

		if(environment != null && transaction != null) {
			try {
				DefaultHttpClient httpClient = new DefaultHttpClient();

				setProxyIfRequested(httpClient);
				
				// create the HTTP POST object
				HttpPost httpPost = createHttpPost(environment, transaction);

				// execute the request
				HttpResponse httpResponse = httpClient.execute(httpPost);
				String rawResponseString;
				if(httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200) {
					HttpEntity entity = httpResponse.getEntity();

					// get the raw data being received
					InputStream instream = entity.getContent();
					rawResponseString = convertStreamToString(instream);
				}
				else {
					StringBuilder responseBuilder = new StringBuilder();
					if(transaction instanceof net.authorize.arb.Transaction ||
					    transaction instanceof net.authorize.cim.Transaction ||
					    transaction instanceof net.authorize.reporting.Transaction) {

						responseBuilder.append("<?xml version=\"1.0\" ?>");
						responseBuilder.append("<messages><resultCode>Error</resultCode>");
						responseBuilder.append("<message><code>E00001</code>");
						responseBuilder.append("<text>");
						responseBuilder.append(httpResponse != null?httpResponse.getStatusLine().getReasonPhrase():"");
						responseBuilder.append("</text></message></messages>");
					} else {
						responseBuilder.append("<?xml version=\"1.0\" ?>");
						responseBuilder.append("<response>");
						responseBuilder.append("<ResponseCode>3</ResponseCode>");
						responseBuilder.append("<Errors><Error><ErrorCode>22</ErrorCode><ErrorText><![CDATA[");
						responseBuilder.append(httpResponse != null?httpResponse.getStatusLine().getReasonPhrase():"");
						responseBuilder.append("]]></ErrorText></Error></Errors></response>");
					}

					rawResponseString = responseBuilder.toString();
				}


				httpClient.getConnectionManager().shutdown();

				if(rawResponseString == null) return null;

				if(Environment.SANDBOX.equals(environment) ||
						Environment.SANDBOX_TESTMODE.equals(environment)) {
					
				}

				int mark = rawResponseString.indexOf("<?xml");
				if(mark == -1){
					return null;
				}

				response.parseString(rawResponseString.substring(mark,rawResponseString.length()));
				if(response.IsAccessible() == false){
					return null;
				}
			} catch (Exception e) {
				logger.warn(String.format("Exception getting response: '%s': '%s'\n'%s'", e.getMessage(), e.getCause(), Arrays.toString(e.getStackTrace())));
			}
		}

		return response;
	}

	/**
	 * if proxy use is requested, set http-client appropriately 
	 * @param httpClient the client to add proxy values to 
	 */
	public static void setProxyIfRequested(DefaultHttpClient httpClient) {
		if ( UseProxy)
		{
			if ( !proxySet) {
				logger.info(String.format("Setting up proxy to URL: '%s://%s:%d'\n", Constants.PROXY_PROTOCOL, ProxyHost, ProxyPort));
				proxySet = true;
			}
			HttpHost proxyHttpHost = new HttpHost(ProxyHost, ProxyPort, Constants.PROXY_PROTOCOL);
			httpClient.getParams().setParameter( ConnRoutePNames.DEFAULT_PROXY, proxyHttpHost);
		}
	}
}

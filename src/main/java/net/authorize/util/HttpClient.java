package net.authorize.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import net.authorize.Environment;
import net.authorize.ResponseField;
import net.authorize.Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
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
		URI postUrl = null;
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
	 * @return Map<ResponseField, String> container
	 * @throws UnsupportedEncodingException
	 */
	private static Map<ResponseField, String> createResponseMap(Transaction transaction, String responseString)
		throws UnsupportedEncodingException {

		Map<ResponseField, String> responseMap = null;

		// aim/sim
		if(transaction instanceof net.authorize.aim.Transaction ||
				transaction instanceof net.authorize.sim.Transaction) {

			String decodedResponseData = URLDecoder.decode(responseString, HTTP.UTF_8);
			logger.debug("Url-decoded response data: " + decodedResponseData);

			responseMap = ResponseParser.parseResponseString(decodedResponseData);
		}

		return responseMap;
	}

	/**
	 * Executes a Transaction against a given Environment.
	 *
	 * @param environment
	 * @param transaction
	 * @return Return a HashMap<ResponseField> that contains semi-processed data after a request was posted.
	 */
	public static Map<ResponseField, String> execute(Environment environment, Transaction transaction) {
		Map<ResponseField, String> responseMap = new HashMap<ResponseField, String>();

		if(environment != null && transaction != null) {
			try {
				DefaultHttpClient httpClient = new DefaultHttpClient();

				// create the HTTP POST object
				HttpPost httpPost = createHttpPost(environment, transaction);

				// get the raw data being sent for logging while in sandbox type modes
				if(Environment.SANDBOX.equals(environment) ||
						Environment.SANDBOX_TESTMODE.equals(environment)) {
					InputStream outstream = (InputStream)httpPost.getEntity().getContent();
					String requestData = convertStreamToString(outstream);
					logger.debug("SANDBOX MODES ONLY>> Url-encoded request data: " + requestData);
				}

				// execute the request
				HttpResponse httpResponse = httpClient.execute(httpPost);
				String rawResponseString = "";
				if(httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200) {
					HttpEntity entity = httpResponse.getEntity();

					// get the raw data being received
					InputStream instream = (InputStream)entity.getContent();
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

				responseMap = HttpClient.createResponseMap(transaction, rawResponseString);
			} catch (Exception e) {
				logger.error("HttpClient execution failed", e);
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

	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return sb.toString();
	}


	/**
	 * Executes a Transaction against a given Environment.
	 *
	 * @param environment
	 * @param transaction
	 * @return Return a HashMap<ResponseField> that contains semi-processed data after a request was posted.
	 */
	public static BasicXmlDocument executeXML(Environment environment, Transaction transaction) {
		BasicXmlDocument response = new BasicXmlDocument();

		if(environment != null && transaction != null) {
			try {
				DefaultHttpClient httpClient = new DefaultHttpClient();

				// create the HTTP POST object
				HttpPost httpPost = createHttpPost(environment, transaction);

				// get the raw data being sent for logging while in sandbox type modes
				if(Environment.SANDBOX.equals(environment) ||
						Environment.SANDBOX_TESTMODE.equals(environment)) {
					InputStream outstream = (InputStream)httpPost.getEntity().getContent();
					String requestData = convertStreamToString(outstream);
					logger.debug("SANDBOX MODES ONLY>> Url-encoded request data: " + requestData);
				}

				// execute the request
				HttpResponse httpResponse = httpClient.execute(httpPost);
				String rawResponseString = "";
				if(httpResponse != null && httpResponse.getStatusLine().getStatusCode() == 200) {
					HttpEntity entity = httpResponse.getEntity();

					// get the raw data being received
					InputStream instream = (InputStream)entity.getContent();
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
					logger.debug("SANDBOX MODES ONLY>> Response data: " + rawResponseString);
				}

				int mark = rawResponseString.indexOf("<?xml");
				if(mark == -1){
					logger.error("Invalid response");
					logger.error(rawResponseString);
					return null;
				}

				response.parseString(rawResponseString.substring(mark,rawResponseString.length()));
				if(response.IsAccessible() == false){
					logger.error("Invalid response");
					logger.error(rawResponseString);
					return null;
				}
			} catch (Exception e) {
				logger.error("HttpClient execution failed", e);
			}
		}

		return response;
	}

}

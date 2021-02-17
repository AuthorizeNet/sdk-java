package net.authorize.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.bind.JAXBException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;

import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiRequest;
import net.authorize.api.contract.v1.ANetApiResponse;

/**
 * Helper methods for http calls
 * @author ramittal
 *
 */
public final class HttpUtility {

	private static Logger logger = LogManager.getLogger(HttpUtility.class);	

	static int httpConnectionTimeout = Environment.getIntProperty(Constants.HTTP_CONNECTION_TIME_OUT);
	static int httpReadTimeout = Environment.getIntProperty(Constants.HTTP_READ_TIME_OUT);
	
	static {
		
		httpConnectionTimeout = (httpConnectionTimeout == 0 ? Constants.HTTP_CONNECTION_TIME_OUT_DEFAULT_VALUE : httpConnectionTimeout );
		httpReadTimeout = (httpReadTimeout == 0 ? Constants.HTTP_READ_TIME_OUT_DEFAULT_VALUE : httpReadTimeout);
	}
	
	/**
     * Default C'tor, cannot be instantiated
     */
	private HttpUtility() {
	}

	/**
	 * Creates http post to be sent as http request
	 * @param env  Env to point to 
	 * @param request  Http request to send 
	 * @return HttpPost that can be send for http request
	 * @throws URISyntaxException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws JAXBException
	 */
	static HttpPost createPostRequest(Environment env, ANetApiRequest request) throws URISyntaxException, UnsupportedEncodingException, IOException, JAXBException 
	{
		URI postUrl = null;
		HttpPost httpPost = null;

		if(null != request) {
			  postUrl = new URI(env.getXmlBaseUrl() + "/xml/v1/request.api");
			  logger.debug(String.format("Posting request to Url: '%s'", postUrl));
			  httpPost = new HttpPost(postUrl);
              httpPost.getParams().setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false);
              
              //set the tcp connection timeout
  			  httpPost.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, httpConnectionTimeout);
  			  //set the time out on read-data request
  			  httpPost.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, httpReadTimeout);
              
			  httpPost.setHeader("Content-Type", "text/xml; charset=utf-8");
			  
			  String xmlRequest = XmlUtility.getXml(request);
			  logger.debug(String.format("Request: '%s%s%s'", LogHelper.LineSeparator, xmlRequest, LogHelper.LineSeparator));
			  httpPost.setEntity(new StringEntity(xmlRequest, HTTP.UTF_8));
		}

		return httpPost;
	}
	
	/**
	 * Posts a http request
	 * @param env  Env to point to 
	 * @param request  Http request to send 
	 * @param classType  Expected response type if successful
	 * @return ANetApiResponse  successful or failed response
	 */
	public static <T> ANetApiResponse postData(Environment env, ANetApiRequest request, Class<T> classType) {
		ANetApiResponse response = null;
		
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<ANetApiResponse> future = executor.submit(new HttpCallTask(env, request, classType));
        executor.shutdown(); // Important!
		
        try {
        	response = future.get();
        	logger.debug(String.format("Response: '%s'", response));
		} catch (InterruptedException ie) {
			logger.error(String.format("Http call interrupted Message: '%s'", ie.getMessage()));
		} catch (ExecutionException ee) {
			logger.error(String.format("Execution error for http post Message: '%s'", ee.getMessage()));
		}

        return response;
	}

	/**
	 * Converts a response inputstream into a string.
	 *
	 * @param is input stream
	 * @return String contents of the input stream, without BOM 
	 */
	public static String convertStreamToString(InputStream is) {

		BOMStripperInputStream bomStripperStream = null;
		try {
			bomStripperStream = new BOMStripperInputStream(is) ;
		} catch (NullPointerException e) {
			logger.warn(String.format("Exception creating BOMStripperInputStream: '%s'", e.getMessage()));
		} catch (IOException e) {
			logger.warn(String.format("Exception creating BOMStripperInputStream: '%s'", e.getMessage()));
		}
		if ( null == bomStripperStream) {
			throw new NullPointerException("Unable to create BomStriper from the input stream");
		}
			
	    //strip BOM if exists, the funny upto 3 bytes at the begining of stream identifying the char encoding 
    	try {
    		bomStripperStream.skipBOM();
		} catch (IOException e) {
			logger.warn(String.format("Exception setting skip for BOMStripperInputStream: '%s'", e.getMessage()));
		} 

	    String line = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
	    StringBuilder sb = null;
	    //read the stream
	    try {
			isr = new InputStreamReader(bomStripperStream) ;
			reader = new BufferedReader(isr);
		    sb = new StringBuilder();
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append(LogHelper.LineSeparator);
	        }
	    } catch (IOException e) {
			logger.warn(String.format("Exception reading data from Stream: '%s'", e.getMessage()));
	    } finally {

	    	tryClose( reader);
	    	tryClose( isr);
	    	tryClose( bomStripperStream);
	    	tryClose( is);
	    }
	    
	    return sb.toString();
	}
	
	private static <T extends Closeable> void tryClose( T closableObject) {
	    if (null != closableObject)
	    {
	    	try {
	    		closableObject.close();
			} catch (Exception e) {
				logger.warn(String.format("Exception closing '%s': '%s'", closableObject.getClass(), e.getMessage()));
			}
	    }
	}
}

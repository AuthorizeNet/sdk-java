package net.authorize.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Callable;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;

import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiRequest;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.MessagesType;
import net.authorize.api.contract.v1.MessagesType.Message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
//import net.authorize.api.controller.base.ErrorResponse;

/**
 * Callable task to make http calls in future 
 * @author ramittal
 *
 */
public class HttpCallTask implements Callable<ANetApiResponse> {
	private static Logger logger = LogManager.getLogger(HttpCallTask.class);

	Environment env = null;
	ANetApiRequest request = null;
	@SuppressWarnings("rawtypes")
	Class classType = null;
	
	//private static ANetApiResponse errorResponse = null;
	private Message errorMessage = null;

	/**
	 * Creates task to be called in future for making http call
	 * @param env  Env to point to 
	 * @param request  Http request to send 
	 * @param classType  Expected response type if successful
	 */
    public <T> HttpCallTask(Environment env, ANetApiRequest request, Class<T> classType) {
    	this.env = env;
    	this.request = request;
    	this.classType = classType;
		this.errorMessage = new Message();
    }

	@SuppressWarnings("unchecked")
    /**
     * Makes a http call, using the proxy if requested, and returns apiresponse
     * with error code set appropriately
     * @return ANetApiResponse  successful or failed response 
     */
	public ANetApiResponse call() throws Exception {
		ANetApiResponse response = null;
		StringBuilder buffer = new StringBuilder();
		
		org.apache.http.client.HttpClient httpCaller = null;
		
        try {
            HttpPost httppost = HttpUtility.createPostRequest(this.env, this.request);
            httpCaller = HttpClient.getHttpsClient();
			
            HttpResponse httpResponse = httpCaller.execute(httppost);

			if ( null != httpResponse) { 
				if ( null != httpResponse.getStatusLine()) { 
					if ( 200 == httpResponse.getStatusLine().getStatusCode()) {
				
						HttpEntity entity = httpResponse.getEntity();
						// get the raw data being received
						InputStream instream = entity.getContent();
						buffer.append(HttpUtility.convertStreamToString(instream));
					}
				}
			}
			LogHelper.debug(logger, "Raw Response: '%s'", buffer.toString());
			// handle HTTP errors
			if (0 == buffer.length()) {
				response = createErrorResponse(httpResponse, null);
			} else { // i.e. if ( StringUtils.isNotEmpty(buffer.toString())) 
				Object localResponse = null;
				
				try {
					localResponse = XmlUtility.create(buffer.toString(), this.classType);
				} catch(UnmarshalException ume) {
					try {
						//try deserializing to error message
						localResponse = XmlUtility.create(buffer.toString(), net.authorize.api.contract.v1.ErrorResponse.class);
					} catch(JAXBException jabex) {
						response = createErrorResponse(httpResponse, jabex);
					}
				} catch(JAXBException jabex) {
					response = createErrorResponse(httpResponse, jabex);
				}
				
				//ObjectFactory factory = new ObjectFactory();
				//JAXBElement<ANetApiResponse> error = factory.createErrorResponse();
			    
				//check if error
				if ( null == localResponse) {
					try {
						response = XmlUtility.create(buffer.toString(), ANetApiResponse.class);
					} catch(JAXBException jabex) {
						response = createErrorResponse(httpResponse, jabex);
					}
				} else {
					if (localResponse instanceof ANetApiResponse)
					{
						response = (ANetApiResponse) localResponse;
					} else {
						LogHelper.warn( logger, "Unknown ResponseType: '%s'", localResponse);
					}
				}
			}
        } catch (ClientProtocolException cpe) {
			response = createErrorResponse(null, cpe);
        } catch (IOException ioe) {
			response = createErrorResponse(null, ioe);
        } finally {
        	if ( null != httpCaller) {
        		httpCaller.getConnectionManager().shutdown();
        	}
        }

        return response;
	}

	private ANetApiResponse createErrorResponse(HttpResponse httpResponse, Exception exception) {
		ANetApiResponse response = new ANetApiResponse();

		MessagesType aMessage = new MessagesType();
		aMessage.setResultCode(MessageTypeEnum.ERROR);
		response.setMessages(aMessage);

		List<Message> messages = response.getMessages().getMessage();
		//clear all messages
		messages.clear();
		
		setErrorResponse(messages, httpResponse);
		setErrorResponse(messages, exception);
		
		return response;
	}

	private void setErrorResponse(List<Message> messages, HttpResponse httpResponse) {
		if ( null != httpResponse) {
			messages.add(errorMessage);
			String code = "Error";
			String text = "Unknown Error";
			if (null != httpResponse.getStatusLine())
			{
				LogHelper.warn( logger, "Error deserializing response to '%s'", this.classType);

				code = String.format("%d", httpResponse.getStatusLine().getStatusCode());
				if (null != httpResponse.getStatusLine().getReasonPhrase()) { text = httpResponse.getStatusLine().getReasonPhrase();}
			}
			setErrorMessageValues(code, text);
		}
	}

	private void setErrorResponse(List<Message> messages, Exception exception) {
		if ( null != exception) {
			messages.add(errorMessage);
			String code = "Error";
			String text = "Unknown Error";
			LogHelper.error( logger, "Http request execute failed: '%s'", exception.getMessage());
			code = exception.getClass().getCanonicalName();
			//code = exception.getClass().getTypeName();// requires java1.8
			text = exception.getMessage();
			
			setErrorMessageValues(code, text);
		}
	}

	private void setErrorMessageValues(String code, String text) {
		errorMessage.setCode(code);
		errorMessage.setText(text);
		LogHelper.warn(logger, "Adding ErrorMessage: Code: '%s', Text: '%s'", code, text);
	}
}	

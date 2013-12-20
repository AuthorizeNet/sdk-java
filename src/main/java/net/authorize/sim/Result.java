package net.authorize.sim;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import net.authorize.ResponseCode;
import net.authorize.ResponseField;
import net.authorize.ResponseReasonCode;


public class Result implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String> responseMap = new HashMap<String, String>();
	private ResponseCode responseCode;
	private ResponseReasonCode reasonResponseCode;
	private String apiLoginId;
	private String merchantMD5Key;

	private Result() { }

	/**
	 * Reformats the http response map into a usable SIM response map.
	 *
	 * @param responseMap
	 */
	private void reformatResponseMap(Map<String, String[]> responseMap) {
		for(String key : responseMap.keySet()) {
			ResponseField responseField = ResponseField.findByFieldName(key);
			String[] value = responseMap.get(key);
			if(responseField != null) {
				this.responseMap.put(responseField.getFieldName(), value.length>0?value[0]:"");
			} else {
				this.responseMap.put(key, value.length>0?value[0]:"");
			}
		}
	}

	/**
	 * Create a result for SIM based on the response map.
	 *
	 * @param apiLoginId merchant api login Id
	 * @param merchantMD5Key MD5 key that is created in the Security Settings in the merchant interface.
	 * @param responseMap
	 *
	 * @return the result
	 */
	public static Result createResult(String apiLoginId, String merchantMD5Key, Map<String, String[]> responseMap) {
		Result result = new Result();

		result.reformatResponseMap(responseMap);

		result.apiLoginId = apiLoginId;
		result.merchantMD5Key = merchantMD5Key;

		String responseCodeStr = result.responseMap.get(ResponseField.RESPONSE_CODE.getFieldName());
		String responseReasonCodeStr = result.responseMap.get(ResponseField.RESPONSE_REASON_CODE.getFieldName());

		// if this txn didn't come from authnet - bail!
		boolean isMD5Ok = result.isAuthorizeNet();
		if(!isMD5Ok) {
			responseCodeStr = null;
			responseReasonCodeStr = null;
			result.getResponseMap().put(ResponseField.RESPONSE_REASON_TEXT.getFieldName(), "Unable to verify MD5 value.");
		}

		result.responseCode = responseCodeStr!=null && !"".equals(responseCodeStr)?
				ResponseCode.findByResponseCode(Integer.parseInt(responseCodeStr)):
					ResponseCode.UNKNOWN;
		result.reasonResponseCode = responseReasonCodeStr!=null && !"".equals(responseReasonCodeStr)?
				ResponseReasonCode.findByReasonCode(Integer.parseInt(responseReasonCodeStr)):
					ResponseReasonCode.RRC_0_0;
		if(isMD5Ok && ResponseReasonCode.RRC_0_0.equals(result.reasonResponseCode)) {
			result.getResponseMap().put(ResponseField.RESPONSE_REASON_TEXT.getFieldName(), "");
		}
		
		return result;
	}

   /**
    * Verify that the relay response post is actually coming from
    * AuthorizeNet.
    *
    * @return boolean true if the txn came from Authorize.Net
    */
	public boolean isAuthorizeNet() {

	    String amount = this.responseMap.get(ResponseField.AMOUNT.getFieldName()) != null ?
	    	this.responseMap.get(ResponseField.AMOUNT.getFieldName()) : "0.00";

	    String x_MD5_Hash = this.responseMap.get(ResponseField.MD5_HASH.getFieldName());
	    String md5Check = null;

	    try {
		    MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
		    String s = merchantMD5Key + this.apiLoginId + this.responseMap.get(ResponseField.TRANSACTION_ID.getFieldName()) + amount;
		    digest.update(s.getBytes());
		    md5Check = new BigInteger(1,digest.digest()).toString(16).toUpperCase();
		    while(md5Check.length() < 32) {
		    	md5Check = "0" + md5Check;
		    }
	    } catch (NoSuchAlgorithmException nsae) {
	    	//
	    }

	    return md5Check != null && md5Check.equalsIgnoreCase(x_MD5_Hash);
	}

	public boolean isApproved() {
		return ResponseCode.APPROVED.equals(this.responseCode);
	}

	public boolean isDeclined() {
		return ResponseCode.DECLINED.equals(this.responseCode);
	}

	public boolean isError() {
		return ResponseCode.ERROR.equals(this.responseCode);
	}

	public boolean isReview() {
		return ResponseCode.REVIEW.equals(this.responseCode);
	}

	public ResponseCode getResponseCode() {
		return this.responseCode;
	}

	public ResponseReasonCode getReasonResponseCode() {
		return this.reasonResponseCode;
	}

	public Map<String, String> getResponseMap() {
		return this.responseMap;
	}


}

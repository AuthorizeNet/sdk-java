package net.authorize.aim;

import java.util.Map;

import net.authorize.ResponseCode;
import net.authorize.ResponseField;
import net.authorize.ResponseReasonCode;

/**
 * Templated wrapper container for passing back the result from the request gateway.
 *
 * @deprecated since version 1.9.8
 * @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
 * @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API.
 * @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
 * @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-php/tree/master/PaymentTransactions.
 * @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
 *
 */
@Deprecated
public class Result<T> extends net.authorize.Result<T> {

	private static final long serialVersionUID = 1L;

	private ResponseCode responseCode;
	private ResponseReasonCode reasonResponseCode;
	private String responseText;
	private String transactionId;

	private Result() { }

	@SuppressWarnings("unchecked")
	public static <T> Result<T> createResult(T object, Map<ResponseField, String> responseMap) {
		Result<T> result = new Result<T>();

		if(object instanceof Transaction) {
			result.target = (T) Transaction.createTransaction((Transaction) object, responseMap);
		}

		String responseCodeStr = responseMap.get(ResponseField.RESPONSE_CODE);
		
		result.transactionId = responseMap.get(ResponseField.TRANSACTION_ID);
		
		result.responseCode = responseCodeStr!=null && !"".equals(responseCodeStr)?
				ResponseCode.findByResponseCode(Double.valueOf(responseCodeStr).intValue()):
					ResponseCode.ERROR;

		String responseReasonCodeStr = responseMap.get(ResponseField.RESPONSE_REASON_CODE);
		result.reasonResponseCode = responseReasonCodeStr!=null && !"".equals(responseReasonCodeStr)?
				ResponseReasonCode.findByReasonCode(Integer.parseInt(responseReasonCodeStr)):
					ResponseReasonCode.RRC_0_0;

		result.responseText = responseMap.get(ResponseField.RESPONSE_REASON_TEXT);

		return result;
	}

	public ResponseCode getResponseCode() {
		return this.responseCode;
	}

	public ResponseReasonCode getReasonResponseCode() {
		return this.reasonResponseCode;
	}

	/**
	 * @return the reponseText
	 */
	public String getResponseText() {
		return responseText;
	}

	public String getTransactionId() {
		return transactionId;
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
}

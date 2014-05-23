package net.authorize.apicore.helper;

import net.authorize.apicore.contract.v1.ARBGetSubscriptionReportRequest;
import net.authorize.apicore.contract.v1.ARBGetSubscriptionReportResponse;

public class ARBGetSubscriptionReportController extends ApiOperationBase<ARBGetSubscriptionReportRequest, ARBGetSubscriptionReportResponse> {

	public ARBGetSubscriptionReportController(ARBGetSubscriptionReportRequest apiRequest) {
		super(apiRequest);
	}

	
	@Override
	protected void validateRequest() {
		ARBGetSubscriptionReportRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( 0 >= request.getMerchantId()) throw new NullPointerException("MerchantId cannot be null");
		if ( null == request.getRefId()) throw new NullPointerException("RefId cannot be null");
		
		//validate not-required fields		
	    

	}

	@Override
	protected Class<ARBGetSubscriptionReportResponse> getResponseType() {
		return ARBGetSubscriptionReportResponse.class;
	}
}

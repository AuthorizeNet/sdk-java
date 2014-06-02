package net.authorize.apicore.controller;

import net.authorize.apicore.contract.v1.ARBCancelSubscriptionRequest;
import net.authorize.apicore.contract.v1.ARBCancelSubscriptionResponse;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.controller.base.ApiOperationBase;

public class ARBCancelSubscriptionController extends ApiOperationBase<ARBCancelSubscriptionRequest, ARBCancelSubscriptionResponse> {

	public ARBCancelSubscriptionController(ARBCancelSubscriptionRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		ARBCancelSubscriptionRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getSubscriptionId()) throw new NullPointerException("SubscriptionId cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<ARBCancelSubscriptionResponse> getResponseType() {
		return ARBCancelSubscriptionResponse.class;
	}
}

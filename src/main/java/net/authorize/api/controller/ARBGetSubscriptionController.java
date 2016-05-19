package net.authorize.api.controller;

import net.authorize.api.contract.v1.ARBGetSubscriptionRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class ARBGetSubscriptionController extends ApiOperationBase<ARBGetSubscriptionRequest, ARBGetSubscriptionResponse> {

	public ARBGetSubscriptionController(ARBGetSubscriptionRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		ARBGetSubscriptionRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getSubscriptionId()) throw new NullPointerException("SubscriptionId cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<ARBGetSubscriptionResponse> getResponseType() {
		return ARBGetSubscriptionResponse.class;
	}
}

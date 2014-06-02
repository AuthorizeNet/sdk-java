package net.authorize.apicore.controller;

import net.authorize.apicore.contract.v1.ARBCreateSubscriptionRequest;
import net.authorize.apicore.contract.v1.ARBCreateSubscriptionResponse;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.controller.base.ApiOperationBase;

public class ARBCreateSubscriptionController extends ApiOperationBase<ARBCreateSubscriptionRequest, ARBCreateSubscriptionResponse> {

	public ARBCreateSubscriptionController(ARBCreateSubscriptionRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		ARBCreateSubscriptionRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getSubscription()) throw new NullPointerException("Subscription cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<ARBCreateSubscriptionResponse> getResponseType() {
		return ARBCreateSubscriptionResponse.class;
	}
}

package net.authorize.api.controller;

import net.authorize.api.contract.v1.ARBUpdateSubscriptionRequest;
import net.authorize.api.contract.v1.ARBUpdateSubscriptionResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class ARBUpdateSubscriptionController extends ApiOperationBase<ARBUpdateSubscriptionRequest, ARBUpdateSubscriptionResponse> {

	public ARBUpdateSubscriptionController(ARBUpdateSubscriptionRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		ARBUpdateSubscriptionRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getSubscriptionId()) throw new NullPointerException("SubscriptionId cannot be null");
		if ( null == request.getSubscription()) throw new NullPointerException("Subscription cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<ARBUpdateSubscriptionResponse> getResponseType() {
		return ARBUpdateSubscriptionResponse.class;
	}
}

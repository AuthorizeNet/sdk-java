package net.authorize.apicore.controller;

import net.authorize.apicore.contract.v1.ARBGetSubscriptionStatusRequest;
import net.authorize.apicore.contract.v1.ARBGetSubscriptionStatusResponse;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.controller.base.ApiOperationBase;

public class ARBGetSubscriptionStatusController extends ApiOperationBase<ARBGetSubscriptionStatusRequest, ARBGetSubscriptionStatusResponse> {

	public ARBGetSubscriptionStatusController(ARBGetSubscriptionStatusRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		ARBGetSubscriptionStatusRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getSubscriptionId()) throw new NullPointerException("SubscriptionId cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<ARBGetSubscriptionStatusResponse> getResponseType() {
		return ARBGetSubscriptionStatusResponse.class;
	}
}

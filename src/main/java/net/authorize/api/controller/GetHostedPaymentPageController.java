package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetHostedPaymentPageRequest;
import net.authorize.api.contract.v1.GetHostedPaymentPageResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetHostedPaymentPageController extends ApiOperationBase<GetHostedPaymentPageRequest, GetHostedPaymentPageResponse> {

	public GetHostedPaymentPageController(GetHostedPaymentPageRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetHostedPaymentPageRequest request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.getXXX) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetHostedPaymentPageResponse> getResponseType() {
		return GetHostedPaymentPageResponse.class;
	}
}

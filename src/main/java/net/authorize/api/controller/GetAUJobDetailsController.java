package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetAUJobDetailsRequest;
import net.authorize.api.contract.v1.GetAUJobDetailsResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetAUJobDetailsController extends ApiOperationBase<GetAUJobDetailsRequest, GetAUJobDetailsResponse> {

	public GetAUJobDetailsController(GetAUJobDetailsRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetAUJobDetailsRequest request = this.getApiRequest();
		
		//validate required fields
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetAUJobDetailsResponse> getResponseType() {
		return GetAUJobDetailsResponse.class;
	}
}

package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetCustomerProfileRequest;
import net.authorize.api.contract.v1.GetCustomerProfileResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetCustomerProfileController extends ApiOperationBase<GetCustomerProfileRequest, GetCustomerProfileResponse> {

	public GetCustomerProfileController(GetCustomerProfileRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetCustomerProfileRequest request = this.getApiRequest();
		
		//validate required fields		

		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetCustomerProfileResponse> getResponseType() {
		return GetCustomerProfileResponse.class;
	}
}

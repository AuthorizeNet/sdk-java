package net.authorize.api.controller;

import net.authorize.api.contract.v1.UpdateCustomerProfileRequest;
import net.authorize.api.contract.v1.UpdateCustomerProfileResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class UpdateCustomerProfileController extends ApiOperationBase<UpdateCustomerProfileRequest, UpdateCustomerProfileResponse> {

	public UpdateCustomerProfileController(UpdateCustomerProfileRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		UpdateCustomerProfileRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getProfile()) throw new NullPointerException("Profile cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<UpdateCustomerProfileResponse> getResponseType() {
		return UpdateCustomerProfileResponse.class;
	}
}

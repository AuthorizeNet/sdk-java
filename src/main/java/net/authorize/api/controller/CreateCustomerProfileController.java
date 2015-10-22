package net.authorize.api.controller;

import net.authorize.api.contract.v1.CreateCustomerProfileRequest;
import net.authorize.api.contract.v1.CreateCustomerProfileResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class CreateCustomerProfileController extends ApiOperationBase<CreateCustomerProfileRequest, CreateCustomerProfileResponse> {

	public CreateCustomerProfileController(CreateCustomerProfileRequest apiRequest) {
		super(apiRequest);
	}

	
	@Override
	protected void validateRequest() {
		CreateCustomerProfileRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getProfile()) throw new NullPointerException("Profile cannot be null");

		if ( null == request.getValidationMode() || ValidationModeEnum.NONE == request.getValidationMode()) throw new NullPointerException("ValidationMode cannot be null");
		if ( null == request.getProfile().getPaymentProfiles() || 0 == request.getProfile().getPaymentProfiles().size()) throw new NullPointerException("Payment Profile cannot be null or empty");
        }

	@Override
	protected Class<CreateCustomerProfileResponse> getResponseType() {
		return CreateCustomerProfileResponse.class;
	}
}

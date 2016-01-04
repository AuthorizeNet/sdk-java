package net.authorize.api.controller;

import net.authorize.api.contract.v1.ValidateCustomerPaymentProfileRequest;
import net.authorize.api.contract.v1.ValidateCustomerPaymentProfileResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class ValidateCustomerPaymentProfileController extends ApiOperationBase<ValidateCustomerPaymentProfileRequest, ValidateCustomerPaymentProfileResponse> {

	public ValidateCustomerPaymentProfileController(ValidateCustomerPaymentProfileRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		ValidateCustomerPaymentProfileRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getCustomerProfileId()) throw new NullPointerException("CustomerProfileId cannot be null");
		if ( null == request.getCustomerPaymentProfileId()) throw new NullPointerException("CustomerPaymentProfileId cannot be null");
				
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<ValidateCustomerPaymentProfileResponse> getResponseType() {
		return ValidateCustomerPaymentProfileResponse.class;
	}
}

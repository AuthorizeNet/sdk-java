package net.authorize.api.controller;

import net.authorize.api.contract.v1.UpdateCustomerPaymentProfileRequest;
import net.authorize.api.contract.v1.UpdateCustomerPaymentProfileResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class UpdateCustomerPaymentProfileController extends ApiOperationBase<UpdateCustomerPaymentProfileRequest, UpdateCustomerPaymentProfileResponse> {

	public UpdateCustomerPaymentProfileController(UpdateCustomerPaymentProfileRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		UpdateCustomerPaymentProfileRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getCustomerProfileId()) throw new NullPointerException("CustomerProfileId cannot be null");
		if ( null == request.getPaymentProfile()) throw new NullPointerException("PaymentProfile cannot be null");
		if ( null == request.getValidationMode()) throw new NullPointerException("ValidationMode cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<UpdateCustomerPaymentProfileResponse> getResponseType() {
		return UpdateCustomerPaymentProfileResponse.class;
	}
}

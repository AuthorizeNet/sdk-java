package net.authorize.apicore.controller;

import net.authorize.apicore.contract.v1.CreateCustomerPaymentProfileRequest;
import net.authorize.apicore.contract.v1.CreateCustomerPaymentProfileResponse;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.controller.base.ApiOperationBase;

public class CreateCustomerPaymentProfileController extends ApiOperationBase<CreateCustomerPaymentProfileRequest, CreateCustomerPaymentProfileResponse> {

	public CreateCustomerPaymentProfileController(CreateCustomerPaymentProfileRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		CreateCustomerPaymentProfileRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getPaymentProfile()) throw new NullPointerException("PaymentProfile cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<CreateCustomerPaymentProfileResponse> getResponseType() {
		return CreateCustomerPaymentProfileResponse.class;
	}
}

package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetCustomerPaymentProfileRequest;
import net.authorize.api.contract.v1.GetCustomerPaymentProfileResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetCustomerPaymentProfileController extends ApiOperationBase<GetCustomerPaymentProfileRequest, GetCustomerPaymentProfileResponse> {

	public GetCustomerPaymentProfileController(GetCustomerPaymentProfileRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetCustomerPaymentProfileRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getCustomerProfileId()) throw new NullPointerException("CustomerProfileId cannot be null");
		if ( null == request.getCustomerPaymentProfileId()) throw new NullPointerException("CustomerPaymentProfileId cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetCustomerPaymentProfileResponse> getResponseType() {
		return GetCustomerPaymentProfileResponse.class;
	}
}

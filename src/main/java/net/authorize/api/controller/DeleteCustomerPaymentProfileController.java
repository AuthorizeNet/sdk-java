package net.authorize.api.controller;

import net.authorize.api.contract.v1.DeleteCustomerPaymentProfileRequest;
import net.authorize.api.contract.v1.DeleteCustomerPaymentProfileResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class DeleteCustomerPaymentProfileController extends ApiOperationBase<DeleteCustomerPaymentProfileRequest, DeleteCustomerPaymentProfileResponse> {

	public DeleteCustomerPaymentProfileController(DeleteCustomerPaymentProfileRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		DeleteCustomerPaymentProfileRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getCustomerProfileId()) throw new NullPointerException("CustomerProfileId cannot be null");
		if ( null == request.getCustomerPaymentProfileId()) throw new NullPointerException("CustomerPaymentProfileId cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<DeleteCustomerPaymentProfileResponse> getResponseType() {
		return DeleteCustomerPaymentProfileResponse.class;
	}
}

package net.authorize.api.controller;

import net.authorize.api.contract.v1.CreateCustomerProfileFromTransactionRequest;
import net.authorize.api.contract.v1.CreateCustomerProfileResponse;
import net.authorize.api.controller.base.ApiOperationBase;

public class CreateCustomerProfileFromTransactionController 
         extends ApiOperationBase<CreateCustomerProfileFromTransactionRequest,CreateCustomerProfileResponse> {

	public CreateCustomerProfileFromTransactionController(
			CreateCustomerProfileFromTransactionRequest apiRequest) {
		super(apiRequest);
	}

	
	@Override
	protected void validateRequest() {
		CreateCustomerProfileFromTransactionRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getTransId()) throw new NullPointerException("TransId cannot be null");
	}

	@Override
	protected Class<CreateCustomerProfileResponse> getResponseType() {
		return CreateCustomerProfileResponse.class;
	}
}

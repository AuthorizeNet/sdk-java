package net.authorize.api.controller;

import net.authorize.api.contract.v1.CreateCustomerProfileTransactionRequest;
import net.authorize.api.contract.v1.CreateCustomerProfileTransactionResponse;
import net.authorize.api.controller.base.ApiOperationBase;

public class CreateCustomerProfileTransactionController extends ApiOperationBase<CreateCustomerProfileTransactionRequest, CreateCustomerProfileTransactionResponse> {

	public CreateCustomerProfileTransactionController(CreateCustomerProfileTransactionRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		CreateCustomerProfileTransactionRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getMerchantAuthentication()) throw new NullPointerException("The request's merchantAuthentication field cannot be null");
		if ( null == request.getTransaction()) throw new NullPointerException("The request's transaction field cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<CreateCustomerProfileTransactionResponse> getResponseType() {
		return CreateCustomerProfileTransactionResponse.class;
	}
}

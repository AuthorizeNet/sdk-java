package net.authorize.apicore.controller;

import net.authorize.apicore.contract.v1.CreateTransactionRequest;
import net.authorize.apicore.contract.v1.CreateTransactionResponse;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.controller.base.ApiOperationBase;

public class CreateTransactionController extends ApiOperationBase<CreateTransactionRequest, CreateTransactionResponse> {

	public CreateTransactionController(CreateTransactionRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		CreateTransactionRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getTransactionRequest()) throw new NullPointerException("TransactionRequest cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<CreateTransactionResponse> getResponseType() {
		return CreateTransactionResponse.class;
	}
}

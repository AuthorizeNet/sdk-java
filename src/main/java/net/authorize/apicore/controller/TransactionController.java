package net.authorize.apicore.controller;

import net.authorize.apicore.contract.v1.TransactionRequestType;
import net.authorize.apicore.contract.v1.TransactionResponse;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.controller.base.ApiOperationBase;

public class TransactionController 
//extends ApiOperationBase<TransactionRequestType, TransactionResponse> 
{

	public TransactionController(TransactionRequestType apiRequest) {
		//super(apiRequest);
	}
	
	//@Override
	protected void validateRequest() {
		//TransactionRequestType request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.get()) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	//@Override
	protected Class<TransactionResponse> getResponseType() {
		return TransactionResponse.class;
	}
}

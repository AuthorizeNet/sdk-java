package net.authorize.api.controller;

import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.TransactionTypeEnum;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class CreateTransactionController extends ApiOperationBase<CreateTransactionRequest, CreateTransactionResponse> {

	public CreateTransactionController(CreateTransactionRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		CreateTransactionRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getTransactionRequest()) throw new NullPointerException("TransactionRequest cannot be null");
		
		//validate Enum Fields from String
		String transactionType = request.getTransactionRequest().getTransactionType();
		TransactionTypeEnum newtransactionType = TransactionTypeEnum.fromValue(transactionType);
		if (!newtransactionType.value().equals(transactionType))
		{
			throw new IllegalArgumentException("Pass a valid 'value' of 'TransactionTypeEnum' (using .value() as string)");
		}
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<CreateTransactionResponse> getResponseType() {
		return CreateTransactionResponse.class;
	}
}

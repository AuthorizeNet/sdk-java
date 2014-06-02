package net.authorize.apicore.controller;

import net.authorize.apicore.contract.v1.GetTransactionListRequest;
import net.authorize.apicore.contract.v1.GetTransactionListResponse;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.controller.base.ApiOperationBase;

public class GetTransactionListController extends ApiOperationBase<GetTransactionListRequest, GetTransactionListResponse> {

	public GetTransactionListController(GetTransactionListRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetTransactionListRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getBatchId()) throw new NullPointerException("BatchId cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetTransactionListResponse> getResponseType() {
		return GetTransactionListResponse.class;
	}
}

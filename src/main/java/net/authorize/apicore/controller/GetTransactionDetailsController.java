package net.authorize.apicore.controller;

import net.authorize.apicore.contract.v1.GetTransactionDetailsRequest;
import net.authorize.apicore.contract.v1.GetTransactionDetailsResponse;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.controller.base.ApiOperationBase;

public class GetTransactionDetailsController extends ApiOperationBase<GetTransactionDetailsRequest, GetTransactionDetailsResponse> {

	public GetTransactionDetailsController(GetTransactionDetailsRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetTransactionDetailsRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getTransId()) throw new NullPointerException("TransId cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetTransactionDetailsResponse> getResponseType() {
		return GetTransactionDetailsResponse.class;
	}
}

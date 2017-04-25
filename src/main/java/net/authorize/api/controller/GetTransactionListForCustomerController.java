package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetTransactionListForCustomerRequest;
import net.authorize.api.contract.v1.GetTransactionListResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetTransactionListForCustomerController extends ApiOperationBase<GetTransactionListForCustomerRequest, GetTransactionListResponse> {

	public GetTransactionListForCustomerController(GetTransactionListForCustomerRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetTransactionListForCustomerRequest request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.getXXX) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetTransactionListResponse> getResponseType() {
		return GetTransactionListResponse.class;
	}
}

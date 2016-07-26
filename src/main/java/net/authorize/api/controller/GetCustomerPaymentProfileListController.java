package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetCustomerPaymentProfileListRequest;
import net.authorize.api.contract.v1.GetCustomerPaymentProfileListResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetCustomerPaymentProfileListController extends ApiOperationBase<GetCustomerPaymentProfileListRequest, GetCustomerPaymentProfileListResponse> {

	public GetCustomerPaymentProfileListController(GetCustomerPaymentProfileListRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetCustomerPaymentProfileListRequest request = this.getApiRequest();
		
		//validate required fields
		if ( null == request.getSearchType()) throw new NullPointerException("Search type cannot be null");
		if ( null == request.getMonth()) throw new NullPointerException("Month cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetCustomerPaymentProfileListResponse> getResponseType() {
		return GetCustomerPaymentProfileListResponse.class;
	}
}

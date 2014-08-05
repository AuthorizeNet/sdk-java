package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetCustomerProfileIdsRequest;
import net.authorize.api.contract.v1.GetCustomerProfileIdsResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetCustomerProfileIdsController extends ApiOperationBase<GetCustomerProfileIdsRequest, GetCustomerProfileIdsResponse> {

	public GetCustomerProfileIdsController(GetCustomerProfileIdsRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetCustomerProfileIdsRequest request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.get) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetCustomerProfileIdsResponse> getResponseType() {
		return GetCustomerProfileIdsResponse.class;
	}
}

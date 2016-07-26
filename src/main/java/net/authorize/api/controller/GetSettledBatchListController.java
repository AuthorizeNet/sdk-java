package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetSettledBatchListRequest;
import net.authorize.api.contract.v1.GetSettledBatchListResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetSettledBatchListController extends ApiOperationBase<GetSettledBatchListRequest, GetSettledBatchListResponse> {

	public GetSettledBatchListController(GetSettledBatchListRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetSettledBatchListRequest request = this.getApiRequest();
		
		//validate required fields
		//no required fields as per xsd
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetSettledBatchListResponse> getResponseType() {
		return GetSettledBatchListResponse.class;
	}
}

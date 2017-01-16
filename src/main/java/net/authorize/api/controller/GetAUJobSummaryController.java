package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetAUJobSummaryRequest;
import net.authorize.api.contract.v1.GetAUJobSummaryResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetAUJobSummaryController extends ApiOperationBase<GetAUJobSummaryRequest, GetAUJobSummaryResponse> {

	public GetAUJobSummaryController(GetAUJobSummaryRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetAUJobSummaryRequest request = this.getApiRequest();
		
		//validate required fields		
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetAUJobSummaryResponse> getResponseType() {
		return GetAUJobSummaryResponse.class;
	}
}

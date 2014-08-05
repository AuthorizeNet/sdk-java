package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetBatchStatisticsRequest;
import net.authorize.api.contract.v1.GetBatchStatisticsResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetBatchStatisticsController extends ApiOperationBase<GetBatchStatisticsRequest, GetBatchStatisticsResponse> {

	public GetBatchStatisticsController(GetBatchStatisticsRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetBatchStatisticsRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getBatchId()) throw new NullPointerException("BatchId cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetBatchStatisticsResponse> getResponseType() {
		return GetBatchStatisticsResponse.class;
	}
}

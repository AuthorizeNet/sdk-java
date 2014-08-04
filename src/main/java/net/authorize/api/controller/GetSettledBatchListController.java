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
		if ( null == request.getFirstSettlementDate()) throw new NullPointerException("FirstSettlementDate cannot be null");
		if ( null == request.getLastSettlementDate()) throw new NullPointerException("LastSettlementDate cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetSettledBatchListResponse> getResponseType() {
		return GetSettledBatchListResponse.class;
	}
}

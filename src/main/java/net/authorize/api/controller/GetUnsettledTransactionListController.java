package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetUnsettledTransactionListRequest;
import net.authorize.api.contract.v1.GetUnsettledTransactionListResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetUnsettledTransactionListController extends ApiOperationBase<GetUnsettledTransactionListRequest, GetUnsettledTransactionListResponse> {

	public GetUnsettledTransactionListController(GetUnsettledTransactionListRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetUnsettledTransactionListRequest request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.get) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetUnsettledTransactionListResponse> getResponseType() {
		return GetUnsettledTransactionListResponse.class;
	}
}

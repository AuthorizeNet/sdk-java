package net.authorize.api.controller;

import net.authorize.api.contract.v1.ARBGetSubscriptionListRequest;
import net.authorize.api.contract.v1.ARBGetSubscriptionListResponse;
import net.authorize.api.controller.base.ApiOperationBase;

public class ARBGetSubscriptionListController extends ApiOperationBase<ARBGetSubscriptionListRequest, ARBGetSubscriptionListResponse> {

	public ARBGetSubscriptionListController(ARBGetSubscriptionListRequest apiRequest) {
		super(apiRequest);
	}

	
	@Override
	protected void validateRequest() {
		ARBGetSubscriptionListRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getSearchType()) throw new NullPointerException("SearchType cannot be null");
		
		//Paging is not the compulsory parameter so need not be validated
//		if ( null == request.getPaging()) throw new NullPointerException("Paging cannot be null");
		
		//validate not-required fields		
	}

	@Override
	protected Class<ARBGetSubscriptionListResponse> getResponseType() {
		return ARBGetSubscriptionListResponse.class;
	}
}

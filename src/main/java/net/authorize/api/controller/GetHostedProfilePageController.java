package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetHostedProfilePageRequest;
import net.authorize.api.contract.v1.GetHostedProfilePageResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetHostedProfilePageController extends ApiOperationBase<GetHostedProfilePageRequest, GetHostedProfilePageResponse> {

	public GetHostedProfilePageController(GetHostedProfilePageRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetHostedProfilePageRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getCustomerProfileId()) throw new NullPointerException("CustomerProfileIdcannot be null");

	}

	@Override
	protected Class<GetHostedProfilePageResponse> getResponseType() {
		return GetHostedProfilePageResponse.class;
	}
}

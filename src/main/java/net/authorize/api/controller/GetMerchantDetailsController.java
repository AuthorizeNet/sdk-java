package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetMerchantDetailsRequest;
import net.authorize.api.contract.v1.GetMerchantDetailsResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetMerchantDetailsController extends ApiOperationBase<GetMerchantDetailsRequest, GetMerchantDetailsResponse> {

	public GetMerchantDetailsController(GetMerchantDetailsRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetMerchantDetailsRequest request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.getXXX) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetMerchantDetailsResponse> getResponseType() {
		return GetMerchantDetailsResponse.class;
	}
}

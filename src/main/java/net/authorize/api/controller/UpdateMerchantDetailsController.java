package net.authorize.api.controller;

import net.authorize.api.contract.v1.UpdateMerchantDetailsRequest;
import net.authorize.api.contract.v1.UpdateMerchantDetailsResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class UpdateMerchantDetailsController extends ApiOperationBase<UpdateMerchantDetailsRequest, UpdateMerchantDetailsResponse> {

	public UpdateMerchantDetailsController(UpdateMerchantDetailsRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		UpdateMerchantDetailsRequest request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.getXXX) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<UpdateMerchantDetailsResponse> getResponseType() {
		return UpdateMerchantDetailsResponse.class;
	}
}

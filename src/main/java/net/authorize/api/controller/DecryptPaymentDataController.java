package net.authorize.api.controller;

import net.authorize.api.contract.v1.DecryptPaymentDataRequest;
import net.authorize.api.contract.v1.DecryptPaymentDataResponse;
import net.authorize.api.controller.base.ApiOperationBase;

public class DecryptPaymentDataController extends ApiOperationBase<DecryptPaymentDataRequest, DecryptPaymentDataResponse> {

	public DecryptPaymentDataController(DecryptPaymentDataRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		DecryptPaymentDataRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getMerchantAuthentication()) throw new NullPointerException("The request's merchantAuthentication field cannot be null");
		if ( null == request.getOpaqueData()) throw new NullPointerException("The opaqueData field cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<DecryptPaymentDataResponse> getResponseType() {
		return DecryptPaymentDataResponse.class;
	}
}

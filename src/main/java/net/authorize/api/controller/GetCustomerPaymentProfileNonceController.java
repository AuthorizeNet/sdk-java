package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetCustomerPaymentProfileNonceRequest;
import net.authorize.api.contract.v1.GetCustomerPaymentProfileNonceResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetCustomerPaymentProfileNonceController extends ApiOperationBase<GetCustomerPaymentProfileNonceRequest, GetCustomerPaymentProfileNonceResponse> {

	public GetCustomerPaymentProfileNonceController(GetCustomerPaymentProfileNonceRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetCustomerPaymentProfileNonceRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getConnectedAccessToken()) throw new NullPointerException("ConnectedAccessToken");
		if(null == request.getCustomerPaymentProfileId()) throw new NullPointerException("ConnectedAccessToken");
		if(null== request.getCustomerProfileId())throw new NullPointerException("ConnectedAccessToken");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetCustomerPaymentProfileNonceResponse> getResponseType() {
		return GetCustomerPaymentProfileNonceResponse.class;
	}
}

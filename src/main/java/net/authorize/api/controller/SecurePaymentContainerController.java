package net.authorize.api.controller;

import net.authorize.api.contract.v1.SecurePaymentContainerRequest;
import net.authorize.api.contract.v1.SecurePaymentContainerResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class SecurePaymentContainerController extends ApiOperationBase<SecurePaymentContainerRequest, SecurePaymentContainerResponse> {

	public SecurePaymentContainerController(SecurePaymentContainerRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		SecurePaymentContainerRequest request = this.getApiRequest();
		
		//validate required fields
		if ( null == request.getData().getId()) throw new NullPointerException("Id cannot be null");
		if ( null == request.getData().getType()) throw new NullPointerException("Type cannot be null");
		if ( null == request.getData().getToken()) throw new NullPointerException("Token cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<SecurePaymentContainerResponse> getResponseType() {
		return SecurePaymentContainerResponse.class;
	}
}

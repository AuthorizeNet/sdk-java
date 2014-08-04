package net.authorize.api.controller;

import net.authorize.api.contract.v1.AuthenticateTestRequest;
import net.authorize.api.contract.v1.AuthenticateTestResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class AuthenticateTestController extends ApiOperationBase<AuthenticateTestRequest, AuthenticateTestResponse> {

	public AuthenticateTestController(AuthenticateTestRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		AuthenticateTestRequest request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.get) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<AuthenticateTestResponse> getResponseType() {
		return AuthenticateTestResponse.class;
	}
}

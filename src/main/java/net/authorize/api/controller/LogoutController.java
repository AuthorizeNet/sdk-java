package net.authorize.api.controller;

import net.authorize.api.contract.v1.LogoutRequest;
import net.authorize.api.contract.v1.LogoutResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class LogoutController extends ApiOperationBase<LogoutRequest, LogoutResponse> {

	public LogoutController(LogoutRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		//LogoutRequest request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.get()) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<LogoutResponse> getResponseType() {
		return LogoutResponse.class;
	}
}

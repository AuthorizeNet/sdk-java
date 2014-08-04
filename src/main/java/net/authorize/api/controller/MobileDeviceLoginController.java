package net.authorize.api.controller;

import net.authorize.api.contract.v1.MobileDeviceLoginRequest;
import net.authorize.api.contract.v1.MobileDeviceLoginResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class MobileDeviceLoginController extends ApiOperationBase<MobileDeviceLoginRequest, MobileDeviceLoginResponse> {

	public MobileDeviceLoginController(MobileDeviceLoginRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		MobileDeviceLoginRequest request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.get()) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<MobileDeviceLoginResponse> getResponseType() {
		return MobileDeviceLoginResponse.class;
	}
}

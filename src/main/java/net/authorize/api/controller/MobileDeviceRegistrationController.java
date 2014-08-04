package net.authorize.api.controller;

import net.authorize.api.contract.v1.MobileDeviceRegistrationRequest;
import net.authorize.api.contract.v1.MobileDeviceRegistrationResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class MobileDeviceRegistrationController extends ApiOperationBase<MobileDeviceRegistrationRequest, MobileDeviceRegistrationResponse> {

	public MobileDeviceRegistrationController(MobileDeviceRegistrationRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		MobileDeviceRegistrationRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getMobileDevice()) throw new NullPointerException("MobileDevice cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<MobileDeviceRegistrationResponse> getResponseType() {
		return MobileDeviceRegistrationResponse.class;
	}
}

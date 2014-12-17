package net.authorize.api.controller;

import net.authorize.api.contract.v1.CreateFingerPrintRequest;
import net.authorize.api.contract.v1.CreateFingerPrintResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class CreateFingerPrintController extends ApiOperationBase<CreateFingerPrintRequest, CreateFingerPrintResponse> {

	public CreateFingerPrintController(CreateFingerPrintRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		CreateFingerPrintRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getSupportInformation()) throw new NullPointerException("SupportInformation cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<CreateFingerPrintResponse> getResponseType() {
		return CreateFingerPrintResponse.class;
	}
}

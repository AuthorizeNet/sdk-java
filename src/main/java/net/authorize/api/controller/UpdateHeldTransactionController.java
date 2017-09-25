package net.authorize.api.controller;

import net.authorize.api.contract.v1.UpdateHeldTransactionRequest;
import net.authorize.api.contract.v1.UpdateHeldTransactionResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class UpdateHeldTransactionController extends ApiOperationBase<UpdateHeldTransactionRequest, UpdateHeldTransactionResponse> {

	public UpdateHeldTransactionController(UpdateHeldTransactionRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		UpdateHeldTransactionRequest request = this.getApiRequest();
		
		//validate required fields		
		//if ( null == request.getXXX) throw new NullPointerException("XXX cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<UpdateHeldTransactionResponse> getResponseType() {
		return UpdateHeldTransactionResponse.class;
	}
}

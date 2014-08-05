package net.authorize.api.controller;

import net.authorize.api.contract.v1.UpdateSplitTenderGroupRequest;
import net.authorize.api.contract.v1.UpdateSplitTenderGroupResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class UpdateSplitTenderGroupController extends ApiOperationBase<UpdateSplitTenderGroupRequest, UpdateSplitTenderGroupResponse> {

	public UpdateSplitTenderGroupController(UpdateSplitTenderGroupRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		UpdateSplitTenderGroupRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getSplitTenderId()) throw new NullPointerException("SplitTenderId cannot be null");
		if ( null == request.getSplitTenderStatus()) throw new NullPointerException("SplitTenderStatus cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<UpdateSplitTenderGroupResponse> getResponseType() {
		return UpdateSplitTenderGroupResponse.class;
	}
}

package net.authorize.api.controller;

import net.authorize.api.contract.v1.UpdateCustomerShippingAddressRequest;
import net.authorize.api.contract.v1.UpdateCustomerShippingAddressResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class UpdateCustomerShippingAddressController extends ApiOperationBase<UpdateCustomerShippingAddressRequest, UpdateCustomerShippingAddressResponse> {

	public UpdateCustomerShippingAddressController(UpdateCustomerShippingAddressRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		UpdateCustomerShippingAddressRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getCustomerProfileId()) throw new NullPointerException("CustomerProfileId cannot be null");
		if ( null == request.getAddress()) throw new NullPointerException("Address cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<UpdateCustomerShippingAddressResponse> getResponseType() {
		return UpdateCustomerShippingAddressResponse.class;
	}
}

package net.authorize.api.controller;

import net.authorize.api.contract.v1.CreateCustomerShippingAddressRequest;
import net.authorize.api.contract.v1.CreateCustomerShippingAddressResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class CreateCustomerShippingAddressController extends ApiOperationBase<CreateCustomerShippingAddressRequest, CreateCustomerShippingAddressResponse> {

	public CreateCustomerShippingAddressController(CreateCustomerShippingAddressRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		CreateCustomerShippingAddressRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getCustomerProfileId()) throw new NullPointerException("CustomerProfileId cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<CreateCustomerShippingAddressResponse> getResponseType() {
		return CreateCustomerShippingAddressResponse.class;
	}
}

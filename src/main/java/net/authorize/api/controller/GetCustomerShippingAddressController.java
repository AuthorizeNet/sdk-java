package net.authorize.api.controller;

import net.authorize.api.contract.v1.GetCustomerShippingAddressRequest;
import net.authorize.api.contract.v1.GetCustomerShippingAddressResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class GetCustomerShippingAddressController extends ApiOperationBase<GetCustomerShippingAddressRequest, GetCustomerShippingAddressResponse> {

	public GetCustomerShippingAddressController(GetCustomerShippingAddressRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		GetCustomerShippingAddressRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getCustomerProfileId()) throw new NullPointerException("CustomerProfileId cannot be null");
		if ( null == request.getCustomerAddressId()) throw new NullPointerException("CustomerAddressId cannot be null");
		
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<GetCustomerShippingAddressResponse> getResponseType() {
		return GetCustomerShippingAddressResponse.class;
	}
}

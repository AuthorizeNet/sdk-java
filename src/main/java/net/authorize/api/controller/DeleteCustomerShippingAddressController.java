package net.authorize.api.controller;

import net.authorize.api.contract.v1.DeleteCustomerShippingAddressRequest;
import net.authorize.api.contract.v1.DeleteCustomerShippingAddressResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class DeleteCustomerShippingAddressController extends ApiOperationBase<DeleteCustomerShippingAddressRequest, DeleteCustomerShippingAddressResponse> {

	public DeleteCustomerShippingAddressController(DeleteCustomerShippingAddressRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		DeleteCustomerShippingAddressRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getCustomerProfileId()) throw new NullPointerException("CustomerProfileId cannot be null");
		if ( null == request.getCustomerAddressId()) throw new NullPointerException("CustomerAddressId cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<DeleteCustomerShippingAddressResponse> getResponseType() {
		return DeleteCustomerShippingAddressResponse.class;
	}
}

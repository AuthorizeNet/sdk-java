package net.authorize.apicore.helper;

import net.authorize.apicore.contract.v1.DeleteCustomerProfileRequest;
import net.authorize.apicore.contract.v1.DeleteCustomerProfileResponse;

/**
 * @author ramittal
 *
 */
public class DeleteCustomerProfileController extends ApiOperationBase<DeleteCustomerProfileRequest, DeleteCustomerProfileResponse> {

	public DeleteCustomerProfileController(DeleteCustomerProfileRequest apiRequest) {
		super(apiRequest);
	}

	
	@Override
	protected void validateRequest() {
		DeleteCustomerProfileRequest request = this.getApiRequest();
		
		//validate required fields
		if ( null == request.getCustomerProfileId()) throw new NullPointerException("CustomerProfileId cannot be null");
		//if ( null == request.getRefId()) throw new NullPointerException("RefId cannot be null");

		//validate not-required fields		
	}

	@Override
	protected Class<DeleteCustomerProfileResponse> getResponseType() {
		return DeleteCustomerProfileResponse.class;
	}
}

package net.authorize.api.controller;

import net.authorize.api.contract.v1.SendCustomerTransactionReceiptRequest;
import net.authorize.api.contract.v1.SendCustomerTransactionReceiptResponse;
import net.authorize.api.contract.v1.ValidationModeEnum;
import net.authorize.api.controller.base.ApiOperationBase;

public class SendCustomerTransactionReceiptController extends ApiOperationBase<SendCustomerTransactionReceiptRequest, SendCustomerTransactionReceiptResponse> {

	public SendCustomerTransactionReceiptController(SendCustomerTransactionReceiptRequest apiRequest) {
		super(apiRequest);
	}
	
	@Override
	protected void validateRequest() {
		SendCustomerTransactionReceiptRequest request = this.getApiRequest();
		
		//validate required fields		
		if ( null == request.getTransId()) throw new NullPointerException("TransId cannot be null");
		if ( null == request.getCustomerEmail()) throw new NullPointerException("CustomerEmail cannot be null");
		if ( null == request.getEmailSettings()) throw new NullPointerException("EmailSettings cannot be null");
		
		//validate not-required fields		
		//creditCardOne.setCardCode("");
	}

	@Override
	protected Class<SendCustomerTransactionReceiptResponse> getResponseType() {
		return SendCustomerTransactionReceiptResponse.class;
	}
}

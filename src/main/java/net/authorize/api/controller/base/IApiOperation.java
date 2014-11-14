package net.authorize.api.controller.base;

import java.util.List;

import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiRequest;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.MessageTypeEnum;

/**
 * @author ramittal
 *
 */
public interface IApiOperation<Q extends ANetApiRequest, S extends ANetApiResponse> {
	public S getApiResponse();
	public ANetApiResponse getErrorResponse();
	public S executeWithApiResponse();
	public S executeWithApiResponse(Environment environment);
	public void execute(); 
	public void execute(Environment environment); 
	public MessageTypeEnum getResultCode();	
	public List<String> getResults();
}

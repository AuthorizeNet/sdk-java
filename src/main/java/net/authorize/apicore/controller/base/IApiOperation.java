package net.authorize.apicore.controller.base;

import java.util.List;

import net.authorize.Environment;
import net.authorize.apicore.contract.v1.ANetApiRequest;
import net.authorize.apicore.contract.v1.ANetApiResponse;
import net.authorize.apicore.contract.v1.MessageTypeEnum;

/**
 * @author ramittal
 *
 */
public interface IApiOperation<Q extends ANetApiRequest, S extends ANetApiResponse> {
	public void execute(); 
	public void execute(Environment environment); 
	public List<String> getResults();
	public MessageTypeEnum getResultCode();	
}

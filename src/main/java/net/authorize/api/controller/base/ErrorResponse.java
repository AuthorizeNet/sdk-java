package net.authorize.api.controller.base;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.MessagesType;

@XmlRootElement(name = "ErrorResponse")
/**
 * Since JAXB does not generate the class for this element, custom coding it
 * @author ramittal
 *
 */
abstract class ErrorResponse extends ANetApiResponse {
	private static final long serialVersionUID = 1L;

	public String toString() {
		 StringBuilder builder = new StringBuilder();
		 builder.append("ErrorResponse: ");
		 builder.append(super.toString());
		 builder.append(", Id: ").append(this.getRefId());
		 builder.append(", SessionToken: ").append(this.getSessionToken());
		 MessagesType messagesType = this.getMessages();
		 builder.append(", MessagesType: ");
		 if ( null != messagesType)
		 {
			 builder.append(", ResultCode:").append(messagesType.getResultCode());
			 List<MessagesType.Message> messages = messagesType.getMessage();
			 if ( null != messages) {
				 for ( MessagesType.Message  message : messages) {
					 builder.append(", Message-> ");
					 builder.append(", Code: ").append(message.getCode());
					 builder.append(", Text: ").append(message.getText());
				 }
			 }
		 }
		    
	     return builder.toString();
   }
}

package net.authorize.data.reporting;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* Subscription container.
* 
* @deprecated since version 1.9.8
* @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
* @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API.
* @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
* @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-php/tree/master/PaymentTransactions.
* @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
*
*/
@Deprecated
@XmlRootElement
public class Subscription implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private int payNum = 0;
	private static Log logger = LogFactory.getLog(Subscription.class);

	/**
    * Default C'tor
    */
	protected Subscription() {

	}

	/**
	 * Create a subscription.
	 *
	 * @return Subscription with empty fields 
	 */
	public static Subscription createSubscription() {
		return new Subscription();
	}

	/**
	 * Creates a populated Subscription
	 * @param id Sets the subscription Id for subscription
	 * @param payNum Sets the payment number for subscription
	 * @return Subscription with fields populated
	 */
	public static Subscription createSubscription(int id, int payNum) {
		Subscription subscription = new Subscription();
		subscription.setId(id);
		subscription.setPayNum(payNum);
		
		return subscription;
	}
	
	/**
	 * Get the subscription id.
	 *
	 * @return int Gets the subscription Id for subscription
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Set the subscription id.
	 *
	 * @param id Sets the subscription Id for subscription
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the payNum.
	 *
	 * @return int Gets the payment number for subscription
	 */
	public int getPayNum() {
		return this.payNum;
	}

	/**
	 * Set the payNum.
	 *
	 * @param payNum Sets the payment number for subscription
	 */
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	
	//overloaded utility methods
	/**
	 * Set the subscription id.
	 *
	 * @param id Sets the subscription Id for subscription
	 */
	public void setId(String id) {
		this.setId(net.authorize.util.StringUtils.parseInt(id));
	}

	/**
	 * Set the payNum.
	 *
	 * @param payNum Sets the payment number for subscription
	 */
	public void setPayNum(String payNum) {
		this.setPayNum(net.authorize.util.StringUtils.parseInt(payNum));
	}
	
	public String toString() {
		 StringBuilder builder = new StringBuilder();
		 builder.append("Subscription:");
		 builder.append(" Id: ").append(this.id);
		 builder.append(",PayNum: ").append(this.payNum);
		 
	     return builder.toString();
    }
}

package net.authorize.data.reporting;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
* Subscription container.
*/
@XmlRootElement
public class Subscription implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private int payNum = 0;

	/**
    * Default C'tor
    */
	protected Subscription() {

	}

	/**
	 * Create a subscription.
	 *
	 * @return Subscription
	 */
	public static Subscription createSubscription() {
		return new Subscription();
	}

	public static Subscription createSubscription(int id, int payNum) {
		Subscription subscription = new Subscription();
		subscription.setId(id);
		subscription.setPayNum(payNum);
		
		return subscription;
	}
	
	/**
	 * Get the subscription id.
	 *
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Set the subscription id.
	 *
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the payNum.
	 *
	 * @return int
	 */
	public int getPayNum() {
		return this.payNum;
	}

	/**
	 * Set the payNum.
	 *
	 * @param payNum
	 */
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	
	//overloaded utility methods
	/**
	 * Set the subscription id.
	 *
	 * @param id
	 */
	public void setId(String id) {
		this.id = Integer.parseInt( id);
	}

	/**
	 * Set the payNum.
	 *
	 * @param payNum
	 */
	public void setPayNum(String payNum) {
		this.payNum = Integer.parseInt( payNum);
	}
	
	
	public String toString() {
		 StringBuilder builder = new StringBuilder();
		 builder.append("Subscription:");
		 builder.append(" Id: ").append(this.id);
		 builder.append(",PayNum: ").append(this.payNum);
		 
	     return builder.toString();
    }
}

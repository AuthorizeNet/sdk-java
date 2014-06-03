package net.authorize.aim.cardpresent;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* PrepaidCard container.
*/
@XmlRootElement
public class PrepaidCard implements Serializable{
	private static final long serialVersionUID = 1L;
	private double requestedAmount = 0.0;
	private double approvedAmount = 0.0;
	private double balanceAmountOnCard = 0.0;

	private static Log logger = LogFactory.getLog(PrepaidCard.class);

	/**
    * Default C'tor
    */
	protected PrepaidCard() {

	}

	/**
	 * Create a prepaidCard.
	 *
	 * @return PrepaidCard with empty fields 
	 */
	public static PrepaidCard createPrepaidCard() {
		return new PrepaidCard();
	}

	/**
	 * Creates a populated PrepaidCard
	 * @param requestedAmount  amount requested in the transaction
	 * @param approvedAmount   amount approved in the transaction
	 * @param balanceAmountOnCard  remaining balance on the card
	 * @return PrepaidCard with fields populated
	 */
	public static PrepaidCard createPrepaidCard(
			double requestedAmount, double approvedAmount, double balanceAmountOnCard) {
		PrepaidCard prepaidCard = new PrepaidCard();
		prepaidCard.setRequestedAmount(requestedAmount);
		prepaidCard.setApprovedAmount(approvedAmount);
		prepaidCard.setBalanceAmountOnCard(balanceAmountOnCard);
		
		return prepaidCard;
	}

	/**
	 * Creates a populated PrepaidCard
	 * @param requestedAmount  amount requested in the transaction
	 * @param approvedAmount   amount approved in the transaction
	 * @param balanceAmountOnCard  remaining balance on the card
	 * @return PrepaidCard with fields populated
	 */
	public static PrepaidCard createPrepaidCard(
			String requestedAmount, String approvedAmount, String balanceAmountOnCard) {
		PrepaidCard prepaidCard = new PrepaidCard();
		prepaidCard.setRequestedAmount(requestedAmount);
		prepaidCard.setApprovedAmount(approvedAmount);
		prepaidCard.setBalanceAmountOnCard(balanceAmountOnCard);
		
		return prepaidCard;
	}
	
	/**
	 * Gets amount requested in the transaction
	 * @return amount requested in the transaction
	 */
	public double getRequestedAmount() {
		return requestedAmount;
	}

	/**
	 * Gets amount approved in the transaction
	 * @return amount approved in the transaction
	 */
	public double getApprovedAmount() {
		return approvedAmount;
	}

	/**
	 * Gets remaining balance on the card
	 * @return remaining balance on the card
	 */
	public double getBalanceAmountOnCard() {
		return balanceAmountOnCard;
	}

	/**
	 * Sets amount requested in the transaction
	 * @param requestedAmount amount requested in the transaction
	 */
	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	/**
	 * Set amount approved in the transaction
	 * @param approvedAmount amount approved in the transaction
	 */
	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}
	
	/**
	 * Sets remaining balance on the card
	 * @param balanceAmountOnCard remaining balance on the card
	 */
	public void setBalanceAmountOnCard(double balanceAmountOnCard) {
		this.balanceAmountOnCard = balanceAmountOnCard;
	}

	//overloaded utility methods
	/**
	 * Sets amount requested in the transaction
	 * @param requestedAmount amount requested in the transaction
	 */
	public void setRequestedAmount(String requestedAmount) {
		this.requestedAmount = net.authorize.util.StringUtils.parseDouble(requestedAmount);
	}

	/**
	 * Set amount approved in the transaction
	 * @param approvedAmount amount approved in the transaction
	 */
	public void setApprovedAmount(String approvedAmount) {
		this.approvedAmount = net.authorize.util.StringUtils.parseDouble(approvedAmount);
	}

	/**
	 * Sets remaining balance on the card
	 * @param balanceAmountOnCard remaining balance on the card
	 */
	public void setBalanceAmountOnCard(String balanceAmountOnCard) {
		this.balanceAmountOnCard = net.authorize.util.StringUtils.parseDouble(balanceAmountOnCard);
	}
	
	public String toString() {
		 StringBuilder builder = new StringBuilder();
		 builder.append("PrepaidCard:");
		 builder.append(" RequestedAmount: ").append(this.requestedAmount);
		 builder.append(",ApprovedAmount: ").append(this.approvedAmount);
		 builder.append(",BalanceAmountOnCard: ").append(this.balanceAmountOnCard);		 
		 
	     return builder.toString();
    }
}

package net.authorize.data.arb;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
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
public class PaymentSchedule implements Serializable {

	private static final long serialVersionUID = 1L;

	public static String SCHEDULE_DATE_FORMAT = "yyyy-MM-dd";

	private int interval_length = 0;
	private SubscriptionUnitType subscription_unit = SubscriptionUnitType.DAYS; // days | months
	private Date start_date = null;
	private int total_occurrences = 0;
	private int trial_occurrences = 0;

	protected PaymentSchedule(){

	}

	public static PaymentSchedule createPaymentSchedule() {
		return new PaymentSchedule();
	}

	public int getIntervaLength() {
		return interval_length;
	}

	public void setIntervalLength(int interval_length) {
		this.interval_length = interval_length;
	}

	public Date getStartDate() {
		return start_date;
	}
	public void setStartDate(Date date){
		this.start_date = date;
	}
	public void setStartDate(String start_date) {
		this.start_date = net.authorize.util.DateUtil.getDateFromFormattedDate(start_date, SCHEDULE_DATE_FORMAT);
	}

	public SubscriptionUnitType getSubscriptionUnit() {
		return subscription_unit;
	}

	public void setSubscriptionUnit(SubscriptionUnitType subscription_unit) {
		this.subscription_unit = subscription_unit;
	}

	public int getTotalOccurrences() {
		return total_occurrences;
	}

	public void setTotalOccurrences(int total_occurrences) {
		this.total_occurrences = total_occurrences;
	}

	public int getTrialOccurrences() {
		return trial_occurrences;
	}

	public void setTrialOccurrences(int trial_occurrences) {
		this.trial_occurrences = trial_occurrences;
	}
}

package net.authorize.data.echeck;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Container used to hold ECheck related information.
 *
 * @deprecated since version 1.9.8
 * @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
 * @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API (package: net.authorize.api.*).
 * @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
 * @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/PaymentTransactions.
 * @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
 *
 */
@Deprecated
@XmlRootElement
public class ECheck implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final int MAX_ROUTING_NUMBER_LENGTH = 9;
	public static final int MAX_ACCOUNT_NUMBER_LENGTH = 20;
	public static final int MAX_BANK_NAME_LENGTH = 50;
	public static final int MAX_BANK_ACCOUNT_LENGTH = 50;
	public static final int MAX_BANK_CHECK_NUMBER_LENGTH = 15;

	protected String routingNumber;
	protected String bankAccountNumber;
	protected BankAccountType bankAccountType;
	protected String bankName;
	protected String bankAccountName;
	protected ECheckType eCheckType;
	protected String bankCheckNumber;

	protected ECheck() { }

	public static ECheck createECheck() {
		return new ECheck();
	}

	/**
	 * @return the routingNumber
	 */
	public String getRoutingNumber() {
		return routingNumber;
	}
	/**
	 * @param routingNumber the routingNumber to set
	 */
	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}
	/**
	 * @return the bankAccountNumber
	 */
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	/**
	 * @param bankAccountNumber the bankAccountNumber to set
	 */
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	/**
	 * @return the bankAccountType
	 */
	public BankAccountType getBankAccountType() {
		return bankAccountType;
	}
	/**
	 * @param bankAccountType the bankAccountType to set
	 */
	public void setBankAccountType(BankAccountType bankAccountType) {
		this.bankAccountType = bankAccountType;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the bankAccountName
	 */
	public String getBankAccountName() {
		return bankAccountName;
	}
	/**
	 * @param bankAccountName the bankAccountName to set
	 */
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	/**
	 * @return the eCheckType
	 */
	public ECheckType getECheckType() {
		return eCheckType;
	}
	/**
	 * @param eCheckType the eCheckType to set
	 */
	public void setECheckType(ECheckType eCheckType) {
		this.eCheckType = eCheckType;
	}
	/**
	 * @return the bankCheckNumber
	 */
	public String getBankCheckNumber() {
		return bankCheckNumber;
	}
	/**
	 * @param bankCheckNumber the bankCheckNumber to set
	 */
	public void setBankCheckNumber(String bankCheckNumber) {
		this.bankCheckNumber = bankCheckNumber;
	}

}

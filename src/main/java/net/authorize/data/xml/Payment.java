package net.authorize.data.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import net.authorize.data.creditcard.CreditCard;

/**
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
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	private CreditCard credit_card;
	private BankAccount bank_account;

	protected Payment(){

	}

	public static Payment createPayment(CreditCard in_credit) {
		Payment payment = new Payment();
		payment.credit_card = in_credit;

		return payment;
	}

	public static Payment createPayment(BankAccount in_account) {
		Payment payment = new Payment();
		payment.bank_account = in_account;

		return payment;
	}

	public BankAccount getBankAccount() {
		return bank_account;
	}
	public void setBankAccount(BankAccount bank_account) {
		this.bank_account = bank_account;
	}
	public CreditCard getCreditCard() {
		return credit_card;
	}
	public void setCreditCard(CreditCard credit_card) {
		this.credit_card = credit_card;
	}

}

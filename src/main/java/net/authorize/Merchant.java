package net.authorize;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import net.authorize.Result;
import net.authorize.data.arb.Subscription;
import net.authorize.util.BasicXmlDocument;
import net.authorize.util.HttpClient;

/**
 * Container to hold authentication credentials.
 *
 * The Merchant is also responsible for creating transactions and
 * posting them to the gateway are performed through the Merchant.
 *
 */
public class Merchant implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final String CP_VERSION = "1.0";	// card present version
	public static final int MAX_LOGIN_LENGTH = 20;
	public static final int MAX_TRANSACTION_KEY_LENGTH = 16;

	private Environment environment = Environment.SANDBOX;
	private String login;
	private String transactionKey;
	private boolean allowPartialAuth = false;
	private MarketType marketType = null;
	private DeviceType deviceType = null;
	private String userRef = null;
	private String MD5Value = null;

	private Merchant() {
	}

	public static Merchant createMerchant(Environment environment, String login,
			String transactionKey) {
		Merchant merchant = new Merchant();
		merchant.environment = environment;
		merchant.setLogin(login);
		merchant.setTransactionKey(transactionKey);

		return merchant;
	}

	/**
	 * Get the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Set the login.
	 *
	 * @param login the login to set
	 */
	private void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Get the transaction key.
	 *
	 * @return the transactionKey
	 */
	public String getTransactionKey() {
		return transactionKey;
	}

	/**
	 * Set the transaction key.
	 *
	 * @param transactionKey the transactionKey to set
	 */
	private void setTransactionKey(String transactionKey) {
		this.transactionKey = transactionKey;
	}

	/**
	 * Return true if the merchant has been enabled, via the SDK, to allow
	 * partial AUTH transactions.
	 *
	 * @return the allowPartialAuth
	 */
	public boolean isAllowPartialAuth() {
		return allowPartialAuth;
	}

	/**
	 * Indicates if the transaction is enabled for partial authorization.
	 * Including this field in the transaction request overrides your account
	 * configuration.
	 *
	 * @param allowPartialAuth
	 *            the allowPartialAuth to set
	 */
	public void setAllowPartialAuth(boolean allowPartialAuth) {
		this.allowPartialAuth = allowPartialAuth;
	}

	/**
	 * Get the Environment that transactions will be posted against.
	 *
	 * @return the environment
	 */
	public Environment getEnvironment() {
		return environment;
	}

	/**
	 * Set the environment that transactions will be posted against.
	 *
	 * @param environment the environment to set
	 */
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	/**
	 * Return true if the environment is a sandbox type environment.
	 *
	 * @return true if in the sandbox environment
	 */
	public boolean isSandboxEnvironment() {
		return (environment!=null&&
			(Environment.SANDBOX.equals(this.environment) ||
					Environment.SANDBOX_TESTMODE.equals(this.environment)));
	}

	/**
	 * @return the marketType
	 */
	public MarketType getMarketType() {
		return marketType;
	}

	/**
	 * @param marketType the marketType to set
	 */
	public void setMarketType(MarketType marketType) {
		this.marketType = marketType;
	}

	/**
	 * @return the deviceType
	 */
	public DeviceType getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the MD5Value
	 */
	public String getMD5Value() {
		return MD5Value;
	}

	/**
	 * @param MD5Value the MD5Value to set
	 */
	public void setMD5Value(String MD5Value) {
		this.MD5Value = MD5Value;
	}

	/**
	 * Get the UserRef value.
	 *
	 * @return the userRef
	 */
	public String getUserRef() {
		return userRef;
	}

	/**
	 * Set the userRef for Card Present transactions.
	 *
	 * @param userRef the userRef to set
	 */
	public void setUserRef(String userRef) {
		this.userRef = userRef;
	}

	/**
	 * Creates a new AIM Transaction.
	 *
	 * @param transactionType
	 * @param amount
	 *
	 * @return A newly created Transaction will be returned.
	 */
	public net.authorize.aim.Transaction createAIMTransaction(TransactionType transactionType,
			BigDecimal amount) {
		return net.authorize.aim.Transaction.createTransaction(this, transactionType, amount);
	}

	/**
	 * Creates a new SIM Transaction.
	 *
	 * @param transactionType
	 * @param fingerPrintSequence
	 * @param amount
	 *
	 * @return A newly created Transaction will be returned.
	 */
	public net.authorize.sim.Transaction createSIMTransaction(TransactionType transactionType,
			 long fingerPrintSequence, BigDecimal amount) {

		return net.authorize.sim.Transaction.createTransaction(this, transactionType,
				fingerPrintSequence, amount);
	}

	/**
	 * Creates a new ARB Transaction.
	 *
	 * @param transactionType
	 *
	 * @return A newly created Transaction will be returned.
	 */
	public net.authorize.arb.Transaction createARBTransaction(net.authorize.arb.TransactionType transactionType, Subscription subscription) {

		return net.authorize.arb.Transaction.createTransaction(this, transactionType, subscription);
	}

	/**
	 * Creates a new CIM Transaction.
	 *
	 * @param transactionType
	 *
	 * @return A newly created Transaction will be returned.
	 */
	public net.authorize.cim.Transaction createCIMTransaction(net.authorize.cim.TransactionType transactionType) {

		return net.authorize.cim.Transaction.createTransaction(this, transactionType);
	}

	/**
	 * Creates a new Reporting Transaction.
	 *
	 * @param transactionType
	 *
	 * @return A newly created Transaction will be returned.
	 */
	public net.authorize.reporting.Transaction createReportingTransaction(net.authorize.reporting.TransactionType transactionType) {

		return net.authorize.reporting.Transaction.createTransaction(this, transactionType);
	}

	/**
	 * Post a Transaction request to the payment gateway.
	 *
	 * @param transaction
	 *
	 * @return A Result<T> is returned with each post.
	 *
	 */
	public net.authorize.Result<?> postTransaction(Transaction transaction) {

		Result<Transaction> result = null;

		// retrieve the raw mappings from the HttpClient for AIM/SIM
		if(transaction instanceof net.authorize.aim.Transaction ||
				transaction instanceof net.authorize.sim.Transaction) {

			// check if this is a Card Present transaction
			if(transaction instanceof net.authorize.aim.Transaction &&
					((net.authorize.aim.Transaction)transaction).isCardPresent()) {
				BasicXmlDocument responseXML = HttpClient.executeXML(this.environment, transaction);
				result = net.authorize.aim.cardpresent.Result.createResult(transaction, responseXML);
			} else {
				Map<ResponseField, String> responseMap = HttpClient.execute(this.environment, transaction);
				result = net.authorize.aim.Result.createResult(transaction, responseMap);
			}
		}
		else if (transaction instanceof net.authorize.arb.Transaction) {
			BasicXmlDocument response = HttpClient.executeXML(this.environment, transaction);
			result = net.authorize.arb.Result.createResult(transaction, response);
		}
		else if (transaction instanceof net.authorize.cim.Transaction) {
			BasicXmlDocument response = HttpClient.executeXML(this.environment, transaction);
			result = net.authorize.cim.Result.createResult(transaction, response);
		}
		else if (transaction instanceof net.authorize.reporting.Transaction) {
			BasicXmlDocument response = HttpClient.executeXML(this.environment, transaction);
			result = net.authorize.reporting.Result.createResult(transaction, response);
		}
		return result;
	}
}

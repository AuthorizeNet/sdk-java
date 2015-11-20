package net.authorize;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Transaction transaction;

	protected T target;

	/**
	 * Get the request transaction.
	 *
	 * @return Transaction
	 */
	public Transaction getTransaction() {
		return this.transaction;
	}

	/**
	 * Get the target (request + response transaction).
	 *
	 * @return Transaction
	 */
	public T getTarget() {
		return this.target;
	}

   /**
    * Verify that the relay response post is actually coming from
    * AuthorizeNet.
    *
    * @return boolean true if the txn came from Authorize.Net
    */
	public static boolean isAuthorizeNetResponse(String md5Value, String apiLoginId, String amount, String transId, String transHash) {

        String md5Check = null;

	    try {
		    MessageDigest digest = java.security.MessageDigest.getInstance( MessageDigestAlgorithm);
		    String salt = md5Value + apiLoginId + transId + amount;
		    digest.update( salt.getBytes());
		    md5Check = new BigInteger(1,digest.digest()).toString(16).toUpperCase();
		    while(md5Check.length() < 32) {
		    	md5Check = "0" + md5Check;
		    }
	    } catch (NoSuchAlgorithmException nsae) {
	    	//
	    }

	    boolean result = md5Check != null && md5Check.equalsIgnoreCase( transHash);
	
            return result;
	}
	
	public static final String MessageDigestAlgorithm = "MD5";
}

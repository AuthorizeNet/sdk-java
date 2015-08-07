package net.authorize.sim;

import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import net.authorize.Merchant;
import net.authorize.util.LogHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Fingerprint {
	private static Log logger = LogFactory.getLog(Fingerprint.class);

	private long sequence;
	private long timeStamp;
	private String fingerprintHash;

	private Fingerprint() {
	}

	/**
	 * Creates a fingerprint with raw data fields.
	 *
	 * @param loginID
	 * @param transactionKey
	 * @param sequence : this number will be concatenated with a random value
	 * @param amount
	 * @return A Fingerprint object.
	 */
	public static Fingerprint createFingerprint(String loginID,
												String transactionKey,
                                                long sequence,
                                                String amount) {

        return createFingerprint(loginID,transactionKey,sequence,amount,"");

    }

		/**
         * Creates a fingerprint with raw data fields.
         *
         * @param loginID
         * @param transactionKey
         * @param sequence : this number will be concatenated with a random value
         * @param amount
         * @param currency
         * @return A Fingerprint object.
         */
	public static Fingerprint createFingerprint(String loginID,
			String transactionKey, long sequence, String amount, String currency) {

		Fingerprint fingerprint = new Fingerprint();

		// a sequence number is randomly generated
		SecureRandom generator = new SecureRandom();
		fingerprint.sequence = Long.parseLong(sequence+""+generator.nextInt(1000));
		// a timestamp is generated
		fingerprint.timeStamp = System.currentTimeMillis() / 1000;

		// This section uses Java Cryptography functions to generate a
		// fingerprint
		try {
			// First, the Transaction key is converted to a "SecretKey" object
			SecretKey key = new SecretKeySpec(transactionKey.getBytes(),
					"HmacMD5");
			// A MAC object is created to generate the hash using the HmacMD5
			// algorithm
			Mac mac = Mac.getInstance("HmacMD5");
			mac.init(key);
			String inputstring = loginID + "^" + fingerprint.sequence + "^" +
				fingerprint.timeStamp + "^" + amount + "^" + currency;
			byte[] result = mac.doFinal(inputstring.getBytes());
			// Convert the result from byte[] to hexadecimal format
			StringBuilder strbuf = new StringBuilder(result.length * 2);
            for (byte aResult : result) {
                if (((int) aResult & 0xff) < 0x10) {
                    strbuf.append("0");
                }
                strbuf.append(Long.toString((int) aResult & 0xff, 16));
            }
			fingerprint.fingerprintHash = strbuf.toString();
		} catch (NoSuchAlgorithmException nsae) {
			LogHelper.error(logger, "Fingerprint creation failed.", nsae);

		} catch (InvalidKeyException ike) {
			LogHelper.error(logger, "Fingerprint creation failed.", ike);

		}

		return fingerprint;
	}

	/**
	 * Create a fingerprint with object based fields.
	 *
	 * @param merchant
	 * @param sequence : this number will be concatenated with a random value
	 * @param amount
	 * @return A Fingerprint object.
	 */
	public static Fingerprint createFingerprint(Merchant merchant, long sequence,
			BigDecimal amount) {
		Fingerprint fingerprint = new Fingerprint();

		if (merchant != null && amount != null) {
			fingerprint = Fingerprint.createFingerprint(merchant.getLogin(),
					merchant.getTransactionKey(), sequence, amount.setScale(Transaction.CURRENCY_DECIMAL_PLACES,
							BigDecimal.ROUND_HALF_UP).toPlainString());
		}

		return fingerprint;
	}

	/**
	 * Get the  sequence that was used in creating the fingerprint.
	 *
	 * @return the sequence
	 */
	public long getSequence() {
		return Math.abs(sequence);
	}

	/**
	 * Get the timestamp that was used in creating the fingerprint.
	 *
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Get the fingerprint hash.
	 *
	 * @return the fingerprintHash
	 */
	public String getFingerprintHash() {
		return fingerprintHash;
	}


}

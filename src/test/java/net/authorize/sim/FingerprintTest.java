package net.authorize.sim;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;

import junit.framework.Assert;
import net.authorize.UnitTestData;

import org.junit.Test;


public class FingerprintTest extends UnitTestData {

	@Test
	public void createFingerprintWithRawFields() {
		Fingerprint fingerprint = Fingerprint.createFingerprint("loginID",
				"transactionKey", 1, "1.99");

		Assert.assertNotNull(fingerprint);
		Assert.assertNotNull(fingerprint.getFingerprintHash());
		Assert.assertEquals(32, fingerprint.getFingerprintHash().length());
		Assert.assertTrue(fingerprint.getSequence() >= 0);
		Assert.assertTrue(fingerprint.getTimeStamp() > 0);
	}

	@Test
	public void createFingerprintWithObjectFields() {
		Fingerprint fingerprint = Fingerprint.createFingerprint(merchant, 1,
				new BigDecimal(1.99));

		Assert.assertNotNull(fingerprint);
		Assert.assertNotNull(fingerprint.getFingerprintHash());
		Assert.assertEquals(32, fingerprint.getFingerprintHash().length());
		Assert.assertTrue(fingerprint.getSequence() >= 0);
		Assert.assertTrue(fingerprint.getTimeStamp() > 0);
	}

	@Test
	public void testMD5HashVerification() {
		String x_MD5_Hash = "CCF694F4A97B54462CE6329BEF6B0901";
		String amount = "2.18";
		String txnId = "2154896102";
		String md5Check = null;

		try {
		    MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
		    String s = merchantMD5Key + merchant.getLogin() + txnId + amount;
		    digest.update(s.getBytes());
		    md5Check = new BigInteger(1,digest.digest()).toString(16).toUpperCase();
		} catch (Exception e) {

		}
	    Assert.assertNotNull(md5Check);
		Assert.assertEquals(md5Check, x_MD5_Hash);
	}
}

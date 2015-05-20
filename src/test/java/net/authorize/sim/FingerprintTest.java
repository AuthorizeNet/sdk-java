package net.authorize.sim;

import java.math.BigDecimal;

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
	public void createFingerprintWithCurrency() {
		Fingerprint fingerprint = Fingerprint.createFingerprint("loginID",
				"transactionKey", 1, "1.99", "EUR");

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
}

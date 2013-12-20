/**
 *
 */
package net.authorize.data;


import junit.framework.Assert;

import net.authorize.UnitTestData;
import net.authorize.data.EmailReceipt;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class EmailReceiptTest extends UnitTestData {

	private EmailReceipt emailReceipt;

	@Before
	public void setUp() {
		emailReceipt = EmailReceipt.createEmailReceipt();
	}

	@Test
	public void createEmailReceipt() {
		Assert.assertNotNull(emailReceipt);
	}

	@Test
	public void checkEmailReceiptFields() {
		Assert.assertFalse(emailReceipt.isEmailCustomer());

		emailReceipt.setEmail(email);
		emailReceipt.setEmailCustomer(true);
		emailReceipt.setFooterEmailReceipt(footerEmailReceipt);
		emailReceipt.setHeaderEmailReceipt(headerEmailReceipt);
		emailReceipt.setMerchantEmail(merchantEmail);

		Assert.assertEquals(email, emailReceipt.getEmail());
		Assert.assertTrue(emailReceipt.isEmailCustomer());
		Assert.assertEquals(footerEmailReceipt, emailReceipt.getFooterEmailReceipt());
		Assert.assertEquals(headerEmailReceipt, emailReceipt.getHeaderEmailReceipt());
		Assert.assertEquals(merchantEmail, emailReceipt.getMerchantEmail());
	}
}

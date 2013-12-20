package net.authorize;

import junit.framework.Assert;

import org.junit.Test;


public class MerchantTest extends UnitTestData {

	@Test
	public void createMerchant() {
		Assert.assertNotNull(merchant);
	}

	@Test
	public void setMerchantPartialAuth() {
		Assert.assertFalse(merchant.isAllowPartialAuth());
		merchant.setAllowPartialAuth(true);
		Assert.assertTrue(merchant.isAllowPartialAuth());
	}

}

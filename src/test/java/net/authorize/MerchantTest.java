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
		boolean currentValue = merchant.isAllowPartialAuth();
		merchant.setAllowPartialAuth(!currentValue);
		Assert.assertTrue(merchant.isAllowPartialAuth()!=currentValue);
	}

}

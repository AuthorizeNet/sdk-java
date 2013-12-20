package net.authorize.data.echeck;


import junit.framework.Assert;
import net.authorize.UnitTestData;
import net.authorize.data.echeck.ECheck;

import org.junit.Before;
import org.junit.Test;

public class ECheckTest extends UnitTestData {

	private ECheck eCheck;

	@Before
	public void setUp() throws Exception {
		this.eCheck = ECheck.createECheck();
	}

	@Test
	public void createECheck() {
		Assert.assertNotNull(this.eCheck);
	}

	@Test
	public void checkECheckFields() {
		this.eCheck.setBankAccountName(bankAccountName);
		this.eCheck.setBankAccountNumber(bankAccountNumber);
		this.eCheck.setBankAccountType(bankAccountType);
		this.eCheck.setBankCheckNumber(bankCheckNumber);
		this.eCheck.setBankName(bankName);
		this.eCheck.setECheckType(eCheckType);
		this.eCheck.setRoutingNumber(routingNumber);

		Assert.assertEquals(bankAccountName, this.eCheck.getBankAccountName());
		Assert.assertEquals(bankAccountNumber, this.eCheck.getBankAccountNumber());
		Assert.assertEquals(bankAccountType, this.eCheck.getBankAccountType());
		Assert.assertEquals(bankCheckNumber, this.eCheck.getBankCheckNumber());
		Assert.assertEquals(bankName, this.eCheck.getBankName());
		Assert.assertEquals(eCheckType, this.eCheck.getECheckType());
		Assert.assertEquals(routingNumber, this.eCheck.getRoutingNumber());
	}


}

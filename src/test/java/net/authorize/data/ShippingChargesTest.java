package net.authorize.data;

import junit.framework.Assert;
import net.authorize.UnitTestData;
import net.authorize.data.ShippingCharges;

import org.junit.Before;
import org.junit.Test;

public class ShippingChargesTest extends UnitTestData {

	private ShippingCharges shippingCharges;

	@Before
	public void setUp() throws Exception {
		this.shippingCharges = ShippingCharges.createShippingCharges();
	}

	@Test
	public void createShippingCharges() {
		Assert.assertNotNull(this.shippingCharges);
	}

	@Test
	public void checkShippingChargesFields() {
		this.shippingCharges.setDutyAmount(dutyAmount);
		this.shippingCharges.setDutyItemDescription(dutyItemDescription);
		this.shippingCharges.setDutyItemName(dutyItemName);
		this.shippingCharges.setFreightAmount(freightAmount);
		this.shippingCharges.setFreightDescription(freightDescription);
		this.shippingCharges.setFreightItemName(freightItemName);
		this.shippingCharges.setPurchaseOrderNumber(purchaseOrderNumber);
		this.shippingCharges.setTaxAmount(taxAmount);
		this.shippingCharges.setTaxDescription(taxDescription);
		this.shippingCharges.setTaxExempt(taxExempt);
		this.shippingCharges.setTaxItemName(taxItemName);

		Assert.assertEquals(dutyAmount, this.shippingCharges.getDutyAmount());
		Assert.assertEquals(dutyItemDescription, this.shippingCharges.getDutyItemDescription());
		Assert.assertEquals(dutyItemName, this.shippingCharges.getDutyItemName());
		Assert.assertEquals(freightAmount, this.shippingCharges.getFreightAmount());
		Assert.assertEquals(freightDescription, this.shippingCharges.getFreightDescription());
		Assert.assertEquals(freightItemName, this.shippingCharges.getFreightItemName());
		Assert.assertEquals(purchaseOrderNumber, this.shippingCharges.getPurchaseOrderNumber());
		Assert.assertEquals(taxAmount, this.shippingCharges.getTaxAmount());
		Assert.assertEquals(taxDescription, this.shippingCharges.getTaxDescription());
		Assert.assertEquals(taxExempt, this.shippingCharges.isTaxExempt());
		Assert.assertEquals(taxItemName, this.shippingCharges.getTaxItemName());
	}


}

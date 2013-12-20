package net.authorize.data;


import junit.framework.Assert;
import net.authorize.UnitTestData;
import net.authorize.data.OrderItem;

import org.junit.Before;
import org.junit.Test;

public class OrderItemTest extends UnitTestData {

	private OrderItem orderItem;

	@Before
	public void setUp() {
		this.orderItem = OrderItem.createOrderItem();
	}

	@Test
	public void createOrderItem() {
		Assert.assertNotNull(this.orderItem);
	}

	@Test
	public void checkOrderItemFields() {
		Assert.assertFalse(this.orderItem.isItemTaxable());

		this.orderItem.setItemDescription(itemDescription);
		this.orderItem.setItemId(itemId);
		this.orderItem.setItemName(itemName);
		this.orderItem.setItemPrice(itemPrice);
		this.orderItem.setItemQuantity(itemQuantity);
		this.orderItem.setItemTaxable(true);

		Assert.assertEquals(itemDescription, this.orderItem.getItemDescription());
		Assert.assertEquals(itemId, this.orderItem.getItemId());
		Assert.assertEquals(itemName, this.orderItem.getItemName());
		Assert.assertEquals(itemPrice, this.orderItem.getItemPrice());
		Assert.assertEquals(itemQuantity, this.orderItem.getItemQuantity());
		Assert.assertTrue(this.orderItem.isItemTaxable());
	}

}

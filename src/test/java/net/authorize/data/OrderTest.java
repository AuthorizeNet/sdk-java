package net.authorize.data;


import junit.framework.Assert;
import net.authorize.UnitTestData;
import net.authorize.data.Order;
import net.authorize.data.OrderItem;

import org.junit.Before;
import org.junit.Test;

public class OrderTest extends UnitTestData {

	private Order order;

	@Before
	public void setUp() {
		this.order = Order.createOrder();
	}

	@Test
	public void createOrder() {
		Assert.assertNotNull(this.order);
	}

	@Test
	public void checkOrderFields() {
		this.order.setDescription(orderDescription);
		this.order.setInvoiceNumber(invoiceNumber);
		this.order.addOrderItem(OrderItem.createOrderItem());
		this.order.addOrderItem(OrderItem.createOrderItem());

		Assert.assertEquals(orderDescription, this.order.getDescription());
		Assert.assertEquals(invoiceNumber, this.order.getInvoiceNumber());
		Assert.assertEquals(2, this.order.getOrderItems().size());
	}

}

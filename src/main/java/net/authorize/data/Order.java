package net.authorize.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * General order related information.
 *
 */
public class Order implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static Log logger = LogFactory.getLog(Order.class);

	public static final int MAX_INVOICE_NUMBER_LENGTH = 20;
	public static final int MAX_DESCRIPTION_LENGTH = 255;
	public static final int MAX_ORDER_ITEM_SIZE = 30;

	protected String invoiceNumber;
	protected String purchaseOrderNumber;
	protected String description;
	protected BigDecimal totalAmount = new BigDecimal(0.00);
	protected ShippingCharges shippingCharges;

	protected List<OrderItem> orderItems = new ArrayList<OrderItem>();

	protected Order() { }

	public static Order createOrder() {

		return new Order();
	}

	/**
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * @param invoiceNumber the invoiceNumber to set
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Return the total amount of the order.
	 *
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Set the total amount of the order.
	 *
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * Sets the list of OrderItems to the list being passed in.  The list will
	 * be truncated to 30 items, which is the max number of OrderItems allowed.
	 *
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		synchronized(this) {
			int itemListMax = orderItems.size()>MAX_ORDER_ITEM_SIZE?MAX_ORDER_ITEM_SIZE:orderItems.size();
			try {
				this.orderItems = new ArrayList<OrderItem>(orderItems.subList(0, itemListMax));
			} catch (Exception e) {
				logger.warn("Failed setting orderItems.", e);
			}
		}
	}

	/**
	 * Adds an OrderItem to the list of OrderItems - provided the list of items
	 * isn't already at the max of 30.
	 *
	 * @param orderItem
	 */
	public void addOrderItem(OrderItem orderItem) {
		synchronized(this) {
			if(this.orderItems.size() < MAX_ORDER_ITEM_SIZE) {
				this.orderItems.add(orderItem);
			}
		}
	}

	/**
	 * Get the shipping charges associated with this order.
	 *
	 * @return the shippingCharges
	 */
	public ShippingCharges getShippingCharges() {
		return shippingCharges;
	}

	/**
	 * Set the shipping charges assocaited with this order.
	 *
	 * @param shippingCharges the shippingCharges to set
	 */
	public void setShippingCharges(ShippingCharges shippingCharges) {
		this.shippingCharges = shippingCharges;
	}

	/**
	 * @return the purchaseOrderNumber
	 */
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	/**
	 * @param purchaseOrderNumber the purchaseOrderNumber to set
	 */
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}


}

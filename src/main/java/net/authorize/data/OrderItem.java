package net.authorize.data;

import java.io.Serializable;
import java.math.BigDecimal;

import net.authorize.aim.Transaction;
import net.authorize.util.StringUtils;

/**
 * Itemized order information.
 *
 */
public class OrderItem implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final int MAX_ITEM_ID_LENGTH = 31;
	public static final int MAX_ITEM_NAME_LENGTH = 31;
	public static final int MAX_ITEM_DESCRIPTION_LENGTH = 255;

	protected String itemId;
	protected String itemName;
	protected String itemDescription;
	protected BigDecimal itemQuantity = new BigDecimal(0.00);
	protected BigDecimal itemPrice = new BigDecimal(0.00);
	protected boolean itemTaxable = false;

	protected OrderItem() { }

	public static OrderItem createOrderItem() {
		OrderItem orderItem = new OrderItem();

		return orderItem;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * @param itemDescription the itemDescription to set
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	 * @return the itemQuantity
	 */
	public BigDecimal getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(BigDecimal itemQuantity) {
		this.itemQuantity = itemQuantity;
		if(this.itemQuantity != null) {
			this.itemQuantity.setScale(Transaction.QUANTITY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(String itemQuantity) {
		if(StringUtils.isNotEmpty(itemQuantity)) {
			this.itemQuantity = new BigDecimal(itemQuantity).setScale(Transaction.QUANTITY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the itemPrice
	 */
	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(String itemPrice) {
		if(StringUtils.isNotEmpty(itemPrice)) {
			this.itemPrice = new BigDecimal(itemPrice).setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the itemTaxable
	 */
	public boolean isItemTaxable() {
		return itemTaxable;
	}

	/**
	 * @param itemTaxable the itemTaxable to set
	 */
	public void setItemTaxable(boolean itemTaxable) {
		this.itemTaxable = itemTaxable;
	}

	/**
	 * @param itemTaxable the itemTaxable to set
	 */
	public void setItemTaxable(String itemTaxable) {
		if(StringUtils.isNotEmpty(itemTaxable)) {
			this.itemTaxable = Boolean.valueOf(itemTaxable);
		}
	}

}

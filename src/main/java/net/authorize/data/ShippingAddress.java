package net.authorize.data;

import java.io.Serializable;

/**
 * Product shipping address.
 */
public class ShippingAddress extends Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private ShippingAddress() {
		super();
	}

	public static ShippingAddress createShippingAddress() {
		return new ShippingAddress();
	}

}

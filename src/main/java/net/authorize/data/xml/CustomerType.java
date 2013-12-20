package net.authorize.data.xml;


public enum CustomerType {
	INDIVIDUAL,
	BUSINESS;

	/**
	 * Lookup a CustomerType by it's name.
	 *
	 * @param name
	 *
	 * @return Returns a CustomerType if the name match is found.
	 */
	public static CustomerType findByName(String name) {
		for(CustomerType customerType : values()) {
			if(customerType.name().equalsIgnoreCase(name)) {
				return customerType;
			}
		}

		return null;
	}
}

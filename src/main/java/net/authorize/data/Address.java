package net.authorize.data;

public class Address {

	public static final int MAX_FIRST_NAME_LENGTH = 50;
	public static final int MAX_LAST_NAME_LENGTH = 50;
	public static final int MAX_COMPANY_LENGTH = 50;
	public static final int MAX_ADDRESS_LENGTH = 60;
	public static final int MAX_CITY_LENGTH = 40;
	public static final int MAX_STATE_LENGTH = 40;
	public static final int MAX_ZIP_LENGTH = 20;
	public static final int MAX_COUNTRY_LENGTH = 60;

	protected String firstName;
	protected String lastName;
	protected String company;
	protected String address;
	protected String city;
	protected String state;
	protected String zipPostalCode;
	protected String country;

	protected Address() {
	}

	public static Address createAddress() {
		return new Address();
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipPostalCode
	 */
	public String getZipPostalCode() {
		return zipPostalCode;
	}

	/**
	 * @param zipPostalCode
	 *            the zip / postal code to set
	 */
	public void setZipPostalCode(String zipPostalCode) {
		this.zipPostalCode = zipPostalCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}

package net.authorize.data;

import java.io.Serializable;

/**
 * Customer specific information.
 *
 */
public class Customer implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final int MAX_FIRST_NAME_LENGTH = 50;
	public static final int MAX_LAST_NAME_LENGTH = 50;
	public static final int MAX_COMPANY_LENGTH = 50;
	public static final int MAX_ADDRES_LENGTH = 60;
	public static final int MAX_CITY_LENGTH = 40;
	public static final int MAX_STATE_LENGTH = 40;
	public static final int MAX_ZIP_LENGTH = 20;
	public static final int MAX_COUNTRY_LENGTH = 60;
	public static final int MAX_FAX_LENGTH = 25;
	public static final int MAX_EMAIL_LENGTH = 255;
	public static final int MAX_CUSTOMER_ID_LENGTH = 20;
	public static final int MAX_CUSTOMER_IP_LENGTH = 15;

	private String firstName;
	private String lastName;
	private String company;
	private String address;
	private String city;
	private String state;
	private String zipPostalCode;
	private String country;
	private String phone;
	private String fax;
	private String email;
	private String customerId;
	private String customerIP;

	private Customer() { }

	public static Customer createCustomer() {
		return new Customer();
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
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
	 * @param company the company to set
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
	 * @param address the address to set
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
	 * @param city the city to set
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
	 * @param state the state to set
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
	 * @param zipPostalCode the zipPostalCode to set
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
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerIP
	 */
	public String getCustomerIP() {
		return customerIP;
	}

	/**
	 * @param customerIP the customerIP to set
	 */
	public void setCustomerIP(String customerIP) {
		this.customerIP = customerIP;
	}


}

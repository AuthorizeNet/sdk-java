package net.authorize.data.arb;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
*
* @deprecated since version 1.9.8
* @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
* @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API (package: net.authorize.api.*).
* @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
* @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/PaymentTransactions.
* @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
*
*/
@Deprecated
@XmlRootElement
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String customerProfileId;
    protected String customerPaymentProfileId;
    protected String customerAddressId;

    private Profile() { }

    /**
     * Create a new CustomerProfile object
     *
     * @return Profile
     */
    public static Profile createProfile() {
    	return new Profile();
    }

	/**
     * Get the customer profile id.
     *
	 * @return the id
	 */
	public String getCustomerProfileId() {
		return customerProfileId;
	}

	/**
	 * Set the customer profile id.
	 *
	 * @param id the id to set
	 */
	public void setCustomerProfileId(String id) {
		this.customerProfileId = id;
	}

	/**
	 * Get the customer payment profile id.
	 *
	 * @return the id
	 */
	public String getCustomerPaymentProfileId() {
		return customerPaymentProfileId;
	}

	/**
	 * Set the customer payment profile id.
	 *
	 * @param id the id to set
	 */
	public void setCustomerPaymentProfileId(String id) {
		this.customerPaymentProfileId = id;
	}

	/**
	 * Get the customer payment profile id.
	 *
	 * @return the id
	 */
	public String getCustomerAddressId() {
		return customerAddressId;
	}

	/**
	 * Set the customer payment profile id.
	 *
	 * @param id the id to set
	 */
	public void setCustomerAddressId(String id) {
		this.customerAddressId = id;
	}
}
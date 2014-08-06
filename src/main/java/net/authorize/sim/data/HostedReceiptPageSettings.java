package net.authorize.sim.data;

import net.authorize.sim.LinkMethod;

/**
 * The hosted receipt page provides the customer with the status of their transaction and can include a
 * link back to the merchant's website. It can be customized to reflect the look and feel of the
 * merchant's website.
 *
 */
public class HostedReceiptPageSettings {
	private LinkMethod linkMethod;
	private String linkText;
	private String linkUrl;

	private HostedReceiptPageSettings() { }

	/**
	 * Creates an instance of a HostedReceiptPageSettings class.
	 *
	 * @return a HostedReceiptPageSettings object.
	 */
	public static HostedReceiptPageSettings createHostedReceiptPageSettings() {
		return new HostedReceiptPageSettings();
	}

	/**
	 * @return the linkMethod
	 */
	public LinkMethod getLinkMethod() {
		return linkMethod;
	}

	/**
	 * @param linkMethod the linkMethod to set
	 */
	public void setLinkMethod(LinkMethod linkMethod) {
		this.linkMethod = linkMethod;
	}

	/**
	 * @return the linkText
	 */
	public String getLinkText() {
		return linkText;
	}

	/**
	 * @param linkText the linkText to set
	 */
	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	/**
	 * @return the linkUrl
	 */
	public String getLinkUrl() {
		return linkUrl;
	}

	/**
	 * @param linkUrl the linkUrl to set
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

}

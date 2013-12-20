package net.authorize.sim;

/**
 * The type of link back to the merchant's website.
 *
 * LINK creates a regular hyperlink.
 * GET creates a button and returns transaction information in the receipt link URL.
 * POST creates a button and returns transaction information as an HTML Form POST.
 *
 */
public enum LinkMethod {
	LINK,
	POST,
	GET
}

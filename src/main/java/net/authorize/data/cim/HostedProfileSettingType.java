package net.authorize.data.cim;

/**
 *	Enumeration of CIM hosted profile setting types that are supported by Authorize.Net
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
public enum HostedProfileSettingType {
	HOSTED_PROFILE_RETURN_URL("hostedProfileReturnUrl"),
	HOSTED_PROFILE_RETURN_URL_TEXT("hostedProfileReturnUrlText"),
	HOSTED_PROFILE_HEADING_BG_COLOR("hostedProfileHeadingBgColor"),
	HOSTED_PROFILE_PAGE_BORDER_VISIBLE("hostedProfilePageBorderVisible"),
	HOSTED_PROFILE_IFRAME_COMMUNICATOR_URL("hostedProfileIFrameCommunicatorUrl"),
	HOSTED_PROFILE_VALIDATION_MODE("hostedProfileValidationMode");

	final private String value;

	private HostedProfileSettingType(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}

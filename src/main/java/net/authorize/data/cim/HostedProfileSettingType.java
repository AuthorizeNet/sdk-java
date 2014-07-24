package net.authorize.data.cim;

/**
 *	Enumeration of CIM hosted profile setting types that are supported by Authorize.Net
 */
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

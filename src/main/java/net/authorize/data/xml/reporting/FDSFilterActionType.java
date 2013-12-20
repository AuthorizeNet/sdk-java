package net.authorize.data.xml.reporting;

/**
 * The action taken for a transaction that triggered one or more of the
 * Advanced Fraud Detection Suite filters.
 */
public enum FDSFilterActionType {
	REJECT("reject"),
	DECLINE("decline"),
	HOLD("hold"),
	AUTH_AND_HOLD("authAndHold"),
	REPORT("report");

	private final String value;

	private FDSFilterActionType(String value) {
		this.value = value;
	}

	public static FDSFilterActionType findByValue(String value) {
		if(value != null) {
			for(FDSFilterActionType filterAction : values()) {
				if(filterAction.value.equals(value)) {
					return filterAction;
				}
			}
		}

		return null;
	}

}

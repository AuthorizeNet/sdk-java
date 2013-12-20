package net.authorize.data.arb;

public enum SubscriptionStatusType {

	ACTIVE("active"),
	EXPIRED("expired"),
	SUSPENDED("suspended"),
	CANCELED("canceled"),
	TERMINATED("terminated");

    private final String value;

	SubscriptionStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SubscriptionStatusType fromValue(String v) {
        for (SubscriptionStatusType c: SubscriptionStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

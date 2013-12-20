package net.authorize.data.arb;

public enum SubscriptionUnitType {
    DAYS("days"),
    MONTHS("months");

    private final String value;

    SubscriptionUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SubscriptionUnitType fromValue(String v) {
        for (SubscriptionUnitType c: SubscriptionUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

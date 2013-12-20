package net.authorize;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * ResponseField mappings used in processing and matching the returned data from
 * the payment gateway.
 *
 * This enum is leveraged across all the integrations of
 * AIM,SIM,DPM,ARB and CIM.
 *
 */
public enum ResponseField {
	RESPONSE_CODE(AuthNetField.X_RESPONSE_CODE.getFieldName()),
	RESPONSE_SUBCODE(null),
	RESPONSE_REASON_CODE(AuthNetField.X_RESPONSE_REASON_CODE.getFieldName()),
	RESPONSE_REASON_TEXT(AuthNetField.X_RESPONSE_REASON_TEXT.getFieldName()),
	AUTHORIZATION_CODE(AuthNetField.X_AUTH_CODE.getFieldName()),
	AVS_CODE(AuthNetField.X_AVS_CODE.getFieldName()),
	TRANSACTION_ID(AuthNetField.X_TRANS_ID.getFieldName()),
	INVOICE_NUMBER(AuthNetField.X_INVOICE_NUM.getFieldName()),
	DESCRIPTION(AuthNetField.X_DESCRIPTION.getFieldName()),
	AMOUNT(AuthNetField.X_AMOUNT.getFieldName()),
	METHOD(AuthNetField.X_METHOD.getFieldName()),
	TRANSACTION_TYPE(AuthNetField.X_TYPE.getFieldName()),
	CUSTOMER_ID(AuthNetField.X_CUST_ID.getFieldName()),
	FIRST_NAME(AuthNetField.X_FIRST_NAME.getFieldName()),
	LAST_NAME(AuthNetField.X_LAST_NAME.getFieldName()),
	COMPANY(AuthNetField.X_COMPANY.getFieldName()),
	ADDRESS(AuthNetField.X_ADDRESS.getFieldName()),
	CITY(AuthNetField.X_CITY.getFieldName()),
	STATE(AuthNetField.X_STATE.getFieldName()),
	ZIP_CODE(AuthNetField.X_ZIP.getFieldName()),
	COUNTRY(AuthNetField.X_COUNTRY.getFieldName()),
	PHONE(AuthNetField.X_PHONE.getFieldName()),
	FAX(AuthNetField.X_FAX.getFieldName()),
	EMAIL_ADDRESS(AuthNetField.X_EMAIL.getFieldName()),
	SHIP_TO_FIRST_NAME(AuthNetField.X_SHIP_TO_FIRST_NAME.getFieldName()),
	SHIP_TO_LAST_NAME(AuthNetField.X_SHIP_TO_LAST_NAME.getFieldName()),
	SHIP_TO_COMPANY(AuthNetField.X_SHIP_TO_COMPANY.getFieldName()),
	SHIP_TO_ADDRESS(AuthNetField.X_SHIP_TO_ADDRESS.getFieldName()),
	SHIP_TO_CITY(AuthNetField.X_SHIP_TO_CITY.getFieldName()),
	SHIP_TO_STATE(AuthNetField.X_SHIP_TO_STATE.getFieldName()),
	SHIP_TO_ZIP_CODE(AuthNetField.X_SHIP_TO_ZIP.getFieldName()),
	SHIP_TO_COUNTRY(AuthNetField.X_SHIP_TO_COUNTRY.getFieldName()),
	TAX(AuthNetField.X_TAX.getFieldName()),
	DUTY(AuthNetField.X_DUTY.getFieldName()),
	FREIGHT(AuthNetField.X_FREIGHT.getFieldName()),
	TAX_EXEMPT(AuthNetField.X_TAX_EXEMPT.getFieldName()),
	PURCHASE_ORDER_NUMBER(AuthNetField.X_PO_NUM.getFieldName()),
	MD5_HASH(AuthNetField.X_MD5_HASH.getFieldName()),
	CARD_CODE_RESPONSE(AuthNetField.X_CVV2_RESP_CODE.getFieldName()),
	CARDHOLDER_AUTHENTICATION_VERIFICATION_RESPONSE(AuthNetField.X_CAVV_RESPONSE.getFieldName()),
	RESERVED_1(null),
	RESERVED_2(null),
	RESERVED_3(null),
	RESERVED_4(null),
	RESERVED_5(null),
	RESERVED_6(null),
	RESERVED_7(null),
	RESERVED_8(null),
	RESERVED_9(null),
	RESERVED_10(null),
	ACCOUNT_NUMBER(AuthNetField.X_ACCOUNT_NUMBER.getFieldName()),
	CARD_TYPE(AuthNetField.X_CARD_TYPE.getFieldName()),
	SPLIT_TENDER_ID(AuthNetField.X_SPLIT_TENDER_ID.getFieldName()),
	PREPAID_REQUESTED_AMOUNT(AuthNetField.X_PREPAID_REQUESTED_AMOUNT.getFieldName()),
	PREPAID_BALANCE_ON_CARD(AuthNetField.X_PREPAID_BALANCE_ON_CARD.getFieldName()),
	RESERVED_11(null),
	RESERVED_12(null),
	RESERVED_13(null),
	RESERVED_14(null),
	RESERVED_15(null),
	RESERVED_16(null),
	RESERVED_17(null),
	RESERVED_18(null),
	RESERVED_19(null),
	RESERVED_20(null),
	RESERVED_21(null),
	RESERVED_22(null),
	RESERVED_23(null);

	private static final int MERCHANT_DEFINED_START_INDEX = 69;

	private int responseOrder;
	final private String fieldName;
	private static final Map<Integer,ResponseField> lookup =
		new HashMap<Integer,ResponseField>();

	static {
		for (ResponseField s : EnumSet.allOf(ResponseField.class))
			lookup.put(s.responseOrder, s);
	}

	private ResponseField(String fieldName) {
		if(fieldName == null) {
			this.fieldName = "x_" + this.name();
		} else {
			this.fieldName = fieldName;
		}
		this.responseOrder = this.ordinal()+1;
	}

	/**
	 * Get the true response order.
	 *
	 * @return Integer of the response order.
	 */
	public int getResponsOrder() { return this.responseOrder; }

	/**
	 * Get the ResponseField identified by the order specified.
	 *
	 * @param order
	 * @return the ResponseField keyed off the order
	 */
	public static ResponseField get(int order) {
		if(order < MERCHANT_DEFINED_START_INDEX) {
			return ResponseField.lookup.get(order);
		} else {
			return null;
		}
	}


	/**
	 * Lookup a ResponseField by it's field name.
	 *
	 * @param fieldName
	 *
	 * @return Returns a ResponseField if the fieldName match is found.
	 */
	public static ResponseField findByFieldName(String fieldName) {
		for(ResponseField responseField : values()) {
			if(responseField.fieldName.equals(fieldName)) {
				return responseField;
			}
		}

		return null;
	}

	/**
	 * @return the responseOrder
	 */
	public int getResponseOrder() {
		return responseOrder;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}


}

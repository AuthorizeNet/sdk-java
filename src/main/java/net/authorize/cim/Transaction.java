package net.authorize.cim;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.authorize.AuthNetField;
import net.authorize.Merchant;
import net.authorize.data.Order;
import net.authorize.data.OrderItem;
import net.authorize.data.ShippingCharges;
import net.authorize.data.cim.CustomerProfile;
import net.authorize.data.cim.PaymentProfile;
import net.authorize.data.cim.PaymentTransaction;
import net.authorize.data.creditcard.CreditCard;
import net.authorize.data.xml.Address;
import net.authorize.data.xml.BankAccount;
import net.authorize.data.xml.Payment;
import net.authorize.util.BasicXmlDocument;
import net.authorize.util.StringUtils;

import org.w3c.dom.Element;

/**
 * Transaction object for CIM.
 *
 */
public class Transaction extends net.authorize.Transaction {

	private static final long serialVersionUID = 1L;
	public static String XML_NAMESPACE = "AnetApi/xml/v1/schema/AnetApiSchema.xsd";

	private Merchant merchant;
	private TransactionType transactionType;

	private String refId = null;
	private CustomerProfile customerProfile = CustomerProfile.createCustomerProfile();
	private ArrayList<PaymentProfile> paymentProfileList = new ArrayList<PaymentProfile>();
	private PaymentTransaction paymentTransaction;
	protected Map<String, String> extraOptions = Collections.synchronizedMap(new HashMap<String, String>());

	private ValidationModeType validationMode = ValidationModeType.NONE;
	private BasicXmlDocument currentRequest = null;
	private BasicXmlDocument currentResponse = null;

	/**
	 * Private constructor.
	 *
	 * @param merchant
	 * @param transactionType
	 */
	private Transaction(Merchant merchant, TransactionType transactionType) {
		this.merchant = merchant;
		this.transactionType = transactionType;
	}

	/**
	 * Creates a transaction.
	 *
	 * @param merchant
	 * @param transactionType
	 *
	 * @return Transaction
	 */
	public static Transaction createTransaction(Merchant merchant, TransactionType transactionType) {
		return new Transaction(merchant, transactionType);
	}

	/**
	 * Create a transaction from a response.
	 *
	 * @param transaction
	 * @param response
	 * @return a Transaction
	 */
	public static final Transaction createTransaction(Transaction transaction, BasicXmlDocument response) {

		transaction.currentResponse = response;

		return transaction;
	}

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * Returns the current request.
	 *
	 * @return BasicXmlDocument containing the request
	 */
	public BasicXmlDocument getCurrentRequest(){
		return currentRequest;

	}

	/**
	 * Returns the current response.
	 *
	 * @return BasicXmlDocument containing the response
	 */
	public BasicXmlDocument getCurrentResponse(){
		return currentResponse;
	}

	/**
	 * Add authentication to the subscription request.
	 *
	 * @param document
	 */
	private void addAuthentication(BasicXmlDocument document){
		Element auth_el = document.createElement(AuthNetField.ELEMENT_MERCHANT_AUTHENTICATION.getFieldName());
		Element name_el = document.createElement(AuthNetField.ELEMENT_NAME.getFieldName());
		name_el.appendChild(document.getDocument().createTextNode(merchant.getLogin()));
		Element trans_key = document.createElement(AuthNetField.ELEMENT_TRANSACTION_KEY.getFieldName());
		trans_key.appendChild(document.getDocument().createTextNode(merchant.getTransactionKey()));
		auth_el.appendChild(name_el);
		auth_el.appendChild(trans_key);
		document.getDocumentElement().appendChild(auth_el);
	}

	/**
	 * Add the refId to the request.
	 *
	 * @param document
	 * @param subscription
	 */
	private void addRefId(BasicXmlDocument document) {
		if(refId != null) {
			Element ref_id_el = document.createElement(AuthNetField.ELEMENT_REFID.getFieldName());
			ref_id_el.appendChild(document.getDocument().createTextNode(refId));
			document.getDocumentElement().appendChild(ref_id_el);
		}
	}

	/**
	 * Add the customer profile id to the request.
	 *
	 * @param document
	 * @param subscription
	 */
	private void addCustomerProfileId(BasicXmlDocument document) {
		if(customerProfile != null && customerProfile.getCustomerProfileId() != null) {
			Element customer_profile_id_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_PROFILE_ID.getFieldName());
			customer_profile_id_el.appendChild(document.getDocument().createTextNode(customerProfile.getCustomerProfileId()));
			document.getDocumentElement().appendChild(customer_profile_id_el);
		}
	}

	/**
	 * Add the customer address id to the request.
	 *
	 * @param document
	 * @param subscription
	 */
	private void addCustomerAddressId(BasicXmlDocument document) {
		if(this.paymentTransaction.getCustomerShippingAddressId() != null) {
			Element customer_shipping_address_id_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_ADDRESS_ID.getFieldName());
			customer_shipping_address_id_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getCustomerShippingAddressId()));
			document.getDocumentElement().appendChild(customer_shipping_address_id_el);
		}
	}
	/**
	 * Add the customer shipping address id to the request.
	 *
	 * @param document
	 * @param subscription
	 */
	private void addCustomerShippingAddressId(BasicXmlDocument document) {
		if(this.paymentTransaction.getCustomerShippingAddressId() != null) {
			Element customer_shipping_address_id_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_SHIPPING_ADDRESS_ID.getFieldName());
			customer_shipping_address_id_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getCustomerShippingAddressId()));
			document.getDocumentElement().appendChild(customer_shipping_address_id_el);
		}
	}

	/**
	 * Add the customer payment profile id to the request.
	 *
	 * @param document
	 * @param subscription
	 */
	private void addCustomerPaymentProfileId(BasicXmlDocument document) {
		if(this.paymentTransaction.getCustomerPaymentProfileId() != null) {
			Element customer_payment_profile_id_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_PAYMENT_PROFILE_ID.getFieldName());
			customer_payment_profile_id_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getCustomerPaymentProfileId()));
			document.getDocumentElement().appendChild(customer_payment_profile_id_el);
		}
	}

	/**
	 * Add the card code to the request.
	 *
	 * @param document
	 * @param subscription
	 */
	private void addCardCode(BasicXmlDocument document) {
		if(paymentTransaction != null && !StringUtils.isEmpty(paymentTransaction.getCardCode())) {
			Element card_code_el = document.createElement(AuthNetField.ELEMENT_CARD_CODE.getFieldName());
			card_code_el.appendChild(document.getDocument().createTextNode(paymentTransaction.getCardCode()));
			document.getDocumentElement().appendChild(card_code_el);
		}
	}

	/**
	 * Add customer profile to the request.
	 *
	 * @param document
	 */
	private void addCustomerProfile(BasicXmlDocument document) {
		if(customerProfile != null) {

			Element profile_el = document.createElement(AuthNetField.ELEMENT_PROFILE.getFieldName());
			document.getDocumentElement().appendChild(profile_el);

			// merchantCustomerId
			Element merchant_customer_id_el = document.createElement(AuthNetField.ELEMENT_MERCHANT_CUSTOMER_ID.getFieldName());
			merchant_customer_id_el.appendChild(document.getDocument().createTextNode(this.customerProfile.getMerchantCustomerId()));
			profile_el.appendChild(merchant_customer_id_el);

			// description
			Element description_el = document.createElement(AuthNetField.ELEMENT_DESCRIPTION.getFieldName());
			description_el.appendChild(document.getDocument().createTextNode(this.customerProfile.getDescription()));
			profile_el.appendChild(description_el);
			// email
			Element email_el = document.createElement(AuthNetField.ELEMENT_EMAIL.getFieldName());
			email_el.appendChild(document.getDocument().createTextNode(this.customerProfile.getEmail()));
			profile_el.appendChild(email_el);

			// customerProfileId
			if(!StringUtils.isEmpty(this.customerProfile.getCustomerProfileId())) {
				Element customer_profile_id_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_PROFILE_ID.getFieldName());
				customer_profile_id_el.appendChild(document.getDocument().createTextNode(this.customerProfile.getCustomerProfileId()));
				profile_el.appendChild(customer_profile_id_el);
			}

			// add payment profiles
			addPaymentProfiles(document, profile_el);
			// add shipping address
			addAddress(document, AuthNetField.ELEMENT_SHIP_TO.getFieldName(), this.customerProfile.getShipToAddress(), document.getDocumentElement());
		}
	}

	/**
	 * Add payment profiles to the request profile.
	 *
	 * @param document
	 * @param paymentProfiles
	 * @param profile_el - if null handles the singular element case
	 */
	private void addPaymentProfiles(BasicXmlDocument document, Element profile_el) {
		if(this.paymentProfileList != null) {
			Element payment_profiles_el = null;
			// paymentProfile vs paymentProfiles
			if(profile_el == null && paymentProfileList.size() == 1) {
				payment_profiles_el = document.createElement(AuthNetField.ELEMENT_PAYMENT_PROFILE.getFieldName());
			} else {
				payment_profiles_el = document.createElement(AuthNetField.ELEMENT_PAYMENT_PROFILES.getFieldName());
			}

			for(PaymentProfile paymentProfile : this.paymentProfileList) {

				Element cutomer_type_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_TYPE.getFieldName());
				cutomer_type_el.appendChild(document.getDocument().createTextNode(paymentProfile.getCustomerType().name().toLowerCase()));
				payment_profiles_el.appendChild(cutomer_type_el);

				// billTo
				addAddress(document, AuthNetField.ELEMENT_BILL_TO.getFieldName(),
						paymentProfile.getBillTo(),  payment_profiles_el);
				// payment
				Payment payment = paymentProfile.getPaymentList() != null &&
					!paymentProfile.getPaymentList().isEmpty() ?
							paymentProfile.getPaymentList().get(0):null;

				addPayment(document, payment, payment_profiles_el);

				// add the payment profile id if avail
				if(!StringUtils.isEmpty(paymentProfile.getCustomerPaymentProfileId())) {
					Element customer_payment_profile_id_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_PAYMENT_PROFILE_ID.getFieldName());
					customer_payment_profile_id_el.appendChild(document.getDocument().createTextNode(paymentProfile.getCustomerPaymentProfileId()));
					payment_profiles_el.appendChild(customer_payment_profile_id_el);
				}

				// append to the doc properly
				if(profile_el != null) {
					profile_el.appendChild(payment_profiles_el);
				} else {
					document.getDocumentElement().appendChild(payment_profiles_el);
					break; 	// handle the paymentProfile singular case
				}
			}
		}
	}

	/**
	 * Add payment information to the payment profile.
	 *
	 * @param document
	 * @param payment
	 * @param parent_el
	 */
	private void addPayment(BasicXmlDocument document, Payment payment,
			Element parent_el) {

		if(payment == null) return;

		Element payment_el = document.createElement(AuthNetField.ELEMENT_PAYMENT.getFieldName());
		CreditCard credit_card= payment.getCreditCard();
		BankAccount bank_account = payment.getBankAccount();

		if (credit_card != null) {
			Element cc_el = document.createElement(AuthNetField.ELEMENT_CREDIT_CARD.getFieldName());

			Element cc_num_el = document.createElement(AuthNetField.ELEMENT_CREDIT_CARD_NUMBER.getFieldName());
			cc_num_el.appendChild(document.getDocument().createTextNode(credit_card.getCreditCardNumber()));
			cc_el.appendChild(cc_num_el);

			Element cc_exp_el = document.createElement(AuthNetField.ELEMENT_CREDIT_CARD_EXPIRY.getFieldName());
			cc_exp_el.appendChild(document.getDocument().createTextNode(net.authorize.util.DateUtil.getFormattedDate(credit_card.getExpirationDate(),
					CreditCard.ARB_EXPIRY_DATE_FORMAT)));
			cc_el.appendChild(cc_exp_el);

			payment_el.appendChild(cc_el);
		}
		else if (bank_account != null) {
			Element bankacct_el = document.createElement(AuthNetField.ELEMENT_BANK_ACCOUNT.getFieldName());

			if(bank_account.getBankAccountType() != null) {
				Element account_type_el = document.createElement(AuthNetField.ELEMENT_ACCOUNT_TYPE.getFieldName());
				account_type_el.appendChild(document.getDocument().createTextNode(bank_account.getBankAccountType().getValue().toLowerCase()));
				bankacct_el.appendChild(account_type_el);
			}

			Element routing_number_el = document.createElement(AuthNetField.ELEMENT_ROUTING_NUMBER.getFieldName());
			routing_number_el.appendChild(document.getDocument().createTextNode(bank_account.getRoutingNumber()));
			bankacct_el.appendChild(routing_number_el);

			Element acct_number_el = document.createElement(AuthNetField.ELEMENT_ACCOUNT_NUMBER.getFieldName());
			acct_number_el.appendChild(document.getDocument().createTextNode(bank_account.getBankAccountNumber()));
			bankacct_el.appendChild(acct_number_el);

			Element name_on_acct_el = document.createElement(AuthNetField.ELEMENT_NAME_ON_ACCOUNT.getFieldName());
			name_on_acct_el.appendChild(document.getDocument().createTextNode(bank_account.getBankAccountName()));
			bankacct_el.appendChild(name_on_acct_el);

			if(bank_account.getECheckType() != null) {
				Element echeck_type_el = document.createElement(AuthNetField.ELEMENT_ECHECK_TYPE.getFieldName());
				echeck_type_el.appendChild(document.getDocument().createTextNode(bank_account.getECheckType().getValue()));
				bankacct_el.appendChild(echeck_type_el);
			}

			Element bank_name_el = document.createElement(AuthNetField.ELEMENT_BANK_NAME.getFieldName());
			bank_name_el.appendChild(document.getDocument().createTextNode(bank_account.getBankName()));
			bankacct_el.appendChild(bank_name_el);

			payment_el.appendChild(bankacct_el);
		}

		parent_el.appendChild(payment_el);
	}

	/**
	 * Add address info (shipTo / billTo).
	 *
	 * @param document
	 * @param elementName
	 * @param address
	 * @param parent_el - can be null if adding directly to the document
	 */
	private void addAddress(BasicXmlDocument document, String elementName,
			Address address, Element parent_el) {

		if(address != null) {
			Element address_el = document.createElement(elementName);

			Element fname_el = document.createElement(AuthNetField.ELEMENT_FIRST_NAME.getFieldName());
			fname_el.appendChild(document.getDocument().createTextNode(address.getFirstName()));
			address_el.appendChild(fname_el);

			Element lname_el = document.createElement(AuthNetField.ELEMENT_LAST_NAME.getFieldName());
			lname_el.appendChild(document.getDocument().createTextNode(address.getLastName()));
			address_el.appendChild(lname_el);

			Element company_el = document.createElement(AuthNetField.ELEMENT_COMPANY.getFieldName());
			company_el.appendChild(document.getDocument().createTextNode(address.getCompany()));
			address_el.appendChild(company_el);

			Element address_line_el = document.createElement(AuthNetField.ELEMENT_ADDRESS.getFieldName());
			address_line_el.appendChild(document.getDocument().createTextNode(address.getAddress()));
			address_el.appendChild(address_line_el);

			Element city_el = document.createElement(AuthNetField.ELEMENT_CITY.getFieldName());
			city_el.appendChild(document.getDocument().createTextNode(address.getCity()));
			address_el.appendChild(city_el);

			Element state_el = document.createElement(AuthNetField.ELEMENT_STATE.getFieldName());
			state_el.appendChild(document.getDocument().createTextNode(address.getState()));
			address_el.appendChild(state_el);

			Element zip_el = document.createElement(AuthNetField.ELEMENT_ZIP.getFieldName());
			zip_el.appendChild(document.getDocument().createTextNode(address.getZipPostalCode()));
			address_el.appendChild(zip_el);

			Element country_el = document.createElement(AuthNetField.ELEMENT_COUNTRY.getFieldName());
			country_el.appendChild(document.getDocument().createTextNode(address.getCountry()));
			address_el.appendChild(country_el);

			Element phone_el = document.createElement(AuthNetField.ELEMENT_PHONE_NUMBER.getFieldName());
			phone_el.appendChild(document.getDocument().createTextNode(address.getPhoneNumber()));
			address_el.appendChild(phone_el);

			Element fax_el = document.createElement(AuthNetField.ELEMENT_FAX_NUMBER.getFieldName());
			fax_el.appendChild(document.getDocument().createTextNode(address.getFaxNumber()));
			address_el.appendChild(fax_el);

			if(!StringUtils.isEmpty(address.getAddressId())) {
				Element address_id_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_ADDRESS_ID.getFieldName());
				address_id_el.appendChild(document.getDocument().createTextNode(address.getAddressId()));
				address_el.appendChild(address_id_el);
			}

			parent_el.appendChild(address_el);
		}
	}

	/**
	 * Set the validation mode on the request.
	 *
	 * @param document
	 */
	private void addValidationMode(BasicXmlDocument document) {
		if(this.validationMode != null) {
			Element validation_mode_el = document.createElement(AuthNetField.ELEMENT_VALIDATION_MODE.getFieldName());
			validation_mode_el.appendChild(document.getDocument().createTextNode(this.validationMode.getValue()));
			document.getDocumentElement().appendChild(validation_mode_el);
		}
	}

	/**
	 * Adds transaction specific information to the request.
	 *
	 * @param document
	 */
	private void addPaymentTransaction(BasicXmlDocument document) {
		if(this.paymentTransaction != null) {
			boolean authOrCaptureTxn = (net.authorize.TransactionType.AUTH_ONLY.equals(this.paymentTransaction.getTransactionType()) ||
					net.authorize.TransactionType.AUTH_CAPTURE.equals(this.paymentTransaction.getTransactionType()) ||
							net.authorize.TransactionType.CAPTURE_ONLY.equals(this.paymentTransaction.getTransactionType()) );
//			boolean creditTxn = (net.authorize.TransactionType.CREDIT.equals(this.paymentTransaction.getTransactionType()) ||
//					net.authorize.TransactionType.UNLINKED_CREDIT.equals(this.paymentTransaction.getTransactionType()) ||
//							net.authorize.TransactionType.VOID.equals(this.paymentTransaction.getTransactionType()) );

			Element transaction_el = document.createElement(AuthNetField.ELEMENT_TRANSACTION.getFieldName());

			Element profile_trans_x_el = document.createElement(
					this.paymentTransaction.getTransactionType().getCIMValue());

			Order order = this.paymentTransaction.getOrder();
			ShippingCharges shippingCharges = null;

			// amount
			if(order != null && order.getTotalAmount() != null) {
				shippingCharges = order.getShippingCharges();
				Element amount_el = document.createElement(AuthNetField.ELEMENT_AMOUNT.getFieldName());
				amount_el.appendChild(document.getDocument().createTextNode(
						order.getTotalAmount().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString()));
				profile_trans_x_el.appendChild(amount_el);
				if(shippingCharges != null) {

					// tax
					Element tax_el = document.createElement(AuthNetField.ELEMENT_TAX.getFieldName());
					Element tax_amount_el = document.createElement(AuthNetField.ELEMENT_AMOUNT.getFieldName());
					Element tax_name_el = document.createElement(AuthNetField.ELEMENT_NAME.getFieldName());
					Element tax_description_el = document.createElement(AuthNetField.ELEMENT_DESCRIPTION.getFieldName());
					if(shippingCharges.getTaxAmount() != null) {
						tax_amount_el.appendChild(document.getDocument().createTextNode(
								shippingCharges.getTaxAmount().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString()));
					}
					if(shippingCharges.getTaxItemName() != null) {
						tax_name_el.appendChild(document.getDocument().createTextNode(
								shippingCharges.getTaxItemName()));
					}
					if(shippingCharges.getTaxDescription() != null) {
						tax_description_el.appendChild(document.getDocument().createTextNode(
								shippingCharges.getTaxDescription()));
					}
					tax_el.appendChild(tax_amount_el);
					tax_el.appendChild(tax_name_el);
					tax_el.appendChild(tax_description_el);
					profile_trans_x_el.appendChild(tax_el);

					// shipping
					Element shipping_el = document.createElement(AuthNetField.ELEMENT_SHIPPING.getFieldName());
					Element shipping_amount_el = document.createElement(AuthNetField.ELEMENT_AMOUNT.getFieldName());
					Element shipping_name_el = document.createElement(AuthNetField.ELEMENT_NAME.getFieldName());
					Element shipping_description_el = document.createElement(AuthNetField.ELEMENT_DESCRIPTION.getFieldName());
					if(shippingCharges.getFreightAmount() != null) {
						shipping_amount_el.appendChild(document.getDocument().createTextNode(
								shippingCharges.getFreightAmount().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString()));
					}
					if(shippingCharges.getFreightItemName() != null) {
						shipping_name_el.appendChild(document.getDocument().createTextNode(
								shippingCharges.getFreightItemName()));
					}
					if(shippingCharges.getFreightDescription() != null) {
						shipping_description_el.appendChild(document.getDocument().createTextNode(
								shippingCharges.getFreightDescription()));
					}
					shipping_el.appendChild(shipping_amount_el);
					shipping_el.appendChild(shipping_name_el);
					shipping_el.appendChild(shipping_description_el);
					profile_trans_x_el.appendChild(shipping_el);

					// line items
					for(OrderItem orderItem : order.getOrderItems()) {
						Element line_item_el = document.createElement(AuthNetField.ELEMENT_LINE_ITEMS.getFieldName());

						Element item_id_el = document.createElement(AuthNetField.ELEMENT_ITEM_ID.getFieldName());
						item_id_el.appendChild(document.getDocument().createTextNode(orderItem.getItemId()));

						Element name_el = document.createElement(AuthNetField.ELEMENT_NAME.getFieldName());
						name_el.appendChild(document.getDocument().createTextNode(orderItem.getItemName()));

						Element description_el = document.createElement(AuthNetField.ELEMENT_DESCRIPTION.getFieldName());
						description_el.appendChild(document.getDocument().createTextNode(orderItem.getItemDescription()));

						Element quantity_el = document.createElement(AuthNetField.ELEMENT_QUANTITY.getFieldName());
						quantity_el.appendChild(document.getDocument().createTextNode(orderItem.getItemQuantity().toBigInteger().toString()));

						Element unit_price_el = document.createElement(AuthNetField.ELEMENT_UNIT_PRICE.getFieldName());
						unit_price_el.appendChild(document.getDocument().createTextNode(
								orderItem.getItemPrice().setScale(Transaction.CURRENCY_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toPlainString()));

						Element taxable_el = document.createElement(AuthNetField.ELEMENT_TAXABLE.getFieldName());
						taxable_el.appendChild(document.getDocument().createTextNode(orderItem.isItemTaxable()?TRUE.toLowerCase():FALSE.toLowerCase()));

						line_item_el.appendChild(item_id_el);
						line_item_el.appendChild(name_el);
						line_item_el.appendChild(description_el);
						line_item_el.appendChild(quantity_el);
						line_item_el.appendChild(unit_price_el);
						line_item_el.appendChild(taxable_el);

						profile_trans_x_el.appendChild(line_item_el);
					}
				}
			}

			// customer profile id
			if(customerProfile != null && !StringUtils.isEmpty(customerProfile.getCustomerProfileId())) {
				Element customer_profile_id_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_PROFILE_ID.getFieldName());
				customer_profile_id_el.appendChild(document.getDocument().createTextNode(customerProfile.getCustomerProfileId()));
				profile_trans_x_el.appendChild(customer_profile_id_el);
			}

			// customer payment profile id
			if(!StringUtils.isEmpty(this.paymentTransaction.getCustomerPaymentProfileId())) {
				Element customer_payment_profile_id_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_PAYMENT_PROFILE_ID.getFieldName());
				customer_payment_profile_id_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getCustomerPaymentProfileId()));
				profile_trans_x_el.appendChild(customer_payment_profile_id_el);
			}

			// customer shipping address id
			if(!StringUtils.isEmpty(this.paymentTransaction.getCustomerShippingAddressId())) {
				Element customer_shipping_address_id_el = document.createElement(AuthNetField.ELEMENT_CUSTOMER_SHIPPING_ADDRESS_ID.getFieldName());
				customer_shipping_address_id_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getCustomerShippingAddressId()));
				profile_trans_x_el.appendChild(customer_shipping_address_id_el);
			}

			// creditCardNumberMasked
			if(!StringUtils.isEmpty(this.paymentTransaction.getCreditCardNumberMasked())) {
				Element credit_card_num_mask_el = document.createElement(AuthNetField.ELEMENT_CREDIT_CARD_NUMBER_MASKED.getFieldName());
				credit_card_num_mask_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getCreditCardNumberMasked()));
				profile_trans_x_el.appendChild(credit_card_num_mask_el);
			}
			// bankRoutingNumberMasked
			// bankAccountNumberMasked
			else if (!StringUtils.isEmpty(this.paymentTransaction.getBankAccountNumberMasked())) {
				Element bank_routing_num_mask_el = document.createElement(AuthNetField.ELEMENT_BANK_ROUTING_NUMBER_MASKED.getFieldName());
				bank_routing_num_mask_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getBankRoutingNumberMasked()));
				profile_trans_x_el.appendChild(bank_routing_num_mask_el);

				Element bank_acct_num_mask_el = document.createElement(AuthNetField.ELEMENT_BANK_ACCOUNT_NUMBER_MASKED.getFieldName());
				bank_acct_num_mask_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getBankAccountNumberMasked()));
				profile_trans_x_el.appendChild(bank_acct_num_mask_el);
			}

			// check for prior auth/capture which is unique
			if( !net.authorize.TransactionType.PRIOR_AUTH_CAPTURE.equals(this.paymentTransaction.getTransactionType())) {
				
				if(order != null) {
					Element order_el = document.createElement(AuthNetField.ELEMENT_ORDER.getFieldName());
					Element invoice_number_el = document.createElement(AuthNetField.ELEMENT_INVOICE_NUMBER.getFieldName());
					Element description_el = document.createElement(AuthNetField.ELEMENT_DESCRIPTION.getFieldName());
					Element purchase_order_number_el = document.createElement(AuthNetField.ELEMENT_PURCHASE_ORDER_NUMBER.getFieldName());
					invoice_number_el.appendChild(document.getDocument().createTextNode(order.getInvoiceNumber()));
					description_el.appendChild(document.getDocument().createTextNode(order.getDescription()));
					if(shippingCharges != null) {
						purchase_order_number_el.appendChild(document.getDocument().createTextNode(shippingCharges.getPurchaseOrderNumber()));
					}
					order_el.appendChild(invoice_number_el);
					order_el.appendChild(description_el);
					order_el.appendChild(purchase_order_number_el);
					profile_trans_x_el.appendChild(order_el);
				}
	
				// tax exempt
				if(shippingCharges != null) {
					Element tax_exempt_el = document.createElement(AuthNetField.ELEMENT_TAX_EXEMPT.getFieldName());
					tax_exempt_el.appendChild(document.getDocument().createTextNode(
							shippingCharges.isTaxExempt()?TRUE.toLowerCase():FALSE.toLowerCase()));
					profile_trans_x_el.appendChild(tax_exempt_el);
				}
	
				if(authOrCaptureTxn) {
					// recurring billing
					Element recurring_billing_el = document.createElement(AuthNetField.ELEMENT_RECURRING_BILLING.getFieldName());
					recurring_billing_el.appendChild(document.getDocument().createTextNode(
							this.paymentTransaction.isRecurringBilling()?TRUE.toLowerCase():FALSE.toLowerCase()));
					profile_trans_x_el.appendChild(recurring_billing_el);
	
					// card code
					if(!StringUtils.isEmpty(this.paymentTransaction.getCardCode())) {
						Element card_code_el = document.createElement(AuthNetField.ELEMENT_CARD_CODE.getFieldName());
						card_code_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getCardCode()));
						profile_trans_x_el.appendChild(card_code_el);
					}
				}

				// split tender id
				if(!StringUtils.isEmpty(this.paymentTransaction.getSplitTenderId())) {
					Element split_tender_id_el = document.createElement(AuthNetField.ELEMENT_SPLIT_TENDER_ID.getFieldName());
					split_tender_id_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getSplitTenderId()));
					profile_trans_x_el.appendChild(split_tender_id_el);
				}
			}

			// transId
			if(!StringUtils.isEmpty(this.paymentTransaction.getTransactionId())) {
				Element trans_id_el = document.createElement(AuthNetField.ELEMENT_TRANS_ID.getFieldName());
				trans_id_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getTransactionId()));
				profile_trans_x_el.appendChild(trans_id_el);
			}

			// approval code
			if(!StringUtils.isEmpty(this.paymentTransaction.getApprovalCode())) {
				Element approval_code_el = document.createElement(AuthNetField.ELEMENT_APPROVAL_CODE.getFieldName());
				approval_code_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getApprovalCode()));
				profile_trans_x_el.appendChild(approval_code_el);
			}

			transaction_el.appendChild(profile_trans_x_el);
			document.getDocumentElement().appendChild(transaction_el);
		}
	}

	/**
	 * Add extra options that do not exist with CIM (see AIM).
	 *
	 * @param document
	 */
	private void addExtraOptions(BasicXmlDocument document) {
		if(this.extraOptions != null && this.extraOptions.size() > 0) {
			Element extra_options_el = document.createElement(AuthNetField.ELEMENT_EXTRA_OPTIONS.getFieldName());
			StringBuilder cDataBuffer = new StringBuilder();

			for(String key : extraOptions.keySet()) {
				String value = extraOptions.get(key).toString();
				cDataBuffer.append(key).append("=").append(value).append("&");
			}
			if(cDataBuffer.length() > 0) {
				cDataBuffer.deleteCharAt(cDataBuffer.length()-1);
				extra_options_el.appendChild(document.getDocument().createCDATASection(cDataBuffer.toString()));
				document.getDocumentElement().appendChild(extra_options_el);
			}
		}
	}

	/**
	 * Add the split tender id and status to the document.
	 *
	 * @param document
	 */
	private void addSplitTenderInfo(BasicXmlDocument document) {
		if(this.paymentTransaction != null) {
			Element split_tender_id_el = document.createElement(AuthNetField.ELEMENT_SPLIT_TENDER_ID.getFieldName());
			split_tender_id_el.appendChild(document.getDocument().createTextNode(this.paymentTransaction.getSplitTenderId()));
			document.getDocumentElement().appendChild(split_tender_id_el);

			if(this.paymentTransaction.getSplitTenderStatus() != null) {
				Element split_tender_status_el = document.createElement(AuthNetField.ELEMENT_SPLIT_TENDER_STATUS.getFieldName());
				split_tender_status_el.appendChild(document.getDocument().createTextNode(
						this.paymentTransaction.getSplitTenderStatus().name().toLowerCase()));
				document.getDocumentElement().appendChild(split_tender_status_el);
			}
		}
	}

	/**
	 * Convert request to XML.
	 */
	public String toXMLString() {
		switch (this.transactionType) {
		case CREATE_CUSTOMER_PROFILE :
			createCustomerProfile();
			break;
		case CREATE_CUSTOMER_PAYMENT_PROFILE :
			createCustomerPaymentProfile();
			break;
		case CREATE_CUSTOMER_SHIPPING_ADDRESS :
			createCustomerShippingAddress();
			break;
		case CREATE_CUSTOMER_PROFILE_TRANSACTION :
			createCustomerProfileTransaction();
			break;
		case DELETE_CUSTOMER_PROFILE :
			deleteCustomerProfile();
			break;
		case DELETE_CUSTOMER_PAYMENT_PROFILE :
			deleteCustomerPaymentProfile();
			break;
		case DELETE_CUSTOMER_SHIPPING_ADDRESS :
			deleteCustomerShippingAddress();
			break;
		case GET_CUSTOMER_PROFILE_IDS :
			getCustomerProfileIds();
			break;
		case GET_CUSTOMER_PROFILE :
			getCustomerProfile();
			break;
		case GET_CUSTOMER_PAYMENT_PROFILE :
			getCustomerPaymentProfile();
			break;
		case GET_CUSTOMER_SHIPPING_ADDRESS :
			getCustomerShippingAddress();
			break;
		case UPDATE_CUSTOMER_PROFILE :
			updateCustomerProfile();
			break;
		case UPDATE_CUSTOMER_PAYMENT_PROFILE :
			updateCustomerPaymentProfile();
			break;
		case UPDATE_CUSTOMER_SHIPPING_ADDRESS :
			updateCustomerShippingAddress();
			break;
		case UPDATE_SPLIT_TENDER_GROUP :
			updateSplitTenderGroup();
			break;
		case VALIDATE_CUSTOMER_PAYMENT_PROFILE :
			validateCustomerPaymentProfile();
			break;
		default:
			break;
		}

		return currentRequest.dump();
	}

	/**
	 * Validate customer payment profile request.
	 */
	private void validateCustomerPaymentProfile() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.VALIDATE_CUSTOMER_PAYMENT_PROFILE.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addCustomerProfileId(document);
		addCustomerPaymentProfileId(document);
		addCustomerShippingAddressId(document);
		addCardCode(document);
		addValidationMode(document);
		currentRequest = document;
	}

	/**
	 * Update the split tender group.
	 */
	private void updateSplitTenderGroup() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.UPDATE_SPLIT_TENDER_GROUP.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addSplitTenderInfo(document);
		currentRequest = document;
	}

	/**
	 * Update the customer shipping address.
	 */
	private void updateCustomerShippingAddress() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.UPDATE_CUSTOMER_SHIPPING_ADDRESS.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addRefId(document);
		addCustomerProfileId(document);
		// add shipping address
		addAddress(document, AuthNetField.ELEMENT_ADDRESS.getFieldName(),
					this.customerProfile.getShipToAddress(),
					document.getDocumentElement());
		currentRequest = document;
	}

	/**
	 * Update the customer payment profile.
	 */
	private void updateCustomerPaymentProfile() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.UPDATE_CUSTOMER_PAYMENT_PROFILE.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addRefId(document);
		addCustomerProfileId(document);
		addPaymentProfiles(document, null);
		addValidationMode(document);

		currentRequest = document;
	}

	/**
	 * Update the customer profile.
	 */
	private void updateCustomerProfile() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.UPDATE_CUSTOMER_PROFILE.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addRefId(document);
		addCustomerProfile(document);
		currentRequest = document;
	}

	/**
	 * Get customer shipping address request.
	 */
	private void getCustomerShippingAddress() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.GET_CUSTOMER_SHIPPING_ADDRESS.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addCustomerProfileId(document);
		addCustomerAddressId(document);
		currentRequest = document;
	}

	/**
	 * Get customer payment profile request.
	 */
	private void getCustomerPaymentProfile() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.GET_CUSTOMER_PAYMENT_PROFILE.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addCustomerProfileId(document);
		addCustomerPaymentProfileId(document);
		currentRequest = document;
	}

	/**
	 * Get customer profile request.
	 */
	private void getCustomerProfile() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.GET_CUSTOMER_PROFILE.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addCustomerProfileId(document);
		currentRequest = document;
	}

	/**
	 * Get customer profile ids request.
	 */
	private void getCustomerProfileIds() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.GET_CUSTOMER_PROFILE_IDS.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		currentRequest = document;
	}

	/**
	 * Delete customer shipping address request.
	 */
	private void deleteCustomerShippingAddress() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.DELETE_CUSTOMER_SHIPPING_ADDRESS.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addRefId(document);
		addCustomerProfileId(document);
		addCustomerAddressId(document);
		currentRequest = document;
	}

	/**
	 * Delete customer payment profile.
	 */
	private void deleteCustomerPaymentProfile() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.DELETE_CUSTOMER_PAYMENT_PROFILE.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addRefId(document);
		addCustomerProfileId(document);
		addCustomerPaymentProfileId(document);
		currentRequest = document;
	}

	/**
	 * Delete customer profile request.
	 */
	private void deleteCustomerProfile() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.DELETE_CUSTOMER_PROFILE.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addRefId(document);
		addCustomerProfileId(document);
		currentRequest = document;
	}

	/**
	 * Create customer profile transaction request.
	 */
	private void createCustomerProfileTransaction() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.CREATE_CUSTOMER_PROFILE_TRANSACTION.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addRefId(document);
		addPaymentTransaction(document);
		addExtraOptions(document);
		addAddress(document, AuthNetField.ELEMENT_ADDRESS.getFieldName(),
				this.customerProfile.getShipToAddress(),
				document.getDocumentElement());

		currentRequest = document;
	}

	/**
	 * Create customer shipping address request.
	 */
	private void createCustomerShippingAddress() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.CREATE_CUSTOMER_SHIPPING_ADDRESS.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addRefId(document);
		addCustomerProfileId(document);
		addAddress(document, AuthNetField.ELEMENT_ADDRESS.getFieldName(),
				this.customerProfile.getShipToAddress(), document.getDocumentElement());

		currentRequest = document;
	}

	/**
	 * Create customer payment profile request.
	 */
	private void createCustomerPaymentProfile() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.CREATE_CUSTOMER_PAYMENT_PROFILE.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addRefId(document);
		addCustomerProfileId(document);
		addPaymentProfiles(document, null);
		addValidationMode(document);

		currentRequest = document;
	}

	/**
	 * Create customer profile request.
	 */
	private void createCustomerProfile() {
		BasicXmlDocument document = new BasicXmlDocument();
		document.parseString("<" + TransactionType.CREATE_CUSTOMER_PROFILE.getValue()
				+ " xmlns = \"" + XML_NAMESPACE + "\" />");

		addAuthentication(document);
		addRefId(document);
		addCustomerProfile(document);
		addValidationMode(document);

		currentRequest = document;
	}

	/**
	 * @return the refId
	 */
	public String getRefId() {
		return refId;
	}

	/**
	 * @param refId the refId to set
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * @return the paymentProfileList
	 */
	public ArrayList<PaymentProfile> getPaymentProfileList() {
		return paymentProfileList;
	}

	/**
	 * @param paymentProfileList the paymentProfileList to set
	 */
	public void setPaymentProfileList(ArrayList<PaymentProfile> paymentProfileList) {
		this.paymentProfileList = paymentProfileList;
	}

	/**
	 * Add a payment profile.
	 *
	 * @param paymentProfile
	 */
	public void addPaymentProfile(PaymentProfile paymentProfile) {
		if(this.paymentProfileList == null) {
			this.paymentProfileList = new ArrayList<PaymentProfile>();
		}

		this.paymentProfileList.add(paymentProfile);
	}

	/**
	 * Set shipping information.
	 *
	 * @param shipTo
	 */
	public void setShipTo(Address shipTo) {
		if(this.customerProfile == null) {
			customerProfile = CustomerProfile.createCustomerProfile();
		}

		customerProfile.addShipToAddress(shipTo);
	}

	/**
	 * Get the validation mode.
	 *
	 * @return the validationMode
	 */
	public ValidationModeType getValidationMode() {
		return validationMode;
	}

	/**
	 * Set the validation mode for the request.
	 *
	 * @param validationMode the validationMode to set
	 */
	public void setValidationMode(ValidationModeType validationMode) {
		this.validationMode = validationMode;
	}

	/**
	 * Set the customer profile.
	 *
	 * @param customerProfile the customerProfile to set
	 */
	public void setCustomerProfile(CustomerProfile customerProfile) {
		if(this.customerProfile != null) {
			if(StringUtils.isEmpty(customerProfile.getCustomerProfileId())) {
				customerProfile.setCustomerProfileId(this.customerProfile.getCustomerProfileId());
			}
		}
		this.customerProfile = customerProfile;
	}

	/**
	 * Set the customer profile id.
	 *
	 * @param customerProfileId
	 */
	public void setCustomerProfileId(String customerProfileId) {
		if(this.customerProfile == null) {
			this.customerProfile = CustomerProfile.createCustomerProfile();
		}
		this.customerProfile.setCustomerProfileId(customerProfileId);
	}

	/**
	 * Set the customer payment profile id.
	 *
	 * @param customerPaymentProfileId
	 */
	public void setCustomerPaymentProfileId(String customerPaymentProfileId) {
		if(this.paymentTransaction == null) {
			this.paymentTransaction = PaymentTransaction.createPaymentTransaction();
		}
		this.paymentTransaction.setCustomerPaymentProfileId(customerPaymentProfileId);
	}

	/**
	 * Set the customer shipping address id.
	 *
	 * @param customerShippingAddressId
	 */
	public void setCustomerShippingAddressId(String customerShippingAddressId) {
		if(this.paymentTransaction == null) {
			this.paymentTransaction = PaymentTransaction.createPaymentTransaction();
		}
		this.paymentTransaction.setCustomerShippingAddressId(customerShippingAddressId);
	}

	/**
	 * Set the card code for specific transactions.
	 *
	 * @param cardCode
	 */
	public void setCardCode(String cardCode) {
		if(this.paymentTransaction == null) {
			this.paymentTransaction = PaymentTransaction.createPaymentTransaction();
		}
		this.paymentTransaction.setCardCode(cardCode);
	}

	/**
	 * Set the payment transaction.
	 *
	 * @param paymentTransaction the paymentTransaction to set
	 */
	public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
		if(this.paymentTransaction != null) {
			if(StringUtils.isEmpty(paymentTransaction.getCustomerPaymentProfileId())) {
				paymentTransaction.setCustomerPaymentProfileId(this.paymentTransaction.getCustomerPaymentProfileId());
			}
			if(StringUtils.isEmpty(paymentTransaction.getCustomerShippingAddressId())) {
				paymentTransaction.setCustomerShippingAddressId(this.paymentTransaction.getCustomerShippingAddressId());
			}
			if(StringUtils.isEmpty(paymentTransaction.getCardCode())) {
				paymentTransaction.setCardCode(this.paymentTransaction.getCardCode());
			}
		}
		this.paymentTransaction = paymentTransaction;
	}

	/**
	 * Sets the extra options.
	 *
	 * @param extraOptions the extraOptions to set
	 */
	public void setExtraOptions(Map<String, String> extraOptions) {
		this.extraOptions = extraOptions;
	}

	/**
	 * Add extra option to the extra options map.
	 *
	 * @param key
	 * @param value
	 */
	public void addExtraOption(String key, String value) {
		if(this.extraOptions == null) {
			this.extraOptions = Collections.synchronizedMap(new HashMap<String, String>());
		}
		this.extraOptions.put(key, value);
	}
}

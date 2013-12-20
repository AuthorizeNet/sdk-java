package net.authorize;

import java.math.BigDecimal;

import net.authorize.Environment;
import net.authorize.Merchant;
import net.authorize.data.creditcard.AVSCode;
import net.authorize.data.creditcard.CardType;
import net.authorize.data.echeck.BankAccountType;
import net.authorize.data.echeck.ECheckType;

public abstract class UnitTestData {

	protected static String apiLoginID = System.getProperty("API_LOGIN_ID");
	protected static String transactionKey = System.getProperty("TRANSACTION_KEY");
	protected static String cp_apiLoginID = System.getProperty("CP_API_LOGIN_ID");
	protected static String cp_transactionKey = System.getProperty("CP_TRANSACTION_KEY");
	protected static String merchantMD5Key = System.getProperty("MD5_HASH_KEY");
	protected static Merchant merchant = Merchant.createMerchant(
			Environment.SANDBOX, apiLoginID,
			transactionKey);

	// customer information
	protected final String firstName = "John";
	protected final String lastName = "Doe";
	protected final String address = "123 Any Street";
	protected final String city = "Any City";
	protected final String state = "CA";
	protected final String zipPostalCode = "94114";
	protected final String magicSplitTenderZipCode = "46225";
	protected final String company = "John Doe Innovations";
	protected final String country = "US";
	protected final String customerId = "CUST000000";
	protected final String customerIP = "127.0.0.1";
	protected final String email = "customer@merchant.com";
	protected final String email2 = "customer2@merchant.com";
	protected final String phone = "415-555-1212";
	protected final String fax = "415-555-1313";
	protected final String customerDescription = "Customer A";
	protected final String customerDescription2 = "Customer B";

	// email receipt information
	protected final String headerEmailReceipt = "Thank you for purchasing " +
			"Widgets from The Antibes Company";
	protected final String footerEmailReceipt = "If you have any problems, " +
			"please contact us at +44 20 5555 1212";
	protected final String merchantEmail = "merchant@merchant.com";

	// order information
	protected final String orderDescription = "Widgets";
	protected final String invoiceNumber = Long.toString(System.currentTimeMillis());
	protected final String mdfKey = "notes";
	protected final String mdfValue = "Would like a blue widget.";

	// order item information
	protected final String itemDescription = "A widget for widgeting.";
	protected final String itemId = "widget_a_1000";
	protected final String itemName = "Widget A";
	protected final BigDecimal itemPrice = new BigDecimal(19.99);
	protected final BigDecimal itemQuantity = new BigDecimal(1.00);
	protected final String itemDescription2 = "A FREE micro widget.";
	protected final String itemId2 = "mwidget_z_0001";
	protected final String itemName2 = "Micro Widget Z";
	protected final BigDecimal itemPrice2 = new BigDecimal(0.01);
	protected final BigDecimal itemQuantity2 = new BigDecimal(1.00);

	// shipping address information is the same as the customer address

	// shipping charges information
	protected final BigDecimal dutyAmount = new BigDecimal(0.00);
	protected final String dutyItemDescription = "VAT";
	protected final String dutyItemName = "VAT Tax";
	protected final BigDecimal freightAmount = new BigDecimal(5.00);
	protected final String freightDescription = "Flat rate";
	protected final String freightItemName = "Shipping";
	protected final String purchaseOrderNumber = "PO-1001";
	protected final BigDecimal taxAmount = new BigDecimal(2.37);
	protected final String taxDescription = "9.5%";
	protected final boolean taxExempt = false;
	protected final String taxItemName = "California Tax";

	// credit card information
	protected final String creditCardNumber = "4111-1111-1111-1111";
	protected final String rawCreditCardNumber = "4111111111111111";
	protected final String maskedCreditCardNumber = "xxxx1111";
	protected final CardType cardType = CardType.VISA;
	protected final String creditCardExpMonth = "12";
	protected final String creditCardExpYear = "2020";
	protected final AVSCode avsCode = AVSCode.P;
	protected final String cardCodeVerification = "P";
	protected final String cardholderAuthenticationIndicator = "5";
	protected final String cardholderAuthenticationValue = "123";

	// eCheck information
	protected final String bankAccountName = "Test Checking";
	protected final String bankAccountNumber = "1234567890";
	protected final BankAccountType bankAccountType = BankAccountType.CHECKING;
	protected final String bankCheckNumber = "1001";
	protected final String bankName = "Bank of America";
	protected final ECheckType eCheckType = ECheckType.WEB;
	protected final String routingNumber = "111000025";

	// transaction information
	protected final BigDecimal totalAmount = new BigDecimal(27.36);

	protected final String reportingBatchId = "814302";
	protected final String reportingTransId = "2156009012";
}

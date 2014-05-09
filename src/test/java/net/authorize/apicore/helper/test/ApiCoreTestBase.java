package net.authorize.apicore.helper.test;

import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import net.authorize.Environment;
import net.authorize.UnitTestData;
import net.authorize.apicore.contract.v1.BankAccountType;
import net.authorize.apicore.contract.v1.BankAccountTypeEnum;
import net.authorize.apicore.contract.v1.CreditCardTrackType;
import net.authorize.apicore.contract.v1.CreditCardType;
import net.authorize.apicore.contract.v1.CustomerAddressType;
import net.authorize.apicore.contract.v1.CustomerPaymentProfileType;
import net.authorize.apicore.contract.v1.CustomerProfileType;
import net.authorize.apicore.contract.v1.CustomerTypeEnum;
import net.authorize.apicore.contract.v1.DriversLicenseType;
import net.authorize.apicore.contract.v1.EcheckTypeEnum;
import net.authorize.apicore.contract.v1.EncryptedTrackDataType;
import net.authorize.apicore.contract.v1.KeyBlock;
import net.authorize.apicore.contract.v1.MerchantAuthenticationType;
import net.authorize.apicore.contract.v1.PayPalType;
import net.authorize.apicore.contract.v1.PaymentType;
import net.authorize.data.xml.reporting.ReportingDetails;
import net.authorize.util.Constants;
import net.authorize.util.DateUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class ApiCoreTestBase {

	protected static Log logger = LogFactory.getLog(ApiCoreTestBase.class);
	
	static Environment environment = Environment.SANDBOX;
	
	MerchantAuthenticationType merchantAuthenticationType = null;
	CustomerProfileType customerProfileType = null;
	CustomerPaymentProfileType customerPaymentProfileOne = null;
	CustomerAddressType customerAddressOne = null;
	DriversLicenseType driversLicenseOne = null; 
	PaymentType paymentOne = null;
	CreditCardType creditCardOne = null;
	BankAccountType bankAccountOne = null;
	CreditCardTrackType trackDataOne = null;
	EncryptedTrackDataType encryptedTrackDataOne = null;
	PayPalType payPalOne = null;
	
	String nowString = null;
	Date now = null;
	String refId = null;
	int counter = 0;
	String counterStr = null;

	static String CnpApiLoginIdKey = null;
	static String CnpTransactionKey = null;
	static String CnpMd5HashKey = null;
	static String CpApiLoginIdKey = null;
	static String CpTransactionKey = null;
	static String CpMd5HashKey = null;
	
	private Random random = new Random();
	static {
		//getPropertyFromNames get the value from properties file or environment
		CnpApiLoginIdKey = UnitTestData.getPropertyFromNames(Constants.ENV_API_LOGINID, Constants.PROP_API_LOGINID);
		CnpTransactionKey = UnitTestData.getPropertyFromNames(Constants.ENV_TRANSACTION_KEY, Constants.PROP_TRANSACTION_KEY);
		CnpMd5HashKey = null;
		CpApiLoginIdKey = UnitTestData.getPropertyFromNames(Constants.ENV_CP_API_LOGINID, Constants.PROP_CP_API_LOGINID);
		CpTransactionKey = UnitTestData.getPropertyFromNames(Constants.ENV_CP_TRANSACTION_KEY, Constants.PROP_CP_TRANSACTION_KEY);
		CpMd5HashKey = UnitTestData.getPropertyFromNames(Constants.ENV_MD5_HASHKEY, Constants.PROP_MD5_HASHKEY);

		if ((null == CnpApiLoginIdKey) ||
			(null == CnpTransactionKey) ||
			(null == CpApiLoginIdKey) ||
			(null == CpTransactionKey))
		{
			throw new IllegalArgumentException("LoginId and/or TransactionKey have not been set.");
		}
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//initialize counter
		counter = random.nextInt((int) Math.pow(2, 24));
		counterStr = getRandomString("");

		now = Calendar.getInstance().getTime();
		nowString = DateUtil.getFormattedDate(now, ReportingDetails.DATE_FORMAT);
				
		merchantAuthenticationType = new MerchantAuthenticationType() ;
		merchantAuthenticationType.setName(CnpApiLoginIdKey);
		merchantAuthenticationType.setTransactionKey(CnpTransactionKey);
//		merchantAuthenticationType.setSessionToken(getRandomString("SessionToken"));
//		merchantAuthenticationType.setPassword(getRandomString("Password"));
//	    merchantAuthenticationType.setMobileDeviceId(getRandomString("MobileDevice"));
	    
//	    ImpersonationAuthenticationType impersonationAuthenticationType = new ImpersonationAuthenticationType();
//	    impersonationAuthenticationType.setPartnerLoginId(CnpApiLoginIdKey);
//	    impersonationAuthenticationType.setPartnerTransactionKey(CnpTransactionKey);
//	    merchantAuthenticationType.setImpersonationAuthentication(impersonationAuthenticationType);

		customerProfileType = new CustomerProfileType() ;
		customerProfileType.setMerchantCustomerId(getRandomString("Customer"));
		customerProfileType.setDescription(getRandomString("CustomerDescription"));
		customerProfileType.setEmail(getRandomString("CustomerEmail")+"@test.anet.net");
		
		//make sure these elements are initialized by calling get as it uses lazy initialization
		//List<CustomerPaymentProfileType> paymentProfiles = 
				customerProfileType.getPaymentProfiles();
		//List<CustomerAddressType> addresses = 
				customerProfileType.getShipToList();
		
		CreditCardType creditCardOne = new CreditCardType();
		creditCardOne.setCardNumber("4111111111111111");
		creditCardOne.setExpirationDate("2038-12");
//		creditCardOne.setCardCode("");

		BankAccountType bankAccountOne = new BankAccountType();
		bankAccountOne.setAccountType(BankAccountTypeEnum.SAVINGS);
		bankAccountOne.setRoutingNumber("125000000");
		bankAccountOne.setAccountNumber(getRandomString("A/C#"));
		bankAccountOne.setNameOnAccount((getRandomString("A/CName")));
		bankAccountOne.setEcheckType(EcheckTypeEnum.WEB); 
		bankAccountOne.setBankName(getRandomString("Bank"));
		bankAccountOne.setCheckNumber(counterStr);
	    
		CreditCardTrackType trackDataOne = new CreditCardTrackType();
		trackDataOne.setTrack1(getRandomString("Track1"));
		trackDataOne.setTrack2(getRandomString("Track2"));

		EncryptedTrackDataType encryptedTrackDataOne = new EncryptedTrackDataType();
		KeyBlock keyBlock = new KeyBlock();
		//keyBlock.setValue(value);
		encryptedTrackDataOne.setFormOfPayment(keyBlock);

		payPalOne = new PayPalType();
		payPalOne.setSuccessUrl(getRandomString("http://success.anet.net"));
		payPalOne.setCancelUrl(getRandomString("http://cancel.anet.net"));
		payPalOne.setPaypalLc(getRandomString("Lc"));
		payPalOne.setPaypalHdrImg(getRandomString("Hdr"));
		payPalOne.setPaypalPayflowcolor(getRandomString("flowClr"));
		payPalOne.setPayerID(getRandomString("PayerId"));
		
		paymentOne = new PaymentType();
		paymentOne.setCreditCard(creditCardOne);
		//paymentOne.setBankAccount(bankAccountOne);
		//paymentOne.setTrackData(trackDataOne);
		//paymentOne.setEncryptedTrackData(encryptedTrackDataOne);
		//paymentOne.setPayPal( payPalOne);
		
//		driversLicenseOne = new DriversLicenseType();
//		driversLicenseOne.setNumber(getRandomString("DLNumber"));
//		driversLicenseOne.setState(getRandomString("WA"));
//		driversLicenseOne.setDateOfBirth(nowString);

		customerAddressOne = new CustomerAddressType();
		customerAddressOne.setFirstName(getRandomString("FName"));
		customerAddressOne.setLastName(getRandomString("LName"));
	    customerAddressOne.setCompany(getRandomString("Company"));
	    customerAddressOne.setAddress(getRandomString("StreetAdd"));
	    customerAddressOne.setCity("Bellevue");
	    customerAddressOne.setState("WA");
	    customerAddressOne.setZip("98000");
	    customerAddressOne.setCountry("USA");
	    customerAddressOne.setPhoneNumber("123-456-7890");
	    customerAddressOne.setFaxNumber("987-654-3210");
		
		customerPaymentProfileOne = new CustomerPaymentProfileType();
		customerPaymentProfileOne.setCustomerType(CustomerTypeEnum.INDIVIDUAL);
		customerPaymentProfileOne.setPayment(paymentOne);
//	    customerPaymentProfileOne.setBillTo(customerAddressOne);
//	    customerPaymentProfileOne.setDriversLicense(driversLicenseOne);
//	    customerPaymentProfileOne.setTaxId(getRandomString("XX"));
		
	    refId = counterStr;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	String getRandomString(String title) {
		return String.format("%s:%d", title, counter);

	}
}

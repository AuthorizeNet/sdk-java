package net.authorize.api.controller.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.datatype.DatatypeFactory;

import junit.framework.Assert;
import net.authorize.Environment;
import net.authorize.UnitTestData;
import net.authorize.api.contract.v1.ANetApiRequest;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.ARBSubscriptionType;
import net.authorize.api.contract.v1.ARBSubscriptionUnitEnum;
import net.authorize.api.contract.v1.BankAccountType;
import net.authorize.api.contract.v1.BankAccountTypeEnum;
import net.authorize.api.contract.v1.CreditCardTrackType;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.CustomerAddressType;
import net.authorize.api.contract.v1.CustomerDataType;
import net.authorize.api.contract.v1.CustomerPaymentProfileType;
import net.authorize.api.contract.v1.CustomerProfileType;
import net.authorize.api.contract.v1.CustomerType;
import net.authorize.api.contract.v1.CustomerTypeEnum;
import net.authorize.api.contract.v1.DriversLicenseType;
import net.authorize.api.contract.v1.EcheckTypeEnum;
import net.authorize.api.contract.v1.EncryptedTrackDataType;
import net.authorize.api.contract.v1.KeyBlock;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.MessagesType;
import net.authorize.api.contract.v1.MessagesType.Message;
import net.authorize.api.contract.v1.NameAndAddressType;
import net.authorize.api.contract.v1.ObjectFactory;
import net.authorize.api.contract.v1.OrderType;
import net.authorize.api.contract.v1.PayPalType;
import net.authorize.api.contract.v1.PaymentScheduleType;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.controller.base.ApiOperationBase;
import net.authorize.api.controller.base.IApiOperation;
import net.authorize.util.Constants;
import net.authorize.util.DateUtil;
import net.authorize.util.LogHelper;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class ApiCoreTestBase {

	protected static Logger logger = LogManager.getLogger(ApiCoreTestBase.class);

	protected static HashMap<String, String> errorMessages = null;

	// protected static Environment environment = Environment.HOSTED_VM;
	protected static Environment environment = Environment.SANDBOX;

	static String apiLoginIdKey = null;
	static String transactionKey = null;
	static String md5HashKey = null;

	protected static String apiLoginIdKeyApplePay = null;
	protected static String transactionKeyApplePay = null;
	protected static String md5HashKeyApplePay = null;

	DatatypeFactory datatypeFactory = null;
	GregorianCalendar pastDate = null;
	GregorianCalendar nowDate = null;
	GregorianCalendar futureDate = null;
	String nowString = null;
	Date now = null;

	protected String refId = null;
	protected int counter = 0;
	protected String counterStr = null;

	protected MerchantAuthenticationType merchantAuthenticationType = null;

	protected ARBSubscriptionType arbSubscriptionOne = null;
	protected ARBSubscriptionType arbSubscriptionTwo = null;
	protected BankAccountType bankAccountOne = null;
	protected CreditCardTrackType trackDataOne = null;
	protected CreditCardType creditCardOne = null;
	protected CustomerAddressType customerAddressOne = null;
	protected CustomerDataType customerDataOne = null;
	protected CustomerPaymentProfileType customerPaymentProfileOne = null;
	protected CustomerProfileType customerProfileType = null;
	protected CustomerType customerOne = null;
	protected CustomerType customerTwo = null;
	protected DriversLicenseType driversLicenseOne = null;
	protected EncryptedTrackDataType encryptedTrackDataOne = null;
	protected NameAndAddressType nameAndAddressTypeOne = null;
	protected NameAndAddressType nameAndAddressTypeTwo = null;
	protected OrderType orderType = null;
	protected PaymentScheduleType paymentScheduleTypeOne = null;
	protected PaymentType paymentOne = null;
	protected PayPalType payPalOne = null;

	protected Mockery mockContext = null;
	protected static ObjectFactory factory = null;
	private Random random = new Random();

	static {
		// getPropertyFromNames get the value from properties file or environment
		apiLoginIdKey = UnitTestData.getPropertyFromNames(Constants.ENV_API_LOGINID, Constants.PROP_API_LOGINID);
		transactionKey = UnitTestData.getPropertyFromNames(Constants.ENV_TRANSACTION_KEY,
				Constants.PROP_TRANSACTION_KEY);
		md5HashKey = UnitTestData.getPropertyFromNames(Constants.ENV_MD5_HASHKEY, Constants.PROP_MD5_HASHKEY);

		apiLoginIdKeyApplePay = UnitTestData.getPropertyFromNames(Constants.ENV_API_LOGINID_APPLEPAY,
				Constants.PROP_API_LOGINID_APPLEPAY);
		transactionKeyApplePay = UnitTestData.getPropertyFromNames(Constants.ENV_TRANSACTION_KEY_APPLEPAY,
				Constants.PROP_TRANSACTION_KEY_APPLEPAY);
		md5HashKeyApplePay = UnitTestData.getPropertyFromNames(Constants.ENV_MD5_HASHKEY_APPLEPAY,
				Constants.PROP_MD5_HASHKEY_APPLEPAY);

		// require only one cnp or cp merchant keys
		if ((null != apiLoginIdKey && null != transactionKey)) {
			logger.debug("Merchant keys are present.");
		} else {
			throw new IllegalArgumentException(
					"LoginId and/or TransactionKey have not been set. " + "Merchant keys are required.");
		}

		if ((null != apiLoginIdKeyApplePay && null != transactionKeyApplePay)) {
			logger.debug("Merchant ApplePay keys are present.");
		} else {
			// If one is null. make all equal to the regular key values.
			apiLoginIdKeyApplePay = apiLoginIdKey;
			transactionKeyApplePay = transactionKey;
			md5HashKeyApplePay = md5HashKey;
		}

		errorMessages = new HashMap<String, String>();
		factory = new ObjectFactory();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		errorMessages.put("E00003", "");
		errorMessages.put("E00027", "");
		errorMessages.put("E00040", "");
		errorMessages.put("E00090", "PaymentProfile cannot be sent with payment data.");
		errorMessages.put("E00091", "PaymentProfileId cannot be sent with payment data.");
		errorMessages.put("E00092", "ShippingProfileId cannot be sent with ShipTo data.");
		errorMessages.put("E00093", "PaymentProfile cannot be sent with billing data.");
		errorMessages.put("E00095", "ShippingProfileId is not provided within Customer Profile.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		mockContext = new Mockery();

		// initialize counter
		counter = random.nextInt((int) Math.pow(2, 24));
		counterStr = getRandomString("");

		now = Calendar.getInstance().getTime();

		datatypeFactory = DatatypeFactory.newInstance();
		// TODO add / subtract relative
		pastDate = new GregorianCalendar(2010, 01, 01);
		nowDate = new GregorianCalendar();
		futureDate = new GregorianCalendar(2020, 12, 31);

		merchantAuthenticationType = new MerchantAuthenticationType();
		merchantAuthenticationType.setName(apiLoginIdKey);
		merchantAuthenticationType.setTransactionKey(transactionKey);

		// merchantAuthenticationType.setSessionToken(getRandomString("SessionToken"));
		// merchantAuthenticationType.setPassword(getRandomString("Password"));
		// merchantAuthenticationType.setMobileDeviceId(getRandomString("MobileDevice"));

		// ImpersonationAuthenticationType impersonationAuthenticationType = new
		// ImpersonationAuthenticationType();
		// impersonationAuthenticationType.setPartnerLoginId(CnpApiLoginIdKey);
		// impersonationAuthenticationType.setPartnerTransactionKey(CnpTransactionKey);
		// merchantAuthenticationType.setImpersonationAuthentication(impersonationAuthenticationType);

		customerProfileType = new CustomerProfileType();
		customerProfileType.setMerchantCustomerId(getRandomString("Customer"));
		customerProfileType.setDescription(getRandomString("CustomerDescription"));
		customerProfileType.setEmail(counterStr + ".customerProfileType@test.anet.net");

		// make sure these elements are initialized by calling get as it uses lazy
		// initialization
		// List<CustomerPaymentProfileType> paymentProfiles =
		customerProfileType.getPaymentProfiles();
		// List<CustomerAddressType> addresses =
		customerProfileType.getShipToList();

		// XXX HIDE CreditCardType
		creditCardOne = new CreditCardType();
		creditCardOne.setCardNumber("4111111111111111");
		creditCardOne.setExpirationDate("2038-12");
		// creditCardOne.setCardCode("");

		// XXX HIDE BankAccountType
		bankAccountOne = new BankAccountType();
		bankAccountOne.setAccountType(BankAccountTypeEnum.SAVINGS);
		bankAccountOne.setRoutingNumber("125000000");
		bankAccountOne.setAccountNumber(getRandomString("A/C#"));
		bankAccountOne.setNameOnAccount((getRandomString("A/CName")));
		bankAccountOne.setEcheckType(EcheckTypeEnum.WEB);
		bankAccountOne.setBankName(getRandomString("Bank"));
		bankAccountOne.setCheckNumber(counterStr);

		// XXX HIDE CreditCardTrackType
		trackDataOne = new CreditCardTrackType();
		trackDataOne.setTrack1(getRandomString("Track1"));
		trackDataOne.setTrack2(getRandomString("Track2"));

		// XXX HIDE EncryptedTrackDataType
		encryptedTrackDataOne = new EncryptedTrackDataType();
		KeyBlock keyBlock = new KeyBlock();
		// keyBlock.setValue(value);
		encryptedTrackDataOne.setFormOfPayment(keyBlock);

		payPalOne = new PayPalType();
		payPalOne.setSuccessUrl(getRandomString("https://success.anet.net"));
		payPalOne.setCancelUrl(getRandomString("https://cancel.anet.net"));
		payPalOne.setPaypalLc(getRandomString("Lc"));
		payPalOne.setPaypalHdrImg(getRandomString("Hdr"));
		payPalOne.setPaypalPayflowcolor(getRandomString("flowClr"));
		payPalOne.setPayerID(getRandomString("PayerId"));

		paymentOne = new PaymentType();
		paymentOne.setCreditCard(creditCardOne);
		// paymentOne.setBankAccount(bankAccountOne);
		// paymentOne.setTrackData(trackDataOne);
		// paymentOne.setEncryptedTrackData(encryptedTrackDataOne);
		// paymentOne.setPayPal( payPalOne);

		// driversLicenseOne = new DriversLicenseType();
		// driversLicenseOne.setNumber(getRandomString("DLNumber"));
		// driversLicenseOne.setState(getRandomString("WA"));
		// driversLicenseOne.setDateOfBirth(nowString);

		customerAddressOne = new CustomerAddressType();
		customerAddressOne.setFirstName(getRandomString("FName"));
		customerAddressOne.setLastName(getRandomString("LName"));
		customerAddressOne.setCompany(getRandomString("Company"));
		customerAddressOne.setAddress(getRandomString("StreetAdd"));
		customerAddressOne.setCity("Bellevue");
		customerAddressOne.setState("WA");
		customerAddressOne.setZip("98000");
		customerAddressOne.setCountry("USA");
		customerAddressOne.setPhoneNumber(formatToPhone(counter));
		customerAddressOne.setFaxNumber(formatToPhone(counter + 1));
		customerPaymentProfileOne = new CustomerPaymentProfileType();
		customerPaymentProfileOne.setCustomerType(CustomerTypeEnum.INDIVIDUAL);
		customerPaymentProfileOne.setPayment(paymentOne);
		// customerPaymentProfileOne.setBillTo(customerAddressOne);
		// customerPaymentProfileOne.setDriversLicense(driversLicenseOne);
		// customerPaymentProfileOne.setTaxId(getRandomString("XX"));

		customerOne = new CustomerType();
		customerOne.setType(CustomerTypeEnum.INDIVIDUAL);
		customerOne.setId(getRandomString("Id"));
		customerOne.setEmail(counterStr + ".customerOne@test.anet.net");
		customerOne.setPhoneNumber(formatToPhone(counter));
		customerOne.setFaxNumber(formatToPhone(counter + 1));
		customerOne.setDriversLicense(driversLicenseOne);
		customerOne.setTaxId("911011011");// "123-45-6789");//TODO

		customerTwo = new CustomerType();

		PaymentScheduleType.Interval interval = new PaymentScheduleType.Interval();
		interval.setLength((short) 1);
		interval.setUnit(ARBSubscriptionUnitEnum.MONTHS);

		orderType = new OrderType();
		// TODO ADD VALIDATION ON INVOICE LENGTH
		orderType.setInvoiceNumber(getRandomString("Inv:"));
		orderType.setDescription(getRandomString("Description"));

		nameAndAddressTypeOne = new NameAndAddressType();
		nameAndAddressTypeOne.setFirstName(getRandomString("FName"));
		nameAndAddressTypeOne.setLastName(getRandomString("LName"));
		nameAndAddressTypeOne.setCompany(getRandomString("Company"));
		nameAndAddressTypeOne.setAddress(getRandomString("Address"));
		nameAndAddressTypeOne.setCity(getRandomString("City"));
		nameAndAddressTypeOne.setState(getRandomString("State"));
		nameAndAddressTypeOne.setZip("98004");
		nameAndAddressTypeOne.setCountry("USA");

		nameAndAddressTypeTwo = new NameAndAddressType();
		nameAndAddressTypeTwo.setFirstName(getRandomString("FName"));
		nameAndAddressTypeTwo.setLastName(getRandomString("LName"));
		nameAndAddressTypeTwo.setCompany(getRandomString("Company"));
		nameAndAddressTypeTwo.setAddress(getRandomString("Address"));
		nameAndAddressTypeTwo.setCity(getRandomString("City"));
		nameAndAddressTypeTwo.setState(getRandomString("State"));
		nameAndAddressTypeTwo.setZip("98004");
		nameAndAddressTypeTwo.setCountry("USA");

		paymentScheduleTypeOne = new PaymentScheduleType();
		paymentScheduleTypeOne.setInterval(interval);
		paymentScheduleTypeOne.setStartDate(datatypeFactory.newXMLGregorianCalendar(nowDate));
		paymentScheduleTypeOne.setTotalOccurrences((short) 5);
		paymentScheduleTypeOne.setTrialOccurrences((short) 0);

		arbSubscriptionOne = new ARBSubscriptionType();
		arbSubscriptionOne.setAmount(setValidSubscriptionAmount(counter));
		arbSubscriptionOne.setBillTo(nameAndAddressTypeOne);
		arbSubscriptionOne.setCustomer(customerOne);
		arbSubscriptionOne.setName(getRandomString("Name"));
		arbSubscriptionOne.setOrder(orderType);
		arbSubscriptionOne.setPayment(paymentOne);
		arbSubscriptionOne.setPaymentSchedule(paymentScheduleTypeOne);
		arbSubscriptionOne.setShipTo(nameAndAddressTypeOne);
		arbSubscriptionOne.setTrialAmount(setValidSubscriptionAmount(0));

		customerDataOne = new CustomerDataType();
		customerDataOne.setDriversLicense(customerOne.getDriversLicense());
		customerDataOne.setEmail(customerOne.getEmail());
		customerDataOne.setId(customerOne.getId());
		customerDataOne.setTaxId(customerOne.getTaxId());
		customerDataOne.setType(customerOne.getType());

		refId = counterStr;
	}

	@After
	public void tearDown() throws Exception {
	}

	protected String getRandomString(String title) {
		return String.format("%s%d", title, counter);

	}

	public String formatToPhone(int number) {
		DecimalFormat formatter = new DecimalFormat("0000000000");
		String formattedNumber = formatter.format(number).toString();
		return formattedNumber.substring(0, 3) + "-" + formattedNumber.substring(3, 6) + "-"
				+ formattedNumber.substring(6, 10);
	}

	public BigDecimal setValidTaxAmount(BigDecimal amount) {
		return new BigDecimal(amount.doubleValue() * TAX_RATE);
	}

	public BigDecimal setValidTransactionAmount(int number) {
		return setValidAmount(number, MAX_TRANSACTION_AMOUNT);
	}

	public BigDecimal setValidSubscriptionAmount(int number) {
		return setValidAmount(number, MAX_SUBSCRIPTION_AMOUNT);
	}

	private BigDecimal setValidAmount(int number, int maxAmount) {
		return new BigDecimal(number > maxAmount ? (number % maxAmount) : number);
	}

	static ANetApiResponse errorResponse = null;

	protected ANetApiResponse getErrorResponse() {
		return errorResponse;
	}

	private int MAX_SUBSCRIPTION_AMOUNT = 1000;// 214747;
	private int MAX_TRANSACTION_AMOUNT = 10000;// 214747;
	private double TAX_RATE = 0.10d;

	protected static <Q extends ANetApiRequest, S extends ANetApiResponse, T extends ApiOperationBase<Q, S>> S executeTestRequestWithSuccess(
			Q request, Class<T> controllerClass, Environment execEnvironment) {
		S response = executeTestRequest(true, request, controllerClass, execEnvironment);

		return response;
	}

	protected static <Q extends ANetApiRequest, S extends ANetApiResponse, T extends ApiOperationBase<Q, S>> S executeTestRequestWithFailure(
			Q request, Class<T> controllerClass, Environment execEnvironment) {
		S response = executeTestRequest(false, request, controllerClass, execEnvironment);

		return response;
	}

	@SuppressWarnings("unchecked")
	private static <Q extends ANetApiRequest, S extends ANetApiResponse, T extends ApiOperationBase<Q, S>> S executeTestRequest(
			boolean successExpected, Q request, Class<T> controllerClass, Environment execEnvironment) {
		LogHelper.debug(logger, "Created %s Request: '%s'", request.getClass(), request);

		S response = null;
		T controller = null;
		errorResponse = null;
		try {
			Class<?>[] parameterTypes = new Class<?>[] { request.getClass() };
			Constructor<T> constructor = controllerClass.getConstructor(parameterTypes);
			Object controllerObject = constructor.newInstance(request);
			controller = (T) controllerObject;
			ANetApiResponse baseResponse = controller.executeWithApiResponse(execEnvironment);
			LogHelper.info(logger, "%s ResultCode: %s", controllerClass, controller.getResultCode());
			LogHelper.info(logger, "%s Results:    %s", controllerClass, controller.getResults());
			response = (S) baseResponse;

		} catch (Exception e) {
			LogHelper.error(logger, "Exception : '%s' during %s", e.getMessage(), controllerClass);
		}
		if (successExpected) {
			processFailureResult(true, controller, response);
			validateSuccess(controller, response);
		} else {
			validateFailure(controller, response);
		}
		if (null == response && null != controller && null != controller.getErrorResponse()) {
			errorResponse = controller.getErrorResponse();
		}

		return response;
	}

	protected static <Q extends ANetApiRequest, S extends ANetApiResponse, T extends ApiOperationBase<Q, S>> void processFailureResult(
			boolean fail, T controller, S response) {
		// in case there are errors, log the error messages
		if (MessageTypeEnum.OK != controller.getResultCode()) {
			for (String aMessage : controller.getResults()) {
				LogHelper.info(logger, "Controller Messages: '%s' ", aMessage);
			}
			displayResponse(response, "Failure Messsages");
			ANetApiResponse errorResponse = controller.getErrorResponse();
			displayResponse(errorResponse, "Error Response Messages");
			if (fail) {
				Assert.fail("Request failed.");
			}
		}
	}

	protected static <Q extends ANetApiRequest, S extends ANetApiResponse, T extends ApiOperationBase<Q, S>> void validateSuccess(
			T controller, S response) {
		Assert.assertEquals(MessageTypeEnum.OK, controller.getResultCode());
		Assert.assertNull(controller.getErrorResponse());
		Assert.assertNotNull(response);
		displayResponse(response, "Success Messages");
	}

	protected static <Q extends ANetApiRequest, S extends ANetApiResponse, T extends ApiOperationBase<Q, S>> void validateFailure(
			T controller, S response) {
		Assert.assertEquals(MessageTypeEnum.ERROR, controller.getResultCode());
		// TODO Until error response is fixed
		// Assert.assertNotNull(controller.getErrorResponse());
		// Assert.assertNull(response);
		processFailureResult(false, controller, response);
	}

	private static void displayResponse(ANetApiResponse response, String source) {
		LogHelper.info(logger, "Source '%s' ", source);
		if (null != response) {
			MessagesType messageType = response.getMessages();
			if (null != messageType) {
				LogHelper.info(logger, "MessageCode: '%s' ", messageType.getResultCode().toString());
				for (Message aMessage : messageType.getMessage()) {
					LogHelper.info(logger, "Message: '%s':'%s' ", aMessage.getCode(), aMessage.getText());
				}
			}
		}
	}

	protected void validateErrorCode(MessagesType messagesType, String errorCode) {
		MessagesType.Message firstError = getFirstErrorMessage(messagesType);
		if (null != firstError) {
			Assert.assertEquals(errorCode, firstError.getCode());
			if (errorMessages.containsKey(errorCode)) {
				String message = errorMessages.get(errorCode);
				if (!message.isEmpty()) {
					Assert.assertEquals(message, firstError.getText());
				}
			}
		}
	}

	protected static String getFirstErrorCode(MessagesType messagesType) {
		MessagesType.Message errorMessage = getFirstErrorMessage(messagesType);
		return ((null != errorMessage) ? errorMessage.getCode() : null);
	}

	protected static String getFirstErrorText(MessagesType messagesType) {
		MessagesType.Message errorMessage = getFirstErrorMessage(messagesType);
		return ((null != errorMessage) ? errorMessage.getText() : null);
	}

	protected static MessagesType.Message getFirstErrorMessage(MessagesType messagesType) {
		MessagesType.Message errorMessage = null;
		if (null != messagesType.getMessage()) {
			for (MessagesType.Message aMessage : messagesType.getMessage()) {
				errorMessage = aMessage;
				break;
			}

		}

		return errorMessage;

	}

	protected <Q extends ANetApiRequest, S extends ANetApiResponse> void setMockControllerExpectations(
			final IApiOperation<Q, S> mockController, final Q mockRequest, final S mockResponse,
			final ANetApiResponse errorResponse, final List<String> results, final MessageTypeEnum messageType) {

		final net.authorize.Environment mockEnvironment = net.authorize.Environment.CUSTOM;
		mockContext.checking(new Expectations() {
			{
				oneOf(mockController).execute();
				oneOf(mockController).execute(mockEnvironment);
				oneOf(mockController).getApiResponse();
				will(returnValue(mockResponse));
				oneOf(mockController).executeWithApiResponse();
				will(returnValue(mockResponse));
				oneOf(mockController).executeWithApiResponse(mockEnvironment);
				will(returnValue(mockResponse));
				oneOf(mockController).getResults();
				will(returnValue(results));
				oneOf(mockController).getResultCode();
				will(returnValue(messageType));
				oneOf(mockController).getErrorResponse();
				will(returnValue(errorResponse));
			}
		});

		if (null != mockRequest && null != mockResponse) {
			mockResponse.setRefId(mockRequest.getRefId());
		}
		logger.info(String.format("Request: %s", mockRequest));
		showProperties(mockRequest);
		logger.info(String.format("Response: %s", mockResponse));
		showProperties(mockResponse);
	}

	@SuppressWarnings("unchecked")
	protected <Q extends ANetApiRequest, S extends ANetApiResponse> IApiOperation<Q, S> getMockController() {
		return mockContext.mock(IApiOperation.class);
	}

	public static void showProperties(Object bean) {
		if (null == bean) {
			return;
		}
		try {
			BeanInfo info = Introspector.getBeanInfo(bean.getClass(), Object.class);
			PropertyDescriptor[] props = info.getPropertyDescriptors();
			for (PropertyDescriptor pd : props) {
				String name = pd.getName();
				Method getter = pd.getReadMethod();
				Class<?> type = pd.getPropertyType();

				if (null != getter && !"class".equals(name)) {
					Object value = getter.invoke(bean);
					logger.info(String.format("Type: '%s', Name:'%s', Value:'%s'", type, name, value));
					processCollections(type, name, value);
					// process compositions of custom classes
					if (null != value && 0 <= type.toString().indexOf("net.authorize.")) {
						showProperties(value);
					}
				}
			}
		} catch (Exception e) {
			logger.error(String.format("Exception during navigating properties: Message: %s, StackTrace: %s",
					e.getMessage(), e.getStackTrace()));
		}
	}

	public static void processCollections(Class<?> type, String name, Object value) {
		if (null != type) {
			if (Collection.class.isAssignableFrom(type)) {
				logger.info(String.format("Iterating on Collection: '%s'", name));
				for (Object aValue : (Collection<?>) value) {
					showProperties(aValue);
				}
			}
			if (Map.class.isAssignableFrom(type)) {
				logger.info(String.format("Iterating on Map: '%s'", name));
				for (Object aValue : ((Map<?, ?>) value).values()) {
					showProperties(aValue);
				}
			}
		}
	}
}

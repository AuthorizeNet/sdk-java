Authorize.Net Java SDK
======================
[![Build Status](https://travis-ci.org/AuthorizeNet/sdk-java.png?branch=master)]
(https://travis-ci.org/AuthorizeNet/sdk-java)
[![Code Climate](https://codeclimate.com/github/namanbansal/sdk-java/badges/gpa.svg)](https://codeclimate.com/github/namanbansal/sdk-java)
[![Maven Central](https://img.shields.io/maven-central/v/net.authorize/anet-java-sdk.svg?style=flat)](http://mvnrepository.com/artifact/net.authorize/anet-java-sdk)

```
  <groupId>net.authorize</groupId>
  <artifactId>anet-java-sdk</artifactId>
  <version>LATEST</version>
```

Prerequisites
=============

  * JDK 1.5.0 or higher
  * Ant 1.6.2 or higher (build SDK only)
  * Maven 2.2.0 or higher (build SDK only)

  Note: Support for building the SDK with either Ant or Maven has been made.
        Please see the respective build processes below.  All initial jars
        and docs were built with Ant however.

Dependencies
============

  * commons-logging-1.1.1.jar : logging
  * log4j-1.2.16.jar          : logging
  * httpclient-4.0.1.jar      : http communication with the payment gateway
  * httpcore-4.0.1.jar        : http communication with the payment gateway
  * junit-4.8.2.jar           : unit testing
  * hamcrest-core-1.3.jar     : unit testing
  * hamcrest-library-1.3.jar  : unit testing
  * jmock-2.6.0.jar           : unit testing

Build process
==============

  * Note:  To properly run the unit tests, please reference the
           anet-java-sdk.properties file, which is a simple properties file that
           holds the API credentials for testing the SDK.



  Build the SDK with Maven
  ------------------------

  To compile the SDK and create a jar...

    $ mvn clean package



  Build the SDK with Ant
  ----------------------

  To compile the SDK and create a jar...

    $ ant jar

  To run the unit tests...

    $ ant unit-test


  To create the javadocs...

    $ ant javadoc


Test Code - Payment Transactions
=============================================

**This API enables you to submit transaction requests to the payment gateway.**

There are some sample unit tests that are located in the test directory. They
capture basic auth/capture (product purchase) functionality, which most
integrations are looking to get started with. 

###Charge a credit card

A transaction to authorize and charge a credit card payment can be performed with 
the following code (JSP) :
````jsp
  <%@ page import = "java.math.BigDecimal" %>
  <%@ page import = "java.util.Map" %>
  <%@ page import = "net.authorize.Environment" %>
  <%@ page import = "net.authorize.api.contract.v1.*" %>
  <%@ page import = "net.authorize.api.controller.base.ApiOperationBase" %>
  <%@ page import = "net.authorize.api.controller.CreateTransactionController" %>
  <%
    // Set up the environment
	String apiLoginId 		= "YOUR_API_LOGIN_ID";
    String transactionKey 	= "YOUR_TRANSACTION_KEY";
    ApiOperationBase.setEnvironment(Environment.SANDBOX);

	// Provide the merchant credentials
    MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType() ;
    merchantAuthenticationType.setName(apiLoginId);
    merchantAuthenticationType.setTransactionKey(transactionKey);
    ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);

    // Populate the payment data
    PaymentType paymentType 	  = new PaymentType();
    CreditCardType creditCard 	= new CreditCardType();
    creditCard.setCardNumber("4111111111111111");
    creditCard.setExpirationDate("1220");
    paymentType.setCreditCard(creditCard);

    // Create the payment transaction request
    TransactionRequestType txnRequest = new TransactionRequestType();
    txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
    txnRequest.setPayment(paymentType);
    txnRequest.setAmount(new BigDecimal("500.00"));

    // Make the API Request
    CreateTransactionRequest apiRequest = new CreateTransactionRequest();
    apiRequest.setTransactionRequest(txnRequest);
    CreateTransactionController controller = new CreateTransactionController(apiRequest);
    controller.execute();

    CreateTransactionResponse apiResponse = controller.getApiResponse();

    if (apiResponse != null) {
        // If API response code is ok (transaction is successful), 
		// go ahead and check the transaction response
        if (apiResponse.getMessages().getResultCode() == MessageTypeEnum.OK) {

            TransactionResponse txnResponse = apiResponse.getTransactionResponse();
            if (txnResponse.getResponseCode().equals("1")) {
                 out.println(txnResponse.getResponseCode());
                 out.println("Successful Credit Card Transaction");
                 out.println("Auth Code: " + txnResponse.getAuthCode());
                 out.println("Transaction ID: " + txnResponse.getTransId());
            }
            else {
                 out.println("Failed Transaction. Response Code: " + 
											txnResponse.getResponseCode());
            }
        }
        else {
             out.println("Failed Transaction. Result Code:  " + 
				  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorCode() +
                  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorText());
        }
    }
  %>
````

###Capture a Previously Authorized Amount
A transaction to capture funds for a transaction that was previously authorized 
using `authOnlyTransaction` can be performed with the following code (JSP) :
````jsp
  <%@ page import = "java.math.BigDecimal" %>
  <%@ page import = "net.authorize.Environment" %>
  <%@ page import = "net.authorize.api.contract.v1.*" %>
  <%@ page import = "net.authorize.api.controller.base.ApiOperationBase" %>
  <%@ page import = "net.authorize.api.controller.CreateTransactionController" %>
  <%
    // Set up the environment
	String apiLoginId 		= "YOUR_API_LOGIN_ID";
    String transactionKey 	= "YOUR_TRANSACTION_KEY";    
	ApiOperationBase.setEnvironment(Environment.SANDBOX);

	// Provide the merchant credentials
    MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType() ;
	merchantAuthenticationType.setName(apiLoginId);
	merchantAuthenticationType.setTransactionKey(transactionKey);
	ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);

	// Create the payment transaction request
	TransactionRequestType txnRequest = new TransactionRequestType();
	txnRequest.setTransactionType(TransactionTypeEnum.PRIOR_AUTH_CAPTURE_TRANSACTION.value());
	txnRequest.setRefTransId("YOUR_TRANSACTION_ID");

	// Make the API Request
	CreateTransactionRequest apiRequest = new CreateTransactionRequest();
	apiRequest.setTransactionRequest(txnRequest);
	CreateTransactionController controller = new CreateTransactionController(apiRequest);
	controller.execute(); 

	CreateTransactionResponse apiResponse = controller.getApiResponse();

	if (apiResponse != null) {
		// If API response code is ok (transaction is successful), 
		// go ahead and check the transaction response
        if (apiResponse.getMessages().getResultCode() == MessageTypeEnum.OK) {

			TransactionResponse txnResponse = apiResponse.getTransactionResponse();
			if (txnResponse.getResponseCode().equals("1")) {
				out.println(txnResponse.getResponseCode());
				out.println("Successfully Captured Transaction");
				out.println("Auth Code: " + txnResponse.getAuthCode());
                out.println("Transaction ID: " + txnResponse.getTransId());
			}
			else {
				out.println("Failed Transaction. Response Code: " + 
											txnResponse.getResponseCode());
			}
		}
		else {
			out.println("Failed Transaction. Result Code:  " + 
				  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorCode() +
                  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorText());
		}
	}
  %>
````

Test Code - Recurring Billing
=============================================

**Recurring Billing API methods enable you to manage regular payment subscriptions.**

There are some sample unit tests that are located in the test directory. 
They capture basic create/update/cancel/get subscription recurring billing requests.

###Create a Subscription
For subscriptions with a monthly interval, whose payments begin on the 31st of a month, 
payments for months with fewer than 31 days occur on the last day of the month.

A transaction to create a new subscription can be performed with the following code (JSP) :
````jsp
  <%@ page import = "java.math.BigDecimal" %>
  <%@ page import = "net.authorize.Environment" %>
  <%@ page import = "net.authorize.api.contract.v1.*" %>
  <%@ page import = "net.authorize.api.controller.base.ApiOperationBase" %>
  <%@ page import = "net.authorize.api.controller.ARBCreateSubscriptionController" %>
  <%@ page import = "net.authorize.data.arb.*" %>
  <%@ page import = "net.authorize.data.Customer" %>
  <%@ page import = "javax.xml.datatype.*" %>
  <%@ page import = "java.lang.Exception.*" %>
  <%
    // Set up the environment
    String apiLoginId 		= "YOUR_API_LOGIN_ID";
    String transactionKey 	= "YOUR_TRANSACTION_KEY";
    ApiOperationBase.setEnvironment(Environment.SANDBOX);
	
    // Provide the merchant credentials
    MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType() ;
	merchantAuthenticationType.setName(apiLoginId);
	merchantAuthenticationType.setTransactionKey(transactionKey);
	ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);

	// Set up payment schedule
	PaymentScheduleType schedule 		 = new PaymentScheduleType();
	PaymentScheduleType.Interval interval = new PaymentScheduleType.Interval();
	interval.setLength((short)1);
	interval.setUnit(ARBSubscriptionUnitEnum.MONTHS);
	schedule.setInterval(interval);

	try {
	  XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar();
	  startDate.setDay(30);
	  startDate.setMonth(8);
	  startDate.setYear(2020);
	  schedule.setStartDate(startDate); //2020-08-30 
	}
	catch(Exception err) {
		out.println("Exception in calculating Dates: " + err.getMessage());
	}

	schedule.setTotalOccurrences((short)12);
	schedule.setTrialOccurrences((short)1);

	// Populate the payment data
	PaymentType paymentType 	  = new PaymentType();
	CreditCardType creditCard 	= new CreditCardType();
	creditCard.setCardNumber("4111111111111111");
	creditCard.setExpirationDate("1220");
	paymentType.setCreditCard(creditCard);

	// Create the billing info
	NameAndAddressType billInfo = new NameAndAddressType();
	billInfo.setFirstName("John");
	billInfo.setLastName("Doe");

	// Create the ARB subscription request
	ARBSubscriptionType arbSubscriptionType = new ARBSubscriptionType();
	arbSubscriptionType.setPaymentSchedule(schedule);
	arbSubscriptionType.setAmount(new BigDecimal("15.55"));
	arbSubscriptionType.setTrialAmount(new BigDecimal("0.00"));
	arbSubscriptionType.setPayment(paymentType);
	arbSubscriptionType.setBillTo(billInfo);

	// Make the API Request
	ARBCreateSubscriptionRequest apiRequest = new ARBCreateSubscriptionRequest();
	apiRequest.setSubscription(arbSubscriptionType);
	ARBCreateSubscriptionController controller = new ARBCreateSubscriptionController(apiRequest);
	controller.execute();
	
	ARBCreateSubscriptionResponse apiResponse = controller.getApiResponse();
	
	if (apiResponse != null) {
		 // If API response code is ok (transaction is successful), 
		 // go ahead and print the response details
	     if (apiResponse.getMessages().getResultCode() == MessageTypeEnum.OK) {
	        out.println("Successfully Created Subscription");
	        out.println("Subscription ID:  " + apiResponse.getSubscriptionId());
	        out.println("Message Code: " + apiResponse.getMessages().getMessage().get(0).getCode());
	        out.println("Message Text: " + apiResponse.getMessages().getMessage().get(0).getText());
	    }
	    else {
	        out.println("Failed to create Subscription:  " + 
				  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorCode() +
                  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorText());
	    }
	}	
  %>  
````

Test Code - PayPal Express Checkout
=============================================

**Use the following methods to process PayPal transactions.**

There are some sample unit tests that are located in the test directory. 
The following calls are createTransactionRequest calls with PayPal-specific fields.
You must first sign up for the service in the [Authorize.Net Merchant Interface](https://account.authorize.net). 
The sign up page is at Accounts > Digital Payment Solutions.

###Authorization Only
An Authorization Only request notifies PayPal that an authorization has been initiated 
but does not complete the authorization. It returns a secure URL with a token appended to it. 
The purpose of this token is to identify the transaction when the customer is redirected to PayPal.

A transaction of this type can be performed with the following code (JSP) :
````jsp
  <%@ page import = "java.math.BigDecimal" %>
  <%@ page import = "net.authorize.Environment" %>
  <%@ page import = "net.authorize.api.contract.v1.*" %>
  <%@ page import = "net.authorize.api.controller.base.ApiOperationBase" %>
  <%@ page import = "net.authorize.api.controller.CreateTransactionController" %>
  <%@ page import = "net.authorize.data.arb.*" %>
  <%@ page import = "net.authorize.data.Customer" %>
  <%@ page import = "javax.xml.datatype.*" %>
  <%@ page import = "java.lang.Exception.*" %>
  <%
    // Set up the environment
    String apiLoginId         = "YOUR_API_LOGIN_ID";
    String transactionKey     = "YOUR_TRANSACTION_KEY";
    ApiOperationBase.setEnvironment(Environment.SANDBOX);
    
    // Provide the merchant credentials
    MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType() ;
    merchantAuthenticationType.setName(apiLoginId);
    merchantAuthenticationType.setTransactionKey(transactionKey);
    ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);
    
    // Provide the PayPal settings
    PayPalType payPalType = new PayPalType();
    payPalType.setSuccessUrl("http://www.merchanteCommerceSite.com/Success/TC25262");
    payPalType.setCancelUrl("http://www.merchanteCommerceSite.com/Success/TC25262");
    
    PaymentType paymentType = new PaymentType();
    paymentType.setPayPal(payPalType);
    
    // Create the payment transaction request
    TransactionRequestType txnRequest = new TransactionRequestType();
    
    txnRequest.setTransactionType(TransactionTypeEnum.AUTH_ONLY_TRANSACTION.value());
    txnRequest.setPayment(paymentType);
    txnRequest.setAmount(new BigDecimal("11.89"));
    
    // Make the API Request
    CreateTransactionRequest apiRequest = new CreateTransactionRequest();
    apiRequest.setTransactionRequest(txnRequest);
    CreateTransactionController controller = new CreateTransactionController(apiRequest);
    controller.execute();
    
    CreateTransactionResponse apiResponse = controller.getApiResponse();
    
    // If API response code is ok (transaction is successful), 
    // go ahead and check the transaction response
    if (apiResponse.getMessages().getResultCode() == MessageTypeEnum.OK) {  
        if (apiResponse.getTransactionResponse() != null) {
            TransactionResponse txnResponse = apiResponse.getTransactionResponse();
            out.println("Successful Paypal Authorize Only Transaction");
            out.println("Response Code: " + txnResponse.getResponseCode());
            out.println("Transaction ID: " + txnResponse.getTransId());
            out.println("Secure Acceptance URL: " + 
                              txnResponse.getSecureAcceptance().getSecureAcceptanceUrl());
        }
    }
    else {
        out.println("Failed Paypal Authorize Only Transaction");
        if(!apiResponse.getMessages().getMessage().isEmpty()) {
            out.println("Error: " + apiResponse.getMessages().getMessage().get(0).getCode() + 
                              "  " + apiResponse.getMessages().getMessage().get(0).getText());
        }
    
        if (apiResponse.getTransactionResponse() != null) {
            if(!apiResponse.getTransactionResponse().getErrors().getError().isEmpty()) {
              out.println("Transaction Error : " + 
                  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorCode() +
                  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorText());
            }
        }
    }
  %>  
````

###Authorization and Capture
This type of transaction is the most common and is the default payment gateway transaction type. 
Like the Authorization Only request, it notifies PayPal that an Authorization and Capture transaction 
has been initiated, but does not complete the request. It also returns a secure URL with a token 
appended to it. The purpose of this token is to identify the transaction when the customer is 
redirected to PayPal.

A transaction of this type can be performed with the following code (JSP) :
````jsp
  <%@ page import = "java.math.BigDecimal" %>
  <%@ page import = "net.authorize.Environment" %>
  <%@ page import = "net.authorize.api.contract.v1.*" %>
  <%@ page import = "net.authorize.api.controller.base.ApiOperationBase" %>
  <%@ page import = "net.authorize.api.controller.CreateTransactionController" %>
  <%@ page import = "net.authorize.data.arb.*" %>
  <%@ page import = "net.authorize.data.Customer" %>
  <%@ page import = "javax.xml.datatype.*" %>
  <%@ page import = "java.lang.Exception.*" %>
  <%
    // Set up the environment
    String apiLoginId         = "YOUR_API_LOGIN_ID";
    String transactionKey     = "YOUR_TRANSACTION_KEY";
    ApiOperationBase.setEnvironment(Environment.SANDBOX);
    
    // Provide the merchant credentials
    MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType() ;
    merchantAuthenticationType.setName(apiLoginId);
    merchantAuthenticationType.setTransactionKey(transactionKey);
    ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);
    
    // Provide the PayPal settings
    PayPalType payPalType = new PayPalType();
    payPalType.setSuccessUrl("http://www.merchanteCommerceSite.com/Success/TC25262");
    payPalType.setCancelUrl("http://www.merchanteCommerceSite.com/Success/TC25262");
    
    PaymentType paymentType = new PaymentType();
    paymentType.setPayPal(payPalType);
    
    // Create the payment transaction request
    TransactionRequestType apiRequest = new TransactionRequestType();
    
    apiRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
    apiRequest.setPayment(paymentType);
    apiRequest.setAmount(new BigDecimal("11.89"));
    
    // Make the API Request
    CreateTransactionRequest apiRequest = new CreateTransactionRequest();
    apiRequest.setTransactionRequest(apiRequest);
    CreateTransactionController controller = new CreateTransactionController(apiRequest);
    controller.execute();
    
    CreateTransactionResponse apiResponse = controller.getApiResponse();
    
    // If API response code is ok (transaction is successful), 
    // go ahead and check the transaction response
    if (apiResponse.getMessages().getResultCode() == MessageTypeEnum.OK) {  
        if (apiResponse.getTransactionResponse() != null) {
            TransactionResponse txnResponse = apiResponse.getTransactionResponse();
            out.println("Successful Paypal Authorize Capture Transaction");
            out.println("Response Code: " + txnResponse.getResponseCode());
            out.println("Transaction ID: " + txnResponse.getTransId());
            out.println("Secure Acceptance URL: " + 
                              txnResponse.getSecureAcceptance().getSecureAcceptanceUrl());
        }
    }
    else {
        out.println("Failed Paypal Authorize Capture Transaction");
        if(!apiResponse.getMessages().getMessage().isEmpty()) {
            out.println("Error: " + apiResponse.getMessages().getMessage().get(0).getCode() + 
                              "  " + apiResponse.getMessages().getMessage().get(0).getText());
        }

        if (apiResponse.getTransactionResponse() != null) {
            if(!apiResponse.getTransactionResponse().getErrors().getError().isEmpty()) {
              out.println("Transaction Error : " + 
                  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorCode() +
                  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorText());
            }
        }
    }
  %>
````

Test Code - Customer Profiles
==============================================
**This API enables you to store customer payment and address data for subsequent use.**

There are some sample unit tests that are located in the test directory.  They
capture requests that create, delete, get, and update customer profile
information, including payment and address information.

###Create Customer Profile
Use this function to create a new customer profile including any customer 
payment profiles and customer shipping addresses. The createCustomerProfileResponse 
field returns the assigned customerProfileId element for the created profile.

A transaction of this type can be performed with the following code (JSP) :
````jsp
  <%@ page import = "java.math.BigDecimal" %>
  <%@ page import = "net.authorize.Environment" %>
  <%@ page import = "net.authorize.api.contract.v1.*" %>
  <%@ page import = "net.authorize.api.controller.base.ApiOperationBase" %>
  <%@ page import = "net.authorize.api.controller.CreateCustomerProfileController" %>
  <%@ page import = "net.authorize.data.arb.*" %>
  <%@ page import = "net.authorize.data.Customer" %>
  <%@ page import = "javax.xml.datatype.*" %>
  <%@ page import = "java.lang.Exception.*" %>
  <%
    // Set up the environment
    String apiLoginId         = "YOUR_API_LOGIN_ID";
    String transactionKey     = "YOUR_TRANSACTION_KEY";
    ApiOperationBase.setEnvironment(Environment.SANDBOX);

    // Provide the merchant credentials
    MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType() ;
    merchantAuthenticationType.setName(apiLoginId);
    merchantAuthenticationType.setTransactionKey(transactionKey);
    ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);

    // Populate the payment data
    PaymentType paymentType = new PaymentType();
	CreditCardType creditCard = new CreditCardType();
	creditCard.setCardNumber("4111111111111111");
  	creditCard.setExpirationDate("1220");
	paymentType.setCreditCard(creditCard);

	// Populate the request entriesCustomerPaymentProfileType
	// Payment Profile Type
	CustomerPaymentProfileType customerPaymentProfileType = new CustomerPaymentProfileType();
	customerPaymentProfileType.setCustomerType(CustomerTypeEnum.INDIVIDUAL);
	customerPaymentProfileType.setPayment(paymentType);

    // Profile Type
	CustomerProfileType customerProfileType = new CustomerProfileType();
    customerProfileType.setMerchantCustomerId("MERCHANT_CUSTOMER_ID");
    customerProfileType.setDescription("PROFILE_DESCRIPTION_HERE");	
    customerProfileType.setEmail("CUSTOMER_EMAIL@ABC.COM"); 
							// Email Id should be unique for the merchant	
    customerProfileType.getPaymentProfiles().add(customerPaymentProfileType);

    // Billing Info
	CustomerAddressType billingInfo = new CustomerAddressType();
    billingInfo.setFirstName("John");
    billingInfo.setLastName("Doe");
    billingInfo.setCompany("Company A");
    billingInfo.setAddress("123 Street");
    billingInfo.setCity("AnyCity");
    billingInfo.setState("CA");
    billingInfo.setCountry("US");
    billingInfo.setZip("90122");
    billingInfo.setPhoneNumber("415-555-1212");
    billingInfo.setFaxNumber("415-555-1313");
    customerProfileType.getShipToList().add(billingInfo);

    // Make the API Request
	CreateCustomerProfileRequest apiRequest = new CreateCustomerProfileRequest();
    apiRequest.setProfile(customerProfileType);
    apiRequest.setRefId("REF_ID");
    apiRequest.setValidationMode(ValidationModeEnum.TEST_MODE);
    CreateCustomerProfileController controller = new CreateCustomerProfileController(apiRequest);
    controller.execute();
    
	CreateCustomerProfileResponse apiResponse = controller.getApiResponse();
    
	if (apiResponse!=null) {
		// If API response code is ok (transaction is successful), 
        // go ahead and check the transaction response
        if (apiRequest.getMessages().getResultCode() == MessageTypeEnum.OK) {

            out.println("Profile ID: " + apiRequest.getCustomerProfileId());
            out.println("Payment Profiles: " + 
							apiRequest.getCustomerPaymentProfileIdList().getNumericString().get(0));
            out.println("Shipping Address: " + 
							apiRequest.getCustomerShippingAddressIdList().getNumericString().get(0));
            out.println(apiRequest.getValidationDirectResponseList().getString().get(0));
        }
        else {
            out.println("Failed to create customer profile: " + 
			      apiRequest.getTransactionResponse().getErrors().getError().get(0).getErrorCode() +
                  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorText());
        }
    }
  %>  
````

Test Code - Transaction Reporting
==============================================
**Enables developers to access transaction history and details programmatically**

There are some sample unit tests that are located in the test directory.  They
capture requests that retrieve transaction data that was processed by Authorize.Net.

###Get Transaction Details
Use this function to get detailed information about a specific transaction.

A transaction of this type can be performed with the following code (JSP) :
````jsp
  <%@ page import = "java.math.BigDecimal" %>
  <%@ page import = "net.authorize.Environment" %>
  <%@ page import = "net.authorize.api.contract.v1.*" %>
  <%@ page import = "net.authorize.api.controller.base.ApiOperationBase" %>
  <%@ page import = "net.authorize.api.controller.GetTransactionDetailsController" %>
  <%
    // Set up the environment
    String apiLoginId         = "YOUR_API_LOGIN_ID";
    String transactionKey     = "YOUR_TRANSACTION_KEY";
    ApiOperationBase.setEnvironment(Environment.SANDBOX);

    // Provide the merchant credentials
    MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType() ;
    merchantAuthenticationType.setName(apiLoginId);
	merchantAuthenticationType.setTransactionKey(transactionKey);
	ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);

	// Provide a VALID transaction ID   
	String transId = "TRANSACTION_ID";

	// Make the API Request
    GetTransactionDetailsRequest getRequest = new GetTransactionDetailsRequest();
	getRequest.setMerchantAuthentication(merchantAuthenticationType);
	getRequest.setTransId(transId);   
	GetTransactionDetailsController controller = new GetTransactionDetailsController(getRequest);
	controller.execute();
	
	GetTransactionDetailsResponse apiResponse = controller.getApiResponse();

   if (apiResponse != null) {
		// If API response code is ok (transaction is successful), 
        // go ahead and check the transaction response
        if (apiResponse.getMessages().getResultCode() == MessageTypeEnum.OK) {

			out.println(apiResponse.getMessages().getMessage().get(0).getCode());
			out.println(apiResponse.getMessages().getMessage().get(0).getText());
			
			// Any other required fields can be accessed from the transaction response
			// present in the API response.
			// To access the transaction response, use the getTransactionResponse().
		}
		else
		{
			out.println("Failed to get transaction details: " + 
				  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorCode() +
                  apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorText());
		}
	}
  %>
````

Test Code - Apple Pay
==============================================
**Enables you to pass Apple Pay payment data to Authorize.Net.**

Apple Pay support is available through the SDK using our new model 
and code samples.

###Create a Apple Pay Transaction
Use this function to create an Authorize.Net payment transaction request 
using Apple Pay Opaque data in place of card data. 

**_Data Value (Apple Pay Blob) is one-time use value._**

A transaction of this type can be performed with the following code (JSP) :

````jsp
<%@ page import = "java.math.BigDecimal" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "net.authorize.Environment" %>
<%@ page import = "net.authorize.api.contract.v1.*" %>
<%@ page import = "net.authorize.api.controller.base.ApiOperationBase" %>
<%@ page import = "net.authorize.api.controller.CreateTransactionController" %>

<%
        MerchantAuthenticationType appleMerchAuthenticationType = new MerchantAuthenticationType();
        appleMerchAuthenticationType.setName("YOUR_API_LOGIN_ID");
        appleMerchAuthenticationType.setTransactionKey("YOUR_TRANSACTION_KEY");

        ApiOperationBase.setEnvironment(Environment.SANDBOX);
        ApiOperationBase.setMerchantAuthentication(appleMerchAuthenticationType);

        PaymentType paymentType = new PaymentType();
        OpaqueDataType op = new OpaqueDataType();
        op.setDataDescriptor("COMMON.APPLE.INAPP.PAYMENT");
        op.setDataValue("YOUR_APPLE_PAY_BLOB_HERE");
        paymentType.setOpaqueData(op);


        TransactionRequestType txnRequest = new TransactionRequestType();
        txnRequest.setTransactionType(TransactionTypeEnum.AUTH_ONLY_TRANSACTION.value());
        txnRequest.setPayment(paymentType);
        txnRequest.setAmount(new BigDecimal(System.currentTimeMillis() % 100));

        CreateTransactionRequest apiRequest = new CreateTransactionRequest();
        apiRequest.setTransactionRequest(txnRequest);

        CreateTransactionController controller = new CreateTransactionController(apiRequest);
        controller.execute();
        CreateTransactionResponse apiResponse = controller.getApiResponse();
      
       if (apiResponse!=null) {

           TransactionResponse result = apiResponse.getTransactionResponse();

           if (result.getResponseCode().equals("1")) {
               out.println(result.getResponseCode());
               out.println("Successful ApplePay Transaction ");
               out.println("Auht Code : "+result.getAuthCode());
               out.println("Transaction ID: "+result.getTransId());
           }
           else
           {
              out.println("Failed Transaction. <br/> Result Code :  " + apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorCode() + " <br/> "+ apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorText());
           }
       }
       else{
        out.println("Error processing the Transaction ..");
     }

%>
````


Test Code - Visa Checkout
==============================================
**Enables you to pass Visa Checkout payment data to Authorize.Net.**

Visa Checkout support is also available through the SDK using our new model 
and code samples.

###Create a Visa Checkout Transaction
Use this function to create an Authorize.Net payment transaction request 
using Visa Checkout data in place of card data. 

**_Data Value, Data Key and Call ID are one-time use values._**

A transaction of this type can be performed with the following code (JSP) :
````jsp
  <%@ page import = "java.math.BigDecimal" %>
  <%@ page import = "java.util.Map" %>
  <%@ page import = "net.authorize.Environment" %>
  <%@ page import = "net.authorize.api.contract.v1.MerchantAuthenticationType" %>
  <%@ page import = "net.authorize.api.contract.v1.PaymentType" %>
  <%@ page import = "net.authorize.api.contract.v1.OpaqueDataType" %>
  <%@ page import = "net.authorize.api.contract.v1.TransactionRequestType" %>
  <%@ page import = "net.authorize.api.contract.v1.CreateTransactionRequest" %>
  <%@ page import = "net.authorize.api.contract.v1.CreateTransactionResponse" %>
  <%@ page import = "net.authorize.api.contract.v1.MessageTypeEnum" %>
  <%@ page import = "net.authorize.api.contract.v1.TransactionResponse" %>
  <%@ page import = "net.authorize.api.contract.v1.TransactionTypeEnum" %>
  <%@ page import = "net.authorize.api.controller.base.ApiOperationBase" %>
  <%@ page import = "net.authorize.api.controller.CreateTransactionController" %>
  
  <%
    // Set up the environment
    String apiLoginId         = "YOUR_API_LOGIN_ID";
    String transactionKey     = "YOUR_TRANSACTION_KEY";
    ApiOperationBase.setEnvironment(Environment.SANDBOX);
    
    // Provide the merchant credentials
    MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType();
    merchantAuthenticationType.setName(apiLoginId);
    merchantAuthenticationType.setTransactionKey(transactionKey);
    ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);
    
    // Populate the payment data
    PaymentType paymentType = new PaymentType();
    OpaqueDataType opaqueData = new OpaqueDataType();
    opaqueData.setDataDescriptor("COMMON.VCO.ONLINE.PAYMENT");
    opaqueData.setDataValue("SET_DATA_VALUE_HERE");
    
      opaqueData.setDataKey("SET_DATA_KEY_HERE");
    paymentType.setOpaqueData(opaqueData);
    
    // Create the payment transaction request
    TransactionRequestType txnRequest = new TransactionRequestType();
    txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
    txnRequest.setPayment(paymentType);
    txnRequest.setCallId("SET_VALID_CALL_ID_HERE");
    
    // Make the API Request
    CreateTransactionRequest apiRequest = new CreateTransactionRequest();
    apiRequest.setTransactionRequest(txnRequest);
    CreateTransactionController controller = new CreateTransactionController(apiRequest);
    controller.execute();
    
    CreateTransactionResponse apiResponse = controller.getApiResponse();
    
    if (apiResponse != null) {
    	// If API response code is ok (transaction is successful), 
    	// go ahead and check the transaction response
    	if (apiResponse.getMessages().getResultCode() == MessageTypeEnum.OK) {
    
    		TransactionResponse txnResponse = apiResponse.getTransactionResponse();
    		if (txnResponse.getResponseCode().equals("1")) {
    			out.println(txnResponse.getResponseCode());
    			out.println("Successful Visa Checkout Transaction");
    			out.println(txnResponse.getAuthCode());
    			out.println(txnResponse.getTransId());
    		} 
    		else {
    			out.println("Failed Transaction: " + txnResponse.getResponseCode());
    		}
    	}
    	 
    	else {
    		out.println("Failed Transaction: " + 
    			apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorCode() +
    			apiResponse.getTransactionResponse().getErrors().getError().get(0).getErrorText());
    	}
    }
  %>
````

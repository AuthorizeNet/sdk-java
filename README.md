Authorize.Net Java SDK
======================
[![Build Status](https://travis-ci.org/AuthorizeNet/sdk-java.png?branch=future)]
(https://travis-ci.org/AuthorizeNet/sdk-java)

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

The SDK is offered with very few dependencies.

  * commons-logging-1.1.1.jar : logging
  * log4j-1.2.16.jar          : logging
  * httpclient-4.0.1.jar      : http communication with the payment gateway
  * httpcore-4.0.1.jar        : http communication with the payment gateway
  * junit-4.8.2.jar           : unit testing

Build process
==============

  * Note:  To properly run the unit tests, please reference the
           anet_java_sdk.properties.example file, which is a simple properties file that
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


Test Code - Advanced Integration Method (AIM)
=============================================

There are some sample unit tests that are located in the test directory.  They
capture basic auth/capture (product purchase) functionality, which most
integrations are looking to get started with.

A simple auth/capture can be performed with the following code (JSP) :

  <%@ page import="java.math.BigDecimal" %>
  <%@ page import="java.util.Map" %>
  <%@ page import="net.authorize.Environment" %>
  <%@ page import="net.authorize.Merchant" %>
  <%@ page import="net.authorize.TransactionType" %>
  <%@ page import="net.authorize.aim.Result" %>
  <%@ page import="net.authorize.aim.Transaction" %>
  <%@ page import="net.authorize.data.*" %>
  <%@ page import="net.authorize.data.creditcard.*" %>
  <%
    String apiLoginID = "YOUR_API_LOGIN_ID";
    String transactionKey = "YOUR_TRANSACTION_KEY";
    Merchant merchant = Merchant.createMerchant(Environment.SANDBOX,
        apiLoginID, transactionKey);

    // create credit card
    CreditCard creditCard = CreditCard.createCreditCard();
    creditCard.setCreditCardNumber("4111 1111 1111 1111");
    creditCard.setExpirationMonth("12");
    creditCard.setExpirationYear("2015");

    // create transaction
    Transaction authCaptureTransaction = merchant.createAIMTransaction(
        TransactionType.AUTH_CAPTURE, new BigDecimal(1.99));
    authCaptureTransaction.setCreditCard(creditCard);

    Result<Transaction> result = (Result<Transaction>)merchant
        .postTransaction(authCaptureTransaction);

    if(result.isApproved()) {
      out.println("Approved!</br>");
      out.println("Transaction Id: " + result.getTarget().getTransactionId());
    } else if (result.isDeclined()) {
      out.println("Declined.</br>");
      out.println(result.getReasonResponseCode() + " : " + result.getResponseText());
    } else {
      out.println("Error.</br>");
      out.println(result.getReasonResponseCode() + " : " + result.getResponseText());
    }
  %>

Test Code - Advanced Integration Method (AIM) + Card Present
============================================================

There are some sample unit tests that are located in the test directory.  Similar
to the AIM test, however they leverage the Card Present API.

A simple auth/capture can be performed with the following code (JSP) :

  <%@ page import="java.math.BigDecimal" %>
  <%@ page import="java.util.Map" %>
  <%@ page import="net.authorize.Environment" %>
  <%@ page import="net.authorize.Merchant" %>
  <%@ page import="net.authorize.TransactionType" %>
  <%@ page import="net.authorize.aim.cardpresent.Result" %>
  <%@ page import="net.authorize.aim.Transaction" %>
  <%@ page import="net.authorize.data.*" %>
  <%@ page import="net.authorize.data.creditcard.*" %>
  <%
    String apiLoginID = "YOUR_API_LOGIN_ID";
    String transactionKey = "YOUR_TRANSACTION_KEY";
    String MD5Value = "MD5_VALUE";
    Merchant merchant = Merchant.createMerchant(Environment.SANDBOX,
        apiLoginID, transactionKey);
    merchant.setDeviceType(net.authorize.DeviceType.VIRTUAL_TERMINAL);
    merchant.setMarketType(net.authorize.MarketType.RETAIL);
    merchant.setMD5Value(MD5Value);

    // create credit card
    CreditCard creditCard = CreditCard.createCreditCard();
    creditCard.setCardType(CardType.VISA);
    creditCard.setTrack1("%B4111111111111111^CARDUSER/JOHN^1803101000000000020000831000000?");
    creditCard.setTrack2(";4111111111111111=1803101000020000831?");

    // create transaction
    Transaction authCaptureTransaction = merchant.createAIMTransaction(
        TransactionType.AUTH_CAPTURE, new BigDecimal(1.99));
    authCaptureTransaction.setCreditCard(creditCard);

    Result<Transaction> result = (Result<Transaction>)merchant
        .postTransaction(authCaptureTransaction);

    if(result.isApproved()) {
      out.println("Approved!</br>");
      out.println("Transaction Id: " + result.getTransId());
    } else if (result.isDeclined()) {
      out.println("Declined.</br>");
      out.println(result.getResponseReasonCodes().get(0) + " : " +
        result.getResponseReasonCodes().get(0).getReasonText());
    } else {
      out.println("Error.</br>");
      out.println(result.getResponseReasonCodes().get(0) + " : " +
        result.getResponseReasonCodes().get(0).getReasonText());
    }
  %>

Test Code - Server Integration Method (SIM)
===========================================

The SDK implementation for SIM is fairly concise.  To easily create a finger-
print for your form POST, you can reference the following code :

    Fingerprint fingerprint = Fingerprint.createFingerprint(
        "YOUR_API_LOGIN_ID",
        "YOUR_TRANSACTION_KEY",
        1234567890,
        "AMOUNT");

    String x_fp_sequence = fingerprint.getSequence();
    String x_fp_timestamp = fingerprint.getTimeStamp();
    String x_fp_hash = fingerprint.getFingerprintHash();


Parsing a Relay Response is performed by using the ResponseParser class.
It takes as it's only method parameter a pipe (|) delimited string
that represents the transaction response passed to the merchant by
Authorize.net.

    HashMap<ResponseField, String> responseMap =
        ResponseParser.parseResponseString(responseString);

Setting up the necessary data containers and getting a form that can be
displayed directly on the page can be performed via the following code (JSP) :

  <%@ page import="net.authorize.sim.*" %>
  <%@ page import="net.authorize.sim.button.*" %>
  <%@ page import="net.authorize.data.*" %>
  <%@ page import="net.authorize.data.creditcard.*" %>
  <%
          String apiLoginID = "YOUR_API_LOGIN_ID";
          String transactionKey = "YOUR_TRANSACTION_KEY";
          String amount = "1.99";
          Fingerprint fingerprint = Fingerprint.createFingerprint(
              apiLoginID,
              transactionKey,
              1234567890,
              amount);
          long x_fp_sequence = fingerprint.getSequence();
          long x_fp_timestamp = fingerprint.getTimeStamp();
          String x_fp_hash = fingerprint.getFingerprintHash();
  %>

    <FORM NAME='formName' ID='formID' ACTION='https://test.authorize.net/gateway/transact.dll' METHOD='POST'>
      <INPUT TYPE='HIDDEN' NAME='x_login' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(apiLoginID)%>'>
      <INPUT TYPE='HIDDEN' NAME='x_fp_sequence' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(Long.toString(x_fp_sequence))%>'>
      <INPUT TYPE='HIDDEN' NAME='x_fp_timestamp' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(Long.toString(x_fp_timestamp))%>'>
      <INPUT TYPE='HIDDEN' NAME='x_fp_hash' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(x_fp_hash)%>'>
      <INPUT TYPE='HIDDEN' NAME='x_version' VALUE='3.1'>
      <INPUT TYPE='HIDDEN' NAME='x_method' VALUE='CC'>
      <INPUT TYPE='HIDDEN' NAME='x_type' VALUE='AUTH_CAPTURE'>
      <INPUT TYPE='TEXT' NAME='x_amount' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(amount)%>'>
      <INPUT TYPE='HIDDEN' NAME='x_show_form' VALUE='payment_form'>
      <INPUT TYPE='HIDDEN' NAME='x_test_request' VALUE='FALSE'>
      <INPUT TYPE='SUBMIT' NAME='submit_button' VALUE='Submit' CLASS='null'>
    </FORM>


If you were to load this JSP in your browser and hit submit, you should be taken
to a page on the Authorize.Net servers that contains a form asking for payment
information to be submitted.


Test Code - Direct Post Method (DPM)
====================================

* This method is implemented via three code snippets.  First, create the page
that will host the form that will be submitted.  We're calling this form.jsp,
and you will be required to enter in your API_LOGIN_ID, TRANSACTION_KEY, and
your public facing MERCHANT_HOST domain name.  Note, you may want to alter the
relayResponseUrl and place the jsp in a separate webapp container of your
choosing.

  ========
  form.jsp
  ========

  <%@ page import="net.authorize.sim.*" %>
  <%
     String apiLoginId = "YOUR_API_LOGIN_ID";
     String transactionKey = "YOUR_TRANSACTION_KEY";
     String relayResponseUrl = "http://MERCHANT_HOST/relay_response.jsp";

     String amount = "1.99";
     Fingerprint fingerprint = Fingerprint.createFingerprint(
         apiLoginId,
         transactionKey,
         1234567890,  // random sequence used for the finger print creation
         amount);

     long x_fp_sequence = fingerprint.getSequence();
     long x_fp_timestamp = fingerprint.getTimeStamp();
     String x_fp_hash = fingerprint.getFingerprintHash();
  %>

  <FORM NAME='secure_redirect_form' ID='secure_redirect_form_id' ACTION='https://test.authorize.net/gateway/transact.dll' METHOD='POST'>
   <label>CreditCardNumber</label><input type='text' class='text' name='x_card_num' size='15'></input>
   <label>Exp.</label><input type='text' class='text' name='x_exp_date' size='4'></input>
   <label>Amount</label><input type='text' class='text' name='x_amount' size='9' readonly value='<%=net.authorize.util.StringUtils.sanitizeString(amount)%>'></input>
   <INPUT TYPE='HIDDEN' NAME='x_invoice_num' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(Long.toString(System.currentTimeMillis()))%>'>
   <INPUT TYPE='HIDDEN' NAME='x_relay_url' VALUE='<%=relayResponseUrl%>'>
   <INPUT TYPE='HIDDEN' NAME='x_login' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(apiLoginId)%>'>
   <INPUT TYPE='HIDDEN' NAME='x_fp_sequence' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(Long.toString(x_fp_sequence))%>'>
   <INPUT TYPE='HIDDEN' NAME='x_fp_timestamp' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(Long.toString(x_fp_timestamp))%>'>
   <INPUT TYPE='HIDDEN' NAME='x_fp_hash' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(x_fp_hash)%>'>
   <INPUT TYPE='HIDDEN' NAME='x_version' VALUE='3.1'>
   <INPUT TYPE='HIDDEN' NAME='x_method' VALUE='CC'>
   <INPUT TYPE='HIDDEN' NAME='x_type' VALUE='AUTH_CAPTURE'>
   <INPUT TYPE='HIDDEN' NAME='x_amount' VALUE='<%=net.authorize.util.StringUtils.sanitizeString(amount)%>'>
   <INPUT TYPE='HIDDEN' NAME='x_test_request' VALUE='FALSE'>
   <INPUT TYPE='HIDDEN' NAME='notes' VALUE='extra hot please'>
   <INPUT TYPE='SUBMIT' NAME='buy_button' VALUE='BUY'>
  </FORM>


* Create a page that will receive the response.  We're calling this
relay_response.jsp (referenced in the form above by the relayResponseUrl).
Once again, you will be required to enter in your API_LOGIN_ID and your public
facing MERCHANT_HOST domain name.  Additionally, you will have to provide your
MD5_HASH_KEY.  Unless you have explicitly set this in the merchant interface:
Account > Settings > Security Settings > MD5-Hash, leave this as an empty
string.

  ==================
  relay_response.jsp
  ==================

  <%@ page import="java.util.Map" %>
  <%@ page import="net.authorize.*" %>

  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
   <head>
   </head>
   <body>
   <script type="text/javascript">
   <!--
     var referrer = document.referrer;
     if (referrer.substr(0,7)=="http://") referrer = referrer.substr(7);
     if (referrer.substr(0,8)=="https://") referrer = referrer.substr(8);
     if(referrer && referrer.indexOf(document.location.hostname) != 0) {
  <%
     String apiLoginId = "YOUR_API_LOGIN_ID";
     String receiptPageUrl = "http://MERCHANT_HOST/order_receipt.jsp";
     /*
      * Leave the MD5HashKey as is - empty string, unless you have explicitly set it in the merchant interface:
      *   Account > Settings > Security Settings > MD5-Hash
      */
     String MD5HashKey = "";

     net.authorize.sim.Result result = net.authorize.sim.Result.createResult(apiLoginId, MD5HashKey, request.getParameterMap());
     // perform Java server side processing...
     // ...
     // build receipt url buffer
     StringBuffer receiptUrlBuffer = new StringBuffer(receiptPageUrl);

     if(result != null) {
       receiptUrlBuffer.append("?");
       receiptUrlBuffer.append(ResponseField.RESPONSE_CODE.getFieldName()).append("=");
       receiptUrlBuffer.append(result.getResponseCode().getCode());
       receiptUrlBuffer.append("&");
       receiptUrlBuffer.append(ResponseField.RESPONSE_REASON_CODE.getFieldName()).append("=");
       receiptUrlBuffer.append(result.getReasonResponseCode().getResponseReasonCode());
       receiptUrlBuffer.append("&");
       receiptUrlBuffer.append(ResponseField.RESPONSE_REASON_TEXT.getFieldName()).append("=");
       receiptUrlBuffer.append(result.getResponseMap().get(ResponseField.RESPONSE_REASON_TEXT.getFieldName()));

       if(result.isApproved()) {
         receiptUrlBuffer.append("&").append(ResponseField.TRANSACTION_ID.getFieldName()).append("=");
         receiptUrlBuffer.append(result.getResponseMap().get(ResponseField.TRANSACTION_ID.getFieldName()));
       }
     }
  %>
     // Use Javascript to redirect the page to the receipt redirect url.  If Javascript is not
     // available, then the <meta> refresh tag will handle the redirect.
     document.location = "<%=receiptUrlBuffer.toString()%>";
    }
  //-->
  </script>
  <noscript><meta http-equiv="refresh" content="0;url=<%=receiptUrlBuffer.toString()%>"></noscript>
  </body>
  </html>


* Create a page, called order_receipt.jsp, that will host the receipt
information.  This is what the user will finally see.

  =================
  order_receipt.jsp
  =================

  <%@ page import="java.util.Map" %>
  <%@ page import="net.authorize.*" %>

  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
   <head>
   </head>
   <body>
   <h1>Your Receipt Page</h1></br>
  <%
   // Show the confirmation data
   Map<String, String[]> requestParameterMap = request.getParameterMap();

   if(requestParameterMap != null && requestParameterMap.containsKey(ResponseField.RESPONSE_CODE.getFieldName())) {
     String transactionId = "";
     if(requestParameterMap.containsKey(ResponseField.TRANSACTION_ID.getFieldName())) {
       transactionId = requestParameterMap.get(ResponseField.TRANSACTION_ID.getFieldName())[0];
     }

     // 1 means we have a successful transaction
     if("1".equals(requestParameterMap.get(ResponseField.RESPONSE_CODE.getFieldName())[0])) {
  %>
     <h2>Success!</h2>
     <h3>Your transaction ID:</h3>
     <div><%=net.authorize.util.StringUtils.sanitizeString(transactionId)%></div>
  <%
     } else {
  %>
     <h2>Error!</h2>
     <h3><%=net.authorize.util.StringUtils.sanitizeString(
      requestParameterMap.get(ResponseField.RESPONSE_REASON_TEXT.getFieldName())[0])%></h3>
       <table>
         <tr>
           <td>response code</td>
           <td><%=net.authorize.util.StringUtils.sanitizeString(
             requestParameterMap.get(ResponseField.RESPONSE_CODE.getFieldName())[0])%></td>
         </tr>
             <tr>
           <td>response reason code</td>
           <td><%=net.authorize.util.StringUtils.sanitizeString(requestParameterMap.get(ResponseField.RESPONSE_REASON_CODE.getFieldName())[0])%></td>
         </tr>
     </table>
     </div>
  <%
     }
   }
  %>
  </body>
  </html>


Upon loading form.jsp and following the steps, you should have been able to
successfully enter in your credit card information hit submit and receive a
success or error message that is hosted on your merchant server.

Test Code - Automated Recurring Billing (ARB)
=============================================

There are some sample unit tests that are located in the test directory.  They
capture basic create/update/cancel/get subscription recurring billing requests.

A simple subscription creation can be performed with the following code (JSP) :

  <%@ page import="java.math.BigDecimal" %>
  <%@ page import="net.authorize.Merchant" %>
  <%@ page import="net.authorize.Environment" %>
  <%@ page import="net.authorize.Transaction" %>
  <%@ page import="net.authorize.arb.*" %>
  <%@ page import="net.authorize.xml.Message" %>
  <%@ page import="net.authorize.data.xml.*" %>
  <%@ page import="net.authorize.data.arb.*" %>
  <%@ page import="net.authorize.data.creditcard.CreditCard" %>

  <%
    String apiLoginID = "YOUR_API_LOGIN_ID";
    String transactionKey = "YOUR_TRANSACTION_KEY";
    Merchant merchant = Merchant.createMerchant(Environment.SANDBOX,
                apiLoginID, transactionKey);

    PaymentSchedule new_schedule = PaymentSchedule.createPaymentSchedule();
    new_schedule.setIntervalLength(1);
    new_schedule.setSubscriptionUnit(SubscriptionUnitType.MONTHS);
    new_schedule.setStartDate("2019-01-01");
    new_schedule.setTotalOccurrences(7);
    new_schedule.setTrialOccurrences(0);

    // Create a new credit card
    //
    CreditCard credit_card = CreditCard.createCreditCard();
    credit_card.setCreditCardNumber("4111 1111 1111 1111");
    credit_card.setExpirationDate("2029-07");

    // Create a billing info
    //
    Address billing_info = Address.createAddress();
    billing_info.setFirstName("Test " + System.currentTimeMillis());
    billing_info.setLastName("Tester");

    // Create a customer and specify billing info
    //
    Customer customer = Customer.createCustomer();
    customer.setBillTo(billing_info);

    // Create a subscription and specify payment, schedule and customer
    //
    Subscription subscription = Subscription.createSubscription();
    subscription.setPayment(Payment.createPayment(credit_card));
    subscription.setSchedule(new_schedule);
    subscription.setCustomer(customer);
      subscription.setAmount(new BigDecimal(6.00));
    subscription.setTrialAmount(Transaction.ZERO_AMOUNT);
    subscription.setRefId("REF:" + System.currentTimeMillis());
    subscription.setName("Demo Subscription " + System.currentTimeMillis());

    net.authorize.arb.Transaction transaction =
        merchant.createARBTransaction(TransactionType.CREATE_SUBSCRIPTION,
            subscription);
    Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(transaction);

    out.println("Result Code: " + (result.getResultCode() != null ? result.getResultCode() : "No result code") + "<br/>");
    out.println("Result Subscription Id: " + result.getResultSubscriptionId() + "<br/>");
    for(int i = 0; i < result.getMessages().size(); i++){
      Message message = (Message)result.getMessages().get(i);
      out.println("Message code/text: " + message.getCode() + " - " + message.getText() + "<br/>");
    }
  %>


Test Code - Customer Information Manager (CIM)
==============================================

There are some sample unit tests that are located in the test directory.  They
capture requests that create, delete, get, and update customer profile
information, including payment and address information.

A simple customer profile can be created with the following code (JSP) :

  <%@ page import="net.authorize.Merchant" %>
  <%@ page import="net.authorize.Environment" %>
  <%@ page import="net.authorize.Transaction" %>
  <%@ page import="net.authorize.cim.*" %>
  <%@ page import="net.authorize.data.cim.*" %>
  <%@ page import="net.authorize.data.xml.*" %>
  <%@ page import="net.authorize.xml.Message" %>
  <%@ page import="net.authorize.data.creditcard.CreditCard" %>

  <%
    String apiLoginID = "YOUR_API_LOGIN_ID";
    String transactionKey = "YOUR_TRANSACTION_KEY";
    Merchant merchant = Merchant.createMerchant(Environment.SANDBOX,
                apiLoginID, transactionKey);

    CustomerProfile customerProfile = CustomerProfile.createCustomerProfile();
    customerProfile.setDescription("Customer A");
    customerProfile.setMerchantCustomerId("123456789");
    customerProfile.setEmail("customer@merchant.com");

    Address billingInfo = Address.createAddress();
    billingInfo.setFirstName("Joe");
    billingInfo.setLastName("Test");
    billingInfo.setCompany("CompanyA");
    billingInfo.setAddress("123 Street");
    billingInfo.setCity("AnyCity");
    billingInfo.setState("CA");
    billingInfo.setCountry("US");
    billingInfo.setZipPostalCode("90123");
    billingInfo.setPhoneNumber("415-555-1212");
    billingInfo.setFaxNumber("415-555-1313");

    CreditCard creditCard = CreditCard.createCreditCard();
    creditCard.setCreditCardNumber("4111111111111111");
    creditCard.setExpirationDate("2029-07");

    PaymentProfile paymentProfile = PaymentProfile.createPaymentProfile();
    paymentProfile.setBillTo(billingInfo);
    paymentProfile.addPayment(Payment.createPayment(creditCard));
    paymentProfile.setCustomerType(CustomerType.INDIVIDUAL);

    // Create a new customer profile
    net.authorize.cim.Transaction transaction =
      merchant.createCIMTransaction(TransactionType.CREATE_CUSTOMER_PROFILE);
    transaction.setRefId(Long.toString(System.currentTimeMillis()));
    transaction.setCustomerProfile(customerProfile);
    transaction.addPaymentProfile(paymentProfile);
    transaction.setValidationMode(ValidationModeType.TEST_MODE);

    Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(transaction);

    out.println("Result Code: " + (result.getResultCode() != null ? result.getResultCode() : "No result code") + "<br>");
    if(result.getCustomerProfileId() != null){
      out.println("Result customerProfile Id: " + result.getCustomerProfileId() + "<br>");
    }
    for(int i = 0; i < result.getMessages().size(); i++){
      Message message = (Message)result.getMessages().get(i);
      out.println(message.getCode() + " - " + message.getText() + "<br>");
    }
  %>


Test Code - Transaction Details
===============================

There are some sample unit tests that are located in the test directory.  They
capture requests that retrieve transaction data that was processed by Authorize.Net.

A simple batch list request can be created with the following code (JSP) :

  <%@ page import="net.authorize.Merchant" %>
  <%@ page import="net.authorize.Environment" %>
  <%@ page import="net.authorize.Transaction" %>
  <%@ page import="net.authorize.reporting.*" %>

  <%
    String apiLoginID = "YOUR_API_LOGIN_ID";
    String transactionKey = "YOUR_TRANSACTION_KEY";

    Merchant merchant = Merchant.createMerchant(Environment.SANDBOX,
                apiLoginID, transactionKey);

    net.authorize.reporting.Transaction transaction = merchant.createReportingTransaction(net.authorize.reporting.TransactionType.GET_SETTLED_BATCH_LIST);
    net.authorize.data.xml.reporting.ReportingDetails reportingDetails = net.authorize.data.xml.reporting.ReportingDetails.createReportingDetails();
    reportingDetails.setBatchIncludeStatistics(true);
    transaction.setReportingDetails(reportingDetails);

    Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(transaction);

    out.println("Result Code: " + (result.getResultCode() != null ? result.getResultCode() : "No result code") + "<br>");
    for(net.authorize.data.xml.reporting.BatchDetails batchDetail : result.getReportingDetails().getBatchDetailsList()) {
      out.println("<hr/>");
      out.println("* id: " + batchDetail.getBatchId() + "<br>");
      out.println("* settlementState: " + batchDetail.getSettlementState().value() + "<br>");
      out.println("* local settlementTime: " + batchDetail.getSettlementTimeLocal().toString() + "<br>");
      out.println("* UTC settlementTime: " + batchDetail.getSettlementTimeUTC().toString() + "<br>");
      out.println("* paymentMethod: " + batchDetail.getPaymentMethod() + "<br>");
      for(net.authorize.data.xml.reporting.BatchStatistics batchStat :batchDetail.getBatchStatisticsList()) {
        out.println("<table>");
        out.println("<tr><td>accountType</td><td>" + batchStat.getAccountType()+"</td>");
        out.println("<tr><td>chargeAmount</td><td>" + batchStat.getChargeAmount()+"</td>");
        out.println("<tr><td>chargebackAmount</td><td>" + batchStat.getChargebackAmount()+"</td>");
        out.println("<tr><td>chargebackCount</td><td>" + batchStat.getChargebackCount()+"</td>");
        out.println("<tr><td>chargeChargebackAmount</td><td>" + batchStat.getChargeChargebackAmount()+"</td>");
        out.println("<tr><td>chargeChargebackCount</td><td>" + batchStat.getChargeChargebackCount()+"</td>");
        out.println("<tr><td>chargeCount</td><td>" + batchStat.getChargeCount()+"</td>");
        out.println("<tr><td>chargeReturnedItemsAmount</td><td>" + batchStat.getChargeReturnedItemsAmount()+"</td>");
        out.println("<tr><td>chargeReturnedItemsCount</td><td>" +batchStat.getChargeReturnedItemsCount()+"</td>");
        out.println("<tr><td>correctionNoticeCount</td><td>" + batchStat.getCorrectionNoticeCount()+"</td>");
        out.println("<tr><td>declineCount</td><td>" + batchStat.getDeclineCount()+"</td>");
        out.println("<tr><td>errorCount</td><td>" +batchStat.getErrorCount()+"</td>");
        out.println("<tr><td>refundAmount</td><td>" + batchStat.getRefundAmount()+"</td>");
        out.println("<tr><td>refundCount</td><td>" + batchStat.getRefundCount()+"</td>");
        out.println("<tr><td>refundChargebackAmount</td><td>" + batchStat.getRefundChargebackAmount()+"</td>");
        out.println("<tr><td>refundReturnedItemsAmount</td><td>" + batchStat.getRefundReturnedItemsAmount()+"</td>");
        out.println("<tr><td>refundReturnedItemsCount</td><td>" + batchStat.getRefundReturnedItemsCount()+"</td>");
        out.println("<tr><td>returnedItemAmount</td><td>" + batchStat.getReturnedItemAmount()+"</td>");
        out.println("<tr><td>returnedItemCount</td><td>" + batchStat.getReturnedItemCount()+"</td>");
        out.println("<tr><td>voidCount</td><td>" + batchStat.getVoidCount()+"</td>");
        out.println("</table>");
      }
    }
  %>

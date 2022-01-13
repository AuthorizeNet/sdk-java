# Authorize.Net Java SDK

[![Travis CI Status](https://travis-ci.org/AuthorizeNet/sdk-java.svg?branch=master)](https://travis-ci.org/AuthorizeNet/sdk-java)
[![Code Climate](https://codeclimate.com/github/AuthorizeNet/sdk-java/badges/gpa.svg)](https://codeclimate.com/github/AuthorizeNet/sdk-java)
[![Maven Central](https://img.shields.io/maven-central/v/net.authorize/anet-java-sdk.svg?style=flat)](http://mvnrepository.com/artifact/net.authorize/anet-java-sdk)
 
## Requirements
* JDK 1.5.0 to JDK 1.8.0
* Ant 1.6.2 or higher (build SDK only)
* Maven 2.2.0 or higher (build SDK only)
* An Authorize.Net account (see _Registration & Configuration_ section below)

_Note 1: Support for building the SDK with either Ant or Maven has been made. Please see the respective build processes below.  All initial jars and docs were built with Ant, however._

_Note 2: Support for higher versions of JDK (>= 1.9.0) has not been made available._

### Dependencies
* commons-logging-1.1.1.jar : logging
* log4j-2.17.1.jar          : logging
* httpclient-4.0.1.jar      : http communication with the payment gateway
* httpcore-4.0.1.jar        : http communication with the payment gateway
* junit-4.8.2.jar           : unit testing
* hamcrest-core-1.3.jar     : unit testing
* hamcrest-library-1.3.jar  : unit testing
* jmock-2.6.0.jar           : unit testing

### Migrating from older versions
Since August 2018, the Authorize.Net API has been reorganized to be more merchant focused. Authorize.Net AIM, ARB, CIM, Transaction Reporting, and SIM classes have been deprecated in favor of `net\authorize\api`. To see the full list of mapping of new features corresponding to the deprecated features, see [MIGRATING.md](MIGRATING.md).  

### Contribution
  - If you need information or clarification about Authorize.Net features, create an issue with your question. You can also search the [Authorize.Net developer community](https://community.developer.authorize.net/) for discussions related to your question.  
  - Before creating pull requests, read [the contributors guide](CONTRIBUTING.md).

### TLS 1.2
The Authorize.Net APIs only support connections using the TLS 1.2 security protocol. Make sure to upgrade all required components to support TLS 1.2. Keep these components up to date to mitigate the risk of new security flaws.


## Installation
```
  <groupId>net.authorize</groupId>
  <artifactId>anet-java-sdk</artifactId>
  <version>LATEST</version>
```

## Registration & Configuration
Use of this SDK and the Authorize.Net APIs requires having an account on the Authorize.Net system. You can find these details in the Settings section.
If you don't currently have a production Authorize.Net account, [sign up for a sandbox account](https://developer.authorize.net/sandbox/).

### Authentication
To authenticate with the Authorize.Net API, use your account's API Login ID and Transaction Key. If you don't have these credentials, obtain them from the Merchant Interface.  For production accounts, the Merchant Interface is located at (https://account.authorize.net/), and for sandbox accounts, at (https://sandbox.authorize.net).

After you have your credentials, load them into the appropriate variables in your code. The below sample code shows how to set the credentials as part of the API request.

#### To set your API credentials for an API request:
```java
    MerchantAuthenticationType merchantAuthenticationType  = new MerchantAuthenticationType() ;
    merchantAuthenticationType.setName("YOUR_API_LOGIN_ID");
    merchantAuthenticationType.setTransactionKey("YOUR_TRANSACTION_KEY");
    ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);
```

Never include your API Login ID and Transaction Key directly in a file in a publicly accessible portion of your website. As a best practice, define the API Login ID and Transaction Key in a constants file, and reference those constants in your code.

### Switching between the sandbox environment and the production environment
Authorize.Net maintains a complete sandbox environment for testing and development purposes. The sandbox environment is an exact replica of our production environment, with simulated transaction authorization and settlement. By default, this SDK is configured to use the sandbox environment. To switch to the production environment, set the appropriate environment constant using ApiOperationBase `setEnvironment` method. For example:
```java
// For PRODUCTION use
ApiOperationBase.setEnvironment(Environment.PRODUCTION);
```

API credentials are different for each environment, so be sure to switch to the appropriate credentials when switching environments. 

## SDK Usage Examples and Sample Code
When using this SDK, downloading the Authorize.Net sample code repository is recommended.
* [Authorize.Net Java Sample Code Repository (on GitHub)](https://github.com/AuthorizeNet/sample-code-java)

The repository contains comprehensive sample code for common uses of the Authorize.Net API.

The API Reference contains details and examples of the structure and formatting of the Authorize.Net API.
* [Developer Center API Reference](http://developer.authorize.net/api/reference/index.html)

Use the examples in the API Reference to determine which methods and information to include in an API request using this SDK.

## Create a Chase Pay Transaction

Use this method to authorize and capture a payment using a tokenized credit card number issued by Chase Pay. Chase Pay transactions are only available to merchants using the Paymentech processor.

The following information is required in the request:
- **payment token**
- **expiration date**
- **cryptogram** received from the token provider
- **tokenRequestorName**
- **tokenRequestorId**
- **tokenRequestorEci**

When using the SDK to submit Chase Pay transactions, consider the following points:
- `tokenRequesterName` must be populated with **`”CHASE_PAY”`**
- `tokenRequestorId` must be populated with the **`Token Requestor ID`** provided by Chase Pay services for each transaction during consumer checkout
- `tokenRequesterEci` must be populated with the **`ECI Indicator`** provided by Chase Pay services for each transaction during consumer checkout

## Building & Testing the SDK
Build the SDK with Maven
------------------------

To compile the SDK and create a .jar file:

 ` $ mvn clean package`

Build the SDK with Ant
----------------------

To compile the SDK and create a .jar file:

 ` $ ant jar`

To run the unit tests:

 ` $ ant unit-test`

To create the javadocs:

 ` $ ant javadoc`

### Running the SDK Tests
* Note:  To properly run the unit tests, please reference the anet-java-sdk.properties file, which contains the API credentials for testing the SDK.

### Testing Guide
For additional help in testing your own code, Authorize.Net maintains a [comprehensive testing guide](http://developer.authorize.net/hello_world/testing_guide/) that includes test credit card numbers to use and special triggers to generate certain responses from the sandbox environment.

## Logging Sensitive Data 
 
The Authorize.Net Java SDK uses Log4J framework for logging purposes. Enable the logger by keeping a configuration file `Log4j.properties` in the resources folder of the application. A sample [Log4.properties](https://github.com/AuthorizeNet/sdk-java/blob/master/resources/log4j.properties) file has been provided as a reference.  
 
The possible log levels are `DEBUG, INFO, WARN, ERROR` and `FATAL`.  There is a new pattern layout introduced to mask sensitive data while logging and can be used with the application by providing the following configurations in the `Log4j.properties` file:   
 
``` 
// Default configuration which logs the entries in clear text 

log4j.appender.S.layout = org.apache.log4j.PatternLayout 
log4j.appender.R.layout = org.apache.log4j.PatternLayout 
 
// Configuration which masks the sensitive data in the log entries 

log4j.appender.S.layout = net.authorize.util.SensitiveFilterLayout 
log4j.appender.R.layout = net.authorize.util.SensitiveFilterLayout 

``` 
 
By default the logger comes with two appenders, **console** and **file transport**.  
 
The sensitive fields that are masked during logging are:
* Card Number
* Card Code
* Expiration Date
* Transaction Key
* Account Number
* Name on Account

There is also a list of regular expressions which the sensitive logger uses to mask credit card numbers while logging. 

More information on the regular expressions used during sensitive data logging [can be found here](https://github.com/AuthorizeNet/sdk-java/blob/master/resources/AuthorizedNetSensitiveTagsConfig.json).

### Transaction Hash Upgrade
Authorize.Net is phasing out the MD5 based `transHash` element in favor of the SHA-512 based `transHashSHA2`. The setting in the Merchant Interface which controlled the MD5 Hash option is no longer available, and the `transHash` element will stop returning values at a later date to be determined. For information on how to use `transHashSHA2`, see the [Transaction Hash Upgrade Guide](https://developer.authorize.net/support/hash_upgrade/).

## License
This repository is distributed under a proprietary license. See the provided [`LICENSE.txt`](/LICENSE.txt) file.

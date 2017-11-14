# Authorize.Net Java SDK

[![Travis CI Status](https://travis-ci.org/AuthorizeNet/sdk-java.svg?branch=master)](https://travis-ci.org/AuthorizeNet/sdk-java)
[![Code Climate](https://codeclimate.com/github/AuthorizeNet/sdk-java/badges/gpa.svg)](https://codeclimate.com/github/AuthorizeNet/sdk-java)
[![Maven Central](https://img.shields.io/maven-central/v/net.authorize/anet-java-sdk.svg?style=flat)](http://mvnrepository.com/artifact/net.authorize/anet-java-sdk)

 
## Requirements
* JDK 1.5.0 or higher
* Ant 1.6.2 or higher (build SDK only)
* Maven 2.2.0 or higher (build SDK only)
* An Authorize.Net account (see _Registration & Configuration_ section below)

_Note: Support for building the SDK with either Ant or Maven has been made. Please see the respective build processes below.  All initial jars and docs were built with Ant, however._

### Dependencies
* commons-logging-1.1.1.jar : logging
* log4j-1.2.16.jar          : logging
* httpclient-4.0.1.jar      : http communication with the payment gateway
* httpcore-4.0.1.jar        : http communication with the payment gateway
* junit-4.8.2.jar           : unit testing
* hamcrest-core-1.3.jar     : unit testing
* hamcrest-library-1.3.jar  : unit testing
* jmock-2.6.0.jar           : unit testing

### TLS 1.2
The Authorize.Net APIs only support connections using the TLS 1.2 security protocol. It's important to make sure you have new enough versions of all required components to support TLS 1.2. Additionally, it's very important to keep these components up to date going forward to mitigate the risk of any security flaws that may be discovered in your system or any libraries it uses.


## Installation
```
  <groupId>net.authorize</groupId>
  <artifactId>anet-java-sdk</artifactId>
  <version>LATEST</version>
```

## Registration & Configuration
Use of this SDK and the Authorize.Net APIs requires having an account on our system. You can find these details in the Settings section.
If you don't currently have a production Authorize.Net account and need a sandbox account for testing, you can easily sign up for one [here](https://developer.authorize.net/sandbox/).

### Authentication
To authenticate with the Authorize.Net API you will need to use your account's API Login ID and Transaction Key. If you don't have these values, you can obtain them from our Merchant Interface site. Access the Merchant Interface for production accounts at (https://account.authorize.net/) or sandbox accounts at (https://sandbox.authorize.net).

Once you have your keys simply load them into the appropriate variables in your code, as per the below sample code dealing with the authentication part of the API request. 

#### To set your API credentials for an API request:
```java
    MerchantAuthenticationType merchantAuthenticationType  = new MerchantAuthenticationType() ;
    merchantAuthenticationType.setName("YOUR_API_LOGIN_ID");
    merchantAuthenticationType.setTransactionKey("YOUR_TRANSACTION_KEY");
    ApiOperationBase.setMerchantAuthentication(merchantAuthenticationType);
```

You should never include your Login ID and Transaction Key directly in a file that's in a publically accessible portion of your website. A better practice would be to define these in a constants file, and then reference those constants in the appropriate place in your code.

### Switching between the sandbox environment and the production environment
Authorize.Net maintains a complete sandbox environment for testing and development purposes. This sandbox environment is an exact duplicate of our production environment with the transaction authorization and settlement process simulated. By default, this SDK is configured to communicate with the sandbox environment. To switch to the production environment, set the appropriate environment constant using ApiOperationBase `setEnvironment` method.  For example:
```java
// For PRODUCTION use
ApiOperationBase.setEnvironment(Environment.PRODUCTION);
```

API credentials are different for each environment, so be sure to switch to the appropriate credentials when switching environments. 


## SDK Usage Examples and Sample Code
To get started using this SDK, it's highly recommended to download our sample code repository:
* [Authorize.Net Java Sample Code Repository (on GitHub)](https://github.com/AuthorizeNet/sample-code-java)

In that respository, we have comprehensive sample code for all common uses of our API:

Additionally, you can find details and examples of how our API is structured in our API Reference Guide:
* [Developer Center API Reference](http://developer.authorize.net/api/reference/index.html)

The API Reference Guide provides examples of what information is needed for a particular request and how that information would be formatted. Using those examples, you can easily determine what methods would be necessary to include that information in a request using this SDK.


## Building & Testing the SDK
Build the SDK with Maven
------------------------

To compile the SDK and create a jar...

 ` $ mvn clean package`

Build the SDK with Ant
----------------------

To compile the SDK and create a jar...

 ` $ ant jar`

To run the unit tests...

 ` $ ant unit-test`


To create the javadocs...

 ` $ ant javadoc`

### Running the SDK Tests
* Note:  To properly run the unit tests, please reference the
          anet-java-sdk.properties file, which is a simple properties file that
          holds the API credentials for testing the SDK.

### Testing Guide
For additional help in testing your own code, Authorize.Net maintains a [comprehensive testing guide](http://developer.authorize.net/hello_world/testing_guide/) that includes test credit card numbers to use and special triggers to generate certain responses from the sandbox environment.


## License
This repository is distributed under a proprietary license. See the provided [`LICENSE.txt`](/LICENSE.txt) file.
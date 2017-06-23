Authorize.Net Java SDK
======================
[![Travis](https://img.shields.io/travis/AuthorizeNet/sdk-java/master.svg)](https://travis-ci.org/AuthorizeNet/sdk-java)
[![Code Climate](https://codeclimate.com/github/AuthorizeNet/sdk-java/badges/gpa.svg)](https://codeclimate.com/github/AuthorizeNet/sdk-java)
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

Sample Code
===========
There are some sample unit tests that are located in the test directory. They
can doemonstrate basic functionality. However, detailed sample code for all
of the API operations available can be found in our sample code repository
at https://github.com/AuthorizeNet/sample-code-java

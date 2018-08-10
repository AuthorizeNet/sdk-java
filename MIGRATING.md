# Migrating from Legacy Authorize.Net Classes

Authorize.Net no longer supports several legacy classes, including AIM, ARB and others listed below, as part of sdk-java. If you are using any of these, we recommend that you update your code to use the new Authorize.Net API classes under (net/authorize/api).

**For details on the deprecation and replacement of legacy Authorize.Net APIs, visit https://developer.authorize.net/api/upgrade_guide/.**

## Full list of classes that are no longer supported
| Class                               | New Feature                                                                                                                                                    | Sample Codes directory/repository                                                 |
|-------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| AIM (net/authorize/aim)             | [PaymentTransactions](https://developer.authorize.net/api/reference/index.html#payment-transactions)                                                           | [sample-code-java/PaymentTransactions](https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/PaymentTransactions)    |
| ARB (net/authorize/arb)             | [RecurringBilling](https://developer.authorize.net/api/reference/index.html#recurring-billing)                                                                 | [sample-code-java/Recurring Billing](https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/RecurringBilling)          | 
| CIM (net/authorize/cim)             | [CustomerProfiles](https://developer.authorize.net/api/reference/index.html#customer-profiles)                                                                 | [sample-code-java/CustomerProfiles](https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/CustomerProfiles)          |
| SIM (net/authorize/sim)             | [Accept Hosted](https://developer.authorize.net/content/developer/en_us/api/reference/features/accept_hosted.html)                                             | Not available                                                                                                                         |
| Reporting	(net/authorize/reporting) | [TransactionReporting](https://developer.authorize.net/api/reference/index.html#transaction-reporting)                                                         | [sample-code-java/TransactionReporting](https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/TransactionReporting) |

## Example 
#### Old AuthorizeNetAIM example: 
   ```java
import net.authorize.DeviceType;
import net.authorize.Environment;
import net.authorize.MarketType;
import net.authorize.Merchant;
import net.authorize.TransactionType;

import net.authorize.aim.Transaction;
import net.authorize.aim.cardpresent.Result;

import net.authorize.data.creditcard.CardType;
import net.authorize.data.creditcard.CreditCard;

public class ChargeCreditCard{
       
	//AIM
	public static void main(String[] args) {
		CreditCard creditCard = CreditCard.createCreditCard();
		creditCard.setCardType(CardType.VISA);
		creditCard.setCreditCardNumber("4111111111111111");
		creditCard.setExpirationMonth("12");
		creditCard.setExpirationYear("2020");

        merchant = Merchant.createMerchant(Environment.SANDBOX, apiLoginID, transactionKey);
        merchant.setDeviceType(DeviceType.VIRTUAL_TERMINAL);
        merchant.setMarketType(MarketType.RETAIL);
		
		// create transaction
		Transaction authCaptureTransaction = merchant.createAIMTransaction(
				TransactionType.AUTH_CAPTURE, totalAmount);
		authCaptureTransaction.setCreditCard(creditCard);

        Result<Transaction> result = (Result<Transaction>) merchant.postTransaction(authCaptureTransaction);
	}
}
```
#### Corresponding new model code (charge-credit-card):
   ```java
import java.math.BigDecimal;
import java.math.RoundingMode;

import net.authorize.Environment;
import net.authorize.api.contract.v1.*;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;

public class ChargeCreditCard {
	
    public static void main(String[] args) {

        // Set the request to operate in either the sandbox or production environment
        ApiOperationBase.setEnvironment(Environment.SANDBOX);

        // Create object with merchant authentication details
        MerchantAuthenticationType merchantAuthenticationType  = new MerchantAuthenticationType() ;
        merchantAuthenticationType.setName(apiLoginId);
        merchantAuthenticationType.setTransactionKey(transactionKey);

        // Populate the payment data
        PaymentType paymentType = new PaymentType();
        CreditCardType creditCard = new CreditCardType();
        creditCard.setCardNumber("4111111111111111");
        creditCard.setExpirationDate("1220");
        paymentType.setCreditCard(creditCard);

        // Create the payment transaction object
        TransactionRequestType txnRequest = new TransactionRequestType();
        txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
        txnRequest.setPayment(paymentType);
        txnRequest.setAmount(new BigDecimal(amount).setScale(2, RoundingMode.CEILING));

        // Create the API request and set the parameters for this specific request
        CreateTransactionRequest apiRequest = new CreateTransactionRequest();
        apiRequest.setMerchantAuthentication(merchantAuthenticationType);
        apiRequest.setTransactionRequest(txnRequest);

        // Call the controller
        CreateTransactionController controller = new CreateTransactionController(apiRequest);
        controller.execute();

        // Get the response
        CreateTransactionResponse response = new CreateTransactionResponse();
        response = controller.getApiResponse();      
        
        return response;
    }
}
```

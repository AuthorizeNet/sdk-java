
import VisaCheckout.*;
import PayPalExpress.*;
import java.util.Scanner;
import RecurringBilling.*;
import PaymentTransactions.*;
import TransactionReporting.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] params={};
		
		SelectMethod();         // show the list of available methods		
	}
	
	private static void SelectMethod()
    {
		Scanner user_input = new Scanner( System.in );
		
		String processToRun;
		
		System.out.println("Code Sample Names: ");
		System.out.println("");
        ShowMethods();
        System.out.println("");
        System.out.println("Type a sample name & then press <Return> : ");
        processToRun = user_input.next( );
        
        System.out.println(processToRun);
        RunMethod(processToRun);
    }
	
	private static void ShowMethods()
    {
		System.out.println("    VisaCheckoutDecrypt");
		System.out.println("    VisaCheckoutTransaction");
		System.out.println("    ChargeCreditCard");
        System.out.println("    CaptureOnly");
        System.out.println("    AuthorizeCreditCard");
        System.out.println("    CapturePreviouslyAuthorizedAmount");
        System.out.println("    RefundTransaction");
        System.out.println("    Void");
        System.out.println("    DebitBankAccount");
        System.out.println("    CreditBankAccount");
        System.out.println("    ChargeTokenizedCard");
        System.out.println("    PayPalVoid");
        System.out.println("    PayPalAuthorizeCapture");
        System.out.println("    PayPalAuthorizeCaptureContinue");
        System.out.println("    PayPalAuthorizeOnly");
        System.out.println("    PayPalCredit");
        System.out.println("    PayPalGetDetails");
        System.out.println("    PayPalPriorAuthorizationCapture");
        System.out.println("    CancelSubscription");
        System.out.println("    CreateSubscription");
        System.out.println("    GetSubscriptionList");
        System.out.println("    GetSubscriptionStatus");
        System.out.println("    UpdateSubscription");
        System.out.println("    ChargeCustomerProfile");
        System.out.println("    GetBatchStatistics");
        System.out.println("    ChargeTokenizedCreditCard");
    }
	
	private static void RunMethod(String methodName)
    {
        // These are default transaction keys.
        // You can create your own keys in seconds by signing up for a sandbox account here: https://developer.authorize.net/sandbox/
        String apiLoginId 		= "5KP3u95bQpv";
        String transactionKey 	= "4Ktq966gC55GAX7S";

        String TransactionAmount;
        String TransactionID;
        
        String RefID;
        String SubscriptionID;
        
        Scanner user_input = new Scanner( System.in );

        switch (methodName)
        {
            case "AuthorizeCreditCard":
            	AuthorizeCreditCard.main(apiLoginId, transactionKey);
                break;
            case "CaptureOnly":
                CaptureOnly.main(apiLoginId, transactionKey);
                break;
            case "CapturePreviouslyAuthorizedAmount":
            	
            	System.out.println("Enter An Transaction Amount : ");
            	TransactionAmount = user_input.next( );
            	
            	System.out.println("Enter An Transaction ID : ");
                TransactionID = user_input.next( );

                CapturePreviouslyAuthorizedAmount.main(apiLoginId, transactionKey, TransactionAmount, TransactionID);
                break;
            case "RefundTransaction":
            	System.out.println("Enter An Transaction Amount : ");
                TransactionAmount = user_input.next( );

                System.out.println("Enter An Transaction ID : ");
                TransactionID = user_input.next( );

                RefundTransaction.main(apiLoginId, transactionKey, TransactionAmount, TransactionID);
                break;
            case "ChargeCreditCard":
                ChargeCreditCard.main(apiLoginId, transactionKey);
                break;
            case "ChargeCustomerProfile":
                ChargeCustomerProfile.main(apiLoginId, transactionKey);
                break;
            case "ChargeTokenizedCreditCard":
                ChargeTokenizedCreditCard.main(apiLoginId, transactionKey);
                break;
            case "CreditBankAccount":
                CreditBankAccount.main(apiLoginId, transactionKey);
                break;
            case "DebitBankAccount":
                DebitBankAccount.main(apiLoginId, transactionKey);
                break;
            case "VoidTransaction":
            	VoidTransaction.main(apiLoginId, transactionKey);
                break;
            case "CancelSubscription":
            	System.out.println("Enter An RefID : ");
            	RefID = user_input.next( );
            	
            	System.out.println("Enter An Subscription ID : ");
            	SubscriptionID = user_input.next( );

            	CancelSubscription.main(apiLoginId, transactionKey, RefID, SubscriptionID);
                break;
            case "CreateSubscription":
            	System.out.println("Enter An RefID : ");
            	RefID = user_input.next( );
  
            	CreateSubscription.main(apiLoginId, transactionKey, RefID);
                break;
            case "GetListSubscription":
            	System.out.println("Enter An RefID : ");
            	RefID = user_input.next( );
            	
            	System.out.println("Enter An Subscription ID : ");
            	SubscriptionID = user_input.next( );

            	GetListSubscription.main(apiLoginId, transactionKey, RefID, SubscriptionID);
                break;
            case "GetSubscriptionStatus":
            	System.out.println("Enter An RefID : ");
            	RefID = user_input.next( );
            	
            	System.out.println("Enter An Subscription ID : ");
            	SubscriptionID = user_input.next( );

            	GetSubscriptionStatus.main(apiLoginId, transactionKey, RefID, SubscriptionID);
                break;
            case "UpdateSubscription":
            	System.out.println("Enter An RefID : ");
            	RefID = user_input.next( );
            	
            	System.out.println("Enter An Subscription ID : ");
            	SubscriptionID = user_input.next( );

            	UpdateSubscription.main(apiLoginId, transactionKey, RefID, SubscriptionID);
                break;
            case "GetBatchStatistics":
            	GetBatchStatistics.main(apiLoginId, transactionKey);
                break;
            default:
                break;
        }
        
        user_input.close();
    }

}

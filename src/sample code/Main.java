import java.util.Scanner;
import PaymentTransactions.CaptureOnly;
import PaymentTransactions.RefundTransaction;
import PaymentTransactions.AuthorizeCreditCard;
import PaymentTransactions.CapturePreviouslyAuthorizedAmount;

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
    }
	
	private static void RunMethod(String methodName)
    {
        // These are default transaction keys.
        // You can create your own keys in seconds by signing up for a sandbox account here: https://developer.authorize.net/sandbox/
        String apiLoginId 		= "5KP3u95bQpv";
        String transactionKey 	= "4Ktq966gC55GAX7S";

        String TransactionAmount;
        String TransactionID;
        
        String processToRun;
        
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

                user_input.close();
                CapturePreviouslyAuthorizedAmount.main(apiLoginId, transactionKey, TransactionAmount, TransactionID);
                break;
            case "RefundTransaction":
            	System.out.println("Enter An Transaction Amount : ");
                TransactionAmount = user_input.next( );

                System.out.println("Enter An Transaction ID : ");
                TransactionID = user_input.next( );

                RefundTransaction.main(apiLoginId, transactionKey, TransactionAmount, TransactionID);
                break;
            default:
                break;
        }
    }

}

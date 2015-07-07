import java.util.Scanner;
import PaymentTransactions.AuthorizeCreditCard;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] params={};
		
		SelectMethod();         // show the list of available methods
		
		//AuthorizeCreditCard.main(params);
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
		System.out.println("    Refund");
		System.out.println("    Void");
		System.out.println("    DebitBankAccount");
		System.out.println("    CreditBankAccount");
		System.out.println("    ChargeTokenizedCard");
    }
	
	private static void RunMethod(String methodName)
    {
        // These are default transaction keys.
        // You can create your own keys in seconds by signing up for a sandbox account here: https://developer.authorize.net/sandbox/
        String apiLoginId 		= "5KP3u95bQpv";
        String transactionKey 	= "4Ktq966gC55GAX7S";

        String TransactionAmount;
        String TransactionID;

        switch (methodName)
        {
            case "AuthorizeCreditCard":
            	AuthorizeCreditCard.main(apiLoginId, transactionKey);
                break;
            default:
                break;
        }
    }

}

import java.util.Scanner;

public class CollegeOutput {

	public static void main(user Person) {
		// TODO Auto-generated method stub

		Scanner user_LNinput = new Scanner(System.in);
		Scanner user_YNinput = new Scanner(System.in);
		Scanner user_PAinput = new Scanner(System.in);
		Scanner user_MAinput = new Scanner(System.in);
		
		//Instigating object
		CollegeLoan L1 = new CollegeLoan(0, .01057, 0, Person);
		
		//Disclaimer message
		System.out.println("The minimum amount you can apply for is $35000 and the maximum is $100000.");
		
		//Method to ask user for loan amount
		L1.AskLoanAmount(user_LNinput);
		
		//Display loan amount
		L1.DisplayLoanAmount();
		
		//Method if loan greater than maximum
		L1.IFLoanGREAT(user_YNinput, user_LNinput);
		
		//Method if loan less than minimum
		L1.IFLoanLESS(user_YNinput, user_LNinput);
		
		//Display initial fee
		L1.DisplayInitialFee();
		
		//Method for calculating initial fee
		L1.CalculateFee();
		
		//Display method for calculating monthly payments
		L1.CalculatePayments();
		
		//Method for calculating months
		L1.CalculateYears();
		
		//Method for asking user if they want to pay in advance
		L1.PayAdvance(user_PAinput, user_MAinput);
		
	}

}


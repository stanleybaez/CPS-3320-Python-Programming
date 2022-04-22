import java.util.Scanner;

public class CBLoanOutput {

	public static void main(user Person) {
		// TODO Auto-generated method stub
		
		//Scanners
		Scanner user_CBLinput = new Scanner(System.in);
		Scanner user_CBYNinput = new Scanner(System.in);
		Scanner user_CBPAinput = new Scanner(System.in);
		Scanner user_CBMAinput = new Scanner(System.in);
		
		//Instigating an object
		CBLoan CB = new CBLoan(0, 0, .0049, .0054, .0430, .0550, .0710, Person);
		
		//Display greetings message
		System.out.println("Welcome!");
		System.out.println("When applying for a business loan, the minimum you can apply for $100000 and the max you can apply for is $2500000.");
		System.out.println("An initial fee will be applied when applying for a loan.");
		
		//Ask user business loan amount
		CB.AskCBLAmt(user_CBLinput);
		
		//Display if loan exceeds limit
		CB.CBIFLTHAN(user_CBYNinput, user_CBLinput);
		
		//Display if loan less than minimum
		CB.CBIFGTHAN(user_CBYNinput, user_CBLinput);
		
		//Display fee
		CB.DisplayCalcCBFee();
		
		//Display payments
		CB.DisplayCalcCBPay();
		
		//Display interest rate
		CB.CDInterest();
		
		//Display years
		CB.DisplayCalcBCYears();
		
		//Display months to pay in advance
		CB.DisplayPayAdv(user_CBPAinput, user_CBMAinput);		
		
	}

}

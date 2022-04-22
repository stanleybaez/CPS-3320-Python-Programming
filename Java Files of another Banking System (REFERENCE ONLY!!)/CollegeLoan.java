import java.util.Scanner;

public class CollegeLoan {

    //Private Instance Variables
    private int LoanAmount;
    private int MonthA;
    private double InitialFee;
    private double MonthP;
    public double M1 = 60.0;
    public double M2 = 48.0;
    private String UserYN;
    private String UserPA;
    private static user abc;

    //Overloaded Constructor
    public CollegeLoan(int loanamount, double initialfee, double monthp, user Person) {

        this.LoanAmount = loanamount;
        this.InitialFee = initialfee;
        this.MonthP = monthp;
        abc = Person;

    }

    //Accessor Methods
    public int getLoanAmount() {
        return LoanAmount;
    }

    public double getInitialFee() {
        return InitialFee;
    }

    public double getMonthP() {
        return MonthP;
    }

    //Modifier Methods
    public void setLoanAmount(int loanamount) {
        this.LoanAmount = loanamount;
    }

    public void setInitialFee(double initialfee) {
        this.InitialFee = initialfee;
    }

    public void setMonthP(double monthp) {
        this.MonthP = monthp;
    }

    //Method for calculating fee
    public void CalculateFee() {

        if (LoanAmount >= 35000 && LoanAmount <= 100000) {

            System.out.println("Your initial loan fee will be: $" + Math.round(LoanAmount * InitialFee));

        }

    }

    //Method for calculating payments
    public void CalculatePayments() {

        if (LoanAmount >= 65000 && LoanAmount <= 100000) {

            System.out.println("Your monthly payments will be: $" + Math.round(LoanAmount / M1));

        } else if (LoanAmount >= 35000 && LoanAmount < 65000) {

            System.out.println("Your monthly payments will be: $" + Math.round(LoanAmount / M2));

        }

    }

  //Method for calculating years
    public void CalculateYears() {
    	
    	if (LoanAmount >= 65000 && LoanAmount <= 100000) {
    		
    	System.out.println("It will take approximately 5 years to pay off your loan.");
    	System.out.println("Your first payment will start next month and it will be due on the 21st of every month for 5 years.");
    	
    	}
    	else if (LoanAmount >= 35000 && LoanAmount < 65000) {
    		
    	System.out.println("It will take approximately 4 years to pay off your loan.");
    	System.out.println("Your first payment will start next month and it will be due on the 21st of every month for 4 years.");
    	
    	}
    	

    	
    }

    //Method for asking loan amount
    public void AskLoanAmount(Scanner user_LNinput) {

        System.out.print("Enter the college loan amount you would like: $");

        LoanAmount = user_LNinput.nextInt();

    }

    public void DisplayLoanAmount() {

        if (LoanAmount >= 35000 && LoanAmount <= 100000) {

            System.out.println("Your loan amount is: $" + LoanAmount);

        }

    }

    public void DisplayInitialFee() {

        if (LoanAmount >= 35000 && LoanAmount <= 100000) {

            System.out.println("The added initial fee is: " + (InitialFee * 100) + "%");

        }

    }

    //Warning message if amount less than minimum
    public void IFLoanLESS(Scanner user_YNinput, Scanner user_LNinput) {

        while (LoanAmount >= 0 && LoanAmount < 35000) {

            System.out.println("WARNING!");
            System.out.println("Please enter an amount that is between $35000 and $100000.");

            System.out.println("Would you like to enter again?");
            System.out.println("Enter Y for yes or N for no");

            UserYN = user_YNinput.nextLine();

            if (UserYN.equalsIgnoreCase("Y")) {

                System.out.print("Enter the college loan amount you would like: $");
                LoanAmount = user_LNinput.nextInt();

            } else if (UserYN.equalsIgnoreCase("N")) {

                System.out.println("Have a nice day!");
                client.Menu(abc);
            }
        }

    }

    //Warning message if amount greater than limit
    public void IFLoanGREAT(Scanner user_YNinput, Scanner user_LNinput) {

        while (LoanAmount > 100000 || LoanAmount < 35000) {

            System.out.println("WARNING!");
            System.out.println("Please enter an amount that is between $35000 and $100000.");

            System.out.println("Would you like to enter again?");
            System.out.println("Enter Y for yes or N for no");

            UserYN = user_YNinput.nextLine();

            if (UserYN.equalsIgnoreCase("Y")) {

                System.out.print("Enter the college loan amount you would like: $");
                LoanAmount = user_LNinput.nextInt();

            } else if (UserYN.equalsIgnoreCase("N")) {

                System.out.println("Have a nice day!");
                client.Menu(abc);
            }
        }

    }

    //Method for paying in advance
    public void PayAdvance(Scanner user_PAinput, Scanner user_MAinput) {

        if (LoanAmount >= 65000 && LoanAmount <= 100000) {

            System.out.println("Would you like to pay in advance? ");
            System.out.println("Enter Y for yes or N for no");

            UserPA = user_PAinput.nextLine();

            if (UserPA.equalsIgnoreCase("Y")) {

                System.out.println("How many months would you like to pay in advance? ");

                MonthA = user_MAinput.nextInt();

                System.out.println("You will have to pay $" + Math.round(LoanAmount / M1) * (MonthA) + " in advance.");
                client.Menu(abc);
            } else if (UserPA.equalsIgnoreCase("N")) {

                System.out.println("Okay, have a nice day!");
                client.Menu(abc);
            }

        } else if (LoanAmount >= 35000 && LoanAmount < 65000) {

            System.out.println("Would you like to pay in advance? ");
            System.out.println("Enter Y for yes or N for no");

            UserPA = user_PAinput.nextLine();

            if (UserPA.equalsIgnoreCase("Y")) {

                System.out.println("How many months would you like to pay in advance? ");

                MonthA = user_MAinput.nextInt();

                System.out.println("You will have to pay $" + Math.round(LoanAmount / M2) * (MonthA) + " in advance.");
                client.Menu(abc);
            } else if (UserPA.equalsIgnoreCase("N")) {

                System.out.println("Okay, have a nice day!");
                client.Menu(abc);
            }

        }

    }

}
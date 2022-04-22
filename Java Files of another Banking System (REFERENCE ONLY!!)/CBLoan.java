import java.util.Scanner;

public class CBLoan {

    //Instance Variables
    private int CBLoanAmt;
    private int CBMonthsA;
    private double InitialF1;
    private double InitialF2;
    private double InterestR1;
    private double InterestR2;
    private double InterestR3;
    private double CBM1 = 72.0;
    private double CBM2 = 84.0;
    private double CBM3 = 96.0;
    private String USERCBYN;
    private String USERCBPA;
    private static user abc;

    //Overloaded Constructor
    public CBLoan(int cbloanamt, int cbmonthsa, double initialf1, double initialf2, double interestr1, double interestr2, double interestr3, user Person) {

        this.CBLoanAmt = cbloanamt;
        this.CBMonthsA = cbmonthsa;
        this.InitialF1 = initialf1;
        this.InitialF2 = initialf2;
        this.InterestR1 = interestr1;
        this.InterestR2 = interestr2;
        this.InterestR3 = interestr3;
        abc = Person;

    }

    //Accessor Methods	
    public int getCBLoanAmt() {
        return CBLoanAmt;
    }

    public int getCBMonthsA() {
        return CBMonthsA;
    }

    public double getInitialF1() {
        return InitialF1;
    }

    public double getInitialF2() {
        return InitialF2;
    }

    public double getInterestR1() {
    	return InterestR1;
    }
    
    public double getInterestR2() {
    	return InterestR2;
    }
    
    public double getInterestR3() {
    	return InterestR3;
    }
   
    
    //Modifier Methods
    public void setCBLoanAmt(int cbloanamt) {
        this.CBLoanAmt = cbloanamt;
    }

    public void setCBMonthsA(int cbmonthsa) {
        this.CBMonthsA = cbmonthsa;
    }

    public void setInitialF1(double initialf1) {
        this.InitialF1 = initialf1;
    }

    public void setInitialF2(double initialf2) {
        this.InitialF2 = initialf2;
    }
    
    public void setInterestR1(double interestr1) {
    	this.InterestR1 = interestr1;
    }
    
    public void setInterestR2(double interestr2) {
    	this.InterestR2 = interestr2;
    }
    
    public void setInterestR3(double interestr3) {
    	this.InterestR3 = interestr3;
    }

    //Ask user how much they want
    public void AskCBLAmt(Scanner user_CBLinput) {

        System.out.print("Please enter the business loan amount you would like: $");

        CBLoanAmt = user_CBLinput.nextInt();

    }

    //Display warning message if less than minimum
    public void CBIFLTHAN(Scanner user_CBYNinput, Scanner user_CBLinput) {

        while (CBLoanAmt >= 0 && CBLoanAmt < 100000) {

            System.out.println("WARNING!");
            System.out.println("Please enter an amount that is between $100000 and $2500000.");

            System.out.println("Would you like to enter again?");
            System.out.println("Please enter Y for yes or N for no");

            USERCBYN = user_CBYNinput.nextLine();

            if (USERCBYN.equalsIgnoreCase("Y")) {

                System.out.print("Please enter the business loan amount you would like: $");

                CBLoanAmt = user_CBLinput.nextInt();

            } else if (USERCBYN.equalsIgnoreCase("N")) {

                System.out.println("Have a nice day!");
                client.Menu(abc);

            }

        }

    }

    //Display error if greater than limit
    public void CBIFGTHAN(Scanner user_CBYNinput, Scanner user_CBLinput) {

        while (CBLoanAmt > 2500000 || CBLoanAmt < 35000) {

            System.out.println("WARNING!");
            System.out.println("Please enter an amount that is between $100000 and $2500000.");

            System.out.println("Would you like to enter again?");
            System.out.println("Please enter Y for yes or N for no");

            USERCBYN = user_CBYNinput.nextLine();

            if (USERCBYN.equalsIgnoreCase("Y")) {

                System.out.print("Please enter the business loan amount you would like: $");

                CBLoanAmt = user_CBLinput.nextInt();

            } else if (USERCBYN.equalsIgnoreCase("N")) {

                System.out.println("Have a nice day!");
                client.Menu(abc);

            }

        }

    }

    //Method for calculating and displaying fee
    public void DisplayCalcCBFee() {

        if (CBLoanAmt >= 100000 && CBLoanAmt <= 1000000) {

            System.out.println("The initial fee will be: " + (InitialF1 * 100) + "%");

            System.out.println("Your fee will be: $" + Math.round(CBLoanAmt * InitialF1));

        } else if (CBLoanAmt > 1000000 && CBLoanAmt <= 2500000) {

            System.out.println("The initial fee will be: " + (InitialF2 * 100) + "%");

            System.out.println("Your fee will be: $" + Math.round(CBLoanAmt * InitialF2));

        }
    }

    //Method for calculating and displaying monthly payments
    public void DisplayCalcCBPay() {

        if (CBLoanAmt >= 100000 && CBLoanAmt <= 833000) {

            System.out.println("Your monthly payments will be: $" + Math.round(CBLoanAmt / CBM1));

        } else if (CBLoanAmt > 833000 && CBLoanAmt <= 1666000) {

            System.out.println("Your monthly payments will be: $" + Math.round(CBLoanAmt / CBM2));

        } else if (CBLoanAmt > 1666000 && CBLoanAmt <= 2500000) {

            System.out.println("Your monthly payments will be: $" + Math.round(CBLoanAmt / CBM3));

        }

    }

    //Method for displaying years
    public void DisplayCalcBCYears() {

        if (CBLoanAmt >= 100000 && CBLoanAmt <= 750000) {

            System.out.println("It will take approximately 6 years to pay off your loan.");
            System.out.println("Your first payment will start next month and it will be due on the 21st of every month for 6 years.");
        } else if (CBLoanAmt > 750000 && CBLoanAmt <= 1500000) {

            System.out.println("It will take approximately 7 years to pay off your loan.");
            System.out.println("Your first payment will start next month and it will be due on the 21st of every month for 7 years.");

        } else if (CBLoanAmt > 1500000 && CBLoanAmt <= 2500000) {

            System.out.println("It will take approximately 8 years to pay off your loan.");
            System.out.println("Your first payment will start next month and it will be due on the 21st of every month for 8 years.");

        }

    }
    
    //Method for display and calculating interest rate
    public void CDInterest() {
    	
    	if (CBLoanAmt >= 100000 && CBLoanAmt <= 750000) {
    		
    		System.out.println("Your interest rate will be: " + (InterestR1 * 100) + "%");
    		System.out.println("Your total amount that you will have to pay off will be: $" + (int) (CBLoanAmt * InterestR1 * 6 + CBLoanAmt));
    		
    	}
    	else if (CBLoanAmt > 750000 && CBLoanAmt <= 1500000) {
    		
    		System.out.println("Your interest rate will be: " + (InterestR2 * 100) + "%");
    		System.out.println("Your total amount that you will have to pay off will be: $" + (int) (CBLoanAmt * InterestR2 * 7 + CBLoanAmt));	
    		
    	}
    	else if (CBLoanAmt > 1500000 && CBLoanAmt <= 2500000) {
    		
    		System.out.println("Your interest rate will be: " + (InterestR3 * 100) + "%");
    		System.out.println("Your total amount that you will have to pay off will be: $" + (int) (CBLoanAmt * InterestR3 * 8 + CBLoanAmt));	
    		
    	}
    	
    	
    }
    
    
    //Method for paying in advance
    public void DisplayPayAdv(Scanner user_CBPAinput, Scanner user_CBMAinput) {

        if (CBLoanAmt >= 100000 && CBLoanAmt <= 833000) {

            System.out.println("Would you like to pay in advance? ");
            System.out.println("Enter Y for yes or N for no");

            USERCBPA = user_CBPAinput.nextLine();

            if (USERCBPA.equalsIgnoreCase("Y")) {

                System.out.println("How many months would you like to pay in advance? ");

                CBMonthsA = user_CBMAinput.nextInt();

                System.out.println("You will have to pay $" + Math.round(CBLoanAmt / CBM1) * (CBMonthsA) + " in advance.");
                client.Menu(abc);
            } else if (USERCBPA.equalsIgnoreCase("N")) {

                System.out.println("Okay, have a nice day!");
                client.Menu(abc);
            }
        } else if (CBLoanAmt > 833000 && CBLoanAmt <= 1666000) {

            System.out.println("Would you like to pay in advance? ");
            System.out.println("Enter Y for yes or N for no");

            USERCBPA = user_CBPAinput.nextLine();

            if (USERCBPA.equalsIgnoreCase("Y")) {

                System.out.println("How many months would you like to pay in advance? ");

                CBMonthsA = user_CBMAinput.nextInt();

                System.out.println("You will have to pay $" + Math.round(CBLoanAmt / CBM2) * (CBMonthsA) + " in advance.");
                client.Menu(abc);
            } else if (USERCBPA.equalsIgnoreCase("N")) {

                System.out.println("Okay, have a nice day!");
                client.Menu(abc);
            }
        } else if (CBLoanAmt > 1666000 && CBLoanAmt <= 2500000) {

            System.out.println("Would you like to pay in advance? ");
            System.out.println("Enter Y for yes or N for no");

            USERCBPA = user_CBPAinput.nextLine();

            if (USERCBPA.equalsIgnoreCase("Y")) {

                System.out.println("How many months would you like to pay in advance? ");

                CBMonthsA = user_CBMAinput.nextInt();

                System.out.println("You will have to pay $" + Math.round(CBLoanAmt / CBM3) * (CBMonthsA) + " in advance.");
                client.Menu(abc);
            } else if (USERCBPA.equalsIgnoreCase("N")) {

                System.out.println("Okay, have a nice day!");
                client.Menu(abc);
            }
        }

    }

}



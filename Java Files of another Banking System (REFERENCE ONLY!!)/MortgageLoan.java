import java.util.Scanner;
// TO DO: 
// Closing for Mortgage Loan
// Applying for Mortgage Loan 
// Checking if mortgage loan is greater than the user balance
// Fees? 

public class MortgageLoan {
    public static void main(user Person) {
        Scanner scan = new Scanner(System.in);

        // Asking for principal amount and checking if it is greater than 0. 
        System.out.println("Welcome! Please enter principal amount: ");
        double userprincipal = scan.nextDouble();
        while (userprincipal <= 0) {
            System.out.println("Please enter a positive principal amount greater than 0. Try again!");
            userprincipal = scan.nextDouble();

            if (userprincipal > 0) {
                break;
            }

        }

        // Asking for annual rate and checking if it is greater than 0. 
        System.out.print("Enter Annual Rate of Interest (exclude the %): ");
        double annualrate = scan.nextDouble();
        while (annualrate <= 0) {
            System.out.println("Please enter a positive interest rate greater than 0. Try again!");
            annualrate = scan.nextDouble();

            if (annualrate > 0) {
                break;
            }

        }

        // Asking for time period and checking if it is greater than 0. 
        System.out.print("Enter Time period in years : ");
        double timeperiod = scan.nextDouble();
        while (timeperiod <= 0) {
            System.out.println("Please enter a positive time period (greater than 0). Try again!");
            timeperiod = scan.nextDouble();

            if (timeperiod > 0) {
                break;
            }
        }

        // Creating the object and calling the methods 
        MortgagePayment hello = new MortgagePayment(userprincipal, annualrate, timeperiod);
        double monthlyInterest = hello.calculatemonthlyinterest();
        double numberofmonths = hello.calculatenumberofmonths();
        double monthlypaym = hello.calculatemonthlyMortgage(monthlyInterest, numberofmonths);
        System.out.println("Monthly mortgage payment: " + " $" + monthlypaym);

        double loanfee = hello.calculateloanOriginationFee();
        System.out.println("Loan Origination Fee (0.5%): " + loanfee);

        double totalpaym = hello.calculatetotalMortgage(monthlypaym, numberofmonths) + loanfee;
        System.out.println("Total mortgage payment: " + " $" + totalpaym);
        
        client.Menu(Person);
    }
}

class MortgagePayment {
    // Instance variables 
    private double principalAmount;
    private double annualInterest;
    private double timePeriod;
    private user Person;
    //private static user abc; 

    // Overloaded Constructor 
    public MortgagePayment(double principal, double interest, double time) {
        principalAmount = principal;
        annualInterest = interest;
        timePeriod = time;
    }
    public MortgagePayment(double principal, double interest, double time, user abc) {
        principalAmount = principal;
        annualInterest = interest;
        timePeriod = time;
        Person = abc;
    }

    // Get methods
    public double getprincipalAmount() {
        return principalAmount;
    }
    public double getannualInterest() {
        return annualInterest;
    }
    public double gettimePeriod() {
        return timePeriod;
    }

    // Interesting methods
    public double calculatemonthlyinterest() {
        double monthlyInterest = (annualInterest / 100) / 12;
        return monthlyInterest;
    }

    public double calculatenumberofmonths() {
        double months = timePeriod * 12;
        return months;
    }

    //public calculate total payments P [ i(1 + i)^n ] / [ (1 + i)^n – 1]- ***NEED TO FIX 
    public double calculatemonthlyMortgage(double monthlyInterestRate, double months) {
        double first = Math.pow(1 + monthlyInterestRate, months);
        double second = Math.pow(1 + monthlyInterestRate, months);
        double monthlypay = (principalAmount * monthlyInterestRate * first) / (second - 1);
        return monthlypay;
    }

    public double calculatetotalMortgage(double monthlymortgage, double months) {
        double total = monthlymortgage * months;
        return total;
    }

    public double calculateloanOriginationFee() {
        double fee = 0.005 * principalAmount;
        return fee;
    }

    public void determineAccount(double monthlypayment) {
        System.out.println("Which of your accounts would you like to use to pay?");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) Savings Account");
        System.out.println("2) Checking Account");
        System.out.println("3) Exit");

        String userInput = keyboard.nextLine();

        if (userInput.equals("1")) {
            Person.getSavingsAccount().withdraw(monthlypayment, Person.getSavingsAccount().getBalance(), Person.getSavingsAccount().getMonthlyWithdrawals());
        } else if (userInput.equals("2")) {
            Person.getCheckingAccount().withdraw(monthlypayment, Person.getCheckingAccount().getBalance());
        }    //abc.getMoneyMarketAccount().withdraw(monthlypayment);
          else if (userInput.equals("3")) {
            System.out.println("Thank you for banking with Bing Bong Byron");

            System.exit(0);
        } 
        else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            determineAccount(monthlypayment);
        }
    }

    public boolean agree() {
        Scanner keyboard2 = new Scanner(System.in);
        System.out.print("Do you agree? y/n ");
        String agree = keyboard2.nextLine();
        if (agree.equalsIgnoreCase("y")) {
            return true;
        } else if (agree.equalsIgnoreCase("n")) {
            System.out.println("Exiting...");
            return false;
        } else {
            System.out.println("Input not understood, please try again!");
            return agree();
        }
    }

}
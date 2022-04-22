// UML final


import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
//import CreditDebitCards.java;

public class HomeEquityLoan {

    private double creditscore;
    private double loanamount;
    private int timetopayoff; //in months
    private double monthlypayment;
    private double houseprice;
    private double interest; //compounded annually
    private double homeequity;
    private user abc;

    HomeEquityLoan() {

        creditscore = 750; //default value, will pass actual score
        loanamount = 0;
        timetopayoff = 0;
        monthlypayment = 0;
        houseprice = 0;
        interest = 0;
        homeequity = 50000;
    }

    HomeEquityLoan(double price, double intrate, double equity, user Person) {
        houseprice = price;
        interest = intrate;
        homeequity = equity;
        abc = Person;
    }

    public static void main(user Person) {

        System.out.println("Welcome to the Home Equity Loan menu!");
        
        //double creditscore = Person.getCreditScore();

        double creditscore = Person.getCreditScore();

        double marketVal = getHomeValue();

        double interestrate = 3.5; // interest rate established beforehand by Bing Bong Byron Bank

        if (checkCreditScore(creditscore)) {

        	double mortgagebal = getMortgageBalance();
            double homeequity = marketVal - mortgagebal;
            HomeEquityLoan myHome = new HomeEquityLoan(marketVal, interestrate, homeequity, Person);

            if (myHome.checkCurrentpay()) {

                myHome.getMonthlyPayment();
            }

        } else {
            System.out.println("Your credit score is too low, please apply again later!");
            client.Menu(Person);
        }

    }
    
    public static double getHomeValue() {
    	Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your house's current market value: ");
        double marketVal2 = keyboard.nextDouble();
        if (marketVal2 < 0) {
        	System.out.println("Negative amount is not allowed. Please try again.");
        	return getHomeValue();
        }
        return marketVal2;
    }
    
    public static double getMortgageBalance() {
    	Scanner keyboard2 = new Scanner(System.in);
        System.out.println("Please enter your mortgage balance remaining: ");
        double mortgagebal = keyboard2.nextDouble();
        if (mortgagebal < 0) {
        	System.out.println("Negative amount is not allowed. Please try again.");
        	return getMortgageBalance();
        }
        return mortgagebal;
    }
    
    public static boolean checkCreditScore(double creditscore) {

        if (creditscore >= 620) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkCurrentpay() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your current payment amount: ");
        int currentpay = keyboard.nextInt();
        // error handling
        if (currentpay < 0) {
        	System.out.println("Negative amount is not allowed. Please try again.");
        	return checkCurrentpay();
        }
        if (currentpay >= houseprice / 5) {
            return true;

        } else {
            System.out.println("Your current payment must be 20% of the home price. Please try again.");
            return checkCurrentpay();
        }

    }
    // GET METHODS/ACCESSOR METHODS
    public double getCreditScore() {
        return creditscore;
    }
    public double getHomeEquity() {
        return homeequity;
    }
    public double getLoanAmount() {
        return loanamount;
    }
    public double getTimeToPayOff() { //in months
        return 120;
    }
    public double getCurrentPayableAmount() {
        double homeEquity = getHomeEquity();
        return 0.2 * homeEquity; // 20% of home equity amount
    }

    public void getMonthlyPayment() {
        double homeEquity = homeequity;
        double CurrentPayableAmount = getCurrentPayableAmount();
        double TimetoPayOff = getTimeToPayOff();
        double totalpayment = homeEquity - CurrentPayableAmount;
        double monthlypayment = totalpayment / TimetoPayOff;
        double ROUNDEDmonthlypayment = Math.round(monthlypayment * 100.0) / 100.0;
        System.out.println("The loan will be paid off over the course of 10 years.");
        System.out.println("With current interest rate of 3.5%, your monthly payment will be: $" + ROUNDEDmonthlypayment * .035);

        if (agree()) {
            determineAccount(monthlypayment);
            System.out.println("Your first payment has been processed.");

        } else {
            client.Menu(abc);
        }

    }

    public void determineAccount(double monthlypayment) {
        System.out.println("Which of your accounts would you like to use to pay?");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) Savings Account");
        System.out.println("2) Checking Account");
        System.out.println("3) Exit"); 

        String userInput = keyboard.nextLine();

        if (userInput.equals("1")) {
            abc.getSavingsAccount().withdraw(monthlypayment, abc.getSavingsAccount().getBalance(), abc.getSavingsAccount().getMonthlyWithdrawals());
        } else if (userInput.equals("2")) {
            abc.getCheckingAccount().withdraw(monthlypayment, abc.getCheckingAccount().getBalance());
        } else if (userInput.equals("3")) {
            System.out.println("Thank you for banking with Bing Bong Byron");

            System.exit(0);
        } else {
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
    // SET METHODS
    public void setHomeCost(double price) {
        houseprice = price;
    }

}
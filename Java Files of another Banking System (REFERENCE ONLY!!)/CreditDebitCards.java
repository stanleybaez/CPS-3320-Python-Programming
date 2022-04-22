import java.util.Scanner;
import java.util.Random;

public class CreditDebitCards {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // parameters should be based on other group's code

        // OUR CODE SO FAR... IN THE WORKS

        //Debit myDebit = new Debit(1000000000, 1, 1234, "Byron", 1111987667890069.0, 420);
        // 1111 indicates Bing Bong Byron Bank - otherwise it's a diff bank/card
        //System.out.println("Your balance is: $" + myDebit.getBalance());
        //myDebit.withdrawDollah();
        //myDebit.withdrawDollah();
        //myDebit.depositDollah();
        //System.out.println(myDebit.getTotalSpent());
        //Credit myCredit = new Credit(1000000000, 1234, "Byron", 1111987667890069.0, 420, 2000.00);

    }

}

class Debit {
    private double balance;
    private int RoutingNumber;
    private double totalSpent = 0;
    private int userPIN;
    private double dcNUM;
    private int CVV;

    private static user abc;

    private String userName;
    //private double withdrawAmt;
    // double depositAmt;

    Debit() {
        balance = 0.00;
        RoutingNumber = 420691234;
        dcNUM = 1111123443216969.0;
        CVV = 420;
    }
    Debit(double bal, int num, int PIN, String name, double num2, int numcvv) {
        balance = bal;
        RoutingNumber = num;
        userPIN = PIN;
        userName = name;
        dcNUM = num2;
        CVV = numcvv;

    }

    Debit(double bal, int num, int PIN, String name, double num2, int numcvv, user Person) {
        balance = bal;
        RoutingNumber = num;
        userPIN = PIN;
        userName = name;
        dcNUM = num2;
        CVV = numcvv;
        abc = Person;
    }

    public double getDCNum() {
        return dcNUM;
    }

    public double getBalance() {
        checkRoutingNumber();
        checkPIN();
        return balance;
    }
    // FOR ATM 
    public double getATMBalance() {
        return balance;
    }
    public String getUserName() {
        return userName;
    }

    public void PutInCard() {
        System.out.println("Please put in your credit card.");
    }
    
    public void setUser(user person) {
        abc = person;
    }
    
    public boolean checkDebitCardNum() { // checks debit card number AND cvv together
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your debit card number for confirmation: ");
        double userInput = keyboard.nextDouble();

        if (userInput == dcNUM) {
            checkCVV();
            return true;
        } else {
            System.out.println("\nIncorrect debit card number, please try again.");
            return checkDebitCardNum();
        }
    }

    public boolean checkCVV() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your CVV (3 digits on the back) for confirmation: ");
        int userInput = keyboard.nextInt(); // user's input word
        if (userInput == CVV) {
            return true;
        } else {
            System.out.println("Incorrect CVV number, please try again.");
            return checkCVV();
        }
    }

    public boolean checkRoutingNumber() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your routing number for confirmation: ");
        int userInput = keyboard.nextInt(); // user's input word

        if (userInput == RoutingNumber) {
            return true;
        } else {
            System.out.println("\nIncorrect routing number, please try again.");
            return checkRoutingNumber();
        }
    }
    public boolean checkPIN() {
        Scanner keyboard = new Scanner(System.in);
        // checkPin();
        System.out.print("Please enter your 4 digit PIN for confirmation: ");
        int PIN = keyboard.nextInt(); // user's input 
        if (PIN == userPIN) {
            return true;
        } else {
            System.out.println("\nIncorrect PIN, please try again.");
            return checkPIN();
        }

    }

    public boolean checkDigitalSignature() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Sign below.\n");
        String userInput = keyboard.next(); // user's input word

        if (userInput.equals(userName)) {
            return true;
        } else {
            System.out.println("Incorrect signature, please sign again.");
            return checkDigitalSignature();
        }
    }

    public String checkIRS() {
        return "Under the Bank Secrecy Act, you are required to file an IRS form for exceeding the limit";
    }

    public void withdrawDollah() { //happens at bank or atm
        // do we need to specify which type of account we are withdrawing from?
        System.out.println("\nYou are now in the withdraw menu.");
        checkDebitCardNum();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("How much would you like to withdraw? ");
        Double userInput = keyboard.nextDouble(); // user's input word
        Double amount = userInput;
        checkPIN();
        if (amount > 10000) {
            Scanner keyboard2 = new Scanner(System.in);
            System.out.println("You are withdrawing a large amount of money. Are you sure you want to continue? (Y/N)");
            String userInput2 = keyboard2.next(); // user's input word
            if (userInput2.equalsIgnoreCase("y")) {
                System.out.println("You are good to continue.");
                if (amount < balance) {
                    checkDigitalSignature();
                    balance = balance - amount;
                    //totalSpent = totalSpent + amount;
                    System.out.println("Transaction completed. Withdrew $" + amount);
                    System.out.println("Your new balance is $" + balance);
                } else {
                    System.out.println("Not enough money, please try again.");
                    withdrawDollah();
                }
            } else {
                System.out.println("Transaction cancelled.");
            }

        }

    }

    public void spendDollah() {
        // do we need to specify which type of account we are withdrawing from?
        System.out.println("\nYou are now in the spending menu.");
        checkDebitCardNum();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How much would you like to spend? ");
        Double userInput = keyboard.nextDouble(); // user's input word
        Double amount = userInput;
        checkPIN();
        if (amount > 10000) {
            Scanner keyboard2 = new Scanner(System.in);
            System.out.println("You are spending a large amount of money. Are you sure you want to continue? (Y/N)");
            String userInput2 = keyboard2.next(); // user's input word
            if (userInput2.equalsIgnoreCase("y")) {
                System.out.println("You are good to continue.");
                if (amount < balance) {
                    checkDigitalSignature();
                    balance = balance - amount;
                    totalSpent = totalSpent + amount;
                    System.out.println("Transaction completed. Spent $" + amount);
                    System.out.println("Your new balance is $" + balance);
                } else {
                    System.out.println("Not enough money, please try again.");
                    spendDollah();
                }
            } else {
                System.out.println("Transaction cancelled.");
            }

        }

    }

    public void depositDollah() {
        System.out.println("\nYou are now in the deposit menu.");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("How much would you like to deposit? ");
        Double userInput = keyboard.nextDouble(); // user's input word
        Double amount = userInput;
        checkPIN(); // secondary security measure

        if (amount >= 10000) {
            System.out.println(checkIRS());
        }
        balance = balance + amount;
        System.out.println("Transaction completed. Deposited $" + amount);
        System.out.println("Your new balance is $" + balance);
    }

    // get method to get the total spent
    public double getTotalSpent() {
        return totalSpent;
    }
    public void setBalance(double b) {
        abc.getCheckingAccount().setBalance(b);
        balance = b;
    }
}

class Credit extends Debit {
    private double balance;
    //private int RoutingNumber;
    private double totalSpent = 0.0;
    private int userPIN;
    private double ccNUM;
    private int CVV;
    private double creditlimit;
    private String userName;
    private static user abc;
    Credit() {
        balance = 0.00;
        //RoutingNumber = 420691234;
        ccNUM = 1111123443216969.0;
        CVV = 420;
        creditlimit = 20000;
    }
    Credit(double bal, int PIN, String name, double num2, int numcvv, double limit) {
        balance = bal;
        //RoutingNumber = num;
        userPIN = PIN;
        userName = name;
        ccNUM = num2;
        numcvv = CVV;
        creditlimit = limit;
    }

    Credit(double bal, int PIN, String name, double num2, int numcvv, double limit, user Person) {
        balance = bal;
        //RoutingNumber = num;
        userPIN = PIN;
        userName = name;
        ccNUM = num2;
        numcvv = CVV;
        creditlimit = limit;
        abc = Person;
    }

    public double getCCNum() {
        return ccNUM;
    }

    public boolean checkCreditCardNum() { // checks credit card number AND cvv together
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your credit card number for confirmation: ");
        double userInput = keyboard.nextDouble();

        if (userInput == ccNUM) {
            checkCVV();
            return true;
        } else {
            System.out.println("\nIncorrect credit card number, please try again.");
            return checkDebitCardNum();
        }
    }
    
    public void setUser(user person) {
        abc = person;
    }
    
    public boolean checkLimit() {
        if (getTotalSpent() > creditlimit) {
            System.out.println("You are over your credit limit.");
            return false;
        } else {
            return true;
        }
    }

    public void spendDollah() {
        // do we need to specify which type of account we are withdrawing from?
        checkCreditCardNum();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How much are you spending? ");
        Double userInput = keyboard.nextDouble(); // user's input word
        Double amount = userInput;
        checkPIN();
        if (checkLimit()) {
            if (amount > 10000) {
                Scanner keyboard2 = new Scanner(System.in);
                System.out.println("You are spending a large amount of money. Are you sure you want to continue? (Y/N)");
                String userInput2 = keyboard2.next(); // user's input word
                if (userInput2.equalsIgnoreCase("y")) {
                    System.out.println("You are good to continue.");
                    if (amount < balance) {
                        checkDigitalSignature();
                        balance = balance - amount;
                        totalSpent = totalSpent + amount;
                        System.out.println("Transaction completed. Spent $" + amount);
                        System.out.println("Your new balance is $" + balance);
                    } else {
                        System.out.println("Not enough money, please try again.");
                        spendDollah();
                    }
                } else {
                    System.out.println("Transaction cancelled.");
                }

            }

        }
    }

    public double getTotalDueEOM() {
        //gets the total due at the EOM
        return totalSpent;
    }
    public void setBalance(double b) {
        abc.getCheckingAccount().setBalance(b);
        balance = b;
    }
}
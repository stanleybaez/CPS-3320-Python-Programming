/*          ONLINE BANKING
 *          Definition: Online banking through traditional banks enables customers to perform all routine transactions, such as 
 *          account transfers, balance inquiries, bill payments, and stop-payment requests. Some even offer online loans and credit card applications.
 * 			
 * 			Job: create a system that can allow customers to
 * 			- check their balance
 * 			- pay their bills-??
 * 			- send stop payment requests
 * 			- perform account transfers
 * 			- apply for credit cards
 * 			- apply for online loans
 *			- etc.
 * 
 * 			Important details: 
 * 			- stop payment is a formal request made to a financial institution to cancel a check or payment that has not yet been processed
 * 			- an account transfer involves the movement of assets, monetary funds, and/or ownership rights from one account to another.
 * 
 * 			Online Banking Class Details
 * 			
 * 			METHODS
 * 			* - unsure
 * 
 * 			double getBalance() - returns the balance in the account
 * 			-- void payBill(string/int billIdentifier) - pays off a bill of billIdentifier and subtracts the amount from balance
 * 			-- void sendStopPaymentReq(string/int checkIdentifier) - sends a request to recipient of check of checkIdentifier to cancel payment
 * 			Account* transferAccount(Account newAccount) - transfers current account to the new account given
 * 			Card* applyForCard() - applies for card and returns card if accepted
 * 			void applyForLoan(Loan loanType, double requestedAmount) - applies for loan, when accepted cash is supplied and slowly depletes over time at the rate bank decides
 * 			
 * 			PROPERTIES
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBanking {
    //public static Bank bank = new Bank();

    public static Scanner input = new Scanner(System.in);

    public interface userChoice {
        void choose(user person);
    }

    private static userChoice[] methodList = new userChoice[] {
        new userChoice() {
                public void choose(user person) {
                    // getBalance

                    // get balance from user's saving account
                    System.out.println("Which account would you like to get the balance of?");
                    System.out.println("1) Checking Account");
                    System.out.println("2) Savings Account");

                    int choice = -1;

                    while (choice != 1 && choice != 2) {
                        choice = input.nextInt();

                        if (choice != 1 && choice != 2) {
                            System.out.println("Cannot recognize input. Please try again.");
                        }
                    }

                    if (choice == 1) {
                        System.out.println("Balance: $" + person.getCheckingAccount().getBalance());
                    } else {
                        System.out.println("Balance: $" + person.getSavingsAccount().getBalance());
                    }

                    displayOptions(person);
                }
            }, new userChoice() {
                public void choose(user person) {
                    // getAccountInfo

                    System.out.println("Which account would you like to get the information of?");
                    System.out.println("1) Checking Account");
                    System.out.println("2) Savings Account");

                    int choice = -1;

                    while (choice != 1 && choice != 2) {
                        choice = input.nextInt();

                        if (choice != 1 && choice != 2) {
                            System.out.println("Cannot recognize input. Please try again.");
                        }
                    }

                    if (choice == 1) {
                        CheckingAccount userAcc = person.getCheckingAccount();
                        System.out.println("Account holder: " + userAcc.getName());
                        System.out.println("Account number: " + userAcc.getAccountNum());
                        System.out.println("Balance: $" + userAcc.getBalance());

                    } else {
                        SavingsAccount userAcc = person.getSavingsAccount();
                        System.out.println("Account holder: " + userAcc.getName());
                        System.out.println("Account number: " + userAcc.getAccountNum());
                        System.out.println("Balance: $" + userAcc.getBalance());
                    }

                    displayOptions(person);
                }
            },

            new userChoice() {
                public void choose(user person) {
                    // transferAccount

                    // TODO: use credit card's verification system
                    // WAIT UNTIL PROJECT MASTERS HAVE AN ARRAY OF ACCOUNTS
                    System.out.println(
                        "Are you sure you wish to transfer accounts? All assets and monetary funds will be transfered to the new account.");
                    System.out.println("1) No");
                    System.out.println("2) Yes");

                    int choice = -1;
                    while (choice != 1 && choice != 2) {
                        choice = input.nextInt();
                    }

                    if (choice == 1) {
                        System.out.println("Action cancelled!");

                        displayOptions(person);
                        return;
                    }
                    if (choice == 2) {
                        person.getDebitCard().checkDebitCardNum();

                        System.out.println("Please enter the account number for the account you wish to transfer to.");
                        String newAccNum = "-1";
                        CheckingAccount newAcc;
                        boolean accFound = false;

                        while (accFound == false) {
                            newAccNum = input.nextLine();

                            ArrayList <CheckingAccount> allAccs = user.getAllChecking();
                            for (CheckingAccount acc: allAccs) {
                                if (acc.getAccountNum().equals(newAccNum)) {
                                    newAcc = acc;
                                    accFound = true;
                                }
                            }

                            System.out.println("Account number provided was not found. Please try again.");
                        }

                        // user.setAccount(newAcc);?
                        
                        
                        
                        
                        System.out.println("Account found! Successfully transferred.");
                        displayOptions(person);
                        return;
                    }

                }
            }, new userChoice() {
                public void choose(user person) {
                    // applyForCard

                    if (person.getCreditCard() != null) {
                        System.out.println("You already own a card.");

                        displayOptions(person);
                        return;
                    }

                    System.out.println("Please enter your account number as confirmation.");

                    if (person.getCreditScore() > 650) {
                        // SCRUM MASTERS: REPLACE IF STATEMENT ABOVE WITH CHECK CREDIT SCORE

                        System.out.println("Credit card provided!");

                        displayOptions(person);
                        return;
                    } else {
                        System.out.println("Low credit score, please apply again later!");
                        displayOptions(person);
                        return;

                    }

                    //System.out.println("Debit card granted!");
                    // SCRUM MASTERS: GRANT CREDIT CARD

                    //displayOptions(person);
                    //return;
                }
            }, new userChoice() {
                public void choose(user person) {
                    // applyForLoan
                    // TO-DO: wait for credit score system w/ credit card class
                    //Loan newLoan = new Loan(0, 0, 0);
                    //newLoan.askLoanAmount(input);
                    client.Loan(person);
                    System.out.println("Loan successfully filed!");

                    displayOptions(person);
                }
            }, new userChoice() {
                public void choose(user person) {
                    // exit
                    System.out.println("Thank you for banking with Bing Bong Byron Bank! Bing Bong!");
                    client.Menu(person);
                }
            }
    };

    public static void main(user person) {
        // interface boogaloo
        System.out.println("Welcome to the online banking sector. Please pick an option.");

        displayOptions(person);
    }

    // -------------------------- Misc. Methods ----------------------------\\

    public static void displayOptions(user person) {
        int choice = -1;

        System.out.println("1) Display Balance");
        System.out.println("2) Check Account Info");
        System.out.println("3) Transfer Account");
        System.out.println("4) Apply For Card");
        System.out.println("5) Apply For Loan");
        System.out.println("6) Exit");

        while (choice < 1 || choice > methodList.length) {
            choice = input.nextInt();
        }

        methodList[choice - 1].choose(person);
    }

    /*
     * public static boolean verifyAccountNum(int numProvided) { return
     * Integer.toString(numProvided).equals(bankAccount.getAccountNum()); }
     */
}
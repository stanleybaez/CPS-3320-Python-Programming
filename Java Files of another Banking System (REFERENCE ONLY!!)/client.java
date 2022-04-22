import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class
import java.util.Random;

public class client {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //user abc = new user();
        System.out.println("Welcome to Bing Bong Byron's Banking Services!");
        // CREATING THE USER FOR DEMOS
        

        SavingsAccount savings = new SavingsAccount("Byron", 1000000, 500);
        CheckingAccount checking = new CheckingAccount("Byron", 1000000);
        MoneyMarketAccount moneyacct = new MoneyMarketAccount("Byron", 1000000, 3);
        
        
        CertificateOfDepositAccount cdacct = new CertificateOfDepositAccount("Byron", 1000000);
        InvestmentAccount invacct = new InvestmentAccount(10000);

        Debit myDebit = new Debit(1000000000, 1, 1234, "Byron", 1111987667890069.0, 420);
        Credit myCredit = new Credit(1000000000, 1234, "Byron", 1111987667890069.0, 420, 2000.00);
        safeDepositBox box = new safeDepositBox();
        //box.getSafetyBox().add("GOld Watch");
        user abc = new user("bigbyron123", "secrets456", "BB69420360", savings, checking, moneyacct, cdacct, invacct, myDebit, myCredit, box);
        savings.setUser(abc);
        checking.setUser(abc);
        box.setUser(abc);
        cdacct.setUser(abc);
        moneyacct.setUser(abc);
        invacct.setUser(abc);
        myDebit.setUser(abc);
        myCredit.setUser(abc);
        GreetUser(abc); 

    }
    public static void GreetUser(user DefaultUser) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) Login");
        System.out.println("2) Sign Up");
        System.out.println("3) Exit");

        String userInput = keyboard.nextLine();
        if (userInput.equals("1")) {
            Login(DefaultUser);
        } else if (userInput.equals("2")) {
            SignUp();
        } else if (userInput.equals("3")) {
        	printFunny();
        	System.out.println("\n\nThank you for banking with Bing Bong Byron");
            
            

            System.exit(0);
        } else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            GreetUser(DefaultUser);

        }
    }

    public static void Login(user DefaultUser) {

        // Check credentials
        Scanner keyboard = new Scanner(System.in);
        //System.out.println("Welcome to the menu! Please select what you would like to do.");
        System.out.println("Enter your username: ");
        String inputuser = keyboard.nextLine();
        

        user abc = DefaultUser;
        
        ArrayList < String > usernameArray = null;
        ArrayList < String > passwordArray = null;
        //usernameArray.add("bigbyron123");
        //passwordArray.add("secrets456");
        usernameArray = user.getUsernames();
        passwordArray = user.getPasswords();

        //user newUser = new user("teacher123", "banksecrets");
        int index = 0;
        // first checks if username is in the database
        if (usernameArray.contains(inputuser)) {
            // takes index of where the username is
            index = usernameArray.indexOf(inputuser);
            // gets password
            System.out.println("Enter your password: ");
            String inputpassword = keyboard.nextLine();
            String y = passwordArray.get(index);
            // compares password to the password found at the index
            // ONE user corresponds to the same index for username + password
            if (inputpassword.equals(y)) {
                System.out.println("Login successful!");
                Menu(abc);
                // Display menu
            } else {
                System.out.println("Password incorrect, please try again.");
                Login(DefaultUser);
            }
        } else {
            System.out.println("Username not found, please try again!");
            Login(DefaultUser);
        }

    }

    public static void SignUp() {
        // usera
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your username?");
        String userInput = keyboard.nextLine();
        ArrayList < String > usernameArray;

        usernameArray = user.getUsernames();

        for (String x: usernameArray) {
            if (userInput.equalsIgnoreCase(x)) {
                System.out.println("Username Taken! Consider adding numbers to the end.");
                SignUp();
            }
        }
        String username = userInput;

        // getting password
        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("What is your password?");
        String userInput2 = keyboard.nextLine();

        String password = userInput;

        // creating new user object
        user newUser = new user(username, password);
        newUser.setStatusSavings(false);
        newUser.setStatusChecking(false);
        newUser.setStatusMoney(false);
        newUser.setStatusCOD(false);
        newUser.setStatusINV(false);
        
        System.out.println("Thank you for joining Bing Bong Byron's Banking Services!");
        GettingStarted(newUser);
    }

    public static void GettingStarted(user Person) {
        //Boolean newAccount = true;

        System.out.println("What would you like to do first?");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) Create a bank account");
        System.out.println("2) Add a credit card");
        System.out.println("3) Add a debit card");
        System.out.println("4) Access the safety deposit box");
        System.out.println("5) Access the regular menu");
        System.out.println("6) Exit");

        String userInput = keyboard.nextLine();

        if (userInput.equals("1")) {
            // 4 types of accounts
            System.out.println("Welcome to the accounts menu!");
            NewAccounts(Person);

        } else if (userInput.equals("2")) {
            AddCreditCard(Person);
        } else if (userInput.equals("3")) {
            AddDebitCard(Person);
        } else if (userInput.equals("4")) {
            safeDepositBox.main(Person);
        } else if (userInput.equals("5")) {

            Menu(Person);
        } else if (userInput.equals("6")) {
        	printFunny();
            System.out.println("Thank you for banking with Bing Bong Byron");

            System.exit(0);
        } else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            GettingStarted(Person);
        }

        //Accounts(newAccount);
    }

    public static void Menu(user Person) {
        //Boolean newAccount = false;
        System.out.println("\nWhat would you like to do?");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) Manage Account");
        System.out.println("2) Loan");
        System.out.println("3) Online Banking");
        System.out.println("4) Safety Deposit Box");
        System.out.println("5) Investment");
        System.out.println("6) Foreign Currency Exchange");
        System.out.println("7) ATM");
        System.out.println("8) Insurance Products");
        System.out.println("9) Exit");

        String userInput = keyboard.nextLine();

        if (userInput.equals("1")) {
            System.out.println("Welcome to the accounts menu!");
            Accounts(Person);

            //Accounts(newAccount);
            // decide which account
            // pass the parameter newAccount to decide when checking account whether it is necessary to create one
        } else if (userInput.equals("2")) {

            Loan(Person);
        } else if (userInput.equals("3")) {

            OnlineBanking.main(Person);
            // account for online banking needs to be fixed.
        } else if (userInput.equals("4")) {

            safeDepositBox.main(Person);
        } else if (userInput.equals("5")) {

            InvestmentTest.main(Person);
        } else if (userInput.equals("6")) {

            double balance = Person.getCheckingAccount().getBalance();
            ForeignCurrencyExchange.main(Person, balance);

        } else if (userInput.equals("7")) {

            ATM.main(Person);

        } else if (userInput.equals("8")) {

            InsuranceProducts.main(Person);

        } else if (userInput.equals("9")) {
        	printFunny();
            System.out.println("Thank you for banking with Bing Bong Byron");

            System.exit(0);
        } else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            Menu(Person);
        }
    }

    public static void NewAccounts(user Person) {
        System.out.println("Which type of account would you like to create?");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) Savings Account");
        System.out.println("2) Checking Account");
        System.out.println("3) Certificate of Deposit Account");
        System.out.println("4) Money Market Account");
        System.out.println("5) Investment Account");
        System.out.println("6) Exit");

        String userInput = keyboard.nextLine();

        if (userInput.equals("1")) {

            NewSavingsAccount(Person);

        } else if (userInput.equals("2")) {

            NewCheckingAccount(Person);

        } else if (userInput.equals("3")) {

            NewCertificateOfDepositAccount(Person);

        } else if (userInput.equals("4")) {

            NewMoneyMarketAccount(Person);

        } else if (userInput.equals("5")) {
        	NewInvestmentAccount(Person);
        } else if (userInput.equals("6")) {
        	//System.out.println("Thank you for banking with Bing Bong Byron");
        	System.out.println("Returning you to the menu...");
        	GettingStarted(Person);
        } else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            NewAccounts(Person);
        }
    }

    public static void Accounts(user Person) {

        System.out.println("Which of your accounts would you like to access?");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) Savings Account");
        System.out.println("2) Checking Account");
        System.out.println("3) Certificate of Deposit Account");
        System.out.println("4) Money Market Account");
        System.out.println("5) Investment Account");
        System.out.println("6) Exit");

        String userInput = keyboard.nextLine();

        if (userInput.equals("1")) {

            UserSavingsAccount(Person);
        } else if (userInput.equals("2")) {

            UserCheckingAccount(Person);
        } else if (userInput.equals("3")) {

            CertificateOfDepositAccount(Person);
        } else if (userInput.equals("4")) {

            MoneyMarketAccount(Person);
        } else if (userInput.equals("5")) {
            InvestmentTest.main(Person);
        } else if (userInput.equals("6")) {
            Menu(Person);
        } else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            Accounts(Person);
        }

    }

    public static void NewSavingsAccount(user Person) {
        System.out.println("Welcome to the Savings Account Creation menu!");
        //System.out.println("THIS IS A WORK IN PROGRESS, RETURNING YOU TO THE MENU!");
        //NewAccounts();
        Scanner keyfour = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = keyfour.next();
        System.out.println("Please enter your opening balance: ");
        double balance = keyfour.nextDouble();
        
        double myWithdrawals = 0.0;
        SavingsAccount newsavings = new SavingsAccount(name, balance, myWithdrawals);
        Person.setStatusSavings(true);
        System.out.println("Account created successfully!");
        GettingStarted(Person);
    }

    public static void UserSavingsAccount(user Person) {
    	
    	
    	if (!Person.getStatusSavings()) {
    		System.out.println("I see you do not have a savings account yet...");
    		NewSavingsAccount(Person);
    	}
        System.out.println("What would you like to do?");

        Scanner savingskey = new Scanner(System.in);
        System.out.println("1) Withdraw");
        System.out.println("2) Deposit");
        System.out.println("3) Transfer");
        System.out.println("4) Check Balance");
        System.out.println("5) Exit");

        String userInput = savingskey.nextLine();

        if (userInput.equals("1")) {
            System.out.println("How much money do you want to withdraw? ");
            double withdrawamount = savingskey.nextDouble();
            Person.getSavingsAccount().withdraw(withdrawamount, Person.getSavingsAccount().getBalance(), Person.getSavingsAccount().getMonthlyWithdrawals());

        } else if (userInput.equals("2")) {
            System.out.println("How much money do you want to deposit? ");
            double depositamount = savingskey.nextDouble();
            Person.getSavingsAccount().deposit(depositamount);

        } else if (userInput.equals("3")) {
            Scanner keyboard3 = new Scanner(System.in);
            System.out.println("Enter an amount to transfer");
            double amount = keyboard3.nextDouble();
            Person.getSavingsAccount().transferSavings(amount, Person.getCheckingAccount());

        } else if (userInput.equals("4")) {
            System.out.println("Your balance is $" + Person.getSavingsAccount().getBalance());
            Menu(Person);
        } else if (userInput.equals("5")) {
        	printFunny();
            System.out.println("Thank you for banking with Bing Bong Byron");

            System.exit(0);
        } else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            UserSavingsAccount(Person);
        }
    }

    public static void NewCheckingAccount(user Person) {
    	
        Scanner keyfour = new Scanner(System.in);
        System.out.println("Welcome to the Checking Account Creation menu!");
        System.out.println("Please enter your name: ");
        String name = keyfour.next();
        System.out.println("Please enter your opening balance: ");
        double balance = keyfour.nextDouble();
        CheckingAccount newchecking = new CheckingAccount(name, balance);
        Person.setStatusChecking(true);
        System.out.println("Account created successfully!");
        GettingStarted(Person);

    }

    public static void UserCheckingAccount(user Person) {
    	if (!Person.getStatusChecking()) {
    		System.out.println("I see you do not have a checking account yet...");
    		NewCheckingAccount(Person);
    	}
    	
        System.out.println("What would you like to do?");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) Withdraw");
        System.out.println("2) Deposit");
        System.out.println("3) Transfer");
        System.out.println("4) Check Balance");
        System.out.println("5) Exit");

        String userInput = keyboard.nextLine();

        if (userInput.equals("1")) {
            System.out.println("Please enter the amount that you want to withdraw: ");
            double withdrawamount = keyboard.nextDouble();
            Person.getCheckingAccount().withdraw(withdrawamount, Person.getCheckingAccount().getBalance());

        } else if (userInput.equals("2")) {
            System.out.println("Please enter your checking account number: ");
            String accountnumber = keyboard.next();
            System.out.println("Please enter the amount that you want to deposit: ");
            double depositamount = keyboard.nextDouble();
            Person.getCheckingAccount().deposit(depositamount, Person.getCheckingAccount().getBalance());

        } else if (userInput.equals("3")) {
            Scanner keyboard3 = new Scanner(System.in);
            System.out.println("Enter an amount to transfer");
            double amount = keyboard3.nextDouble();
            Person.getCheckingAccount().transferChecking(amount, Person.getSavingsAccount());
        } else if (userInput.equals("4")) {
            System.out.println("Your balance is $" + Person.getCheckingAccount().getBalance());
            
            Menu(Person);

        } else if (userInput.equals("5")) {
        	printFunny();
            System.out.println("Thank you for banking with Bing Bong Byron");

            System.exit(0);
        } else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            UserCheckingAccount(Person);
        }
    }

    public static void NewCertificateOfDepositAccount(user Person) {
        System.out.println("Welcome to the Certificate of Deposit Creation menu!");
        Scanner keyseven = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = keyseven.next();
        System.out.println("Please enter your opening balance: ");
        double balance = keyseven.nextDouble();
        CertificateOfDepositAccount cod = new CertificateOfDepositAccount(name, balance);
        Person.setStatusCOD(true);
        System.out.println("Account created successfully!");
        GettingStarted(Person);

    }

    public static void CertificateOfDepositAccount(user abc) {
    	if (!abc.getStatusCOD()) {
    		System.out.println("I see you do not have a Certificate of Deposit account yet...");
    		NewCertificateOfDepositAccount(abc);
    	}
    	
        System.out.println("What would you like to do?");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) Withdraw");
        System.out.println("2) Deposit");
        System.out.println("3) Check Balance");
        System.out.println("4) Exit");

        String userInput = keyboard.nextLine();

        if (userInput.equals("1")) {
            System.out.println("Please enter the amount you would like to withdraw.");
            double amount = keyboard.nextDouble();
            double balance = abc.getcod().getBalance();
            abc.getcod().withdraw(amount, balance);
            Menu(abc);
        } else if (userInput.equals("2")) {
            System.out.println("How long do you want to deposit your money? ");
            System.out.println("1) 3 months");
            System.out.println("2) 6 months");
            System.out.println("3) 1 year");
            System.out.println("4) 3 years");
            System.out.println("5) 5 years");
            int time = keyboard.nextInt();
            double deposit = abc.getcod().getdepositamount(time);
            System.out.println("Please enter the amount you would like to deposit.");
            double amount = keyboard.nextDouble();
            double balance = abc.getcod().getBalance();
            abc.getcod().deposit(amount, balance);

            Menu(abc);
        } else if (userInput.equals("3")) {
            double balance = abc.getcod().getBalance();
            System.out.println("Balance: " + balance);
            Menu(abc);
        } else if (userInput.equals("4")) {
        	printFunny();
            System.out.println("Thank you for banking with Bing Bong Byron");

            System.exit(0);
        } else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            CertificateOfDepositAccount(abc);
        }
    }

    public static void NewMoneyMarketAccount(user Person) {
        System.out.println("Welcome to the Money Market Account Creation menu!");
        Scanner keysix = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = keysix.next();
        System.out.println("Please enter your opening balance: ");
        double balance = keysix.nextDouble();
        System.out.println("Please enter the number of months that you would like to deposit the money for. ");
        int months = keysix.nextInt();
        MoneyMarketAccount newmoney = new MoneyMarketAccount(name, balance, months);
        Person.setStatusMoney(true);
        System.out.println("Account created successfully!");
        GettingStarted(Person);
        

    }

    public static void MoneyMarketAccount(user abc) {
    	if (!abc.getStatusMoney()) {
    		System.out.println("I see you do not have a Money Market account yet...");
    		NewMoneyMarketAccount(abc);
    	}
        System.out.println("What would you like to do?");
        Scanner keyboardsix = new Scanner(System.in);
        System.out.println("1) Withdraw");
        System.out.println("2) Deposit");
        System.out.println("3) Check Balance");
        System.out.println("4) Exit");

        String userInput = keyboardsix.nextLine();

        if (userInput.equals("1")) {
            double balance = abc.getMoneyMarket().getBalance();
            System.out.println("Please enter the amount that you would like to widthraw");
            double withdraw = keyboardsix.nextDouble();
            abc.getMoneyMarket().withdraw(withdraw, balance);
            Menu(abc);
        } else if (userInput.equals("2")) {
            double balance = abc.getMoneyMarket().getBalance();
            System.out.println("Please the enter the amount that you would like to deposit.");
            double deposit = keyboardsix.nextDouble();
            abc.getMoneyMarket().deposit(deposit, balance);
            Menu(abc);

        } else if (userInput.equals("3")) {
            double balance = abc.getMoneyMarket().getBalance();
            System.out.println("Balance: " + balance);
            Menu(abc);

        } else if (userInput.equals("4")) {
        	printFunny();
            System.out.println("Thank you for banking with Bing Bong Byron");
            System.exit(0);
        } else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            MoneyMarketAccount(abc);
        }

    }
    
    public static void NewInvestmentAccount(user Person) {
        System.out.println("Welcome to the Investment Account Creation menu!");
        Scanner keysix = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = keysix.next();
        System.out.println("Please enter your opening balance: ");
        double balance = keysix.nextDouble();
        
        InvestmentAccount newinvest = new InvestmentAccount(balance, Person);
        Person.setStatusINV(true);
        System.out.println("Account created successfully!");
        GettingStarted(Person);

    }
    
    
    public static void AddCreditCard(user Person) {
        System.out.println("Welcome to the Add A Credit Card Menu!");

        System.out.println("First we need to ask some questions.");
        // establishing the properties of the card
        Scanner keyboard4 = new Scanner(System.in);
        System.out.println("What name should the card be under?");
        String name = keyboard4.nextLine();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your balance?");
        Double balance = keyboard.nextDouble();


        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("What is your PIN number?");
        int PIN = keyboard2.nextInt();
        

        Scanner keyboard3 = new Scanner(System.in);
        System.out.println("What is your credit limit?");
        double limit = keyboard3.nextInt();
     
        // randomly generate CVV and credit card number
        Random rand = new Random();
        int upperbound = 1000;
        int CVV = rand.nextInt(upperbound);

        String ccnum = "1111";

        double min = 1000.0;
        double max = 9999.0;
        Random rand2 = new Random();
        double randomValue = min + ((max - min) * rand2.nextDouble());
        //System.out.println(randomValue);
        String first4cc = Double.toString(randomValue).substring(0, 4);

        double randomValue2 = min + ((max - min) * rand.nextDouble());
        String second4cc = Double.toString(randomValue2).substring(0, 4);

        double randomValue3 = min + ((max - min) * rand.nextDouble());
        String third4cc = Double.toString(randomValue3).substring(0, 4);

        String finalcc = ccnum + first4cc + second4cc + third4cc;
        String newString = finalcc.substring(0, 16);

        //System.out.println(newString);

        double finalccnum = Double.parseDouble(newString);

        Credit userCredit = new Credit(balance, PIN, name, finalccnum, CVV, limit, Person);

        System.out.println("Congratulations on your credit card! Keep this information safe!");
        System.out.println("Credit card Number: " + newString);
        System.out.println("What would you like to do next?");

        GettingStarted(Person);
    }

    public static void AddDebitCard(user Person) {
        System.out.println("Welcome to the Add A Debit Card Menu!");

        System.out.println("First we need to ask some questions.");
        // establishing the properties of the card
        Scanner keyboard4 = new Scanner(System.in);
        System.out.println("What name should the card be under?");
        String name = keyboard4.nextLine();

        Scanner keyboard5 = new Scanner(System.in);
        System.out.println("What is the routing number of the connected bank account?");
        int routingnum = keyboard5.nextInt();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your balance?");
        Double balance = keyboard.nextDouble();

        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("What is your PIN number?");
        int PIN = keyboard2.nextInt();
        
        Scanner keyboard3 = new Scanner(System.in);
        System.out.println("What is your credit limit?");
        double limit = keyboard3.nextInt();
      

        // randomly generate CVV and debit card number
        Random rand = new Random();
        int upperbound = 1000;
        int CVV = rand.nextInt(upperbound);

        String dcnum = "1111";

        double min = 1000.0;
        double max = 9999.0;
        Random rand2 = new Random();
        double randomValue = min + ((max - min) * rand2.nextDouble());
        //System.out.println(randomValue);
        String first4dc = Double.toString(randomValue).substring(0, 4);

        double randomValue2 = min + ((max - min) * rand.nextDouble());
        String second4dc = Double.toString(randomValue2).substring(0, 4);

        double randomValue3 = min + ((max - min) * rand.nextDouble());
        String third4dc = Double.toString(randomValue3).substring(0, 4);

        String finaldc = dcnum + first4dc + second4dc + third4dc;
        String newString = finaldc.substring(0, 16);

        //System.out.println(newString);

        double finaldcnum = Double.parseDouble(newString);

        Debit userDebit = new Debit(balance, routingnum, PIN, name, finaldcnum, CVV, Person);
        
        System.out.println("Congratulations on your debit card! Keep this information safe!");
        System.out.println("Debit card Number: " + newString);
        System.out.println("What would you like to do next?");
        
    
        GettingStarted(Person);

    }

    public static void Loan(user Person) {
        System.out.println("Welcome to the Loan Menu!");
        System.out.println("Which type of loan would you like to take out?");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) College Loan");
        System.out.println("2) Commercial Business Loans");
        System.out.println("3) Home Equity Loan");
        System.out.println("4) Mortgage Loan");
        System.out.println("5) Exit");

        String userInput = keyboard.nextLine();

        if (userInput.equals("1")) {
            CollegeOutput.main(Person);
            // CHECK IF IT HAS ENOUGH IN BALANCE!
        } else if (userInput.equals("2")) {
            CBLoanOutput.main(Person);
        } else if (userInput.equals("3")) {
            HomeEquityLoan.main(Person);
        } else if (userInput.equals("4")) {
            MortgageLoan.main(Person);
        } else if (userInput.equals("5")) {
            Menu(Person);
        } else {
            System.out.println("Sorry! I did not understand that input, please try again.");
            Loan(Person);
        }

    }
    
    
    
    
    public static void printFunny() {
    	System.out.println("BBBBBBBBBBBBBBBBB     iiii                                            BBBBBBBBBBBBBBBBB                                                               BBBBBBBBBBBBBBBBB                                                                                        BBBBBBBBBBBBBBBBB                                      kkkkkkkk           ");
        System.out.println("B::::::::::::::::B   i::::i                                           B::::::::::::::::B                                                              B::::::::::::::::B                                                                                       B::::::::::::::::B                                     k::::::k           ");
        System.out.println("B::::::BBBBBB:::::B   iiii                                            B::::::BBBBBB:::::B                                                             B::::::BBBBBB:::::B                                                                                      B::::::BBBBBB:::::B                                    k::::::k           ");
        System.out.println("BB:::::B     B:::::B                                                  BB:::::B     B:::::B                                                            BB:::::B     B:::::B                                                                                     BB:::::B     B:::::B                                   k::::::k           ");
        System.out.println("  B::::B     B:::::Biiiiiiinnnn  nnnnnnnn       ggggggggg   ggggg       B::::B     B:::::B   ooooooooooo   nnnn  nnnnnnnn       ggggggggg   ggggg       B::::B     B:::::Byyyyyyy           yyyyyyyrrrrr   rrrrrrrrr      ooooooooooo   nnnn  nnnnnnnn           B::::B     B:::::B  aaaaaaaaaaaaa  nnnn  nnnnnnnn     k:::::k    kkkkkkk");
        System.out.println("  B::::B     B:::::Bi:::::in:::nn::::::::nn    g:::::::::ggg::::g       B::::B     B:::::B oo:::::::::::oo n:::nn::::::::nn    g:::::::::ggg::::g       B::::B     B:::::B y:::::y         y:::::y r::::rrr:::::::::r   oo:::::::::::oo n:::nn::::::::nn         B::::B     B:::::B  a::::::::::::a n:::nn::::::::nn   k:::::k   k:::::k ");
        System.out.println("  B::::BBBBBB:::::B  i::::in::::::::::::::nn  g:::::::::::::::::g       B::::BBBBBB:::::B o:::::::::::::::on::::::::::::::nn  g:::::::::::::::::g       B::::BBBBBB:::::B   y:::::y       y:::::y  r:::::::::::::::::r o:::::::::::::::on::::::::::::::nn        B::::BBBBBB:::::B   aaaaaaaaa:::::an::::::::::::::nn  k:::::k  k:::::k  ");
        System.out.println("  B:::::::::::::BB   i::::inn:::::::::::::::ng::::::ggggg::::::gg       B:::::::::::::BB  o:::::ooooo:::::onn:::::::::::::::ng::::::ggggg::::::gg       B:::::::::::::BB     y:::::y     y:::::y   rr::::::rrrrr::::::ro:::::ooooo:::::onn:::::::::::::::n       B:::::::::::::BB             a::::ann:::::::::::::::n k:::::k k:::::k   ");
        System.out.println("  B::::BBBBBB:::::B  i::::i  n:::::nnnn:::::ng:::::g     g:::::g        B::::BBBBBB:::::B o::::o     o::::o  n:::::nnnn:::::ng:::::g     g:::::g        B::::BBBBBB:::::B     y:::::y   y:::::y     r:::::r     r:::::ro::::o     o::::o  n:::::nnnn:::::n       B::::BBBBBB:::::B     aaaaaaa:::::a  n:::::nnnn:::::n k::::::k:::::k    ");
        System.out.println("  B::::B     B:::::B i::::i  n::::n    n::::ng:::::g     g:::::g        B::::B     B:::::Bo::::o     o::::o  n::::n    n::::ng:::::g     g:::::g        B::::B     B:::::B     y:::::y y:::::y      r:::::r     rrrrrrro::::o     o::::o  n::::n    n::::n       B::::B     B:::::B  aa::::::::::::a  n::::n    n::::n k:::::::::::k     ");
        System.out.println("  B::::B     B:::::B i::::i  n::::n    n::::ng:::::g     g:::::g        B::::B     B:::::Bo::::o     o::::o  n::::n    n::::ng:::::g     g:::::g        B::::B     B:::::B      y:::::y:::::y       r:::::r            o::::o     o::::o  n::::n    n::::n       B::::B     B:::::B a::::aaaa::::::a  n::::n    n::::n k:::::::::::k     ");
        System.out.println("  B::::B     B:::::B i::::i  n::::n    n::::ng::::::g    g:::::g        B::::B     B:::::Bo::::o     o::::o  n::::n    n::::ng::::::g    g:::::g        B::::B     B:::::B       y:::::::::y        r:::::r            o::::o     o::::o  n::::n    n::::n       B::::B     B:::::Ba::::a    a:::::a  n::::n    n::::n k::::::k:::::k    ");
        System.out.println("BB:::::BBBBBB::::::Bi::::::i n::::n    n::::ng:::::::ggggg:::::g      BB:::::BBBBBB::::::Bo:::::ooooo:::::o  n::::n    n::::ng:::::::ggggg:::::g      BB:::::BBBBBB::::::B        y:::::::y         r:::::r            o:::::ooooo:::::o  n::::n    n::::n     BB:::::BBBBBB::::::Ba::::a    a:::::a  n::::n    n::::nk::::::k k:::::k   ");
        System.out.println("B:::::::::::::::::B i::::::i n::::n    n::::n g::::::::::::::::g      B:::::::::::::::::B o:::::::::::::::o  n::::n    n::::n g::::::::::::::::g      B:::::::::::::::::B          y:::::y          r:::::r            o:::::::::::::::o  n::::n    n::::n     B:::::::::::::::::B a:::::aaaa::::::a  n::::n    n::::nk::::::k  k:::::k  ");
        System.out.println("B::::::::::::::::B  i::::::i n::::n    n::::n  gg::::::::::::::g      B::::::::::::::::B   oo:::::::::::oo   n::::n    n::::n  gg::::::::::::::g      B::::::::::::::::B          y:::::y           r:::::r             oo:::::::::::oo   n::::n    n::::n     B::::::::::::::::B   a::::::::::aa:::a n::::n    n::::nk::::::k   k:::::k ");
        System.out.println("BBBBBBBBBBBBBBBBB   iiiiiiii nnnnnn    nnnnnn    gggggggg::::::g      BBBBBBBBBBBBBBBBB      ooooooooooo     nnnnnn    nnnnnn    gggggggg::::::g      BBBBBBBBBBBBBBBBB          y:::::y            rrrrrrr               ooooooooooo     nnnnnn    nnnnnn     BBBBBBBBBBBBBBBBB     aaaaaaaaaa  aaaa nnnnnn    nnnnnnkkkkkkkk    kkkkkkk");
        System.out.println("                                                         g:::::g                                                                         g:::::g                                y:::::y                                                                                                                                                  ");
        System.out.println("                                             gggggg      g:::::g                                                             gggggg      g:::::g                               y:::::y                                                                                                                                                   ");
        System.out.println("                                             g:::::gg   gg:::::g                                                             g:::::gg   gg:::::g                              y:::::y                                                                                                                                                    ");
        System.out.println("                                              g::::::ggg:::::::g                                                              g::::::ggg:::::::g                             y:::::y                                                                                                                                                     ");
        System.out.println("                                               gg:::::::::::::g                                                                gg:::::::::::::g                             yyyyyyy                                                                                                                                                      ");
        System.out.println("                                                 ggg::::::ggg                                                                    ggg::::::ggg                                                                                                                                                                                            ");
        System.out.println("                                                    gggggg                                                                          gggggg                                                                                                                                                                                               ");
        
    }

}

class user {
    private static String accountNumber;

    private static String myUsername;
    private static String myPassword;

    private static SavingsAccount savings;
    private static CheckingAccount checking;

    private safeDepositBox safetybox; //should have constructors?
    private static Debit debitCard;
    private static Credit creditCard;

    private static MoneyMarketAccount moneyMarket;
    private static CertificateOfDepositAccount cod;
    private static InvestmentAccount inv;

    private static boolean hasSavingsAccount = false;
    private static boolean hasCheckingAccount = false;
    private static boolean hasMoneyMarketAccount = false;
    private static boolean hasCODAccount = false;
    private static boolean hasInvestmentAccount = false;

    
    
    private static CollegeLoan collegeloan;

    //private double creditScore;

    Random rand = new Random();
    int max = 50;
    int min = -50;
    double n = rand.nextInt((max - min) + min);

    private double creditScore = 650.0 + n;

    //private static CommercialBusinessLoan cbusinessloan;
    //private static HomeEquityLoan hequityloan;
    //private static MortgageLoan mortgageloan;

    // ADD LOAN STUFF

    // DATABASE OF BANK
    private static ArrayList < String > allUsernames = new ArrayList < String > ();
    private static ArrayList < String > allPasswords = new ArrayList < String > ();

    private static ArrayList < Credit > allCreditCards = new ArrayList < Credit > ();
    private static ArrayList < Debit > allDebitCards = new ArrayList < Debit > ();

    private static ArrayList < safeDepositBox > allSafetyBoxes = new ArrayList < safeDepositBox > ();

    private static ArrayList < String > allAccountNumbers = new ArrayList < String > ();

    private static ArrayList < CollegeLoan > allCollegeLoans = new ArrayList < CollegeLoan > ();
    private static ArrayList < CBLoan > allCBusinessLoans = new ArrayList < CBLoan > ();
    private static ArrayList < HomeEquityLoan > allHEquityLoans = new ArrayList < HomeEquityLoan > ();
    private static ArrayList < MortgageLoan > allMortgageLoans = new ArrayList < MortgageLoan > ();

    private static ArrayList < CheckingAccount > allCheckingAccounts = new ArrayList < CheckingAccount > ();
    private static ArrayList < SavingsAccount > allSavingsAccounts = new ArrayList < SavingsAccount > ();
    private static ArrayList < MoneyMarketAccount > allMoneyMarketAccounts = new ArrayList < MoneyMarketAccount > ();
    private static ArrayList < CertificateOfDepositAccount > allCertificateOfDepositAccounts = new ArrayList < CertificateOfDepositAccount > ();
    private static ArrayList < InvestmentAccount > allInvestmentAccounts = new ArrayList < InvestmentAccount > ();
    
    
    /*public user() {
        //allUsernames.add("bigbyron123");
        //allPasswords.add("secrets456");
        myUsername = "bigbyron123";
        myPassword = "secrets456";
        savings = new SavingsAccount("Mr.C", 100, 20);
        checking = new CheckingAccount("Mr.C", 50);
        moneyMarket = new MoneyMarketAccount("Mr. C", 50, 6);
        inv = new InvestmentAccount(10000);
        debitCard = new Debit(1000000000, 1, 1234, "Byron", 1111987667890069.0, 420);
        creditCard = new Credit(1000000000, 1234, "Byron", 1111987667890069.0, 420, 2000.00);

        // randomly generating an account number
        // EX: BB69420360
        Random rand = new Random();
        String card = "BB";
        for (int i = 0; i < 8; i++) {
            int n = rand.nextInt(10) + 0;
            card += Integer.toString(n);
        }

        accountNumber = card;

        allUsernames.add(myUsername);
        allPasswords.add(myPassword);
        allCreditCards.add(creditCard);
        allDebitCards.add(debitCard);
        allSafetyBoxes.add(safetybox);
        allAccountNumbers.add(accountNumber);
    }*/
    public user(String username, String password) {
        //allUsernames.add("bigbyron123");
        //allPasswords.add("secrets456");
        // another constructor FOR NEW USERS bc they don't have savings account/checking accounts
        myUsername = username;
        myPassword = password;
        allUsernames.add(myUsername);
        allPasswords.add(myPassword);
    }
    public user(String username, String password, String acnum, SavingsAccount sav, CheckingAccount check, MoneyMarketAccount moneym, CertificateOfDepositAccount codaccount, InvestmentAccount invacct, Debit deb, Credit cred, safeDepositBox box) {

        //allUsernames.add("bigbyron123");
        //allPasswords.add("secrets456");
        myUsername = username;
        myPassword = password;

        savings = sav;
        checking = check;
        debitCard = deb;
        creditCard = cred;
        safetybox = box;
        accountNumber = acnum;
        moneyMarket = moneym;
        cod = codaccount;
        inv = invacct;

        allUsernames.add(myUsername);
        allPasswords.add(myPassword);
        allCreditCards.add(creditCard);
        allDebitCards.add(debitCard);
        allSafetyBoxes.add(safetybox);
        allAccountNumbers.add(accountNumber);
        
        hasSavingsAccount = true;
        hasCheckingAccount = true;
        hasMoneyMarketAccount = true;
        hasCODAccount = true;
        hasInvestmentAccount = true;
        
        allCheckingAccounts.add(checking);
        allSavingsAccounts.add(savings);
        allCertificateOfDepositAccounts.add(cod);
        allInvestmentAccounts.add(inv);
        allMoneyMarketAccounts.add(moneyMarket);
        
    }
    
    public static ArrayList < CheckingAccount > getAllChecking() {
    	return allCheckingAccounts;
    }
    public static ArrayList < SavingsAccount > getAllSavings() {
    	return allSavingsAccounts;
    }
    public static ArrayList < CertificateOfDepositAccount > getAllCOD() {
    	return allCertificateOfDepositAccounts;
    }
    public static ArrayList < InvestmentAccount > getAllINV() {
    	return allInvestmentAccounts;
    }
    public static ArrayList < MoneyMarketAccount > getAllMoney() {
    	return allMoneyMarketAccounts;
    }
    
    public boolean getStatusSavings() {
    	return hasSavingsAccount;
    }
    public boolean getStatusChecking() {
    	return hasCheckingAccount;
    }
    public boolean getStatusMoney() {
    	return hasMoneyMarketAccount;
    }
    public boolean getStatusCOD() {
    	return hasCODAccount;
    }
    public boolean getStatusINV() {
    	return hasInvestmentAccount;
    }
    
    public String getusername() {
        return myUsername;
    }
    public double getCreditScore() {
        return creditScore;
    }
    public String getpassword() {
        return myPassword;
    }
    public Credit getCreditCard() {
        return creditCard;
    }
    public Debit getDebitCard() {
        return debitCard;
    }
    public safeDepositBox getSafetyBox() {
        return safetybox;
    }
    public static ArrayList < String > getUsernames() {
        return allUsernames;
    }
    public static ArrayList < String > getPasswords() {
        return allPasswords;
    }
    public CheckingAccount getCheckingAccount() {
        return checking;
    }
    public SavingsAccount getSavingsAccount() {
        return savings;
    }
    public MoneyMarketAccount getMoneyMarket() {
        return moneyMarket;
    }
    public CertificateOfDepositAccount getcod() {
        return cod;
    }
    public static InvestmentAccount getinv() {
        return inv;
    }
    public static String getAccountNumber() {
        return accountNumber;
    }
    // set methods

    public void setUsername(String username) {
        myUsername = username;
    }
    public void setPassword(String password) {
        myPassword = password;
    }
    
    public void setStatusSavings(boolean flag) {
    	hasSavingsAccount = flag;
    }
    public void setStatusChecking(boolean flag) {
    	hasCheckingAccount = flag;
    }
    public void setStatusMoney(boolean flag) {
    	hasMoneyMarketAccount = flag;
    }
    public void setStatusCOD(boolean flag) {
    	hasCODAccount = flag;
    }
    public void setStatusINV(boolean flag) {
    	hasInvestmentAccount = flag;
    }
    

}
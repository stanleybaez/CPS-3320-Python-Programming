public class SavingsAccount {
    private static int routingNumber = 36073182;
    private String myName;
    private int myAccountNum;
    private double myBalance;
    private double myMonthlyWithdrawals;
    private static user abc;

    //(int) (Math.random() * (HI - LO + 1)) + LO
    SavingsAccount(String Name, double balance, double withdrawal) {
        myName = Name;
        myAccountNum = (int)(Math.random() * (999999999 - 100000000 + 1)) + 100000000;
        myBalance = balance;
        myMonthlyWithdrawals = withdrawal;
    }
    SavingsAccount(String Name, double balance, double withdrawal, user Person) {
        myName = Name;
        myAccountNum = (int)(Math.random() * (999999999 - 100000000 + 1)) + 100000000;
        myBalance = balance;
        myMonthlyWithdrawals = withdrawal;
        abc = Person;
    }

    //get methods
    public int getAccountNum() {
        return myAccountNum;
    }
    public double getBalance() {
        return myBalance;
    }
    public double getMonthlyWithdrawals() {
        return myMonthlyWithdrawals;
    }
    public int getRoutingNum() {
        return (routingNumber);
    }
    public String getName() {
        return (myName);
    }
    //modifier methods
    public void deposit(double d) {
        myBalance += d;
        System.out.println("You succesfully deposited " + "$" + d);
        setBalance(myBalance);
        client.Menu(abc); // return to menu!

    }
    public void withdraw(double w, double myBalance, double myMonthlyWithdrawals) {
    	if (w < 0) {
    		System.out.println("Input not understood, please try again!");
    		client.Menu(abc);
    		//withdraw(w, myBalance, myMonthlyWithdrawals);
    	}
        if (w <= myBalance) {
            myBalance -= w;
            myMonthlyWithdrawals += 1;
            System.out.println("You succesfully withdrew " + "$" + String.format("%.2f", w));
            setBalance(myBalance);
            client.Menu(abc); // return to menu!
        } else {
            System.out.println("You don't have enough to make that withdrawal. Your current balance is " + String.format("%.2f", myBalance));
            client.UserSavingsAccount(abc); // return to the proper menu
        }
        if (myMonthlyWithdrawals == 6) {
            myBalance -= 50;
            System.out.println("You made too many withdrawals this month and you've been charged a $50 fee");
            client.Menu(abc); // return to menu!
        }
    }
    public void transferSavings(double amount, CheckingAccount user) {
    	if (amount < 0 || amount>myBalance) {
    		System.out.println("Input not understood, please try again!");
    		client.Menu(abc);
    	}
        myBalance -= amount;
        setBalance(myBalance);
        user.deposit(amount, user.getBalance());
    }

    public void setBalance(double b) {
        myBalance = b;
    }
    public void setUser(user person) {
        abc = person;
    }
    //interesting methods
    public void newYear(int years) {
        double b = myBalance;
        for (int i = 0; i < years; i++) {
            myBalance = myBalance * 1.01;
            myMonthlyWithdrawals = 0;
        }
        double earned = myBalance - b;
        System.out.println(years + " year(s) have passed, and you have earned " + "$" + String.format("%.2f", earned) + " in interest");
        client.Menu(abc); // return to menu!
    }
    public void newMonth() {
        myMonthlyWithdrawals = 0;
        if (myBalance < 1500) {
            myBalance -= 10;
            System.out.println("Your balance was below 1500, so you've been charged the $10 monthly maintenance fee");
            client.Menu(abc); // return to menu!
        } else {
            System.out.println("Your balance was above 1500, so you didn't have to pay the monthly fee");
            client.Menu(abc); // return to menu!

        }
    }
}
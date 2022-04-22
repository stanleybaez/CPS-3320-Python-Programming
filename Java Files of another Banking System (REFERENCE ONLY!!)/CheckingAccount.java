public class CheckingAccount {
    private String myName;
    private String myAccountNum;
    private double myBalance;
    private static user abc;

    public CheckingAccount() {
        myName = "Mr.C";
        myAccountNum = "9083421009";
        myBalance = 50;
    }

    public CheckingAccount(String Name, double Balance) {
        myName = Name;
        myAccountNum = (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000) + "" + (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000);
        myBalance = Balance;

    }

    public CheckingAccount(String Name, double Balance, user Person) {
        myName = Name;
        myAccountNum = (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000) + "" + (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000);
        myBalance = Balance;
        abc = Person;
    }

    //get methods
    public String getAccountNum() {
        return myAccountNum;
    }
    public double getBalance() {
        return myBalance;
    }

    public String getName() {
        return (myName);
    }
    public void setUser(user person) {
    	abc = person;
    }
    public void deposit(double amount, double balance) {
        if (amount < 0) {
            System.out.println("Amount to be deposited should be positive");
            client.UserCheckingAccount(abc);
        } else {
            balance = balance + amount;
            System.out.println("Amount deposited successfully");
            setBalance(balance);
            client.Menu(abc);

        }
    }

    public void withdraw(double amount, double balance) {
        if (amount < 0) {
            System.out.println("Amount to be withdrawn should be positive");
            client.UserCheckingAccount(abc);
        } else {
            if (balance < amount) {
                System.out.println("Insufficient balance");
                client.UserCheckingAccount(abc);
            } else {
                balance = balance - amount;
                setBalance(balance);
                System.out.println("Amount withdrawn successfully");

                if (balance <= 10) {
                    System.out.println("WARNING: LOW BALANCE!");
                }
                client.Menu(abc);
            }
        }
    }

    public void transferChecking(double amount, SavingsAccount user)
    {
        myBalance-= amount;
        setBalance(myBalance);
        user.deposit(amount);
    }


    public void setBalance(double b) {
        myBalance = b;
    }
}
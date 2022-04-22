import java.util.Scanner;

public class MoneyMarketAccount {
    private String myName;
    private String myAccountNum;
    private double myBalance;
    private int myMonths;
    private static user abc;

    public MoneyMarketAccount() {
        myName = "Mr.C";
        myAccountNum = "3214902256";
        myBalance = 0;
        myMonths = 0;
    }

    public MoneyMarketAccount(String Name, double balance, int months) {
        myName = Name;
        myAccountNum = (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000) + "" + (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000);
        myBalance = balance;
        myMonths = months;
    }

    public MoneyMarketAccount(String Name, double balance, int months, user Person) {
        myName = Name;
        myAccountNum = (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000) + "" + (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000);
        myBalance = balance;
        myMonths = months;
        abc = Person;
    }
    public void setUser(user person) {
        abc = person;
    }
    public String getAccountNum() {
        return myAccountNum;
    }

    public double getBalance() {
        return myBalance;
    }

    public int getMonths() {
        return myMonths;
    }
    public void setBalance(double balance) {
        myBalance = balance;

    }

    public void deposit(double amount, double balance) {
        if (amount <= 0) {
            System.out.println("Amount to be deposited should be positive");
            while (amount < 1000) {
                System.out.println("You need to deposit $1000.00 or more. Please try again.");
                //money = keyboard.nextDouble();
                // ERROR WITH ^^
            }
        } else {
            balance = balance + amount;
            System.out.println("Amount deposited successfully");
            setBalance(balance);
        }

    }

    public void withdraw(double amount, double balance) {
        if (amount <= 0) {
            System.out.println("Amount to be withdrawn should be positive");
            client.MoneyMarketAccount(abc);
        } else {
            if (balance < amount) {
                System.out.println("Insufficient balance");
                client.MoneyMarketAccount(abc);
            } else {
                balance = balance - amount;
                System.out.println("Amount withdrawn successfully");
                setBalance(balance);

                if (balance <= 10) {
                    System.out.println("WARNING: LOW BALANCE!");
                }
                client.Menu(abc);
            }
        }
    }

    public double calculatetotalmoney(double balance, int time) {
        double total = balance * Math.pow(1 + (0.02 / 360), 360 * (time / 12));
        return total;

    }
}
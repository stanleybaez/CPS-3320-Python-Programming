import java.util.Scanner;

public class CertificateOfDepositAccount {

    // Private Variables
    private String myName;
    private String accountNum;
    private double myBalance;
    private static user abc;

    public CertificateOfDepositAccount() {
        myName = "Mr.C";
        accountNum = "5902371359";
        myBalance = 0;
    }

    public CertificateOfDepositAccount(String name, double balance) {
        myName = name;
        myBalance = balance;
        accountNum = (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000) + "" + (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000);
    }

    public CertificateOfDepositAccount(String name, double balance, user Person) {
        myName = name;
        myBalance = balance;
        accountNum = (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000) + "" + (int) Math.floor(Math.random() * (12000 - 10000 + 1) + 10000);
        abc = Person;
    }

    // Methods
    public String getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return myBalance;
    }
    
    public void setUser(user person) {
        abc = person;
    }
    
    public void setBalance(double balance) {
        myBalance = balance;

    }

    public double calculateapy(int choice) {
        double apy = 0;
        if (choice == 1) {
            apy = 0.32;
        }

        if (choice == 2) {
            apy = 0.59;
        }

        if (choice == 3) {
            apy = 0.98;
        }

        if (choice == 4) {
            apy = 1.10;
        }

        if (choice == 5) {
            apy = 1.29;
        }

        return apy;
    }

    public double getdepositamount(int time) {
        Scanner keyboardeight = new Scanner(System.in);
        System.out.println("How much will you be depositing?");
        double money = keyboardeight.nextDouble();

        // Loops
        while (time == 1 && money < 500) {
            System.out.println("You need to deposit $ 500 or more to continue. Please try again.");
            money = keyboardeight.nextDouble();
        }

        while (time == 2 && money < 1000) {
            System.out.println("You need to deposit $ 1000 or more to continue. Please try again.");
            money = keyboardeight.nextDouble();
        }

        while (time == 3 && money < 2000) {
            System.out.println("You need to deposit $ 2000 or more to continue. Please try again.");
            money = keyboardeight.nextDouble();
        }

        while (time == 4 && money < 2500) {
            System.out.println("You need to deposit $ 2500 or more to continue. Please try again.");
            money = keyboardeight.nextDouble();
        }

        while (time == 5 && money < 3500) {
            System.out.println("You need to deposit $ 3500 or more to continue. Please try again.");
            money = keyboardeight.nextDouble();
        }

        return money;

    }

    public void withdraw(double amount, double balance) {
        if (amount <= 0) {
            System.out.println("Amount to be withdrawn should be positive");
            client.CertificateOfDepositAccount(abc);
        } else {
            if (balance < amount) {
                System.out.println("Insufficient balance");
                client.CertificateOfDepositAccount(abc);
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

    public void deposit(double amount, double balance) {
        if (amount <= 0) {
            System.out.println("Amount to be deposited should be positive");
            client.CertificateOfDepositAccount(abc);
        } else {
            balance = balance + amount;
            System.out.println("Amount deposited successfully");
            setBalance(balance);
            client.Menu(abc);

        }
    }

    public static void calculateTotal(double apy, double money) {
        double interest = apy * money;
        double total = interest + money;
        System.out.println("You have deposited " + money);
        System.out.println("At the end of your alloted time, you will have made " + interest + " in interest. Your total will then be " + total + ".");

    }

}
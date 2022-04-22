import java.util.Scanner;

//notes
    // Jan 31: added and edited few lines of code pertaining to transaction fees when selling stock
public class InvestmentAccount{
    private String name;
    private int accountNum;
    private double balance;
    private double totalInvestment; //this value tracks the total amount you have invested which will be used to determine the fee
    private double stockValueH;//high risk stocks (have a higher maximum value than low risk, but also a lower minimum)
    private double stockValueL; //low risk stocks (have a good chance to increase but aren't likely to make a ton of money)
    private double dividendStockValue; //dividends are a type of low risk stock. They pay a percentage of their value quarterly
    private boolean sweep; //determines whether your earnings from dividends are moved into your checking account
    private double stockInvestmentH; //this is the amount you put into high risk stocks
    private double stockInvestmentL; //this is the amount you put into low risk stocks
    private double bondInvestment; //this is the amount that you put into bonds
    private int bondMonths;
    private static user abc;
    private static int routingNum= 36073182;
    private static boolean hasAccount = false;
    InvestmentAccount( double bal, user Person)
    {
        balance=bal;
        accountNum = (int)(Math.random() * (999999999 - 100000000 + 1)) + 100000000;
        totalInvestment=0;
        stockValueH=0;
        stockValueL=0;
        stockInvestmentH=0;
        sweep=false;
        abc=Person;
    }
    InvestmentAccount(double bal) {
        balance = bal;
        accountNum = (int)(Math.random() * (999999999 - 100000000 + 1)) + 100000000;
        totalInvestment = 0;
        stockValueH = 0;
        stockValueL = 0;
        stockInvestmentH = 0;
        hasAccount = true;
    }
    
    public boolean checkStatus() {
    	return hasAccount;
    }
    
    //get methods
    public double getBalance()
    {
        return balance;	
    }
    public int getAccountNum()
    {
        return accountNum;	
    }
    public double getInvested()
    {
        return totalInvestment;	
    }
    public double getStockValueH()
    {
        return stockValueH;
    }
    public double getStockValueL()
    {
        return stockValueL;
    }
    public void setUser(user person) {
        abc = person;
    }
    //modifier methods
    public void deposit(double d)
    {
        balance += d;
        System.out.println("You succesfully deposited " + "$" + d);
    }
    public void withdraw(double w)
    {
    Scanner keyboard= new Scanner (System.in);
    boolean b=false;
    while (b==false)
    {
        if (w <= balance && w>0) 
        {
            balance-=w;
            System.out.println("You successfully withdrew $" + w);
            b=true;
        }
        else 
        {
            System.out.println("Sorry but you have an insufficient balance for this transaction or you have entered a value lower than 0.");
            System.out.println("Please enter a new amount");
            w=keyboard.nextDouble();
        }
    }
    }
    public void sweep(double payment, CheckingAccount user)
    {
    user.deposit(payment, user.getBalance());
    }
    public void setSweep (boolean s)
    {
    sweep=s;	
    }
    //puts money into high risk stocks which will later be multiplied by a random value
    public void investStockH(double investment)
    {
        if (balance>=investment)
            {
            balance-=investment;
            totalInvestment += investment;
            stockValueH+=investment;
            stockInvestmentH+=investment;
            System.out.println("You successfully invested $" + investment + " in high risk stocks");
            }
        else
            {
            System.out.println("You are trying to invest more than you have in your account. Please enter a lower value.");
            }
    }
    public void investStockL(double investment, boolean dividends)
    {
        if (balance>=investment)
            {
        if (dividends==true)
        {
        dividendStockValue=investment;	
        }
            balance-=investment;
            totalInvestment+=investment;
            stockValueL+=investment;
            stockInvestmentL+=investment;
            System.out.println("You successfully invested " + investment + " in low risk stocks");
            }
        else
        {
        System.out.println("You are trying to invest more than you have in your account. Please enter a lower value.");
        }
    }
    
    public void buyBond(double amount, int years)
    {
    balance-=amount;
    bondMonths=years*12;
    bondInvestment+=amount;	
    }
    public void bondPayment()
    {
    if (bondInvestment>0)
    {
    balance+=(bondInvestment*0.02);
    bondMonths-=6;
    System.out.println("Your bond payment of " + bondInvestment*0.02 + " has been sent to your account balance");
    if (bondMonths<=0)
    {
    balance+=bondInvestment;
    bondMonths=0;
    System.out.println("Your bond has reached maturtity and your original investment of " + bondInvestment + " has been returned");
    }
    }
    }
    //this method updates the value of high risk stocks by using a random number 1-5
    public void updateStockH()
    {
    if (stockValueH>0)
    {
        int num=(int)(Math.random() * (5 - 1 + 1)) + 1;
        if (num==1)
        {
            stockValueH*=0.7;
            System.out.println("Your high risk stock's value has dropped by 30%");
        }
        else if (num==2)
        {
            stockValueH*=0.8;
            System.out.println("Your high risk stock's value has dropped by 20%");
        }
        else if (num==3)
        {
             stockValueH*=1.05;
             System.out.println("Your high risk stock's value has increased by 5%");
        }
        else if (num==4)
        {
            stockValueH*=1.20;
            System.out.println("Your high risk stock's value has increased by 20%");
        }
        else if (num==5)
        {
            stockValueH*=1.3;
            System.out.println("Your high risk stock's value has increased by 30%");
        }
    }
    }
    public void updateStockL()
    {
    if (stockValueL>0)
    {
        int num=(int)(Math.random() * (5 - 1 + 1)) + 1;
        if (num==1)
        {
            stockValueL*=0.9;
            System.out.println("Your low risk stock's value has dropped by 10%");
        }
        else if (num==2)
        {
            stockValueL*=1.05;
            System.out.println("Your low risk stock's value has increased by 5%");
        }
        else if (num==3)
        {
            stockValueL*=1.05;
            System.out.println("Your low risk stock's value has increased by 5%");
        }
        else if (num==4)
        {
            stockValueL*=1.15;
            System.out.println("Your low risk stock's value has increased by 15%");
        }
        else if (num==5)
        {
            stockValueL*=1.2;
            System.out.println("Your low risk stock's value has increased by 20%");
        }
    }
    }
    public void sellStockH()
    {
        totalInvestment-=stockInvestmentH;
        balance+=stockValueH;
        stockValueH=0;
        balance-=25;
        System.out.println("Your high risk stocks were successfully sold. You were also charged a $25 transaction fee.");
    }
    public void sellStockL()
    {
        totalInvestment-=stockInvestmentL;
        balance+=stockValueL;
        stockValueL=0;
        dividendStockValue=0;
        balance-=25;
        System.out.println("Your low risk stocks were successfully sold. You were also charged a $25 transaction fee.");
    }
    public void newMonth()
    {
        if (stockValueL>0 || stockValueH>0)
        {
        updateStockH();
        updateStockL();
        double fee = totalInvestment*0.01;
        balance -= fee;
        System.out.println("Your monthly management fee has been charged. You're total investment was "+ totalInvestment + " and the fee was " + fee + ". The fee was removed from your balance.");
        }
        else 
        System.out.println("You don't currently have any stocks to update so you will be returned to the main menu.");
    }

    public void threeMonths()
    {
    if (stockValueH>0 || stockValueL>0) 
    {
      updateStockH();
      updateStockL();
      double fee = 3*(totalInvestment*0.005);
      balance -= fee;
      if (dividendStockValue>0)
      {
      double payment= (dividendStockValue*0.005);
      if (sweep==true)
      {
      System.out.println("You earned " + payment + " from dividends. This was added to your checking account.");
      sweep(payment, abc.getCheckingAccount());
      }
      else
      {
      balance+=payment;
      System.out.println("You earned " + payment + " from dividends. This was added to your balance.");
      }
      }
      System.out.println("Over the last 3 months your managment fees have totaled to " + fee + " This has been removed from your balance");
    }
    else
    System.out.println("You don't currently have any stocks to update so you will be returned to the menu.");
    
    }
    public void sixMonths()
    {
       if (stockValueH>0 || stockValueL>0 || bondInvestment>0)
         {
    updateStockH();
    updateStockL();
    double fee = 6*(totalInvestment*0.01);
    balance -= fee;
    if (dividendStockValue>0)
    {
    double payment= (dividendStockValue*0.01);
    if (sweep==true)
    {
    System.out.println("You earned " + payment + " from dividends. This was added to your checking account.");
    sweep(payment, abc.getCheckingAccount());
    }
    else
    {
    balance+=payment;
    System.out.println("You earned " + payment + " from dividends. This was added to your balance.");
    }
    }
    System.out.println("Over the last 6 months your managment fees have totaled to " + fee + " This has been removed from your balance");
    bondPayment();
    }
    else
     System.out.println("You don't currently have any stocks or bonds so you will be returned to the menu.");
    }
}
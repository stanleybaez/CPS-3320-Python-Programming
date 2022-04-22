import java.util.Scanner;
public class InvestmentTest {
	private static user abc;
	public static void main(user Person) {
		Scanner keyboard= new Scanner (System.in);
		 user abc = Person;
		System.out.println("What balance would you like to put into the account? (This can be invested later)");
		double d=keyboard.nextDouble();
			InvestmentAccount x=new InvestmentAccount(d, abc);
			boolean done=false;
			while (done==false)
			{
            while (x.getBalance()<0)
			{
			System.out.print("Your balance is cuurently " + x.getBalance() + "Please enter an amount to deposit, so your balance is no longer negative.");
			double dep=keyboard.nextDouble();
			x.deposit(dep);
			}
			int choice=0;
			System.out.println("1) Buy high risk stocks");
			System.out.println("2) Buy low risk stocks");
			System.out.println("3) Buy a bond");
			System.out.println("4) Check your balance");
			System.out.println("5) Check the value of your stocks");
			System.out.println("6) advance to next month"); //this is used for the monthly fee and to update stock values
			System.out.println("7) advance by 3 months");
			System.out.println("8) advance by 6 months"); //this applies everything from the new month method but also pays bonds/dividends
			System.out.println("9) Deposit");
			System.out.println("10) Withdraw");
			System.out.println("11) Sell low risk stocks");
			System.out.println("12) Sell high risk stocks");
			System.out.println("13) Return to the main menu");
			choice=keyboard.nextInt();
			if (choice==1)
			{
			boolean exit=false;
			while (exit==false)
			{
			System.out.println("How much would you like to invest?");
			int i=keyboard.nextInt();
			if (i<x.getBalance()&& i>0)
			{
			x.investStockH(i);
			exit=true;
			}
			else
			System.out.println("You entered an invalid amount. Please enter a number that is less than your balance and greater than 0");
			}
			}
			else if (choice==2)
			{
			boolean div=false;
			System.out.println("How much would you like to invest?");
			boolean exit=false;
			double i=5;
			while (exit==false)
			{
			i=keyboard.nextDouble();
			if (i<x.getBalance()&& i>0)
			exit=true;
			else 
			{
			exit=false;
			System.out.println("You entered an invalid amount. Please enter a number that is less than your balance and greater than 0");
			}
			}
			System.out.println("Would you like to buy stocks with dividends?");
			System.out.println("1) Yes");
			System.out.println("2) No");
			int dividends=keyboard.nextInt();
			if (dividends==1)
			{
			div=true;
			System.out.println("Would you like to send your money from dividents directly to your checking account?");
			System.out.println("1) Yes");
			System.out.println("2) No");
			int s=keyboard.nextInt();
			if (s==1)
			{
			x.setSweep(true);
			}
			}
			x.investStockL(i, div);
			}
			else if (choice==3)
			{
			boolean exit=false;
			double i=0;
			while (exit==false)
			{
			System.out.println("How much would you like to invest?");
			i=keyboard.nextDouble();
			if (i<x.getBalance()&& i>0) 
			exit=true;
			else
			{
			exit=false;
			System.out.println("You entered an invalid amount. Please enter a number that is less than your balance and greater than 0");
			}
			}
			System.out.println("How many years do you want the bond for");
			int y=keyboard.nextInt();
			while (y>30 || y<1)
			{
			System.out.println("Please enter an amount between 1 and 30 years");
			y=keyboard.nextInt();
			}
			
			x.buyBond(i, y);
			}
			else if (choice==4)
			{
			System.out.println("Your balance is " + x.getBalance());
			}
			else if (choice==5)
			{
			if (x.getStockValueH()>0)
				System.out.println("Your high risk stocks are worth " + x.getStockValueH());
			if (x.getStockValueL()>0)
				System.out.println("Your low risk stocks are worth " + x.getStockValueL());
			}
			else if (choice==6)
			{
			x.newMonth();
			}
			else if (choice==7)
			{
			x.threeMonths();
			}
			else if (choice==8)
			{
			x.sixMonths();
			}
			else if (choice==9)
			{
			System.out.println("Enter an amount to deposit");
			double amount=keyboard.nextDouble();
			while(amount<0)
			{
			System.out.println("The value you entered is less than 0. Please enter a positive number.");
			amount=keyboard.nextDouble();
			}
			x.deposit(amount);
			}
			else if (choice==10)
			{
			System.out.println("Enter an amount to withdraw");
			double w=keyboard.nextDouble();
			x.withdraw(w);
			}
			else if (choice==11)
			{
			if (x.getStockValueL()>0)
			x.sellStockL();
			else
			System.out.println("It looks like you don't have any low risk stocks at the moment");
			}
			else if (choice==12)
			{
			if (x.getStockValueH()>0)
			x.sellStockH();
			else
			System.out.println("It looks like you don't have any high risk stocks at the moment");
			}
			else if (choice==13)
			{
			done=true;
			client.Menu(abc);
			}
			
	}

}
}
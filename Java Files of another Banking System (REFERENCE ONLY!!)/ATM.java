import java.util.Scanner;

public class ATM {

    public static void main(user Person) {

        //Variables to return to bank menu
        final user abc;
        abc = Person;

        //Accessing balances of accounts
        Debit myDebit = Person.getDebitCard();
        Credit myCredit = Person.getCreditCard();
        SavingsAccount savings = Person.getSavingsAccount();
        CheckingAccount checking = Person.getCheckingAccount();

        //Starting Variables
        Scanner sc = new Scanner(System.in);

        double balanceDebit = myDebit.getATMBalance();
        double balanceCredit = myCredit.getATMBalance();
        double balanceSavings = savings.getBalance();
        double balanceChecking = checking.getBalance();

        double balance = 0;
        double withdraw;
        double deposit;
        double fee = 3.00;

        //Bing Bong Byron Bank ATM Introduction
        System.out.println("\nWelcome to the Bing Bong Byron Bank ATM! \nPlease enter the card you will be using.\n");
        System.out.println("1) Debit");
        System.out.println("2) Credit");

        //Choose type of card to use (credit or debit)
        double cardNum = 0;
        
        String check = "";
        
        for(int i = 0; i < 999; i++)
        {
        	check = sc.nextLine();
        	boolean pass1 = false;
        	
        	if(check.equals("1") || check.equals("2"))
	        {
	        	pass1 = true;
        	} 
        	else 
        	{
        		System.out.println("Invalid Input. Please try again.");
	        	pass1 = false;
        	}
        	
        	if(pass1 == true)
        	{
        		break;
        	}
        }
        
        int cardType = Integer.parseInt(check);
        
        //Input Validation for Card Type

        for (int i = 0; i < 999; i++) {
            boolean pass = false;

            if (cardType == 1) {
                cardNum = myDebit.getDCNum();
                balance = balanceDebit;
                pass = true;
            } else if (cardType == 2) {
                cardNum = myCredit.getCCNum();
                balance = balanceCredit;
                pass = true;
            } else if (cardType < 1 || cardType > 2) {
                System.out.println("Invalid Input. Please try again.");
                pass = false;
            }

            if (pass == true) {
                break;
            }
        }

        //User chooses which account to interact with
        System.out.println("\nPlease choose the bank account you would like to interact with ");
        System.out.println("1) Checking Account");
        System.out.println("2) Savings Account");

        //Input Validation for Account Type

        for(int i = 0; i < 999; i++)
        {
        	check = sc.nextLine();
        	boolean pass = false;
        	
        	if(check.equals("1") || check.equals("2"))
	        {
	        	pass = true;
        	} 
        	else 
        	{
        		System.out.println("Invalid Input. Please try again.");
	        	pass = false;
        	}
        	
        	if(pass == true)
        	{
        		break;
        	}
        }
        
        int accountType = Integer.parseInt(check);
        
        for (int j = 0; j < 999; j++) {
            boolean pass = false;

            if (accountType == 1) {
                balance = balanceChecking;
                pass = true;
            } else if (accountType == 2) {
                balance = balanceSavings;
                pass = true;

            } else if (accountType < 1 || accountType > 2) {
                System.out.println("Invalid Input. Please try again.");
                pass = false;
            }

            if (pass == true) {
                break;
            }
        }

        //Converting card number to string and using substring to get first 4 digits
        String cardNumS = Double.toString(cardNum);
        String bankNum1 = cardNumS.substring(0, 5);
        String bankNum = bankNum1.replaceAll("\\p{Punct}", "");

        //Conditional to check bank number to apply $3.00 fee or not
        if (bankNum.equals("1111")) {
            System.out.println("\nWelcome " + myDebit.getUserName() + "!");
        } else {
            System.out.println("\nWelcome " + myDebit.getUserName() + "! You are not a member of our bank. If you continue, there will be a $3.00 fee. \nDo you wish to continue?\n");
            System.out.println("1) Yes. I agree to the terms and wish to continue using the ATM");
            System.out.println("2) Exit");

            //Input Validation for Applying Fee
            int agree = sc.nextInt();

            for (int j = 0; j < 999; j++) {
                boolean pass = false;

                if (agree == 1) {
                    balance -= fee;
                    pass = true;
                } else if (agree == 2) {
                    System.out.println("\nThank you. Have a good one!");
                    pass = true;
                    client.Menu(abc);
                } else if (agree < 1 || agree > 2) {
                    System.out.println("Invalid Input. Please try again.");
                    pass = false;
                }

                if (pass == true) {
                    break;
                }
            }
        }

        //Uses method from Card class to confirm user PIN
        myDebit.checkPIN();

        //Variable for withdrawal limit
        double withdrawTotal = 0;

        //ATM Menu that will continuously run until user exits
        while (true) {
            System.out.println("\n1) Withdraw (Limit of $2500)");
            System.out.println("2) Deposit");
            System.out.println("3) Check Balance");
            System.out.println("4) EXIT");
            System.out.print("Choose the operation you want to perform: ");

            
            for(int i = 0; i < 999; i++)
        {
        	check = sc.nextLine();
        	boolean pass1 = false;
        	
        	if(check.equals("1") || check.equals("2") || check.equals("3") || check.equals("4"))
	        {
	        	pass1 = true;
        	} 
        	else 
        	{
        		System.out.println("Invalid Input. Please try again.");
	        	pass1 = false;
        	}
        	
        	if(pass1 == true)
        	{
        		break;
        	}
        }
        
        int choice = Integer.parseInt(check);

            switch (choice) {

                //First option (withdraw)
            case 1:
                System.out.println("");

                System.out.print("Enter money to be withdrawn: ");

                String check1 = "";
                
                for(int i = 0; i < 999; i++)
                {
                	check1 = sc.nextLine();
                	boolean pass = false;
                	
                	if(isDouble(check1))
        	        {
        	        	pass = true;
                	} 
                	else 
                	{
                		System.out.println("Invalid Input. Please try again.");
        	        	pass = false;
                	}
                	
                	if(pass == true)
                	{
                		break;
                	}
                }
                
                double with = Double.parseDouble(check1);
                withdraw = with;
                
                withdraw = checkNegativeValue(withdraw);

                if (balance >= withdraw) {
                	if (withdraw > 2500) {
                		System.out.println("\nMaximum withdraw amount reached. Please come back another time.\n");
                        break;
                	}
                	
                    withdrawTotal += withdraw;
                    
                    //Check for withdrawal limit
                    if (withdrawTotal > 2500) {
                        System.out.println("\nMaximum withdraw limit reached. Please come back another time.\n");
                        break;
                    } 

                    //Setting new balance in respective accounts
                    balance = balance - withdraw;

                    if (accountType == 1) {
                        if (cardType == 1) {
                            myDebit.setBalance(balance);
                        } else if (cardType == 2) {
                            myCredit.setBalance(balance);
                        }
                    }

                    if (accountType == 2) {
                        savings.setBalance(balance);
                    }

                    System.out.println("\nSuccessfully withdrew: $" + String.format("%.2f", withdraw) + "\nNew Balance : $" + String.format("%.2f", balance));
                    System.out.println("Please collect your money");
                } else {
                    //Insufficient Balance
                    System.out.println("\nInsufficient Balance");
                    System.out.println("Your current balance is $" + String.format("%.2f", balance));
                }
                System.out.println("");
                break;

                //Second option (deposit)
            case 2:
                System.out.println("");

                System.out.print("Enter money to be deposited: ");

                String check2 = "";
                
                for(int i = 0; i < 999; i++)
                {
                	check2 = sc.nextLine();
                	boolean pass = false;
                	
                	if(isDouble(check2))
        	        {
        	        	pass = true;
                	} 
                	else 
                	{
                		System.out.println("Invalid Input. Please try again.");
        	        	pass = false;
                	}
                	
                	if(pass == true)
                	{
                		break;
                	}
                }
                
                double dep = Double.parseDouble(check2);
                deposit = dep;
                
                deposit = checkNegativeValue(deposit);

                //Adds deposited money to balance
                balance = balance + deposit;

                //Updates balance of respective account
                if (accountType == 1) {
                    if (cardType == 1) {
                        myDebit.setBalance(balance);
                    } else if (cardType == 2) {
                        myCredit.setBalance(balance);
                    }
                }

                if (accountType == 2) {
                    savings.setBalance(balance);
                }

                System.out.println("\nSuccessfully deposited: $" + String.format("%.2f", deposit) + "\nNew Balance : $" + String.format("%.2f", balance));
                System.out.println("");
                break;

                //Third option (check balance)
            case 3:
                System.out.println("");

                System.out.println("Balance : $" + String.format("%.2f", balance));
                System.out.println("");
                break;

                //Fourth option (allows user to exit ATM)
            case 4:
                System.out.println("");

                System.out.println("\nThank you for using Bing Bong Byron Bank ATM Services!\n");
                client.Menu(abc);
            }
        }
    }
   
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static double checkNegativeValue(double ATMvalue) 
    {
    	double myValue = ATMvalue;
    	Scanner scan = new Scanner(System.in);
    	
    	
    	while(myValue < 0)
    	{
    		System.out.println("invalid");
    		myValue = scan.nextDouble();
    	}
    	
    	return myValue;
    	
    }
    
}
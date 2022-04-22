import java.util.Scanner;
import java.util.ArrayList;

public class InsuranceProducts {
    static String[][] insurancePrices = {
        {
            "324",
            "Life Insurance",
            "year"
        },
        {
            "30",
            "Liability Insurance",
            "month"
        },
        {
            "104",
            "Home Owner's Insurance",
            "month"
        }
    };
    static ArrayList<String> ownedInsurance = new ArrayList<String>(3);
    // {Price, Insurance Name}

    public static void main(user person) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Insurance Product sector. Would you like to browse our insurance options?");

        System.out.println("1) Yes");
        System.out.println("2) No");

        int choice = -1;
        while (choice != 1 && choice != 2) {
            choice = input.nextInt();
            if (choice != 1 && choice != 2) {
            	System.out.println("Input not understood. Please try again.");
            }
        }

        if (choice == 2) {
            System.out.println("Action cancelled!");
            client.Menu(person);
        }
        if (choice == 1) {
            System.out.println("Here are our options: ");
            System.out.println("1) Life Insurance - $" + insurancePrices[0][0] + "/" + insurancePrices[0][2]);
            System.out.println("2) Liability Insurance - $" + insurancePrices[1][0] + "/" + insurancePrices[1][2]);
            System.out.println("3) Home Owner's Insurance - $" + insurancePrices[2][0] + "/" + insurancePrices[2][2]);
            System.out.println("4) Exit");

            choice = -1;
            while (choice <= 1 || choice >= 4) {
                choice = input.nextInt();

                if (choice >= 1 && choice <= 3) {
                    String[] insuranceType = insurancePrices[choice - 1];
                    System.out.println("You are about to purchase " + insuranceType[1] + " for $" + insuranceType[0] + "/month. Proceed?");
                    System.out.println("1) Yes");
                    System.out.println("2) No");

                    choice = -1;
                    while (choice != 1 && choice != 2) {
                        choice = input.nextInt();

                        if (choice == 1) {
                            if (!arrayContains(ownedInsurance, insuranceType[1])) {
                                System.out.println("Purchased " + insuranceType[1] + " for $" + insuranceType[0] + "/month.");
                                String price = insuranceType[0];
                                ownedInsurance.add(insuranceType[1]);
                                person.getCheckingAccount().withdraw(Double.parseDouble(price), person.getCheckingAccount().getBalance());
                                
                            } else
                                System.out.println("You already own this type of insurance!");

                            main(null);
                        } else if (choice == 2) {
                            System.out.println("Action cancelled!");
                            main(null);
                        } else {
                        	System.out.println("Input not understood. Please try again.");
                        }
                    }
                } else if (choice == 4) {
                    System.out.println("Exiting Insurance Products menu.");
                    client.Menu(person);
                } else {
                	System.out.println("Input not understood. Please try again.");
                }
            }
        }
    }

    public static void advanceMonth() {
    	
    }

    public static boolean arrayContains(ArrayList<String> array, String contains) {
        for (String value: array) {
        	if (value != null) {
        		if (value.equals(contains)) {
        			return true;
        		}
        	}
        }

        return false;
    }
}
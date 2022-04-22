import java.util.Scanner;
import java.util.ArrayList;

public class ForeignCurrencyExchange {
    public static void main(user person, double balance_FCE) {

        String[] countries = {
            "Austrailia",
            "Canada",
            "China",
            "Denmark",
            "Eurozone",
            "Great Britain",
            "Hong Kong",
            "Japan",
            "Mexico",
            "New Zealand",
            "Norway",
            "Singapore",
            "Sweden",
            "Switzerland",
            "Thailand"
        };
        String[] currencies = {
            "AUD",
            "CAD",
            "CNY",
            "DKK",
            "EUR",
            "GBP",
            "HKD",
            "JPY",
            "MXN",
            "NZD",
            "NOK",
            "SGD",
            "SEK",
            "CHF",
            "THB"
        };
        //Start/Introduction
        //Listing Exchange Rates (based on rates listed on Wells Fargo)
        System.out.println("Exchange Rates");
        System.out.println("............................................................");
        System.out.println("");

        System.out.println(countries[0]);
        System.out.println("1 AUD = 0.7589 USD");
        System.out.println("");

        System.out.println(countries[1]);
        System.out.println("1 CAD = 0.825832 USD");
        System.out.println("");

        System.out.println(countries[2]);
        System.out.println("1 CNY = 0.1677543 USD");
        System.out.println("");

        System.out.println(countries[3]);
        System.out.println("1 DKK = 0.16028 USD");
        System.out.println("");

        System.out.println(countries[4]);
        System.out.println("1 EUR = 1.1889 USD");
        System.out.println("");

        System.out.println(countries[5]);
        System.out.println("1 GBP = 1.4165 USD");
        System.out.println("");

        System.out.println(countries[6]);
        System.out.println("1 HKD = 0.136476 USD");
        System.out.println("");

        System.out.println(countries[7]);
        System.out.println("1 JPY = 0.0091108 USD");
        System.out.println("");

        System.out.println(countries[8]);
        System.out.println("1 MXN = 0.051702 USD");
        System.out.println("");

        System.out.println(countries[9]);
        System.out.println("1 NZD = 0.7151 USD");
        System.out.println("");

        System.out.println(countries[10]);
        System.out.println("1 NOK = 0.11903 USD");
        System.out.println("");

        System.out.println(countries[11]);
        System.out.println("1 SGD = 0.785361 USD");

        System.out.println(countries[12]);
        System.out.println("1 SEK = 0.116081 USD");
        System.out.println("");

        System.out.println(countries[13]);
        System.out.println("1 CHF = 1.146395 USD");
        System.out.println("");

        System.out.println(countries[14]);
        System.out.println("1 THB = 0.032103 USD");
        System.out.println("");
        System.out.println("............................................................");
        System.out.println("");
        System.out.println("");

        //Utilizing "balance" as a placeholder for the actual balance
        System.out.println("Your current amount is $" + balance_FCE + ".");
        System.out.println("Please input wanted amount to be converted and then the number of the desired conversion from the list above.");

        //User Input
        Scanner input = new Scanner(System.in);
        ArrayList < Double > values = new ArrayList < Double > ();
        for (int i = 0; i <= 1; i++) {
            values.add(input.nextDouble());
            System.out.println("Which currency from the list do you want to convert to? (give the index of it)");
        }

        double from_balance = values.get(0);
        int convert_ID = (int) Math.round(values.get(1)) - 1;

        //Calculations are runned but should not do anything to the user's balance if all things go right
        USD_Converter convert = new USD_Converter();
        convert.converting(from_balance, convert_ID);


        //This should be the point in which the money to removed from the balance and it displays the proper amount in the new currency
        if (balance_FCE > from_balance && from_balance > 0) {
            System.out.println("You have exchanged $" + from_balance + " for " + convert.getExchange() + " " + currencies[convert_ID]);

            amount_balance Removal = new amount_balance();
            Removal.calc_transaction_fee(from_balance);
            Removal.subtract_amount(convert.getExchange(), balance_FCE);

            System.out.println("Yor current balance is now $" + Removal.get_newBalance() + ".");
            System.out.println("Thank you and have a nice day.");
            client.Menu(person);

        } else {
            System.out.println("Sorry but either the amount you wanted to be converted or your balance is invalid.");
            System.out.println("Thank you and have a nice day.");
            client.Menu(person);
        }
    }
}

//Attempt to round the converted amount to the nearest "unit"
//Would likely need an array to convert the amounts as different currencies have different "units"
class USD_Converter {
    Double[] conversions = {
        1.317696666,
        12.10900038,
        5.96109906,
        6.239081607,
        0.8411136345,
        0.7059654077,
        7.327295624,
        109.7598455,
        19.34161154,
        1.398405817,
        8.401243384,
        1.273299795,
        8.614674236,
        0.8722996873,
        31.14973678
    };
    public double converted_amount = 0;

    void converting(double amount_inputed, int wanted_foreign) {
        converted_amount = amount_inputed * conversions[wanted_foreign];
    }

    public double getExchange() {
        return converted_amount;
    }

}

//Again using "balance" as a placeholder for actual balance object
//Attempt to round the balance to the nearest cent
class amount_balance {
    double transact = 0;
    double new_balance = 0;
    void calc_transaction_fee(double input_amount) {
        transact = input_amount * 0.03;
    }

    public void subtract_amount(double the_amount, double the_balance) {
        new_balance = the_balance - (the_amount + transact);
    }

    public double get_newBalance() {
        return new_balance;
    }
}
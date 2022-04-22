import java.util.ArrayList;
import java.util.Scanner;
public class safeDepositBox {
    private static ArrayList < String > boxes2 = new ArrayList < String > ();
    private user abc;

    public void setUser(user person) {
        abc = person;
    }
    safeDepositBox() {
    	// BY DEFAULT, THEY GET 3 EMPTY SPOTS
        boxes2.add("Empty");
        boxes2.add("Empty");
        boxes2.add("Empty");
        boxes2.add("Removal");
        boxes2.add("Exit");
    }
    safeDepositBox(ArrayList < String > box, user Person) {
        boxes2 = box;
        Person = abc; 
    }
    public ArrayList < String > getSafetyBox() {
        return boxes2;
    }
    public static void main(user Person) {
        String choice = " ";
        System.out.println("Do you want to make safe deposit box?");
        System.out.println("1) Yes");
        System.out.println("2) No, I already have one"); // try to send them back to the menu
        System.out.println("3) Exit");

        safeDepositBox userBox = Person.getSafetyBox();
        Scanner keyboard = new Scanner(System.in);
        int option1 = keyboard.nextInt();

        if (option1 == 1) {

            boxes2 = boxes();
            boxeslist(boxes2);
            
            boxesMenu(option1, Person);
            
        } else if (option1 == 2) {
            boxeslist(boxes2);
            boxesMenu(option1, Person);
        } else if (option1 == 3) {

            client.Menu(Person);
        } else {
            System.out.println("Your input was not understood, please try again.");
            main(Person);
        }
    }
    public static void removal(ArrayList < String > box) {
        System.out.println("Select a slot to remove");

        Scanner keyboard1000 = new Scanner(System.in);
        int userremove = keyboard1000.nextInt();
        box.set(userremove - 1, "Empty");

        boxeslist(box);

    }
    public static void boxesMenu(int option1, user abc) {
    	while (option1 == 1 || option1 == 2) {
    		System.out.println("Choose a slot");
            Scanner keyboard13 = new Scanner(System.in);
            int userInput = keyboard13.nextInt();
            int index = 0;

            //System.out.println(box.indexOf("Removal"));	
            int removalindex = boxes2.indexOf("Removal") + 1;
            int exitindex = removalindex + 1;
            //System.out.println("AAAAAAAAAAAAAAAAAAA" + removalindex);
            //System.out.println("AAAAAAAAAAAAAAAAAA" + exitindex);

            if (userInput == removalindex) 
            {
                //System.out.println("YOU ARE RMEOVING");
                removal(boxes2);
            } else if (userInput == exitindex) 
            {
                client.Menu(abc);
            } 
            else if (boxes2.size() < userInput)
            {
            	System.out.println("Error: Please re-enter a valid slot");
            }
            else if (userInput < 1)
            {
            	System.out.println("Error: Please re-enter a valid slot");
            }
            else 
            {
                System.out.println("Add a basic object");
                Scanner keyboard8 = new Scanner(System.in);
                String choice = keyboard8.nextLine();
                boxes2.set(userInput - 1, choice);
                boxeslist(boxes2);
            }

    	}
    }
    public static ArrayList < String > boxes() {
        System.out.println("How many slots do you want?");

        Scanner Keyboard11 = new Scanner(System.in);
        int boxamount = Keyboard11.nextInt();
        ArrayList < String > boxes = new ArrayList < String > ();
        for (int i = 0; i < boxamount; i++) {
            boxes.add("Empty");
        }
        boxes.add("Removal");
        boxes.add("Exit");
        return boxes;

    }

    public static void boxeslist(ArrayList < String > boxes) {

        for (int l = 0; l < boxes.size(); l++) {
            System.out.println((l + 1) + ") " + boxes.get(l));
        }
        
    }

}
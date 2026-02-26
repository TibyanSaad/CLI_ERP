import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            option = mainMenu(userInput);
        }
    }

    public static int mainMenu(Scanner userInput) {
        System.out.println("######### MAIN MENU #########");
        System.out.println("1.Customer \n2.Admin \n3.Support Staff \n4.Exit");
        System.out.println("#############################");
        int option = userInput.nextInt();

        if (option == 1) {

        } else if (option == 2) {
            // admin menu
        } else if (option == 3) {
            //support staff menu
        } else if (option == 4) {
            System.out.println("Exiting the application. Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Invalid option! please choose a valid option");
        }
        return (0);
    }

}

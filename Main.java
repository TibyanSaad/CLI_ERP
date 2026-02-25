import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Customer> Tickets = new ArrayList<>();
    public static void main(String[] args){
        Scanner userInput = new Scanner (System.in);
        int option = 0;
        while (option != 4){
          option = mainMenu(userInput);
        }
    }

    public static int mainMenu(Scanner userInput){
        System.out.println("######### MAIN MENU #########");
        System.out.println("1.Customer \n2.Admin \n3.Support Staff \n4.Exit");
        System.out.println("#############################");
        int option = userInput.nextInt();

        if (option == 1){
            System.out.println("Welcome to Customer menu! \nCreate a ticket");
            System.out.println("Enter complaint ID: ");
            int compID = userInput.nextInt();
            userInput.nextLine();
            System.out.println("Enter complaint description: ");
            String compDes = userInput.nextLine();
            System.out.println("Enter complaint Priority. \n1.LOW 2.MEDIUM 3.HIGH ");
            int compPri = userInput.nextInt();
            if (compPri > 3 || compPri < 0){

            }
            Tickets.add(new Customer(compID,compDes,compPri-1));
            System.out.println("Ticket Created Successfully!");

            userInput.nextLine();
            System.out.println("Ticket number to be viewed: ");
            int adminCompID = Integer.parseInt(userInput.nextLine());

            for (Customer adminTicketId : Tickets) {
                if (adminTicketId.getComplaintId() == adminCompID) {
                    System.out.println("Ticket Number: " + adminTicketId.getComplaintId());
                    System.out.println("Description: " + adminTicketId.getComplaintDescription());
                    System.out.println("Priority: " + adminTicketId.getComplaintPriority());
                }

        }}else if (option == 2){
            // admin menu
        }else if (option == 3){
            //support staff menu
        } else if (option == 4) {
            System.out.println("Exiting the application. Goodbye!");
            System.exit(0);
        }else {
            System.out.println("Invalid option! please choose a valid option");
        }return(0);
    }

}

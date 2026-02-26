import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMenu {
    static ArrayList<Complaints> Tickets = new ArrayList<>();
    public static void main (String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Customer menu! \nCreate a ticket");
        int compID;
        while (true) {
            System.out.println("Enter complaint ID: ");
            if (userInput.hasNextInt()) {
                compID = userInput.nextInt();
                break;
            } else {
                System.out.println("Please enter a valid complaint ID");
                userInput.next();
            }
        }
        userInput.nextLine();
        System.out.println("Enter complaint description: ");
        String compDes = userInput.nextLine();
        // fix this block for invalid input

        String comPri;
        while (true) {
            System.out.println("Enter complaint Priority. \n1.LOW 2.MEDIUM (default) 3.HIGH ");
            String priority = userInput.nextLine();
            if (priority.isEmpty()) {
                comPri = "MEDIUM";
                break;
            }

            if (!priority.matches("\\d+")) {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                continue; // ask again
            }

            int comPriIndex = Integer.parseInt(priority);

            if (comPriIndex == 1) {
                comPri = "LOW";
                break;
            } else if (comPriIndex == 2) {
                comPri = "MEDIUM";
                break;
            } else if (comPriIndex == 3) {
                comPri = "HIGH";
                break;
            } else {
                System.out.println("Please select a valid priority number 1-3.");
            }
        }

        // fix this block for invalid input

        Tickets.add(new Complaints(compID,compDes,comPri));
        System.out.println("Ticket Created Successfully!");

        System.out.println("Ticket number to be viewed: ");
        int adminCompID = Integer.parseInt(userInput.nextLine());

        for (Complaints adminTicketId : Tickets) {
            if (adminTicketId.getComplaintId() == adminCompID) {
                System.out.println("Ticket Number: " + adminTicketId.getComplaintId());
                System.out.println("Description: " + adminTicketId.getComplaintDescription());
                System.out.println("Priority: " + adminTicketId.getComplaintPriority());
            }
        }
    }
}


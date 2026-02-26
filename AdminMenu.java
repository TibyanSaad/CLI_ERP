import java.util.Scanner;

public class AdminMenu {
    public static void main (){
        Scanner userInput = new Scanner(System.in);
        int tries = 1;
        while (tries <= 3){
            System.out.println(" \nPlease enter password: ");
            int password = userInput.nextInt();
            if (password == 1234){
                System.out.println("Password is correct!");
                System.out.println("##### Welcome to Admin menu #####");
                System.out.println("1.View all complaints");
                System.out.println("2.Search complaint by ID");
                System.out.println("3.Close a complaint");
                System.out.println("4.Assign a complaint");
                System.out.println("5.View a staff member's complaints");
                int adminOption = userInput.nextInt();
                if (adminOption == 1){
                    System.out.println("---- All Complaint Tickets ----");
                    for (Complaints compTickets : CustomerMenu.Tickets){
                        System.out.println("Complaint ID: " + compTickets.getComplaintId());
                        System.out.println("Complaint Description: " + compTickets.getComplaintDescription());
                        System.out.println("Complaint Priority: " + compTickets.getComplaintPriority());
                        System.out.println("Complaint Status: " + compTickets.getComplaintStatus());
                        System.out.println("Assigned staff member: " + compTickets.getAssignedStaff());
                        System.out.println("-----------------------------");
                    }
                } else if (adminOption == 2) {
                    System.out.println("---- Complaint Tickets by ID ----");
                    System.out.println("Enter the complaint ID of ticket to be viewed: ");
                    if (userInput.hasNextInt()) {
                        int adminCompID = userInput.nextInt();
                        for (Complaints adminTicketId : CustomerMenu.Tickets) {
                            if (adminCompID == adminTicketId.getComplaintId()) {
                                System.out.println("Complaint ID: " + adminTicketId.getComplaintId());
                                System.out.println("Complaint Description: " + adminTicketId.getComplaintDescription());
                                System.out.println("Complaint Priority: " + adminTicketId.getComplaintPriority());
                                System.out.println("Complaint Status: " + adminTicketId.getComplaintStatus());
                                System.out.println("Assigned staff member: " + adminTicketId.getAssignedStaff());
                            }else {
                                System.out.println("Complaint ticket not found");
                            }
                        }
                    }else {
                        System.out.println("Please type a valid complaint ID");
                        userInput.next();
                    }

                } else if (adminOption == 3) {
                    System.out.println("---- Close a Complaint Ticket----");
                    System.out.println("Enter the complaint ID of ticket to be closed: ");
                    if (userInput.hasNextInt()) {
                        int adminCompID = userInput.nextInt();
                        for (Complaints adminTicketId : CustomerMenu.Tickets) {
                            if (adminCompID == adminTicketId.getComplaintId()) {
                                if(!adminTicketId.getComplaintStatus().equals("CLOSED")){
                                    System.out.println("Complaint ID: " + adminTicketId.getComplaintId());
                                    System.out.println("Complaint Description: " + adminTicketId.getComplaintDescription());
                                    System.out.println("Complaint Priority: " + adminTicketId.getComplaintPriority());
                                    adminTicketId.setComplaintStatus("CLOSED");
                                    System.out.println("Complaint Status: " + adminTicketId.getComplaintStatus());
                                    System.out.println("Assigned staff member: " + adminTicketId.getAssignedStaff());
                                }else{
                                    System.out.println("Complaint ticket already closed.");
                                }

                            }else {
                                System.out.println("Complaint ticket not found");
                            }
                        }
                    }else {
                        System.out.println("Please type a valid complaint ID");
                        userInput.next();
                    }

                }else if (adminOption == 4) {
                    System.out.println("---- Assign Complaint Tickets ----");
                    System.out.println("Enter the complaint ID: ");
                    int cStaffID = userInput.nextInt();
                    userInput.nextLine();

                    for (Complaints adminTicketId : CustomerMenu.Tickets) {
                        if (cStaffID == adminTicketId.getComplaintId()) {
                            if(!adminTicketId.getComplaintStatus().equals("CLOSED")){
                                System.out.println("Complaint ID: " + adminTicketId.getComplaintId());
                                System.out.println("Complaint Description: " + adminTicketId.getComplaintDescription());
                                System.out.println("Complaint Priority: " + adminTicketId.getComplaintPriority());
                                System.out.println("Complaint Status: " + adminTicketId.getComplaintStatus());
                                System.out.println("Enter the name of the staff member to be assigned: ");
                                String cStaffName = userInput.nextLine();
                                adminTicketId.setAssignStaff(cStaffName);
                                System.out.println("Assigned staff member: " + adminTicketId.getAssignedStaff());
                            }else{
                                System.out.println("Complaint ticket already closed, cannot assign");
                            }

                        }else {
                            System.out.println("Complaint ticket not found");
                        }
                    }

            }  else if (adminOption == 5) {
                    System.out.println("---- Staff Member Assigned Complaint Tickets ----");
                    System.out.println("Enter the staff member's name: ");
                    String cStaffAssigned = userInput.next();
                    System.out.printf("%s Assigned complaint tickets%n", cStaffAssigned);
                    System.out.println("-------------------------------------------------");
                    for (Complaints staffComplaints : CustomerMenu.Tickets){
                        if (cStaffAssigned.equals(staffComplaints.getAssignedStaff())){
                            System.out.println("Complaint ID: " + staffComplaints.getComplaintId());
                            System.out.println("Complaint Description: " + staffComplaints.getComplaintDescription());
                            System.out.println("Complaint Priority: " + staffComplaints.getComplaintPriority());
                            System.out.println("Complaint Status: " + staffComplaints.getComplaintStatus());
                            System.out.println("-------------------------------------------------");
                        }else {
                            System.out.println("No complaints assigned.");
                        }
                    }

                }else {
                System.out.printf("Wrong password, attempt %d%n",tries);
                tries ++;
            }
        }
    }
}
}

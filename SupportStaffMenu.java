import java.util.Scanner;

public class SupportStaffMenu {
    public static void main(){
        Scanner userInput = new Scanner (System.in);

        while (true){
            System.out.println("##### Welcome to Support Staff menu #####");
            System.out.println("Enter your name: ");
            String staffName = userInput.nextLine();
            System.out.printf("##### Welcome %s #####%n", staffName);
            System.out.println("1.View assigned complaints");
            System.out.println("2.Add a comment to a complaint");
            System.out.println("3.Close an assigned complaint");
            int staffChoice = userInput.nextInt();
            if (staffChoice == 1){

            } else if (staffChoice == 2) {

            }else if (staffChoice == 3){

            } else {
                System.out.println("Choose a valid option");
            }
        }
    }
}

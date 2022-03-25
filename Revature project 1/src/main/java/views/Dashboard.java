package views;

import models.User;
import service.ReimbursementService;
import util.Print;

import java.util.Scanner;

public class Dashboard {
    public static void view(User user){
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;
        ReimbursementService rs = new ReimbursementService();

        while(running){
            Print.dashboard(user);
            String input = scanner.nextLine();

            switch (input){
                case "1":
                    System.out.print(rs.getAllReimbursementsGivenUsersId(user.getId()));
                    break;
                case "2":
                    System.out.println("Reimbursement amount: ");
                    Integer amount = Integer.valueOf(scanner.nextLine());
                    System.out.println("Reimbursement type: ");
                    System.out.println("1): Lodging ");
                    System.out.println("2): Food ");
                    System.out.println("3): Travel ");
                    Integer type = Integer.valueOf(scanner.nextLine());
                    rs.createReimbursement(amount, user.getId(), type);
                    break;
                case "3":
                    System.out.println("Update Reimbursement status");
                    StatusUpdate.view(user);
                case "0":
                    running = false;
                    Landing.view();
                    break;
                default:
                    System.out.println("Invalid");

            }
        }

    }

}

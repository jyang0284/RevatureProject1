package views;

import models.User;


import service.ReimbursementService;
import service.UserService;



import java.util.Scanner;

public class StatusUpdate {

    public static void view(User user) {

        ReimbursementService rs = new ReimbursementService();
        UserService userService = new UserService();


        Scanner sc = new Scanner(System.in);
        Boolean running = true;

        System.out.println("Please enter Reimbursement ID: ");
        Integer ID = Integer.valueOf(sc.nextLine());
        System.out.println("Which reimbursement status would you ike to change it to? ");
//        System.out.println("1) View reimbursements");
        System.out.println("2) Approved");
        System.out.println("3) Denied");
        Integer Status = Integer.valueOf(sc.nextLine());
        rs.updateReimbursement(Status, ID);
    }
}
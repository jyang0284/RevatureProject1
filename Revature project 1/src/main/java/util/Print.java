package util;

import models.Reimbursements;
import models.User;

public class Print {

    public static void landing(){
        System.out.println("****** Employee Reimbursement System ******");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("0) EXIT");
    }


    public static void dashboard(User user){
        System.out.println("Welcome, " + user.getFirstname() + " " + user.getLastname());
        System.out.println("1) View your reimbursements");
        System.out.println("2) Add reimbursement request ");
        System.out.println("3) Approve or deny reimbursement request ");
        System.out.println("0) Logout");
    }

}
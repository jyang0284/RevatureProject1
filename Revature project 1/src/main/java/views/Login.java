package views;

import models.User;
import service.UserService;

import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Login {
    public static void view(){
        UserService userService = new UserService();
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        // In order to start the method below we had to instantiate UserService (As seen on line 11)
        User user = userService.validateCredentials(username, password);

        if(user == null){
            System.out.println("Username or password incorrect");
            Landing.view();
        }else{
            Dashboard.view(user);
        }


    }
}
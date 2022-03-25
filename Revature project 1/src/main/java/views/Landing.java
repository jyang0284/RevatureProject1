package views;

import util.Print;

import java.util.Scanner;

public class Landing {

    public static void view(){

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running){
            Print.landing();
            //This prints the Print class located in the util folder. What get's printed out is the method: landing in the Print class.
            //These are the functions behind the words printed to the user
            String input = sc.nextLine();
            switch(input){
                case "1":
                    Login.view();
                case "2":
                    Register.view();
                    break;
                case"0":
                    running = false;
                    Landing.view();
                    break;
                default:
                    System.out.println("Invalid input");
            }

        }

    }

}

package com.ironyard;

import java.util.Scanner;

/**
 * Created by dlocke on 11/16/16.
 */

public class Main {

    //receive user input
    public static Scanner scanner = new Scanner(System.in);
    public static Transaction transaction = new Transaction();


    //main method to run the program
    public static void main(String[] args) throws Exception{

        boolean run = true; //I'm trying to use this to to be my "big loop" to keep the whole program running ... but :(

        System.out.println("Hello"); //output to user

        //call methods
        while (run) {
            transaction.existingCustomer(); //load existing customers and data

            transaction.chooseName();
            transaction.transactionChoice();
        }


    }//end main()

}//end class Main

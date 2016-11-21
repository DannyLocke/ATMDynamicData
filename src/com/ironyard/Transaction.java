package com.ironyard;

import java.util.HashMap;

/**
 * Created by dlocke on 11/16/16.
 */

public class Transaction {

    //variables
    private String name;
    private int transaction;
    private double withdraw;
    private double money;
    public HashMap<String, Double> balances = new HashMap<>(); //<Key, Value>


        //method for pre-populated customer list in hashmap
        public void existingCustomer () {
        balances.put("Kate", 95000.00);
        balances.put("Danny", 70000.00);
        balances.put("John", 25000.00);
        balances.put("Sam", 50000.00);
    }

        // METHOD TO RECEIVE USER NAME

    public void chooseName() throws Exception {

        System.out.println("What is your name?");
        name = Main.scanner.nextLine();

        //hashmap names
        if (balances.containsKey(name)) {
            System.out.println("Welcome to Wells Fargo, " + name);

            //no name typed
        } else if (name.isEmpty()) {
            throw new Exception("ERROR: No name entered.");

        } else {
            //ADD TO HASH MAP (PUT)
            balances.put(name, 100.00);
            System.out.println("Welcome to Wells Fargo, " + name + ".  We've created a new account for you.");
        }

    }//end chooseName()

    //METHOD TO GET USER TRANSACTION CHOICE
    public void transactionChoice() throws Exception {

        do {

            System.out.println("Enter 1 to check your balance, 2 to withdraw funds, 3 to remove your account or 4 to cancel transaction.");

            transaction = Main.scanner.nextInt();

            if (transaction != 1 && transaction != 2 && transaction != 3 && transaction != 4) {
                System.out.println("Only enter a '1', '2', '3' or '4'.");
            }

            // 1. GET BALANCE
            if (transaction == 1 && balances.containsKey(name)) {
                System.out.println("Your balance is $" + (balances.get(name) - withdraw) + "0.");
            }


            // 2. WITHDRAWAL
            if (transaction == 2) {
                System.out.println("How much money would you like to withdraw?");
                withdraw = Main.scanner.nextInt();

                //ensure sufficient funds
                if (withdraw > 0 && withdraw <= (balances.get(name))) {
                    money = balances.get(name) - withdraw;
                    System.out.println("Thank you. Here is your $" + withdraw + "0 dollars. Please take your money.");
                    System.out.println("Your new balance is: $" + money + "0. Have a nice day!");

                } else if (withdraw > balances.get(name)) {
                    throw new Exception("Insufficient Funds.");
                }
            }


            // 3. REMOVE ACCOUNT FROM HASHMAP
            if (transaction == 3) {

                balances.remove(name);
                System.out.println("We have removed your account");
                System.out.println("Thank you and have a nice day.");
            }


            // 4. CANCEL TRANSACTION
            if (transaction == 4) {
                //transaction = Main.scanner.nextInt();
                System.out.println("Thank you and please come again.");

                //if the entry is something other than 1, 2, 3 or 4
            }

        } while (transaction != 4);

    }//end transactionChoice()

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }




}//end class Transaction
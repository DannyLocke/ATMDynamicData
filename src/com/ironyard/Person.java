package com.ironyard;

import java.util.HashMap;

/**
 * Created by dlocke on 11/18/16.
 */
public class Person {

    //variables
    private String name;

    // METHOD TO RECEIVE USER NAME
    public void chooseName() throws Exception {

        HashMap<String, Double> balances = new HashMap<>(); //<Key, Value>
        balances.put("Kate", 95000.00);
        balances.put("Danny", 70000.00);
        balances.put("John", 25000.00);
        balances.put("Sam", 50000.00);

        System.out.println("What is your name?");
        name = Main.scanner.nextLine();

        //hashmap names
        if(name.isEmpty()){
            throw new Exception("No name entered.");
        }
        else if (balances.containsKey(name)) {
            System.out.println("Welcome to Wells Fargo, " + name);

            //field left empty
        } else{
            //ADD TO HASH MAP (PUT)
            balances.put(name, 1000.00);
            System.out.println("Welcome to Wells Fargo, " + name + ".  We've created a new account for you.");
        }

    }//end chooseName()
}

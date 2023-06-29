/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class EnterData {

    DisplayData dp = new DisplayData();
    Scanner sc = new Scanner(System.in);

    //enter input int in range
    public int enterIntRange(String msg, int min, int max) {
        String input;
        float integer;
        //loop until user enter correct input
        do {
            dp.displayMenu();
            System.out.print(msg);
            input = sc.nextLine();
            //check if input empty
            if (input.isEmpty()) {
                System.err.println("Input cannot be empty.");
            }
            try {
                integer = Float.parseFloat(input);
                //check if input not in range 
                if (integer < min || integer > max) {
                    throw new Exception();
                    //check if input is a real number
                } else if ((int) integer != integer) {
                    throw new Error();
                } else {
                    return (int) integer;
                }
            } catch (NumberFormatException exception) {
                System.err.println("Input cannot be a string.");
                System.out.println("Please enter an integer in [" + min + ", " + max + "].");
            } catch (Exception NotInRange) {
                System.err.println("Input cannot out of range.");
                System.out.println("Please enter an integer in [" + min + ", " + max + "].");
            } catch (Error RealNum) {
                System.err.println("Input cannot be a real number.");
                System.out.println("Please enter an integer in [" + min + ", " + max + "].");
            }
        } while (true);
    }

    //enter base input
    public int enterBaseIn() {
        int baseIn = enterIntRange("Enter base input: ", 1, 4);
        //check if user enter base input = 4 -> out program
        if (baseIn == 4) {
            System.exit(0);
        }
        return baseIn;
    }

    //enter base output
    public int enterBaseOut(int baseIn) {
        //loop until user enter correct input
        do {
            int baseOut = enterIntRange("Enter base output: ", 1, 3);
            //check if base output = base input 
            if (baseOut == baseIn) {
                System.err.println("Base output cannot equal to base input.");
                System.out.println("Please enter again.");
            } else {
                return baseOut;
            }
        } while (true);
    }

    //enter value input
    public String enterValueIn(int baseIn) {
        String input;
        boolean check = true;
        //loop until user enter correct input
        do {
            System.out.print("Enter input value: ");
            input = sc.nextLine();
            //check if input empty
            if (input.isEmpty()) {
                System.err.println("Input cannot be empty.");
                System.out.println("Please enter input match the pattern.");
            }
            //check input match base format
            switch (baseIn) {
                //base 2: only accept digit 0 or 1, unlimited length
                case 1:
                    check = input.matches("^[0-1]+$");
                    break;
                //base 10: only accept digit 0 -> 9, unlimited length
                case 2:
                    check = input.matches("^[0-9]+$");
                    break;
                //base 16: accpet digit 0 -> 9, alphabet a -> f ignored case, unlimited length
                case 3:
                    check = input.matches("^[0-9a-fA-F]+$");
                    break;
            }
            //check 
            if (check == false) {
                System.err.println("Input must match the pattern of base input.");
                System.out.println("Please enter input match the pattern.");
            } else {
                return input.toUpperCase();
            }
        } while (true);
    }
}

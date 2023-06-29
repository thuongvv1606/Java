/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class InputData {
    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {            
            input = sc.nextLine().trim();
            if(input.isEmpty()) {
                System.out.println("Input could not empty.");
            }else {
                return input;
            }
        }
    }
    
    public static int inputInteger() {
        Scanner sc = new Scanner(System.in);
        int integerNumber;
        String input;
        while (true) {            
            input = sc.nextLine().trim();
            if(input.isEmpty()) {
                System.out.println("Input could not empty.");
                continue;
            }
            try {
                integerNumber = Integer.parseInt(input);
                if(integerNumber <= 0) {
                    throw new Exception();
                } else {
                    return integerNumber;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be positive integer: ");
            } catch (Exception negative) {
                System.out.println("input must be positive integer: ");
            }
        }
    }
    
    public static int inputIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int integerNumber;
        String input;
        //check input
        while (true) {            
            input = sc.nextLine().trim();
            // check input empty
            if(input.isEmpty()) {
                System.out.println("Input could not empty.");
                continue;
            }
            try {
                integerNumber = Integer.parseInt(input);
                //check input large min and less than max
                if(integerNumber < min || integerNumber > max) {
                    throw new Exception();
                }else {
                    return integerNumber;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be a positive numnber");
            } catch (Exception e) {
                System.out.println("Please input number in rage [" + min + ""
                        + ", " + max + "]");
            }
        }
    }
    
    public static boolean checkCodeExist(ArrayList<Doctor> ld, String code) {
        //loop access from the first to the last element
        for (Doctor d : ld) {
            if(code.equalsIgnoreCase(d.getCode())) {
                return false;
            }
        }
        return true;
    }
}

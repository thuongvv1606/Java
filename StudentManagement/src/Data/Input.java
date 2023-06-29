/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Input {
    public static String InputString(String msg) {
        Scanner sc = new Scanner(System.in);
        //loop to user input true value
        while (true) {     
            System.out.print(msg);
            String result = sc.nextLine().trim();
            //check if string is isEmpty
            if(result.isEmpty()) {
                System.out.println("Not empty.");
            } else {
                return result;
            }
        }
    }
    
    public static double InputMark(String nameSubject) {
        Scanner sc = new Scanner(System.in);;
        while (true) {            
            System.out.print(nameSubject + ":");
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if(result < 0 ) {
                    System.out.println(nameSubject + " is greater than equal zero");
                    continue;
                }
                if(result > 10) {
                    System.out.println(nameSubject + " is less than equal ten");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(nameSubject + " is digit");               
            }
        }
    }
    
    public static boolean checkYN(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.print(msg);
            String check = sc.nextLine();
            if(check.equalsIgnoreCase("N")) {
                return false;
            }
            if(check.equalsIgnoreCase("Y")) {
                return true;
            }
            System.out.println("Please input must be N or y.");
            System.out.println("Enter again: ");
        }
    }
}

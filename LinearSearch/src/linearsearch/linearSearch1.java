/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class linearSearch1 {
    
    
    
    
    
    
    
    public static void main(String[] args) {
        //step1: input a positiave decimal number of array
        int numberOfArray = positiveDecimalNumber("Enter number of array: ");
        //step2: input a positive decimal number a search number
        int searchNumber = positiveDecimalNumber("Enter search value: ");
        //step3: Generate random integer in number range
        int[] array = generateRandomNumber(numberOfArray);
        //step4: Display the array
        displayArray("The array: ", array);
        //step5: linear search
        linearSearch(array, searchNumber);
        //step6: Display the index of search number in array
        displaySearchNumber(linearSearch(array, searchNumber), searchNumber);
        
    }

    private static int positiveDecimalNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        double poDeNumber;
        String input;
        //check and input
        do {            
            System.out.println(msg);
            input = sc.nextLine();
            //check empty
            if(input.isEmpty()) {
                System.out.println("Input could not be empty. Please enter a "
                        + "positive decimal number.");
                continue;
            }
            try {
                poDeNumber = Double.parseDouble(input);
                //check less than zero
                if(poDeNumber <= 0) {
                    throw new Exception();
                }
                if((int)poDeNumber != poDeNumber) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input must be positive decimal number. "
                        + "Please enter a positive decimal number.");
            } catch (Exception | Error negative) {
                System.out.println("Input must be positive decimal number. "
                        + "Please enter a positive decimal number.");
            }
        } while (true);
        return (int) poDeNumber;
    }

    private static int[] generateRandomNumber(int numberOfArray) {
        Random rd = new Random();
        int[] array = new int[numberOfArray];
        //loop to access from the first element to the last element
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(9) + 1;
        }
        return array;
    }

    private static void displayArray(String msg, int[] array) {
        System.out.print(msg);
        System.out.print("[");
        //loop to access the first element to the last element
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //check
            if(i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int linearSearch(int[] array, int searchNumber) {
        //loop to access the first element to the last element
        for (int i = 0; i < array.length; i++) {
            //compare element in array with the search number
            if(array[i] == searchNumber) {
                return i;
            }
        }
        return -1;
    }

    private static void displaySearchNumber(int linearSearch, int searchNumber) {
        //compare
        if(linearSearch == -1) {
            System.out.println(searchNumber + " not found in array.");
        } else {
            System.out.println("Found " + searchNumber + " at index: " + linearSearch);
        }
    }
}

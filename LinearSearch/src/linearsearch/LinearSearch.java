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
public class LinearSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean check = false;
       //step1: input a positive decimal number
       int numberOfArray = positiveDecimalNumber("Enter number of array: ");
        while (check != true) {            
       //step2: input search number
       int searchValue = positiveDecimalNumber("Enter search value: ");
       //step3: Generate random integer in number range
       int[] array = generateRandomNumber(numberOfArray);
       //step4: Display the array
       displayArray("The array: ", array);
       //step5: Linear searchue:
       int linearSearch = linearSearch(array, searchValue);
       //step6: Display the index of search number in array
       check  = displayIndex(linearSearch, searchValue);
        }
    }

    @SuppressWarnings("empty-statement")
    private static int positiveDecimalNumber(String msg){
        Scanner sc = new Scanner(System.in);
        double positiveNumber;
        String input;
        //check input
        do {            
            System.out.println(msg);
            input = sc.nextLine();
            if(input.isEmpty()) {
                System.out.println("Input could not be empty. Please enter a "
                        + "positive decimal number.");
                continue;
            }
            try {
                positiveNumber = Double.parseDouble(input);
                if(positiveNumber <= 0) {
                    throw new Exception();
                }
                if((int)positiveNumber != positiveNumber) {
                    throw new Error();
                }else{
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input must be positive decimal number. "
                        + "Please enter a positive number.");
            } catch (Exception | Error negative) {
                System.out.println("Input must be positive decimal number. "
                        + "Please enter a positive number.");
            }
        }while (true);
        return (int) positiveNumber;
    }

    private static int[] generateRandomNumber(int numberOfArray) {
        int[] array = new int[numberOfArray];
        Random rd = new Random();
        //loop to access from the first element to the last element
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(9) + 1;
        }
        return array;
    }

    private static void displayArray(String msg, int[] array) {
        System.out.print(msg);
        System.out.print("[");
        //loop to access from the first element to the last element
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //compare and insert ','
            if(i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int linearSearch(int[] array, int searchValue) {
        //loop to access from the first element to the last element
        for (int i = 0; i < array.length; i++) {
            //compare the element in the array with the valuw to look for
            if(array[i] == searchValue)
                return i;
        }
        return -1;
    }

    private boolean check (int linewarSearch) {
        if(linewarSearch == -1) {
            return false;
        }else return true;
    } 
     
    private static  boolean displayIndex(int linearSearch, int searchValue) {
        if(linearSearch == -1) {
            System.out.println("Element not found in array");
            return false;
        } else{
            System.out.println("Found " + searchValue + " at index: " + linearSearch);
            return true;
        }
    }
    
    
    
}

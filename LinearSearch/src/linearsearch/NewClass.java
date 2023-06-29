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
public class NewClass {
    public static void main(String[] args) {
        //step1: input a positive decimal number of array
        int numberOfArray = positiveDecimalNumber("Enter number of array: ");
        //step2: input a positive decimal number of array
        int searchNumber = positiveDecimalNumber("Enter search value: ");
        //step3: Generate random integer in number range for each array element
        int[] array = enerateRandomInteger(numberOfArray);
        //step4: Display array
        diplayArray("The array: ", array);
        //step5: linear search
        linearSearch(array, searchNumber);
        //step6: Display the index of search number in array
        displayIndex(linearSearch(array, searchNumber), searchNumber);
    }

    private static int positiveDecimalNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        double positiveNumber;
        String input;
        do {            
            System.out.println(msg);
            input = sc.nextLine();
            //check input is empty
            if(input.isEmpty()) {
                System.out.println("Input could not be empty. Please enter a "
                        + "positive decimal number.");
                continue;
            }
            //check input
            try {
                positiveNumber = Double.parseDouble(input);
                //check number of array less than zero
                if(positiveNumber <= 0) {
                    throw new Exception();
                }
                //check number of array is real
                if((int)positiveNumber != positiveNumber) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NullPointerException exception) {
                System.out.println("Input must be a positive decimal number."
                        + " Please enter a positive decimal number.");
            } catch (Exception | Error Negative) {
                System.out.println("Input must be a positive decimal number."
                        + " Please enter a positive decimal number.");
            }
        } while (true);
        return (int) positiveNumber;
    }

    private static int[] enerateRandomInteger(int numberOfArray) {
        Random rd = new Random();
        int[] array = new int[numberOfArray];
        //loop to access from the first element to the last element
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(9) + 1;
        }
        return array;
    }

    private static void diplayArray(String msg, int[] array) {
        System.out.print(msg);
        System.out.print("[");
        //loop to access from the first element to the last element
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author hp
 */
public class DisplayData {
    //display menu
    public void displayMenu() {
        System.out.println("======Change base number system======");
        System.out.println("\t1. Binary");
        System.out.println("\t2. Decimal");
        System.out.println("\t3. Hexadecimal");
        System.out.println("\t4. Exit");
    }
    //display result
    public void displayResult(String result) {
        System.out.println("Converted result: " + result);
    }
}

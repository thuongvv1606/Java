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
public class Main {
    public static void main(String[] args) {
        EnterData input = new EnterData();
        Convert cv = new Convert();
        DisplayData dp = new DisplayData();
        do {
            //Step 1. Choose base number input
            int baseIn = input.enterBaseIn();
            //Step 2. Choose base number output
            int baseOut = input.enterBaseOut(baseIn);
            //Step 3. Enter input value
            String valueIn = input.enterValueIn(baseIn);
            //Step 4. Convert result
            String result = cv.convertResult(baseIn, baseOut, valueIn);
            //Step 5. Print output value
            dp.displayResult(result);
        } while (true);
    }
}

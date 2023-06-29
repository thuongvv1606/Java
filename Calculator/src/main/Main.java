/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.Calculate;
import bo.MatrixBO;
import entity.Matrix;
import util.Validate;

/**
 *
 * @author hp
 */
public class Main {

    public static void main(String[] args) {
        MatrixBO matrixBo = new MatrixBO();
        int option;
        Matrix matrixFirst = new Matrix();
        Matrix matrixSecond = new Matrix();
        Matrix result = new Matrix();
        do {
            //Step 1. Display menu
            System.out.println("=======Calculator program======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            //Step 2. Select option
            option = Validate.getInt("Your choice: ",
                    "Please enter an integer in [" + 1 + ", " + 4 + "]",
                    "Please enter an integer number", 1, 4);
            //Step 3. Calculate
            switch (option) {
                //Option 1: Addition matrix
                case 1:
                    System.out.println("-------- Addition --------");
                    //Enter 1st matrix
                    matrixFirst.getMatrix(Integer.MIN_VALUE, Integer.MAX_VALUE,
                            Integer.MIN_VALUE, Integer.MAX_VALUE);
                    //Enter 2nd matrix
                    matrixSecond.getMatrix(matrixFirst.getRow(), matrixFirst.getRow(),
                            matrixFirst.getCol(), matrixFirst.getCol());
                    //Calculate addition
                    result = Calculate.addSubMatrix(option, matrixFirst, matrixSecond);
                    break;
                //Option 2. Subtraction matrix
                case 2:
                    System.out.println("----- Subtraction ------");
                    //Enter 1st matrix
                    matrixFirst.getMatrix(Integer.MIN_VALUE, Integer.MAX_VALUE,
                            Integer.MIN_VALUE, Integer.MAX_VALUE);
                    //Enter 2nd matrix
                    matrixSecond.getMatrix(matrixFirst.getRow(), matrixFirst.getRow(),
                            matrixFirst.getCol(), matrixFirst.getCol());
                    //Calculate subtraction
                    result = Calculate.addSubMatrix(option, matrixFirst, matrixSecond);
                    break;
                //Option 3. Multiplication matrix
                case 3:
                    System.out.println("-------- Multiplication -------");
                    //Enter First matrix
                    matrixFirst.getMatrix(Integer.MIN_VALUE, Integer.MAX_VALUE,
                            Integer.MIN_VALUE, Integer.MAX_VALUE);
                    //Enter second matrix
                    matrixSecond.getMatrix(matrixFirst.getCol(), matrixFirst.getCol(),
                            Integer.MIN_VALUE, Integer.MAX_VALUE);
                    //Calculate multiplicationmat
                    result = Calculate.multiplicationMatrix(matrixFirst, matrixSecond);
                    break;
                //Option 4. Quit
                case 4:
                    System.exit(0);
                    break;
            }
            //Step 4. Display result
            matrixBo.displayResult(option, matrixFirst, matrixSecond, result);
        } while (true);
    }
}

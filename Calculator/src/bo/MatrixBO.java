/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Matrix;

/**
 *
 * @author hp
 */
public class MatrixBO {

    Matrix matrix = new Matrix();

    /**
     *
     * display the result obtained from the calculation
     *
     * @param option       the valid option integer scanned from the input
     * @param matrixFirst  the valid matrix scanned from the input
     * @param matrixSecond the valid matrix scanned from the input
     * @param result       after calculator with each option return the matrix
     */
    public void displayResult(int option, Matrix matrixFirst, Matrix matrixSecond,
            Matrix result) {
        System.out.println("-------- Result --------");
        matrixFirst.display();
        switch (option) {
            case 1:
                System.out.println("+");
                break;
            case 2:
                System.out.println("-");
                break;
            case 3:
                System.out.println("*");
                break;
        }
        matrixSecond.display();
        System.out.println("=");
        result.display();
    }
}

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
public class Calculate {

    private Calculate() {
    }

    /**
     * Returns the matrix received from subtraction 2 matrix from input
     *
     * @param option       the valid value entered from the user from the beginning to
     * select the calculation with option equal 1 is Addition Matrix and option
     * equal 2 is Subtraction Matrix declared from the input in main
     * @param matrixFirst  the valid matrix scanned from the input
     * @param matrixSecond the valid matrix scanned from the input
     * @return the matrix received from subtraction 2 matrix from input
     */
    public static Matrix addSubMatrix(int option, Matrix matrixFirst, Matrix matrixSecond) {
        int row = matrixFirst.getRow();
        int col = matrixFirst.getCol();
        Matrix result = new Matrix(row, col);
        //nested loop
        //1st loop to access each element of row of matrix
        if (option == 1) {
            for (int i = 0; i < row; i++) {
                //2nd loop to access each element of column of matrix
                for (int j = 0; j < col; j++) {
                    result.setMatrix(i, j, matrixFirst.getMatrix(i, j) + matrixSecond.getMatrix(i, j));
                }
            }
        }
        if (option == 2) {
            for (int i = 0; i < row; i++) {
                //2nd loop to access each element of column of matrix
                for (int j = 0; j < col; j++) {
                    result.setMatrix(i, j, matrixFirst.getMatrix(i, j) - matrixSecond.getMatrix(i, j));
                }
            }
        }
        return result;
    }

    /**
     * Return the matrix received from multiplication 2 matrix from the input
     *
     * @param matrixFirst  the valid matrix scanned from the input
     * @param matrixSecond the valid matrix scanned from the input
     * @return the matrix received from multiplication 2 matrix from the input
     */
    public static Matrix multiplicationMatrix(Matrix matrixFirst, Matrix matrixSecond) {
        int row = matrixFirst.getRow();
        int col = matrixFirst.getCol();
        int colSecond = matrixSecond.getCol();
        Matrix result = new Matrix(row, colSecond);
        //nested loop
        //1st loop to access each element of row of 1st matrix
        for (int i = 0; i < row; i++) {
            //2nd loop to access each element of column of 2nd matrix 
            for (int j = 0; j < colSecond; j++) {
                int sum = 0;
                //3rd loop to access each element of column of 1st matrix 
                for (int k = 0; k < col; k++) {
                    sum += matrixFirst.getMatrix(i, k) * matrixSecond.getMatrix(k, j);
                }
                result.setMatrix(i, j,sum);
            }
        }
        return result;
    }
}

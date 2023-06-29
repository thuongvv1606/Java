/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import util.Validate;

/**
 *
 * @author hp
 */
public class Matrix {
    private int col;
    private int row;
    private int[][] matrix;

    public Matrix() {
    }

    public Matrix(int col, int row, int[][] matrix) {
        this.col = col;
        this.row = row;
        this.matrix = new int[row][col];
    }

    public Matrix(int row, int col) {
        this.col = col;
        this.row = row;
        this.matrix = new int[row][col];
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getMatrix(int row, int col) {
        return this.matrix[row][col];
    }

    public void setMatrix(int row, int col,int value) {
        this.matrix[row][col] = value;
    }
    

    @Override
    public String toString() {
        return "Matrix{" + "col=" + col + ", row=" + row + '}';
    }
    /**
     * return the valid matrix scanned from the input
     *
     * @param colMin minimum limit value of col matrix
     * @param colMax max limit value of col matrix
     * @param rowMin minimum limit value of row matrix
     * @param rowMax max limit value of row matrix
     * @return the matrix scanned from the input
     */
    public void getMatrix(int rowMin, int rowMax, int colMin, int colMax) {
        this.row = Validate.getInt("Enter Row Matrix:", "Row must in range "
                + "[rowMin, rowMax]", "Please enter an integer.",
                rowMin, rowMax);
        this.col = Validate.getInt("Enter Col Matrix:", "Column must in range "
                + "[colMin, colMax]", "Please enter an integer.",
                colMin, colMax);
        this.matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            //2nd loop to enter each element of column of 2nd matrix
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Validate.getInt("Enter Matrix[" + (i + 1) + "]["
                        + (j + 1) + "]:", "Row/Column cannot be "
                        + "a real number.", "Please enter an integer.",
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
    }
    
     /**
     * display matrix
     *
     * @param matrix the valid matrix from the input
     */
    public void display() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + this.matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }
}

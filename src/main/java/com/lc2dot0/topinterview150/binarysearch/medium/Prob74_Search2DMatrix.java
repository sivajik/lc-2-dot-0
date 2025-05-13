package com.lc2dot0.topinterview150.binarysearch.medium;

public class Prob74_Search2DMatrix {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // Start at last row, first column
        // 3 X 4
        int r = matrix.length - 1;
        int c = 0;

        while (r >= 0 && c < matrix[0].length) {
            if (target < matrix[r][c]) {
                r--;
            } else if (target > matrix[r][c]) {
                c++;
            } else {
                return true;
            }
        }
        return false;
    }
}

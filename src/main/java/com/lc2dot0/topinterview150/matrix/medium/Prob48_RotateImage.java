package com.lc2dot0.topinterview150.matrix.medium;

public class Prob48_RotateImage {
    public static void main(String[] args) {
//        int[][] m = new int[][]{
//                {5, 1, 9, 11},
//                {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
//        };
        int[][] m = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(m);
        print(m);
    }

    public static void rotate(int[][] matrix) {
        int[][] transposed = transpose(matrix);
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                matrix[i][j] = transposed[i][matrix.length - j - 1];
            }
        }
    }

    private static int[][] transpose(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }

    private static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%d ", m[i][j]);
            }
            System.out.println();
        }
    }
}

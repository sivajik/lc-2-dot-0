package com.lc2dot0.topinterview150.matrix.medium;

import java.util.HashSet;
import java.util.Set;

public class Prob36_ValidSudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (board[i][j] != '.') {
                    boolean existsInRow = seen.add("in row:" + i + ",val:" + c);
                    boolean existsInCol = seen.add("in col:" + j + ",val:" + c);
                    boolean existsInGrid = seen.add("in block:" + i / 3 + "&" + j / 3 + "&val:" + c);

                    if (!existsInRow || !existsInCol || !existsInGrid) {
                        System.out.println(i + "," + j + ", " + existsInRow + " , " + existsInCol + " , " + existsInGrid);
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
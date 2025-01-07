package lc.medium;

import java.util.HashSet;
import java.util.Set;

public class Prob0036_ValidSudoku {
    public static void main(String[] args) {
        char[][] ip = new char[][]{
                {
                        '5', '3', '.', '.', '7', '.', '.', '.', '.'
                },
                {
                        '6', '.', '.', '1', '9', '5', '.', '.', '.'
                },
                {
                        '.', '9', '8', '.', '.', '.', '.', '6', '.'
                },
                {
                        '8', '.', '.', '.', '6', '.', '.', '.', '3'
                },
                {
                        '4', '.', '.', '8', '.', '3', '.', '.', '1'
                },
                {
                        '7', '.', '.', '.', '2', '.', '.', '.', '6'
                },
                {
                        '.', '6', '.', '.', '.', '.', '2', '8', '.'
                },
                {
                        '.', '.', '.', '4', '1', '9', '.', '.', '5'
                },
                {
                        '.', '.', '.', '.', '8', '.', '.', '7', '9'
                }
        };
        System.out.println(isValidSudoku(ip));
    }

    static public boolean isValidSudoku(char[][] board) {
        boolean valid = true;
        int size = board.length;
        for (int row = 0; row < size; row++) {
            valid = valid && isValidComb(board[row]);

            char[] colArray = new char[size];
            for (int col = 0; col < size; col++) {
                colArray[col] = board[col][row];
            }
            valid = valid && isValidComb(colArray);
        }


        for (int row = 0; row < size; row = row + 3) {
            for (int col = 0; col < size; col = col + 3) {
                valid = valid && isValidSubGrid(board[row][col], board[row][col + 1], board[row][col + 2],
                        board[row + 1][col], board[row + 1][col + 1], board[row + 1][col + 2],
                        board[row + 2][col], board[row + 2][col + 1], board[row + 2][col + 2]
                );
            }
        }

        return valid;
    }

    static boolean isValidSubGrid(char c1, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        char[][] a1 = new char[][]{
                {c1, c2, c3},
                {c4, c5, c6},
                {c7, c8, c9}
        };
        char[][] a2 = new char[][]{
                {c1, c4, c7},
                {c2, c5, c8},
                {c3, c6, c9}
        };
        boolean valid = isValidComb(a1[0]) && isValidComb(a1[1]) && isValidComb(a1[2]) && isValidComb(a2[0]) && isValidComb(a2[1]) && isValidComb(a2[2]);
        return valid && isValidComb(new char[]{c1, c2, c3, c4, c5, c6, c7, c8, c9});
    }

    static boolean isValidComb(char[] line) {
        Set<Character> set = new HashSet<>();
        for (char c : line) {
            if (c != '.') {
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        return true;
    }
}

package com.bpkb.fiveinrow.client.game;

public class WinLogic {
    private static final int BOARD_SIZE = 15;
    private static final int WINNING_COUNT = 5;

    public static boolean checkWin(char[][] board, int row, int col, char playerSymbol) {
        return checkHorizontal(board, row, col, playerSymbol) ||
                checkVertical(board, row, col, playerSymbol) ||
                checkDiagonal1(board, row, col, playerSymbol) ||
                checkDiagonal2(board, row, col, playerSymbol);
    }

    private static boolean checkHorizontal(char[][] board, int row, int col, char playerSymbol) {
        int count = 1;

        for (int c = col + 1; c < BOARD_SIZE && board[row][c] == playerSymbol; c++) {
            count++;
            if (count >= WINNING_COUNT) {
                return true;
            }
        }

        for (int c = col - 1; c >= 0 && board[row][c] == playerSymbol; c--) {
            count++;
            if (count >= WINNING_COUNT) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkVertical(char[][] board, int row, int col, char playerSymbol) {
        int count = 1;

        for (int r = row + 1; r < BOARD_SIZE && board[r][col] == playerSymbol; r++) {
            count++;
            if (count >= WINNING_COUNT) {
                return true;
            }
        }

        for (int r = row - 1; r >= 0 && board[r][col] == playerSymbol; r--) {
            count++;
            if (count >= WINNING_COUNT) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkDiagonal1(char[][] board, int row, int col, char playerSymbol) {
        int count = 1;

        for (int r = row + 1, c = col + 1; r < BOARD_SIZE && c < BOARD_SIZE && board[r][c] == playerSymbol; r++, c++) {
            count++;
            if (count >= WINNING_COUNT) {
                return true;
            }
        }

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0 && board[r][c] == playerSymbol; r--, c--) {
            count++;
            if (count >= WINNING_COUNT) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkDiagonal2(char[][] board, int row, int col, char playerSymbol) {
        int count = 1;

        for (int r = row + 1, c = col - 1; r < BOARD_SIZE && c >= 0 && board[r][c] == playerSymbol; r++, c--) {
            count++;
            if (count >= WINNING_COUNT) {
                return true;
            }
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < BOARD_SIZE && board[r][c] == playerSymbol; r--, c++) {
            count++;
            if (count >= WINNING_COUNT) {
                return true;
            }
        }

        return false;
    }
}

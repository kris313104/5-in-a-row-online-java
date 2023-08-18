package com.bpkb.fiveinrow.client.game.controllers;

import com.bpkb.fiveinrow.client.game.WinLogic;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

    private final Random random = new Random();

    public void makeMove(Button[] buttons) {
        List<Integer> winningMoves = new ArrayList<>();
        List<Integer> blockingMoves = new ArrayList<>();
        List<Integer> emptyIndices = new ArrayList<>();

        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().equals("")) {
                emptyIndices.add(i);

                if (isWinningMove(buttons, i, "O")) {
                    winningMoves.add(i);
                } else if (isWinningMove(buttons, i, "X")) {
                    blockingMoves.add(i);
                } else if (isPotentialBlockingMove(buttons, i, "X")) {
                    blockingMoves.add(i);
                }
                if (WinLogic.checkWin(getCurrentBoardState(FiveInRowAIController.getButtons()), i / 15, i % 15, 'O')) {
                    buttons[i].setText("O");
                 FiveInRowAIController.disableButtons();
                    return;
                }
            }
        }

        if (!winningMoves.isEmpty()) {
            int winningMove = winningMoves.get(random.nextInt(winningMoves.size()));
            placeMove(buttons, winningMove, "O");
        } else if (!blockingMoves.isEmpty()) {
            int blockingMove = blockingMoves.get(random.nextInt(blockingMoves.size()));
            placeMove(buttons, blockingMove, "O");
        } else if (!emptyIndices.isEmpty()) {
            int randomIndex = emptyIndices.get(random.nextInt(emptyIndices.size()));
            placeMove(buttons, randomIndex, "O");
        }
    }

    private boolean isWinningMove(Button[] buttons, int index, String symbol) {
        buttons[index].setText(symbol);
        boolean isWinning = WinLogic.checkWin(getCurrentBoardState(buttons), index / 15, index % 15, symbol.charAt(0));
        buttons[index].setText("");  // Reset the button
        return isWinning;
    }

    private boolean isPotentialBlockingMove(Button[] buttons, int index, String symbol) {
        buttons[index].setText(symbol);
        boolean isPotentialBlocking = hasPotentialWinningSequence(buttons, index, symbol);
        buttons[index].setText("");  // Reset the button
        return isPotentialBlocking;
    }

    private boolean hasPotentialWinningSequence(Button[] buttons, int index, String symbol) {
        return hasPotentialRow(buttons, index, symbol) ||
                hasPotentialColumn(buttons, index, symbol) ||
                hasPotentialDiagonal(buttons, index, symbol);
    }

    private boolean hasPotentialRow(Button[] buttons, int index, String symbol) {
        int row = index / 15;
        int col = index % 15;
        int count = 0;

        for (int c = col - 1; c >= 0; c--) {
            if (buttons[row * 15 + c].getText().equals(symbol)) {
                count++;
            } else {
                break;
            }
        }

        for (int c = col + 1; c < 15; c++) {
            if (buttons[row * 15 + c].getText().equals(symbol)) {
                count++;
            } else {
                break;
            }
        }

        return count >= 3;
    }

    private boolean hasPotentialColumn(Button[] buttons, int index, String symbol) {
        int row = index / 15;
        int col = index % 15;
        int count = 0;

        for (int r = row - 1; r >= 0; r--) {
            if (buttons[r * 15 + col].getText().equals(symbol)) {
                count++;
            } else {
                break;
            }
        }

        for (int r = row + 1; r < 15; r++) {
            if (buttons[r * 15 + col].getText().equals(symbol)) {
                count++;
            } else {
                break;
            }
        }

        return count >= 3;
    }

    private boolean hasPotentialDiagonal(Button[] buttons, int index, String symbol) {
        return hasPotentialDiagonal1(buttons, index, symbol) ||
                hasPotentialDiagonal2(buttons, index, symbol);
    }

    private boolean hasPotentialDiagonal1(Button[] buttons, int index, String symbol) {
        int row = index / 15;
        int col = index % 15;
        int count = 0;

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (buttons[r * 15 + c].getText().equals(symbol)) {
                count++;
            } else {
                break;
            }
        }

        for (int r = row + 1, c = col + 1; r < 15 && c < 15; r++, c++) {
            if (buttons[r * 15 + c].getText().equals(symbol)) {
                count++;
            } else {
                break;
            }
        }

        return count >= 3;
    }

    private boolean hasPotentialDiagonal2(Button[] buttons, int index, String symbol) {
        int row = index / 15;
        int col = index % 15;
        int count = 0;

        for (int r = row - 1, c = col + 1; r >= 0 && c < 15; r--, c++) {
            if (buttons[r * 15 + c].getText().equals(symbol)) {
                count++;
            } else {
                break;
            }
        }

        for (int r = row + 1, c = col - 1; r < 15 && c >= 0; r++, c--) {
            if (buttons[r * 15 + c].getText().equals(symbol)) {
                count++;
            } else {
                break;
            }
        }

        return count >= 3;
    }

    private void placeMove(Button[] buttons, int index, String symbol) {
        buttons[index].setTextFill(Color.rgb(235, 219, 240));
        buttons[index].setText(symbol);
    }

    private char[][] getCurrentBoardState(Button[] buttons) {
        char[][] board = new char[15][15];
        for (int i = 0; i < buttons.length; i++) {
            char symbol = buttons[i].getText().isEmpty() ? ' ' : buttons[i].getText().charAt(0);
            board[i / 15][i % 15] = symbol;
        }
        return board;
    }
}

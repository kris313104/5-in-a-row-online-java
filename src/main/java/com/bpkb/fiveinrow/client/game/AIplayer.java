package com.bpkb.fiveinrow.client.game;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class AIplayer {

    private final Random random = new Random();

    public void makeMove(JButton[] buttons) {
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
                }
            }
        }

        // Choose a move based on strategy priorities
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

    private boolean isWinningMove(JButton[] buttons, int index, String symbol) {
        buttons[index].setText(symbol);
        boolean isWinning = WinLogic.checkWin(getCurrentBoardState(buttons), index / 15, index % 15, symbol.charAt(0));
        buttons[index].setText("");  // Reset the button
        return isWinning;
    }

    private void placeMove(JButton[] buttons, int index, String symbol) {
        buttons[index].setForeground(new Color(235, 219, 240));
        buttons[index].setText(symbol);
    }

    private char[][] getCurrentBoardState(JButton[] buttons) {
        char[][] board = new char[15][15];
        for (int i = 0; i < buttons.length; i++) {
            char symbol = buttons[i].getText().isEmpty() ? ' ' : buttons[i].getText().charAt(0);
            board[i / 15][i % 15] = symbol;
        }
        return board;
    }
}

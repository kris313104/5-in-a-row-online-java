package com.bpkb.fiveinrow.client.game.controllers;

import com.bpkb.fiveinrow.client.game.WinLogic;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;



public class FiveInRowAIController {
    private boolean player1_turn = true;
    @FXML
    private Text turnLabel;

    @FXML
    private GridPane gridPane;

    private final AI ai = new AI();


    private static Button[] buttons = new Button[15*15];
    @FXML
    private void initialize() {

        for (int i = 0; i < gridPane.getColumnCount(); i++) {
            for (int j = 0; j < gridPane.getRowCount(); j++) {
                Button initButton = new Button();
                initButton.setPrefHeight(1000);
                initButton.setOnAction(this::actionPerformed);
                initButton.setPrefWidth(1000);
                gridPane.add(initButton, i, j);
                buttons[j + i * 15] = initButton;
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                if (buttons[i].getText().equals("")) {



                    buttons[i].setText("X");
                    turnLabel.setText("Player 2 (O) turn");

                    //x move and wins
                    if (WinLogic.checkWin(getCurrentBoardState(), i / 15, i % 15, 'X')) {

                        disableButtons();
                        return;
                    }

                    //AIplayer move
                    ai.makeMove(buttons);
                    turnLabel.setText("Player 1 (X) turn");

                    //ai move and win checking
                    if (WinLogic.checkWin(getCurrentBoardState(), i / 15, i % 15, 'O')) {

                        disableButtons();
                        return;
                    }
                }
            }
        }
    }
    private char[][] getCurrentBoardState() {
        char[][] board = new char[15][15];
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().equals("X")) {
                board[i / 15][i % 15] = 'X';
            } else if (buttons[i].getText().equals("O")) {
                board[i / 15][i % 15] = 'O';
            }
        }
        return board;
    }
    public static void disableButtons() {
        for (Button button : buttons) {
            button.setDisable(true);
        }
    }
    public static Button[] getButtons() {
        return buttons;
    }
}



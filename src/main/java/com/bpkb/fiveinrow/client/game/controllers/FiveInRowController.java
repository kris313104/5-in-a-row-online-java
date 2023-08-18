package com.bpkb.fiveinrow.client.game.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.awt.event.ActionEvent;

public class FiveInRowController {

    @FXML
    GridPane gridPane;
    @FXML
    private void initialize() {

        for (int i = 0; i < gridPane.getColumnCount(); i++) {
            for (int j = 0; j < gridPane.getRowCount(); j++) {
                Button initButton = new Button();
                initButton.setPrefHeight(1000);

                initButton.setPrefWidth(1000);
                gridPane.add(initButton, i, j);
            }
        }
    }

}


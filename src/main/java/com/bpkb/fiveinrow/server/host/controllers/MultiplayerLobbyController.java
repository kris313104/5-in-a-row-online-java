package com.bpkb.fiveinrow.server.host.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MultiplayerLobbyController {
    @FXML
    public TextField portTextField;
    @FXML
    public Label ipInfoLabel;
    @FXML
    public Label portInfoLabel;
    @FXML
    public Button joinGameButton;

    @FXML
    public TextField ipAddressTextField;
    @FXML
    public TextField hostPortTextField;
    @FXML
    public Label hostPortInfoLabel;
    @FXML
    public Button hostGameButton;
}

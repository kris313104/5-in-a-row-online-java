package com.bpkb.fiveinrow.server.host.controllers;

import com.bpkb.fiveinrow.client.FiveinrowApplication;
import com.bpkb.fiveinrow.server.host.ClientGame;
import com.bpkb.fiveinrow.server.host.HostGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

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
    @FXML
    public Tab joinGameTab;
    @FXML
    public Tab hostGameTab;
    @FXML
    public Label waitingLabel;

    @FXML
    private void initialize() {
        joinGameButton.setOnAction(this::joinGame);
        hostGameButton.setOnAction(this::hostGame);
        waitingLabel.setVisible(false);
    }
    private void joinGame(ActionEvent event) {

        try {
            String ip = ipAddressTextField.getText();
            int port = Integer.parseInt(portTextField.getText());
            Thread thread = new Thread(() -> {
                ClientGame clientGame = new ClientGame();
                clientGame.initConnection(ip, port);

            });
//                for (JFrame window : FiveinrowApplication.openWindows) {
//                    window.dispose();
//                }

            thread.start();

//                this.dispose();
//                generateHost.setEnabled(false);
//                connectButton.setEnabled(false);

        } catch (NumberFormatException ex) {
            System.out.println(ex);
            portInfoLabel.setText("Invalid port");
        }
    }

    private void hostGame(ActionEvent event) {
        try {
            int port = Integer.parseInt(hostPortTextField.getText());

            Thread thread = new Thread(() -> {
                HostGame hostGame = new HostGame();
                hostGame.initConnection(port);

            });

            thread.start();

            hostGameButton.setDisable(true);
            waitingLabel.setVisible(true);
//            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//            stage.close();
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            hostPortInfoLabel.setText("Invalid port");
        }
    }

}

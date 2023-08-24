package com.bpkb.fiveinrow.client.game.controllers;

import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import com.bpkb.fiveinrow.client.FiveInRowMain;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class MainMenuController{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button game1;

    @FXML
    private Button game2;

    @FXML
    private Button game3;




    @FXML
    private  void switchStyle(ActionEvent event) {
        Button button = (Button)event.getSource();
        PrimerDark dark = new PrimerDark();
        PrimerLight light = new PrimerLight();
        if (Application.getUserAgentStylesheet().equals(dark.getUserAgentStylesheet())) {
            Application.setUserAgentStylesheet(light.getUserAgentStylesheet());
            button.setText("Dark mode?");
        }
        else {
            Application.setUserAgentStylesheet(dark.getUserAgentStylesheet());
            button.setText("Light mode?");
        }

    }



    @FXML
    private void onGameOneButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader =new FXMLLoader(FiveInRowMain.class.getResource("five-in-row-game.fxml"));
        fxmlLoader.setController(new FiveInRowController());

        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 900);

        stage.setScene(scene);
//        stage.setFullScreen(true);
        stage.setHeight(0);
        stage.show();

    }

    @FXML
    private void onGameTwoButtonClick(ActionEvent event) throws IOException {
        System.out.println("game2");
        FXMLLoader fxmlLoader =new FXMLLoader(FiveInRowMain.class.getResource("lobby.fxml"));
        // change controller class for different game mode
//        fxmlLoader.setController(new FiveInRowController());

        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void onGameThreeButtonClick(ActionEvent event) throws IOException {
        System.out.println("game3");
        FXMLLoader fxmlLoader =new FXMLLoader(FiveInRowMain.class.getResource("five-in-row-game.fxml"));
        // change controller class for different game mode
        fxmlLoader.setController(new FiveInRowAIController());

        root = fxmlLoader.load();



        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }
}

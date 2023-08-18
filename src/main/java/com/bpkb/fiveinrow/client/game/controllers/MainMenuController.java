package com.bpkb.fiveinrow.client.game.controllers;

import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;


public class MainMenuController {

//    @FXML
//    Button game1;
//
//    @FXML
//    Button game2;
//
//    @FXML
//    Button game3;

    @FXML
    protected void switchStyle(ActionEvent event) {
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
    public void onButtonClick(ActionEvent event) {
        System.out.println("test");
    }
}

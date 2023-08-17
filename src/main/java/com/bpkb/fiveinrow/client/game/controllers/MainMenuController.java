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
        if (Application.getUserAgentStylesheet().equals(PrimerDark.class)) {
            Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        }
        else {
            Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        }

    }



    @FXML
    public void onButtonClick(ActionEvent event) {
        System.out.println("test");
    }
}

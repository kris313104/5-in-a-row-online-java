package com.bpkb.fiveinrow.client;

import atlantafx.base.theme.PrimerDark;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Map;

public class FiveInRowMain extends Application{
    public static void main(String[] args) throws IOException {
//        System.out.println(FiveInRowMain.class.getResource("main-menu.fxml").toString());
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        FXMLLoader fxmlLoader = new FXMLLoader(FiveInRowMain.class.getResource("main-menu.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Five in a row");
        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();
    }
}

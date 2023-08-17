package com.bpkb.fiveinrow.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Map;

public class FiveInRowMain extends Application{
    public static void main(String[] args) throws IOException {
        System.out.println(Application.class.getResource("").toString());
                launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/main-menu.fxml"));
////        fxmlLoader.setController(new MainMenuController());
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Five in a row");
//        stage.setResizable(false);
//        stage.setScene(scene);
//
//        stage.show();
    }
}

package com.test.view;

import com.test.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws  Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginView loginView = new LoginView();
        loginView.start(new Stage());
    }
}

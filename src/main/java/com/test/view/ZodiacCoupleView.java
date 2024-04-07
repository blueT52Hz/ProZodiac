package com.test.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZodiacCoupleView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZodiacCoupleView.class.getResource("ZodiacCoupleScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("ZodiacCouple");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

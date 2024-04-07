package com.test.view;

import com.test.controller.ChooseFunctionController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseFunctionView extends Application {
    private ChooseFunctionController chooseFunctionController;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ChooseFunction.fxml"));
        Scene scene = new Scene((Parent) loader.load());
        ChooseFunctionController controller = loader.getController();
        controller.setAccount(this.chooseFunctionController.getAccount());
        System.out.println(chooseFunctionController.getAccount().getUsername());
        primaryStage.setTitle("ChooseFunction");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setChooseFunctionController(ChooseFunctionController chooseFunctionController) {
        this.chooseFunctionController=chooseFunctionController;
    }
}

package com.test.view;

import com.test.controller.ShowInforSingleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowInforView extends Application {
    private ShowInforSingleController showInforSingleController;
    public void setController(ShowInforSingleController showInforSingleController) {
        this.showInforSingleController = showInforSingleController;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ShowInforSingleScene.fxml"));
        Scene scene = new Scene( fxmlLoader.load());
        ShowInforSingleController controller = fxmlLoader.getController();
        controller.setChoosedProfile(showInforSingleController.getChoosedProfile());
        controller.setAccount(showInforSingleController.getAccount());
        controller.showInfor();
        primaryStage.setTitle("ShowInfor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

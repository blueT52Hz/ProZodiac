package com.test.view;

import com.test.controller.NewProfileController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class NewProfileView extends Application {
    private NewProfileController newProfileController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(NewProfileView.class.getResource("NewProfileScene.fxml"));
        Scene scene = new Scene(loader.load());
        NewProfileController controller = loader.getController();
        controller.setAccount(newProfileController.getAccount());
        primaryStage.setTitle("New Profile");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setController(NewProfileController newProfileController) {
        this.newProfileController=newProfileController;
    }
    public void notice(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(content);
//        ButtonType buttonType = new ButtonType("OK", ButtonBar.ButtonData.YES);
        alert.show();
    }
}

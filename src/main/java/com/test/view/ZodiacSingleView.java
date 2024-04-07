package com.test.view;

import com.test.controller.ZodiacSingleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class ZodiacSingleView extends Application {

    private ZodiacSingleController zodiacSingleController;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginView.class.getResource("ZodiacSingleScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ZodiacSingleController controller = fxmlLoader.getController();
        controller.setAccount(this.zodiacSingleController.getAccount());
        controller.setStage(primaryStage);
        controller.updateProfileList();
        System.out.println(controller.getAccount().getUsername());

        primaryStage.setTitle("ZodiacSingle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setController(ZodiacSingleController zodiacSingleController) {
        this.zodiacSingleController=zodiacSingleController;
    }

    public void notice(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(content);
//        ButtonType buttonType = new ButtonType("OK", ButtonBar.ButtonData.YES);
        alert.show();
    }

}

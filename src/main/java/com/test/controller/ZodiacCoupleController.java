package com.test.controller;

import com.test.view.ChooseFunctionView;
import com.test.view.NewProfileView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ZodiacCoupleController {
    @FXML
    protected Button newProfileButton, showInformationButton, onClickBackButton;

    @FXML
    protected Label choosedProfileLabel;

    @FXML
    protected void onClickNewProfileButton(ActionEvent event) throws IOException {
        new NewProfileView().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    protected void onClickBackButton(ActionEvent event) throws IOException {
        new ChooseFunctionView().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    protected void chooseThisProfile(ActionEvent event) {
        this.choosedProfileLabel.setText("Tùng Tùng Tùng");
    }

    @FXML
    protected void editProfile(ActionEvent event) throws IOException {
        new NewProfileView().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    protected void onClickShowInformationButton(ActionEvent event) {

    }
}

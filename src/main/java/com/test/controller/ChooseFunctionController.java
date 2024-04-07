package com.test.controller;

import com.test.model.Account;
import com.test.view.LoginView;
import com.test.view.ZodiacCoupleView;
import com.test.view.ZodiacSingleView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseFunctionController implements Initializable {
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    @FXML
    protected Button zodiacSingleButton, zodiacCouple, backButton;
    @FXML
    protected void onClickZodiacSingleButton(ActionEvent event) throws IOException {
        ZodiacSingleView zodiacSingleView = new ZodiacSingleView();
        ZodiacSingleController zodiacSingleController = new ZodiacSingleController();
        zodiacSingleController.setAccount(this.getAccount());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        zodiacSingleController.setStage(stage);
        zodiacSingleView.setController(zodiacSingleController);
        zodiacSingleView.start(stage);
    }

    @FXML
    protected void onClickZodiacCouple(ActionEvent event) throws IOException {
        new ZodiacCoupleView().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    protected void onClickBackButton(ActionEvent event) throws IOException {
        new LoginView().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

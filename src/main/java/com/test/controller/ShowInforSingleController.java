package com.test.controller;

import com.test.model.Account;
import com.test.model.Profile;
import com.test.model.ReadFile;
import com.test.view.ZodiacSingleView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowInforSingleController {
    private Account account;
    private Profile choosedProfile;
    @FXML
    protected Label choosedProfileLabel;
    @FXML
    protected TextArea inforTextArea;
    public Profile getChoosedProfile() {
        return choosedProfile;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setChoosedProfile(Profile choosedProfile) {
        this.choosedProfile = choosedProfile;
    }

    public void showInfor() throws IOException {
        this.choosedProfileLabel.setText(choosedProfile.toString());
        String infor = ReadFile.readFileToString("data\\Sun\\"+choosedProfile.getZodiacSun()+".txt");
        this.inforTextArea.setText(infor);
    }


    public void onClickBackButton(ActionEvent event) throws IOException {
        ZodiacSingleView zodiacSingleView = new ZodiacSingleView();
        ZodiacSingleController zodiacSingleController = new ZodiacSingleController();
        zodiacSingleController.setAccount(this.account);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        zodiacSingleController.setStage(stage);
        zodiacSingleView.setController(zodiacSingleController);
        zodiacSingleView.start(stage);
    }
}

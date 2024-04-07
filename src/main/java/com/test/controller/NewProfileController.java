package com.test.controller;

import com.test.model.*;
import com.test.view.LoginView;
import com.test.view.NewProfileView;
import com.test.view.ZodiacSingleView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class NewProfileController {
    private Account account;
    private Profile oldProfile;
    @FXML
    protected Button backButton, saveProfileButton;
    @FXML
    protected DatePicker datePicker;
    @FXML
    protected TextField nameProfileTextField;

    @FXML
    protected void onClickBackButton(ActionEvent event) throws IOException {
        ZodiacSingleView zodiacSingleView = new ZodiacSingleView();
        ZodiacSingleController zodiacSingleController = new ZodiacSingleController();
        zodiacSingleController.setAccount(this.getAccount());
        zodiacSingleView.setController(zodiacSingleController);
        zodiacSingleView.start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    @FXML
    protected void onClickSaveProfileButton(ActionEvent event) throws IOException {
        String name = nameProfileTextField.getText();
        LocalDate date = datePicker.getValue();
        if(name == null || date==null) {
            new NewProfileView().notice("Vui lòng nhập đầy đủ thông tin.");
            return;
        }
        Birthday birthday = new Birthday(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        Profile newProfile = new Profile(nameProfileTextField.getText().trim(), birthday);
        if(oldProfile!=null && oldProfile.toString().equals(newProfile.toString())) {
            new NewProfileView().notice("Bạn chưa đổi thông tin hồ sơ!");
            return;
        }
        if(oldProfile != null) {
            account.getProfileList().remove(oldProfile);
        }
        account.getProfileList().add(newProfile);
        List<String> profileList = ReadFile.getListString("data\\User\\"+account.getUsername()+".txt");
        if(profileList.contains(newProfile.toString())) {
            new NewProfileView().notice("Hồ sơ đã tồn tại !");
        } else {
            new NewProfileView().notice("Lưu hồ sơ thành công!");
            WriteFile.writeProfile("data\\User\\"+account.getUsername()+".txt", newProfile.toString());
        }
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public Account getAccount() {
        return account;
    }

}

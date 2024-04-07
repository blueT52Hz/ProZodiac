package com.test.controller;

import com.test.model.Account;
import com.test.model.Profile;
import com.test.view.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ZodiacSingleController {
    protected Account account;
    private Stage stage;
    private Profile choosedProfile;

    @FXML
    protected Button newProfileButton, showInformationButton, backButton;

    @FXML
    protected Label choosedProfileLabel;
    @FXML
    protected VBox profileListVBox;

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void updateProfileList() {
        for (Profile profile : account.getProfileList()) {
            MenuButton menuButton = new MenuButton();
            menuButton.setAlignment(Pos.CENTER);
            menuButton.setId("menuButton");
            menuButton.getStylesheets();
            MenuItem choose = new MenuItem("Chọn hồ sơ");
            choose.setOnAction(event -> {
                System.out.println("Chọn hồ sơ");
                this.choosedProfile = profile;
                choosedProfileLabel.setText(menuButton.getText());
            });
            MenuItem edit = getMenuItem();
            MenuItem delete = new MenuItem("Xóa hồ sơ");
            delete.setOnAction(event -> {
                this.profileListVBox.getChildren().remove(menuButton);
                this.account.getProfileList().remove(profile);
            });
            menuButton.getItems().addAll(choose,edit, delete);
            menuButton.setText(profile.getName() + " - " + profile.getBirthday().toString());
            menuButton.setPrefWidth(316);
            menuButton.setPrefHeight(40);
            profileListVBox.getChildren().add(menuButton);
        }
    }

    private MenuItem getMenuItem() {
        MenuItem edit = new MenuItem("Sửa hồ sơ");
        edit.setOnAction(event -> {
            try {
                NewProfileView newProfileView = new NewProfileView();
                NewProfileController newProfileController = new NewProfileController();
                newProfileController.setAccount(this.getAccount());
                newProfileView.setController(newProfileController);
                newProfileView.start(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return edit;
    }

    @FXML
    protected void onClickNewProfileButton(ActionEvent event) throws IOException {
        NewProfileView newProfileView = new NewProfileView();
        NewProfileController newProfileController = new NewProfileController();
        newProfileController.setAccount(this.getAccount());
        newProfileView.setController(newProfileController);
        newProfileView.start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    protected void onClickBackButton(ActionEvent event) throws IOException {
        ChooseFunctionView chooseFunctionView = new ChooseFunctionView();
        ChooseFunctionController chooseFunctionController = new ChooseFunctionController();
        chooseFunctionController.setAccount(this.account);
        chooseFunctionView.setChooseFunctionController(chooseFunctionController);
        chooseFunctionView.start((Stage) (((Node) event.getSource()).getScene().getWindow()));
    }


    @FXML
    protected void editProfile(ActionEvent event) throws IOException {
//        new NewProfileView().start((Stage) ((Node) event.getSource()).getScene().getWindow());
        NewProfileView newProfileView = new NewProfileView();
        NewProfileController newProfileController = new NewProfileController();
        newProfileController.setAccount(this.account);
        newProfileView.setController(newProfileController);
        newProfileView.start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    protected void onClickShowInformationButton(ActionEvent event) throws IOException {
        if(choosedProfile==null) {
            new ZodiacSingleView().notice("Bạn chưa chọn hồ sơ nào!");
            return;
        }
        ShowInforView showInforView = new ShowInforView();
        ShowInforSingleController showInforSingleController = new ShowInforSingleController();
        showInforSingleController.setChoosedProfile(choosedProfile);
        showInforSingleController.setAccount(this.account);
        showInforView.setController(showInforSingleController);
        showInforView.start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

}

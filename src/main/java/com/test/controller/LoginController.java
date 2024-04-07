package com.test.controller;

import com.test.model.Account;
import com.test.model.ReadFile;
import com.test.view.ChooseFunctionView;
import com.test.view.LoginView;
import com.test.view.RegisterView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    protected Button registerButton, loginButton, forgotPasswordButton;
    @FXML
    protected TextField usernameTextField, passwordTextField;

    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }
    public Account getAccount(){
        return this.account;
    }

    @FXML
    protected void onClickRegisterButtonClick(ActionEvent event) throws IOException {
        new RegisterView().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    protected void onClickLoginButtonClick(ActionEvent event) throws IOException{
        List<String> listAccount = ReadFile.getListString("data\\User\\listAccount.txt");
        String account = usernameTextField.getText()+"|"+passwordTextField.getText();
        LoginView loginView = new LoginView();
        if(listAccount.contains(account)) {
            loginView.notice("Đăng nhập thành công!");
            ChooseFunctionView chooseFunctionView = new ChooseFunctionView();
            ChooseFunctionController chooseFunctionController = new ChooseFunctionController();
            this.account = new Account(usernameTextField.getText());
            this.account.updateProfileList();
            chooseFunctionController.setAccount(this.account);
            chooseFunctionView.setChooseFunctionController(chooseFunctionController);
            chooseFunctionView.start((Stage) (((Node) event.getSource()).getScene().getWindow()));
        } else {
            boolean existUsername=false;
            for(String tmp:listAccount) {
//                System.out.println(tmp.split("\\|")[0]);
                if(tmp.split("\\|")[0].equals(usernameTextField.getText())) {
                    loginView.notice("Mật khẩu không đúng!");
                    existUsername=true;
                    break;
                }
            }
            if(!existUsername) loginView.notice("Tài khoản không tồn tại!");
        }
    }


    @FXML
    protected void onClickForgotPasswordButtonClick() {
        new LoginView().notice("Mỗi thế cũng quên, thế nyc có quên không ?");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
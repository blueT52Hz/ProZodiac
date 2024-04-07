package com.test.controller;
import com.test.model.ReadFile;
import com.test.model.WriteFile;
import com.test.view.LoginView;
import com.test.view.RegisterView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RegisterController {
    @FXML
    protected Button registerButton;

    @FXML
    protected PasswordField passwordField, confirmPasswordField;
    @FXML
    protected TextField usernameTextField;
    @FXML
    protected void onClickBackButton(ActionEvent event) throws IOException {
        new LoginView().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    protected void onClickRegisterButton(ActionEvent event) throws IOException {
        RegisterView registerView = new RegisterView();
        if(confirmPasswordField.getText().isEmpty()) {
            registerView.notice("Hãy nhập mật khẩu!");
        } else if(!confirmPasswordField.getText().equals(passwordField.getText())) {
            registerView.notice("Xác nhận mật khẩu không đúng!");
        } else {
            List<String> listAccount = ReadFile.getListString("data\\User\\listAccount.txt");
            for (String account:listAccount) {
                if(account.split("\\|")[0].equals(usernameTextField.getText())) {
                    registerView.notice("Tên đăng nhập đã tồn tại!");
                    return;
                }
            }
            WriteFile.writeNewAccount(usernameTextField.getText()+"|"+passwordField.getText());
            try {
                String pathName = "data\\User\\" + usernameTextField.getText()+".txt";
                File file = new File(pathName);
                file.createNewFile();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            registerView.notice("Đăng kí thành công!");
            onClickBackButton(event);
        }
    }

}

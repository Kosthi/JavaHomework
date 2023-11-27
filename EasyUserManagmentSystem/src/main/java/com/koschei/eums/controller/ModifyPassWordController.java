package com.koschei.eums.controller;

import com.koschei.eums.EUMSApplication;
import com.koschei.eums.dao.FileManager;
import com.koschei.eums.entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ModifyPassWordController implements Initializable {
    private static Stage stage; // Reference to the application stage

    @FXML
    private Button modifyButton;

    @FXML
    private PasswordField pwd1;

    @FXML
    private PasswordField pwd2;

    public void setStage(Stage stage) {
        ModifyPassWordController.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modifyButton.setOnMouseClicked(actionEvent -> {
            if (pwd1.getText().isEmpty() || pwd2.getText().isEmpty()) {
                showAlert("密码不能为空");
                return;
            }
            if (pwd1.getText().equals(pwd2.getText())) {
                modifyPwd();
                loadMenuInterface();
                return;
            }
            showAlert("两次密码不匹配");
        });
    }

    public void modifyPwd() {
        System.out.println(LoginController.userList.size());
        for (User user : LoginController.userList) {
            if (user.equals(LoginController.currentUser)) {
                user.setPassword(pwd1.getText());
                try {
                    FileManager.flushUsersToFile(LoginController.userList);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                showAlert("密码修改成功");
                return;
            }
        }
        showAlert("错误：未找到用户");
    }

    private void loadMenuInterface() {
        // Load and display the menu interface
        FXMLLoader loader = new FXMLLoader(EUMSApplication.class.getResource("menu.fxml"));
        Parent menuRoot;
        try {
            menuRoot = loader.load();
            MenuController menuController = loader.getController();
            menuController.setStage(stage);

            Scene menuScene = new Scene(menuRoot);
            stage.setScene(menuScene);
            stage.setTitle("菜单");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("通知");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

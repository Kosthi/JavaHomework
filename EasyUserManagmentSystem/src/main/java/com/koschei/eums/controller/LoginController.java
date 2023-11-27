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

/**
 * @author Koschei
 * @date 2023/11/1
 */
public class LoginController implements Initializable {
    private static Stage stage; // Reference to the application stage
    @FXML
    private Label registLabel;
    @FXML
    private Button loginButton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    public static List<User> userList; // Store user information here

    public static User currentUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            userList = FileManager.readUsersFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        registLabel.setOnMouseClicked(actionEvent -> {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                System.out.println("Empty info");
                return;
            }

            if (showConfirmationDialog()) {

                for (User user : userList) {
                    if (user.getName().equals(username.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        DialogPane dialogPane = alert.getDialogPane();
                        dialogPane.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");

                        alert.setTitle("注册");
                        alert.setHeaderText(null);  // 如果不需要头部文本，设置为null
                        alert.setContentText("用户已经注册！");
                        alert.showAndWait();
                        return;
                    }
                }

                User user = new User(username.getText(), password.getText());
                try {
                    // 更新文件中的用户列表
                    FileManager.writeUserToFile(user);
                } catch (IOException e) {
                    // 创建信息对话框
                    Alert alert = new Alert(Alert.AlertType.ERROR);

                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");

                    alert.setTitle("注册");
                    alert.setHeaderText(null);  // 如果不需要头部文本，设置为null
                    alert.setContentText("注册失败!（FileManager Error");
                    alert.showAndWait();
                    return;
                }

                // 更新内存中的用户列表
                userList.add(user);

                // 创建信息对话框
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");

                alert.setTitle("注册");
                alert.setHeaderText(null);  // 如果不需要头部文本，设置为null
                alert.setContentText("注册成功!");
                alert.showAndWait();

                System.out.println("注册成功!");
                System.out.println("Username: " + username.getText() + " password: " + password.getText());
            }
        });

        loginButton.setOnAction(actionEvent -> {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                return;
            }

            User user;
            try {
                user = validateUser(username.getText(), password.getText());
            } catch (InvalidNameException e) {
                // 创建信息对话框
                Alert alert = new Alert(Alert.AlertType.ERROR);

                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");

                alert.setTitle("登录");
                alert.setHeaderText(null);  // 如果不需要头部文本，设置为null
                alert.setContentText("未找到用户!");
                alert.showAndWait();

                System.out.println("未找到用户: " + username.getText());
                return;
            } catch (InvalidPasswordException e) {
                // 创建信息对话框
                Alert alert = new Alert(Alert.AlertType.ERROR);

                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");

                alert.setTitle("登录");
                alert.setHeaderText(null);  // 如果不需要头部文本，设置为null
                alert.setContentText("密码错误!");
                alert.showAndWait();

                System.out.println("密码错误: " + password.getText());
                return;
            }

            currentUser = user;

            // 创建信息对话框
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");

            alert.setTitle("登录");
            alert.setHeaderText(null);  // 如果不需要头部文本，设置为null
            alert.setContentText("登录成功!");
            alert.showAndWait();

            System.out.println("登录成功!");

            System.out.println("Username: " + user.getName() + " password: " + user.getPassword());

            // 注册成功后进入菜单界面
            loadMenuInterface();
        });
    }

    private User validateUser(String enteredName, String enteredPassword) throws InvalidNameException, InvalidPasswordException {
        // Implement user validation logic here
        // Check if the entered name and password match any user's information
        for (User user : userList) {
            if (user.getName().equals(enteredName)) {
                if (user.getPassword().equals(enteredPassword)) {
                    return user;
                } else {
                    throw new InvalidPasswordException("Incorrect password.");
                }
            }
        }
        throw new InvalidNameException("User not found.");
    }

    private boolean showConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        // 设置字体样式
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px;");

        alert.setTitle("注册");
        alert.setHeaderText(null);
        alert.setContentText("请确定是否注册?");

        // 显示对话框并等待用户响应
        return alert.showAndWait().filter(response -> response == ButtonType.OK).isPresent();
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

    // Set the stage for this controller
    public void setStage(Stage stage) {
        LoginController.stage = stage;
    }

    public static class InvalidNameException extends Exception {
        public InvalidNameException(String message) {
            super(message);
        }
    }

    public static class InvalidPasswordException extends RuntimeException {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }
}

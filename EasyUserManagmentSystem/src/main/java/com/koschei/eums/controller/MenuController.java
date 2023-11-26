package com.koschei.eums.controller;

import com.koschei.eums.EUMSApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    private static Stage stage; // Reference to the application stage
    @FXML
    private Button viewMessageButton;
    @FXML
    private Button logoutButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewMessageButton.setOnMouseClicked(actionEvent -> {
            loadMessageInterface();
        });
        logoutButton.setOnMouseClicked(actionEvent -> {
            loadLoginInterface();
        });
    }

    // Set the stage for this controller
    public void setStage(Stage stage) {
        MenuController.stage = stage;
    }

    private void loadMessageInterface() {
        // Load and display the message interface
        FXMLLoader loader = new FXMLLoader(EUMSApplication.class.getResource("message.fxml"));
        Parent root;
        try {
            root = loader.load();
            MessageController messageController = loader.getController();
            messageController.setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("消息");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLoginInterface() {
        // Load and display the login interface
        FXMLLoader loader = new FXMLLoader(EUMSApplication.class.getResource("login.fxml"));
        Parent root;
        try {
            root = loader.load();
            LoginController loginController = loader.getController();
            loginController.setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("登陆");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

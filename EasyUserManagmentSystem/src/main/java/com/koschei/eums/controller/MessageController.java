package com.koschei.eums.controller;

import com.koschei.eums.EUMSApplication;
import com.koschei.eums.dao.FileManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class MessageController {

    private static Stage stage;
    @FXML
    private TextArea messageTextArea;

    public void setStage(Stage stage) {
        MessageController.stage = stage;
    }

    @FXML
    private void saveMessage() {
        // Get the message content from the TextArea and write to file
        try {
            FileManager.writeMessageToFile(messageTextArea.getText());
            showAlert("消息保存成功！");
        } catch (IOException e) {
            showAlert("消息保存失败！（文件 IO 错误）");
        }
    }

    @FXML
    private void closeMessage() {
        loadMenuInterface();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("通知");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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

    @FXML
    public void initialize() {
        try {
            messageTextArea.setText(FileManager.readMessageFromFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

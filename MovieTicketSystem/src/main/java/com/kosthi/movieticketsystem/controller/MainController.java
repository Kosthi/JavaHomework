package com.kosthi.movieticketsystem.controller;

import com.kosthi.movieticketsystem.entity.TicketRequest;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ComboBox<String> windowComboBox;

    @FXML
    private ComboBox<String> movieComboBox;

    @FXML
    private ComboBox<String> seatComboBox;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Button buyButton;

    @FXML
    private Button refundButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 1; i <= 200; i++) {
            seatComboBox.getItems().add("座位 " + i);
        }
        buyButton.setOnMouseClicked(e -> {
            String windowName = windowComboBox.getValue();
            String movieName = movieComboBox.getValue();
            String seatName = seatComboBox.getValue();

            try {
                Socket socket = new Socket("localhost", 8888);
                ObjectOutputStream toServer =
                        new ObjectOutputStream(socket.getOutputStream());
                TicketRequest ticketReq = new TicketRequest(windowName, movieName, seatName, true);
                System.out.println("A buy ticket request is sent.");
                toServer.writeObject(ticketReq);
                socket.shutdownOutput();

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                outputTextArea.appendText(dis.readUTF());
                System.out.println("A buy ticket response is received.");

                //截断输入流
                socket.shutdownInput();
                //关闭流
                toServer.close();
                dis.close();
                socket.close();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        refundButton.setOnMouseClicked(e -> {
            String windowName = windowComboBox.getValue();
            String movieName = movieComboBox.getValue();
            String seatName = seatComboBox.getValue();

            try {
                Socket socket = new Socket("localhost", 8888);
                ObjectOutputStream toServer =
                        new ObjectOutputStream(socket.getOutputStream());
                TicketRequest ticketReq = new TicketRequest(windowName, movieName, seatName, false);
                System.out.println("A refund ticket request is sent.");
                toServer.writeObject(ticketReq);
                socket.shutdownOutput();

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                outputTextArea.appendText(dis.readUTF());
                System.out.println("A refund ticket response is received.");

                //截断输入流
                socket.shutdownInput();
                //关闭流
                toServer.close();
                dis.close();
                socket.close();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}

package com.kosthi.movieticketsystem.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TicketServer {
    public TicketServer() {
        ServerSocket server = null;
        Socket you = null;
        while (true) {
            try {
                server = new ServerSocket(8888);
            } catch (IOException e) {
                System.out.println("正在监听");
            }

            try {
                you = server.accept();
                System.out.println("客户地址：" + you.getInetAddress());
            } catch (IOException e) {
                System.out.println("正在等待客户");
            }

            if (you != null) {
                new ServerThread(you).start();
            }
        }
    }

    public static void main(String[] args) {
        new TicketServer();
    }
}

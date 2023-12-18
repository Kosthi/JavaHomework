package com.kosthi.movieticketsystem.server;

import com.kosthi.movieticketsystem.entity.TicketRequest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private final Socket socket;

    private final TicketManager ticketManager;

    private ObjectInputStream objectInputStream;

    private DataOutputStream dataOutputStream;

    public ServerThread(Socket sc) {
        socket = sc;
        ticketManager = TicketManager.getTicketManager();
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        // Read from input
        Object object;
        try {
            object = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        TicketRequest ticketRequest = (TicketRequest) object;

        StringBuilder result = new StringBuilder();
        boolean isUsed = ticketManager.checkSeat(ticketRequest.getMovieName(), ticketRequest.getSeatName());
        int ticketCount = ticketManager.getTicketCount(ticketRequest.getMovieName());
        if (isUsed) {
            if (ticketRequest.isBuy()) {
                result.append("购票失败！当前座位已经被预订了");
            } else {
                ticketManager.refundTicket(ticketRequest.getMovieName(), ticketRequest.getSeatName());
                result.append("退票成功！《").append(ticketRequest.getMovieName()).append("》 座位为").append(ticketRequest.getSeatName()).append(" 已经售出").append(ticketManager.getTicketCount(ticketRequest.getMovieName())).append("票");
            }
        } else if (!ticketRequest.isBuy()) {
            result.append("退票失败，当前座位未预订");
        } else if (ticketCount < 200) {
            ticketManager.buyTicket(ticketRequest.getMovieName(), ticketRequest.getSeatName());
            result.append("购票成功！《").append(ticketRequest.getMovieName()).append("》 您的座位为").append(ticketRequest.getSeatName()).append(" 已经售出").append(ticketManager.getTicketCount(ticketRequest.getMovieName())).append("票");
        } else {
            result.append("购票失败！当前座位已经满了");
        }
        result.append("\n");

        /*
          发送结果给客户端
          */
        try {
            dataOutputStream.writeUTF(result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

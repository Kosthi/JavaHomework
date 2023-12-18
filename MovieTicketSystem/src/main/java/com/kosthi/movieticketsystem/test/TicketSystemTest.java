package com.kosthi.movieticketsystem.test;

import com.kosthi.movieticketsystem.entity.TicketCountRequest;
import com.kosthi.movieticketsystem.entity.TicketRequest;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class TicketSystemTest {

    public static void main(String[] args) {
        mixTest();
    }

    private static void buyAction(int clientId) throws Exception {
        // 模拟购票或退票
        boolean isBuy = true;
        // String movieName = Math.random() < 0.5 ? "哈利·波特" : "拯救嫌疑人"; // 模拟不同电影
        String movieName = "哈利·波特"; // 模拟不同电影
        String seatName = "座位 " + clientId; // 模拟不同座位

        // 连接到服务器
        Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
        TicketRequest ticketReq = new TicketRequest("窗口1", movieName, seatName, isBuy);

        // 发送购票或退票请求
        toServer.writeObject(ticketReq);
        socket.shutdownOutput();

        // 接收服务器响应
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String response = dis.readUTF();
        System.out.println("Client " + clientId + ": " + response);

        // 关闭连接
        dis.close();
        toServer.close();
        socket.close();
    }

    private static void refundAction(int clientId) throws Exception {
        // 模拟购票或退票
        boolean isBuy = false;
        // String movieName = Math.random() < 0.5 ? "哈利·波特" : "拯救嫌疑人"; // 模拟不同电影
        String movieName = "哈利·波特";

        String seatName = "座位 " + clientId; // 模拟不同座位

        // 连接到服务器
        Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
        TicketRequest ticketReq = new TicketRequest("窗口1", movieName, seatName, isBuy);

        // 发送购票或退票请求
        toServer.writeObject(ticketReq);
        socket.shutdownOutput();

        // 接收服务器响应
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String response = dis.readUTF();
        System.out.println("Client " + clientId + ": " + response);

        // 关闭连接
        dis.close();
        toServer.close();
        socket.close();
    }

    private static void mixAction(int clientId) throws Exception {
        // 模拟购票或退票
        boolean isBuy = Math.random() < 0.5;
        String movieName = Math.random() < 0.5 ? "哈利·波特" : "拯救嫌疑人"; // 模拟不同电影
        String seatName = "座位 " + clientId; // 模拟不同座位

        // 连接到服务器
        Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
        TicketRequest ticketReq = new TicketRequest("窗口1", movieName, seatName, isBuy);

        // 发送购票或退票请求
        toServer.writeObject(ticketReq);
        socket.shutdownOutput();

        // 接收服务器响应
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String response = dis.readUTF();
        System.out.println("Client " + clientId + ": " + response);

        // 关闭连接
        dis.close();
        toServer.close();
        socket.close();
    }

    public static void mixTest() {
        // 5个客户端同时购买
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    mixAction(finalI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    @Test
    public void buyTest() throws Exception {
        // 5个客户端同时购买
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int finalI = i + 1; // 确保线程有唯一的标识
            threads[i] = new Thread(() -> {
                try {
                    buyAction(finalI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        // 等待所有线程完成
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Thread.currentThread().interrupt(); // 重置中断状态
            }
        }

        // 线程都执行完毕后获取票数
        int count1 = getTicketCount("哈利·波特");
        int count2 = getTicketCount("拯救嫌疑人");
        assertEquals(5, count1 + count2);
    }

    @Test
    public void refundTest() throws Exception {
        // 5个客户端同时退票
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int finalI = i + 1; // 确保线程有唯一的标识
            threads[i] = new Thread(() -> {
                try {
                    refundAction(finalI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        // 等待所有线程完成
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Thread.currentThread().interrupt(); // 重置中断状态
            }
        }

        // 线程都执行完毕后获取票数
        int count1 = getTicketCount("哈利·波特");
        int count2 = getTicketCount("拯救嫌疑人");
        assertEquals(0, count1 + count2);
    }

    public int getTicketCount(String movieName) throws Exception {
        // 连接到服务器
        Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
        TicketCountRequest ticketCountRequest = new TicketCountRequest(movieName);

        // 发送购票或退票请求
        toServer.writeObject(ticketCountRequest);
        socket.shutdownOutput();

        // 接收服务器响应
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String response = dis.readUTF();

        // 关闭连接
        dis.close();
        toServer.close();
        socket.close();

        return Integer.valueOf(response.trim());
    }
}

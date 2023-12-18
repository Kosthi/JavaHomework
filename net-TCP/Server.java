package com.net3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Server is waiting for the client infomation: ");
        while (true) {
            //创建ServerSocket对象
            ServerSocket server = new ServerSocket(9000);
            //监听客户端请求   进行连接
            Socket client = server.accept();
            /**
             * 接收客户端发送来的信息
             * */
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            //需向下转型     读取完之后是父类Object类型的对象
            User user = (User) ois.readObject();
            System.out.println("IP地址为:" + client.getInetAddress().getHostAddress() + "请求登录");
            client.shutdownInput();

            //验证输入的登录信息和默认信息是否一样
            String result = null;
            if ("abc".equals(user.getName()) && "123".equals(user.getPassword())) {
                result = "登录成功";
            } else {
                result = "对不起，账户或密码不存在";
            }

            /**
             * 发送结果给客户端
             * */
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF(result);
            client.shutdownOutput();

            //关闭流
            dos.close();
            ois.close();
            client.close();
            server.close();
        }
    }
}

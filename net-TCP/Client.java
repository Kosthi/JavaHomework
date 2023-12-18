package com.net3;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        //创建Socket对象
        Socket client = new Socket("127.0.0.1", 9000);

        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        oos.writeObject(getUser());
        //oos.writeObject(new User("abc","123"));
        //oos.writeObject(new User("Tom","123"));
        //截断输出流
        client.shutdownOutput();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println(dis.readUTF());
        //截断输入流
        client.shutdownInput();
        //关闭流
        dis.close();
        oos.close();
        client.close();

    }

    //获取用户的对象
    public static User getUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.next();
        System.out.println("请输入密码:");
        String passWord = sc.next();

        //返回用户对象
        return new User(name, passWord);
    }
}

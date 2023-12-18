package cn.ex.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class StudentClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = sc.next();
        String host = "localhost";
        Socket socket;
        try {
            socket = new Socket(host, 8000);
            // Create an output stream to the server
            ObjectOutputStream toServer =
                    new ObjectOutputStream(socket.getOutputStream());
            Student s = new Student(name);
            toServer.writeObject(s);
            socket.close();
            System.out.println("A student object is sent.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

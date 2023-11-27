package com.koschei.eums.dao;

import com.koschei.eums.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public static ArrayList<User> readUsersFromFile() throws IOException {

        File file = new File("user.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating user.txt file.");
                throw e;
            }
        }

        ArrayList<User> userList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("user.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String password = parts[1].trim();
                    userList.add(new User(name, password));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileManager: user.txt not found.");
            throw e;
        }
        return userList;
    }

    public static void writeUserToFile(User user) throws IOException {
        try (FileWriter writer = new FileWriter("user.txt", true)) {
            // Append the user's information to the file
            writer.write(user.getName() + ", " + user.getPassword() + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("FileManager: Error writing user information to file.");
            throw e;
        }
    }

    public static String readMessageFromFile() throws IOException {
        File file = new File("message.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating user.txt file.");
                throw e;
            }
        }

        // Load the message content from "message.txt" when the interface is initialized
        try (BufferedReader reader = new BufferedReader(new FileReader("message.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            System.out.println("Error loading the message.");
            throw e;
        }
    }

    public static void writeMessageToFile(String messageContent) throws IOException {
        // Save the message content to "message.txt"
        try (FileWriter writer = new FileWriter("message.txt")) {
            writer.write(messageContent);
            System.out.println("Message saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving the message.");
            throw e;
        }
    }

    public static void flushUsersToFile(List<User> userList) throws IOException {
        try (FileWriter writer = new FileWriter("user.txt")) {
            for (User user : userList) {
                writer.write(user.getName() + ", " + user.getPassword() + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("FileManager: Error writing user information to file.");
            throw e;
        }
    }
}

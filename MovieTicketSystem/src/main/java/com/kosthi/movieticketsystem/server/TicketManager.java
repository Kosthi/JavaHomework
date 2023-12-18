package com.kosthi.movieticketsystem.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 单例类
public class TicketManager {
    private static TicketManager ticketManager = null;
    private static String ticketFilePath = "ticketFile.txt"; // 定义文件路径
    private static HashMap<String, HashSet<String>> ticketMap;

    private TicketManager() {
        ticketMap = new HashMap<>();
        readTicketFromFile(); // 初始化时从文件中读取数据
    }

    // 双重检查锁定 处理多线程单例
    public static TicketManager getTicketManager() {
        if (ticketManager == null) { // 第一次检查：不加锁
            synchronized (TicketManager.class) {
                if (ticketManager == null) { // 第二次检查：加锁后再检查
                    System.out.println("初始化单例");
                    ticketManager = new TicketManager();
                }
            }
        }
        return ticketManager;
    }

    // 从文件中读取电影票信息
    private void readTicketFromFile() {
        try {
            if (!Files.exists(Paths.get(ticketFilePath))) {
                Files.createFile(Paths.get(ticketFilePath)); // 如果文件不存在，则创建一个空文件
            }

            Stream<String> stream = Files.lines(Paths.get(ticketFilePath));
            stream.forEach((line) -> {
                String[] parts = line.split("[,\\[\\]\\s]+");
                if (parts.length > 1) {
                    String movieName = parts[0];
                    HashSet<String> seats = ticketMap.getOrDefault(movieName, new HashSet<>());
                    for (int i = 1; i < parts.length; i += 2) {
                        seats.add(parts[i] + " " + parts[i + 1]);
                        // System.out.println(parts[i]);
                    }
                    ticketMap.put(movieName, seats);
                    // System.out.println(ticketMap);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 将电影票信息写入文件
    private void writeTicketToFile() {
        try {
            String data = ticketMap.entrySet().stream()
                    .map(entry -> entry.getKey() + "," + entry.getValue())
                    .collect(Collectors.joining("\n"));
            Files.write(Paths.get(ticketFilePath), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 添加电影票信息
    public synchronized void buyTicket(String movieName, String seatName) {
        ticketMap.computeIfAbsent(movieName, k -> new HashSet<>()).add(seatName);
        writeTicketToFile(); // 更新后写入文件
    }

    // 删除电影票信息
    public synchronized void refundTicket(String movieName, String seatName) {
        ticketMap.computeIfAbsent(movieName, k -> new HashSet<>()).remove(seatName);
        writeTicketToFile(); // 更新后写入文件
    }

    // 查询电影票信息
    public synchronized int getTicketCount(String movieName) {
        return ticketMap.getOrDefault(movieName, new HashSet<>()).size();
    }

    public synchronized boolean checkSeat(String movieName, String seatName) {
        return ticketMap.getOrDefault(movieName, new HashSet<>()).contains(seatName);
    }

    // only for test
    public void clearStatus() {
        ticketMap.clear();
        writeTicketToFile();
    }
}

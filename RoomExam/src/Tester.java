import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Tester {
    public static void main(String[] args) {
        // (a) 输出类名字和静态变量的值
        System.out.println("Class Name: " + Room210405225.class.getName() + ' ' + Room210405225.getClassName());

        // (b) 创建HashMap管理Room对象
        HashMap<String, HashSet<Room210405225>> roomMap = new HashMap<>();

        // (c) 创建新集合管理已被预订的Room对象
        Set<Room210405225> bookedRooms = new HashSet<>();

        // (d) 输出 (b) 和 (c) 的两个集合信息
        System.out.println("Initial HashMap (Room Management): " + roomMap);
        System.out.println("Initial Set (Booked Rooms): " + bookedRooms);

        // 模拟预订房间
        Room210405225 room1 = new Room210405225("Single", "101", "2023-12-01", "2023-12-05");
        Room210405225 room2 = new Room210405225("Double", "201", "2023-12-02", "2023-12-06");
        Room210405225 room3 = new Room210405225("Double", "205", "2023-12-03", "2023-12-04");
        Room210405225 room4 = new Room210405225("Double", "205", "2023-12-03", "2023-12-04");

        // 将房间添加到HashMap中
        roomMap.computeIfAbsent(room1.getRoomType(), k -> new HashSet<>()).add(room1);
        roomMap.computeIfAbsent(room2.getRoomType(), k -> new HashSet<>()).add(room2);
        roomMap.get(room3.getRoomType()).add(room3);
        roomMap.computeIfAbsent(room4.getRoomType(), k -> new HashSet<>()).add(room4);

        // 输出更新后的信息
        System.out.println("Updated HashMap (Room Management): " + roomMap);

        // 检查是否已经被预订
        if (bookedRooms.contains(room2)) {
            System.out.println("Room " + room2.getRoomNumber() + " is already booked!");
        } else {
            // 添加到已预订集合中
            bookedRooms.add(room2);
            // 移除HashMap中的房间
            roomMap.get(room2.getRoomType()).remove(room2);
            System.out.println("Booking successful for Room " + room2.getRoomNumber());
        }

        // 输出最终信息
        System.out.println("Final HashMap (Room Management): " + roomMap);
        System.out.println("Final Set (Booked Rooms): " + bookedRooms);
    }
}

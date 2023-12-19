import java.util.Objects;

class Room210405225 {

    // 房间类型
    private String roomType;

    // 房间号
    private String roomNumber;

    // 预定日期
    private String reservationDate;

    // 入住日期
    private String checkInDate;

    private static String className = "计算机2102班";  // 请将"YourClass"替换为您的班级名称

    public Room210405225(String roomType, String roomNumber, String reservationDate, String checkInDate) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.reservationDate = reservationDate;
        this.checkInDate = checkInDate;
    }

    public static String getClassName() {
        return className;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room210405225 that = (Room210405225) o;
        return Objects.equals(roomType, that.roomType) && Objects.equals(roomNumber, that.roomNumber) && Objects.equals(reservationDate, that.reservationDate) && Objects.equals(checkInDate, that.checkInDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomType, roomNumber, reservationDate, checkInDate);
    }

    @Override
    public String toString() {
        return "Room210405225{" +
                "roomType='" + roomType + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                '}';
    }
}

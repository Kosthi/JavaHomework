public class Keyboard_210405317 {
    public static String name = "计算机2103班";

    private String id;

    private String brand;

    private int capacity;

    private double price;

    public Keyboard_210405317(String id, String brand, int capacity, double price) {
        this.id = id;
        this.brand = brand;
        this.capacity = capacity;
        this.price = price;
    }

    public static String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBrand() {
        return brand;
    }

    public String getId() {
        return id;
    }
}

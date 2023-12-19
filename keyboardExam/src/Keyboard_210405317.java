public class Keyboard_210405317 implements Comparable<Keyboard_210405317> {
    public static String name = "计算机2103班";

    private String id;

    private String brand;

    private int capacity;

    private double price;

    @Override
    public int compareTo(Keyboard_210405317 k2) {
        // Compare by brand
        int brandComparison = this.getBrand().compareTo(k2.getBrand());
        if (brandComparison != 0) {
            return brandComparison;
        }
        // If brand are the same, compare by capacity
        int idComparison = Integer.compare(this.getCapacity(), k2.getCapacity());
        if (idComparison != 0) {
            return idComparison;
        }
        // If capacity are the same, compare by price
        return Double.compare(this.getPrice(), k2.getPrice());
    }

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

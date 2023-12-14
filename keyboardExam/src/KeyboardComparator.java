import java.util.Comparator;

public class KeyboardComparator implements Comparator<Keyboard_210405317> {
    @Override
    public int compare(Keyboard_210405317 k1, Keyboard_210405317 k2) {
        // Compare by brand
        int brandComparison = k1.getBrand().compareTo(k2.getBrand());
        if (brandComparison != 0) {
            return brandComparison;
        }
        // If brand are the same, compare by capacity
        int idComparison = Integer.compare(k1.getCapacity(), k2.getCapacity());
        if (idComparison != 0) {
            return idComparison;
        }
        // If capacity are the same, compare by price
        return Double.compare(k1.getPrice(), k2.getPrice());
    }
}

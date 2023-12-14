import java.util.Comparator;

public class PeripheralComparator implements Comparator<Peripheral> {
    @Override
    public int compare(Peripheral p1, Peripheral p2) {
        // Compare by name
        int nameComparison = p1.getName().compareTo(p2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        // If names are the same, compare by produceDate
        return p1.getProduceDate().compareTo(p2.getProduceDate());
    }
}

import java.util.*;

public class PeriManaging {
    private final HashMap<String, List<Peripheral>> peripheralGroups = new HashMap<>();

    public boolean add(Peripheral o) {
        String peripheralName = o.getName();
        if (!peripheralGroups.containsKey(peripheralName)) {
            peripheralGroups.put(o.getName(), new ArrayList<>());
        }
        List<Peripheral> peripheralList = peripheralGroups.get(o.getName());
        if (!peripheralList.contains(o)) {
            peripheralList.add(o);
            return true;
        }
        return false;
    }

    public boolean add(List<Peripheral> peripheralList) {
        boolean isAdded = false;
        for (Peripheral peripheral : peripheralList) {
            if (add(peripheral)) {
                isAdded = true;
            }
        }
        return isAdded;
    }

    public boolean remove(Peripheral peripheral) {
        String peripheralName = peripheral.getName();
        if (peripheralGroups.containsKey(peripheralName)) {
            List<Peripheral> peripheralList = peripheralGroups.get(peripheral.getName());
            if (peripheralList.remove(peripheral)) {
                if (peripheralList.isEmpty()) {
                    peripheralGroups.remove(peripheralName);
                }
                return true;
            }
        }
        return false;
    }

    public void listAll() {
        List<String> sortedKeys = new ArrayList<>(peripheralGroups.keySet());
        Collections.sort(sortedKeys);
        for (String key : sortedKeys) {
            List<Peripheral> peripherals = peripheralGroups.get(key);
            peripherals.sort(new PeripheralComparator());
            System.out.println("Peripherals for " + key + ":");
            for (Peripheral peripheral : peripherals) {
                System.out.println(peripheral);
            }
        }
    }

    public boolean find(Peripheral peripheral) {
        String name = peripheral.getName();
        if (peripheralGroups.containsKey(name)) {
            List<Peripheral> peripheralList = peripheralGroups.get(name);
            return peripheralList.contains(peripheral);
        }
        return false;
    }
}

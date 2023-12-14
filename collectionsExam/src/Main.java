import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // My name and id
        System.out.println("吴奕民 " + "210405317");

        addByObjectTest();

        addByObjectListTest();

        findByObjectTest();

        sortTest();
    }

    public static void addByObjectTest() {
        System.out.println('\n' + "*** Add Object Test ***");
        // Create some Peripheral objects
        Peripheral peripheral1 = new Peripheral("Computer", "A12345", new Date());
        Peripheral peripheral2 = new Peripheral("Scanner", "B20201", new Date());
        Peripheral peripheral3 = new Peripheral("Printer", "CQ1210", new Date());

        // Create a PeriManaging object
        PeriManaging periManaging = new PeriManaging();

        periManaging.add(peripheral1);
        periManaging.add(peripheral2);
        periManaging.add(peripheral3);

        // List all peripherals
        periManaging.listAll();

        System.out.println("*** Add Object Test ***");
    }

    public static void addByObjectListTest() {
        System.out.println('\n' + "*** Add ObjectList Test ***");

        // Create some Peripheral objects
        Peripheral peripheral1 = new Peripheral("Computer", "A12345", new Date());
        Peripheral peripheral2 = new Peripheral("Scanner", "B20201", new Date());
        Peripheral peripheral3 = new Peripheral("Printer", "CQ1210", new Date());

        List<Peripheral> peripheralList = new ArrayList<Peripheral>();
        peripheralList.add(peripheral1);
        peripheralList.add(peripheral2);
        peripheralList.add(peripheral3);

        // Create a PeriManaging object
        PeriManaging periManaging = new PeriManaging();

        periManaging.add(peripheral1);
        periManaging.add(peripheral2);
        periManaging.add(peripheral3);

        // List all peripherals
        periManaging.listAll();

        System.out.println("*** Add ObjectList Test ***");
    }

    public static void findByObjectTest() {
        System.out.println('\n' + "*** find Object Test ***");

        // Create some Peripheral objects
        Peripheral peripheral1 = new Peripheral("Computer", "A12345", new Date());
        Peripheral peripheral2 = new Peripheral("Scanner", "B20201", new Date());
        Peripheral peripheral3 = new Peripheral("Printer", "CQ1210", new Date());

        PeriManaging periManaging = new PeriManaging();

        periManaging.add(peripheral1);
        periManaging.add(peripheral2);
        periManaging.add(peripheral3);

        // Test the find method
        System.out.println("Finding peripheral2: " + periManaging.find(peripheral2));
        System.out.println("Finding peripheral4: " + periManaging.find(new Peripheral("Mouse", "11111", new Date())));

        System.out.println("*** find Object Test ***");
    }

    public static void sortTest() {
        System.out.println('\n' + "*** sort Object Test ***");

        // Create some Peripheral objects
        Peripheral peripheral1 = new Peripheral("Computer", "A12345", new Date(90000));
        Peripheral peripheral2 = new Peripheral("Computer", "B20201", new Date(1212));
        Peripheral peripheral3 = new Peripheral("Printer", "CQ1210", new Date(931121));
        Peripheral peripheral4 = new Peripheral("Printer", "CZX210", new Date(233));

        PeriManaging periManaging = new PeriManaging();

        periManaging.add(peripheral1);
        periManaging.add(peripheral2);
        periManaging.add(peripheral3);
        periManaging.add(peripheral4);

        periManaging.listAll();

        System.out.println("*** sort Object Test ***");
    }
}

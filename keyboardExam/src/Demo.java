import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Demo {

    // key: brand value: keyboard obj list
    private static final HashMap<String, List<Keyboard_210405317>> brandMap = new HashMap<>();

    private static final List<Keyboard_210405317> keyboardList = new ArrayList<>();

    public static void Test() {
        System.out.println("Class name: " + Keyboard_210405317.class.getName() + " 静态成员 name: " + Keyboard_210405317.name);

        keyboardList.add(new Keyboard_210405317("A1", "Google", 128, 59.99));
        keyboardList.add(new Keyboard_210405317("B2", "Apple", 256, 79.99));
        keyboardList.add(new Keyboard_210405317("C1", "Samsung", 512, 99.99));
        keyboardList.add(new Keyboard_210405317("C2", "Samsung", 128, 89.99));
        keyboardList.add(new Keyboard_210405317("C3", "Samsung", 512, 98.99));
        keyboardList.add(new Keyboard_210405317("C4", "Samsung", 512, 20.99));
        keyboardList.add(new Keyboard_210405317("B1", "Apple", 256, 9.99));

        // add to brandMap
        for (Keyboard_210405317 keyboard : keyboardList) {
            String brand = keyboard.getBrand();
            if (!brandMap.containsKey(brand)) {
                brandMap.put(brand, new ArrayList<>());
            }
            brandMap.get(brand).add(keyboard);
        }

        System.out.println("\n按 brand 字典序分类, 相同按 capacity 升序，再相同按 price 升序");
        // 先按 key 字典序 sort
        List<String> sortedBrands = new ArrayList<>(brandMap.keySet());
        Collections.sort(sortedBrands);

        for (String brand : sortedBrands) {
            System.out.println("Brand: " + brand);
            List<Keyboard_210405317> keyboardsByBrand = brandMap.get(brand);
            // 使用自定义排序类
            keyboardsByBrand.sort(new KeyboardComparator());
            for (Keyboard_210405317 keyboard : keyboardsByBrand) {
                System.out.println("ID: " + keyboard.getId() + " Capacity: " + keyboard.getCapacity() + " Price: " + keyboard.getPrice());
            }
        }
    }
}

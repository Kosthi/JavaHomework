// 懒汉式单例类，在类初始时，已自行实例化
public class MyPrinter {
    private MyPrinter() {}

    private static MyPrinter myPrinter = null;
    private static String myPrinterName;

    public static MyPrinter getMyPrinter() {
        if (myPrinter == null) {
            myPrinter = new MyPrinter();
            myPrinterName = "My type is Canno-IP110.";
            System.out.println(myPrinterName);
        } else {
            System.out.println("I'm the only one.");
        }
        return myPrinter;
    }

    public static void print(Object obj) {
        System.out.println("****** " + myPrinterName + " ******");
        System.out.println(obj.toString());
    }

    @Override
    public String toString() {
        return myPrinterName;
    }
}

import java.util.Date;
import geo.*;

public class Main {
    public static void main(String[] args) {
        MyPrinter p1 = MyPrinter.getMyPrinter();
        MyPrinter p2 = MyPrinter.getMyPrinter();
        MyPrinter p3 = MyPrinter.getMyPrinter();

        p1.print(p3);
        p2.print(new Rectangle(2, 5));
        p3.print(new Circle(3, "yellow"));
        p1.print(new MyLogger(new Date(), "Hello Koschei"));
    }
}

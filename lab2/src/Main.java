import geo.Circle;
import geo.Rectangle;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        MyPrinter p1 = MyPrinter.getMyPrinter();
        MyPrinter p2 = MyPrinter.getMyPrinter();
        MyPrinter p3 = MyPrinter.getMyPrinter();

        p1.print(p3);
        p2.print(new Rectangle(2, 5));
        p3.print(new Circle(3, "yellow"));
        p1.print(new MyLogger(new Date(), "Hello Koschei."));

        MyLogger myLogger = new MyLogger();
        MyLogger myLoggerCloned = myLogger.clone();
        p1.print(myLogger);
        p1.print(myLoggerCloned);

        // String为引用对象，浅拷贝中为true，深拷贝中为false
        System.out.println(myLogger.getMsg() == myLoggerCloned.getMsg());
        System.out.println(myLogger.getMsg().equals(myLoggerCloned.getMsg()));
    }
}

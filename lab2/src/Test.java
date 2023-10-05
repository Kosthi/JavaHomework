import java.util.Date;
import geo.*;

public class Test {
    // Tester for MyLogger
    public static class TesterMyLogger {
        public static void main(String[] args) {
            MyLogger[] myLoggers = new MyLogger[3];
            myLoggers[0] = new MyLogger(new Date(), "Hello World From myLogger0!");
            myLoggers[1] = new MyLogger(new Date(132100), "Hello World From myLogger1!");
            myLoggers[2] = new MyLogger(new Date(8121200), "Hello World From myLogger2!");

            for (MyLogger mylogger : myLoggers) {
                testLogger(mylogger);
            }
        }

        public static void testLogger(MyLogger myLogger) {
            System.out.println("*****输出日志时间*****");
            System.out.println(myLogger.getLogTime());
            System.out.println("*****输出日志信息*****");
            System.out.println(myLogger.getMsg() + '\n');
        }
    }

    // Tester for Geo
    public static class TesterGeo {
        public static void main(String[] args) {
            //Circle o1= new Circle();
            Geo o1 = new Circle();//向上转型
            TesterGeo.computeArea(o1);    //System.out.println(o1);//o1.toString()，方法的动态绑定
            ((Circle) o1).setRadius(5);//向下转型
            TesterGeo.computeArea(o1);    //System.out.println(o1);
            o1 = new Rectangle(2, 5);//向上转型
            TesterGeo.computeArea(o1);    //System.out.println(o1);
            TesterGeo.computeArea(new Circle(1));
            TesterGeo.computeArea(new Rectangle(1, 2));
        }

        public static void computeArea(Geo o) {
            System.out.println(o);
        }
    }
}

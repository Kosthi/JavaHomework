package Testpack;

public class Sample {
    public static int cal(int a, int b, int x) {
        if (a > 1 && b == 0) {
            x = x / a;
        }
        if (a == 2 || x > 1) {
            return x + 1;
        }
        return x;
    }

    public static int loopCal(int i, int a) {
        while (i <= 10) {
            a += 2;
            if (a > 4) {
                a *= 2;
                a += 3;
            } else {
                if (a > 1) {
                    a -= 4;
                } else {
                    a += 5;
                }
            }
            ++i;
        }
        return 4 * a;
    }

    public static int simplyCal(int a) {
        if (a > 10 && a < 100) {
            return a * 20 - 5;
        } else if (a > 0 && a <= 10) {
            return a * 15 + 20;
        } else if (a >= 100) {
            return a * 100 - 200;
        }
        throw new RuntimeException();
    }
}

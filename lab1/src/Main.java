import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 猜数游戏
        GuessNumber gn = new GuessNumber();
        gn.Guess();

        // 验证码生成程序
        CaptchaCreator cc = new CaptchaCreator();
        cc.Test();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CaptchaCreator cc = new CaptchaCreator();
        cc.Test();

        int ans = (int)(Math.random() * 11 + 1);

        int num;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3;) {
            try {
                System.out.println("请输入1-10的数字");
                num = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("输入错误");
                // 用户输入错误，提醒用户重新输入或者直接结束程序
                // 清空缓冲区
                scanner.nextLine();
                continue;
                // return;
            }
            if (num < 0 || num > 10) continue;
            if (num == 0) {
                System.out.println("Bye-bye");
                return;
            }
            if (num > ans) {
                System.out.println("Too big");
            } else if (num < ans) {
                System.out.println("Too small");
            } else {
                System.out.println("Bingo");
                return;
            }
            ++i;
        }
        System.out.println("Gameover");
    }
}

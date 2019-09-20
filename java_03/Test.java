import java.util.Random;
import java.util.Scanner;

public class Test {
    // 编写程序数一下 1到 100 的所有整数中出现多少个数字9。
    public static int findNine() {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 10 == 9) {
                sum += 1;
            }
            if (i / 10 == 9) {
                sum += 1;
            }
            if (i / 10 == 9 && i % 10 == 9) {
                sum -= 1;
            }
        }
        return sum;
    }

    // 求出0～999之间的所有“水仙花数”并输出。
    public static void narcNum(int n) {
        int flag = 1;
        int count = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == flag * 10) {
                flag *= 10;
                count++;
            }
            for (int j = i; j > 0; j /= 10) {
                sum += (int) Math.pow(j % 10, count);
            }
            if (i == sum) {
                System.out.print(i + " ");
            }
            sum = 0;
        }

    }
    // 编写代码模拟三次密码输入的场景。 
    // 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 
    // 可以重新输入，最多输入三次。三次均错，则提示退出程序 
    public static void pass(){
        
    }
    // 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
    public static int num(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += (n >> i) & 1;
        }
        return sum;
    }

    // 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列。
    public static void fun(int n) {
        int a;
        System.out.println("偶数位为：");
        for (int i = 30; i >= 0; i -= 2) {
            a = (n >> i) & 1;
            System.out.print(a);
        }
        System.out.println();
        System.out.println("奇数位为：");
        for (int i = 31; i > 0; i -= 2) {
            a = (n >> i) & 1;
            System.out.print(a);
        }

    }

    // 输出一个整数的每一位.
    public static void everyNum(int n) {
        if (n > 9) {
            everyNum(n / 10);
        }
        System.out.print(" " + n % 10);

    }

    // 完成猜数字游戏
    public static void guessNum() {
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        int toGuess = r.nextInt(100);
        System.out.println(toGuess);
        while (true) {
            System.out.println("输入一个人1-100的数");
            int num = s.nextInt();
            if (num > toGuess) {
                System.out.println("猜大了");
            } else if (num < toGuess) {
                System.out.println("猜小了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
        s.close();
    }

    public static void main(String[] args) {
        // int ret = findNine();
        // System.out.println(ret);
        // narcNum(999);
        // int ret = num(15);
        // System.out.println(ret);
        // fun(15);
        // everyNum(1234);
        // guessNum();
    }
}
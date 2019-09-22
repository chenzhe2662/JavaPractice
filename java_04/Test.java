public class Test {
    // 实现代码: 递归求 N 的阶乘
    public static int mul(int n) {
        if (n == 1) {
            return 1;
        }
        return n * mul(n - 1);
    }

    // 实现代码: 递归求 1 + 2 + 3 + ... + 10
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    // 实现代码: 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
    public static void print(int n) {
        if (n > 9) {
            print(n / 10);
        }
        System.out.print(" " + n % 10);
    }

    // 实现代码: 写一个递归方法，输入一个非负整数，返回组成它的数字之和.
    public static int printSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + printSum(n / 10);
    }

    public static void main(String[] args) {
        // int ret = mul(5);
        // System.out.println(ret);
        // int ret = sum(100);
        // System.out.println(ret);
        // print(1234);
        int ret = printSum(1279);
        System.out.println(ret);
    }
}
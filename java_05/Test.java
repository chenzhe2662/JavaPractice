public class Test {
    // 实现代码: 求斐波那契数列的第 N 项
    public static int fabonaqi(int n) {
        if (n == 1 | n == 2) {
            return 1;
        }
        return fabonaqi(n - 1) + fabonaqi(n - 2);
    }

    // 实现代码: 求解汉诺塔问题(提示, 使用递归)
    public static void hanota(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println(A + "->" + C);
        } else {
            hanota(n - 1, A, C, B);
            System.out.println(A + "->" + C);
            hanota(n - 1, B, A, C);
        }
    }

    // 实现代码: 青蛙跳台阶问题(提示, 使用递归)
    public static int jump(int n) {
        if (n <= 0) {
            return 0;
        } else if (n < 3) {
            return n;
        } else {
            return jump(n - 1) + jump(n - 2);
        }
    }

    public static void main(String[] args) {
        // int ret = fabonaqi(7);
        // System.out.println(ret);
        // hanota(10, 'A', 'B', 'C');
        int ret = jump(4);
        System.out.println(ret);
    }
}
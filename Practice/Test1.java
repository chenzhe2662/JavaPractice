public class Test1 {
    // 打印100~200 之间的素数
    public void Prime() {
        for (int i = 100; i < 200; i++) {
            int count = 0;
            for (int j = 1; j < 100; j++) {
                if (i % j == 0) {
                    count++;
                }
                if (count > 2) {
                    break;
                }
            }
            if (count <= 2) {
                System.out.println(i);
            }
        }
    }

    // 输出乘法口诀表
    public void print(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "  ");
            }
            System.out.println();
        }
    }

    // 判断1000年---2000年之间的闰年
    public void Year(int n) {
        if ((n % 100 != 0 && n % 4 == 0) || (n % 400 == 0)) {
            System.out.println("是闰年！");
        } else {
            System.out.println("不是闰年！");
        }
    }

    public static void main(String[] args) {
        // Test1 s = new Test1();
        // s.Year(1504);
        // s.print(9);
        // s.Prime();
    }
}
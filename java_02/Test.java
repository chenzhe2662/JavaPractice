public class Test {
    /**
     * 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
     */
    public void Age(int n) {
        if (n <= 18) {
            System.out.println("是少年");
        } else if (n > 18 && n <= 28) {
            System.out.println("是青年");
        } else if (n > 28 && n <= 55) {
            System.out.println("是中年");
        } else {
            System.out.println("是老年");
        }
    }

    /**
     * 
     * 判定一个数字是否是素数
     */
    public void Prinme(int p) {
        int num = 1;
        int count = 0;
        while (num < p / 2) {
            if (p % num == 0) {
                count++;
                if (count == 2) {
                    break;
                }
            }
            num++;
        }
        if (count == 2) {
            System.out.println("不是素数");
        }
        if (count < 2) {
            System.out.println("是素数");
        }
    }

    /**
     * 
     * 打印 1 - 100 之间所有的素数
     */
    public void primePrint(int n) {
        for (int i = 2; i < n; i++) {
            int count = 0;
            for (int j = 1; j < n / 2; j++) {
                if (i % j == 0) {
                    count++;
                }
                if (count > 2) {
                    break;
                }
            }
            if (count <= 2) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 
     * 输出 1000 - 2000 之间所有的闰年
     */
    public void yearPrint() {

        for (int i = 1000; i <= 2000; i++) {
            if (i % 100 == 0) {
                if (i % 400 == 0) {
                    System.out.print(i + " ");
                }
            } else {
                if (i % 4 == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    /**
     * 
     * 输出乘法口诀表
     */
    public void mulPrint(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 
     * 求两个正整数的最大公约数
     */
    public void Num(int m, int n) {
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        while (m % n != 0) {
            n = m % n;
        }
        System.out.println(n);
    }

    /**
     * 
     * 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
     */
    public double Sum(int n) {
        int flag = 1;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += flag * (1.0 / i);
            flag = -flag;
        }
        return sum;
    }

    public static void main(String[] args) {
        Test s = new Test();
        double ret = s.Sum(100);
        System.out.println(ret);
        // s.Num(14, 21);
        // s.mulPrint(9);
        // s.yearPrint();
        // s.primePrint(100);
        // s.Prinme(100);
        // s.Age(100);
    }
}
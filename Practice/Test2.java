public class Test2 {
    // 给定两个整形变量的值，将两个值的内容进行交换.
    public void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println(a + "," + b);
    }

    // 求10 个整数中最大值。
    public int Max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    // 冒泡排序
    public void Bubble(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] > a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }
//求两个数的最大公约数。 
public int Num(int m,int n){
    if(m<n){
       int tmp=m;
       m=n;
       n=tmp;
    }
    if(m%n==0){
        return n;
    }
    return Num(m, m%n);
}
    public static void main(String[] args) {
        //int[] b = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 0 };
        // Test2 s = new Test2();
        // int ret=s.Num(14, 21);
        // System.out.println("ret="+ret);
        // s.Bubble(b);
        // for (int i : b) {
        //     System.out.print(i + " ");
        // }
        // s.swap(10, 20);
        // int ret= s.Max(a);
        // System.out.println(ret);
    }
}
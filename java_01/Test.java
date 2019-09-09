public class Test {
    public void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println(a + "," + b);
    }

    public void Max(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1] < a[j]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
        System.out.println("max=" + a[0]);
        System.out.println("min=" + a[a.length - 1]);

    }

    public static void main(String[] args) {
        int a[] = { 10, 5, 20 };
        Test s = new Test();
        //s.Max(a);
        s.swap(10, 20);

    }
}
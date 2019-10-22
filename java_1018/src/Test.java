public class Test {
    //数组中最大值
    public static int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(max < a[i]){
                max = a[i];
            }
        }
        return max;
    }
    public static int min(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if(min > a[i]){
                min = a[i];
            }
        }
        return min;
    }
    public  static  double avg(int[] a ){
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum/a.length;
    }

    public static void bubbleSort(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;//优化代码
            for (int j = 0; j < a.length - 1 - i; j++) {
                count ++;
                if (a[j] > a[j + 1]) {
                    int tem = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tem;
                    flag = false;
                }
            }
            //flag 没有改变说明不存在交换，
            // 说明后面已经有序 没必要继续排序。
            if (flag) {
                break;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int[] a = {1,3,4,9,5,7,2};
        //int ret = max(a);
        double ret = avg(a);
        System.out.println(ret);
    }
}

import java.util.Arrays;

public class Test {
    //冒泡排序
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
            //flag 没有改变说明不存在交换，说明后面已经有序 没必要继续排序。
            if (flag) {
                break;
            }
        }
        System.out.println(count);
    }

    //选择排序
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            int tem = a[index];
            a[index] = a[i];
            a[i] = tem;
        }
    }

    //插入排序
    public static void InsertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int n = a[i];
            int index = i - 1;
            while (index >= 0 && n < a[index]) {
                a[index + 1] = a[index];
                index--;
            }
            a[index + 1] = n;
        }
    }


    public static void main(String[] args) {
        int[] a = {3, 5, 1, 9, 4 ,6 ,7,8};
        bubbleSort(a);
        //selectSort(a);
        //InsertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}

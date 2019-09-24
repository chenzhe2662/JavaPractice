import java.util.Arrays;

public class Test {
    public static void printArray(int[] a) {
        for (int x : a) {
            System.out.println(x);
        }
    }

    public static void func(int x) {
        x = 10;
        System.out.println("x=" + x);
    }

    public static void func1(int[] a) {
        a[0] = 10;
        System.out.println("a[0]=" + a[0]);
    }

    public static void transform(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * 2;
        }
    }

    public static int[] transform1(int[] a) {
        int[] ret = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i] * 2;
        }
        return ret;
    }

    public static String toString(int[] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if (i != arr.length - 1) {
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }

    public static int[] copyof(int[] a) {
        int[] ret = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[i];
        }
        return ret;
    }

    public static int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static double avg(int[] a) {
        int sum = 0;
        for (int x : a) {
            sum += x;
        }
        return (double) sum / (double) a.length;
    }

    public static int find(int[] a, int tofind) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == tofind) {
                return i;
            }
        }
        return -1;
    }

    static int count = 0;

    public static int[] makeBigArray() {
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int binarySearch(int[] a, int tofind) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            count++;
            int mid = (low + high) / 2;
            if (tofind < a[mid]) {
                high = mid - 1;
            } else if (tofind > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    int tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void reverse(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            left++;
            right--;
        }
    }

    public static void transform2(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            while (left < right && a[left] % 2 == 0) {
                left++;
            }
            while (left < right && a[right] % 2 == 1) {
                right--;
            }
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3 };
        // System.out.println("length:" + arr.length);
        // System.out.println(arr[1]);
        // System.out.println(arr[0]);
        // arr[2] = 100;
        // System.out.println(arr[2]);
        // 数组遍历
        // for(int i =0 ;i<arr.length;i++){
        // System.out.println(arr[i]);
        // }
        // for(int x:arr){
        // System.out.println(x);
        // }
        // 打印数组的内容
        // printArray(arr);
        // 参数传内置类型
        // int num = 0;
        // func(num);
        // System.out.println("num=" + num);
        // 参数传数组类型
        // func1(arr);
        // System.out.println("arr[0]="+arr[0]);

        // transform(arr);
        // printArray(arr);

        // int[] output = transform1(arr);
        // printArray(output);
        // 数组转字符串
        // int[] arr = { 1, 2, 3, 4, 5, 6 };
        // String newArr=Arrays.toString(arr);
        // System.out.println(newArr);

        // System.out.println(toString(arr));

        // 数组拷贝
        // int[] newArr = Arrays.copyOf(arr, arr.length);
        // System.out.println("newArr: " + Arrays.toString(newArr));
        // arr[0] = 10;
        // System.out.println("arr: " + Arrays.toString(newArr));
        // System.out.println("newArr: " + Arrays.toString(newArr));

        // 找数组元素中最大的元素
        // System.out.println(max(arr));

        // 求数组元素中的平均值
        // System.out.println(avg(arr));

        // 顺序查找
        // int[] arr={1,2,3,10,5,6};
        // System.out.println(find(arr,10));

        // 二分查找
        // int[] arr={1,2,3,4,5,6};
        // System.out.println(binarySearch(arr,6));

        // 二分查找速率
        // int[] arr = makeBigArray();
        // int ret = binarySearch(arr, 9999);
        // System.out.println("ret= " + ret + " count=" + count);

        // 检查数组有序性
        // int[] arr = { 1, 2, 3, 10, 5, 6 };
        // System.out.println(isSorted(arr));

        // 冒泡排序
        // int[] arr = { 9,5,2,7};
        // bubbleSort(arr);
        // System.out.println(Arrays.toString(arr));

        // java内置方法Arrays.sort
        // int[] arr = { 9,5,2,7};
        // Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));

        // 数组逆序
        // int[] arr = { 1,2,3,4};
        // reverse(arr);
        // System.out.println(Arrays.toString(arr));

        // 数组数字排列
        // int[] arr = { 1, 2, 3, 4, 5, 6 };
        // transform2(arr);
        // System.out.println(Arrays.toString(arr));

        //二维数组
        int[][] arr={
            {1,2,3},
            {4,5,6},
            {7,8,9,10}
        };
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
                System.out.printf("%d\t",arr[row][col]);
            }
            System.out.println();
        }
    }

}
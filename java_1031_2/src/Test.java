import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        int [][] arr = {
//                {1,2,8,9},
//                {2,4,9,12},
//                {4,7,10,13},
//                {6,8,11,15}
//        };
//        int[] a = findVal(arr,4,4,10);
//        System.out.println(Arrays.toString(a));
        int ret = function(5);
        System.out.println(ret);
    }

    public static int[] findVal(int[][] arr, int row, int col, int num) {
        int[] a = new int[2];
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (num > arr[i][j]) {
                i++;
            } else if (num < arr[i][j]) {
                j--;
            } else {
                a[0] = i;
                a[1] = j;
                return a;
            }
        }
        return null;
    }

    public static int function(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }
        int count = 0;
        while (n > 1) {
            for (int i = 0; i < a.length ; i++) {
                if (a[i] == 1) {
                    count++;
                    if (count == 3) {
                        a[i] =  0;
                        count = 0;
                        n--;
                    }
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                return i;
            }
        }
        return -1;
    }

}

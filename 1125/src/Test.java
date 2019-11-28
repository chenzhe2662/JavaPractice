import java.util.Arrays;

public class Test {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int index = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > index ) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = index;
        }
    }
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            insertSortGap(array,gap);
            gap /= 2;
        }
        insertSortGap(array,1);
    }
    private static void insertSortGap(int[] array, int gap) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            while (j >= 0 && array[j] > tmp) {
                array[j + gap] = array[j];
                j -= gap;
            }
            array[j + gap] = tmp;
        }

    }
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 2, 6, 8, 1};
        //insertSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

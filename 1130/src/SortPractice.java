import java.util.Arrays;

public class SortPractice {
    private static void swap(int[] array , int x ,int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while ( j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    swap(array,j,j + 1);
                }
            }
        }
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j =  i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    swap(array,i,j);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {9,5,2,7,8,6,3,1};
        //insertSort(array);
        //bubbleSort(array);
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}

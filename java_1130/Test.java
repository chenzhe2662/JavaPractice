package java_1130;

public class Test {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tmp ) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if ( array[j] > array[j + 1] ) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = false;
                }
                if (flag) {
                    break;
                }
            }
        }
    }
}

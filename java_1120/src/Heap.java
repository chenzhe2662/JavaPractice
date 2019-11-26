import java.util.Arrays;

public class Heap {
    //向下调整
    public static void shiftDown(int[] array,int size,int index) {
        int parent = index;
        int child = 2*parent + 1;
//        while (child < size) {
//            if (child + 1 < size &&
//                    array[child + 1] > array[child]) {
//                child = child + 1;
//            }
//
//            if (array[child] <= array[parent]) {
//                break;
//            }
//            int tmp = array[parent];
//            array[parent] = array[child];
//            array[child] = tmp;
//
//            parent = child;
//            child = 2*parent + 1;
//        }
    }
    public static void createHeap (int[] array , int size) {

        for (int i = (size - 1) / 2; i >= 0; i--) {
            shiftDown(array,size,i);
        }
    }
    public static void main(String[] args) {
        int[] array = {1,5,3,8,7,6};
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}

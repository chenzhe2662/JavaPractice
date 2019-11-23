
import java.util.Arrays;

public class Heap {
    public static void shiftDown(int[] array,int size,int index) {
        int parent = index;
        int child = 2*parent + 1;
//        while (child < size) {
//            if (child + 1 < size &&
//                    array[child + 1] > array[child]) {
//                child += 1;
//            }
//            if (array[child] > array[parent]) {
//                swap(array,child,parent);
//            }else {
//                break;
//            }
//            parent = child;
//            child = 2*parent + 1;
//        }
    }
    private static void swap (int[] array,int x,int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
    public static void createHeap (int[] array , int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            shiftDown(array,size,i);
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}

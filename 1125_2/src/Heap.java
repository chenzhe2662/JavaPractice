import java.util.Arrays;

public class Heap {
    int[] elem = new int[100];
    int usedSize;
    private static void adjustDown(int[] array, int root) {
        int parent = root;
        int child = 2*parent + 1;
        while (child < array.length ) {
            if (child + 1 < array.length &&
                        array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    private static void createHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0 ; i--) {
            adjustDown(array,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        createHeap(array);
        System.out.println(Arrays.toString(array));
    }
    public void adjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if (elem[child] > elem[parent] ) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }


    public void pushHeap(int val) {
        this.elem[this.usedSize] = val;
        this.usedSize++;//11

        adjustUp(usedSize-1);

    }
    public Integer popHeap() {
        if (usedSize == 0) {
            return null;
        }
        int ret = elem[0];
        elem[0] = elem[usedSize - 1];
        usedSize--;
        adjustDown(elem,0);
        return ret;
    }

}

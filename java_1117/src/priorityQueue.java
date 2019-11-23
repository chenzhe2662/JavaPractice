
public class priorityQueue {
    private int[] array = new int[100];
    private int size = 0;
    public void offer(int x) {
        if (size >= array.length) {
			return;
        }
        array[size] = x;
        size++;
        shiftUp(array,size - 1);
    }
    public void shiftUp(int[] array,int index) {
        int child = index;
        int parent = (index - 1) / 2;
        while (child > 0) {
            if (array[parent] < array[child]) {
                swap(array,parent,child);
            }else{
                break;
            }
            child = parent;
            parent = (index - 1) / 2;
        }
    }
    private static void swap (int[] array,int x,int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array,size,0);
        return ret;
    }
    public static void shiftDown(int[] array,int size,int index) {
        int parent = index;
        int child = 2*parent + 1;
        while (child < size) {
            if (child + 1 < size &&
                    array[child + 1] > array[child]) {
                child += 1;
            }
            if (array[child] > array[parent]) {
                swap(array,parent,child);
            }else {
                break;
            }
            parent = child;
            child = 2*parent + 1;
        }
    }
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[0];
    }
}

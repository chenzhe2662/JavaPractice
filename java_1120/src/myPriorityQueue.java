public class myPriorityQueue {
    private int[] array = new int[100];
    private int size = 0;
    public void offer(int val) {
        array[size++] = val;
        shiftUp(array,size);
    }
    private void shiftUp(int[] arr, int index) {
        int child = index - 1;
        while (child > 0) {
            int parent = child / 2;
            if (arr[child] <= arr[parent]) {
                break;
            }
            int tmp = arr[child];
            arr[child] = arr[parent];
            arr[parent] = tmp;

            child = parent;
        }
    }
    public int poll() {
        int oldVal = array[0];
        array[0] = array[--size];
        shiftDown(array,size,0);
        return oldVal;
    }
    private void shiftDown(int[] array, int size, int index) {
        int child = 2*index + 1;
        int parent = index;
        while (child < size) {
            if (child + 1 < size &&
                            array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] <= array[parent]) {
                break;
            }
            int tmp = array[child];
            array[child] = array[parent];
            array[parent] = tmp;

            parent = child;
            child = 2*parent + 1;
        }
    }
    public int peek() {
        return array[0];
    }


    public static void main(String[] args) {
        myPriorityQueue queue = new myPriorityQueue();
        queue.offer(8);
        queue.offer(6);
        queue.offer(7);
        queue.offer(5);
        queue.offer(1);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}

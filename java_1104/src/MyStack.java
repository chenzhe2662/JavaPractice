public class MyStack {
    private  int[] array = new int[100];
    private int size = 0;

    public void push(int val) {
        array[size] = val;
        size++;
    }
    public Integer pop() {
        if (size == 0) {
            return null;
        }
        int ret = array[size - 1];
        size --;
        return  ret;
    }
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[size - 1];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

}

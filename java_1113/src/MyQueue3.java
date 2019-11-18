public class MyQueue3 {
    private int[] data = new int[100];
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    public boolean offer(int val) {
        if (size == data.length) {
            return false;
        }
        data[tail] = val;
        tail++;
        if (tail == data.length) {
            tail = 0;
        }
        size++;
        return true;
    }
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer ret = data[head];
        head++;
        if ( head == data.length) {
            head = 0;
        }
        size--;
        return ret;
    }
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }
    public  boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyQueue3 myQueue = new MyQueue3();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        myQueue.poll();
        System.out.println(myQueue.peek());
    }
}

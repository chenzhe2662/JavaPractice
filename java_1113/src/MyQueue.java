import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private List<Integer> list = new ArrayList<>();
    private void offer(int val) {
        list.add(val);
    }
    private void poll() {
        if (list.isEmpty()) {
            return;
        }
       list.remove(0);
    }
    private Integer peek() {
        if (list.isEmpty()) {
            return  null;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        myQueue.poll();
        System.out.println(myQueue.peek());
    }
}

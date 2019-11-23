

import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(3);
        queue.offer(4);
        queue.offer(2);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.println(cur);
        }
    }
}

class Node {
    public int val;
    public Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val) {
        this.val = val;
    }
}
public class MyQueue {
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    public void offer(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }
    public Integer poll() {
        if (head == null) {
            return null;
        }
        Integer ret = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return ret;
    }
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }
}

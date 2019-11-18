class Node {
    int data;
    Node next;

    public Node(int val, Node next) {
        this.data = val;
        this.next = next;
    }

    Node(int val) {
        this.data = val;
    }
}
public class MyQueue2 {
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    public void offer(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }
    public Integer poll() {
        if (head == null) {
            return null;
        }
        Integer ret = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size --;
        return ret;
    }
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }
}

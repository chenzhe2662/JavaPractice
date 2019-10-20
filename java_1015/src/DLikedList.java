
class DLinkedNode {
    public int val;
    DLinkedNode next = null;
    DLinkedNode prev = null;

    public DLinkedNode(int val) {
        this.val = val;
    }
}

public class DLikedList {
    private DLinkedNode head;

    public DLikedList() {
        head = new DLinkedNode(-1);
        head.next = head;
        head.prev = head;
    }

    public void display() {
        System.out.print("正向：[");
        for (DLinkedNode cur = head.next; cur != head; cur = cur.next) {
            System.out.print(cur.val);
            if (cur.next != head) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        System.out.print("反向：[");
        for (DLinkedNode cur = head.prev; cur != head; cur = cur.prev) {
            System.out.print(cur.val);
            if (cur.prev != head) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public void addFirst(int data) {
        DLinkedNode node = new DLinkedNode(data);
        DLinkedNode next = head.next;
        node.next = next;
        next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void addLast(int data) {
        DLinkedNode node = new DLinkedNode(data);
        DLinkedNode prev = head.prev;
        node.next = head;
        head.prev = node;
        prev.next = node;
        node.prev = prev;
    }

    public void addIndex(int index, int data) {
        int len = size();
        if (index < 0 || index > len) {
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == len) {
            addLast(data);
            return;
        }
        DLinkedNode next = getPos(index);
        DLinkedNode prev = next.prev;
        DLinkedNode node = new DLinkedNode(data);
        prev.next = node;
        node.prev = prev;
        next.prev = node;
        node.next = next;
    }

    private DLinkedNode getPos(int pos) {
        DLinkedNode cur = head.next;
        for (int i = 0; i < pos; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean Contains(int key) {
        for (DLinkedNode cur = head.next; cur != head; cur = cur.next) {
            if (cur.val == key) {
                return true;
            }
        }
        return false;
    }

//    public void Remove(int key) {
//        DLinkedNode node = find(key);
//        if (node == null) {
//            return;
//        }
//        DLinkedNode prev = node.prev;
//        DLinkedNode next = node.next;
//        prev.next = next;
//        next.prev = prev;
//    }

    public void removeAll(int key) {
        while(true) {
            DLinkedNode node = find(key);
            if (node == null) {
                return;
            }
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }
    }

    private DLinkedNode find(int key) {
        for (DLinkedNode cur = head.next; cur != head; cur = cur.next) {
            if (cur.val == key) {
                return cur;
            }
        }
        return null;
    }

    private int size() {
        int size = 0;
        for (DLinkedNode cur = head.next; cur != head; cur = cur.next) {
            size++;
        }
        return size;
    }
    public void clear(){
        head.next = head;
        head.prev = head;
    }
}

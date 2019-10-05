
class LinkedNode {
    public int data;
    public LinkedNode next = null;

    public LinkedNode(int data) {
        this.data = data;
    }
}

public class LinkedList {
    private LinkedNode head = null;

    public void display() {
        System.out.print("[");
        for (LinkedNode node = this.head; node != null; node = node.next) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //头插法
    public void addFirst(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = head;
        this.head = node;
    }

    //尾插法
    public void addLast(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if (head == null) {
            head = node;
            return;
        }
        LinkedNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //任意位置插入
    public void addIndex(int index, int elem) {
        LinkedNode node = new LinkedNode(elem);
        int len = size();
        if (index < 0 || index > len) {
            return;
        }
        if (index == 0) {
            addFirst(elem);
            return;
        }
        if (index == len) {
            addLast(elem);
            return;
        }
        LinkedNode prev = getIndexPos(index - 1);
        node.next = prev.next;
        prev.next = node;
    }

    private LinkedNode getIndexPos(int index) {
        LinkedNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //查找
    public boolean contains(int key) {
        for (LinkedNode cur = this.head; cur != null; cur = cur.next) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    //删除
    public void remove(int key) {
        if (head == null) {
            return;
        }
        if (head.data == key) {
            head = head.next;
            return;
        }
        LinkedNode prev = searchPrev(key);
        if (null != prev) {
            prev.next = prev.next.next;
        }

    }

    private LinkedNode searchPrev(int toRemove) {
        if (this.head == null) {
            return null;
        }
        LinkedNode prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == toRemove) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    public void removeAllkey(int key) {
        if (head == null) {
            return;
        }
        LinkedNode prev = head;
        LinkedNode cur = head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.data == key) {
            head = head.next;
        }
    }

    //单链表长度
    public int size() {
        int size = 0;
        for (LinkedNode cur = this.head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public void clear() {
        this.head = null;
    }
}

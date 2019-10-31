class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
    }
}

class DoubleList {

    public Node head;//头
    public Node last;//尾巴

    public DoubleList() {
        this.head = null;
        this.last = null;
    }

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        //1、判断是否是第一次插入
        if (head == null) {
            last = node;
            head = node;
            return;
        }
        //2、不是第一次插入
        head.prev = node;
        node.next = head;
        head = node;
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (last == null) {
            head = node;
            last = node;
            return;
        }
        last.next = node;
        node.prev = last;
        last = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        int len = size();
        if (index < 0 || index > len) {
            throw new IndexOutOfBoundsException("index 不合法");
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == len) {
            addLast(data);
            return true;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node newPrev = cur.prev;
        Node node = new Node(data);
        newPrev.next = node;
        node.prev = newPrev;
        cur.prev = node;
        node.next = cur;
        return false;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove2(int key) {
        if (head.data == key) {
            head = head.next;
            head.prev = null;
            return;
        }
        if (last.data == key) {
            last = last.prev;
            last.next = null;
            return;
        }
        Node cur = find(key);
        if (cur != null) {
            Node newPrev = cur.prev;
            Node newNext = cur.next;
            newPrev.next = newNext;
            newNext.prev = newPrev;
        }
    }

    public void remove1(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                //删除的节点是头节点
                if (cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;
                } else {
                    //不是头节点
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
            }
            cur = cur.next;
        }
    }
    public void Remove(int key) {
        Node node = find(key);
        if (node == null) {
            return;
        }
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }



        public void removeAll(int key) {
            while(true) {
                Node node = find(key);
                if (node == null) {
                    return;
                }
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }
        }

    private Node find(int key) {
        for (Node cur = head.next; cur != head; cur = cur.next) {
            if (cur.data == key) {
                return cur;
            }
        }
        return null;
    }

    //删除所有值为key的节点

    //得到单链表的长度
    public int size() {
        int size = 0;
        for (Node node = this.head; node != null; node = node.next) {
            size++;
        }
        return size;
    }

    public void display() {
        System.out.print("[");
        for (Node node = this.head; node != null; node = node.next) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void clear() {
//        Node cur = this.head;
//        while (cur != null) {
//            Node curNext = cur.next;
//            cur.prev = null;
//            cur.next = null;
//            cur = curNext;
//        }
        this.head = null;
        //this.last = null;
    }

}

class Node {
    public int data;
    public Node next;
    public Node() {

    }
    public Node(int data) {
        this.data = data;
    }
}

 public class LinkedList {
    public Node head;

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next =this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入数据
     public void addIndex(int index, int elem) {
         Node node = new Node(elem);
         int len = size();
         if (index < 0 || index > len) {
             return;
         }
         //1.头插
         if (index == 0) {
             addFirst(elem);
             return;
         }
         Node cur = this.head;
         for (int i = 0; i < index - 1; i++) {
             cur = cur.next;
         }
         Node prev = cur;
         //先连右边后连左边
         node.next = prev.next;
         prev.next = node;
     }
     //删除关键字key
     public void remove(int key) {
         //头节点
         if (head == null) {
             return;
         }
         if (head.data == key) {
             this.head = this.head.next;
             return;
         }
             Node prev = searchPrev(key);
         if(prev != null) {
             prev.next = prev.next.next;
         }
     }
    //删除所有的key
     public void removeAllkey(int key) {
         if (head == null) {
             return;
         }
         Node prev = this.head;
         Node cur = this.head.next;
         while (cur != null) {
             if (cur.data == key) {
                 prev.next = cur.next;
                 cur = prev.next;
             }else {
                 prev = cur;
                 cur = cur.next;
             }
         }
        if (head.data == key) {
            head = head.next;
        }
     }
     //查找关键字的前驱
     private Node searchPrev(int toRemove) {
         Node prev = this.head;
         while (prev.next != null) {
             if (prev.next.data == toRemove) {
                 return prev;
             }
             prev = prev.next;
         }
         return null;
     }
     //打印链表
     public void display() {
         System.out.print("[");
         for (Node node = this.head; node != null;
              node = node.next) {
             System.out.print(node.data);
             if (node.next != null) {
                 System.out.print(", ");
             }
         }
         System.out.println("]");
     }
     //链表长度
     public int size() {
        int size = 0;
        for(Node cur = this.head;cur != null;
            cur = cur.next)  {
            size++;
        }
        return  size;
     }
     //清空链表
     public void clear() {
        this.head = null;
     }
}

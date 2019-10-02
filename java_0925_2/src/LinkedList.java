
class LinkedNode {
    public int data;
    public LinkedNode next = null;

    public LinkedNode(int data) {
        this.data = data;
    }
}

public class LinkedList {
    private LinkedNode head = null;

    //头插法
    public void addFirst(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if(this.head==null){
            this.head=node;
        }
        node.next=this.head.next;
        this.head=node;
    }

    //尾插法
    public void addLast(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if(null==this.head){
            this.head=node;
        }
        LinkedNode cur = this.head;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;

    }

    //任意位置插入
    public void addIndex(int index, int elem) {
        LinkedNode node = new LinkedNode(elem);
        int len = size();
        if (index < 0 || index > len) {
            return;
        }
        //1.头插
        if (index == 0) {
            addFirst(elem);
            return;
        }
        //2.尾插
        if (index == len) {
            addLast(elem);
            return;
        }
        //3.中间
        LinkedNode prev = getIndexPos(index - 1);
        //先连右边后连左边
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

        for (LinkedNode cur = this.head; cur.next != null; cur = cur.next) {
            if (key == cur.data) {
                return true;
            }
        }
        return false;
    }

    //删除
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        //头节点
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //中间
        LinkedNode prev = searchPrev(key);
        prev.next = prev.next.next;
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
        if (this.head == null) {
            return;
        }
        while (this.head.data == key) {
            this.head = this.head.next;
        }
        LinkedNode cur ;
        for(cur=this.head;cur!=null;cur=cur.next){
            if(cur.next!=null&&cur.next.data==key){
                cur.next=cur.next.next;
            }
        }

    }

    //单链表长度
    public int size() {
        int size = 0;
        for (LinkedNode cur = this.head; cur.next != null; cur = cur.next) {
            size++;
        }
        return size;
    }

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

    public void clear() {
        this.head = null;
    }

}


public class Test {
    public static void testAddFirst(){
        DLikedList s = new DLikedList();
        s.addFirst(4);
        s.addFirst(3);
        s.addFirst(2);
        s.addFirst(1);
        System.out.println("头插：");
        s.display();
    }
    public static void testAddLast(){
        DLikedList s = new DLikedList();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addFirst(4);
        System.out.println("尾插：");
        s.display();
    }
    public static void testAddIndex(){
        DLikedList s = new DLikedList();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addFirst(4);
        s.addIndex(0,5);
        s.addIndex(2,6);
        s.addIndex(6,7);

        s.display();
    }
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testAddIndex();
    }
}

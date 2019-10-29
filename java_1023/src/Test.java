
public class Test {

    public static void testAddFirst() {
        LinkedList s = new LinkedList();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addFirst(4);
        s.display();
    }

    public static void testAddLast() {
        LinkedList s = new LinkedList();
        s.addLast(1);
        s.addLast(2);
        s.addLast(3);
        s.addLast(99);
        s.addIndex(0,99);
        s.addIndex(0,199);
        s.addIndex(0,99);
        s.removeAllkey(99);
        s.display();
    }

    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
    }

}
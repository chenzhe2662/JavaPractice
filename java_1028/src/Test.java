public class Test {
    public static void testAddFirst() {
        DoubleList s = new DoubleList();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addFirst(4);
        s.addFirst(5);
        s.display();
    }
    public static void testAddLast() {
        DoubleList s = new DoubleList();
        s.addLast(1);
        s.addLast(2);
        s.addLast(3);
        s.addLast(4);
        s.addLast(5);
        s.addIndex(0,99);
        s.addIndex(6,99);
        s.addIndex(3,100);
        s.remove1(99);
        s.display();

    }
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        DoubleList s = new DoubleList();
        s.clear();
        System.out.println("hhh");
    }
}

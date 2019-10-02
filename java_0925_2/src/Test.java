public class Test {
    public static void TestAddFirst(){
        LinkedList l=new LinkedList();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        l.addFirst(4);
        l.display();

    }
    public static void TestAddLast(){
        LinkedList l=new LinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.display();

    }
    public static void TestaddIndex() {
        LinkedList l=new LinkedList();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        l.addFirst(4);
        l.display();
        l.addIndex(2,5);
        l.display();
    }
    public static void TestRemove() {
        LinkedList l=new LinkedList();
//        l.addFirst(1);
//        l.addFirst(2);
//        l.addFirst(3);
        l.addFirst(4);
        l.display();
        l.remove(4);
        l.display();
    }
    public static void TestAllRemove() {
        LinkedList l=new LinkedList();
        l.addLast(2);
        l.addLast(2);
        l.addLast(2);
        l.addLast(3);
        l.addLast(2);
        l.addLast(2);
        l.addLast(2);
        l.addLast(2);
        l.addLast(3);
        l.addLast(6);
        l.addLast(2);
        l.addLast(2);
        l.addLast(2);
        l.display();
        l.removeAllkey(2);
        l.display();
    }

        public static void main(String[] args) {
//        TestAddFirst();
//        TestAddLast();
//        TestaddIndex();
//        TestRemove();
        TestAllRemove();
    }
}

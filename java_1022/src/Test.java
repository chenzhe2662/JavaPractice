public class Test {
    public static void testAdd() {
        MyArrayList s = new MyArrayList();
        s.add(0, 0);
        s.add(1, 2);
        s.add(2, 3);
        s.add(3, 4);
        s.add(4, 1);
        s.remove(1);
        s.display();

    }


    public static void main(String[] args) {
        // SeqList s = new SeqList();
        testAdd();

//        int a = 10;
//        System.out.println();
    }
}

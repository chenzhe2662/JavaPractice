public class Test {
    public static void testAdd() {
        SeqList s = new SeqList();
        s.add(0, 1);
        s.add(1, 2);
        s.add(2, 3);
        s.add(3, 4);
        s.add(4, 5);
        s.add(2, 6);
        s.display();
        boolean r = s.contains(6);
        System.out.println(r);
        int a=s.search(4);
        System.out.println(a);
        int b=s.getPos(3);
        System.out.println(b);
        s.setPos(4,100);
        s.display();
        s.remove(100);
        s.display();
    }


        public static void main(String[] args) {
       // SeqList s = new SeqList();
        testAdd();

    }
}

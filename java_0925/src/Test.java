public class Test {
    public static void TestAdd(){
        SeqList s = new SeqList();
        s.add(0,1);
        s.add(1,2);
        s.add(2,3);
        s.add(3,4);
        s.add(2,5);
        s.display();
        System.out.println(s.contains(10));
        System.out.println(s.search(5));
    }

        public static void main(String[] args) {
            TestAdd();
    }
}

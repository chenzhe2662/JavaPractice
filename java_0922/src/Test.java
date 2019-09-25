public class Test {
    public static void main(String[] args) {
        Calculator c = new Calculator(4, 5);
        int sum = c.sum();
        System.out.println("sum=" + sum);
        int sub = c.sub();
        System.out.println("sub=" + sub);
        double div = c.div();
        System.out.println("div=" + div);
        int mul = c.mul();
        System.out.println("mul=" + mul);

    }
}

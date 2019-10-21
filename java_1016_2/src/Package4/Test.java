package Package4;

import Package2.Animal;
import Package2.Bird;

public class Test {
    public static void main(String[] args) {
        Bird bird = new Bird("方方");
        feed(bird);
    }
    public static void feed(Animal animal){
        animal.eat("谷子");
    }
}

package Package3;
class Animal {
    protected String name;

    protected Animal(String name) {
        this.name = name;
    }
    protected void eat(String food){
        System.out.println(this.name+"eat"+food);
    }
}
class Cat extends Animal{
    protected Cat(String name) {
        super(name);
    }
}
class Bird extends Animal{
    protected Bird(String name) {
        super(name);
    }
    protected void Fly(){
        System.out.println(this.name+"正在飞！");
    }
}
public class Teat {
    public static void main(String[] args) {
        Cat cat = new Cat("小花");
        cat.eat("猫粮");
        Bird bird = new Bird("圆圆");
        bird.Fly();

    }
}

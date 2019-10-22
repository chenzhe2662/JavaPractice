package Package;

public class Test {
    public static void wolk(IRunning running) {
        System.out.println("我带着伙伴去散步");
        running.run();
    }
    public static void main(String[] args) {
        Cat cat = new Cat("小猫");
        wolk(cat);
        Frog frog = new Frog("小青蛙");
        wolk(frog);
    }
}
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}
interface Ifying {
    void fly();
}

interface IRunning {
    void run();
}

interface ISwimming{
    void swim();
}

class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name+"四条腿跑");
    }
}

class Fish extends Animal implements ISwimming {
    @Override
    public void swim() {
        System.out.println(this.name+"在游泳");
    }

    public Fish(String name) {
        super(name);
    }
}
class Frog extends Animal implements ISwimming,IRunning {
    public Frog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name+"跳着跑");
    }

    @Override
    public void swim() {
        System.out.println(name+ "在蛙泳");
    }
}

class Duck extends Animal implements IRunning,ISwimming,Ifying {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name + "用翅膀在飞");
    }

    @Override
    public void run() {
        System.out.println(name + "用爪子跑");
    }

    @Override
    public void swim() {
        System.out.println(name + "漂在水上游");
    }
}
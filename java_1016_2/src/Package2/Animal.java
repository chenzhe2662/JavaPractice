package Package2;

public class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
    public void eat(String food){
        System.out.println("我是一只小动物");
        System.out.println(this.name+"eat"+food);
    }
}
